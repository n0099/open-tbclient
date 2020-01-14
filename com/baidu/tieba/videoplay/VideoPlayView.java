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
/* loaded from: classes9.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private VerticalViewPager kFU;
    private VideoPlayFragmentAdapter kFV;
    public int kFX;
    private a kFY;
    private VideoPlayActivity kFZ;
    private TBLottieAnimationView kGa;
    private boolean kGb;
    private int kGc;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int kFW = 0;
    private boolean kGd = true;
    private boolean kGe = false;

    /* loaded from: classes9.dex */
    public interface a {
        void bdz();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.kFZ = videoPlayActivity;
        this.mFrom = str;
        this.kGb = Kr(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.kFU = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.kFV = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.kFV.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.cRI();
            }
        });
        cRH();
        this.kFV.mFromPage = this.mFrom;
        this.kFU.setAdapter(this.kFV);
        this.kFU.setOffscreenPageLimit(1);
        this.kFU.setEventListener(new a.InterfaceC0389a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0389a
            public void aSS() {
                VideoPlayFragment DK = VideoPlayView.this.kFV.DK(VideoPlayView.this.kFU.getCurrentItem());
                if (DK != null) {
                    DK.aSS();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0389a
            public void u(float f, float f2) {
                VideoPlayFragment DK = VideoPlayView.this.kFV.DK(VideoPlayView.this.kFU.getCurrentItem());
                if (DK != null) {
                    DK.u(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0389a
            public void aST() {
                VideoPlayFragment DK = VideoPlayView.this.kFV.DK(VideoPlayView.this.kFU.getCurrentItem());
                if (DK != null) {
                    DK.aST();
                }
            }
        });
        this.kFU.setOnPageChangeListener(this);
        this.kFU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment DK = VideoPlayView.this.kFV.DK(VideoPlayView.this.kFU.getCurrentItem());
                if (DK != null) {
                    return DK.cRD();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.kGa = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.kGa.setAnimation(R.raw.lottie_video_guide);
        this.kGa.setImageAssetsFolder("lottie_video_guide");
        this.kGa.setOnClickListener(this);
        this.kGa.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.kGa.isAnimating()) {
                    VideoPlayView.this.aO(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.kGa.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.cRK();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.bxc();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kGc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        bxc();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.kFX = i;
        this.kFV.a(this.mDatas, rect);
        this.kFV.notifyDataSetChanged();
        this.kFU.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.kFV != null) {
            this.kFV.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.kFY = aVar;
    }

    public void Kq(String str) {
        if (this.kFV != null) {
            this.kFV.mFrom = str;
        }
    }

    public void onDestroy() {
        bxc();
        cRL();
        if (this.kFV != null) {
            this.kFV.cRG();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.kFW = i;
        if (this.kFX != i && this.kGd) {
            this.kGd = false;
        }
        if (!v.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.kFY != null) {
            this.kFY.bdz();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.kFV != null && this.kFU != null) {
            this.kFV.DL(this.kFU.getCurrentItem());
        }
    }

    public boolean cRD() {
        VideoPlayFragment DK;
        if (cRM()) {
            return true;
        }
        if (this.kFV == null || this.kFU == null || (DK = this.kFV.DK(this.kFU.getCurrentItem())) == null) {
            return false;
        }
        return DK.cRD();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment DK;
        if (this.kFV != null && this.kFU != null && (DK = this.kFV.DK(this.kFU.getCurrentItem())) != null) {
            DK.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            bxc();
        }
    }

    private void cRH() {
        this.kFV.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.j.b
            public void bx(int i, int i2) {
                VideoPlayView.this.cQ(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.kGc * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.kFU.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.kGc * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.kFU.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.kGc * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.kFU.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.kGc * (0.92d - f) * 6.0d) : 0;
        }
        this.kFU.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRI() {
        if (this.kFW == this.kFX && this.kGd) {
            tw(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQ(int i, int i2) {
        int i3;
        if (!this.kGe && VideoPlayActivityConfig.FROM_DEFAULT.equals(Ks(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.kGd && i.cNO()) {
            tw(true);
            this.kGe = true;
            i.cNP();
        }
    }

    private void cRJ() {
        this.kFU.scrollTo(0, 0);
    }

    private boolean tw(boolean z) {
        if (this.kGa == null) {
            return false;
        }
        if (this.kGb || z) {
            this.kGa.setVisibility(0);
            this.kGa.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxc() {
        if (this.kGa != null) {
            if (this.kGa.isAnimating()) {
                this.kGa.pauseAnimation();
                cRJ();
            }
            this.kGa.setVisibility(8);
        }
    }

    private boolean Kr(String str) {
        return b.aDr().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Ks(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRK() {
        if (this.kGb) {
            b.aDr().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Ks(this.mFrom), false);
            this.kGb = false;
        }
    }

    private String Ks(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void Kt(String str) {
        if (this.kFV != null) {
            this.kFV.kFN = str;
        }
    }

    private void cRL() {
        if (this.kGe) {
            i.cNR();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Ks(this.mFrom))) {
            if (this.kGd) {
                i.cNQ();
            } else {
                i.cNR();
            }
        }
    }

    private boolean cRM() {
        if (this.kGa == null || !this.kGa.isAnimating()) {
            return false;
        }
        bxc();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
