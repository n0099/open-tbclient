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
    private VerticalViewPager jIe;
    private VideoPlayFragmentAdapter jIf;
    public int jIh;
    private a jIi;
    private VideoPlayActivity jIj;
    private TBLottieAnimationView jIk;
    private boolean jIl;
    private int jIm;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int jIg = 0;
    private boolean jIn = true;
    private boolean jIo = false;

    /* loaded from: classes6.dex */
    public interface a {
        void aLV();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.jIj = videoPlayActivity;
        this.mFrom = str;
        this.jIl = Fp(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.jIe = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.jIf = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.jIf.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.cww();
            }
        });
        cwv();
        this.jIf.hbD = this.mFrom;
        this.jIe.setAdapter(this.jIf);
        this.jIe.setOffscreenPageLimit(1);
        this.jIe.setEventListener(new a.InterfaceC0306a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0306a
            public void aAK() {
                VideoPlayFragment Bh = VideoPlayView.this.jIf.Bh(VideoPlayView.this.jIe.getCurrentItem());
                if (Bh != null) {
                    Bh.aAK();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0306a
            public void s(float f, float f2) {
                VideoPlayFragment Bh = VideoPlayView.this.jIf.Bh(VideoPlayView.this.jIe.getCurrentItem());
                if (Bh != null) {
                    Bh.s(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0306a
            public void aAL() {
                VideoPlayFragment Bh = VideoPlayView.this.jIf.Bh(VideoPlayView.this.jIe.getCurrentItem());
                if (Bh != null) {
                    Bh.aAL();
                }
            }
        });
        this.jIe.setOnPageChangeListener(this);
        this.jIe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment Bh = VideoPlayView.this.jIf.Bh(VideoPlayView.this.jIe.getCurrentItem());
                if (Bh != null) {
                    return Bh.cwt();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.jIk = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.jIk.setAnimation(R.raw.lottie_video_guide);
        this.jIk.setImageAssetsFolder("lottie_video_guide");
        this.jIk.setOnClickListener(this);
        this.jIk.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.jIk.isAnimating()) {
                    VideoPlayView.this.az(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jIk.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.cwy();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.beG();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jIm = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        beG();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.jIh = i;
        this.jIf.a(this.mDatas, rect);
        this.jIf.notifyDataSetChanged();
        this.jIe.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.jIf != null) {
            this.jIf.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.jIi = aVar;
    }

    public void Fo(String str) {
        if (this.jIf != null) {
            this.jIf.mFrom = str;
        }
    }

    public void onDestroy() {
        beG();
        cwz();
        if (this.jIf != null) {
            this.jIf.cwu();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.jIg = i;
        if (this.jIh != i && this.jIn) {
            this.jIn = false;
        }
        if (!v.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.jIi != null) {
            this.jIi.aLV();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.jIf != null && this.jIe != null) {
            this.jIf.Bi(this.jIe.getCurrentItem());
        }
    }

    public boolean cwt() {
        VideoPlayFragment Bh;
        if (cwA()) {
            return true;
        }
        if (this.jIf == null || this.jIe == null || (Bh = this.jIf.Bh(this.jIe.getCurrentItem())) == null) {
            return false;
        }
        return Bh.cwt();
    }

    public void b(int i, int i2, Intent intent) {
        VideoPlayFragment Bh;
        if (this.jIf != null && this.jIe != null && (Bh = this.jIf.Bh(this.jIe.getCurrentItem())) != null) {
            Bh.b(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            beG();
        }
    }

    private void cwv() {
        this.jIf.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.j.b
            public void bh(int i, int i2) {
                VideoPlayView.this.cz(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.jIm * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.jIe.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.jIm * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.jIe.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.jIm * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.jIe.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.jIm * (0.92d - f) * 6.0d) : 0;
        }
        this.jIe.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cww() {
        if (this.jIg == this.jIh && this.jIn) {
            rE(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cz(int i, int i2) {
        int i3;
        if (!this.jIo && VideoPlayActivityConfig.FROM_DEFAULT.equals(Fq(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.jIn && i.csF()) {
            rE(true);
            this.jIo = true;
            i.csG();
        }
    }

    private void cwx() {
        this.jIe.scrollTo(0, 0);
    }

    private boolean rE(boolean z) {
        if (this.jIk == null) {
            return false;
        }
        if (this.jIl || z) {
            this.jIk.setVisibility(0);
            this.jIk.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beG() {
        if (this.jIk != null) {
            if (this.jIk.isAnimating()) {
                this.jIk.pauseAnimation();
                cwx();
            }
            this.jIk.setVisibility(8);
        }
    }

    private boolean Fp(String str) {
        return b.alP().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Fq(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwy() {
        if (this.jIl) {
            b.alP().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Fq(this.mFrom), false);
            this.jIl = false;
        }
    }

    private String Fq(String str) {
        if (!VideoPlayActivityConfig.FROM_MAINTAB_VIDEO.equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return VideoPlayActivityConfig.FROM_MAINTAB_VIDEO;
    }

    public void Fr(String str) {
        if (this.jIf != null) {
            this.jIf.jHX = str;
        }
    }

    private void cwz() {
        if (this.jIo) {
            i.csI();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Fq(this.mFrom))) {
            if (this.jIn) {
                i.csH();
            } else {
                i.csI();
            }
        }
    }

    private boolean cwA() {
        if (this.jIk == null || !this.jIk.isAnimating()) {
            return false;
        }
        beG();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
