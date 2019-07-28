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
    private VerticalViewPager jFB;
    private VideoPlayFragmentAdapter jFC;
    public int jFE;
    private a jFF;
    private VideoPlayActivity jFG;
    private TBLottieAnimationView jFH;
    private boolean jFI;
    private int jFJ;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int jFD = 0;
    private boolean jFK = true;
    private boolean jFL = false;

    /* loaded from: classes6.dex */
    public interface a {
        void cxk();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.jFG = videoPlayActivity;
        this.mFrom = str;
        this.jFI = Gm(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.jFB = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.jFC = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.jFC.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.cxz();
            }
        });
        cxy();
        this.jFC.dxn = this.mFrom;
        this.jFB.setAdapter(this.jFC);
        this.jFB.setOffscreenPageLimit(1);
        this.jFB.setEventListener(new a.InterfaceC0265a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0265a
            public void aAp() {
                VideoPlayFragment Cw = VideoPlayView.this.jFC.Cw(VideoPlayView.this.jFB.getCurrentItem());
                if (Cw != null) {
                    Cw.aAp();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0265a
            public void x(float f, float f2) {
                VideoPlayFragment Cw = VideoPlayView.this.jFC.Cw(VideoPlayView.this.jFB.getCurrentItem());
                if (Cw != null) {
                    Cw.x(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0265a
            public void aAq() {
                VideoPlayFragment Cw = VideoPlayView.this.jFC.Cw(VideoPlayView.this.jFB.getCurrentItem());
                if (Cw != null) {
                    Cw.aAq();
                }
            }
        });
        this.jFB.setOnPageChangeListener(this);
        this.jFB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment Cw = VideoPlayView.this.jFC.Cw(VideoPlayView.this.jFB.getCurrentItem());
                if (Cw != null) {
                    return Cw.cxw();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.jFH = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.jFH.setAnimation(R.raw.lottie_video_guide);
        this.jFH.setImageAssetsFolder("lottie_video_guide");
        this.jFH.setOnClickListener(this);
        this.jFH.a(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.jFH.isAnimating()) {
                    VideoPlayView.this.aV(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jFH.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.cxB();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.bgg();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jFJ = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        bgg();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.jFE = i;
        this.jFC.a(this.mDatas, rect);
        this.jFC.notifyDataSetChanged();
        this.jFB.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.jFC != null) {
            this.jFC.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.jFF = aVar;
    }

    public void Gl(String str) {
        if (this.jFC != null) {
            this.jFC.mFrom = str;
        }
    }

    public void onDestroy() {
        bgg();
        cxC();
        if (this.jFC != null) {
            this.jFC.cxx();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.jFD = i;
        if (this.jFE != i && this.jFK) {
            this.jFK = false;
        }
        if (!v.aa(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.jFF != null) {
            this.jFF.cxk();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.jFC != null && this.jFB != null) {
            this.jFC.Cx(this.jFB.getCurrentItem());
        }
    }

    public boolean cxw() {
        VideoPlayFragment Cw;
        if (cxD()) {
            return true;
        }
        if (this.jFC == null || this.jFB == null || (Cw = this.jFC.Cw(this.jFB.getCurrentItem())) == null) {
            return false;
        }
        return Cw.cxw();
    }

    public void a(int i, int i2, Intent intent) {
        VideoPlayFragment Cw;
        if (this.jFC != null && this.jFB != null && (Cw = this.jFC.Cw(this.jFB.getCurrentItem())) != null) {
            Cw.a(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            bgg();
        }
    }

    private void cxy() {
        this.jFC.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
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
            i = (int) (this.jFJ * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.jFB.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.jFJ * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.jFB.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.jFJ * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.jFB.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.jFJ * (0.92d - f) * 6.0d) : 0;
        }
        this.jFB.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxz() {
        if (this.jFD == this.jFE && this.jFK) {
            rR(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJ(int i, int i2) {
        int i3;
        if (!this.jFL && VideoPlayActivityConfig.FROM_DEFAULT.equals(Gn(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.jFK && i.ctI()) {
            rR(true);
            this.jFL = true;
            i.ctJ();
        }
    }

    private void cxA() {
        this.jFB.scrollTo(0, 0);
    }

    private boolean rR(boolean z) {
        if (this.jFH == null) {
            return false;
        }
        if (this.jFI || z) {
            this.jFH.setVisibility(0);
            this.jFH.br();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgg() {
        if (this.jFH != null) {
            if (this.jFH.isAnimating()) {
                this.jFH.bt();
                cxA();
            }
            this.jFH.setVisibility(8);
        }
    }

    private boolean Gm(String str) {
        return b.ahO().getBoolean("video_play_vertical_first_in" + Gn(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxB() {
        if (this.jFI) {
            b.ahO().putBoolean("video_play_vertical_first_in" + Gn(this.mFrom), false);
            this.jFI = false;
        }
    }

    private String Gn(String str) {
        if (!VideoPlayActivityConfig.FROM_MAINTAB_VIDEO.equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return VideoPlayActivityConfig.FROM_MAINTAB_VIDEO;
    }

    public void Go(String str) {
        if (this.jFC != null) {
            this.jFC.jFu = str;
        }
    }

    private void cxC() {
        if (this.jFL) {
            i.ctL();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Gn(this.mFrom))) {
            if (this.jFK) {
                i.ctK();
            } else {
                i.ctL();
            }
        }
    }

    private boolean cxD() {
        if (this.jFH == null || !this.jFH.isAnimating()) {
            return false;
        }
        bgg();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        am.h(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
