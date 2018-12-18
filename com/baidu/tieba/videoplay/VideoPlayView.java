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
    private VerticalViewPager hLM;
    private VideoPlayFragmentAdapter hLN;
    public int hLP;
    private a hLQ;
    private VideoPlayActivity hLR;
    private TBLottieAnimationView hLS;
    private boolean hLT;
    private int hLU;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int hLO = 0;
    private boolean hLV = true;
    private boolean hLW = false;

    /* loaded from: classes4.dex */
    public interface a {
        void aIG();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.hLR = videoPlayActivity;
        this.mFrom = str;
        this.hLT = xg(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(e.g.root_layout);
        this.hLM = (VerticalViewPager) videoPlayActivity.findViewById(e.g.video_play_viewpager);
        this.hLN = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.hLN.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.bLG();
            }
        });
        bLF();
        this.hLN.bUG = this.mFrom;
        this.hLM.setAdapter(this.hLN);
        this.hLM.setOffscreenPageLimit(1);
        this.hLM.setEventListener(new a.InterfaceC0180a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
            public void TB() {
                VideoPlayFragment wJ = VideoPlayView.this.hLN.wJ(VideoPlayView.this.hLM.getCurrentItem());
                if (wJ != null) {
                    wJ.TB();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
            public void t(float f, float f2) {
                VideoPlayFragment wJ = VideoPlayView.this.hLN.wJ(VideoPlayView.this.hLM.getCurrentItem());
                if (wJ != null) {
                    wJ.t(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
            public void TC() {
                VideoPlayFragment wJ = VideoPlayView.this.hLN.wJ(VideoPlayView.this.hLM.getCurrentItem());
                if (wJ != null) {
                    wJ.TC();
                }
            }
        });
        this.hLM.setOnPageChangeListener(this);
        this.hLM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment wJ = VideoPlayView.this.hLN.wJ(VideoPlayView.this.hLM.getCurrentItem());
                if (wJ != null) {
                    return wJ.bLD();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.hLS = (TBLottieAnimationView) videoPlayActivity.findViewById(e.g.guide_animation_view);
        this.hLS.setAnimation(e.i.lottie_video_guide);
        this.hLS.setImageAssetsFolder("lottie_video_guide");
        this.hLS.setOnClickListener(this);
        this.hLS.a(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.hLS.isAnimating()) {
                    VideoPlayView.this.aD(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.hLS.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.bLI();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.blc();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hLU = l.h(TbadkCoreApplication.getInst(), e.C0210e.tbds310);
    }

    public void onPause() {
        blc();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.hLP = i;
        this.hLN.a(this.mDatas, rect);
        this.hLN.notifyDataSetChanged();
        this.hLM.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.hLN != null) {
            this.hLN.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.hLQ = aVar;
    }

    public void xf(String str) {
        if (this.hLN != null) {
            this.hLN.mFrom = str;
        }
    }

    public void onDestroy() {
        blc();
        bLJ();
        if (this.hLN != null) {
            this.hLN.bLE();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.hLO = i;
        if (this.hLP != i && this.hLV) {
            this.hLV = false;
        }
        if (!v.I(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.hLQ != null) {
            this.hLQ.aIG();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.hLN != null && this.hLM != null) {
            this.hLN.wK(this.hLM.getCurrentItem());
        }
    }

    public boolean bLD() {
        VideoPlayFragment wJ;
        if (bLK()) {
            return true;
        }
        if (this.hLN == null || this.hLM == null || (wJ = this.hLN.wJ(this.hLM.getCurrentItem())) == null) {
            return false;
        }
        return wJ.bLD();
    }

    public void a(int i, int i2, Intent intent) {
        VideoPlayFragment wJ;
        if (this.hLN != null && this.hLM != null && (wJ = this.hLN.wJ(this.hLM.getCurrentItem())) != null) {
            wJ.a(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.guide_animation_view) {
            blc();
        }
    }

    private void bLF() {
        this.hLN.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.j.b
            public void bC(int i, int i2) {
                VideoPlayView.this.bZ(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.hLU * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.hLM.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.hLU * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.hLM.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.hLU * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.hLM.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.hLU * (0.92d - f) * 6.0d) : 0;
        }
        this.hLM.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLG() {
        if (this.hLO == this.hLP && this.hLV) {
            ok(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(int i, int i2) {
        int i3;
        if (!this.hLW && VideoPlayActivityConfig.FROM_DEFAULT.equals(xh(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.hLV && i.bHU()) {
            ok(true);
            this.hLW = true;
            i.bHV();
        }
    }

    private void bLH() {
        this.hLM.scrollTo(0, 0);
    }

    private boolean ok(boolean z) {
        if (this.hLS == null) {
            return false;
        }
        if (this.hLT || z) {
            this.hLS.setVisibility(0);
            this.hLS.cv();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blc() {
        if (this.hLS != null) {
            if (this.hLS.isAnimating()) {
                this.hLS.cx();
                bLH();
            }
            this.hLS.setVisibility(8);
        }
    }

    private boolean xg(String str) {
        return b.getInstance().getBoolean("video_play_vertical_first_in" + xh(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLI() {
        if (this.hLT) {
            b.getInstance().putBoolean("video_play_vertical_first_in" + xh(this.mFrom), false);
            this.hLT = false;
        }
    }

    private String xh(String str) {
        if (!VideoPlayActivityConfig.FROM_MAINTAB_VIDEO.equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return VideoPlayActivityConfig.FROM_MAINTAB_VIDEO;
    }

    public void xi(String str) {
        if (this.hLN != null) {
            this.hLN.dZg = str;
        }
    }

    private void bLJ() {
        if (this.hLW) {
            i.bHX();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(xh(this.mFrom))) {
            if (this.hLV) {
                i.bHW();
            } else {
                i.bHX();
            }
        }
    }

    private boolean bLK() {
        if (this.hLS == null || !this.hLS.isAnimating()) {
            return false;
        }
        blc();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        al.e(this.mRootView, e.d.cp_bg_line_d, i);
    }
}
