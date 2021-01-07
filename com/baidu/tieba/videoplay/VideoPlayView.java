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
    private VerticalViewPager nQp;
    private VideoPlayFragmentAdapter nQq;
    public int nQs;
    private a nQt;
    private VideoPlayActivity nQu;
    private TBLottieAnimationView nQv;
    private boolean nQw;
    private int nQx;
    public int nQr = 0;
    private boolean nQy = true;
    private boolean nQz = false;

    /* loaded from: classes8.dex */
    public interface a {
        void bZl();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.nQu = videoPlayActivity;
        this.mFrom = str;
        this.nQw = UR(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.nQp = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.nQq = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.nQq.a(new VideoPlayFragment.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.VideoPlayFragment.a
            public void onStart() {
                VideoPlayView.this.dXg();
            }
        });
        dXf();
        this.nQq.mFromPage = this.mFrom;
        this.nQp.setAdapter(this.nQq);
        this.nQp.setOffscreenPageLimit(1);
        this.nQp.setEventListener(new a.InterfaceC0608a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0608a
            public void bMr() {
                VideoPlayFragment Mg = VideoPlayView.this.nQq.Mg(VideoPlayView.this.nQp.getCurrentItem());
                if (Mg != null) {
                    Mg.bMr();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0608a
            public void y(float f, float f2) {
                VideoPlayFragment Mg = VideoPlayView.this.nQq.Mg(VideoPlayView.this.nQp.getCurrentItem());
                if (Mg != null) {
                    Mg.y(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0608a
            public void bMs() {
                VideoPlayFragment Mg = VideoPlayView.this.nQq.Mg(VideoPlayView.this.nQp.getCurrentItem());
                if (Mg != null) {
                    Mg.bMs();
                }
            }
        });
        this.nQp.setOnPageChangeListener(this);
        this.nQp.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment Mg = VideoPlayView.this.nQq.Mg(VideoPlayView.this.nQp.getCurrentItem());
                if (Mg != null) {
                    return Mg.dXb();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.nQv = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.nQv.setAnimation(R.raw.lottie_video_guide);
        this.nQv.setImageAssetsFolder("lottie_video_guide");
        this.nQv.setOnClickListener(this);
        this.nQv.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.nQv.isAnimating()) {
                    VideoPlayView.this.ba(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nQv.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.dXi();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.cyY();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nQx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        cyY();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.nQs = i;
        this.nQq.a(this.mDatas, rect);
        this.nQq.notifyDataSetChanged();
        this.nQp.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.nQq != null) {
            this.nQq.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.nQt = aVar;
    }

    public void UQ(String str) {
        if (this.nQq != null) {
            this.nQq.mFrom = str;
        }
    }

    public void onDestroy() {
        cyY();
        dXj();
        if (this.nQq != null) {
            this.nQq.dXe();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.nQr = i;
        if (this.nQs != i && this.nQy) {
            this.nQy = false;
        }
        if (!x.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.nQt != null) {
            this.nQt.bZl();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.nQq != null && this.nQp != null) {
            this.nQq.Mh(this.nQp.getCurrentItem());
        }
    }

    public boolean dXb() {
        VideoPlayFragment Mg;
        if (dXk()) {
            return true;
        }
        if (this.nQq == null || this.nQp == null || (Mg = this.nQq.Mg(this.nQp.getCurrentItem())) == null) {
            return false;
        }
        return Mg.dXb();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment Mg;
        if (this.nQq != null && this.nQp != null && (Mg = this.nQq.Mg(this.nQp.getCurrentItem())) != null) {
            Mg.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            cyY();
        }
    }

    private void dXf() {
        this.nQq.a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
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
            i = (int) (this.nQx * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.nQp.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.nQx * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.nQp.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.nQx * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.nQp.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.nQx * (0.92d - f) * 6.0d) : 0;
        }
        this.nQp.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXg() {
        if (this.nQr == this.nQs && this.nQy) {
            yV(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(int i, int i2) {
        int i3;
        if (!this.nQz && VideoPlayActivityConfig.FROM_DEFAULT.equals(US(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.nQy && h.dTI()) {
            yV(true);
            this.nQz = true;
            h.dTJ();
        }
    }

    private void dXh() {
        this.nQp.scrollTo(0, 0);
    }

    private boolean yV(boolean z) {
        if (this.nQv == null) {
            return false;
        }
        if (this.nQw || z) {
            this.nQv.setVisibility(0);
            this.nQv.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyY() {
        if (this.nQv != null) {
            if (this.nQv.isAnimating()) {
                this.nQv.pauseAnimation();
                dXh();
            }
            this.nQv.setVisibility(8);
        }
    }

    private boolean UR(String str) {
        return b.bvr().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + US(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXi() {
        if (this.nQw) {
            b.bvr().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + US(this.mFrom), false);
            this.nQw = false;
        }
    }

    private String US(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void UT(String str) {
        if (this.nQq != null) {
            this.nQq.nQi = str;
        }
    }

    private void dXj() {
        if (this.nQz) {
            h.dTL();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(US(this.mFrom))) {
            if (this.nQy) {
                h.dTK();
            } else {
                h.dTL();
            }
        }
    }

    private boolean dXk() {
        if (this.nQv == null || !this.nQv.isAnimating()) {
            return false;
        }
        cyY();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0201, i);
    }
}
