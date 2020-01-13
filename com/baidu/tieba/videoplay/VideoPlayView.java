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
    private VerticalViewPager kFP;
    private VideoPlayFragmentAdapter kFQ;
    public int kFS;
    private a kFT;
    private VideoPlayActivity kFU;
    private TBLottieAnimationView kFV;
    private boolean kFW;
    private int kFX;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int kFR = 0;
    private boolean kFY = true;
    private boolean kFZ = false;

    /* loaded from: classes9.dex */
    public interface a {
        void bdz();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.kFU = videoPlayActivity;
        this.mFrom = str;
        this.kFW = Kr(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.kFP = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.kFQ = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.kFQ.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.cRG();
            }
        });
        cRF();
        this.kFQ.mFromPage = this.mFrom;
        this.kFP.setAdapter(this.kFQ);
        this.kFP.setOffscreenPageLimit(1);
        this.kFP.setEventListener(new a.InterfaceC0389a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0389a
            public void aSS() {
                VideoPlayFragment DK = VideoPlayView.this.kFQ.DK(VideoPlayView.this.kFP.getCurrentItem());
                if (DK != null) {
                    DK.aSS();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0389a
            public void u(float f, float f2) {
                VideoPlayFragment DK = VideoPlayView.this.kFQ.DK(VideoPlayView.this.kFP.getCurrentItem());
                if (DK != null) {
                    DK.u(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0389a
            public void aST() {
                VideoPlayFragment DK = VideoPlayView.this.kFQ.DK(VideoPlayView.this.kFP.getCurrentItem());
                if (DK != null) {
                    DK.aST();
                }
            }
        });
        this.kFP.setOnPageChangeListener(this);
        this.kFP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment DK = VideoPlayView.this.kFQ.DK(VideoPlayView.this.kFP.getCurrentItem());
                if (DK != null) {
                    return DK.cRB();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.kFV = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.kFV.setAnimation(R.raw.lottie_video_guide);
        this.kFV.setImageAssetsFolder("lottie_video_guide");
        this.kFV.setOnClickListener(this);
        this.kFV.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.kFV.isAnimating()) {
                    VideoPlayView.this.aO(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.kFV.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.cRI();
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
        this.kFX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        bxc();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.kFS = i;
        this.kFQ.a(this.mDatas, rect);
        this.kFQ.notifyDataSetChanged();
        this.kFP.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.kFQ != null) {
            this.kFQ.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.kFT = aVar;
    }

    public void Kq(String str) {
        if (this.kFQ != null) {
            this.kFQ.mFrom = str;
        }
    }

    public void onDestroy() {
        bxc();
        cRJ();
        if (this.kFQ != null) {
            this.kFQ.cRE();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.kFR = i;
        if (this.kFS != i && this.kFY) {
            this.kFY = false;
        }
        if (!v.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.kFT != null) {
            this.kFT.bdz();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.kFQ != null && this.kFP != null) {
            this.kFQ.DL(this.kFP.getCurrentItem());
        }
    }

    public boolean cRB() {
        VideoPlayFragment DK;
        if (cRK()) {
            return true;
        }
        if (this.kFQ == null || this.kFP == null || (DK = this.kFQ.DK(this.kFP.getCurrentItem())) == null) {
            return false;
        }
        return DK.cRB();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment DK;
        if (this.kFQ != null && this.kFP != null && (DK = this.kFQ.DK(this.kFP.getCurrentItem())) != null) {
            DK.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            bxc();
        }
    }

    private void cRF() {
        this.kFQ.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
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
            i = (int) (this.kFX * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.kFP.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.kFX * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.kFP.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.kFX * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.kFP.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.kFX * (0.92d - f) * 6.0d) : 0;
        }
        this.kFP.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRG() {
        if (this.kFR == this.kFS && this.kFY) {
            tw(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQ(int i, int i2) {
        int i3;
        if (!this.kFZ && VideoPlayActivityConfig.FROM_DEFAULT.equals(Ks(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.kFY && i.cNM()) {
            tw(true);
            this.kFZ = true;
            i.cNN();
        }
    }

    private void cRH() {
        this.kFP.scrollTo(0, 0);
    }

    private boolean tw(boolean z) {
        if (this.kFV == null) {
            return false;
        }
        if (this.kFW || z) {
            this.kFV.setVisibility(0);
            this.kFV.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxc() {
        if (this.kFV != null) {
            if (this.kFV.isAnimating()) {
                this.kFV.pauseAnimation();
                cRH();
            }
            this.kFV.setVisibility(8);
        }
    }

    private boolean Kr(String str) {
        return b.aDr().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Ks(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRI() {
        if (this.kFW) {
            b.aDr().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Ks(this.mFrom), false);
            this.kFW = false;
        }
    }

    private String Ks(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void Kt(String str) {
        if (this.kFQ != null) {
            this.kFQ.kFI = str;
        }
    }

    private void cRJ() {
        if (this.kFZ) {
            i.cNP();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Ks(this.mFrom))) {
            if (this.kFY) {
                i.cNO();
            } else {
                i.cNP();
            }
        }
    }

    private boolean cRK() {
        if (this.kFV == null || !this.kFV.isAnimating()) {
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
