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
/* loaded from: classes24.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    private VerticalViewPager nrQ;
    private VideoPlayFragmentAdapter nrR;
    public int nrT;
    private a nrU;
    private VideoPlayActivity nrV;
    private TBLottieAnimationView nrW;
    private boolean nrX;
    private int nrY;
    public int nrS = 0;
    private boolean nrZ = true;
    private boolean nsa = false;

    /* loaded from: classes24.dex */
    public interface a {
        void bRc();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.nrV = videoPlayActivity;
        this.mFrom = str;
        this.nrX = TW(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.nrQ = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.nrR = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.nrR.a(new VideoPlayFragment.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.VideoPlayFragment.a
            public void onStart() {
                VideoPlayView.this.dPG();
            }
        });
        dPF();
        this.nrR.mFromPage = this.mFrom;
        this.nrQ.setAdapter(this.nrR);
        this.nrQ.setOffscreenPageLimit(1);
        this.nrQ.setEventListener(new a.InterfaceC0593a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0593a
            public void bEG() {
                VideoPlayFragment KL = VideoPlayView.this.nrR.KL(VideoPlayView.this.nrQ.getCurrentItem());
                if (KL != null) {
                    KL.bEG();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0593a
            public void y(float f, float f2) {
                VideoPlayFragment KL = VideoPlayView.this.nrR.KL(VideoPlayView.this.nrQ.getCurrentItem());
                if (KL != null) {
                    KL.y(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0593a
            public void bEH() {
                VideoPlayFragment KL = VideoPlayView.this.nrR.KL(VideoPlayView.this.nrQ.getCurrentItem());
                if (KL != null) {
                    KL.bEH();
                }
            }
        });
        this.nrQ.setOnPageChangeListener(this);
        this.nrQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment KL = VideoPlayView.this.nrR.KL(VideoPlayView.this.nrQ.getCurrentItem());
                if (KL != null) {
                    return KL.dPB();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.nrW = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.nrW.setAnimation(R.raw.lottie_video_guide);
        this.nrW.setImageAssetsFolder("lottie_video_guide");
        this.nrW.setOnClickListener(this);
        this.nrW.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.nrW.isAnimating()) {
                    VideoPlayView.this.aO(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nrW.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.dPI();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.cpK();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nrY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        cpK();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.nrT = i;
        this.nrR.a(this.mDatas, rect);
        this.nrR.notifyDataSetChanged();
        this.nrQ.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.nrR != null) {
            this.nrR.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.nrU = aVar;
    }

    public void TV(String str) {
        if (this.nrR != null) {
            this.nrR.mFrom = str;
        }
    }

    public void onDestroy() {
        cpK();
        dPJ();
        if (this.nrR != null) {
            this.nrR.dPE();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.nrS = i;
        if (this.nrT != i && this.nrZ) {
            this.nrZ = false;
        }
        if (!y.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.nrU != null) {
            this.nrU.bRc();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.nrR != null && this.nrQ != null) {
            this.nrR.KM(this.nrQ.getCurrentItem());
        }
    }

    public boolean dPB() {
        VideoPlayFragment KL;
        if (dPK()) {
            return true;
        }
        if (this.nrR == null || this.nrQ == null || (KL = this.nrR.KL(this.nrQ.getCurrentItem())) == null) {
            return false;
        }
        return KL.dPB();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment KL;
        if (this.nrR != null && this.nrQ != null && (KL = this.nrR.KL(this.nrQ.getCurrentItem())) != null) {
            KL.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            cpK();
        }
    }

    private void dPF() {
        this.nrR.a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.f.b
            public void cc(int i, int i2) {
                VideoPlayView.this.dA(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.nrY * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.nrQ.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.nrY * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.nrQ.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.nrY * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.nrQ.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.nrY * (0.92d - f) * 6.0d) : 0;
        }
        this.nrQ.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPG() {
        if (this.nrS == this.nrT && this.nrZ) {
            ya(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dA(int i, int i2) {
        int i3;
        if (!this.nsa && VideoPlayActivityConfig.FROM_DEFAULT.equals(TX(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.nrZ && i.dLW()) {
            ya(true);
            this.nsa = true;
            i.dLX();
        }
    }

    private void dPH() {
        this.nrQ.scrollTo(0, 0);
    }

    private boolean ya(boolean z) {
        if (this.nrW == null) {
            return false;
        }
        if (this.nrX || z) {
            this.nrW.setVisibility(0);
            this.nrW.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpK() {
        if (this.nrW != null) {
            if (this.nrW.isAnimating()) {
                this.nrW.pauseAnimation();
                dPH();
            }
            this.nrW.setVisibility(8);
        }
    }

    private boolean TW(String str) {
        return b.bnH().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + TX(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dPI() {
        if (this.nrX) {
            b.bnH().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + TX(this.mFrom), false);
            this.nrX = false;
        }
    }

    private String TX(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void TY(String str) {
        if (this.nrR != null) {
            this.nrR.nrJ = str;
        }
    }

    private void dPJ() {
        if (this.nsa) {
            i.dLZ();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(TX(this.mFrom))) {
            if (this.nrZ) {
                i.dLY();
            } else {
                i.dLZ();
            }
        }
    }

    private boolean dPK() {
        if (this.nrW == null || !this.nrW.isAnimating()) {
            return false;
        }
        cpK();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
