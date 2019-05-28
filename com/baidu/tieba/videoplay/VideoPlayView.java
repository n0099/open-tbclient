package com.baidu.tieba.videoplay;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.al;
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
    private VerticalViewPager jzp;
    private VideoPlayFragmentAdapter jzq;
    public int jzs;
    private a jzt;
    private VideoPlayActivity jzu;
    private TBLottieAnimationView jzv;
    private boolean jzw;
    private int jzx;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int jzr = 0;
    private boolean jzy = true;
    private boolean jzz = false;

    /* loaded from: classes6.dex */
    public interface a {
        void cuw();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.jzu = videoPlayActivity;
        this.mFrom = str;
        this.jzw = Fv(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.jzp = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.jzq = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.jzq.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.cuL();
            }
        });
        cuK();
        this.jzq.dvf = this.mFrom;
        this.jzp.setAdapter(this.jzq);
        this.jzp.setOffscreenPageLimit(1);
        this.jzp.setEventListener(new a.InterfaceC0263a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0263a
            public void azb() {
                VideoPlayFragment BP = VideoPlayView.this.jzq.BP(VideoPlayView.this.jzp.getCurrentItem());
                if (BP != null) {
                    BP.azb();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0263a
            public void w(float f, float f2) {
                VideoPlayFragment BP = VideoPlayView.this.jzq.BP(VideoPlayView.this.jzp.getCurrentItem());
                if (BP != null) {
                    BP.w(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0263a
            public void azc() {
                VideoPlayFragment BP = VideoPlayView.this.jzq.BP(VideoPlayView.this.jzp.getCurrentItem());
                if (BP != null) {
                    BP.azc();
                }
            }
        });
        this.jzp.setOnPageChangeListener(this);
        this.jzp.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment BP = VideoPlayView.this.jzq.BP(VideoPlayView.this.jzp.getCurrentItem());
                if (BP != null) {
                    return BP.cuI();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.jzv = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.jzv.setAnimation(R.raw.lottie_video_guide);
        this.jzv.setImageAssetsFolder("lottie_video_guide");
        this.jzv.setOnClickListener(this);
        this.jzv.a(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.jzv.isAnimating()) {
                    VideoPlayView.this.aU(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jzv.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.cuN();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.bed();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jzx = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        bed();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.jzs = i;
        this.jzq.a(this.mDatas, rect);
        this.jzq.notifyDataSetChanged();
        this.jzp.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.jzq != null) {
            this.jzq.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.jzt = aVar;
    }

    public void Fu(String str) {
        if (this.jzq != null) {
            this.jzq.mFrom = str;
        }
    }

    public void onDestroy() {
        bed();
        cuO();
        if (this.jzq != null) {
            this.jzq.cuJ();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.jzr = i;
        if (this.jzs != i && this.jzy) {
            this.jzy = false;
        }
        if (!v.aa(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.jzt != null) {
            this.jzt.cuw();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.jzq != null && this.jzp != null) {
            this.jzq.BQ(this.jzp.getCurrentItem());
        }
    }

    public boolean cuI() {
        VideoPlayFragment BP;
        if (cuP()) {
            return true;
        }
        if (this.jzq == null || this.jzp == null || (BP = this.jzq.BP(this.jzp.getCurrentItem())) == null) {
            return false;
        }
        return BP.cuI();
    }

    public void a(int i, int i2, Intent intent) {
        VideoPlayFragment BP;
        if (this.jzq != null && this.jzp != null && (BP = this.jzq.BP(this.jzp.getCurrentItem())) != null) {
            BP.a(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            bed();
        }
    }

    private void cuK() {
        this.jzq.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.j.b
            public void bc(int i, int i2) {
                VideoPlayView.this.cE(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.jzx * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.jzp.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.jzx * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.jzp.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.jzx * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.jzp.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.jzx * (0.92d - f) * 6.0d) : 0;
        }
        this.jzp.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuL() {
        if (this.jzr == this.jzs && this.jzy) {
            rD(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cE(int i, int i2) {
        int i3;
        if (!this.jzz && VideoPlayActivityConfig.FROM_DEFAULT.equals(Fw(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.jzy && i.cqW()) {
            rD(true);
            this.jzz = true;
            i.cqX();
        }
    }

    private void cuM() {
        this.jzp.scrollTo(0, 0);
    }

    private boolean rD(boolean z) {
        if (this.jzv == null) {
            return false;
        }
        if (this.jzw || z) {
            this.jzv.setVisibility(0);
            this.jzv.bo();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bed() {
        if (this.jzv != null) {
            if (this.jzv.isAnimating()) {
                this.jzv.bq();
                cuM();
            }
            this.jzv.setVisibility(8);
        }
    }

    private boolean Fv(String str) {
        return b.agM().getBoolean("video_play_vertical_first_in" + Fw(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuN() {
        if (this.jzw) {
            b.agM().putBoolean("video_play_vertical_first_in" + Fw(this.mFrom), false);
            this.jzw = false;
        }
    }

    private String Fw(String str) {
        if (!VideoPlayActivityConfig.FROM_MAINTAB_VIDEO.equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return VideoPlayActivityConfig.FROM_MAINTAB_VIDEO;
    }

    public void Fx(String str) {
        if (this.jzq != null) {
            this.jzq.jzi = str;
        }
    }

    private void cuO() {
        if (this.jzz) {
            i.cqZ();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Fw(this.mFrom))) {
            if (this.jzy) {
                i.cqY();
            } else {
                i.cqZ();
            }
        }
    }

    private boolean cuP() {
        if (this.jzv == null || !this.jzv.isAnimating()) {
            return false;
        }
        bed();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        al.h(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
