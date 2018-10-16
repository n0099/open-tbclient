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
    private VerticalViewPager hCQ;
    private VideoPlayFragmentAdapter hCR;
    public int hCT;
    private a hCU;
    private VideoPlayActivity hCV;
    private TBLottieAnimationView hCW;
    private boolean hCX;
    private int hCY;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int hCS = 0;
    private boolean hCZ = true;
    private boolean hDa = false;

    /* loaded from: classes4.dex */
    public interface a {
        void aHw();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.hCV = videoPlayActivity;
        this.mFrom = str;
        this.hCX = wy(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(e.g.root_layout);
        this.hCQ = (VerticalViewPager) videoPlayActivity.findViewById(e.g.video_play_viewpager);
        this.hCR = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.hCR.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.bKd();
            }
        });
        bKc();
        this.hCR.bQf = this.mFrom;
        this.hCQ.setAdapter(this.hCR);
        this.hCQ.setOffscreenPageLimit(1);
        this.hCQ.setEventListener(new a.InterfaceC0146a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0146a
            public void Sm() {
                VideoPlayFragment vT = VideoPlayView.this.hCR.vT(VideoPlayView.this.hCQ.getCurrentItem());
                if (vT != null) {
                    vT.Sm();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0146a
            public void q(float f, float f2) {
                VideoPlayFragment vT = VideoPlayView.this.hCR.vT(VideoPlayView.this.hCQ.getCurrentItem());
                if (vT != null) {
                    vT.q(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0146a
            public void Sn() {
                VideoPlayFragment vT = VideoPlayView.this.hCR.vT(VideoPlayView.this.hCQ.getCurrentItem());
                if (vT != null) {
                    vT.Sn();
                }
            }
        });
        this.hCQ.setOnPageChangeListener(this);
        this.hCQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment vT = VideoPlayView.this.hCR.vT(VideoPlayView.this.hCQ.getCurrentItem());
                if (vT != null) {
                    return vT.bKa();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.hCW = (TBLottieAnimationView) videoPlayActivity.findViewById(e.g.guide_animation_view);
        this.hCW.setAnimation(e.i.lottie_video_guide);
        this.hCW.setImageAssetsFolder("lottie_video_guide");
        this.hCW.setOnClickListener(this);
        this.hCW.a(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.hCW.isAnimating()) {
                    VideoPlayView.this.aB(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.hCW.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.bKf();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.aui();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hCY = l.h(TbadkCoreApplication.getInst(), e.C0175e.tbds310);
    }

    public void onPause() {
        aui();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.hCT = i;
        this.hCR.a(this.mDatas, rect);
        this.hCR.notifyDataSetChanged();
        this.hCQ.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.hCR != null) {
            this.hCR.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.hCU = aVar;
    }

    public void wx(String str) {
        if (this.hCR != null) {
            this.hCR.mFrom = str;
        }
    }

    public void onDestroy() {
        aui();
        bKg();
        if (this.hCR != null) {
            this.hCR.bKb();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.hCS = i;
        if (this.hCT != i && this.hCZ) {
            this.hCZ = false;
        }
        if (!v.J(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.hCU != null) {
            this.hCU.aHw();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.hCR != null && this.hCQ != null) {
            this.hCR.vU(this.hCQ.getCurrentItem());
        }
    }

    public boolean bKa() {
        VideoPlayFragment vT;
        if (bKh()) {
            return true;
        }
        if (this.hCR == null || this.hCQ == null || (vT = this.hCR.vT(this.hCQ.getCurrentItem())) == null) {
            return false;
        }
        return vT.bKa();
    }

    public void a(int i, int i2, Intent intent) {
        VideoPlayFragment vT;
        if (this.hCR != null && this.hCQ != null && (vT = this.hCR.vT(this.hCQ.getCurrentItem())) != null) {
            vT.a(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.guide_animation_view) {
            aui();
        }
    }

    private void bKc() {
        this.hCR.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.j.b
            public void bC(int i, int i2) {
                VideoPlayView.this.bX(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.hCY * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.hCQ.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.hCY * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.hCQ.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.hCY * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.hCQ.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.hCY * (0.92d - f) * 6.0d) : 0;
        }
        this.hCQ.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKd() {
        if (this.hCS == this.hCT && this.hCZ) {
            nU(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(int i, int i2) {
        int i3;
        if (!this.hDa && VideoPlayActivityConfig.FROM_DEFAULT.equals(wz(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.hCZ && i.bGr()) {
            nU(true);
            this.hDa = true;
            i.bGs();
        }
    }

    private void bKe() {
        this.hCQ.scrollTo(0, 0);
    }

    private boolean nU(boolean z) {
        if (this.hCW == null) {
            return false;
        }
        if (this.hCX || z) {
            this.hCW.setVisibility(0);
            this.hCW.cv();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aui() {
        if (this.hCW != null) {
            if (this.hCW.isAnimating()) {
                this.hCW.cy();
                bKe();
            }
            this.hCW.setVisibility(8);
        }
    }

    private boolean wy(String str) {
        return b.getInstance().getBoolean("video_play_vertical_first_in" + wz(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKf() {
        if (this.hCX) {
            b.getInstance().putBoolean("video_play_vertical_first_in" + wz(this.mFrom), false);
            this.hCX = false;
        }
    }

    private String wz(String str) {
        if (!VideoPlayActivityConfig.FROM_MAINTAB_VIDEO.equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return VideoPlayActivityConfig.FROM_MAINTAB_VIDEO;
    }

    public void wA(String str) {
        if (this.hCR != null) {
            this.hCR.hCJ = str;
        }
    }

    private void bKg() {
        if (this.hDa) {
            i.bGu();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(wz(this.mFrom))) {
            if (this.hCZ) {
                i.bGt();
            } else {
                i.bGu();
            }
        }
    }

    private boolean bKh() {
        if (this.hCW == null || !this.hCW.isAnimating()) {
            return false;
        }
        aui();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        al.e(this.mRootView, e.d.cp_bg_line_d, i);
    }
}
