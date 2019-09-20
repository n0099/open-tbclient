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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.viewpager.VerticalViewPager;
import com.baidu.tbadk.widget.viewpager.a;
import com.baidu.tieba.R;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.j;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.i;
import java.util.List;
/* loaded from: classes6.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private VerticalViewPager jJd;
    private VideoPlayFragmentAdapter jJe;
    public int jJg;
    private a jJh;
    private VideoPlayActivity jJi;
    private TBLottieAnimationView jJj;
    private boolean jJk;
    private int jJl;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int jJf = 0;
    private boolean jJm = true;
    private boolean jJn = false;

    /* loaded from: classes6.dex */
    public interface a {
        void cyu();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.jJi = videoPlayActivity;
        this.mFrom = str;
        this.jJk = GN(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.jJd = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.jJe = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.jJe.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.cyJ();
            }
        });
        cyI();
        this.jJe.dzf = this.mFrom;
        this.jJd.setAdapter(this.jJe);
        this.jJd.setOffscreenPageLimit(1);
        this.jJd.setEventListener(new a.InterfaceC0274a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0274a
            public void aAD() {
                VideoPlayFragment CC = VideoPlayView.this.jJe.CC(VideoPlayView.this.jJd.getCurrentItem());
                if (CC != null) {
                    CC.aAD();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0274a
            public void x(float f, float f2) {
                VideoPlayFragment CC = VideoPlayView.this.jJe.CC(VideoPlayView.this.jJd.getCurrentItem());
                if (CC != null) {
                    CC.x(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0274a
            public void aAE() {
                VideoPlayFragment CC = VideoPlayView.this.jJe.CC(VideoPlayView.this.jJd.getCurrentItem());
                if (CC != null) {
                    CC.aAE();
                }
            }
        });
        this.jJd.setOnPageChangeListener(this);
        this.jJd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment CC = VideoPlayView.this.jJe.CC(VideoPlayView.this.jJd.getCurrentItem());
                if (CC != null) {
                    return CC.cyG();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.jJj = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.jJj.setAnimation(R.raw.lottie_video_guide);
        this.jJj.setImageAssetsFolder("lottie_video_guide");
        this.jJj.setOnClickListener(this);
        this.jJj.a(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.jJj.isAnimating()) {
                    VideoPlayView.this.aW(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jJj.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.cyL();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.bgP();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jJl = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        bgP();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.jJg = i;
        this.jJe.a(this.mDatas, rect);
        this.jJe.notifyDataSetChanged();
        this.jJd.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.jJe != null) {
            this.jJe.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.jJh = aVar;
    }

    public void GM(String str) {
        if (this.jJe != null) {
            this.jJe.mFrom = str;
        }
    }

    public void onDestroy() {
        bgP();
        cyM();
        if (this.jJe != null) {
            this.jJe.cyH();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.jJf = i;
        if (this.jJg != i && this.jJm) {
            this.jJm = false;
        }
        if (!v.aa(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.jJh != null) {
            this.jJh.cyu();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.jJe != null && this.jJd != null) {
            this.jJe.CD(this.jJd.getCurrentItem());
        }
    }

    public boolean cyG() {
        VideoPlayFragment CC;
        if (cyN()) {
            return true;
        }
        if (this.jJe == null || this.jJd == null || (CC = this.jJe.CC(this.jJd.getCurrentItem())) == null) {
            return false;
        }
        return CC.cyG();
    }

    public void a(int i, int i2, Intent intent) {
        VideoPlayFragment CC;
        if (this.jJe != null && this.jJd != null && (CC = this.jJe.CC(this.jJd.getCurrentItem())) != null) {
            CC.a(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            bgP();
        }
    }

    private void cyI() {
        this.jJe.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.j.b
            public void bh(int i, int i2) {
                VideoPlayView.this.cI(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.jJl * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.jJd.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.jJl * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.jJd.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.jJl * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.jJd.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.jJl * (0.92d - f) * 6.0d) : 0;
        }
        this.jJd.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyJ() {
        if (this.jJf == this.jJg && this.jJm) {
            rV(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cI(int i, int i2) {
        int i3;
        if (!this.jJn && VideoPlayActivityConfig.FROM_DEFAULT.equals(GO(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.jJm && i.cuS()) {
            rV(true);
            this.jJn = true;
            i.cuT();
        }
    }

    private void cyK() {
        this.jJd.scrollTo(0, 0);
    }

    private boolean rV(boolean z) {
        if (this.jJj == null) {
            return false;
        }
        if (this.jJk || z) {
            this.jJj.setVisibility(0);
            this.jJj.br();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgP() {
        if (this.jJj != null) {
            if (this.jJj.isAnimating()) {
                this.jJj.bt();
                cyK();
            }
            this.jJj.setVisibility(8);
        }
    }

    private boolean GN(String str) {
        return b.ahU().getBoolean("video_play_vertical_first_in" + GO(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyL() {
        if (this.jJk) {
            b.ahU().putBoolean("video_play_vertical_first_in" + GO(this.mFrom), false);
            this.jJk = false;
        }
    }

    private String GO(String str) {
        if (!VideoPlayActivityConfig.FROM_MAINTAB_VIDEO.equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return VideoPlayActivityConfig.FROM_MAINTAB_VIDEO;
    }

    public void GP(String str) {
        if (this.jJe != null) {
            this.jJe.jIW = str;
        }
    }

    private void cyM() {
        if (this.jJn) {
            i.cuV();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(GO(this.mFrom))) {
            if (this.jJm) {
                i.cuU();
            } else {
                i.cuV();
            }
        }
    }

    private boolean cyN() {
        if (this.jJj == null || !this.jJj.isAnimating()) {
            return false;
        }
        bgP();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        am.h(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
