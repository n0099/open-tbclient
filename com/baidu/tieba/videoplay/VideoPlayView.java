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
/* loaded from: classes7.dex */
public class VideoPlayView implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    private VerticalViewPager nYc;
    private VideoPlayFragmentAdapter nYd;
    public int nYf;
    private a nYg;
    private VideoPlayActivity nYh;
    private TBLottieAnimationView nYi;
    private boolean nYj;
    private int nYk;
    private boolean nYn;
    private float nYo;
    public int nYe = 0;
    private int nYp = UtilHelper.getDimenPixelSize(R.dimen.tbds35);
    private int nYq = 2049;
    private boolean nYl = true;
    private boolean nYm = false;

    /* loaded from: classes7.dex */
    public interface a {
        void bWk();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.nYh = videoPlayActivity;
        this.mFrom = str;
        this.nYj = Va(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.nYc = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.nYd = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.nYd.a(new VideoPlayFragment.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.VideoPlayFragment.a
            public void onStart() {
                VideoPlayView.this.dVQ();
            }
        });
        dVP();
        this.nYd.mFromPage = this.mFrom;
        this.nYc.setAdapter(this.nYd);
        this.nYc.setOffscreenPageLimit(1);
        this.nYc.setEventListener(new a.InterfaceC0594a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0594a
            public void bIW() {
                VideoPlayFragment KY = VideoPlayView.this.nYd.KY(VideoPlayView.this.nYc.getCurrentItem());
                if (KY != null) {
                    KY.bIW();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0594a
            public void z(float f, float f2) {
                VideoPlayFragment KY = VideoPlayView.this.nYd.KY(VideoPlayView.this.nYc.getCurrentItem());
                if (KY != null) {
                    KY.z(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0594a
            public void bIX() {
                VideoPlayFragment KY = VideoPlayView.this.nYd.KY(VideoPlayView.this.nYc.getCurrentItem());
                if (KY != null) {
                    KY.bIX();
                }
            }
        });
        this.nYc.setOnPageChangeListener(this);
        this.nYc.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        VideoPlayView.this.nYo = motionEvent.getY();
                        VideoPlayView.this.nYn = false;
                        break;
                    case 1:
                    case 3:
                        VideoPlayView.this.nYo = 0.0f;
                        break;
                    case 2:
                        if (VideoPlayView.this.nYo == 0.0f) {
                            VideoPlayView.this.nYo = motionEvent.getY();
                        }
                        float y = motionEvent.getY() - VideoPlayView.this.nYo;
                        if (VideoPlayView.this.nYo > (l.h(TbadkCoreApplication.getInst(), true) - UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst())) - VideoPlayView.this.nYp && y < UtilHelper.getDimenPixelSize(R.dimen.tbds25) && UtilHelper.hasNavBar(VideoPlayView.this.nYh) && l.h(TbadkCoreApplication.getInst(), true) != VideoPlayView.this.nYq) {
                            VideoPlayView.this.nYn = true;
                            break;
                        }
                        break;
                }
                VideoPlayFragment KY = VideoPlayView.this.nYd.KY(VideoPlayView.this.nYc.getCurrentItem());
                if (KY != null) {
                    return KY.dVK();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.nYi = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.nYi.setAnimation(R.raw.lottie_video_guide);
        this.nYi.setImageAssetsFolder("lottie_video_guide");
        this.nYi.setOnClickListener(this);
        this.nYi.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.nYi.isAnimating()) {
                    VideoPlayView.this.bh(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nYi.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.dVS();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.cwF();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nYk = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        cwF();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.nYf = i;
        this.nYd.a(this.mDatas, rect);
        this.nYd.notifyDataSetChanged();
        this.nYc.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.nYd != null) {
            this.nYd.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.nYg = aVar;
    }

    public void UZ(String str) {
        if (this.nYd != null) {
            this.nYd.mFrom = str;
        }
    }

    public void onDestroy() {
        cwF();
        dVT();
        if (this.nYd != null) {
            this.nYd.dVN();
        }
        this.nYh = null;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (i2 > l.getEquipmentHeight(TbadkCoreApplication.getInst())) {
            this.nYn = true;
        }
        if (dVO()) {
            this.nYc.setNeedHanleTouch(true);
        } else {
            this.nYc.setNeedHanleTouch(false);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.nYe = i;
        if (this.nYf != i && this.nYl) {
            this.nYl = false;
        }
        if (!y.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.nYg != null) {
            this.nYg.bWk();
        }
        if (dVO()) {
            this.nYc.computeScroll();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.nYd != null && this.nYc != null) {
            this.nYd.KZ(this.nYc.getCurrentItem());
            if (dVO()) {
                this.nYc.setNeedHanleTouch(true);
                this.nYc.setSelected(true);
                this.nYc.setCurrentItem(this.nYc.getCurrentItem(), true);
                this.nYc.setNeedHanleTouch(false);
                this.nYn = false;
            }
        }
    }

    private boolean dVO() {
        return g.bsd() && this.nYn && UtilHelper.getNavigationBarHeight(TbadkCoreApplication.getInst()) > 0;
    }

    public boolean dVK() {
        VideoPlayFragment KY;
        if (dVU()) {
            return true;
        }
        if (this.nYd == null || this.nYc == null || (KY = this.nYd.KY(this.nYc.getCurrentItem())) == null) {
            return false;
        }
        return KY.dVK();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment KY;
        if (this.nYd != null && this.nYc != null && (KY = this.nYd.KY(this.nYc.getCurrentItem())) != null) {
            KY.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            cwF();
        }
    }

    private void dVP() {
        this.nYd.a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.f.b
            public void cf(int i, int i2) {
                VideoPlayView.this.dB(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bh(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.nYk * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.nYc.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.nYk * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.nYc.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.nYk * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.nYc.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.nYk * (0.92d - f) * 6.0d) : 0;
        }
        this.nYc.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVQ() {
        if (this.nYe == this.nYf && this.nYl) {
            zl(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dB(int i, int i2) {
        int i3;
        if (!this.nYm && VideoPlayActivityConfig.FROM_DEFAULT.equals(Vb(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.nYl && h.dSr()) {
            zl(true);
            this.nYm = true;
            h.dSs();
        }
    }

    private void dVR() {
        this.nYc.scrollTo(0, 0);
    }

    private boolean zl(boolean z) {
        if (this.nYi == null) {
            return false;
        }
        if (this.nYj || z) {
            this.nYi.setVisibility(0);
            this.nYi.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwF() {
        if (this.nYi != null) {
            if (this.nYi.isAnimating()) {
                this.nYi.pauseAnimation();
                dVR();
            }
            this.nYi.setVisibility(8);
        }
    }

    private boolean Va(String str) {
        return b.brR().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Vb(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVS() {
        if (this.nYj) {
            b.brR().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Vb(this.mFrom), false);
            this.nYj = false;
        }
    }

    private String Vb(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void Vc(String str) {
        if (this.nYd != null) {
            this.nYd.nXV = str;
        }
    }

    private void dVT() {
        if (this.nYm) {
            h.dSu();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Vb(this.mFrom))) {
            if (this.nYl) {
                h.dSt();
            } else {
                h.dSu();
            }
        }
    }

    private boolean dVU() {
        if (this.nYi == null || !this.nYi.isAnimating()) {
            return false;
        }
        cwF();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0201, i);
        if (!UtilHelper.isFlyMeOs()) {
            UtilHelper.changeStatusBarIconAndTextColor(true, this.nYh);
        }
    }
}
