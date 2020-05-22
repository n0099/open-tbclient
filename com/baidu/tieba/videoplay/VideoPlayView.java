package com.baidu.tieba.videoplay;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
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
/* loaded from: classes11.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private VideoPlayFragmentAdapter lLA;
    public int lLC;
    private a lLD;
    private VideoPlayActivity lLE;
    private TBLottieAnimationView lLF;
    private boolean lLG;
    private int lLH;
    private VerticalViewPager lLz;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int lLB = 0;
    private boolean lLI = true;
    private boolean lLJ = false;

    /* loaded from: classes11.dex */
    public interface a {
        void buV();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.lLE = videoPlayActivity;
        this.mFrom = str;
        this.lLG = NZ(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.lLz = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.lLA = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.lLA.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.dlz();
            }
        });
        dly();
        this.lLA.mFromPage = this.mFrom;
        this.lLz.setAdapter(this.lLA);
        this.lLz.setOffscreenPageLimit(1);
        this.lLz.setEventListener(new a.InterfaceC0500a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0500a
            public void bjJ() {
                VideoPlayFragment Fl = VideoPlayView.this.lLA.Fl(VideoPlayView.this.lLz.getCurrentItem());
                if (Fl != null) {
                    Fl.bjJ();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0500a
            public void t(float f, float f2) {
                VideoPlayFragment Fl = VideoPlayView.this.lLA.Fl(VideoPlayView.this.lLz.getCurrentItem());
                if (Fl != null) {
                    Fl.t(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0500a
            public void bjK() {
                VideoPlayFragment Fl = VideoPlayView.this.lLA.Fl(VideoPlayView.this.lLz.getCurrentItem());
                if (Fl != null) {
                    Fl.bjK();
                }
            }
        });
        this.lLz.setOnPageChangeListener(this);
        this.lLz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment Fl = VideoPlayView.this.lLA.Fl(VideoPlayView.this.lLz.getCurrentItem());
                if (Fl != null) {
                    return Fl.dlu();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.lLF = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.lLF.setAnimation(R.raw.lottie_video_guide);
        this.lLF.setImageAssetsFolder("lottie_video_guide");
        this.lLF.setOnClickListener(this);
        this.lLF.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.lLF.isAnimating()) {
                    VideoPlayView.this.aw(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.lLF.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.dlB();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.bPf();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lLH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        bPf();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.lLC = i;
        this.lLA.a(this.mDatas, rect);
        this.lLA.notifyDataSetChanged();
        this.lLz.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.lLA != null) {
            this.lLA.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.lLD = aVar;
    }

    public void NY(String str) {
        if (this.lLA != null) {
            this.lLA.mFrom = str;
        }
    }

    public void onDestroy() {
        bPf();
        dlC();
        if (this.lLA != null) {
            this.lLA.dlx();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.lLB = i;
        if (this.lLC != i && this.lLI) {
            this.lLI = false;
        }
        if (!v.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.lLD != null) {
            this.lLD.buV();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.lLA != null && this.lLz != null) {
            this.lLA.Fm(this.lLz.getCurrentItem());
        }
    }

    public boolean dlu() {
        VideoPlayFragment Fl;
        if (dlD()) {
            return true;
        }
        if (this.lLA == null || this.lLz == null || (Fl = this.lLA.Fl(this.lLz.getCurrentItem())) == null) {
            return false;
        }
        return Fl.dlu();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment Fl;
        if (this.lLA != null && this.lLz != null && (Fl = this.lLA.Fl(this.lLz.getCurrentItem())) != null) {
            Fl.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            bPf();
        }
    }

    private void dly() {
        this.lLA.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.j.b
            public void bI(int i, int i2) {
                VideoPlayView.this.de(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.lLH * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.lLz.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.lLH * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.lLz.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.lLH * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.lLz.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.lLH * (0.92d - f) * 6.0d) : 0;
        }
        this.lLz.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlz() {
        if (this.lLB == this.lLC && this.lLI) {
            vg(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(int i, int i2) {
        int i3;
        if (!this.lLJ && VideoPlayActivityConfig.FROM_DEFAULT.equals(Oa(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.lLI && i.dhO()) {
            vg(true);
            this.lLJ = true;
            i.dhP();
        }
    }

    private void dlA() {
        this.lLz.scrollTo(0, 0);
    }

    private boolean vg(boolean z) {
        if (this.lLF == null) {
            return false;
        }
        if (this.lLG || z) {
            this.lLF.setVisibility(0);
            this.lLF.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPf() {
        if (this.lLF != null) {
            if (this.lLF.isAnimating()) {
                this.lLF.pauseAnimation();
                dlA();
            }
            this.lLF.setVisibility(8);
        }
    }

    private boolean NZ(String str) {
        return b.aTX().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Oa(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlB() {
        if (this.lLG) {
            b.aTX().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Oa(this.mFrom), false);
            this.lLG = false;
        }
    }

    private String Oa(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void Ob(String str) {
        if (this.lLA != null) {
            this.lLA.lLs = str;
        }
    }

    private void dlC() {
        if (this.lLJ) {
            i.dhR();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Oa(this.mFrom))) {
            if (this.lLI) {
                i.dhQ();
            } else {
                i.dhR();
            }
        }
    }

    private boolean dlD() {
        if (this.lLF == null || !this.lLF.isAnimating()) {
            return false;
        }
        bPf();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
