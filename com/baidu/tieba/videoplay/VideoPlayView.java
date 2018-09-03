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
import com.baidu.tieba.f;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.j;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.i;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private VerticalViewPager hnM;
    private VideoPlayFragmentAdapter hnN;
    public int hnP;
    private a hnQ;
    private VideoPlayActivity hnR;
    private TBLottieAnimationView hnS;
    private boolean hnT;
    private int hnU;
    private List<VideoItemData> mDatas;
    private String mFrom;
    public int hnO = 0;
    private boolean hnV = true;
    private boolean hnW = false;

    /* loaded from: classes2.dex */
    public interface a {
        void aBR();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.hnR = videoPlayActivity;
        this.mFrom = str;
        this.hnT = vo(str);
        g(videoPlayActivity);
        this.hnM = (VerticalViewPager) videoPlayActivity.findViewById(f.g.video_play_viewpager);
        this.hnN = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.hnN.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.bEa();
            }
        });
        bDZ();
        this.hnN.bBN = this.mFrom;
        this.hnM.setAdapter(this.hnN);
        this.hnM.setOffscreenPageLimit(1);
        this.hnM.setEventListener(new a.InterfaceC0122a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0122a
            public void Oy() {
                VideoPlayFragment uW = VideoPlayView.this.hnN.uW(VideoPlayView.this.hnM.getCurrentItem());
                if (uW != null) {
                    uW.Oy();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0122a
            public void q(float f, float f2) {
                VideoPlayFragment uW = VideoPlayView.this.hnN.uW(VideoPlayView.this.hnM.getCurrentItem());
                if (uW != null) {
                    uW.q(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0122a
            public void Oz() {
                VideoPlayFragment uW = VideoPlayView.this.hnN.uW(VideoPlayView.this.hnM.getCurrentItem());
                if (uW != null) {
                    uW.Oz();
                }
            }
        });
        this.hnM.setOnPageChangeListener(this);
        this.hnM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment uW = VideoPlayView.this.hnN.uW(VideoPlayView.this.hnM.getCurrentItem());
                if (uW != null) {
                    return uW.bDX();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.hnS = (TBLottieAnimationView) videoPlayActivity.findViewById(f.g.guide_animation_view);
        this.hnS.setAnimation(f.i.lottie_video_guide);
        this.hnS.setImageAssetsFolder("lottie_video_guide");
        this.hnS.setOnClickListener(this);
        this.hnS.a(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.hnS.isAnimating()) {
                    VideoPlayView.this.aG(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.hnS.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.bEc();
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
        this.hnU = l.f(TbadkCoreApplication.getInst(), f.e.tbds310);
    }

    public void onPause() {
        aoX();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.hnP = i;
        this.hnN.a(this.mDatas, rect);
        this.hnN.notifyDataSetChanged();
        this.hnM.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.hnN != null) {
            this.hnN.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.hnQ = aVar;
    }

    public void vn(String str) {
        if (this.hnN != null) {
            this.hnN.mFrom = str;
        }
    }

    public void onDestroy() {
        aoX();
        bEd();
        if (this.hnN != null) {
            this.hnN.bDY();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.hnO = i;
        if (this.hnP != i && this.hnV) {
            this.hnV = false;
        }
        if (!w.z(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.hnQ != null) {
            this.hnQ.aBR();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.hnN != null && this.hnM != null) {
            this.hnN.uX(this.hnM.getCurrentItem());
        }
    }

    public boolean bDX() {
        VideoPlayFragment uW;
        if (bEe()) {
            return true;
        }
        if (this.hnN == null || this.hnM == null || (uW = this.hnN.uW(this.hnM.getCurrentItem())) == null) {
            return false;
        }
        return uW.bDX();
    }

    public void a(int i, int i2, Intent intent) {
        VideoPlayFragment uW;
        if (this.hnN != null && this.hnM != null && (uW = this.hnN.uW(this.hnM.getCurrentItem())) != null) {
            uW.a(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == f.g.guide_animation_view) {
            aoX();
        }
    }

    private void bDZ() {
        this.hnN.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.j.b
            public void bx(int i, int i2) {
                VideoPlayView.this.bS(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.hnU * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.hnM.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.hnU * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.hnM.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.hnU * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.hnM.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.hnU * (0.92d - f) * 6.0d) : 0;
        }
        this.hnM.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEa() {
        if (this.hnO == this.hnP && this.hnV) {
            nh(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bS(int i, int i2) {
        int i3;
        if (!this.hnW && VideoPlayActivityConfig.FROM_DEFAULT.equals(vp(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.hnV && i.bAo()) {
            nh(true);
            this.hnW = true;
            i.bAp();
        }
    }

    private void bEb() {
        this.hnM.scrollTo(0, 0);
    }

    private boolean nh(boolean z) {
        if (this.hnS == null) {
            return false;
        }
        if (this.hnT || z) {
            this.hnS.setVisibility(0);
            this.hnS.aX();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoX() {
        if (this.hnS != null) {
            if (this.hnS.isAnimating()) {
                this.hnS.aZ();
                bEb();
            }
            this.hnS.setVisibility(8);
        }
    }

    private boolean vo(String str) {
        return b.getInstance().getBoolean("video_play_vertical_first_in" + vp(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEc() {
        if (this.hnT) {
            b.getInstance().putBoolean("video_play_vertical_first_in" + vp(this.mFrom), false);
            this.hnT = false;
        }
    }

    private String vp(String str) {
        if (!VideoPlayActivityConfig.FROM_MAINTAB_VIDEO.equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return VideoPlayActivityConfig.FROM_MAINTAB_VIDEO;
    }

    public void vq(String str) {
        if (this.hnN != null) {
            this.hnN.hnF = str;
        }
    }

    private void bEd() {
        if (this.hnW) {
            i.bAr();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(vp(this.mFrom))) {
            if (this.hnV) {
                i.bAq();
            } else {
                i.bAr();
            }
        }
    }

    private boolean bEe() {
        if (this.hnS == null || !this.hnS.isAnimating()) {
            return false;
        }
        aoX();
        return true;
    }
}
