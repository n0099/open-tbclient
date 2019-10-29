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
/* loaded from: classes6.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private VerticalViewPager jIV;
    private VideoPlayFragmentAdapter jIW;
    public int jIY;
    private a jIZ;
    private VideoPlayActivity jJa;
    private TBLottieAnimationView jJb;
    private boolean jJc;
    private int jJd;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int jIX = 0;
    private boolean jJe = true;
    private boolean jJf = false;

    /* loaded from: classes6.dex */
    public interface a {
        void aLX();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.jJa = videoPlayActivity;
        this.mFrom = str;
        this.jJc = Fp(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.jIV = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.jIW = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.jIW.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.cwy();
            }
        });
        cwx();
        this.jIW.hcu = this.mFrom;
        this.jIV.setAdapter(this.jIW);
        this.jIV.setOffscreenPageLimit(1);
        this.jIV.setEventListener(new a.InterfaceC0306a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0306a
            public void aAM() {
                VideoPlayFragment Bi = VideoPlayView.this.jIW.Bi(VideoPlayView.this.jIV.getCurrentItem());
                if (Bi != null) {
                    Bi.aAM();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0306a
            public void s(float f, float f2) {
                VideoPlayFragment Bi = VideoPlayView.this.jIW.Bi(VideoPlayView.this.jIV.getCurrentItem());
                if (Bi != null) {
                    Bi.s(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0306a
            public void aAN() {
                VideoPlayFragment Bi = VideoPlayView.this.jIW.Bi(VideoPlayView.this.jIV.getCurrentItem());
                if (Bi != null) {
                    Bi.aAN();
                }
            }
        });
        this.jIV.setOnPageChangeListener(this);
        this.jIV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment Bi = VideoPlayView.this.jIW.Bi(VideoPlayView.this.jIV.getCurrentItem());
                if (Bi != null) {
                    return Bi.cwv();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.jJb = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.jJb.setAnimation(R.raw.lottie_video_guide);
        this.jJb.setImageAssetsFolder("lottie_video_guide");
        this.jJb.setOnClickListener(this);
        this.jJb.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.jJb.isAnimating()) {
                    VideoPlayView.this.az(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jJb.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.cwA();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.beI();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jJd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        beI();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.jIY = i;
        this.jIW.a(this.mDatas, rect);
        this.jIW.notifyDataSetChanged();
        this.jIV.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.jIW != null) {
            this.jIW.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.jIZ = aVar;
    }

    public void Fo(String str) {
        if (this.jIW != null) {
            this.jIW.mFrom = str;
        }
    }

    public void onDestroy() {
        beI();
        cwB();
        if (this.jIW != null) {
            this.jIW.cww();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.jIX = i;
        if (this.jIY != i && this.jJe) {
            this.jJe = false;
        }
        if (!v.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.jIZ != null) {
            this.jIZ.aLX();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.jIW != null && this.jIV != null) {
            this.jIW.Bj(this.jIV.getCurrentItem());
        }
    }

    public boolean cwv() {
        VideoPlayFragment Bi;
        if (cwC()) {
            return true;
        }
        if (this.jIW == null || this.jIV == null || (Bi = this.jIW.Bi(this.jIV.getCurrentItem())) == null) {
            return false;
        }
        return Bi.cwv();
    }

    public void b(int i, int i2, Intent intent) {
        VideoPlayFragment Bi;
        if (this.jIW != null && this.jIV != null && (Bi = this.jIW.Bi(this.jIV.getCurrentItem())) != null) {
            Bi.b(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            beI();
        }
    }

    private void cwx() {
        this.jIW.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.j.b
            public void bj(int i, int i2) {
                VideoPlayView.this.cB(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.jJd * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.jIV.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.jJd * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.jIV.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.jJd * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.jIV.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.jJd * (0.92d - f) * 6.0d) : 0;
        }
        this.jIV.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwy() {
        if (this.jIX == this.jIY && this.jJe) {
            rE(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(int i, int i2) {
        int i3;
        if (!this.jJf && VideoPlayActivityConfig.FROM_DEFAULT.equals(Fq(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.jJe && i.csH()) {
            rE(true);
            this.jJf = true;
            i.csI();
        }
    }

    private void cwz() {
        this.jIV.scrollTo(0, 0);
    }

    private boolean rE(boolean z) {
        if (this.jJb == null) {
            return false;
        }
        if (this.jJc || z) {
            this.jJb.setVisibility(0);
            this.jJb.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beI() {
        if (this.jJb != null) {
            if (this.jJb.isAnimating()) {
                this.jJb.pauseAnimation();
                cwz();
            }
            this.jJb.setVisibility(8);
        }
    }

    private boolean Fp(String str) {
        return b.alR().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Fq(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwA() {
        if (this.jJc) {
            b.alR().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Fq(this.mFrom), false);
            this.jJc = false;
        }
    }

    private String Fq(String str) {
        if (!VideoPlayActivityConfig.FROM_MAINTAB_VIDEO.equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return VideoPlayActivityConfig.FROM_MAINTAB_VIDEO;
    }

    public void Fr(String str) {
        if (this.jIW != null) {
            this.jIW.jIO = str;
        }
    }

    private void cwB() {
        if (this.jJf) {
            i.csK();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Fq(this.mFrom))) {
            if (this.jJe) {
                i.csJ();
            } else {
                i.csK();
            }
        }
    }

    private boolean cwC() {
        if (this.jJb == null || !this.jJb.isAnimating()) {
            return false;
        }
        beI();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
