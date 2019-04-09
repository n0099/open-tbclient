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
    private TBLottieAnimationView jgA;
    private boolean jgB;
    private int jgC;
    private VerticalViewPager jgu;
    private VideoPlayFragmentAdapter jgv;
    public int jgx;
    private a jgy;
    private VideoPlayActivity jgz;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int jgw = 0;
    private boolean jgD = true;
    private boolean jgE = false;

    /* loaded from: classes6.dex */
    public interface a {
        void cmr();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.jgz = videoPlayActivity;
        this.mFrom = str;
        this.jgB = DZ(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(d.g.root_layout);
        this.jgu = (VerticalViewPager) videoPlayActivity.findViewById(d.g.video_play_viewpager);
        this.jgv = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.jgv.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.cmG();
            }
        });
        cmF();
        this.jgv.dky = this.mFrom;
        this.jgu.setAdapter(this.jgv);
        this.jgu.setOffscreenPageLimit(1);
        this.jgu.setEventListener(new a.InterfaceC0248a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0248a
            public void atV() {
                VideoPlayFragment AH = VideoPlayView.this.jgv.AH(VideoPlayView.this.jgu.getCurrentItem());
                if (AH != null) {
                    AH.atV();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0248a
            public void w(float f, float f2) {
                VideoPlayFragment AH = VideoPlayView.this.jgv.AH(VideoPlayView.this.jgu.getCurrentItem());
                if (AH != null) {
                    AH.w(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0248a
            public void atW() {
                VideoPlayFragment AH = VideoPlayView.this.jgv.AH(VideoPlayView.this.jgu.getCurrentItem());
                if (AH != null) {
                    AH.atW();
                }
            }
        });
        this.jgu.setOnPageChangeListener(this);
        this.jgu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment AH = VideoPlayView.this.jgv.AH(VideoPlayView.this.jgu.getCurrentItem());
                if (AH != null) {
                    return AH.cmD();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.jgA = (TBLottieAnimationView) videoPlayActivity.findViewById(d.g.guide_animation_view);
        this.jgA.setAnimation(d.i.lottie_video_guide);
        this.jgA.setImageAssetsFolder("lottie_video_guide");
        this.jgA.setOnClickListener(this);
        this.jgA.a(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.jgA.isAnimating()) {
                    VideoPlayView.this.aQ(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jgA.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.cmI();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.aWN();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jgC = l.h(TbadkCoreApplication.getInst(), d.e.tbds310);
    }

    public void onPause() {
        aWN();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.jgx = i;
        this.jgv.a(this.mDatas, rect);
        this.jgv.notifyDataSetChanged();
        this.jgu.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.jgv != null) {
            this.jgv.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.jgy = aVar;
    }

    public void DY(String str) {
        if (this.jgv != null) {
            this.jgv.mFrom = str;
        }
    }

    public void onDestroy() {
        aWN();
        cmJ();
        if (this.jgv != null) {
            this.jgv.cmE();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.jgw = i;
        if (this.jgx != i && this.jgD) {
            this.jgD = false;
        }
        if (!v.T(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.jgy != null) {
            this.jgy.cmr();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.jgv != null && this.jgu != null) {
            this.jgv.AI(this.jgu.getCurrentItem());
        }
    }

    public boolean cmD() {
        VideoPlayFragment AH;
        if (cmK()) {
            return true;
        }
        if (this.jgv == null || this.jgu == null || (AH = this.jgv.AH(this.jgu.getCurrentItem())) == null) {
            return false;
        }
        return AH.cmD();
    }

    public void a(int i, int i2, Intent intent) {
        VideoPlayFragment AH;
        if (this.jgv != null && this.jgu != null && (AH = this.jgv.AH(this.jgu.getCurrentItem())) != null) {
            AH.a(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.guide_animation_view) {
            aWN();
        }
    }

    private void cmF() {
        this.jgv.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
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
            i = (int) (this.jgC * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.jgu.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.jgC * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.jgu.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.jgC * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.jgu.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.jgC * (0.92d - f) * 6.0d) : 0;
        }
        this.jgu.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmG() {
        if (this.jgw == this.jgx && this.jgD) {
            qO(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx(int i, int i2) {
        int i3;
        if (!this.jgE && VideoPlayActivityConfig.FROM_DEFAULT.equals(Ea(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.jgD && i.ciR()) {
            qO(true);
            this.jgE = true;
            i.ciS();
        }
    }

    private void cmH() {
        this.jgu.scrollTo(0, 0);
    }

    private boolean qO(boolean z) {
        if (this.jgA == null) {
            return false;
        }
        if (this.jgB || z) {
            this.jgA.setVisibility(0);
            this.jgA.cu();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWN() {
        if (this.jgA != null) {
            if (this.jgA.isAnimating()) {
                this.jgA.cw();
                cmH();
            }
            this.jgA.setVisibility(8);
        }
    }

    private boolean DZ(String str) {
        return b.getInstance().getBoolean("video_play_vertical_first_in" + Ea(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmI() {
        if (this.jgB) {
            b.getInstance().putBoolean("video_play_vertical_first_in" + Ea(this.mFrom), false);
            this.jgB = false;
        }
    }

    private String Ea(String str) {
        if (!VideoPlayActivityConfig.FROM_MAINTAB_VIDEO.equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return VideoPlayActivityConfig.FROM_MAINTAB_VIDEO;
    }

    public void Eb(String str) {
        if (this.jgv != null) {
            this.jgv.jgn = str;
        }
    }

    private void cmJ() {
        if (this.jgE) {
            i.ciU();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Ea(this.mFrom))) {
            if (this.jgD) {
                i.ciT();
            } else {
                i.ciU();
            }
        }
    }

    private boolean cmK() {
        if (this.jgA == null || !this.jgA.isAnimating()) {
            return false;
        }
        aWN();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        al.f(this.mRootView, d.C0277d.cp_bg_line_d, i);
    }
}
