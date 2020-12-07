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
    private VerticalViewPager nMT;
    private VideoPlayFragmentAdapter nMU;
    public int nMW;
    private a nMX;
    private VideoPlayActivity nMY;
    private TBLottieAnimationView nMZ;
    private boolean nNa;
    private int nNb;
    public int nMV = 0;
    private boolean nNc = true;
    private boolean nNd = false;

    /* loaded from: classes24.dex */
    public interface a {
        void bWE();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.nMY = videoPlayActivity;
        this.mFrom = str;
        this.nNa = Vn(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.nMT = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.nMU = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.nMU.a(new VideoPlayFragment.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.VideoPlayFragment.a
            public void onStart() {
                VideoPlayView.this.dXB();
            }
        });
        dXA();
        this.nMU.mFromPage = this.mFrom;
        this.nMT.setAdapter(this.nMU);
        this.nMT.setOffscreenPageLimit(1);
        this.nMT.setEventListener(new a.InterfaceC0617a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0617a
            public void bJY() {
                VideoPlayFragment Mt = VideoPlayView.this.nMU.Mt(VideoPlayView.this.nMT.getCurrentItem());
                if (Mt != null) {
                    Mt.bJY();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0617a
            public void y(float f, float f2) {
                VideoPlayFragment Mt = VideoPlayView.this.nMU.Mt(VideoPlayView.this.nMT.getCurrentItem());
                if (Mt != null) {
                    Mt.y(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0617a
            public void bJZ() {
                VideoPlayFragment Mt = VideoPlayView.this.nMU.Mt(VideoPlayView.this.nMT.getCurrentItem());
                if (Mt != null) {
                    Mt.bJZ();
                }
            }
        });
        this.nMT.setOnPageChangeListener(this);
        this.nMT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment Mt = VideoPlayView.this.nMU.Mt(VideoPlayView.this.nMT.getCurrentItem());
                if (Mt != null) {
                    return Mt.dXw();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.nMZ = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.nMZ.setAnimation(R.raw.lottie_video_guide);
        this.nMZ.setImageAssetsFolder("lottie_video_guide");
        this.nMZ.setOnClickListener(this);
        this.nMZ.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.nMZ.isAnimating()) {
                    VideoPlayView.this.aY(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nMZ.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.dXD();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.cwd();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nNb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        cwd();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.nMW = i;
        this.nMU.a(this.mDatas, rect);
        this.nMU.notifyDataSetChanged();
        this.nMT.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.nMU != null) {
            this.nMU.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.nMX = aVar;
    }

    public void Vm(String str) {
        if (this.nMU != null) {
            this.nMU.mFrom = str;
        }
    }

    public void onDestroy() {
        cwd();
        dXE();
        if (this.nMU != null) {
            this.nMU.dXz();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.nMV = i;
        if (this.nMW != i && this.nNc) {
            this.nNc = false;
        }
        if (!y.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.nMX != null) {
            this.nMX.bWE();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.nMU != null && this.nMT != null) {
            this.nMU.Mu(this.nMT.getCurrentItem());
        }
    }

    public boolean dXw() {
        VideoPlayFragment Mt;
        if (dXF()) {
            return true;
        }
        if (this.nMU == null || this.nMT == null || (Mt = this.nMU.Mt(this.nMT.getCurrentItem())) == null) {
            return false;
        }
        return Mt.dXw();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment Mt;
        if (this.nMU != null && this.nMT != null && (Mt = this.nMU.Mt(this.nMT.getCurrentItem())) != null) {
            Mt.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            cwd();
        }
    }

    private void dXA() {
        this.nMU.a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
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
            i = (int) (this.nNb * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.nMT.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.nNb * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.nMT.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.nNb * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.nMT.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.nNb * (0.92d - f) * 6.0d) : 0;
        }
        this.nMT.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXB() {
        if (this.nMV == this.nMW && this.nNc) {
            yV(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dI(int i, int i2) {
        int i3;
        if (!this.nNd && VideoPlayActivityConfig.FROM_DEFAULT.equals(Vo(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.nNc && i.dTP()) {
            yV(true);
            this.nNd = true;
            i.dTQ();
        }
    }

    private void dXC() {
        this.nMT.scrollTo(0, 0);
    }

    private boolean yV(boolean z) {
        if (this.nMZ == null) {
            return false;
        }
        if (this.nNa || z) {
            this.nMZ.setVisibility(0);
            this.nMZ.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwd() {
        if (this.nMZ != null) {
            if (this.nMZ.isAnimating()) {
                this.nMZ.pauseAnimation();
                dXC();
            }
            this.nMZ.setVisibility(8);
        }
    }

    private boolean Vn(String str) {
        return b.bsO().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Vo(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXD() {
        if (this.nNa) {
            b.bsO().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Vo(this.mFrom), false);
            this.nNa = false;
        }
    }

    private String Vo(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void Vp(String str) {
        if (this.nMU != null) {
            this.nMU.nMM = str;
        }
    }

    private void dXE() {
        if (this.nNd) {
            i.dTS();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Vo(this.mFrom))) {
            if (this.nNc) {
                i.dTR();
            } else {
                i.dTS();
            }
        }
    }

    private boolean dXF() {
        if (this.nMZ == null || !this.nMZ.isAnimating()) {
            return false;
        }
        cwd();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201, i);
    }
}
