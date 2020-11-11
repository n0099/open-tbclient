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
    private VerticalViewPager nxL;
    private VideoPlayFragmentAdapter nxM;
    public int nxO;
    private a nxP;
    private VideoPlayActivity nxQ;
    private TBLottieAnimationView nxR;
    private boolean nxS;
    private int nxT;
    public int nxN = 0;
    private boolean nxU = true;
    private boolean nxV = false;

    /* loaded from: classes24.dex */
    public interface a {
        void bTB();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.nxQ = videoPlayActivity;
        this.mFrom = str;
        this.nxS = Un(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.nxL = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.nxM = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.nxM.a(new VideoPlayFragment.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.VideoPlayFragment.a
            public void onStart() {
                VideoPlayView.this.dSi();
            }
        });
        dSh();
        this.nxM.mFromPage = this.mFrom;
        this.nxL.setAdapter(this.nxM);
        this.nxL.setOffscreenPageLimit(1);
        this.nxL.setEventListener(new a.InterfaceC0605a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0605a
            public void bHf() {
                VideoPlayFragment KY = VideoPlayView.this.nxM.KY(VideoPlayView.this.nxL.getCurrentItem());
                if (KY != null) {
                    KY.bHf();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0605a
            public void y(float f, float f2) {
                VideoPlayFragment KY = VideoPlayView.this.nxM.KY(VideoPlayView.this.nxL.getCurrentItem());
                if (KY != null) {
                    KY.y(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0605a
            public void bHg() {
                VideoPlayFragment KY = VideoPlayView.this.nxM.KY(VideoPlayView.this.nxL.getCurrentItem());
                if (KY != null) {
                    KY.bHg();
                }
            }
        });
        this.nxL.setOnPageChangeListener(this);
        this.nxL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment KY = VideoPlayView.this.nxM.KY(VideoPlayView.this.nxL.getCurrentItem());
                if (KY != null) {
                    return KY.dSd();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.nxR = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.nxR.setAnimation(R.raw.lottie_video_guide);
        this.nxR.setImageAssetsFolder("lottie_video_guide");
        this.nxR.setOnClickListener(this);
        this.nxR.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.nxR.isAnimating()) {
                    VideoPlayView.this.aQ(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nxR.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.dSk();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.csl();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nxT = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        csl();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.nxO = i;
        this.nxM.a(this.mDatas, rect);
        this.nxM.notifyDataSetChanged();
        this.nxL.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.nxM != null) {
            this.nxM.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.nxP = aVar;
    }

    public void Um(String str) {
        if (this.nxM != null) {
            this.nxM.mFrom = str;
        }
    }

    public void onDestroy() {
        csl();
        dSl();
        if (this.nxM != null) {
            this.nxM.dSg();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.nxN = i;
        if (this.nxO != i && this.nxU) {
            this.nxU = false;
        }
        if (!y.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.nxP != null) {
            this.nxP.bTB();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.nxM != null && this.nxL != null) {
            this.nxM.KZ(this.nxL.getCurrentItem());
        }
    }

    public boolean dSd() {
        VideoPlayFragment KY;
        if (dSm()) {
            return true;
        }
        if (this.nxM == null || this.nxL == null || (KY = this.nxM.KY(this.nxL.getCurrentItem())) == null) {
            return false;
        }
        return KY.dSd();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment KY;
        if (this.nxM != null && this.nxL != null && (KY = this.nxM.KY(this.nxL.getCurrentItem())) != null) {
            KY.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            csl();
        }
    }

    private void dSh() {
        this.nxM.a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.f.b
            public void ce(int i, int i2) {
                VideoPlayView.this.dC(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.nxT * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.nxL.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.nxT * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.nxL.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.nxT * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.nxL.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.nxT * (0.92d - f) * 6.0d) : 0;
        }
        this.nxL.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSi() {
        if (this.nxN == this.nxO && this.nxU) {
            yj(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dC(int i, int i2) {
        int i3;
        if (!this.nxV && VideoPlayActivityConfig.FROM_DEFAULT.equals(Uo(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.nxU && i.dOy()) {
            yj(true);
            this.nxV = true;
            i.dOz();
        }
    }

    private void dSj() {
        this.nxL.scrollTo(0, 0);
    }

    private boolean yj(boolean z) {
        if (this.nxR == null) {
            return false;
        }
        if (this.nxS || z) {
            this.nxR.setVisibility(0);
            this.nxR.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csl() {
        if (this.nxR != null) {
            if (this.nxR.isAnimating()) {
                this.nxR.pauseAnimation();
                dSj();
            }
            this.nxR.setVisibility(8);
        }
    }

    private boolean Un(String str) {
        return b.bqh().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Uo(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSk() {
        if (this.nxS) {
            b.bqh().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Uo(this.mFrom), false);
            this.nxS = false;
        }
    }

    private String Uo(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void Up(String str) {
        if (this.nxM != null) {
            this.nxM.nxE = str;
        }
    }

    private void dSl() {
        if (this.nxV) {
            i.dOB();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Uo(this.mFrom))) {
            if (this.nxU) {
                i.dOA();
            } else {
                i.dOB();
            }
        }
    }

    private boolean dSm() {
        if (this.nxR == null || !this.nxR.isAnimating()) {
            return false;
        }
        csl();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
