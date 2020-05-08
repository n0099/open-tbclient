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
    private VerticalViewPager lsV;
    private VideoPlayFragmentAdapter lsW;
    public int lsY;
    private a lsZ;
    private VideoPlayActivity lta;
    private TBLottieAnimationView ltb;
    private boolean ltc;
    private int ltd;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int lsX = 0;
    private boolean lte = true;
    private boolean ltf = false;

    /* loaded from: classes11.dex */
    public interface a {
        void bpe();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.lta = videoPlayActivity;
        this.mFrom = str;
        this.ltc = Mm(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.lsV = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.lsW = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.lsW.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.dej();
            }
        });
        dei();
        this.lsW.mFromPage = this.mFrom;
        this.lsV.setAdapter(this.lsW);
        this.lsV.setOffscreenPageLimit(1);
        this.lsV.setEventListener(new a.InterfaceC0453a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0453a
            public void bdy() {
                VideoPlayFragment EA = VideoPlayView.this.lsW.EA(VideoPlayView.this.lsV.getCurrentItem());
                if (EA != null) {
                    EA.bdy();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0453a
            public void t(float f, float f2) {
                VideoPlayFragment EA = VideoPlayView.this.lsW.EA(VideoPlayView.this.lsV.getCurrentItem());
                if (EA != null) {
                    EA.t(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0453a
            public void bdz() {
                VideoPlayFragment EA = VideoPlayView.this.lsW.EA(VideoPlayView.this.lsV.getCurrentItem());
                if (EA != null) {
                    EA.bdz();
                }
            }
        });
        this.lsV.setOnPageChangeListener(this);
        this.lsV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment EA = VideoPlayView.this.lsW.EA(VideoPlayView.this.lsV.getCurrentItem());
                if (EA != null) {
                    return EA.dee();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.ltb = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.ltb.setAnimation(R.raw.lottie_video_guide);
        this.ltb.setImageAssetsFolder("lottie_video_guide");
        this.ltb.setOnClickListener(this);
        this.ltb.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.ltb.isAnimating()) {
                    VideoPlayView.this.ax(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.ltb.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.del();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.bIL();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ltd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        bIL();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.lsY = i;
        this.lsW.a(this.mDatas, rect);
        this.lsW.notifyDataSetChanged();
        this.lsV.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.lsW != null) {
            this.lsW.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.lsZ = aVar;
    }

    public void Ml(String str) {
        if (this.lsW != null) {
            this.lsW.mFrom = str;
        }
    }

    public void onDestroy() {
        bIL();
        dem();
        if (this.lsW != null) {
            this.lsW.deh();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.lsX = i;
        if (this.lsY != i && this.lte) {
            this.lte = false;
        }
        if (!v.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.lsZ != null) {
            this.lsZ.bpe();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.lsW != null && this.lsV != null) {
            this.lsW.EB(this.lsV.getCurrentItem());
        }
    }

    public boolean dee() {
        VideoPlayFragment EA;
        if (den()) {
            return true;
        }
        if (this.lsW == null || this.lsV == null || (EA = this.lsW.EA(this.lsV.getCurrentItem())) == null) {
            return false;
        }
        return EA.dee();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment EA;
        if (this.lsW != null && this.lsV != null && (EA = this.lsW.EA(this.lsV.getCurrentItem())) != null) {
            EA.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            bIL();
        }
    }

    private void dei() {
        this.lsW.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.j.b
            public void bE(int i, int i2) {
                VideoPlayView.this.cZ(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.ltd * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.lsV.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.ltd * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.lsV.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.ltd * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.lsV.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.ltd * (0.92d - f) * 6.0d) : 0;
        }
        this.lsV.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dej() {
        if (this.lsX == this.lsY && this.lte) {
            uI(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZ(int i, int i2) {
        int i3;
        if (!this.ltf && VideoPlayActivityConfig.FROM_DEFAULT.equals(Mn(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.lte && i.daz()) {
            uI(true);
            this.ltf = true;
            i.daA();
        }
    }

    private void dek() {
        this.lsV.scrollTo(0, 0);
    }

    private boolean uI(boolean z) {
        if (this.ltb == null) {
            return false;
        }
        if (this.ltc || z) {
            this.ltb.setVisibility(0);
            this.ltb.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIL() {
        if (this.ltb != null) {
            if (this.ltb.isAnimating()) {
                this.ltb.pauseAnimation();
                dek();
            }
            this.ltb.setVisibility(8);
        }
    }

    private boolean Mm(String str) {
        return b.aNT().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Mn(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void del() {
        if (this.ltc) {
            b.aNT().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Mn(this.mFrom), false);
            this.ltc = false;
        }
    }

    private String Mn(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void Mo(String str) {
        if (this.lsW != null) {
            this.lsW.lsO = str;
        }
    }

    private void dem() {
        if (this.ltf) {
            i.daC();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Mn(this.mFrom))) {
            if (this.lte) {
                i.daB();
            } else {
                i.daC();
            }
        }
    }

    private boolean den() {
        if (this.ltb == null || !this.ltb.isAnimating()) {
            return false;
        }
        bIL();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
