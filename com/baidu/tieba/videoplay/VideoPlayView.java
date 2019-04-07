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
    private boolean jgA;
    private int jgB;
    private VerticalViewPager jgt;
    private VideoPlayFragmentAdapter jgu;
    public int jgw;
    private a jgx;
    private VideoPlayActivity jgy;
    private TBLottieAnimationView jgz;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int jgv = 0;
    private boolean jgC = true;
    private boolean jgD = false;

    /* loaded from: classes6.dex */
    public interface a {
        void cmr();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.jgy = videoPlayActivity;
        this.mFrom = str;
        this.jgA = DZ(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(d.g.root_layout);
        this.jgt = (VerticalViewPager) videoPlayActivity.findViewById(d.g.video_play_viewpager);
        this.jgu = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.jgu.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.cmG();
            }
        });
        cmF();
        this.jgu.dkx = this.mFrom;
        this.jgt.setAdapter(this.jgu);
        this.jgt.setOffscreenPageLimit(1);
        this.jgt.setEventListener(new a.InterfaceC0248a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0248a
            public void atV() {
                VideoPlayFragment AH = VideoPlayView.this.jgu.AH(VideoPlayView.this.jgt.getCurrentItem());
                if (AH != null) {
                    AH.atV();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0248a
            public void w(float f, float f2) {
                VideoPlayFragment AH = VideoPlayView.this.jgu.AH(VideoPlayView.this.jgt.getCurrentItem());
                if (AH != null) {
                    AH.w(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0248a
            public void atW() {
                VideoPlayFragment AH = VideoPlayView.this.jgu.AH(VideoPlayView.this.jgt.getCurrentItem());
                if (AH != null) {
                    AH.atW();
                }
            }
        });
        this.jgt.setOnPageChangeListener(this);
        this.jgt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment AH = VideoPlayView.this.jgu.AH(VideoPlayView.this.jgt.getCurrentItem());
                if (AH != null) {
                    return AH.cmD();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.jgz = (TBLottieAnimationView) videoPlayActivity.findViewById(d.g.guide_animation_view);
        this.jgz.setAnimation(d.i.lottie_video_guide);
        this.jgz.setImageAssetsFolder("lottie_video_guide");
        this.jgz.setOnClickListener(this);
        this.jgz.a(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.jgz.isAnimating()) {
                    VideoPlayView.this.aQ(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jgz.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
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
        this.jgB = l.h(TbadkCoreApplication.getInst(), d.e.tbds310);
    }

    public void onPause() {
        aWN();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.jgw = i;
        this.jgu.a(this.mDatas, rect);
        this.jgu.notifyDataSetChanged();
        this.jgt.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.jgu != null) {
            this.jgu.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.jgx = aVar;
    }

    public void DY(String str) {
        if (this.jgu != null) {
            this.jgu.mFrom = str;
        }
    }

    public void onDestroy() {
        aWN();
        cmJ();
        if (this.jgu != null) {
            this.jgu.cmE();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.jgv = i;
        if (this.jgw != i && this.jgC) {
            this.jgC = false;
        }
        if (!v.T(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.jgx != null) {
            this.jgx.cmr();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.jgu != null && this.jgt != null) {
            this.jgu.AI(this.jgt.getCurrentItem());
        }
    }

    public boolean cmD() {
        VideoPlayFragment AH;
        if (cmK()) {
            return true;
        }
        if (this.jgu == null || this.jgt == null || (AH = this.jgu.AH(this.jgt.getCurrentItem())) == null) {
            return false;
        }
        return AH.cmD();
    }

    public void a(int i, int i2, Intent intent) {
        VideoPlayFragment AH;
        if (this.jgu != null && this.jgt != null && (AH = this.jgu.AH(this.jgt.getCurrentItem())) != null) {
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
        this.jgu.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
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
            i = (int) (this.jgB * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.jgt.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.jgB * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.jgt.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.jgB * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.jgt.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.jgB * (0.92d - f) * 6.0d) : 0;
        }
        this.jgt.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmG() {
        if (this.jgv == this.jgw && this.jgC) {
            qO(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx(int i, int i2) {
        int i3;
        if (!this.jgD && VideoPlayActivityConfig.FROM_DEFAULT.equals(Ea(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.jgC && i.ciR()) {
            qO(true);
            this.jgD = true;
            i.ciS();
        }
    }

    private void cmH() {
        this.jgt.scrollTo(0, 0);
    }

    private boolean qO(boolean z) {
        if (this.jgz == null) {
            return false;
        }
        if (this.jgA || z) {
            this.jgz.setVisibility(0);
            this.jgz.cu();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWN() {
        if (this.jgz != null) {
            if (this.jgz.isAnimating()) {
                this.jgz.cw();
                cmH();
            }
            this.jgz.setVisibility(8);
        }
    }

    private boolean DZ(String str) {
        return b.getInstance().getBoolean("video_play_vertical_first_in" + Ea(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmI() {
        if (this.jgA) {
            b.getInstance().putBoolean("video_play_vertical_first_in" + Ea(this.mFrom), false);
            this.jgA = false;
        }
    }

    private String Ea(String str) {
        if (!VideoPlayActivityConfig.FROM_MAINTAB_VIDEO.equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return VideoPlayActivityConfig.FROM_MAINTAB_VIDEO;
    }

    public void Eb(String str) {
        if (this.jgu != null) {
            this.jgu.jgm = str;
        }
    }

    private void cmJ() {
        if (this.jgD) {
            i.ciU();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Ea(this.mFrom))) {
            if (this.jgC) {
                i.ciT();
            } else {
                i.ciU();
            }
        }
    }

    private boolean cmK() {
        if (this.jgz == null || !this.jgz.isAnimating()) {
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
