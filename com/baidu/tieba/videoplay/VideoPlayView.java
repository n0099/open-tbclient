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
/* loaded from: classes24.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    private VerticalViewPager nfp;
    private VideoPlayFragmentAdapter nfq;
    public int nfs;
    private a nft;
    private VideoPlayActivity nfu;
    private TBLottieAnimationView nfv;
    private boolean nfw;
    private int nfx;
    public int nfr = 0;
    private boolean nfy = true;
    private boolean nfz = false;

    /* loaded from: classes24.dex */
    public interface a {
        void bOx();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.nfu = videoPlayActivity;
        this.mFrom = str;
        this.nfw = Tx(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.nfp = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.nfq = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.nfq.a(new VideoPlayFragment.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.VideoPlayFragment.a
            public void onStart() {
                VideoPlayView.this.dMy();
            }
        });
        dMx();
        this.nfq.mFromPage = this.mFrom;
        this.nfp.setAdapter(this.nfq);
        this.nfp.setOffscreenPageLimit(1);
        this.nfp.setEventListener(new a.InterfaceC0579a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0579a
            public void bCN() {
                VideoPlayFragment Kt = VideoPlayView.this.nfq.Kt(VideoPlayView.this.nfp.getCurrentItem());
                if (Kt != null) {
                    Kt.bCN();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0579a
            public void y(float f, float f2) {
                VideoPlayFragment Kt = VideoPlayView.this.nfq.Kt(VideoPlayView.this.nfp.getCurrentItem());
                if (Kt != null) {
                    Kt.y(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0579a
            public void bCO() {
                VideoPlayFragment Kt = VideoPlayView.this.nfq.Kt(VideoPlayView.this.nfp.getCurrentItem());
                if (Kt != null) {
                    Kt.bCO();
                }
            }
        });
        this.nfp.setOnPageChangeListener(this);
        this.nfp.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment Kt = VideoPlayView.this.nfq.Kt(VideoPlayView.this.nfp.getCurrentItem());
                if (Kt != null) {
                    return Kt.dMt();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.nfv = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.nfv.setAnimation(R.raw.lottie_video_guide);
        this.nfv.setImageAssetsFolder("lottie_video_guide");
        this.nfv.setOnClickListener(this);
        this.nfv.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.nfv.isAnimating()) {
                    VideoPlayView.this.aM(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.nfv.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.dMA();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.cmD();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nfx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        cmD();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.nfs = i;
        this.nfq.a(this.mDatas, rect);
        this.nfq.notifyDataSetChanged();
        this.nfp.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.nfq != null) {
            this.nfq.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.nft = aVar;
    }

    public void Tw(String str) {
        if (this.nfq != null) {
            this.nfq.mFrom = str;
        }
    }

    public void onDestroy() {
        cmD();
        dMB();
        if (this.nfq != null) {
            this.nfq.dMw();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.nfr = i;
        if (this.nfs != i && this.nfy) {
            this.nfy = false;
        }
        if (!y.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.nft != null) {
            this.nft.bOx();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.nfq != null && this.nfp != null) {
            this.nfq.Ku(this.nfp.getCurrentItem());
        }
    }

    public boolean dMt() {
        VideoPlayFragment Kt;
        if (dMC()) {
            return true;
        }
        if (this.nfq == null || this.nfp == null || (Kt = this.nfq.Kt(this.nfp.getCurrentItem())) == null) {
            return false;
        }
        return Kt.dMt();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment Kt;
        if (this.nfq != null && this.nfp != null && (Kt = this.nfq.Kt(this.nfp.getCurrentItem())) != null) {
            Kt.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            cmD();
        }
    }

    private void dMx() {
        this.nfq.a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.f.b
            public void ca(int i, int i2) {
                VideoPlayView.this.dy(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aM(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.nfx * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.nfp.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.nfx * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.nfp.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.nfx * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.nfp.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.nfx * (0.92d - f) * 6.0d) : 0;
        }
        this.nfp.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMy() {
        if (this.nfr == this.nfs && this.nfy) {
            xJ(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dy(int i, int i2) {
        int i3;
        if (!this.nfz && VideoPlayActivityConfig.FROM_DEFAULT.equals(Ty(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.nfy && i.dIO()) {
            xJ(true);
            this.nfz = true;
            i.dIP();
        }
    }

    private void dMz() {
        this.nfp.scrollTo(0, 0);
    }

    private boolean xJ(boolean z) {
        if (this.nfv == null) {
            return false;
        }
        if (this.nfw || z) {
            this.nfv.setVisibility(0);
            this.nfv.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmD() {
        if (this.nfv != null) {
            if (this.nfv.isAnimating()) {
                this.nfv.pauseAnimation();
                dMz();
            }
            this.nfv.setVisibility(8);
        }
    }

    private boolean Tx(String str) {
        return b.blO().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Ty(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMA() {
        if (this.nfw) {
            b.blO().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Ty(this.mFrom), false);
            this.nfw = false;
        }
    }

    private String Ty(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void Tz(String str) {
        if (this.nfq != null) {
            this.nfq.nfi = str;
        }
    }

    private void dMB() {
        if (this.nfz) {
            i.dIR();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Ty(this.mFrom))) {
            if (this.nfy) {
                i.dIQ();
            } else {
                i.dIR();
            }
        }
    }

    private boolean dMC() {
        if (this.nfv == null || !this.nfv.isAnimating()) {
            return false;
        }
        cmD();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
