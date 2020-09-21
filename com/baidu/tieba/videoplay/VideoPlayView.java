package com.baidu.tieba.videoplay;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.viewpager.VerticalViewPager;
import com.baidu.tbadk.widget.viewpager.a;
import com.baidu.tieba.R;
import com.baidu.tieba.play.f;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.i;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import java.util.List;
/* loaded from: classes23.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private List<VideoItemData> mDatas;
    private String mFrom;
    private VerticalViewPager mPK;
    private VideoPlayFragmentAdapter mPL;
    public int mPN;
    private a mPO;
    private VideoPlayActivity mPP;
    private TBLottieAnimationView mPQ;
    private boolean mPR;
    private int mPS;
    private View mRootView;
    public int mPM = 0;
    private boolean mPT = true;
    private boolean mPU = false;

    /* loaded from: classes23.dex */
    public interface a {
        void bLN();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.mPP = videoPlayActivity;
        this.mFrom = str;
        this.mPR = SJ(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.mPK = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.mPL = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.mPL.a(new VideoPlayFragment.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.VideoPlayFragment.a
            public void onStart() {
                VideoPlayView.this.dIM();
            }
        });
        dIL();
        this.mPL.mFromPage = this.mFrom;
        this.mPK.setAdapter(this.mPL);
        this.mPK.setOffscreenPageLimit(1);
        this.mPK.setEventListener(new a.InterfaceC0562a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0562a
            public void bAd() {
                VideoPlayFragment JN = VideoPlayView.this.mPL.JN(VideoPlayView.this.mPK.getCurrentItem());
                if (JN != null) {
                    JN.bAd();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0562a
            public void y(float f, float f2) {
                VideoPlayFragment JN = VideoPlayView.this.mPL.JN(VideoPlayView.this.mPK.getCurrentItem());
                if (JN != null) {
                    JN.y(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0562a
            public void bAe() {
                VideoPlayFragment JN = VideoPlayView.this.mPL.JN(VideoPlayView.this.mPK.getCurrentItem());
                if (JN != null) {
                    JN.bAe();
                }
            }
        });
        this.mPK.setOnPageChangeListener(this);
        this.mPK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment JN = VideoPlayView.this.mPL.JN(VideoPlayView.this.mPK.getCurrentItem());
                if (JN != null) {
                    return JN.dIH();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.mPQ = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.mPQ.setAnimation(R.raw.lottie_video_guide);
        this.mPQ.setImageAssetsFolder("lottie_video_guide");
        this.mPQ.setOnClickListener(this);
        this.mPQ.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.mPQ.isAnimating()) {
                    VideoPlayView.this.aG(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.mPQ.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.dIO();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.cjh();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mPS = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        cjh();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.mPN = i;
        this.mPL.a(this.mDatas, rect);
        this.mPL.notifyDataSetChanged();
        this.mPK.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.mPL != null) {
            this.mPL.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.mPO = aVar;
    }

    public void SI(String str) {
        if (this.mPL != null) {
            this.mPL.mFrom = str;
        }
    }

    public void onDestroy() {
        cjh();
        dIP();
        if (this.mPL != null) {
            this.mPL.dIK();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mPM = i;
        if (this.mPN != i && this.mPT) {
            this.mPT = false;
        }
        if (!y.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.mPO != null) {
            this.mPO.bLN();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.mPL != null && this.mPK != null) {
            this.mPL.JO(this.mPK.getCurrentItem());
        }
    }

    public boolean dIH() {
        VideoPlayFragment JN;
        if (dIQ()) {
            return true;
        }
        if (this.mPL == null || this.mPK == null || (JN = this.mPL.JN(this.mPK.getCurrentItem())) == null) {
            return false;
        }
        return JN.dIH();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment JN;
        if (this.mPL != null && this.mPK != null && (JN = this.mPL.JN(this.mPK.getCurrentItem())) != null) {
            JN.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            cjh();
        }
    }

    private void dIL() {
        this.mPL.a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.f.b
            public void ca(int i, int i2) {
                VideoPlayView.this.dy(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.mPS * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.mPK.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.mPS * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.mPK.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.mPS * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.mPK.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.mPS * (0.92d - f) * 6.0d) : 0;
        }
        this.mPK.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIM() {
        if (this.mPM == this.mPN && this.mPT) {
            xc(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dy(int i, int i2) {
        int i3;
        if (!this.mPU && VideoPlayActivityConfig.FROM_DEFAULT.equals(SK(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.mPT && i.dFc()) {
            xc(true);
            this.mPU = true;
            i.dFd();
        }
    }

    private void dIN() {
        this.mPK.scrollTo(0, 0);
    }

    private boolean xc(boolean z) {
        if (this.mPQ == null) {
            return false;
        }
        if (this.mPR || z) {
            this.mPQ.setVisibility(0);
            this.mPQ.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjh() {
        if (this.mPQ != null) {
            if (this.mPQ.isAnimating()) {
                this.mPQ.pauseAnimation();
                dIN();
            }
            this.mPQ.setVisibility(8);
        }
    }

    private boolean SJ(String str) {
        return b.bjf().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + SK(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIO() {
        if (this.mPR) {
            b.bjf().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + SK(this.mFrom), false);
            this.mPR = false;
        }
    }

    private String SK(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void SL(String str) {
        if (this.mPL != null) {
            this.mPL.mPD = str;
        }
    }

    private void dIP() {
        if (this.mPU) {
            i.dFf();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(SK(this.mFrom))) {
            if (this.mPT) {
                i.dFe();
            } else {
                i.dFf();
            }
        }
    }

    private boolean dIQ() {
        if (this.mPQ == null || !this.mPQ.isAnimating()) {
            return false;
        }
        cjh();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
