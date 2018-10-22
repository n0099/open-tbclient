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
    private VerticalViewPager hCR;
    private VideoPlayFragmentAdapter hCS;
    public int hCU;
    private a hCV;
    private VideoPlayActivity hCW;
    private TBLottieAnimationView hCX;
    private boolean hCY;
    private int hCZ;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int hCT = 0;
    private boolean hDa = true;
    private boolean hDb = false;

    /* loaded from: classes4.dex */
    public interface a {
        void aHw();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.hCW = videoPlayActivity;
        this.mFrom = str;
        this.hCY = wy(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(e.g.root_layout);
        this.hCR = (VerticalViewPager) videoPlayActivity.findViewById(e.g.video_play_viewpager);
        this.hCS = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.hCS.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.bKd();
            }
        });
        bKc();
        this.hCS.bQf = this.mFrom;
        this.hCR.setAdapter(this.hCS);
        this.hCR.setOffscreenPageLimit(1);
        this.hCR.setEventListener(new a.InterfaceC0146a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0146a
            public void Sm() {
                VideoPlayFragment vT = VideoPlayView.this.hCS.vT(VideoPlayView.this.hCR.getCurrentItem());
                if (vT != null) {
                    vT.Sm();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0146a
            public void q(float f, float f2) {
                VideoPlayFragment vT = VideoPlayView.this.hCS.vT(VideoPlayView.this.hCR.getCurrentItem());
                if (vT != null) {
                    vT.q(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0146a
            public void Sn() {
                VideoPlayFragment vT = VideoPlayView.this.hCS.vT(VideoPlayView.this.hCR.getCurrentItem());
                if (vT != null) {
                    vT.Sn();
                }
            }
        });
        this.hCR.setOnPageChangeListener(this);
        this.hCR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment vT = VideoPlayView.this.hCS.vT(VideoPlayView.this.hCR.getCurrentItem());
                if (vT != null) {
                    return vT.bKa();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.hCX = (TBLottieAnimationView) videoPlayActivity.findViewById(e.g.guide_animation_view);
        this.hCX.setAnimation(e.i.lottie_video_guide);
        this.hCX.setImageAssetsFolder("lottie_video_guide");
        this.hCX.setOnClickListener(this);
        this.hCX.a(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.hCX.isAnimating()) {
                    VideoPlayView.this.aB(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.hCX.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.bKf();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.auj();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hCZ = l.h(TbadkCoreApplication.getInst(), e.C0175e.tbds310);
    }

    public void onPause() {
        auj();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.hCU = i;
        this.hCS.a(this.mDatas, rect);
        this.hCS.notifyDataSetChanged();
        this.hCR.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.hCS != null) {
            this.hCS.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.hCV = aVar;
    }

    public void wx(String str) {
        if (this.hCS != null) {
            this.hCS.mFrom = str;
        }
    }

    public void onDestroy() {
        auj();
        bKg();
        if (this.hCS != null) {
            this.hCS.bKb();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.hCT = i;
        if (this.hCU != i && this.hDa) {
            this.hDa = false;
        }
        if (!v.J(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.hCV != null) {
            this.hCV.aHw();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.hCS != null && this.hCR != null) {
            this.hCS.vU(this.hCR.getCurrentItem());
        }
    }

    public boolean bKa() {
        VideoPlayFragment vT;
        if (bKh()) {
            return true;
        }
        if (this.hCS == null || this.hCR == null || (vT = this.hCS.vT(this.hCR.getCurrentItem())) == null) {
            return false;
        }
        return vT.bKa();
    }

    public void a(int i, int i2, Intent intent) {
        VideoPlayFragment vT;
        if (this.hCS != null && this.hCR != null && (vT = this.hCS.vT(this.hCR.getCurrentItem())) != null) {
            vT.a(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.guide_animation_view) {
            auj();
        }
    }

    private void bKc() {
        this.hCS.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
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
            i = (int) (this.hCZ * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.hCR.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.hCZ * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.hCR.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.hCZ * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.hCR.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.hCZ * (0.92d - f) * 6.0d) : 0;
        }
        this.hCR.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKd() {
        if (this.hCT == this.hCU && this.hDa) {
            nU(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(int i, int i2) {
        int i3;
        if (!this.hDb && VideoPlayActivityConfig.FROM_DEFAULT.equals(wz(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.hDa && i.bGr()) {
            nU(true);
            this.hDb = true;
            i.bGs();
        }
    }

    private void bKe() {
        this.hCR.scrollTo(0, 0);
    }

    private boolean nU(boolean z) {
        if (this.hCX == null) {
            return false;
        }
        if (this.hCY || z) {
            this.hCX.setVisibility(0);
            this.hCX.cv();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auj() {
        if (this.hCX != null) {
            if (this.hCX.isAnimating()) {
                this.hCX.cy();
                bKe();
            }
            this.hCX.setVisibility(8);
        }
    }

    private boolean wy(String str) {
        return b.getInstance().getBoolean("video_play_vertical_first_in" + wz(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKf() {
        if (this.hCY) {
            b.getInstance().putBoolean("video_play_vertical_first_in" + wz(this.mFrom), false);
            this.hCY = false;
        }
    }

    private String wz(String str) {
        if (!VideoPlayActivityConfig.FROM_MAINTAB_VIDEO.equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return VideoPlayActivityConfig.FROM_MAINTAB_VIDEO;
    }

    public void wA(String str) {
        if (this.hCS != null) {
            this.hCS.hCK = str;
        }
    }

    private void bKg() {
        if (this.hDb) {
            i.bGu();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(wz(this.mFrom))) {
            if (this.hDa) {
                i.bGt();
            } else {
                i.bGu();
            }
        }
    }

    private boolean bKh() {
        if (this.hCX == null || !this.hCX.isAnimating()) {
            return false;
        }
        auj();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        al.e(this.mRootView, e.d.cp_bg_line_d, i);
    }
}
