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
    private VerticalViewPager mFG;
    private VideoPlayFragmentAdapter mFH;
    public int mFJ;
    private a mFK;
    private VideoPlayActivity mFL;
    private TBLottieAnimationView mFM;
    private boolean mFN;
    private int mFO;
    private String mFrom;
    private View mRootView;
    public int mFI = 0;
    private boolean mFP = true;
    private boolean mFQ = false;

    /* loaded from: classes18.dex */
    public interface a {
        void bKC();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.mFL = videoPlayActivity;
        this.mFrom = str;
        this.mFN = Sj(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.mFG = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.mFH = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.mFH.a(new VideoPlayFragment.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.VideoPlayFragment.a
            public void onStart() {
                VideoPlayView.this.dEJ();
            }
        });
        dEI();
        this.mFH.mFromPage = this.mFrom;
        this.mFG.setAdapter(this.mFH);
        this.mFG.setOffscreenPageLimit(1);
        this.mFG.setEventListener(new a.InterfaceC0566a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0566a
            public void byT() {
                VideoPlayFragment Jj = VideoPlayView.this.mFH.Jj(VideoPlayView.this.mFG.getCurrentItem());
                if (Jj != null) {
                    Jj.byT();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0566a
            public void x(float f, float f2) {
                VideoPlayFragment Jj = VideoPlayView.this.mFH.Jj(VideoPlayView.this.mFG.getCurrentItem());
                if (Jj != null) {
                    Jj.x(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0566a
            public void byU() {
                VideoPlayFragment Jj = VideoPlayView.this.mFH.Jj(VideoPlayView.this.mFG.getCurrentItem());
                if (Jj != null) {
                    Jj.byU();
                }
            }
        });
        this.mFG.setOnPageChangeListener(this);
        this.mFG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment Jj = VideoPlayView.this.mFH.Jj(VideoPlayView.this.mFG.getCurrentItem());
                if (Jj != null) {
                    return Jj.dEE();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.mFM = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.mFM.setAnimation(R.raw.lottie_video_guide);
        this.mFM.setImageAssetsFolder("lottie_video_guide");
        this.mFM.setOnClickListener(this);
        this.mFM.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.mFM.isAnimating()) {
                    VideoPlayView.this.aG(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.mFM.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.dEL();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.cfP();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mFO = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        cfP();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.mFJ = i;
        this.mFH.a(this.mDatas, rect);
        this.mFH.notifyDataSetChanged();
        this.mFG.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.mFH != null) {
            this.mFH.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.mFK = aVar;
    }

    public void Si(String str) {
        if (this.mFH != null) {
            this.mFH.mFrom = str;
        }
    }

    public void onDestroy() {
        cfP();
        dEM();
        if (this.mFH != null) {
            this.mFH.dEH();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mFI = i;
        if (this.mFJ != i && this.mFP) {
            this.mFP = false;
        }
        if (!y.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.mFK != null) {
            this.mFK.bKC();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.mFH != null && this.mFG != null) {
            this.mFH.Jk(this.mFG.getCurrentItem());
        }
    }

    public boolean dEE() {
        VideoPlayFragment Jj;
        if (dEN()) {
            return true;
        }
        if (this.mFH == null || this.mFG == null || (Jj = this.mFH.Jj(this.mFG.getCurrentItem())) == null) {
            return false;
        }
        return Jj.dEE();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment Jj;
        if (this.mFH != null && this.mFG != null && (Jj = this.mFH.Jj(this.mFG.getCurrentItem())) != null) {
            Jj.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            cfP();
        }
    }

    private void dEI() {
        this.mFH.a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
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
            i = (int) (this.mFO * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.mFG.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.mFO * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.mFG.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.mFO * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.mFG.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.mFO * (0.92d - f) * 6.0d) : 0;
        }
        this.mFG.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEJ() {
        if (this.mFI == this.mFJ && this.mFP) {
            wR(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void du(int i, int i2) {
        int i3;
        if (!this.mFQ && VideoPlayActivityConfig.FROM_DEFAULT.equals(Sk(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.mFP && i.dAZ()) {
            wR(true);
            this.mFQ = true;
            i.dBa();
        }
    }

    private void dEK() {
        this.mFG.scrollTo(0, 0);
    }

    private boolean wR(boolean z) {
        if (this.mFM == null) {
            return false;
        }
        if (this.mFN || z) {
            this.mFM.setVisibility(0);
            this.mFM.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfP() {
        if (this.mFM != null) {
            if (this.mFM.isAnimating()) {
                this.mFM.pauseAnimation();
                dEK();
            }
            this.mFM.setVisibility(8);
        }
    }

    private boolean Sj(String str) {
        return b.bik().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Sk(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEL() {
        if (this.mFN) {
            b.bik().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Sk(this.mFrom), false);
            this.mFN = false;
        }
    }

    private String Sk(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void Sl(String str) {
        if (this.mFH != null) {
            this.mFH.mFz = str;
        }
    }

    private void dEM() {
        if (this.mFQ) {
            i.dBc();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Sk(this.mFrom))) {
            if (this.mFP) {
                i.dBb();
            } else {
                i.dBc();
            }
        }
    }

    private boolean dEN() {
        if (this.mFM == null || !this.mFM.isAnimating()) {
            return false;
        }
        cfP();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
