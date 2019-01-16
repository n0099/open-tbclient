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
    private VerticalViewPager hQe;
    private VideoPlayFragmentAdapter hQf;
    public int hQh;
    private a hQi;
    private VideoPlayActivity hQj;
    private TBLottieAnimationView hQk;
    private boolean hQl;
    private int hQm;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int hQg = 0;
    private boolean hQn = true;
    private boolean hQo = false;

    /* loaded from: classes4.dex */
    public interface a {
        void aJT();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.hQj = videoPlayActivity;
        this.mFrom = str;
        this.hQl = xz(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(e.g.root_layout);
        this.hQe = (VerticalViewPager) videoPlayActivity.findViewById(e.g.video_play_viewpager);
        this.hQf = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.hQf.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.bNe();
            }
        });
        bNd();
        this.hQf.bVu = this.mFrom;
        this.hQe.setAdapter(this.hQf);
        this.hQe.setOffscreenPageLimit(1);
        this.hQe.setEventListener(new a.InterfaceC0180a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
            public void TZ() {
                VideoPlayFragment wZ = VideoPlayView.this.hQf.wZ(VideoPlayView.this.hQe.getCurrentItem());
                if (wZ != null) {
                    wZ.TZ();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
            public void t(float f, float f2) {
                VideoPlayFragment wZ = VideoPlayView.this.hQf.wZ(VideoPlayView.this.hQe.getCurrentItem());
                if (wZ != null) {
                    wZ.t(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0180a
            public void Ua() {
                VideoPlayFragment wZ = VideoPlayView.this.hQf.wZ(VideoPlayView.this.hQe.getCurrentItem());
                if (wZ != null) {
                    wZ.Ua();
                }
            }
        });
        this.hQe.setOnPageChangeListener(this);
        this.hQe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment wZ = VideoPlayView.this.hQf.wZ(VideoPlayView.this.hQe.getCurrentItem());
                if (wZ != null) {
                    return wZ.bNb();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.hQk = (TBLottieAnimationView) videoPlayActivity.findViewById(e.g.guide_animation_view);
        this.hQk.setAnimation(e.i.lottie_video_guide);
        this.hQk.setImageAssetsFolder("lottie_video_guide");
        this.hQk.setOnClickListener(this);
        this.hQk.a(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.hQk.isAnimating()) {
                    VideoPlayView.this.aD(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.hQk.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
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
        this.hQm = l.h(TbadkCoreApplication.getInst(), e.C0210e.tbds310);
    }

    public void onPause() {
        bmw();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.hQh = i;
        this.hQf.a(this.mDatas, rect);
        this.hQf.notifyDataSetChanged();
        this.hQe.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.hQf != null) {
            this.hQf.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.hQi = aVar;
    }

    public void xy(String str) {
        if (this.hQf != null) {
            this.hQf.mFrom = str;
        }
    }

    public void onDestroy() {
        bmw();
        bNh();
        if (this.hQf != null) {
            this.hQf.bNc();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.hQg = i;
        if (this.hQh != i && this.hQn) {
            this.hQn = false;
        }
        if (!v.I(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.hQi != null) {
            this.hQi.aJT();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.hQf != null && this.hQe != null) {
            this.hQf.xa(this.hQe.getCurrentItem());
        }
    }

    public boolean bNb() {
        VideoPlayFragment wZ;
        if (bNi()) {
            return true;
        }
        if (this.hQf == null || this.hQe == null || (wZ = this.hQf.wZ(this.hQe.getCurrentItem())) == null) {
            return false;
        }
        return wZ.bNb();
    }

    public void a(int i, int i2, Intent intent) {
        VideoPlayFragment wZ;
        if (this.hQf != null && this.hQe != null && (wZ = this.hQf.wZ(this.hQe.getCurrentItem())) != null) {
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
        this.hQf.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
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
            i = (int) (this.hQm * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.hQe.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.hQm * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.hQe.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.hQm * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.hQe.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.hQm * (0.92d - f) * 6.0d) : 0;
        }
        this.hQe.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNe() {
        if (this.hQg == this.hQh && this.hQn) {
            oo(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(int i, int i2) {
        int i3;
        if (!this.hQo && VideoPlayActivityConfig.FROM_DEFAULT.equals(xA(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.hQn && i.bJt()) {
            oo(true);
            this.hQo = true;
            i.bJu();
        }
    }

    private void bNf() {
        this.hQe.scrollTo(0, 0);
    }

    private boolean oo(boolean z) {
        if (this.hQk == null) {
            return false;
        }
        if (this.hQl || z) {
            this.hQk.setVisibility(0);
            this.hQk.cv();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmw() {
        if (this.hQk != null) {
            if (this.hQk.isAnimating()) {
                this.hQk.cx();
                bNf();
            }
            this.hQk.setVisibility(8);
        }
    }

    private boolean xz(String str) {
        return b.getInstance().getBoolean("video_play_vertical_first_in" + xA(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNg() {
        if (this.hQl) {
            b.getInstance().putBoolean("video_play_vertical_first_in" + xA(this.mFrom), false);
            this.hQl = false;
        }
    }

    private String xA(String str) {
        if (!VideoPlayActivityConfig.FROM_MAINTAB_VIDEO.equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return VideoPlayActivityConfig.FROM_MAINTAB_VIDEO;
    }

    public void xB(String str) {
        if (this.hQf != null) {
            this.hQf.ecD = str;
        }
    }

    private void bNh() {
        if (this.hQo) {
            i.bJw();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(xA(this.mFrom))) {
            if (this.hQn) {
                i.bJv();
            } else {
                i.bJw();
            }
        }
    }

    private boolean bNi() {
        if (this.hQk == null || !this.hQk.isAnimating()) {
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
