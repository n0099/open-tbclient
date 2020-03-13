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
    private VerticalViewPager kHd;
    private VideoPlayFragmentAdapter kHe;
    public int kHg;
    private a kHh;
    private VideoPlayActivity kHi;
    private TBLottieAnimationView kHj;
    private boolean kHk;
    private int kHl;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int kHf = 0;
    private boolean kHm = true;
    private boolean kHn = false;

    /* loaded from: classes11.dex */
    public interface a {
        void bfK();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.kHi = videoPlayActivity;
        this.mFrom = str;
        this.kHk = KF(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.kHd = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.kHe = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.kHe.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.cTf();
            }
        });
        cTe();
        this.kHe.mFromPage = this.mFrom;
        this.kHd.setAdapter(this.kHe);
        this.kHd.setOffscreenPageLimit(1);
        this.kHd.setEventListener(new a.InterfaceC0400a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
            public void aVm() {
                VideoPlayFragment DQ = VideoPlayView.this.kHe.DQ(VideoPlayView.this.kHd.getCurrentItem());
                if (DQ != null) {
                    DQ.aVm();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
            public void u(float f, float f2) {
                VideoPlayFragment DQ = VideoPlayView.this.kHe.DQ(VideoPlayView.this.kHd.getCurrentItem());
                if (DQ != null) {
                    DQ.u(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
            public void aVn() {
                VideoPlayFragment DQ = VideoPlayView.this.kHe.DQ(VideoPlayView.this.kHd.getCurrentItem());
                if (DQ != null) {
                    DQ.aVn();
                }
            }
        });
        this.kHd.setOnPageChangeListener(this);
        this.kHd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment DQ = VideoPlayView.this.kHe.DQ(VideoPlayView.this.kHd.getCurrentItem());
                if (DQ != null) {
                    return DQ.cTa();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.kHj = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.kHj.setAnimation(R.raw.lottie_video_guide);
        this.kHj.setImageAssetsFolder("lottie_video_guide");
        this.kHj.setOnClickListener(this);
        this.kHj.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.kHj.isAnimating()) {
                    VideoPlayView.this.aN(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.kHj.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.cTh();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.byK();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kHl = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        byK();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.kHg = i;
        this.kHe.a(this.mDatas, rect);
        this.kHe.notifyDataSetChanged();
        this.kHd.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.kHe != null) {
            this.kHe.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.kHh = aVar;
    }

    public void KE(String str) {
        if (this.kHe != null) {
            this.kHe.mFrom = str;
        }
    }

    public void onDestroy() {
        byK();
        cTi();
        if (this.kHe != null) {
            this.kHe.cTd();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.kHf = i;
        if (this.kHg != i && this.kHm) {
            this.kHm = false;
        }
        if (!v.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.kHh != null) {
            this.kHh.bfK();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.kHe != null && this.kHd != null) {
            this.kHe.DR(this.kHd.getCurrentItem());
        }
    }

    public boolean cTa() {
        VideoPlayFragment DQ;
        if (cTj()) {
            return true;
        }
        if (this.kHe == null || this.kHd == null || (DQ = this.kHe.DQ(this.kHd.getCurrentItem())) == null) {
            return false;
        }
        return DQ.cTa();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment DQ;
        if (this.kHe != null && this.kHd != null && (DQ = this.kHe.DQ(this.kHd.getCurrentItem())) != null) {
            DQ.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            byK();
        }
    }

    private void cTe() {
        this.kHe.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.j.b
            public void by(int i, int i2) {
                VideoPlayView.this.cT(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.kHl * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.kHd.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.kHl * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.kHd.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.kHl * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.kHd.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.kHl * (0.92d - f) * 6.0d) : 0;
        }
        this.kHd.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTf() {
        if (this.kHf == this.kHg && this.kHm) {
            tA(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT(int i, int i2) {
        int i3;
        if (!this.kHn && VideoPlayActivityConfig.FROM_DEFAULT.equals(KG(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.kHm && i.cPm()) {
            tA(true);
            this.kHn = true;
            i.cPn();
        }
    }

    private void cTg() {
        this.kHd.scrollTo(0, 0);
    }

    private boolean tA(boolean z) {
        if (this.kHj == null) {
            return false;
        }
        if (this.kHk || z) {
            this.kHj.setVisibility(0);
            this.kHj.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byK() {
        if (this.kHj != null) {
            if (this.kHj.isAnimating()) {
                this.kHj.pauseAnimation();
                cTg();
            }
            this.kHj.setVisibility(8);
        }
    }

    private boolean KF(String str) {
        return b.aFD().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + KG(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTh() {
        if (this.kHk) {
            b.aFD().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + KG(this.mFrom), false);
            this.kHk = false;
        }
    }

    private String KG(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void KH(String str) {
        if (this.kHe != null) {
            this.kHe.kGW = str;
        }
    }

    private void cTi() {
        if (this.kHn) {
            i.cPp();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(KG(this.mFrom))) {
            if (this.kHm) {
                i.cPo();
            } else {
                i.cPp();
            }
        }
    }

    private boolean cTj() {
        if (this.kHj == null || !this.kHj.isAnimating()) {
            return false;
        }
        byK();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
