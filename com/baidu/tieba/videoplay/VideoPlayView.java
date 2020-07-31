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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.viewpager.VerticalViewPager;
import com.baidu.tbadk.widget.viewpager.a;
import com.baidu.tieba.R;
import com.baidu.tieba.play.f;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.i;
import com.baidu.tieba.videoplay.VideoPlayFragment;
import java.util.List;
/* loaded from: classes18.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private List<VideoItemData> mDatas;
    private String mFrom;
    private View mRootView;
    private VerticalViewPager mnQ;
    private VideoPlayFragmentAdapter mnR;
    public int mnT;
    private a mnU;
    private VideoPlayActivity mnV;
    private TBLottieAnimationView mnW;
    private boolean mnX;
    private int mnY;
    public int mnS = 0;
    private boolean mnZ = true;
    private boolean moa = false;

    /* loaded from: classes18.dex */
    public interface a {
        void bBi();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.mnV = videoPlayActivity;
        this.mFrom = str;
        this.mnX = Pl(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.mnQ = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.mnR = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.mnR.a(new VideoPlayFragment.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.VideoPlayFragment.a
            public void onStart() {
                VideoPlayView.this.dtn();
            }
        });
        dtm();
        this.mnR.mFromPage = this.mFrom;
        this.mnQ.setAdapter(this.mnR);
        this.mnQ.setOffscreenPageLimit(1);
        this.mnQ.setEventListener(new a.InterfaceC0520a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0520a
            public void bqf() {
                VideoPlayFragment GN = VideoPlayView.this.mnR.GN(VideoPlayView.this.mnQ.getCurrentItem());
                if (GN != null) {
                    GN.bqf();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0520a
            public void t(float f, float f2) {
                VideoPlayFragment GN = VideoPlayView.this.mnR.GN(VideoPlayView.this.mnQ.getCurrentItem());
                if (GN != null) {
                    GN.t(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0520a
            public void bqg() {
                VideoPlayFragment GN = VideoPlayView.this.mnR.GN(VideoPlayView.this.mnQ.getCurrentItem());
                if (GN != null) {
                    GN.bqg();
                }
            }
        });
        this.mnQ.setOnPageChangeListener(this);
        this.mnQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment GN = VideoPlayView.this.mnR.GN(VideoPlayView.this.mnQ.getCurrentItem());
                if (GN != null) {
                    return GN.dti();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.mnW = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.mnW.setAnimation(R.raw.lottie_video_guide);
        this.mnW.setImageAssetsFolder("lottie_video_guide");
        this.mnW.setOnClickListener(this);
        this.mnW.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.mnW.isAnimating()) {
                    VideoPlayView.this.aA(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.mnW.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.dtp();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPlayView.this.bVC();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mnY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        bVC();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.mnT = i;
        this.mnR.a(this.mDatas, rect);
        this.mnR.notifyDataSetChanged();
        this.mnQ.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.mnR != null) {
            this.mnR.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.mnU = aVar;
    }

    public void Pk(String str) {
        if (this.mnR != null) {
            this.mnR.mFrom = str;
        }
    }

    public void onDestroy() {
        bVC();
        dtq();
        if (this.mnR != null) {
            this.mnR.dtl();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mnS = i;
        if (this.mnT != i && this.mnZ) {
            this.mnZ = false;
        }
        if (!x.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.mnU != null) {
            this.mnU.bBi();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.mnR != null && this.mnQ != null) {
            this.mnR.GO(this.mnQ.getCurrentItem());
        }
    }

    public boolean dti() {
        VideoPlayFragment GN;
        if (dtr()) {
            return true;
        }
        if (this.mnR == null || this.mnQ == null || (GN = this.mnR.GN(this.mnQ.getCurrentItem())) == null) {
            return false;
        }
        return GN.dti();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment GN;
        if (this.mnR != null && this.mnQ != null && (GN = this.mnR.GN(this.mnQ.getCurrentItem())) != null) {
            GN.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            bVC();
        }
    }

    private void dtm() {
        this.mnR.a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
            @Override // com.baidu.tieba.play.f.b
            public void bP(int i, int i2) {
                VideoPlayView.this.dm(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(float f) {
        int i;
        if (f <= 0.17d) {
            i = (int) (this.mnY * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.mnQ.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.mnY * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.mnQ.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.mnY * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.mnQ.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.mnY * (0.92d - f) * 6.0d) : 0;
        }
        this.mnQ.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtn() {
        if (this.mnS == this.mnT && this.mnZ) {
            wc(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dm(int i, int i2) {
        int i3;
        if (!this.moa && VideoPlayActivityConfig.FROM_DEFAULT.equals(Pm(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.mnZ && i.dpD()) {
            wc(true);
            this.moa = true;
            i.dpE();
        }
    }

    private void dto() {
        this.mnQ.scrollTo(0, 0);
    }

    private boolean wc(boolean z) {
        if (this.mnW == null) {
            return false;
        }
        if (this.mnX || z) {
            this.mnW.setVisibility(0);
            this.mnW.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVC() {
        if (this.mnW != null) {
            if (this.mnW.isAnimating()) {
                this.mnW.pauseAnimation();
                dto();
            }
            this.mnW.setVisibility(8);
        }
    }

    private boolean Pl(String str) {
        return b.aZP().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Pm(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtp() {
        if (this.mnX) {
            b.aZP().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Pm(this.mFrom), false);
            this.mnX = false;
        }
    }

    private String Pm(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void Pn(String str) {
        if (this.mnR != null) {
            this.mnR.mnJ = str;
        }
    }

    private void dtq() {
        if (this.moa) {
            i.dpG();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Pm(this.mFrom))) {
            if (this.mnZ) {
                i.dpF();
            } else {
                i.dpG();
            }
        }
    }

    private boolean dtr() {
        if (this.mnW == null || !this.mnW.isAnimating()) {
            return false;
        }
        bVC();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d, i);
    }
}
