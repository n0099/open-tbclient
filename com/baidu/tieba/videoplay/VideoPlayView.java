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
    private VerticalViewPager kIK;
    private VideoPlayFragmentAdapter kIL;
    public int kIN;
    private a kIO;
    private VideoPlayActivity kIP;
    private TBLottieAnimationView kIQ;
    private boolean kIR;
    private int kIS;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int kIM = 0;
    private boolean kIT = true;
    private boolean kIU = false;

    /* loaded from: classes11.dex */
    public interface a {
        void bfP();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.kIP = videoPlayActivity;
        this.mFrom = str;
        this.kIR = KF(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.kIK = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.kIL = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.kIL.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.cTz();
            }
        });
        cTy();
        this.kIL.mFromPage = this.mFrom;
        this.kIK.setAdapter(this.kIL);
        this.kIK.setOffscreenPageLimit(1);
        this.kIK.setEventListener(new a.InterfaceC0400a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
            public void aVq() {
                VideoPlayFragment DY = VideoPlayView.this.kIL.DY(VideoPlayView.this.kIK.getCurrentItem());
                if (DY != null) {
                    DY.aVq();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
            public void u(float f, float f2) {
                VideoPlayFragment DY = VideoPlayView.this.kIL.DY(VideoPlayView.this.kIK.getCurrentItem());
                if (DY != null) {
                    DY.u(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0400a
            public void aVr() {
                VideoPlayFragment DY = VideoPlayView.this.kIL.DY(VideoPlayView.this.kIK.getCurrentItem());
                if (DY != null) {
                    DY.aVr();
                }
            }
        });
        this.kIK.setOnPageChangeListener(this);
        this.kIK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment DY = VideoPlayView.this.kIL.DY(VideoPlayView.this.kIK.getCurrentItem());
                if (DY != null) {
                    return DY.cTu();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.kIQ = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.kIQ.setAnimation(R.raw.lottie_video_guide);
        this.kIQ.setImageAssetsFolder("lottie_video_guide");
        this.kIQ.setOnClickListener(this);
        this.kIQ.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.kIQ.isAnimating()) {
                    VideoPlayView.this.aN(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.kIQ.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.cTB();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.byQ();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kIS = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        byQ();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.kIN = i;
        this.kIL.a(this.mDatas, rect);
        this.kIL.notifyDataSetChanged();
        this.kIK.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.kIL != null) {
            this.kIL.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.kIO = aVar;
    }

    public void KE(String str) {
        if (this.kIL != null) {
            this.kIL.mFrom = str;
        }
    }

    public void onDestroy() {
        byQ();
        cTC();
        if (this.kIL != null) {
            this.kIL.cTx();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.kIM = i;
        if (this.kIN != i && this.kIT) {
            this.kIT = false;
        }
        if (!v.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.kIO != null) {
            this.kIO.bfP();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.kIL != null && this.kIK != null) {
            this.kIL.DZ(this.kIK.getCurrentItem());
        }
    }

    public boolean cTu() {
        VideoPlayFragment DY;
        if (cTD()) {
            return true;
        }
        if (this.kIL == null || this.kIK == null || (DY = this.kIL.DY(this.kIK.getCurrentItem())) == null) {
            return false;
        }
        return DY.cTu();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment DY;
        if (this.kIL != null && this.kIK != null && (DY = this.kIL.DY(this.kIK.getCurrentItem())) != null) {
            DY.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            byQ();
        }
    }

    private void cTy() {
        this.kIL.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.j.b
            public void bz(int i, int i2) {
                VideoPlayView.this.cU(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.kIS * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.kIK.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.kIS * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.kIK.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.kIS * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.kIK.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.kIS * (0.92d - f) * 6.0d) : 0;
        }
        this.kIK.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTz() {
        if (this.kIM == this.kIN && this.kIT) {
            tG(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cU(int i, int i2) {
        int i3;
        if (!this.kIU && VideoPlayActivityConfig.FROM_DEFAULT.equals(KG(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.kIT && i.cPG()) {
            tG(true);
            this.kIU = true;
            i.cPH();
        }
    }

    private void cTA() {
        this.kIK.scrollTo(0, 0);
    }

    private boolean tG(boolean z) {
        if (this.kIQ == null) {
            return false;
        }
        if (this.kIR || z) {
            this.kIQ.setVisibility(0);
            this.kIQ.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byQ() {
        if (this.kIQ != null) {
            if (this.kIQ.isAnimating()) {
                this.kIQ.pauseAnimation();
                cTA();
            }
            this.kIQ.setVisibility(8);
        }
    }

    private boolean KF(String str) {
        return b.aFH().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + KG(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTB() {
        if (this.kIR) {
            b.aFH().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + KG(this.mFrom), false);
            this.kIR = false;
        }
    }

    private String KG(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void KH(String str) {
        if (this.kIL != null) {
            this.kIL.kID = str;
        }
    }

    private void cTC() {
        if (this.kIU) {
            i.cPJ();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(KG(this.mFrom))) {
            if (this.kIT) {
                i.cPI();
            } else {
                i.cPJ();
            }
        }
    }

    private boolean cTD() {
        if (this.kIQ == null || !this.kIQ.isAnimating()) {
            return false;
        }
        byQ();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
