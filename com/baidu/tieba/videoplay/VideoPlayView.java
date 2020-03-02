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
    private VerticalViewPager kGR;
    private VideoPlayFragmentAdapter kGS;
    public int kGU;
    private a kGV;
    private VideoPlayActivity kGW;
    private TBLottieAnimationView kGX;
    private boolean kGY;
    private int kGZ;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int kGT = 0;
    private boolean kHa = true;
    private boolean kHb = false;

    /* loaded from: classes11.dex */
    public interface a {
        void bfJ();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.kGW = videoPlayActivity;
        this.mFrom = str;
        this.kGY = KE(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.kGR = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.kGS = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.kGS.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.cTe();
            }
        });
        cTd();
        this.kGS.mFromPage = this.mFrom;
        this.kGR.setAdapter(this.kGS);
        this.kGR.setOffscreenPageLimit(1);
        this.kGR.setEventListener(new a.InterfaceC0400a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
            public void aVl() {
                VideoPlayFragment DQ = VideoPlayView.this.kGS.DQ(VideoPlayView.this.kGR.getCurrentItem());
                if (DQ != null) {
                    DQ.aVl();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
            public void u(float f, float f2) {
                VideoPlayFragment DQ = VideoPlayView.this.kGS.DQ(VideoPlayView.this.kGR.getCurrentItem());
                if (DQ != null) {
                    DQ.u(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
            public void aVm() {
                VideoPlayFragment DQ = VideoPlayView.this.kGS.DQ(VideoPlayView.this.kGR.getCurrentItem());
                if (DQ != null) {
                    DQ.aVm();
                }
            }
        });
        this.kGR.setOnPageChangeListener(this);
        this.kGR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment DQ = VideoPlayView.this.kGS.DQ(VideoPlayView.this.kGR.getCurrentItem());
                if (DQ != null) {
                    return DQ.cSZ();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.kGX = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.kGX.setAnimation(R.raw.lottie_video_guide);
        this.kGX.setImageAssetsFolder("lottie_video_guide");
        this.kGX.setOnClickListener(this);
        this.kGX.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.kGX.isAnimating()) {
                    VideoPlayView.this.aN(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.kGX.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.cTg();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.byJ();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kGZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        byJ();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.kGU = i;
        this.kGS.a(this.mDatas, rect);
        this.kGS.notifyDataSetChanged();
        this.kGR.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.kGS != null) {
            this.kGS.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.kGV = aVar;
    }

    public void KD(String str) {
        if (this.kGS != null) {
            this.kGS.mFrom = str;
        }
    }

    public void onDestroy() {
        byJ();
        cTh();
        if (this.kGS != null) {
            this.kGS.cTc();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.kGT = i;
        if (this.kGU != i && this.kHa) {
            this.kHa = false;
        }
        if (!v.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.kGV != null) {
            this.kGV.bfJ();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.kGS != null && this.kGR != null) {
            this.kGS.DR(this.kGR.getCurrentItem());
        }
    }

    public boolean cSZ() {
        VideoPlayFragment DQ;
        if (cTi()) {
            return true;
        }
        if (this.kGS == null || this.kGR == null || (DQ = this.kGS.DQ(this.kGR.getCurrentItem())) == null) {
            return false;
        }
        return DQ.cSZ();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment DQ;
        if (this.kGS != null && this.kGR != null && (DQ = this.kGS.DQ(this.kGR.getCurrentItem())) != null) {
            DQ.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            byJ();
        }
    }

    private void cTd() {
        this.kGS.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
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
            i = (int) (this.kGZ * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.kGR.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.kGZ * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.kGR.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.kGZ * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.kGR.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.kGZ * (0.92d - f) * 6.0d) : 0;
        }
        this.kGR.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTe() {
        if (this.kGT == this.kGU && this.kHa) {
            tA(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT(int i, int i2) {
        int i3;
        if (!this.kHb && VideoPlayActivityConfig.FROM_DEFAULT.equals(KF(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.kHa && i.cPl()) {
            tA(true);
            this.kHb = true;
            i.cPm();
        }
    }

    private void cTf() {
        this.kGR.scrollTo(0, 0);
    }

    private boolean tA(boolean z) {
        if (this.kGX == null) {
            return false;
        }
        if (this.kGY || z) {
            this.kGX.setVisibility(0);
            this.kGX.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byJ() {
        if (this.kGX != null) {
            if (this.kGX.isAnimating()) {
                this.kGX.pauseAnimation();
                cTf();
            }
            this.kGX.setVisibility(8);
        }
    }

    private boolean KE(String str) {
        return b.aFD().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + KF(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTg() {
        if (this.kGY) {
            b.aFD().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + KF(this.mFrom), false);
            this.kGY = false;
        }
    }

    private String KF(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void KG(String str) {
        if (this.kGS != null) {
            this.kGS.kGK = str;
        }
    }

    private void cTh() {
        if (this.kHb) {
            i.cPo();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(KF(this.mFrom))) {
            if (this.kHa) {
                i.cPn();
            } else {
                i.cPo();
            }
        }
    }

    private boolean cTi() {
        if (this.kGX == null || !this.kGX.isAnimating()) {
            return false;
        }
        byJ();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
