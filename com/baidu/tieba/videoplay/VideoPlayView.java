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
/* loaded from: classes8.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private VerticalViewPager kCn;
    private VideoPlayFragmentAdapter kCo;
    public int kCq;
    private a kCr;
    private VideoPlayActivity kCs;
    private TBLottieAnimationView kCt;
    private boolean kCu;
    private int kCv;
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    public int kCp = 0;
    private boolean kCw = true;
    private boolean kCx = false;

    /* loaded from: classes8.dex */
    public interface a {
        void bde();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.kCs = videoPlayActivity;
        this.mFrom = str;
        this.kCu = Kh(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.kCn = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.kCo = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.kCo.setVideoStatusListener(new QuickVideoView.c() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.play.QuickVideoView.c
            public void onStart() {
                VideoPlayView.this.cQD();
            }
        });
        cQC();
        this.kCo.mFromPage = this.mFrom;
        this.kCn.setAdapter(this.kCo);
        this.kCn.setOffscreenPageLimit(1);
        this.kCn.setEventListener(new a.InterfaceC0387a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0387a
            public void aSy() {
                VideoPlayFragment DE = VideoPlayView.this.kCo.DE(VideoPlayView.this.kCn.getCurrentItem());
                if (DE != null) {
                    DE.aSy();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0387a
            public void u(float f, float f2) {
                VideoPlayFragment DE = VideoPlayView.this.kCo.DE(VideoPlayView.this.kCn.getCurrentItem());
                if (DE != null) {
                    DE.u(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0387a
            public void aSz() {
                VideoPlayFragment DE = VideoPlayView.this.kCo.DE(VideoPlayView.this.kCn.getCurrentItem());
                if (DE != null) {
                    DE.aSz();
                }
            }
        });
        this.kCn.setOnPageChangeListener(this);
        this.kCn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment DE = VideoPlayView.this.kCo.DE(VideoPlayView.this.kCn.getCurrentItem());
                if (DE != null) {
                    return DE.cQy();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.kCt = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.kCt.setAnimation(R.raw.lottie_video_guide);
        this.kCt.setImageAssetsFolder("lottie_video_guide");
        this.kCt.setOnClickListener(this);
        this.kCt.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.kCt.isAnimating()) {
                    VideoPlayView.this.aP(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.kCt.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.cQF();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.bwa();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kCv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        bwa();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.kCq = i;
        this.kCo.a(this.mDatas, rect);
        this.kCo.notifyDataSetChanged();
        this.kCn.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.kCo != null) {
            this.kCo.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.kCr = aVar;
    }

    public void Kg(String str) {
        if (this.kCo != null) {
            this.kCo.mFrom = str;
        }
    }

    public void onDestroy() {
        bwa();
        cQG();
        if (this.kCo != null) {
            this.kCo.cQB();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.kCp = i;
        if (this.kCq != i && this.kCw) {
            this.kCw = false;
        }
        if (!v.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.kCr != null) {
            this.kCr.bde();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.kCo != null && this.kCn != null) {
            this.kCo.DF(this.kCn.getCurrentItem());
        }
    }

    public boolean cQy() {
        VideoPlayFragment DE;
        if (cQH()) {
            return true;
        }
        if (this.kCo == null || this.kCn == null || (DE = this.kCo.DE(this.kCn.getCurrentItem())) == null) {
            return false;
        }
        return DE.cQy();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment DE;
        if (this.kCo != null && this.kCn != null && (DE = this.kCo.DE(this.kCn.getCurrentItem())) != null) {
            DE.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            bwa();
        }
    }

    private void cQC() {
        this.kCo.a(new j.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.j.b
            public void by(int i, int i2) {
                VideoPlayView.this.cR(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.kCv * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.kCn.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.kCv * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.kCn.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.kCv * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.kCn.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.kCv * (0.92d - f) * 6.0d) : 0;
        }
        this.kCn.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQD() {
        if (this.kCp == this.kCq && this.kCw) {
            tk(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cR(int i, int i2) {
        int i3;
        if (!this.kCx && VideoPlayActivityConfig.FROM_DEFAULT.equals(Ki(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.kCw && i.cMH()) {
            tk(true);
            this.kCx = true;
            i.cMI();
        }
    }

    private void cQE() {
        this.kCn.scrollTo(0, 0);
    }

    private boolean tk(boolean z) {
        if (this.kCt == null) {
            return false;
        }
        if (this.kCu || z) {
            this.kCt.setVisibility(0);
            this.kCt.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwa() {
        if (this.kCt != null) {
            if (this.kCt.isAnimating()) {
                this.kCt.pauseAnimation();
                cQE();
            }
            this.kCt.setVisibility(8);
        }
    }

    private boolean Kh(String str) {
        return b.aCY().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Ki(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQF() {
        if (this.kCu) {
            b.aCY().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Ki(this.mFrom), false);
            this.kCu = false;
        }
    }

    private String Ki(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void Kj(String str) {
        if (this.kCo != null) {
            this.kCo.kCg = str;
        }
    }

    private void cQG() {
        if (this.kCx) {
            i.cMK();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Ki(this.mFrom))) {
            if (this.kCw) {
                i.cMJ();
            } else {
                i.cMK();
            }
        }
    }

    private boolean cQH() {
        if (this.kCt == null || !this.kCt.isAnimating()) {
            return false;
        }
        bwa();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
