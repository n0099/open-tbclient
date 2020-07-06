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
    private VerticalViewPager mgB;
    private VideoPlayFragmentAdapter mgC;
    public int mgE;
    private a mgF;
    private VideoPlayActivity mgG;
    private TBLottieAnimationView mgH;
    private boolean mgI;
    private int mgJ;
    public int mgD = 0;
    private boolean mgK = true;
    private boolean mgL = false;

    /* loaded from: classes11.dex */
    public interface a {
        void bxT();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.mgG = videoPlayActivity;
        this.mFrom = str;
        this.mgI = OD(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.mgB = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.mgC = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.mgC.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.dqe();
            }
        });
        dqd();
        this.mgC.mFromPage = this.mFrom;
        this.mgB.setAdapter(this.mgC);
        this.mgB.setOffscreenPageLimit(1);
        this.mgB.setEventListener(new a.InterfaceC0508a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0508a
            public void bml() {
                VideoPlayFragment Gr = VideoPlayView.this.mgC.Gr(VideoPlayView.this.mgB.getCurrentItem());
                if (Gr != null) {
                    Gr.bml();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0508a
            public void t(float f, float f2) {
                VideoPlayFragment Gr = VideoPlayView.this.mgC.Gr(VideoPlayView.this.mgB.getCurrentItem());
                if (Gr != null) {
                    Gr.t(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0508a
            public void bmm() {
                VideoPlayFragment Gr = VideoPlayView.this.mgC.Gr(VideoPlayView.this.mgB.getCurrentItem());
                if (Gr != null) {
                    Gr.bmm();
                }
            }
        });
        this.mgB.setOnPageChangeListener(this);
        this.mgB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment Gr = VideoPlayView.this.mgC.Gr(VideoPlayView.this.mgB.getCurrentItem());
                if (Gr != null) {
                    return Gr.dpZ();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.mgH = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.mgH.setAnimation(R.raw.lottie_video_guide);
        this.mgH.setImageAssetsFolder("lottie_video_guide");
        this.mgH.setOnClickListener(this);
        this.mgH.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.mgH.isAnimating()) {
                    VideoPlayView.this.aB(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.mgH.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.dqg();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.bSl();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mgJ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        bSl();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.mgE = i;
        this.mgC.a(this.mDatas, rect);
        this.mgC.notifyDataSetChanged();
        this.mgB.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.mgC != null) {
            this.mgC.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.mgF = aVar;
    }

    public void OC(String str) {
        if (this.mgC != null) {
            this.mgC.mFrom = str;
        }
    }

    public void onDestroy() {
        bSl();
        dqh();
        if (this.mgC != null) {
            this.mgC.dqc();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mgD = i;
        if (this.mgE != i && this.mgK) {
            this.mgK = false;
        }
        if (!w.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.mgF != null) {
            this.mgF.bxT();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.mgC != null && this.mgB != null) {
            this.mgC.Gs(this.mgB.getCurrentItem());
        }
    }

    public boolean dpZ() {
        VideoPlayFragment Gr;
        if (dqi()) {
            return true;
        }
        if (this.mgC == null || this.mgB == null || (Gr = this.mgC.Gr(this.mgB.getCurrentItem())) == null) {
            return false;
        }
        return Gr.dpZ();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment Gr;
        if (this.mgC != null && this.mgB != null && (Gr = this.mgC.Gr(this.mgB.getCurrentItem())) != null) {
            Gr.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            bSl();
        }
    }

    private void dqd() {
        this.mgC.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
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
            i = (int) (this.mgJ * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.mgB.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.mgJ * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.mgB.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.mgJ * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.mgB.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.mgJ * (0.92d - f) * 6.0d) : 0;
        }
        this.mgB.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqe() {
        if (this.mgD == this.mgE && this.mgK) {
            vy(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dk(int i, int i2) {
        int i3;
        if (!this.mgL && VideoPlayActivityConfig.FROM_DEFAULT.equals(OE(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.mgK && com.baidu.tieba.video.j.dms()) {
            vy(true);
            this.mgL = true;
            com.baidu.tieba.video.j.dmt();
        }
    }

    private void dqf() {
        this.mgB.scrollTo(0, 0);
    }

    private boolean vy(boolean z) {
        if (this.mgH == null) {
            return false;
        }
        if (this.mgI || z) {
            this.mgH.setVisibility(0);
            this.mgH.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSl() {
        if (this.mgH != null) {
            if (this.mgH.isAnimating()) {
                this.mgH.pauseAnimation();
                dqf();
            }
            this.mgH.setVisibility(8);
        }
    }

    private boolean OD(String str) {
        return b.aVP().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + OE(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqg() {
        if (this.mgI) {
            b.aVP().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + OE(this.mFrom), false);
            this.mgI = false;
        }
    }

    private String OE(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void OF(String str) {
        if (this.mgC != null) {
            this.mgC.mgu = str;
        }
    }

    private void dqh() {
        if (this.mgL) {
            com.baidu.tieba.video.j.dmv();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(OE(this.mFrom))) {
            if (this.mgK) {
                com.baidu.tieba.video.j.dmu();
            } else {
                com.baidu.tieba.video.j.dmv();
            }
        }
    }

    private boolean dqi() {
        if (this.mgH == null || !this.mgH.isAnimating()) {
            return false;
        }
        bSl();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
