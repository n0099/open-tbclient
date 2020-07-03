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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.viewpager.VerticalViewPager;
import com.baidu.tbadk.widget.viewpager.a;
import com.baidu.tieba.R;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.j;
import com.baidu.tieba.video.VideoItemData;
import java.util.List;
/* loaded from: classes11.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int mgB;
    private a mgC;
    private VideoPlayActivity mgD;
    private TBLottieAnimationView mgE;
    private boolean mgF;
    private int mgG;
    private VerticalViewPager mgy;
    private VideoPlayFragmentAdapter mgz;
    public int mgA = 0;
    private boolean mgH = true;
    private boolean mgI = false;

    /* loaded from: classes11.dex */
    public interface a {
        void bxS();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.mgD = videoPlayActivity;
        this.mFrom = str;
        this.mgF = OC(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.mgy = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.mgz = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.mgz.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.dqa();
            }
        });
        dpZ();
        this.mgz.mFromPage = this.mFrom;
        this.mgy.setAdapter(this.mgz);
        this.mgy.setOffscreenPageLimit(1);
        this.mgy.setEventListener(new a.InterfaceC0508a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0508a
            public void bmk() {
                VideoPlayFragment Gr = VideoPlayView.this.mgz.Gr(VideoPlayView.this.mgy.getCurrentItem());
                if (Gr != null) {
                    Gr.bmk();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0508a
            public void t(float f, float f2) {
                VideoPlayFragment Gr = VideoPlayView.this.mgz.Gr(VideoPlayView.this.mgy.getCurrentItem());
                if (Gr != null) {
                    Gr.t(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0508a
            public void bml() {
                VideoPlayFragment Gr = VideoPlayView.this.mgz.Gr(VideoPlayView.this.mgy.getCurrentItem());
                if (Gr != null) {
                    Gr.bml();
                }
            }
        });
        this.mgy.setOnPageChangeListener(this);
        this.mgy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment Gr = VideoPlayView.this.mgz.Gr(VideoPlayView.this.mgy.getCurrentItem());
                if (Gr != null) {
                    return Gr.dpV();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.mgE = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.mgE.setAnimation(R.raw.lottie_video_guide);
        this.mgE.setImageAssetsFolder("lottie_video_guide");
        this.mgE.setOnClickListener(this);
        this.mgE.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.mgE.isAnimating()) {
                    VideoPlayView.this.aB(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.mgE.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.dqc();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.bSk();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mgG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        bSk();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.mgB = i;
        this.mgz.a(this.mDatas, rect);
        this.mgz.notifyDataSetChanged();
        this.mgy.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.mgz != null) {
            this.mgz.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.mgC = aVar;
    }

    public void OB(String str) {
        if (this.mgz != null) {
            this.mgz.mFrom = str;
        }
    }

    public void onDestroy() {
        bSk();
        dqd();
        if (this.mgz != null) {
            this.mgz.dpY();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mgA = i;
        if (this.mgB != i && this.mgH) {
            this.mgH = false;
        }
        if (!w.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.mgC != null) {
            this.mgC.bxS();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.mgz != null && this.mgy != null) {
            this.mgz.Gs(this.mgy.getCurrentItem());
        }
    }

    public boolean dpV() {
        VideoPlayFragment Gr;
        if (dqe()) {
            return true;
        }
        if (this.mgz == null || this.mgy == null || (Gr = this.mgz.Gr(this.mgy.getCurrentItem())) == null) {
            return false;
        }
        return Gr.dpV();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment Gr;
        if (this.mgz != null && this.mgy != null && (Gr = this.mgz.Gr(this.mgy.getCurrentItem())) != null) {
            Gr.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            bSk();
        }
    }

    private void dpZ() {
        this.mgz.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.j.b
            public void bM(int i, int i2) {
                VideoPlayView.this.dk(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.mgG * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.mgy.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.mgG * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.mgy.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.mgG * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.mgy.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.mgG * (0.92d - f) * 6.0d) : 0;
        }
        this.mgy.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqa() {
        if (this.mgA == this.mgB && this.mgH) {
            vy(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(int i, int i2) {
        int i3;
        if (!this.mgI && VideoPlayActivityConfig.FROM_DEFAULT.equals(OD(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.mgH && com.baidu.tieba.video.j.dmo()) {
            vy(true);
            this.mgI = true;
            com.baidu.tieba.video.j.dmp();
        }
    }

    private void dqb() {
        this.mgy.scrollTo(0, 0);
    }

    private boolean vy(boolean z) {
        if (this.mgE == null) {
            return false;
        }
        if (this.mgF || z) {
            this.mgE.setVisibility(0);
            this.mgE.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSk() {
        if (this.mgE != null) {
            if (this.mgE.isAnimating()) {
                this.mgE.pauseAnimation();
                dqb();
            }
            this.mgE.setVisibility(8);
        }
    }

    private boolean OC(String str) {
        return b.aVP().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + OD(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqc() {
        if (this.mgF) {
            b.aVP().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + OD(this.mFrom), false);
            this.mgF = false;
        }
    }

    private String OD(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void OE(String str) {
        if (this.mgz != null) {
            this.mgz.mgr = str;
        }
    }

    private void dqd() {
        if (this.mgI) {
            com.baidu.tieba.video.j.dmr();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(OD(this.mFrom))) {
            if (this.mgH) {
                com.baidu.tieba.video.j.dmq();
            } else {
                com.baidu.tieba.video.j.dmr();
            }
        }
    }

    private boolean dqe() {
        if (this.mgE == null || !this.mgE.isAnimating()) {
            return false;
        }
        bSk();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
