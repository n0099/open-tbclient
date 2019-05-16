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
    private VerticalViewPager jzo;
    private VideoPlayFragmentAdapter jzp;
    public int jzr;
    private a jzs;
    private VideoPlayActivity jzt;
    private TBLottieAnimationView jzu;
    private boolean jzv;
    private int jzw;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int jzq = 0;
    private boolean jzx = true;
    private boolean jzy = false;

    /* loaded from: classes6.dex */
    public interface a {
        void cuu();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.jzt = videoPlayActivity;
        this.mFrom = str;
        this.jzv = Fv(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.jzo = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.jzp = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.jzp.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.cuJ();
            }
        });
        cuI();
        this.jzp.dve = this.mFrom;
        this.jzo.setAdapter(this.jzp);
        this.jzo.setOffscreenPageLimit(1);
        this.jzo.setEventListener(new a.InterfaceC0263a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0263a
            public void aza() {
                VideoPlayFragment BP = VideoPlayView.this.jzp.BP(VideoPlayView.this.jzo.getCurrentItem());
                if (BP != null) {
                    BP.aza();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0263a
            public void w(float f, float f2) {
                VideoPlayFragment BP = VideoPlayView.this.jzp.BP(VideoPlayView.this.jzo.getCurrentItem());
                if (BP != null) {
                    BP.w(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0263a
            public void azb() {
                VideoPlayFragment BP = VideoPlayView.this.jzp.BP(VideoPlayView.this.jzo.getCurrentItem());
                if (BP != null) {
                    BP.azb();
                }
            }
        });
        this.jzo.setOnPageChangeListener(this);
        this.jzo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment BP = VideoPlayView.this.jzp.BP(VideoPlayView.this.jzo.getCurrentItem());
                if (BP != null) {
                    return BP.cuG();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.jzu = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.jzu.setAnimation(R.raw.lottie_video_guide);
        this.jzu.setImageAssetsFolder("lottie_video_guide");
        this.jzu.setOnClickListener(this);
        this.jzu.a(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.jzu.isAnimating()) {
                    VideoPlayView.this.aU(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jzu.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.cuL();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.bea();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jzw = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        bea();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.jzr = i;
        this.jzp.a(this.mDatas, rect);
        this.jzp.notifyDataSetChanged();
        this.jzo.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.jzp != null) {
            this.jzp.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.jzs = aVar;
    }

    public void Fu(String str) {
        if (this.jzp != null) {
            this.jzp.mFrom = str;
        }
    }

    public void onDestroy() {
        bea();
        cuM();
        if (this.jzp != null) {
            this.jzp.cuH();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.jzq = i;
        if (this.jzr != i && this.jzx) {
            this.jzx = false;
        }
        if (!v.aa(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.jzs != null) {
            this.jzs.cuu();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.jzp != null && this.jzo != null) {
            this.jzp.BQ(this.jzo.getCurrentItem());
        }
    }

    public boolean cuG() {
        VideoPlayFragment BP;
        if (cuN()) {
            return true;
        }
        if (this.jzp == null || this.jzo == null || (BP = this.jzp.BP(this.jzo.getCurrentItem())) == null) {
            return false;
        }
        return BP.cuG();
    }

    public void a(int i, int i2, Intent intent) {
        VideoPlayFragment BP;
        if (this.jzp != null && this.jzo != null && (BP = this.jzp.BP(this.jzo.getCurrentItem())) != null) {
            BP.a(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            bea();
        }
    }

    private void cuI() {
        this.jzp.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
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
            i = (int) (this.jzw * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.jzo.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.jzw * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.jzo.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.jzw * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.jzo.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.jzw * (0.92d - f) * 6.0d) : 0;
        }
        this.jzo.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuJ() {
        if (this.jzq == this.jzr && this.jzx) {
            rD(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cE(int i, int i2) {
        int i3;
        if (!this.jzy && VideoPlayActivityConfig.FROM_DEFAULT.equals(Fw(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.jzx && i.cqU()) {
            rD(true);
            this.jzy = true;
            i.cqV();
        }
    }

    private void cuK() {
        this.jzo.scrollTo(0, 0);
    }

    private boolean rD(boolean z) {
        if (this.jzu == null) {
            return false;
        }
        if (this.jzv || z) {
            this.jzu.setVisibility(0);
            this.jzu.bo();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bea() {
        if (this.jzu != null) {
            if (this.jzu.isAnimating()) {
                this.jzu.bq();
                cuK();
            }
            this.jzu.setVisibility(8);
        }
    }

    private boolean Fv(String str) {
        return b.agM().getBoolean("video_play_vertical_first_in" + Fw(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuL() {
        if (this.jzv) {
            b.agM().putBoolean("video_play_vertical_first_in" + Fw(this.mFrom), false);
            this.jzv = false;
        }
    }

    private String Fw(String str) {
        if (!VideoPlayActivityConfig.FROM_MAINTAB_VIDEO.equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return VideoPlayActivityConfig.FROM_MAINTAB_VIDEO;
    }

    public void Fx(String str) {
        if (this.jzp != null) {
            this.jzp.jzh = str;
        }
    }

    private void cuM() {
        if (this.jzy) {
            i.cqX();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Fw(this.mFrom))) {
            if (this.jzx) {
                i.cqW();
            } else {
                i.cqX();
            }
        }
    }

    private boolean cuN() {
        if (this.jzu == null || !this.jzu.isAnimating()) {
            return false;
        }
        bea();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        al.h(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
