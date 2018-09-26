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
/* loaded from: classes2.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private VerticalViewPager hvE;
    private VideoPlayFragmentAdapter hvF;
    public int hvH;
    private a hvI;
    private VideoPlayActivity hvJ;
    private TBLottieAnimationView hvK;
    private boolean hvL;
    private int hvM;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int hvG = 0;
    private boolean hvN = true;
    private boolean hvO = false;

    /* loaded from: classes2.dex */
    public interface a {
        void aEe();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.hvJ = videoPlayActivity;
        this.mFrom = str;
        this.hvL = vX(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(e.g.root_layout);
        this.hvE = (VerticalViewPager) videoPlayActivity.findViewById(e.g.video_play_viewpager);
        this.hvF = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.hvF.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.bGR();
            }
        });
        bGQ();
        this.hvF.bHC = this.mFrom;
        this.hvE.setAdapter(this.hvF);
        this.hvE.setOffscreenPageLimit(1);
        this.hvE.setEventListener(new a.InterfaceC0122a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0122a
            public void Qs() {
                VideoPlayFragment vw = VideoPlayView.this.hvF.vw(VideoPlayView.this.hvE.getCurrentItem());
                if (vw != null) {
                    vw.Qs();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0122a
            public void q(float f, float f2) {
                VideoPlayFragment vw = VideoPlayView.this.hvF.vw(VideoPlayView.this.hvE.getCurrentItem());
                if (vw != null) {
                    vw.q(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0122a
            public void Qt() {
                VideoPlayFragment vw = VideoPlayView.this.hvF.vw(VideoPlayView.this.hvE.getCurrentItem());
                if (vw != null) {
                    vw.Qt();
                }
            }
        });
        this.hvE.setOnPageChangeListener(this);
        this.hvE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment vw = VideoPlayView.this.hvF.vw(VideoPlayView.this.hvE.getCurrentItem());
                if (vw != null) {
                    return vw.bGO();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.hvK = (TBLottieAnimationView) videoPlayActivity.findViewById(e.g.guide_animation_view);
        this.hvK.setAnimation(e.i.lottie_video_guide);
        this.hvK.setImageAssetsFolder("lottie_video_guide");
        this.hvK.setOnClickListener(this);
        this.hvK.a(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.hvK.isAnimating()) {
                    VideoPlayView.this.aA(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.hvK.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.bGT();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.aqM();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hvM = l.h(TbadkCoreApplication.getInst(), e.C0141e.tbds310);
    }

    public void onPause() {
        aqM();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.hvH = i;
        this.hvF.a(this.mDatas, rect);
        this.hvF.notifyDataSetChanged();
        this.hvE.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.hvF != null) {
            this.hvF.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.hvI = aVar;
    }

    public void vW(String str) {
        if (this.hvF != null) {
            this.hvF.mFrom = str;
        }
    }

    public void onDestroy() {
        aqM();
        bGU();
        if (this.hvF != null) {
            this.hvF.bGP();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.hvG = i;
        if (this.hvH != i && this.hvN) {
            this.hvN = false;
        }
        if (!v.z(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.hvI != null) {
            this.hvI.aEe();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.hvF != null && this.hvE != null) {
            this.hvF.vx(this.hvE.getCurrentItem());
        }
    }

    public boolean bGO() {
        VideoPlayFragment vw;
        if (bGV()) {
            return true;
        }
        if (this.hvF == null || this.hvE == null || (vw = this.hvF.vw(this.hvE.getCurrentItem())) == null) {
            return false;
        }
        return vw.bGO();
    }

    public void a(int i, int i2, Intent intent) {
        VideoPlayFragment vw;
        if (this.hvF != null && this.hvE != null && (vw = this.hvF.vw(this.hvE.getCurrentItem())) != null) {
            vw.a(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.guide_animation_view) {
            aqM();
        }
    }

    private void bGQ() {
        this.hvF.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.j.b
            public void bz(int i, int i2) {
                VideoPlayView.this.bU(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.hvM * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.hvE.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.hvM * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.hvE.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.hvM * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.hvE.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.hvM * (0.92d - f) * 6.0d) : 0;
        }
        this.hvE.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGR() {
        if (this.hvG == this.hvH && this.hvN) {
            nE(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bU(int i, int i2) {
        int i3;
        if (!this.hvO && VideoPlayActivityConfig.FROM_DEFAULT.equals(vY(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.hvN && i.bDd()) {
            nE(true);
            this.hvO = true;
            i.bDe();
        }
    }

    private void bGS() {
        this.hvE.scrollTo(0, 0);
    }

    private boolean nE(boolean z) {
        if (this.hvK == null) {
            return false;
        }
        if (this.hvL || z) {
            this.hvK.setVisibility(0);
            this.hvK.ce();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqM() {
        if (this.hvK != null) {
            if (this.hvK.isAnimating()) {
                this.hvK.cg();
                bGS();
            }
            this.hvK.setVisibility(8);
        }
    }

    private boolean vX(String str) {
        return b.getInstance().getBoolean("video_play_vertical_first_in" + vY(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGT() {
        if (this.hvL) {
            b.getInstance().putBoolean("video_play_vertical_first_in" + vY(this.mFrom), false);
            this.hvL = false;
        }
    }

    private String vY(String str) {
        if (!VideoPlayActivityConfig.FROM_MAINTAB_VIDEO.equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return VideoPlayActivityConfig.FROM_MAINTAB_VIDEO;
    }

    public void vZ(String str) {
        if (this.hvF != null) {
            this.hvF.hvx = str;
        }
    }

    private void bGU() {
        if (this.hvO) {
            i.bDg();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(vY(this.mFrom))) {
            if (this.hvN) {
                i.bDf();
            } else {
                i.bDg();
            }
        }
    }

    private boolean bGV() {
        if (this.hvK == null || !this.hvK.isAnimating()) {
            return false;
        }
        aqM();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        al.e(this.mRootView, e.d.cp_bg_line_d, i);
    }
}
