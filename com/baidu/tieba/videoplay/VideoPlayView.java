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
    private VerticalViewPager nLK;
    private VideoPlayFragmentAdapter nLL;
    public int nLN;
    private a nLO;
    private VideoPlayActivity nLP;
    private TBLottieAnimationView nLQ;
    private boolean nLR;
    private int nLS;
    public int nLM = 0;
    private boolean nLT = true;
    private boolean nLU = false;

    /* loaded from: classes7.dex */
    public interface a {
        void bVt();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.nLP = videoPlayActivity;
        this.mFrom = str;
        this.nLR = TJ(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.nLK = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.nLL = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.nLL.a(new VideoPlayFragment.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.VideoPlayFragment.a
            public void onStart() {
                VideoPlayView.this.dTo();
            }
        });
        dTn();
        this.nLL.mFromPage = this.mFrom;
        this.nLK.setAdapter(this.nLL);
        this.nLK.setOffscreenPageLimit(1);
        this.nLK.setEventListener(new a.InterfaceC0591a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0591a
            public void bIz() {
                VideoPlayFragment Kz = VideoPlayView.this.nLL.Kz(VideoPlayView.this.nLK.getCurrentItem());
                if (Kz != null) {
                    Kz.bIz();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0591a
            public void z(float f, float f2) {
                VideoPlayFragment Kz = VideoPlayView.this.nLL.Kz(VideoPlayView.this.nLK.getCurrentItem());
                if (Kz != null) {
                    Kz.z(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0591a
            public void bIA() {
                VideoPlayFragment Kz = VideoPlayView.this.nLL.Kz(VideoPlayView.this.nLK.getCurrentItem());
                if (Kz != null) {
                    Kz.bIA();
                }
            }
        });
        this.nLK.setOnPageChangeListener(this);
        this.nLK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment Kz = VideoPlayView.this.nLL.Kz(VideoPlayView.this.nLK.getCurrentItem());
                if (Kz != null) {
                    return Kz.dTj();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.nLQ = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.nLQ.setAnimation(R.raw.lottie_video_guide);
        this.nLQ.setImageAssetsFolder("lottie_video_guide");
        this.nLQ.setOnClickListener(this);
        this.nLQ.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.nLQ.isAnimating()) {
                    VideoPlayView.this.ba(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nLQ.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
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
        this.nLS = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        cvg();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.nLN = i;
        this.nLL.a(this.mDatas, rect);
        this.nLL.notifyDataSetChanged();
        this.nLK.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.nLL != null) {
            this.nLL.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.nLO = aVar;
    }

    public void TI(String str) {
        if (this.nLL != null) {
            this.nLL.mFrom = str;
        }
    }

    public void onDestroy() {
        cvg();
        dTr();
        if (this.nLL != null) {
            this.nLL.dTm();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.nLM = i;
        if (this.nLN != i && this.nLT) {
            this.nLT = false;
        }
        if (!x.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.nLO != null) {
            this.nLO.bVt();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.nLL != null && this.nLK != null) {
            this.nLL.KA(this.nLK.getCurrentItem());
        }
    }

    public boolean dTj() {
        VideoPlayFragment Kz;
        if (dTs()) {
            return true;
        }
        if (this.nLL == null || this.nLK == null || (Kz = this.nLL.Kz(this.nLK.getCurrentItem())) == null) {
            return false;
        }
        return Kz.dTj();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment Kz;
        if (this.nLL != null && this.nLK != null && (Kz = this.nLL.Kz(this.nLK.getCurrentItem())) != null) {
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
        this.nLL.a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
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
            i = (int) (this.nLS * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.nLK.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.nLS * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.nLK.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.nLS * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.nLK.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.nLS * (0.92d - f) * 6.0d) : 0;
        }
        this.nLK.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTo() {
        if (this.nLM == this.nLN && this.nLT) {
            yR(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(int i, int i2) {
        int i3;
        if (!this.nLU && VideoPlayActivityConfig.FROM_DEFAULT.equals(TK(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.nLT && h.dPQ()) {
            yR(true);
            this.nLU = true;
            h.dPR();
        }
    }

    private void dTp() {
        this.nLK.scrollTo(0, 0);
    }

    private boolean yR(boolean z) {
        if (this.nLQ == null) {
            return false;
        }
        if (this.nLR || z) {
            this.nLQ.setVisibility(0);
            this.nLQ.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvg() {
        if (this.nLQ != null) {
            if (this.nLQ.isAnimating()) {
                this.nLQ.pauseAnimation();
                dTp();
            }
            this.nLQ.setVisibility(8);
        }
    }

    private boolean TJ(String str) {
        return b.brx().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + TK(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dTq() {
        if (this.nLR) {
            b.brx().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + TK(this.mFrom), false);
            this.nLR = false;
        }
    }

    private String TK(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void TL(String str) {
        if (this.nLL != null) {
            this.nLL.nLD = str;
        }
    }

    private void dTr() {
        if (this.nLU) {
            h.dPT();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(TK(this.mFrom))) {
            if (this.nLT) {
                h.dPS();
            } else {
                h.dPT();
            }
        }
    }

    private boolean dTs() {
        if (this.nLQ == null || !this.nLQ.isAnimating()) {
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
