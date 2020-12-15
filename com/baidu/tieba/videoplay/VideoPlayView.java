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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.viewpager.VerticalViewPager;
import com.baidu.tbadk.widget.viewpager.a;
import com.baidu.tieba.R;
import com.baidu.tieba.play.f;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.i;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import java.util.List;
/* loaded from: classes24.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    private VerticalViewPager nMV;
    private VideoPlayFragmentAdapter nMW;
    public int nMY;
    private a nMZ;
    private VideoPlayActivity nNa;
    private TBLottieAnimationView nNb;
    private boolean nNc;
    private int nNd;
    public int nMX = 0;
    private boolean nNe = true;
    private boolean nNf = false;

    /* loaded from: classes24.dex */
    public interface a {
        void bWF();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.nNa = videoPlayActivity;
        this.mFrom = str;
        this.nNc = Vn(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.nMV = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.nMW = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.nMW.a(new VideoPlayFragment.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.VideoPlayFragment.a
            public void onStart() {
                VideoPlayView.this.dXC();
            }
        });
        dXB();
        this.nMW.mFromPage = this.mFrom;
        this.nMV.setAdapter(this.nMW);
        this.nMV.setOffscreenPageLimit(1);
        this.nMV.setEventListener(new a.InterfaceC0617a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0617a
            public void bJY() {
                VideoPlayFragment Mt = VideoPlayView.this.nMW.Mt(VideoPlayView.this.nMV.getCurrentItem());
                if (Mt != null) {
                    Mt.bJY();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0617a
            public void y(float f, float f2) {
                VideoPlayFragment Mt = VideoPlayView.this.nMW.Mt(VideoPlayView.this.nMV.getCurrentItem());
                if (Mt != null) {
                    Mt.y(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0617a
            public void bJZ() {
                VideoPlayFragment Mt = VideoPlayView.this.nMW.Mt(VideoPlayView.this.nMV.getCurrentItem());
                if (Mt != null) {
                    Mt.bJZ();
                }
            }
        });
        this.nMV.setOnPageChangeListener(this);
        this.nMV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment Mt = VideoPlayView.this.nMW.Mt(VideoPlayView.this.nMV.getCurrentItem());
                if (Mt != null) {
                    return Mt.dXx();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.nNb = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.nNb.setAnimation(R.raw.lottie_video_guide);
        this.nNb.setImageAssetsFolder("lottie_video_guide");
        this.nNb.setOnClickListener(this);
        this.nNb.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.nNb.isAnimating()) {
                    VideoPlayView.this.aY(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nNb.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.dXE();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.cwe();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nNd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        cwe();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.nMY = i;
        this.nMW.a(this.mDatas, rect);
        this.nMW.notifyDataSetChanged();
        this.nMV.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.nMW != null) {
            this.nMW.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.nMZ = aVar;
    }

    public void Vm(String str) {
        if (this.nMW != null) {
            this.nMW.mFrom = str;
        }
    }

    public void onDestroy() {
        cwe();
        dXF();
        if (this.nMW != null) {
            this.nMW.dXA();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.nMX = i;
        if (this.nMY != i && this.nNe) {
            this.nNe = false;
        }
        if (!y.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.nMZ != null) {
            this.nMZ.bWF();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.nMW != null && this.nMV != null) {
            this.nMW.Mu(this.nMV.getCurrentItem());
        }
    }

    public boolean dXx() {
        VideoPlayFragment Mt;
        if (dXG()) {
            return true;
        }
        if (this.nMW == null || this.nMV == null || (Mt = this.nMW.Mt(this.nMV.getCurrentItem())) == null) {
            return false;
        }
        return Mt.dXx();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment Mt;
        if (this.nMW != null && this.nMV != null && (Mt = this.nMW.Mt(this.nMV.getCurrentItem())) != null) {
            Mt.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            cwe();
        }
    }

    private void dXB() {
        this.nMW.a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.f.b
            public void ci(int i, int i2) {
                VideoPlayView.this.dI(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.nNd * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.nMV.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.nNd * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.nMV.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.nNd * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.nMV.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.nNd * (0.92d - f) * 6.0d) : 0;
        }
        this.nMV.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXC() {
        if (this.nMX == this.nMY && this.nNe) {
            yV(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dI(int i, int i2) {
        int i3;
        if (!this.nNf && VideoPlayActivityConfig.FROM_DEFAULT.equals(Vo(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.nNe && i.dTQ()) {
            yV(true);
            this.nNf = true;
            i.dTR();
        }
    }

    private void dXD() {
        this.nMV.scrollTo(0, 0);
    }

    private boolean yV(boolean z) {
        if (this.nNb == null) {
            return false;
        }
        if (this.nNc || z) {
            this.nNb.setVisibility(0);
            this.nNb.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwe() {
        if (this.nNb != null) {
            if (this.nNb.isAnimating()) {
                this.nNb.pauseAnimation();
                dXD();
            }
            this.nNb.setVisibility(8);
        }
    }

    private boolean Vn(String str) {
        return b.bsO().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Vo(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXE() {
        if (this.nNc) {
            b.bsO().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Vo(this.mFrom), false);
            this.nNc = false;
        }
    }

    private String Vo(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void Vp(String str) {
        if (this.nMW != null) {
            this.nMW.nMO = str;
        }
    }

    private void dXF() {
        if (this.nNf) {
            i.dTT();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Vo(this.mFrom))) {
            if (this.nNe) {
                i.dTS();
            } else {
                i.dTT();
            }
        }
    }

    private boolean dXG() {
        if (this.nNb == null || !this.nNb.isAnimating()) {
            return false;
        }
        cwe();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201, i);
    }
}
