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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.viewpager.VerticalViewPager;
import com.baidu.tbadk.widget.viewpager.a;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.j;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.i;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private VerticalViewPager hnL;
    private VideoPlayFragmentAdapter hnM;
    public int hnO;
    private a hnP;
    private VideoPlayActivity hnQ;
    private TBLottieAnimationView hnR;
    private boolean hnS;
    private int hnT;
    private List<VideoItemData> mDatas;
    private String mFrom;
    public int hnN = 0;
    private boolean hnU = true;
    private boolean hnV = false;

    /* loaded from: classes2.dex */
    public interface a {
        void aBU();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.hnQ = videoPlayActivity;
        this.mFrom = str;
        this.hnS = vk(str);
        g(videoPlayActivity);
        this.hnL = (VerticalViewPager) videoPlayActivity.findViewById(d.g.video_play_viewpager);
        this.hnM = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.hnM.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.bDY();
            }
        });
        bDX();
        this.hnM.bBL = this.mFrom;
        this.hnL.setAdapter(this.hnM);
        this.hnL.setOffscreenPageLimit(1);
        this.hnL.setEventListener(new a.InterfaceC0122a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0122a
            public void Oz() {
                VideoPlayFragment uW = VideoPlayView.this.hnM.uW(VideoPlayView.this.hnL.getCurrentItem());
                if (uW != null) {
                    uW.Oz();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0122a
            public void q(float f, float f2) {
                VideoPlayFragment uW = VideoPlayView.this.hnM.uW(VideoPlayView.this.hnL.getCurrentItem());
                if (uW != null) {
                    uW.q(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0122a
            public void OA() {
                VideoPlayFragment uW = VideoPlayView.this.hnM.uW(VideoPlayView.this.hnL.getCurrentItem());
                if (uW != null) {
                    uW.OA();
                }
            }
        });
        this.hnL.setOnPageChangeListener(this);
        this.hnL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment uW = VideoPlayView.this.hnM.uW(VideoPlayView.this.hnL.getCurrentItem());
                if (uW != null) {
                    return uW.bDV();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.hnR = (TBLottieAnimationView) videoPlayActivity.findViewById(d.g.guide_animation_view);
        this.hnR.setAnimation(d.i.lottie_video_guide);
        this.hnR.setImageAssetsFolder("lottie_video_guide");
        this.hnR.setOnClickListener(this);
        this.hnR.a(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.hnR.isAnimating()) {
                    VideoPlayView.this.aH(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.hnR.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.bEa();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.aoX();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hnT = l.f(TbadkCoreApplication.getInst(), d.e.tbds310);
    }

    public void onPause() {
        aoX();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.hnO = i;
        this.hnM.a(this.mDatas, rect);
        this.hnM.notifyDataSetChanged();
        this.hnL.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.hnM != null) {
            this.hnM.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.hnP = aVar;
    }

    public void vj(String str) {
        if (this.hnM != null) {
            this.hnM.mFrom = str;
        }
    }

    public void onDestroy() {
        aoX();
        bEb();
        if (this.hnM != null) {
            this.hnM.bDW();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.hnN = i;
        if (this.hnO != i && this.hnU) {
            this.hnU = false;
        }
        if (!w.z(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.hnP != null) {
            this.hnP.aBU();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.hnM != null && this.hnL != null) {
            this.hnM.uX(this.hnL.getCurrentItem());
        }
    }

    public boolean bDV() {
        VideoPlayFragment uW;
        if (bEc()) {
            return true;
        }
        if (this.hnM == null || this.hnL == null || (uW = this.hnM.uW(this.hnL.getCurrentItem())) == null) {
            return false;
        }
        return uW.bDV();
    }

    public void a(int i, int i2, Intent intent) {
        VideoPlayFragment uW;
        if (this.hnM != null && this.hnL != null && (uW = this.hnM.uW(this.hnL.getCurrentItem())) != null) {
            uW.a(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.guide_animation_view) {
            aoX();
        }
    }

    private void bDX() {
        this.hnM.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.j.b
            public void bx(int i, int i2) {
                VideoPlayView.this.bS(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.hnT * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.hnL.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.hnT * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.hnL.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.hnT * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.hnL.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.hnT * (0.92d - f) * 6.0d) : 0;
        }
        this.hnL.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDY() {
        if (this.hnN == this.hnO && this.hnU) {
            nh(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bS(int i, int i2) {
        int i3;
        if (!this.hnV && VideoPlayActivityConfig.FROM_DEFAULT.equals(vl(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.hnU && i.bAm()) {
            nh(true);
            this.hnV = true;
            i.bAn();
        }
    }

    private void bDZ() {
        this.hnL.scrollTo(0, 0);
    }

    private boolean nh(boolean z) {
        if (this.hnR == null) {
            return false;
        }
        if (this.hnS || z) {
            this.hnR.setVisibility(0);
            this.hnR.aX();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoX() {
        if (this.hnR != null) {
            if (this.hnR.isAnimating()) {
                this.hnR.aZ();
                bDZ();
            }
            this.hnR.setVisibility(8);
        }
    }

    private boolean vk(String str) {
        return b.getInstance().getBoolean("video_play_vertical_first_in" + vl(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEa() {
        if (this.hnS) {
            b.getInstance().putBoolean("video_play_vertical_first_in" + vl(this.mFrom), false);
            this.hnS = false;
        }
    }

    private String vl(String str) {
        if (!VideoPlayActivityConfig.FROM_MAINTAB_VIDEO.equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return VideoPlayActivityConfig.FROM_MAINTAB_VIDEO;
    }

    public void vm(String str) {
        if (this.hnM != null) {
            this.hnM.hnE = str;
        }
    }

    private void bEb() {
        if (this.hnV) {
            i.bAp();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(vl(this.mFrom))) {
            if (this.hnU) {
                i.bAo();
            } else {
                i.bAp();
            }
        }
    }

    private boolean bEc() {
        if (this.hnR == null || !this.hnR.isAnimating()) {
            return false;
        }
        aoX();
        return true;
    }
}
