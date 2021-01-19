package com.baidu.tieba.videoplay;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.viewpager.VerticalViewPager;
import com.baidu.tbadk.widget.viewpager.a;
import com.baidu.tieba.R;
import com.baidu.tieba.play.f;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.h;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import java.util.List;
/* loaded from: classes7.dex */
public class VideoPlayView implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    private VerticalViewPager nLL;
    private VideoPlayFragmentAdapter nLM;
    public int nLO;
    private a nLP;
    private VideoPlayActivity nLQ;
    private TBLottieAnimationView nLR;
    private boolean nLS;
    private int nLT;
    public int nLN = 0;
    private boolean nLU = true;
    private boolean nLV = false;

    /* loaded from: classes7.dex */
    public interface a {
        void bVt();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.nLQ = videoPlayActivity;
        this.mFrom = str;
        this.nLS = TK(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.nLL = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.nLM = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.nLM.a(new VideoPlayFragment.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.VideoPlayFragment.a
            public void onStart() {
                VideoPlayView.this.dTo();
            }
        });
        dTn();
        this.nLM.mFromPage = this.mFrom;
        this.nLL.setAdapter(this.nLM);
        this.nLL.setOffscreenPageLimit(1);
        this.nLL.setEventListener(new a.InterfaceC0591a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0591a
            public void bIz() {
                VideoPlayFragment Kz = VideoPlayView.this.nLM.Kz(VideoPlayView.this.nLL.getCurrentItem());
                if (Kz != null) {
                    Kz.bIz();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0591a
            public void z(float f, float f2) {
                VideoPlayFragment Kz = VideoPlayView.this.nLM.Kz(VideoPlayView.this.nLL.getCurrentItem());
                if (Kz != null) {
                    Kz.z(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0591a
            public void bIA() {
                VideoPlayFragment Kz = VideoPlayView.this.nLM.Kz(VideoPlayView.this.nLL.getCurrentItem());
                if (Kz != null) {
                    Kz.bIA();
                }
            }
        });
        this.nLL.setOnPageChangeListener(this);
        this.nLL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment Kz = VideoPlayView.this.nLM.Kz(VideoPlayView.this.nLL.getCurrentItem());
                if (Kz != null) {
                    return Kz.dTj();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.nLR = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.nLR.setAnimation(R.raw.lottie_video_guide);
        this.nLR.setImageAssetsFolder("lottie_video_guide");
        this.nLR.setOnClickListener(this);
        this.nLR.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.nLR.isAnimating()) {
                    VideoPlayView.this.ba(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nLR.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.dTq();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.cvg();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nLT = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        cvg();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.nLO = i;
        this.nLM.a(this.mDatas, rect);
        this.nLM.notifyDataSetChanged();
        this.nLL.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.nLM != null) {
            this.nLM.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.nLP = aVar;
    }

    public void TJ(String str) {
        if (this.nLM != null) {
            this.nLM.mFrom = str;
        }
    }

    public void onDestroy() {
        cvg();
        dTr();
        if (this.nLM != null) {
            this.nLM.dTm();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.nLN = i;
        if (this.nLO != i && this.nLU) {
            this.nLU = false;
        }
        if (!x.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.nLP != null) {
            this.nLP.bVt();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.nLM != null && this.nLL != null) {
            this.nLM.KA(this.nLL.getCurrentItem());
        }
    }

    public boolean dTj() {
        VideoPlayFragment Kz;
        if (dTs()) {
            return true;
        }
        if (this.nLM == null || this.nLL == null || (Kz = this.nLM.Kz(this.nLL.getCurrentItem())) == null) {
            return false;
        }
        return Kz.dTj();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment Kz;
        if (this.nLM != null && this.nLL != null && (Kz = this.nLM.Kz(this.nLL.getCurrentItem())) != null) {
            Kz.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            cvg();
        }
    }

    private void dTn() {
        this.nLM.a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.f.b
            public void ch(int i, int i2) {
                VideoPlayView.this.dD(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.nLT * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.nLL.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.nLT * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.nLL.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.nLT * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.nLL.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.nLT * (0.92d - f) * 6.0d) : 0;
        }
        this.nLL.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTo() {
        if (this.nLN == this.nLO && this.nLU) {
            yR(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(int i, int i2) {
        int i3;
        if (!this.nLV && VideoPlayActivityConfig.FROM_DEFAULT.equals(TL(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.nLU && h.dPQ()) {
            yR(true);
            this.nLV = true;
            h.dPR();
        }
    }

    private void dTp() {
        this.nLL.scrollTo(0, 0);
    }

    private boolean yR(boolean z) {
        if (this.nLR == null) {
            return false;
        }
        if (this.nLS || z) {
            this.nLR.setVisibility(0);
            this.nLR.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvg() {
        if (this.nLR != null) {
            if (this.nLR.isAnimating()) {
                this.nLR.pauseAnimation();
                dTp();
            }
            this.nLR.setVisibility(8);
        }
    }

    private boolean TK(String str) {
        return b.brx().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + TL(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTq() {
        if (this.nLS) {
            b.brx().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + TL(this.mFrom), false);
            this.nLS = false;
        }
    }

    private String TL(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void TM(String str) {
        if (this.nLM != null) {
            this.nLM.nLE = str;
        }
    }

    private void dTr() {
        if (this.nLV) {
            h.dPT();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(TL(this.mFrom))) {
            if (this.nLU) {
                h.dPS();
            } else {
                h.dPT();
            }
        }
    }

    private boolean dTs() {
        if (this.nLR == null || !this.nLR.isAnimating()) {
            return false;
        }
        cvg();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201, i);
    }
}
