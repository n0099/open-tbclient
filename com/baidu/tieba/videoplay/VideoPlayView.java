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
    public int nVB;
    private a nVC;
    private VideoPlayActivity nVD;
    private TBLottieAnimationView nVE;
    private boolean nVF;
    private int nVG;
    private boolean nVJ;
    private float nVK;
    private VerticalViewPager nVy;
    private VideoPlayFragmentAdapter nVz;
    public int nVA = 0;
    private int nVL = UtilHelper.getDimenPixelSize(R.dimen.tbds35);
    private int nVM = 2049;
    private boolean nVH = true;
    private boolean nVI = false;

    /* loaded from: classes8.dex */
    public interface a {
        void bVX();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.nVD = videoPlayActivity;
        this.mFrom = str;
        this.nVF = UH(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.nVy = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.nVz = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.nVz.a(new VideoPlayFragment.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.VideoPlayFragment.a
            public void onStart() {
                VideoPlayView.this.dVA();
            }
        });
        dVz();
        this.nVz.mFromPage = this.mFrom;
        this.nVy.setAdapter(this.nVz);
        this.nVy.setOffscreenPageLimit(1);
        this.nVy.setEventListener(new a.InterfaceC0588a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0588a
            public void bIS() {
                VideoPlayFragment KT = VideoPlayView.this.nVz.KT(VideoPlayView.this.nVy.getCurrentItem());
                if (KT != null) {
                    KT.bIS();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0588a
            public void z(float f, float f2) {
                VideoPlayFragment KT = VideoPlayView.this.nVz.KT(VideoPlayView.this.nVy.getCurrentItem());
                if (KT != null) {
                    KT.z(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0588a
            public void bIT() {
                VideoPlayFragment KT = VideoPlayView.this.nVz.KT(VideoPlayView.this.nVy.getCurrentItem());
                if (KT != null) {
                    KT.bIT();
                }
            }
        });
        this.nVy.setOnPageChangeListener(this);
        this.nVy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        VideoPlayView.this.nVK = motionEvent.getY();
                        VideoPlayView.this.nVJ = false;
                        break;
                    case 1:
                    case 3:
                        VideoPlayView.this.nVK = 0.0f;
                        break;
                    case 2:
                        if (VideoPlayView.this.nVK == 0.0f) {
                            VideoPlayView.this.nVK = motionEvent.getY();
                        }
                        float y = motionEvent.getY() - VideoPlayView.this.nVK;
                        if (VideoPlayView.this.nVK > (l.h(TbadkCoreApplication.getInst(), true) - UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst())) - VideoPlayView.this.nVL && y < UtilHelper.getDimenPixelSize(R.dimen.tbds25) && UtilHelper.hasNavBar(VideoPlayView.this.nVD) && l.h(TbadkCoreApplication.getInst(), true) != VideoPlayView.this.nVM) {
                            VideoPlayView.this.nVJ = true;
                            break;
                        }
                        break;
                }
                VideoPlayFragment KT = VideoPlayView.this.nVz.KT(VideoPlayView.this.nVy.getCurrentItem());
                if (KT != null) {
                    return KT.dVu();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.nVE = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.nVE.setAnimation(R.raw.lottie_video_guide);
        this.nVE.setImageAssetsFolder("lottie_video_guide");
        this.nVE.setOnClickListener(this);
        this.nVE.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.nVE.isAnimating()) {
                    VideoPlayView.this.bd(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nVE.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.dVC();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.cws();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nVG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        cws();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.nVB = i;
        this.nVz.a(this.mDatas, rect);
        this.nVz.notifyDataSetChanged();
        this.nVy.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.nVz != null) {
            this.nVz.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.nVC = aVar;
    }

    public void UG(String str) {
        if (this.nVz != null) {
            this.nVz.mFrom = str;
        }
    }

    public void onDestroy() {
        cws();
        dVD();
        if (this.nVz != null) {
            this.nVz.dVx();
        }
        this.nVD = null;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (i2 > l.getEquipmentHeight(TbadkCoreApplication.getInst())) {
            this.nVJ = true;
        }
        if (dVy()) {
            this.nVy.setNeedHanleTouch(true);
        } else {
            this.nVy.setNeedHanleTouch(false);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.nVA = i;
        if (this.nVB != i && this.nVH) {
            this.nVH = false;
        }
        if (!y.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.nVC != null) {
            this.nVC.bVX();
        }
        if (dVy()) {
            this.nVy.computeScroll();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.nVz != null && this.nVy != null) {
            this.nVz.KU(this.nVy.getCurrentItem());
            if (dVy()) {
                this.nVy.setNeedHanleTouch(true);
                this.nVy.setSelected(true);
                this.nVy.setCurrentItem(this.nVy.getCurrentItem(), true);
                this.nVy.setNeedHanleTouch(false);
                this.nVJ = false;
            }
        }
    }

    private boolean dVy() {
        return g.bsc() && this.nVJ && UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst()) > 0;
    }

    public boolean dVu() {
        VideoPlayFragment KT;
        if (dVE()) {
            return true;
        }
        if (this.nVz == null || this.nVy == null || (KT = this.nVz.KT(this.nVy.getCurrentItem())) == null) {
            return false;
        }
        return KT.dVu();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment KT;
        if (this.nVz != null && this.nVy != null && (KT = this.nVz.KT(this.nVy.getCurrentItem())) != null) {
            KT.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            cws();
        }
    }

    private void dVz() {
        this.nVz.a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.f.b
            public void ce(int i, int i2) {
                VideoPlayView.this.dA(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.nVG * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.nVy.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.nVG * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.nVy.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.nVG * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.nVy.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.nVG * (0.92d - f) * 6.0d) : 0;
        }
        this.nVy.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVA() {
        if (this.nVA == this.nVB && this.nVH) {
            zm(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dA(int i, int i2) {
        int i3;
        if (!this.nVI && VideoPlayActivityConfig.FROM_DEFAULT.equals(UI(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.nVH && h.dSb()) {
            zm(true);
            this.nVI = true;
            h.dSc();
        }
    }

    private void dVB() {
        this.nVy.scrollTo(0, 0);
    }

    private boolean zm(boolean z) {
        if (this.nVE == null) {
            return false;
        }
        if (this.nVF || z) {
            this.nVE.setVisibility(0);
            this.nVE.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cws() {
        if (this.nVE != null) {
            if (this.nVE.isAnimating()) {
                this.nVE.pauseAnimation();
                dVB();
            }
            this.nVE.setVisibility(8);
        }
    }

    private boolean UH(String str) {
        return b.brQ().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + UI(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVC() {
        if (this.nVF) {
            b.brQ().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + UI(this.mFrom), false);
            this.nVF = false;
        }
    }

    private String UI(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void UJ(String str) {
        if (this.nVz != null) {
            this.nVz.nVr = str;
        }
    }

    private void dVD() {
        if (this.nVI) {
            h.dSe();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(UI(this.mFrom))) {
            if (this.nVH) {
                h.dSd();
            } else {
                h.dSe();
            }
        }
    }

    private boolean dVE() {
        if (this.nVE == null || !this.nVE.isAnimating()) {
            return false;
        }
        cws();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201, i);
        if (!UtilHelper.isFlyMeOs()) {
            UtilHelper.changeStatusBarIconAndTextColor(true, this.nVD);
        }
    }
}
