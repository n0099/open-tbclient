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
    private int jzA;
    private VerticalViewPager jzs;
    private VideoPlayFragmentAdapter jzt;
    public int jzv;
    private a jzw;
    private VideoPlayActivity jzx;
    private TBLottieAnimationView jzy;
    private boolean jzz;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int jzu = 0;
    private boolean jzB = true;
    private boolean jzC = false;

    /* loaded from: classes6.dex */
    public interface a {
        void cuv();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.jzx = videoPlayActivity;
        this.mFrom = str;
        this.jzz = Fx(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.jzs = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.jzt = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.jzt.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.cuK();
            }
        });
        cuJ();
        this.jzt.dvf = this.mFrom;
        this.jzs.setAdapter(this.jzt);
        this.jzs.setOffscreenPageLimit(1);
        this.jzs.setEventListener(new a.InterfaceC0263a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0263a
            public void azb() {
                VideoPlayFragment BP = VideoPlayView.this.jzt.BP(VideoPlayView.this.jzs.getCurrentItem());
                if (BP != null) {
                    BP.azb();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0263a
            public void w(float f, float f2) {
                VideoPlayFragment BP = VideoPlayView.this.jzt.BP(VideoPlayView.this.jzs.getCurrentItem());
                if (BP != null) {
                    BP.w(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0263a
            public void azc() {
                VideoPlayFragment BP = VideoPlayView.this.jzt.BP(VideoPlayView.this.jzs.getCurrentItem());
                if (BP != null) {
                    BP.azc();
                }
            }
        });
        this.jzs.setOnPageChangeListener(this);
        this.jzs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment BP = VideoPlayView.this.jzt.BP(VideoPlayView.this.jzs.getCurrentItem());
                if (BP != null) {
                    return BP.cuH();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.jzy = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.jzy.setAnimation(R.raw.lottie_video_guide);
        this.jzy.setImageAssetsFolder("lottie_video_guide");
        this.jzy.setOnClickListener(this);
        this.jzy.a(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.jzy.isAnimating()) {
                    VideoPlayView.this.aU(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jzy.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.cuM();
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
        this.jzA = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        bed();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.jzv = i;
        this.jzt.a(this.mDatas, rect);
        this.jzt.notifyDataSetChanged();
        this.jzs.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.jzt != null) {
            this.jzt.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.jzw = aVar;
    }

    public void Fw(String str) {
        if (this.jzt != null) {
            this.jzt.mFrom = str;
        }
    }

    public void onDestroy() {
        bed();
        cuN();
        if (this.jzt != null) {
            this.jzt.cuI();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.jzu = i;
        if (this.jzv != i && this.jzB) {
            this.jzB = false;
        }
        if (!v.aa(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.jzw != null) {
            this.jzw.cuv();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.jzt != null && this.jzs != null) {
            this.jzt.BQ(this.jzs.getCurrentItem());
        }
    }

    public boolean cuH() {
        VideoPlayFragment BP;
        if (cuO()) {
            return true;
        }
        if (this.jzt == null || this.jzs == null || (BP = this.jzt.BP(this.jzs.getCurrentItem())) == null) {
            return false;
        }
        return BP.cuH();
    }

    public void a(int i, int i2, Intent intent) {
        VideoPlayFragment BP;
        if (this.jzt != null && this.jzs != null && (BP = this.jzt.BP(this.jzs.getCurrentItem())) != null) {
            BP.a(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            bed();
        }
    }

    private void cuJ() {
        this.jzt.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
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
            i = (int) (this.jzA * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.jzs.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.jzA * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.jzs.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.jzA * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.jzs.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.jzA * (0.92d - f) * 6.0d) : 0;
        }
        this.jzs.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuK() {
        if (this.jzu == this.jzv && this.jzB) {
            rE(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cE(int i, int i2) {
        int i3;
        if (!this.jzC && VideoPlayActivityConfig.FROM_DEFAULT.equals(Fy(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.jzB && i.cqX()) {
            rE(true);
            this.jzC = true;
            i.cqY();
        }
    }

    private void cuL() {
        this.jzs.scrollTo(0, 0);
    }

    private boolean rE(boolean z) {
        if (this.jzy == null) {
            return false;
        }
        if (this.jzz || z) {
            this.jzy.setVisibility(0);
            this.jzy.bo();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bed() {
        if (this.jzy != null) {
            if (this.jzy.isAnimating()) {
                this.jzy.bq();
                cuL();
            }
            this.jzy.setVisibility(8);
        }
    }

    private boolean Fx(String str) {
        return b.agM().getBoolean("video_play_vertical_first_in" + Fy(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuM() {
        if (this.jzz) {
            b.agM().putBoolean("video_play_vertical_first_in" + Fy(this.mFrom), false);
            this.jzz = false;
        }
    }

    private String Fy(String str) {
        if (!VideoPlayActivityConfig.FROM_MAINTAB_VIDEO.equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return VideoPlayActivityConfig.FROM_MAINTAB_VIDEO;
    }

    public void Fz(String str) {
        if (this.jzt != null) {
            this.jzt.jzl = str;
        }
    }

    private void cuN() {
        if (this.jzC) {
            i.cra();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Fy(this.mFrom))) {
            if (this.jzB) {
                i.cqZ();
            } else {
                i.cra();
            }
        }
    }

    private boolean cuO() {
        if (this.jzy == null || !this.jzy.isAnimating()) {
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
