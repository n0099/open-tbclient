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
    private VerticalViewPager kGP;
    private VideoPlayFragmentAdapter kGQ;
    public int kGS;
    private a kGT;
    private VideoPlayActivity kGU;
    private TBLottieAnimationView kGV;
    private boolean kGW;
    private int kGX;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int kGR = 0;
    private boolean kGY = true;
    private boolean kGZ = false;

    /* loaded from: classes11.dex */
    public interface a {
        void bfH();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.kGU = videoPlayActivity;
        this.mFrom = str;
        this.kGW = KE(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.kGP = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.kGQ = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.kGQ.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.cTc();
            }
        });
        cTb();
        this.kGQ.mFromPage = this.mFrom;
        this.kGP.setAdapter(this.kGQ);
        this.kGP.setOffscreenPageLimit(1);
        this.kGP.setEventListener(new a.InterfaceC0400a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
            public void aVj() {
                VideoPlayFragment DQ = VideoPlayView.this.kGQ.DQ(VideoPlayView.this.kGP.getCurrentItem());
                if (DQ != null) {
                    DQ.aVj();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
            public void u(float f, float f2) {
                VideoPlayFragment DQ = VideoPlayView.this.kGQ.DQ(VideoPlayView.this.kGP.getCurrentItem());
                if (DQ != null) {
                    DQ.u(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
            public void aVk() {
                VideoPlayFragment DQ = VideoPlayView.this.kGQ.DQ(VideoPlayView.this.kGP.getCurrentItem());
                if (DQ != null) {
                    DQ.aVk();
                }
            }
        });
        this.kGP.setOnPageChangeListener(this);
        this.kGP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment DQ = VideoPlayView.this.kGQ.DQ(VideoPlayView.this.kGP.getCurrentItem());
                if (DQ != null) {
                    return DQ.cSX();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.kGV = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.kGV.setAnimation(R.raw.lottie_video_guide);
        this.kGV.setImageAssetsFolder("lottie_video_guide");
        this.kGV.setOnClickListener(this);
        this.kGV.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.kGV.isAnimating()) {
                    VideoPlayView.this.aN(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.kGV.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.cTe();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.byH();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kGX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        byH();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.kGS = i;
        this.kGQ.a(this.mDatas, rect);
        this.kGQ.notifyDataSetChanged();
        this.kGP.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.kGQ != null) {
            this.kGQ.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.kGT = aVar;
    }

    public void KD(String str) {
        if (this.kGQ != null) {
            this.kGQ.mFrom = str;
        }
    }

    public void onDestroy() {
        byH();
        cTf();
        if (this.kGQ != null) {
            this.kGQ.cTa();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.kGR = i;
        if (this.kGS != i && this.kGY) {
            this.kGY = false;
        }
        if (!v.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.kGT != null) {
            this.kGT.bfH();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.kGQ != null && this.kGP != null) {
            this.kGQ.DR(this.kGP.getCurrentItem());
        }
    }

    public boolean cSX() {
        VideoPlayFragment DQ;
        if (cTg()) {
            return true;
        }
        if (this.kGQ == null || this.kGP == null || (DQ = this.kGQ.DQ(this.kGP.getCurrentItem())) == null) {
            return false;
        }
        return DQ.cSX();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment DQ;
        if (this.kGQ != null && this.kGP != null && (DQ = this.kGQ.DQ(this.kGP.getCurrentItem())) != null) {
            DQ.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            byH();
        }
    }

    private void cTb() {
        this.kGQ.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
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
            i = (int) (this.kGX * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.kGP.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.kGX * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.kGP.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.kGX * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.kGP.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.kGX * (0.92d - f) * 6.0d) : 0;
        }
        this.kGP.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTc() {
        if (this.kGR == this.kGS && this.kGY) {
            tA(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT(int i, int i2) {
        int i3;
        if (!this.kGZ && VideoPlayActivityConfig.FROM_DEFAULT.equals(KF(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.kGY && i.cPj()) {
            tA(true);
            this.kGZ = true;
            i.cPk();
        }
    }

    private void cTd() {
        this.kGP.scrollTo(0, 0);
    }

    private boolean tA(boolean z) {
        if (this.kGV == null) {
            return false;
        }
        if (this.kGW || z) {
            this.kGV.setVisibility(0);
            this.kGV.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byH() {
        if (this.kGV != null) {
            if (this.kGV.isAnimating()) {
                this.kGV.pauseAnimation();
                cTd();
            }
            this.kGV.setVisibility(8);
        }
    }

    private boolean KE(String str) {
        return b.aFB().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + KF(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTe() {
        if (this.kGW) {
            b.aFB().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + KF(this.mFrom), false);
            this.kGW = false;
        }
    }

    private String KF(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void KG(String str) {
        if (this.kGQ != null) {
            this.kGQ.kGI = str;
        }
    }

    private void cTf() {
        if (this.kGZ) {
            i.cPm();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(KF(this.mFrom))) {
            if (this.kGY) {
                i.cPl();
            } else {
                i.cPm();
            }
        }
    }

    private boolean cTg() {
        if (this.kGV == null || !this.kGV.isAnimating()) {
            return false;
        }
        byH();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
