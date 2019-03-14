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
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.j;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.i;
import java.util.List;
/* loaded from: classes6.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private VerticalViewPager jgF;
    private VideoPlayFragmentAdapter jgG;
    public int jgI;
    private a jgJ;
    private VideoPlayActivity jgK;
    private TBLottieAnimationView jgL;
    private boolean jgM;
    private int jgN;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int jgH = 0;
    private boolean jgO = true;
    private boolean jgP = false;

    /* loaded from: classes6.dex */
    public interface a {
        void cmt();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.jgK = videoPlayActivity;
        this.mFrom = str;
        this.jgM = Ea(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(d.g.root_layout);
        this.jgF = (VerticalViewPager) videoPlayActivity.findViewById(d.g.video_play_viewpager);
        this.jgG = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.jgG.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.cmI();
            }
        });
        cmH();
        this.jgG.dku = this.mFrom;
        this.jgF.setAdapter(this.jgG);
        this.jgF.setOffscreenPageLimit(1);
        this.jgF.setEventListener(new a.InterfaceC0248a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0248a
            public void atY() {
                VideoPlayFragment AL = VideoPlayView.this.jgG.AL(VideoPlayView.this.jgF.getCurrentItem());
                if (AL != null) {
                    AL.atY();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0248a
            public void w(float f, float f2) {
                VideoPlayFragment AL = VideoPlayView.this.jgG.AL(VideoPlayView.this.jgF.getCurrentItem());
                if (AL != null) {
                    AL.w(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0248a
            public void atZ() {
                VideoPlayFragment AL = VideoPlayView.this.jgG.AL(VideoPlayView.this.jgF.getCurrentItem());
                if (AL != null) {
                    AL.atZ();
                }
            }
        });
        this.jgF.setOnPageChangeListener(this);
        this.jgF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment AL = VideoPlayView.this.jgG.AL(VideoPlayView.this.jgF.getCurrentItem());
                if (AL != null) {
                    return AL.cmF();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.jgL = (TBLottieAnimationView) videoPlayActivity.findViewById(d.g.guide_animation_view);
        this.jgL.setAnimation(d.i.lottie_video_guide);
        this.jgL.setImageAssetsFolder("lottie_video_guide");
        this.jgL.setOnClickListener(this);
        this.jgL.a(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.jgL.isAnimating()) {
                    VideoPlayView.this.aQ(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jgL.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.cmK();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.aWP();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jgN = l.h(TbadkCoreApplication.getInst(), d.e.tbds310);
    }

    public void onPause() {
        aWP();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.jgI = i;
        this.jgG.a(this.mDatas, rect);
        this.jgG.notifyDataSetChanged();
        this.jgF.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.jgG != null) {
            this.jgG.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.jgJ = aVar;
    }

    public void DZ(String str) {
        if (this.jgG != null) {
            this.jgG.mFrom = str;
        }
    }

    public void onDestroy() {
        aWP();
        cmL();
        if (this.jgG != null) {
            this.jgG.cmG();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.jgH = i;
        if (this.jgI != i && this.jgO) {
            this.jgO = false;
        }
        if (!v.T(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.jgJ != null) {
            this.jgJ.cmt();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.jgG != null && this.jgF != null) {
            this.jgG.AM(this.jgF.getCurrentItem());
        }
    }

    public boolean cmF() {
        VideoPlayFragment AL;
        if (cmM()) {
            return true;
        }
        if (this.jgG == null || this.jgF == null || (AL = this.jgG.AL(this.jgF.getCurrentItem())) == null) {
            return false;
        }
        return AL.cmF();
    }

    public void a(int i, int i2, Intent intent) {
        VideoPlayFragment AL;
        if (this.jgG != null && this.jgF != null && (AL = this.jgG.AL(this.jgF.getCurrentItem())) != null) {
            AL.a(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.guide_animation_view) {
            aWP();
        }
    }

    private void cmH() {
        this.jgG.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.j.b
            public void aW(int i, int i2) {
                VideoPlayView.this.cx(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.jgN * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.jgF.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.jgN * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.jgF.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.jgN * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.jgF.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.jgN * (0.92d - f) * 6.0d) : 0;
        }
        this.jgF.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmI() {
        if (this.jgH == this.jgI && this.jgO) {
            qO(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx(int i, int i2) {
        int i3;
        if (!this.jgP && VideoPlayActivityConfig.FROM_DEFAULT.equals(Eb(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.jgO && i.ciT()) {
            qO(true);
            this.jgP = true;
            i.ciU();
        }
    }

    private void cmJ() {
        this.jgF.scrollTo(0, 0);
    }

    private boolean qO(boolean z) {
        if (this.jgL == null) {
            return false;
        }
        if (this.jgM || z) {
            this.jgL.setVisibility(0);
            this.jgL.cu();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWP() {
        if (this.jgL != null) {
            if (this.jgL.isAnimating()) {
                this.jgL.cw();
                cmJ();
            }
            this.jgL.setVisibility(8);
        }
    }

    private boolean Ea(String str) {
        return b.getInstance().getBoolean("video_play_vertical_first_in" + Eb(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmK() {
        if (this.jgM) {
            b.getInstance().putBoolean("video_play_vertical_first_in" + Eb(this.mFrom), false);
            this.jgM = false;
        }
    }

    private String Eb(String str) {
        if (!VideoPlayActivityConfig.FROM_MAINTAB_VIDEO.equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return VideoPlayActivityConfig.FROM_MAINTAB_VIDEO;
    }

    public void Ec(String str) {
        if (this.jgG != null) {
            this.jgG.jgy = str;
        }
    }

    private void cmL() {
        if (this.jgP) {
            i.ciW();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Eb(this.mFrom))) {
            if (this.jgO) {
                i.ciV();
            } else {
                i.ciW();
            }
        }
    }

    private boolean cmM() {
        if (this.jgL == null || !this.jgL.isAnimating()) {
            return false;
        }
        aWP();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        al.f(this.mRootView, d.C0277d.cp_bg_line_d, i);
    }
}
