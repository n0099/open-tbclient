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
    private VerticalViewPager lMH;
    private VideoPlayFragmentAdapter lMI;
    public int lMK;
    private a lML;
    private VideoPlayActivity lMM;
    private TBLottieAnimationView lMN;
    private boolean lMO;
    private int lMP;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int lMJ = 0;
    private boolean lMQ = true;
    private boolean lMR = false;

    /* loaded from: classes11.dex */
    public interface a {
        void buX();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.lMM = videoPlayActivity;
        this.mFrom = str;
        this.lMO = Oa(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.lMH = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.lMI = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.lMI.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.dlO();
            }
        });
        dlN();
        this.lMI.mFromPage = this.mFrom;
        this.lMH.setAdapter(this.lMI);
        this.lMH.setOffscreenPageLimit(1);
        this.lMH.setEventListener(new a.InterfaceC0500a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0500a
            public void bjL() {
                VideoPlayFragment Fn = VideoPlayView.this.lMI.Fn(VideoPlayView.this.lMH.getCurrentItem());
                if (Fn != null) {
                    Fn.bjL();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0500a
            public void t(float f, float f2) {
                VideoPlayFragment Fn = VideoPlayView.this.lMI.Fn(VideoPlayView.this.lMH.getCurrentItem());
                if (Fn != null) {
                    Fn.t(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0500a
            public void bjM() {
                VideoPlayFragment Fn = VideoPlayView.this.lMI.Fn(VideoPlayView.this.lMH.getCurrentItem());
                if (Fn != null) {
                    Fn.bjM();
                }
            }
        });
        this.lMH.setOnPageChangeListener(this);
        this.lMH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment Fn = VideoPlayView.this.lMI.Fn(VideoPlayView.this.lMH.getCurrentItem());
                if (Fn != null) {
                    return Fn.dlJ();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.lMN = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.lMN.setAnimation(R.raw.lottie_video_guide);
        this.lMN.setImageAssetsFolder("lottie_video_guide");
        this.lMN.setOnClickListener(this);
        this.lMN.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.lMN.isAnimating()) {
                    VideoPlayView.this.aw(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.lMN.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.dlQ();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.bPh();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lMP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        bPh();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.lMK = i;
        this.lMI.a(this.mDatas, rect);
        this.lMI.notifyDataSetChanged();
        this.lMH.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.lMI != null) {
            this.lMI.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.lML = aVar;
    }

    public void NZ(String str) {
        if (this.lMI != null) {
            this.lMI.mFrom = str;
        }
    }

    public void onDestroy() {
        bPh();
        dlR();
        if (this.lMI != null) {
            this.lMI.dlM();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.lMJ = i;
        if (this.lMK != i && this.lMQ) {
            this.lMQ = false;
        }
        if (!v.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.lML != null) {
            this.lML.buX();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.lMI != null && this.lMH != null) {
            this.lMI.Fo(this.lMH.getCurrentItem());
        }
    }

    public boolean dlJ() {
        VideoPlayFragment Fn;
        if (dlS()) {
            return true;
        }
        if (this.lMI == null || this.lMH == null || (Fn = this.lMI.Fn(this.lMH.getCurrentItem())) == null) {
            return false;
        }
        return Fn.dlJ();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment Fn;
        if (this.lMI != null && this.lMH != null && (Fn = this.lMI.Fn(this.lMH.getCurrentItem())) != null) {
            Fn.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            bPh();
        }
    }

    private void dlN() {
        this.lMI.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
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
            i = (int) (this.lMP * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.lMH.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.lMP * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.lMH.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.lMP * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.lMH.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.lMP * (0.92d - f) * 6.0d) : 0;
        }
        this.lMH.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlO() {
        if (this.lMJ == this.lMK && this.lMQ) {
            vg(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(int i, int i2) {
        int i3;
        if (!this.lMR && VideoPlayActivityConfig.FROM_DEFAULT.equals(Ob(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.lMQ && i.did()) {
            vg(true);
            this.lMR = true;
            i.die();
        }
    }

    private void dlP() {
        this.lMH.scrollTo(0, 0);
    }

    private boolean vg(boolean z) {
        if (this.lMN == null) {
            return false;
        }
        if (this.lMO || z) {
            this.lMN.setVisibility(0);
            this.lMN.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPh() {
        if (this.lMN != null) {
            if (this.lMN.isAnimating()) {
                this.lMN.pauseAnimation();
                dlP();
            }
            this.lMN.setVisibility(8);
        }
    }

    private boolean Oa(String str) {
        return b.aTX().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Ob(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlQ() {
        if (this.lMO) {
            b.aTX().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Ob(this.mFrom), false);
            this.lMO = false;
        }
    }

    private String Ob(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void Oc(String str) {
        if (this.lMI != null) {
            this.lMI.lMA = str;
        }
    }

    private void dlR() {
        if (this.lMR) {
            i.dig();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Ob(this.mFrom))) {
            if (this.lMQ) {
                i.dif();
            } else {
                i.dig();
            }
        }
    }

    private boolean dlS() {
        if (this.lMN == null || !this.lMN.isAnimating()) {
            return false;
        }
        bPh();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
