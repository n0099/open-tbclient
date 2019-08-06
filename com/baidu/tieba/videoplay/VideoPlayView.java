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
    private VerticalViewPager jGI;
    private VideoPlayFragmentAdapter jGJ;
    public int jGL;
    private a jGM;
    private VideoPlayActivity jGN;
    private TBLottieAnimationView jGO;
    private boolean jGP;
    private int jGQ;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int jGK = 0;
    private boolean jGR = true;
    private boolean jGS = false;

    /* loaded from: classes6.dex */
    public interface a {
        void cxG();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.jGN = videoPlayActivity;
        this.mFrom = str;
        this.jGP = Gn(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.jGI = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.jGJ = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.jGJ.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.cxV();
            }
        });
        cxU();
        this.jGJ.dxu = this.mFrom;
        this.jGI.setAdapter(this.jGJ);
        this.jGI.setOffscreenPageLimit(1);
        this.jGI.setEventListener(new a.InterfaceC0265a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0265a
            public void aAr() {
                VideoPlayFragment Cy = VideoPlayView.this.jGJ.Cy(VideoPlayView.this.jGI.getCurrentItem());
                if (Cy != null) {
                    Cy.aAr();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0265a
            public void x(float f, float f2) {
                VideoPlayFragment Cy = VideoPlayView.this.jGJ.Cy(VideoPlayView.this.jGI.getCurrentItem());
                if (Cy != null) {
                    Cy.x(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0265a
            public void aAs() {
                VideoPlayFragment Cy = VideoPlayView.this.jGJ.Cy(VideoPlayView.this.jGI.getCurrentItem());
                if (Cy != null) {
                    Cy.aAs();
                }
            }
        });
        this.jGI.setOnPageChangeListener(this);
        this.jGI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment Cy = VideoPlayView.this.jGJ.Cy(VideoPlayView.this.jGI.getCurrentItem());
                if (Cy != null) {
                    return Cy.cxS();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.jGO = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.jGO.setAnimation(R.raw.lottie_video_guide);
        this.jGO.setImageAssetsFolder("lottie_video_guide");
        this.jGO.setOnClickListener(this);
        this.jGO.a(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.jGO.isAnimating()) {
                    VideoPlayView.this.aV(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jGO.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.cxX();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.bgj();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jGQ = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        bgj();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.jGL = i;
        this.jGJ.a(this.mDatas, rect);
        this.jGJ.notifyDataSetChanged();
        this.jGI.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.jGJ != null) {
            this.jGJ.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.jGM = aVar;
    }

    public void Gm(String str) {
        if (this.jGJ != null) {
            this.jGJ.mFrom = str;
        }
    }

    public void onDestroy() {
        bgj();
        cxY();
        if (this.jGJ != null) {
            this.jGJ.cxT();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.jGK = i;
        if (this.jGL != i && this.jGR) {
            this.jGR = false;
        }
        if (!v.aa(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.jGM != null) {
            this.jGM.cxG();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.jGJ != null && this.jGI != null) {
            this.jGJ.Cz(this.jGI.getCurrentItem());
        }
    }

    public boolean cxS() {
        VideoPlayFragment Cy;
        if (cxZ()) {
            return true;
        }
        if (this.jGJ == null || this.jGI == null || (Cy = this.jGJ.Cy(this.jGI.getCurrentItem())) == null) {
            return false;
        }
        return Cy.cxS();
    }

    public void a(int i, int i2, Intent intent) {
        VideoPlayFragment Cy;
        if (this.jGJ != null && this.jGI != null && (Cy = this.jGJ.Cy(this.jGI.getCurrentItem())) != null) {
            Cy.a(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            bgj();
        }
    }

    private void cxU() {
        this.jGJ.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.j.b
            public void bh(int i, int i2) {
                VideoPlayView.this.cJ(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.jGQ * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.jGI.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.jGQ * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.jGI.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.jGQ * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.jGI.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.jGQ * (0.92d - f) * 6.0d) : 0;
        }
        this.jGI.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxV() {
        if (this.jGK == this.jGL && this.jGR) {
            rS(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJ(int i, int i2) {
        int i3;
        if (!this.jGS && VideoPlayActivityConfig.FROM_DEFAULT.equals(Go(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.jGR && i.cue()) {
            rS(true);
            this.jGS = true;
            i.cuf();
        }
    }

    private void cxW() {
        this.jGI.scrollTo(0, 0);
    }

    private boolean rS(boolean z) {
        if (this.jGO == null) {
            return false;
        }
        if (this.jGP || z) {
            this.jGO.setVisibility(0);
            this.jGO.br();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgj() {
        if (this.jGO != null) {
            if (this.jGO.isAnimating()) {
                this.jGO.bt();
                cxW();
            }
            this.jGO.setVisibility(8);
        }
    }

    private boolean Gn(String str) {
        return b.ahQ().getBoolean("video_play_vertical_first_in" + Go(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxX() {
        if (this.jGP) {
            b.ahQ().putBoolean("video_play_vertical_first_in" + Go(this.mFrom), false);
            this.jGP = false;
        }
    }

    private String Go(String str) {
        if (!VideoPlayActivityConfig.FROM_MAINTAB_VIDEO.equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return VideoPlayActivityConfig.FROM_MAINTAB_VIDEO;
    }

    public void Gp(String str) {
        if (this.jGJ != null) {
            this.jGJ.jGB = str;
        }
    }

    private void cxY() {
        if (this.jGS) {
            i.cuh();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Go(this.mFrom))) {
            if (this.jGR) {
                i.cug();
            } else {
                i.cuh();
            }
        }
    }

    private boolean cxZ() {
        if (this.jGO == null || !this.jGO.isAnimating()) {
            return false;
        }
        bgj();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        am.h(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
