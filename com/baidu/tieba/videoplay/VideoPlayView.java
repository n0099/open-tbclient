package com.baidu.tieba.videoplay;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.viewpager.VerticalViewPager;
import com.baidu.tbadk.widget.viewpager.a;
import com.baidu.tieba.R;
import com.baidu.tieba.play.f;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.h;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import java.util.List;
/* loaded from: classes8.dex */
public class VideoPlayView implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    private VerticalViewPager nQq;
    private VideoPlayFragmentAdapter nQr;
    public int nQt;
    private a nQu;
    private VideoPlayActivity nQv;
    private TBLottieAnimationView nQw;
    private boolean nQx;
    private int nQy;
    public int nQs = 0;
    private boolean nQz = true;
    private boolean nQA = false;

    /* loaded from: classes8.dex */
    public interface a {
        void bZk();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.nQv = videoPlayActivity;
        this.mFrom = str;
        this.nQx = US(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.nQq = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.nQr = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.nQr.a(new VideoPlayFragment.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.VideoPlayFragment.a
            public void onStart() {
                VideoPlayView.this.dXf();
            }
        });
        dXe();
        this.nQr.mFromPage = this.mFrom;
        this.nQq.setAdapter(this.nQr);
        this.nQq.setOffscreenPageLimit(1);
        this.nQq.setEventListener(new a.InterfaceC0608a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0608a
            public void bMq() {
                VideoPlayFragment Mg = VideoPlayView.this.nQr.Mg(VideoPlayView.this.nQq.getCurrentItem());
                if (Mg != null) {
                    Mg.bMq();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0608a
            public void y(float f, float f2) {
                VideoPlayFragment Mg = VideoPlayView.this.nQr.Mg(VideoPlayView.this.nQq.getCurrentItem());
                if (Mg != null) {
                    Mg.y(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0608a
            public void bMr() {
                VideoPlayFragment Mg = VideoPlayView.this.nQr.Mg(VideoPlayView.this.nQq.getCurrentItem());
                if (Mg != null) {
                    Mg.bMr();
                }
            }
        });
        this.nQq.setOnPageChangeListener(this);
        this.nQq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment Mg = VideoPlayView.this.nQr.Mg(VideoPlayView.this.nQq.getCurrentItem());
                if (Mg != null) {
                    return Mg.dXa();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.nQw = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.nQw.setAnimation(R.raw.lottie_video_guide);
        this.nQw.setImageAssetsFolder("lottie_video_guide");
        this.nQw.setOnClickListener(this);
        this.nQw.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.nQw.isAnimating()) {
                    VideoPlayView.this.ba(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nQw.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.dXh();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.cyX();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nQy = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        cyX();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.nQt = i;
        this.nQr.a(this.mDatas, rect);
        this.nQr.notifyDataSetChanged();
        this.nQq.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.nQr != null) {
            this.nQr.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.nQu = aVar;
    }

    public void UR(String str) {
        if (this.nQr != null) {
            this.nQr.mFrom = str;
        }
    }

    public void onDestroy() {
        cyX();
        dXi();
        if (this.nQr != null) {
            this.nQr.dXd();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.nQs = i;
        if (this.nQt != i && this.nQz) {
            this.nQz = false;
        }
        if (!x.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.nQu != null) {
            this.nQu.bZk();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.nQr != null && this.nQq != null) {
            this.nQr.Mh(this.nQq.getCurrentItem());
        }
    }

    public boolean dXa() {
        VideoPlayFragment Mg;
        if (dXj()) {
            return true;
        }
        if (this.nQr == null || this.nQq == null || (Mg = this.nQr.Mg(this.nQq.getCurrentItem())) == null) {
            return false;
        }
        return Mg.dXa();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment Mg;
        if (this.nQr != null && this.nQq != null && (Mg = this.nQr.Mg(this.nQq.getCurrentItem())) != null) {
            Mg.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            cyX();
        }
    }

    private void dXe() {
        this.nQr.a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.f.b
            public void ch(int i, int i2) {
                VideoPlayView.this.dD(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.nQy * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.nQq.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.nQy * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.nQq.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.nQy * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.nQq.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.nQy * (0.92d - f) * 6.0d) : 0;
        }
        this.nQq.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXf() {
        if (this.nQs == this.nQt && this.nQz) {
            yV(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(int i, int i2) {
        int i3;
        if (!this.nQA && VideoPlayActivityConfig.FROM_DEFAULT.equals(UT(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.nQz && h.dTH()) {
            yV(true);
            this.nQA = true;
            h.dTI();
        }
    }

    private void dXg() {
        this.nQq.scrollTo(0, 0);
    }

    private boolean yV(boolean z) {
        if (this.nQw == null) {
            return false;
        }
        if (this.nQx || z) {
            this.nQw.setVisibility(0);
            this.nQw.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyX() {
        if (this.nQw != null) {
            if (this.nQw.isAnimating()) {
                this.nQw.pauseAnimation();
                dXg();
            }
            this.nQw.setVisibility(8);
        }
    }

    private boolean US(String str) {
        return b.bvq().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + UT(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXh() {
        if (this.nQx) {
            b.bvq().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + UT(this.mFrom), false);
            this.nQx = false;
        }
    }

    private String UT(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void UU(String str) {
        if (this.nQr != null) {
            this.nQr.nQj = str;
        }
    }

    private void dXi() {
        if (this.nQA) {
            h.dTK();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(UT(this.mFrom))) {
            if (this.nQz) {
                h.dTJ();
            } else {
                h.dTK();
            }
        }
    }

    private boolean dXj() {
        if (this.nQw == null || !this.nQw.isAnimating()) {
            return false;
        }
        cyX();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201, i);
    }
}
