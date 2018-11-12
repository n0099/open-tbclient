package com.baidu.tieba.videoplay;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.viewpager.VerticalViewPager;
import com.baidu.tbadk.widget.viewpager.a;
import com.baidu.tieba.e;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.j;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.i;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private VerticalViewPager hEB;
    private VideoPlayFragmentAdapter hEC;
    public int hEE;
    private a hEF;
    private VideoPlayActivity hEG;
    private TBLottieAnimationView hEH;
    private boolean hEI;
    private int hEJ;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int hED = 0;
    private boolean hEK = true;
    private boolean hEL = false;

    /* loaded from: classes4.dex */
    public interface a {
        void aGU();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.hEG = videoPlayActivity;
        this.mFrom = str;
        this.hEI = wD(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(e.g.root_layout);
        this.hEB = (VerticalViewPager) videoPlayActivity.findViewById(e.g.video_play_viewpager);
        this.hEC = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.hEC.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.bJC();
            }
        });
        bJB();
        this.hEC.bQP = this.mFrom;
        this.hEB.setAdapter(this.hEC);
        this.hEB.setOffscreenPageLimit(1);
        this.hEB.setEventListener(new a.InterfaceC0170a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0170a
            public void Sv() {
                VideoPlayFragment wm = VideoPlayView.this.hEC.wm(VideoPlayView.this.hEB.getCurrentItem());
                if (wm != null) {
                    wm.Sv();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0170a
            public void t(float f, float f2) {
                VideoPlayFragment wm = VideoPlayView.this.hEC.wm(VideoPlayView.this.hEB.getCurrentItem());
                if (wm != null) {
                    wm.t(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0170a
            public void Sw() {
                VideoPlayFragment wm = VideoPlayView.this.hEC.wm(VideoPlayView.this.hEB.getCurrentItem());
                if (wm != null) {
                    wm.Sw();
                }
            }
        });
        this.hEB.setOnPageChangeListener(this);
        this.hEB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment wm = VideoPlayView.this.hEC.wm(VideoPlayView.this.hEB.getCurrentItem());
                if (wm != null) {
                    return wm.bJz();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.hEH = (TBLottieAnimationView) videoPlayActivity.findViewById(e.g.guide_animation_view);
        this.hEH.setAnimation(e.i.lottie_video_guide);
        this.hEH.setImageAssetsFolder("lottie_video_guide");
        this.hEH.setOnClickListener(this);
        this.hEH.a(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.hEH.isAnimating()) {
                    VideoPlayView.this.aD(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.hEH.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.bJE();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.atH();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hEJ = l.h(TbadkCoreApplication.getInst(), e.C0200e.tbds310);
    }

    public void onPause() {
        atH();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.hEE = i;
        this.hEC.a(this.mDatas, rect);
        this.hEC.notifyDataSetChanged();
        this.hEB.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.hEC != null) {
            this.hEC.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.hEF = aVar;
    }

    public void wC(String str) {
        if (this.hEC != null) {
            this.hEC.mFrom = str;
        }
    }

    public void onDestroy() {
        atH();
        bJF();
        if (this.hEC != null) {
            this.hEC.bJA();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.hED = i;
        if (this.hEE != i && this.hEK) {
            this.hEK = false;
        }
        if (!v.I(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.hEF != null) {
            this.hEF.aGU();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.hEC != null && this.hEB != null) {
            this.hEC.wn(this.hEB.getCurrentItem());
        }
    }

    public boolean bJz() {
        VideoPlayFragment wm;
        if (bJG()) {
            return true;
        }
        if (this.hEC == null || this.hEB == null || (wm = this.hEC.wm(this.hEB.getCurrentItem())) == null) {
            return false;
        }
        return wm.bJz();
    }

    public void a(int i, int i2, Intent intent) {
        VideoPlayFragment wm;
        if (this.hEC != null && this.hEB != null && (wm = this.hEC.wm(this.hEB.getCurrentItem())) != null) {
            wm.a(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.guide_animation_view) {
            atH();
        }
    }

    private void bJB() {
        this.hEC.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.j.b
            public void bE(int i, int i2) {
                VideoPlayView.this.cb(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.hEJ * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.hEB.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.hEJ * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.hEB.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.hEJ * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.hEB.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.hEJ * (0.92d - f) * 6.0d) : 0;
        }
        this.hEB.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJC() {
        if (this.hED == this.hEE && this.hEK) {
            oi(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb(int i, int i2) {
        int i3;
        if (!this.hEL && VideoPlayActivityConfig.FROM_DEFAULT.equals(wE(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.hEK && i.bFQ()) {
            oi(true);
            this.hEL = true;
            i.bFR();
        }
    }

    private void bJD() {
        this.hEB.scrollTo(0, 0);
    }

    private boolean oi(boolean z) {
        if (this.hEH == null) {
            return false;
        }
        if (this.hEI || z) {
            this.hEH.setVisibility(0);
            this.hEH.cv();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atH() {
        if (this.hEH != null) {
            if (this.hEH.isAnimating()) {
                this.hEH.cx();
                bJD();
            }
            this.hEH.setVisibility(8);
        }
    }

    private boolean wD(String str) {
        return b.getInstance().getBoolean("video_play_vertical_first_in" + wE(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJE() {
        if (this.hEI) {
            b.getInstance().putBoolean("video_play_vertical_first_in" + wE(this.mFrom), false);
            this.hEI = false;
        }
    }

    private String wE(String str) {
        if (!VideoPlayActivityConfig.FROM_MAINTAB_VIDEO.equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return VideoPlayActivityConfig.FROM_MAINTAB_VIDEO;
    }

    public void wF(String str) {
        if (this.hEC != null) {
            this.hEC.hEu = str;
        }
    }

    private void bJF() {
        if (this.hEL) {
            i.bFT();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(wE(this.mFrom))) {
            if (this.hEK) {
                i.bFS();
            } else {
                i.bFT();
            }
        }
    }

    private boolean bJG() {
        if (this.hEH == null || !this.hEH.isAnimating()) {
            return false;
        }
        atH();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        al.e(this.mRootView, e.d.cp_bg_line_d, i);
    }
}
