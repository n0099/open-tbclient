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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.core.util.y;
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
    private VerticalViewPager nVY;
    private VideoPlayFragmentAdapter nVZ;
    public int nWb;
    private a nWc;
    private VideoPlayActivity nWd;
    private TBLottieAnimationView nWe;
    private boolean nWf;
    private int nWg;
    private boolean nWj;
    private float nWk;
    public int nWa = 0;
    private int nWl = UtilHelper.getDimenPixelSize(R.dimen.tbds35);
    private int nWm = 2049;
    private boolean nWh = true;
    private boolean nWi = false;

    /* loaded from: classes8.dex */
    public interface a {
        void bWe();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.nWd = videoPlayActivity;
        this.mFrom = str;
        this.nWf = UT(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.nVY = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.nVZ = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.nVZ.a(new VideoPlayFragment.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.VideoPlayFragment.a
            public void onStart() {
                VideoPlayView.this.dVI();
            }
        });
        dVH();
        this.nVZ.mFromPage = this.mFrom;
        this.nVY.setAdapter(this.nVZ);
        this.nVY.setOffscreenPageLimit(1);
        this.nVY.setEventListener(new a.InterfaceC0588a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0588a
            public void bIS() {
                VideoPlayFragment KU = VideoPlayView.this.nVZ.KU(VideoPlayView.this.nVY.getCurrentItem());
                if (KU != null) {
                    KU.bIS();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0588a
            public void z(float f, float f2) {
                VideoPlayFragment KU = VideoPlayView.this.nVZ.KU(VideoPlayView.this.nVY.getCurrentItem());
                if (KU != null) {
                    KU.z(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0588a
            public void bIT() {
                VideoPlayFragment KU = VideoPlayView.this.nVZ.KU(VideoPlayView.this.nVY.getCurrentItem());
                if (KU != null) {
                    KU.bIT();
                }
            }
        });
        this.nVY.setOnPageChangeListener(this);
        this.nVY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        VideoPlayView.this.nWk = motionEvent.getY();
                        VideoPlayView.this.nWj = false;
                        break;
                    case 1:
                    case 3:
                        VideoPlayView.this.nWk = 0.0f;
                        break;
                    case 2:
                        if (VideoPlayView.this.nWk == 0.0f) {
                            VideoPlayView.this.nWk = motionEvent.getY();
                        }
                        float y = motionEvent.getY() - VideoPlayView.this.nWk;
                        if (VideoPlayView.this.nWk > (l.h(TbadkCoreApplication.getInst(), true) - UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst())) - VideoPlayView.this.nWl && y < UtilHelper.getDimenPixelSize(R.dimen.tbds25) && UtilHelper.hasNavBar(VideoPlayView.this.nWd) && l.h(TbadkCoreApplication.getInst(), true) != VideoPlayView.this.nWm) {
                            VideoPlayView.this.nWj = true;
                            break;
                        }
                        break;
                }
                VideoPlayFragment KU = VideoPlayView.this.nVZ.KU(VideoPlayView.this.nVY.getCurrentItem());
                if (KU != null) {
                    return KU.dVC();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.nWe = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.nWe.setAnimation(R.raw.lottie_video_guide);
        this.nWe.setImageAssetsFolder("lottie_video_guide");
        this.nWe.setOnClickListener(this);
        this.nWe.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.nWe.isAnimating()) {
                    VideoPlayView.this.bd(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nWe.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.dVK();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.cwz();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nWg = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        cwz();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.nWb = i;
        this.nVZ.a(this.mDatas, rect);
        this.nVZ.notifyDataSetChanged();
        this.nVY.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.nVZ != null) {
            this.nVZ.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.nWc = aVar;
    }

    public void US(String str) {
        if (this.nVZ != null) {
            this.nVZ.mFrom = str;
        }
    }

    public void onDestroy() {
        cwz();
        dVL();
        if (this.nVZ != null) {
            this.nVZ.dVF();
        }
        this.nWd = null;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (i2 > l.getEquipmentHeight(TbadkCoreApplication.getInst())) {
            this.nWj = true;
        }
        if (dVG()) {
            this.nVY.setNeedHanleTouch(true);
        } else {
            this.nVY.setNeedHanleTouch(false);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.nWa = i;
        if (this.nWb != i && this.nWh) {
            this.nWh = false;
        }
        if (!y.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.nWc != null) {
            this.nWc.bWe();
        }
        if (dVG()) {
            this.nVY.computeScroll();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.nVZ != null && this.nVY != null) {
            this.nVZ.KV(this.nVY.getCurrentItem());
            if (dVG()) {
                this.nVY.setNeedHanleTouch(true);
                this.nVY.setSelected(true);
                this.nVY.setCurrentItem(this.nVY.getCurrentItem(), true);
                this.nVY.setNeedHanleTouch(false);
                this.nWj = false;
            }
        }
    }

    private boolean dVG() {
        return g.bsc() && this.nWj && UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst()) > 0;
    }

    public boolean dVC() {
        VideoPlayFragment KU;
        if (dVM()) {
            return true;
        }
        if (this.nVZ == null || this.nVY == null || (KU = this.nVZ.KU(this.nVY.getCurrentItem())) == null) {
            return false;
        }
        return KU.dVC();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment KU;
        if (this.nVZ != null && this.nVY != null && (KU = this.nVZ.KU(this.nVY.getCurrentItem())) != null) {
            KU.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            cwz();
        }
    }

    private void dVH() {
        this.nVZ.a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.f.b
            public void cf(int i, int i2) {
                VideoPlayView.this.dB(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.nWg * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.nVY.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.nWg * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.nVY.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.nWg * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.nVY.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.nWg * (0.92d - f) * 6.0d) : 0;
        }
        this.nVY.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVI() {
        if (this.nWa == this.nWb && this.nWh) {
            zm(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dB(int i, int i2) {
        int i3;
        if (!this.nWi && VideoPlayActivityConfig.FROM_DEFAULT.equals(UU(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.nWh && h.dSj()) {
            zm(true);
            this.nWi = true;
            h.dSk();
        }
    }

    private void dVJ() {
        this.nVY.scrollTo(0, 0);
    }

    private boolean zm(boolean z) {
        if (this.nWe == null) {
            return false;
        }
        if (this.nWf || z) {
            this.nWe.setVisibility(0);
            this.nWe.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwz() {
        if (this.nWe != null) {
            if (this.nWe.isAnimating()) {
                this.nWe.pauseAnimation();
                dVJ();
            }
            this.nWe.setVisibility(8);
        }
    }

    private boolean UT(String str) {
        return b.brQ().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + UU(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVK() {
        if (this.nWf) {
            b.brQ().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + UU(this.mFrom), false);
            this.nWf = false;
        }
    }

    private String UU(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void UV(String str) {
        if (this.nVZ != null) {
            this.nVZ.nVR = str;
        }
    }

    private void dVL() {
        if (this.nWi) {
            h.dSm();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(UU(this.mFrom))) {
            if (this.nWh) {
                h.dSl();
            } else {
                h.dSm();
            }
        }
    }

    private boolean dVM() {
        if (this.nWe == null || !this.nWe.isAnimating()) {
            return false;
        }
        cwz();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201, i);
        if (!UtilHelper.isFlyMeOs()) {
            UtilHelper.changeStatusBarIconAndTextColor(true, this.nWd);
        }
    }
}
