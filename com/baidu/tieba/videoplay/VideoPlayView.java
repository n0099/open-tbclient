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
    private VerticalViewPager mnS;
    private VideoPlayFragmentAdapter mnT;
    public int mnV;
    private a mnW;
    private VideoPlayActivity mnX;
    private TBLottieAnimationView mnY;
    private boolean mnZ;
    private int moa;
    public int mnU = 0;
    private boolean mob = true;
    private boolean moc = false;

    /* loaded from: classes18.dex */
    public interface a {
        void bBi();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.mnX = videoPlayActivity;
        this.mFrom = str;
        this.mnZ = Pl(str);
        g(videoPlayActivity);
        this.mRootView = videoPlayActivity.findViewById(R.id.root_layout);
        this.mnS = (VerticalViewPager) videoPlayActivity.findViewById(R.id.video_play_viewpager);
        this.mnT = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.mnT.a(new VideoPlayFragment.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.VideoPlayFragment.a
            public void onStart() {
                VideoPlayView.this.dto();
            }
        });
        dtn();
        this.mnT.mFromPage = this.mFrom;
        this.mnS.setAdapter(this.mnT);
        this.mnS.setOffscreenPageLimit(1);
        this.mnS.setEventListener(new a.InterfaceC0520a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0520a
            public void bqf() {
                VideoPlayFragment GN = VideoPlayView.this.mnT.GN(VideoPlayView.this.mnS.getCurrentItem());
                if (GN != null) {
                    GN.bqf();
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0520a
            public void t(float f, float f2) {
                VideoPlayFragment GN = VideoPlayView.this.mnT.GN(VideoPlayView.this.mnS.getCurrentItem());
                if (GN != null) {
                    GN.t(f, f2);
                }
            }

            @Override // com.baidu.tbadk.widget.viewpager.a.InterfaceC0520a
            public void bqg() {
                VideoPlayFragment GN = VideoPlayView.this.mnT.GN(VideoPlayView.this.mnS.getCurrentItem());
                if (GN != null) {
                    GN.bqg();
                }
            }
        });
        this.mnS.setOnPageChangeListener(this);
        this.mnS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment GN = VideoPlayView.this.mnT.GN(VideoPlayView.this.mnS.getCurrentItem());
                if (GN != null) {
                    return GN.dtj();
                }
                return false;
            }
        });
    }

    private void g(VideoPlayActivity videoPlayActivity) {
        this.mnY = (TBLottieAnimationView) videoPlayActivity.findViewById(R.id.guide_animation_view);
        this.mnY.setAnimation(R.raw.lottie_video_guide);
        this.mnY.setImageAssetsFolder("lottie_video_guide");
        this.mnY.setOnClickListener(this);
        this.mnY.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VideoPlayView.this.mnY.isAnimating()) {
                    VideoPlayView.this.aA(valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.mnY.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoPlayView.this.dtq();
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
        this.moa = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds310);
    }

    public void onPause() {
        bVC();
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.mnV = i;
        this.mnT.a(this.mDatas, rect);
        this.mnT.notifyDataSetChanged();
        this.mnS.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.mnT != null) {
            this.mnT.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.mnW = aVar;
    }

    public void Pk(String str) {
        if (this.mnT != null) {
            this.mnT.mFrom = str;
        }
    }

    public void onDestroy() {
        bVC();
        dtr();
        if (this.mnT != null) {
            this.mnT.dtm();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.mnU = i;
        if (this.mnV != i && this.mob) {
            this.mob = false;
        }
        if (!x.isEmpty(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.mnW != null) {
            this.mnW.bBi();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.mnT != null && this.mnS != null) {
            this.mnT.GO(this.mnS.getCurrentItem());
        }
    }

    public boolean dtj() {
        VideoPlayFragment GN;
        if (dts()) {
            return true;
        }
        if (this.mnT == null || this.mnS == null || (GN = this.mnT.GN(this.mnS.getCurrentItem())) == null) {
            return false;
        }
        return GN.dtj();
    }

    public void c(int i, int i2, Intent intent) {
        VideoPlayFragment GN;
        if (this.mnT != null && this.mnS != null && (GN = this.mnT.GN(this.mnS.getCurrentItem())) != null) {
            GN.c(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.guide_animation_view) {
            bVC();
        }
    }

    private void dtn() {
        this.mnT.a(new f.b() { // from class: com.baidu.tieba.videoplay.VideoPlayView.6
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
            i = (int) (this.moa * f * 6.0f);
        } else if (f <= 0.25d) {
            i = this.mnS.getScrollY();
        } else if (f <= 0.42d) {
            i = (int) (this.moa * (0.42d - f) * 6.0d);
        } else if (f <= 0.5d) {
            i = this.mnS.getScrollY();
        } else if (f <= 0.67d) {
            i = (int) (this.moa * (f - 0.5d) * 6.0d);
        } else if (f <= 0.75d) {
            i = this.mnS.getScrollY();
        } else {
            i = ((double) f) <= 0.92d ? (int) (this.moa * (0.92d - f) * 6.0d) : 0;
        }
        this.mnS.scrollTo(0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dto() {
        if (this.mnU == this.mnV && this.mob) {
            wc(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dm(int i, int i2) {
        int i3;
        if (!this.moc && VideoPlayActivityConfig.FROM_DEFAULT.equals(Pm(this.mFrom)) && (i3 = i - i2) > 2500 && i3 < 3500 && this.mob && i.dpE()) {
            wc(true);
            this.moc = true;
            i.dpF();
        }
    }

    private void dtp() {
        this.mnS.scrollTo(0, 0);
    }

    private boolean wc(boolean z) {
        if (this.mnY == null) {
            return false;
        }
        if (this.mnZ || z) {
            this.mnY.setVisibility(0);
            this.mnY.playAnimation();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVC() {
        if (this.mnY != null) {
            if (this.mnY.isAnimating()) {
                this.mnY.pauseAnimation();
                dtp();
            }
            this.mnY.setVisibility(8);
        }
    }

    private boolean Pl(String str) {
        return b.aZP().getBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Pm(str), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtq() {
        if (this.mnZ) {
            b.aZP().putBoolean(SharedPrefConfig.VIDEO_PLAY_VERTICAL_FIRST_IN + Pm(this.mFrom), false);
            this.mnZ = false;
        }
    }

    private String Pm(String str) {
        if (!"video_tab".equals(str)) {
            return VideoPlayActivityConfig.FROM_DEFAULT;
        }
        return "video_tab";
    }

    public void Pn(String str) {
        if (this.mnT != null) {
            this.mnT.mnL = str;
        }
    }

    private void dtr() {
        if (this.moc) {
            i.dpH();
        } else if (VideoPlayActivityConfig.FROM_DEFAULT.equals(Pm(this.mFrom))) {
            if (this.mob) {
                i.dpG();
            } else {
                i.dpH();
            }
        }
    }

    private boolean dts() {
        if (this.mnY == null || !this.mnY.isAnimating()) {
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
