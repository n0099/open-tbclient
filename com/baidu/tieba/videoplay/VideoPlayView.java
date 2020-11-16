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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.viewpager.VerticalViewPager;
import com.baidu.tbadk.widget.viewpager.a;
import com.baidu.tieba.R;
import com.baidu.tieba.play.f;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.i;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import java.util.List;
/* loaded from: classes23.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    private VerticalViewPager nyS;
    private VideoPlayFragmentAdapter nyT;
    public int nyV;
    private a nyW;
    private VideoPlayActivity nyX;
    private TBLottieAnimationView nyY;
    private boolean nyZ;
    private int nza;
    public int nyU = 0;
    private boolean nzb = true;
    private boolean nzc = false;

    /* loaded from: classes23.dex */
    public interface a {
        void bSU();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.nyX = videoPlayActivity;
        this.mFrom = str;
        this.nyZ = TY(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.nyS = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.nyT = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.nyT.a(new VideoPlayFragment.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.VideoPlayFragment.a
            public void onStart() {
                VideoPlayView.this.dSh();
            }
        });
        dSg();
        this.nyT.mFromPage = this.mFrom;
        this.nyS.setAdapter(this.nyT);
        this.nyS.setOffscreenPageLimit(1);
        this.nyS.setEventListener(new a.InterfaceC0604a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0604a
            public void bGy() {
                VideoPlayFragment LB = VideoPlayView.this.nyT.LB(VideoPlayView.this.nyS.getCurrentItem());
                if (LB != null) {
                    LB.bGy();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0604a
            public void y(float f, float f2) {
                VideoPlayFragment LB = VideoPlayView.this.nyT.LB(VideoPlayView.this.nyS.getCurrentItem());
                if (LB != null) {
                    LB.y(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0604a
            public void bGz() {
                VideoPlayFragment LB = VideoPlayView.this.nyT.LB(VideoPlayView.this.nyS.getCurrentItem());
                if (LB != null) {
                    LB.bGz();
                }
            }
        });
        this.nyS.setOnPageChangeListener(this);
        this.nyS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment LB = VideoPlayView.this.nyT.LB(VideoPlayView.this.nyS.getCurrentItem());
                if (LB != null) {
                    return LB.dSc();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.nyY = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.nyY.setAnimation(R.raw.lottie_video_guide);
        this.nyY.setImageAssetsFolder("lottie_video_guide");
        this.nyY.setOnClickListener(this);
        this.nyY.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.nyY.isAnimating()) {
                    VideoPlayView.this.aX(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nyY.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.dSj();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.crO();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nza = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        crO();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.nyV = i;
        this.nyT.a(this.mDatas, rect);
        this.nyT.notifyDataSetChanged();
        this.nyS.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.nyT != null) {
            this.nyT.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.nyW = aVar;
    }

    public void TX(String str) {
        if (this.nyT != null) {
            this.nyT.mFrom = str;
        }
    }

    public void onDestroy() {
        crO();
        dSk();
        if (this.nyT != null) {
            this.nyT.dSf();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.nyU = i;
        if (this.nyV != i && this.nzb) {
            this.nzb = false;
        }
        if (!y.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.nyW != null) {
            this.nyW.bSU();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.nyT != null && this.nyS != null) {
            this.nyT.LC(this.nyS.getCurrentItem());
        }
    }

    public boolean dSc() {
        VideoPlayFragment LB;
        if (dSl()) {
            return true;
        }
        if (this.nyT == null || this.nyS == null || (LB = this.nyT.LB(this.nyS.getCurrentItem())) == null) {
            return false;
        }
        return LB.dSc();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment LB;
        if (this.nyT != null && this.nyS != null && (LB = this.nyT.LB(this.nyS.getCurrentItem())) != null) {
            LB.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            crO();
        }
    }

    private void dSg() {
        this.nyT.a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.f.b
            public void ce(int i, int i2) {
                VideoPlayView.this.dD(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.nza * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.nyS.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.nza * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.nyS.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.nza * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.nyS.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.nza * (0.92d - f) * 6.0d) : 0;
        }
        this.nyS.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSh() {
        if (this.nyU == this.nyV && this.nzb) {
            yq(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(int i, int i2) {
        int i3;
        if (!this.nzc && VideoPlayActivityConfig.FROM_DEFAULT.equals(TZ(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.nzb && i.dOx()) {
            yq(true);
            this.nzc = true;
            i.dOy();
        }
    }

    private void dSi() {
        this.nyS.scrollTo(0, 0);
    }

    private boolean yq(boolean z) {
        if (this.nyY == null) {
            return false;
        }
        if (this.nyZ || z) {
            this.nyY.setVisibility(0);
            this.nyY.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crO() {
        if (this.nyY != null) {
            if (this.nyY.isAnimating()) {
                this.nyY.pauseAnimation();
                dSi();
            }
            this.nyY.setVisibility(8);
        }
    }

    private boolean TY(String str) {
        return b.bpu().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + TZ(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dSj() {
        if (this.nyZ) {
            b.bpu().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + TZ(this.mFrom), false);
            this.nyZ = false;
        }
    }

    private String TZ(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void Ua(String str) {
        if (this.nyT != null) {
            this.nyT.nyL = str;
        }
    }

    private void dSk() {
        if (this.nzc) {
            i.dOA();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(TZ(this.mFrom))) {
            if (this.nzb) {
                i.dOz();
            } else {
                i.dOA();
            }
        }
    }

    private boolean dSl() {
        if (this.nyY == null || !this.nyY.isAnimating()) {
            return false;
        }
        crO();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201, i);
    }
}
