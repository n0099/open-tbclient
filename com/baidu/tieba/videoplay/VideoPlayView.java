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
    private VerticalViewPager lsR;
    private VideoPlayFragmentAdapter lsS;
    public int lsU;
    private a lsV;
    private VideoPlayActivity lsW;
    private TBLottieAnimationView lsX;
    private boolean lsY;
    private int lsZ;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int lsT = 0;
    private boolean lta = true;
    private boolean ltb = false;

    /* loaded from: classes11.dex */
    public interface a {
        void bpg();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.lsW = videoPlayActivity;
        this.mFrom = str;
        this.lsY = Mj(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.lsR = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.lsS = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.lsS.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.dem();
            }
        });
        del();
        this.lsS.mFromPage = this.mFrom;
        this.lsR.setAdapter(this.lsS);
        this.lsR.setOffscreenPageLimit(1);
        this.lsR.setEventListener(new a.InterfaceC0432a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0432a
            public void bdA() {
                VideoPlayFragment EA = VideoPlayView.this.lsS.EA(VideoPlayView.this.lsR.getCurrentItem());
                if (EA != null) {
                    EA.bdA();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0432a
            public void t(float f, float f2) {
                VideoPlayFragment EA = VideoPlayView.this.lsS.EA(VideoPlayView.this.lsR.getCurrentItem());
                if (EA != null) {
                    EA.t(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0432a
            public void bdB() {
                VideoPlayFragment EA = VideoPlayView.this.lsS.EA(VideoPlayView.this.lsR.getCurrentItem());
                if (EA != null) {
                    EA.bdB();
                }
            }
        });
        this.lsR.setOnPageChangeListener(this);
        this.lsR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment EA = VideoPlayView.this.lsS.EA(VideoPlayView.this.lsR.getCurrentItem());
                if (EA != null) {
                    return EA.deh();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.lsX = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.lsX.setAnimation(R.raw.lottie_video_guide);
        this.lsX.setImageAssetsFolder("lottie_video_guide");
        this.lsX.setOnClickListener(this);
        this.lsX.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.lsX.isAnimating()) {
                    VideoPlayView.this.ax(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.lsX.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.deo();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.bIN();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lsZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        bIN();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.lsU = i;
        this.lsS.a(this.mDatas, rect);
        this.lsS.notifyDataSetChanged();
        this.lsR.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.lsS != null) {
            this.lsS.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.lsV = aVar;
    }

    public void Mi(String str) {
        if (this.lsS != null) {
            this.lsS.mFrom = str;
        }
    }

    public void onDestroy() {
        bIN();
        dep();
        if (this.lsS != null) {
            this.lsS.dek();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.lsT = i;
        if (this.lsU != i && this.lta) {
            this.lta = false;
        }
        if (!v.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.lsV != null) {
            this.lsV.bpg();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.lsS != null && this.lsR != null) {
            this.lsS.EB(this.lsR.getCurrentItem());
        }
    }

    public boolean deh() {
        VideoPlayFragment EA;
        if (deq()) {
            return true;
        }
        if (this.lsS == null || this.lsR == null || (EA = this.lsS.EA(this.lsR.getCurrentItem())) == null) {
            return false;
        }
        return EA.deh();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment EA;
        if (this.lsS != null && this.lsR != null && (EA = this.lsS.EA(this.lsR.getCurrentItem())) != null) {
            EA.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            bIN();
        }
    }

    private void del() {
        this.lsS.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
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
            i = (int) (this.lsZ * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.lsR.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.lsZ * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.lsR.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.lsZ * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.lsR.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.lsZ * (0.92d - f) * 6.0d) : 0;
        }
        this.lsR.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dem() {
        if (this.lsT == this.lsU && this.lta) {
            uI(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZ(int i, int i2) {
        int i3;
        if (!this.ltb && VideoPlayActivityConfig.FROM_DEFAULT.equals(Mk(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.lta && i.daC()) {
            uI(true);
            this.ltb = true;
            i.daD();
        }
    }

    private void den() {
        this.lsR.scrollTo(0, 0);
    }

    private boolean uI(boolean z) {
        if (this.lsX == null) {
            return false;
        }
        if (this.lsY || z) {
            this.lsX.setVisibility(0);
            this.lsX.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIN() {
        if (this.lsX != null) {
            if (this.lsX.isAnimating()) {
                this.lsX.pauseAnimation();
                den();
            }
            this.lsX.setVisibility(8);
        }
    }

    private boolean Mj(String str) {
        return b.aNV().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Mk(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deo() {
        if (this.lsY) {
            b.aNV().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Mk(this.mFrom), false);
            this.lsY = false;
        }
    }

    private String Mk(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void Ml(String str) {
        if (this.lsS != null) {
            this.lsS.lsK = str;
        }
    }

    private void dep() {
        if (this.ltb) {
            i.daF();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Mk(this.mFrom))) {
            if (this.lta) {
                i.daE();
            } else {
                i.daF();
            }
        }
    }

    private boolean deq() {
        if (this.lsX == null || !this.lsX.isAnimating()) {
            return false;
        }
        bIN();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
