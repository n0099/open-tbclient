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
import com.baidu.tieba.e;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.j;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.i;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private VerticalViewPager hQf;
    private VideoPlayFragmentAdapter hQg;
    public int hQi;
    private a hQj;
    private VideoPlayActivity hQk;
    private TBLottieAnimationView hQl;
    private boolean hQm;
    private int hQn;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int hQh = 0;
    private boolean hQo = true;
    private boolean hQp = false;

    /* loaded from: classes4.dex */
    public interface a {
        void aJT();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.hQk = videoPlayActivity;
        this.mFrom = str;
        this.hQm = xz(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(e.g.root_layout);
        this.hQf = (VerticalViewPager) videoPlayActivity.findViewById(e.g.video_play_viewpager);
        this.hQg = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.hQg.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.bNe();
            }
        });
        bNd();
        this.hQg.bVv = this.mFrom;
        this.hQf.setAdapter(this.hQg);
        this.hQf.setOffscreenPageLimit(1);
        this.hQf.setEventListener(new a.InterfaceC0180a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
            public void TZ() {
                VideoPlayFragment wZ = VideoPlayView.this.hQg.wZ(VideoPlayView.this.hQf.getCurrentItem());
                if (wZ != null) {
                    wZ.TZ();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
            public void t(float f, float f2) {
                VideoPlayFragment wZ = VideoPlayView.this.hQg.wZ(VideoPlayView.this.hQf.getCurrentItem());
                if (wZ != null) {
                    wZ.t(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
            public void Ua() {
                VideoPlayFragment wZ = VideoPlayView.this.hQg.wZ(VideoPlayView.this.hQf.getCurrentItem());
                if (wZ != null) {
                    wZ.Ua();
                }
            }
        });
        this.hQf.setOnPageChangeListener(this);
        this.hQf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment wZ = VideoPlayView.this.hQg.wZ(VideoPlayView.this.hQf.getCurrentItem());
                if (wZ != null) {
                    return wZ.bNb();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.hQl = (TBLottieAnimationView) videoPlayActivity.findViewById(e.g.guide_animation_view);
        this.hQl.setAnimation(e.i.lottie_video_guide);
        this.hQl.setImageAssetsFolder("lottie_video_guide");
        this.hQl.setOnClickListener(this);
        this.hQl.a(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.hQl.isAnimating()) {
                    VideoPlayView.this.aD(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.hQl.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.bNg();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.bmw();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hQn = l.h(TbadkCoreApplication.getInst(), e.C0210e.tbds310);
    }

    public void onPause() {
        bmw();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.hQi = i;
        this.hQg.a(this.mDatas, rect);
        this.hQg.notifyDataSetChanged();
        this.hQf.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.hQg != null) {
            this.hQg.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.hQj = aVar;
    }

    public void xy(String str) {
        if (this.hQg != null) {
            this.hQg.mFrom = str;
        }
    }

    public void onDestroy() {
        bmw();
        bNh();
        if (this.hQg != null) {
            this.hQg.bNc();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.hQh = i;
        if (this.hQi != i && this.hQo) {
            this.hQo = false;
        }
        if (!v.I(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.hQj != null) {
            this.hQj.aJT();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.hQg != null && this.hQf != null) {
            this.hQg.xa(this.hQf.getCurrentItem());
        }
    }

    public boolean bNb() {
        VideoPlayFragment wZ;
        if (bNi()) {
            return true;
        }
        if (this.hQg == null || this.hQf == null || (wZ = this.hQg.wZ(this.hQf.getCurrentItem())) == null) {
            return false;
        }
        return wZ.bNb();
    }

    public void a(int i, int i2, Intent intent) {
        VideoPlayFragment wZ;
        if (this.hQg != null && this.hQf != null && (wZ = this.hQg.wZ(this.hQf.getCurrentItem())) != null) {
            wZ.a(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.guide_animation_view) {
            bmw();
        }
    }

    private void bNd() {
        this.hQg.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.j.b
            public void bD(int i, int i2) {
                VideoPlayView.this.ca(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.hQn * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.hQf.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.hQn * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.hQf.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.hQn * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.hQf.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.hQn * (0.92d - f) * 6.0d) : 0;
        }
        this.hQf.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNe() {
        if (this.hQh == this.hQi && this.hQo) {
            oo(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(int i, int i2) {
        int i3;
        if (!this.hQp && VideoPlayActivityConfig.FROM_DEFAULT.equals(xA(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.hQo && i.bJt()) {
            oo(true);
            this.hQp = true;
            i.bJu();
        }
    }

    private void bNf() {
        this.hQf.scrollTo(0, 0);
    }

    private boolean oo(boolean z) {
        if (this.hQl == null) {
            return false;
        }
        if (this.hQm || z) {
            this.hQl.setVisibility(0);
            this.hQl.cv();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmw() {
        if (this.hQl != null) {
            if (this.hQl.isAnimating()) {
                this.hQl.cx();
                bNf();
            }
            this.hQl.setVisibility(8);
        }
    }

    private boolean xz(String str) {
        return b.getInstance().getBoolean("video_play_vertical_first_in" + xA(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNg() {
        if (this.hQm) {
            b.getInstance().putBoolean("video_play_vertical_first_in" + xA(this.mFrom), false);
            this.hQm = false;
        }
    }

    private String xA(String str) {
        if (!VideoPlayActivityConfig.FROM_MAINTAB_VIDEO.equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return VideoPlayActivityConfig.FROM_MAINTAB_VIDEO;
    }

    public void xB(String str) {
        if (this.hQg != null) {
            this.hQg.ecE = str;
        }
    }

    private void bNh() {
        if (this.hQp) {
            i.bJw();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(xA(this.mFrom))) {
            if (this.hQo) {
                i.bJv();
            } else {
                i.bJw();
            }
        }
    }

    private boolean bNi() {
        if (this.hQl == null || !this.hQl.isAnimating()) {
            return false;
        }
        bmw();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        al.e(this.mRootView, e.d.cp_bg_line_d, i);
    }
}
