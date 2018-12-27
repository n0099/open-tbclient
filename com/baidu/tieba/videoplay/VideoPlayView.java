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
    private VerticalViewPager hOX;
    private VideoPlayFragmentAdapter hOY;
    public int hPa;
    private a hPb;
    private VideoPlayActivity hPc;
    private TBLottieAnimationView hPd;
    private boolean hPe;
    private int hPf;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int hOZ = 0;
    private boolean hPg = true;
    private boolean hPh = false;

    /* loaded from: classes4.dex */
    public interface a {
        void aJv();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.hPc = videoPlayActivity;
        this.mFrom = str;
        this.hPe = xj(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(e.g.root_layout);
        this.hOX = (VerticalViewPager) videoPlayActivity.findViewById(e.g.video_play_viewpager);
        this.hOY = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.hOY.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.bMw();
            }
        });
        bMv();
        this.hOY.bUJ = this.mFrom;
        this.hOX.setAdapter(this.hOY);
        this.hOX.setOffscreenPageLimit(1);
        this.hOX.setEventListener(new a.InterfaceC0180a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
            public void TD() {
                VideoPlayFragment wW = VideoPlayView.this.hOY.wW(VideoPlayView.this.hOX.getCurrentItem());
                if (wW != null) {
                    wW.TD();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
            public void t(float f, float f2) {
                VideoPlayFragment wW = VideoPlayView.this.hOY.wW(VideoPlayView.this.hOX.getCurrentItem());
                if (wW != null) {
                    wW.t(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
            public void TE() {
                VideoPlayFragment wW = VideoPlayView.this.hOY.wW(VideoPlayView.this.hOX.getCurrentItem());
                if (wW != null) {
                    wW.TE();
                }
            }
        });
        this.hOX.setOnPageChangeListener(this);
        this.hOX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment wW = VideoPlayView.this.hOY.wW(VideoPlayView.this.hOX.getCurrentItem());
                if (wW != null) {
                    return wW.bMt();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.hPd = (TBLottieAnimationView) videoPlayActivity.findViewById(e.g.guide_animation_view);
        this.hPd.setAnimation(e.i.lottie_video_guide);
        this.hPd.setImageAssetsFolder("lottie_video_guide");
        this.hPd.setOnClickListener(this);
        this.hPd.a(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.hPd.isAnimating()) {
                    VideoPlayView.this.aD(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.hPd.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.bMy();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.blO();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hPf = l.h(TbadkCoreApplication.getInst(), e.C0210e.tbds310);
    }

    public void onPause() {
        blO();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.hPa = i;
        this.hOY.a(this.mDatas, rect);
        this.hOY.notifyDataSetChanged();
        this.hOX.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.hOY != null) {
            this.hOY.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.hPb = aVar;
    }

    public void xi(String str) {
        if (this.hOY != null) {
            this.hOY.mFrom = str;
        }
    }

    public void onDestroy() {
        blO();
        bMz();
        if (this.hOY != null) {
            this.hOY.bMu();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.hOZ = i;
        if (this.hPa != i && this.hPg) {
            this.hPg = false;
        }
        if (!v.I(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.hPb != null) {
            this.hPb.aJv();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.hOY != null && this.hOX != null) {
            this.hOY.wX(this.hOX.getCurrentItem());
        }
    }

    public boolean bMt() {
        VideoPlayFragment wW;
        if (bMA()) {
            return true;
        }
        if (this.hOY == null || this.hOX == null || (wW = this.hOY.wW(this.hOX.getCurrentItem())) == null) {
            return false;
        }
        return wW.bMt();
    }

    public void a(int i, int i2, Intent intent) {
        VideoPlayFragment wW;
        if (this.hOY != null && this.hOX != null && (wW = this.hOY.wW(this.hOX.getCurrentItem())) != null) {
            wW.a(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.guide_animation_view) {
            blO();
        }
    }

    private void bMv() {
        this.hOY.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.j.b
            public void bD(int i, int i2) {
                VideoPlayView.this.ca(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.hPf * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.hOX.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.hPf * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.hOX.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.hPf * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.hOX.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.hPf * (0.92d - f) * 6.0d) : 0;
        }
        this.hOX.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMw() {
        if (this.hOZ == this.hPa && this.hPg) {
            on(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(int i, int i2) {
        int i3;
        if (!this.hPh && VideoPlayActivityConfig.FROM_DEFAULT.equals(xk(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.hPg && i.bIK()) {
            on(true);
            this.hPh = true;
            i.bIL();
        }
    }

    private void bMx() {
        this.hOX.scrollTo(0, 0);
    }

    private boolean on(boolean z) {
        if (this.hPd == null) {
            return false;
        }
        if (this.hPe || z) {
            this.hPd.setVisibility(0);
            this.hPd.cv();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blO() {
        if (this.hPd != null) {
            if (this.hPd.isAnimating()) {
                this.hPd.cx();
                bMx();
            }
            this.hPd.setVisibility(8);
        }
    }

    private boolean xj(String str) {
        return b.getInstance().getBoolean("video_play_vertical_first_in" + xk(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMy() {
        if (this.hPe) {
            b.getInstance().putBoolean("video_play_vertical_first_in" + xk(this.mFrom), false);
            this.hPe = false;
        }
    }

    private String xk(String str) {
        if (!VideoPlayActivityConfig.FROM_MAINTAB_VIDEO.equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return VideoPlayActivityConfig.FROM_MAINTAB_VIDEO;
    }

    public void xl(String str) {
        if (this.hOY != null) {
            this.hOY.ebX = str;
        }
    }

    private void bMz() {
        if (this.hPh) {
            i.bIN();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(xk(this.mFrom))) {
            if (this.hPg) {
                i.bIM();
            } else {
                i.bIN();
            }
        }
    }

    private boolean bMA() {
        if (this.hPd == null || !this.hPd.isAnimating()) {
            return false;
        }
        blO();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        al.e(this.mRootView, e.d.cp_bg_line_d, i);
    }
}
