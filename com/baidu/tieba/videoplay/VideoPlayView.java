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
/* loaded from: classes18.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private List<VideoItemData> mDatas;
    private VerticalViewPager mFY;
    private VideoPlayFragmentAdapter mFZ;
    private String mFrom;
    public int mGb;
    private a mGc;
    private VideoPlayActivity mGd;
    private TBLottieAnimationView mGe;
    private boolean mGf;
    private int mGg;
    private View mRootView;
    public int mGa = 0;
    private boolean mGh = true;
    private boolean mGi = false;

    /* loaded from: classes18.dex */
    public interface a {
        void bKD();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.mGd = videoPlayActivity;
        this.mFrom = str;
        this.mGf = Sj(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.mFY = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.mFZ = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.mFZ.a(new VideoPlayFragment.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.VideoPlayFragment.a
            public void onStart() {
                VideoPlayView.this.dES();
            }
        });
        dER();
        this.mFZ.mFromPage = this.mFrom;
        this.mFY.setAdapter(this.mFZ);
        this.mFY.setOffscreenPageLimit(1);
        this.mFY.setEventListener(new a.InterfaceC0566a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0566a
            public void byU() {
                VideoPlayFragment Jj = VideoPlayView.this.mFZ.Jj(VideoPlayView.this.mFY.getCurrentItem());
                if (Jj != null) {
                    Jj.byU();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0566a
            public void x(float f, float f2) {
                VideoPlayFragment Jj = VideoPlayView.this.mFZ.Jj(VideoPlayView.this.mFY.getCurrentItem());
                if (Jj != null) {
                    Jj.x(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0566a
            public void byV() {
                VideoPlayFragment Jj = VideoPlayView.this.mFZ.Jj(VideoPlayView.this.mFY.getCurrentItem());
                if (Jj != null) {
                    Jj.byV();
                }
            }
        });
        this.mFY.setOnPageChangeListener(this);
        this.mFY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment Jj = VideoPlayView.this.mFZ.Jj(VideoPlayView.this.mFY.getCurrentItem());
                if (Jj != null) {
                    return Jj.dEN();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.mGe = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.mGe.setAnimation(R.raw.lottie_video_guide);
        this.mGe.setImageAssetsFolder("lottie_video_guide");
        this.mGe.setOnClickListener(this);
        this.mGe.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.mGe.isAnimating()) {
                    VideoPlayView.this.aG(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.mGe.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.dEU();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.cfQ();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mGg = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        cfQ();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.mGb = i;
        this.mFZ.a(this.mDatas, rect);
        this.mFZ.notifyDataSetChanged();
        this.mFY.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.mFZ != null) {
            this.mFZ.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.mGc = aVar;
    }

    public void Si(String str) {
        if (this.mFZ != null) {
            this.mFZ.mFrom = str;
        }
    }

    public void onDestroy() {
        cfQ();
        dEV();
        if (this.mFZ != null) {
            this.mFZ.dEQ();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mGa = i;
        if (this.mGb != i && this.mGh) {
            this.mGh = false;
        }
        if (!y.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.mGc != null) {
            this.mGc.bKD();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.mFZ != null && this.mFY != null) {
            this.mFZ.Jk(this.mFY.getCurrentItem());
        }
    }

    public boolean dEN() {
        VideoPlayFragment Jj;
        if (dEW()) {
            return true;
        }
        if (this.mFZ == null || this.mFY == null || (Jj = this.mFZ.Jj(this.mFY.getCurrentItem())) == null) {
            return false;
        }
        return Jj.dEN();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment Jj;
        if (this.mFZ != null && this.mFY != null && (Jj = this.mFZ.Jj(this.mFY.getCurrentItem())) != null) {
            Jj.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            cfQ();
        }
    }

    private void dER() {
        this.mFZ.a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.f.b
            public void bX(int i, int i2) {
                VideoPlayView.this.du(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.mGg * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.mFY.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.mGg * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.mFY.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.mGg * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.mFY.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.mGg * (0.92d - f) * 6.0d) : 0;
        }
        this.mFY.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dES() {
        if (this.mGa == this.mGb && this.mGh) {
            wT(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void du(int i, int i2) {
        int i3;
        if (!this.mGi && VideoPlayActivityConfig.FROM_DEFAULT.equals(Sk(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.mGh && i.dBi()) {
            wT(true);
            this.mGi = true;
            i.dBj();
        }
    }

    private void dET() {
        this.mFY.scrollTo(0, 0);
    }

    private boolean wT(boolean z) {
        if (this.mGe == null) {
            return false;
        }
        if (this.mGf || z) {
            this.mGe.setVisibility(0);
            this.mGe.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfQ() {
        if (this.mGe != null) {
            if (this.mGe.isAnimating()) {
                this.mGe.pauseAnimation();
                dET();
            }
            this.mGe.setVisibility(8);
        }
    }

    private boolean Sj(String str) {
        return b.bik().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Sk(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEU() {
        if (this.mGf) {
            b.bik().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Sk(this.mFrom), false);
            this.mGf = false;
        }
    }

    private String Sk(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void Sl(String str) {
        if (this.mFZ != null) {
            this.mFZ.mFR = str;
        }
    }

    private void dEV() {
        if (this.mGi) {
            i.dBl();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Sk(this.mFrom))) {
            if (this.mGh) {
                i.dBk();
            } else {
                i.dBl();
            }
        }
    }

    private boolean dEW() {
        if (this.mGe == null || !this.mGe.isAnimating()) {
            return false;
        }
        cfQ();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
