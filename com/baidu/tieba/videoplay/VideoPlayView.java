package com.baidu.tieba.videoplay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.lib.g.e;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private FrameLayout bmh;
    private VerticalViewPager gVM;
    private VideoPlayFragmentAdapter gVN;
    public int gVP;
    private a gVQ;
    private VideoPlayActivity gVR;
    private FrameLayout gVS;
    private ImageView gVT;
    private AnimationDrawable gVU;
    private List<VideoItemData> mDatas;
    public int gVO = 0;
    private Runnable gVV = new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPlayView.this.gVS != null) {
                VideoPlayView.this.gVS.animate().alphaBy(0.0f).alpha(1.0f).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (VideoPlayView.this.gVU != null) {
                            VideoPlayView.this.gVU.start();
                        }
                    }
                }).start();
            }
        }
    };
    private boolean gVu = b.getInstance().getBoolean("video_play_vertical_first_in", true);

    /* loaded from: classes2.dex */
    public interface a {
        void bzz();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity) {
        this.gVR = videoPlayActivity;
        if (this.gVu) {
            this.bmh = (FrameLayout) videoPlayActivity.findViewById(d.g.container);
            this.gVS = (FrameLayout) videoPlayActivity.findViewById(d.g.video_guide_layout);
            this.gVT = (ImageView) videoPlayActivity.findViewById(d.g.video_guide_image);
            this.gVT.setImageResource(d.f.animation_video_slide_guide);
            this.gVU = (AnimationDrawable) this.gVT.getDrawable();
            this.gVS.setOnClickListener(this);
            this.gVT.setOnClickListener(this);
            this.gVS.setVisibility(0);
            this.gVS.setAlpha(0.0f);
        }
        this.gVM = (VerticalViewPager) videoPlayActivity.findViewById(d.g.video_play_viewpager);
        this.gVN = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.gVN.gVu = this.gVu;
        this.gVM.setAdapter(this.gVN);
        this.gVM.setOffscreenPageLimit(1);
        this.gVM.setOnViewClickListener(new VerticalViewPager.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
            public void bzv() {
                VideoPlayFragment uD = VideoPlayView.this.gVN.uD(VideoPlayView.this.gVM.getCurrentItem());
                if (uD != null) {
                    uD.bzv();
                }
            }

            @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
            public void n(float f, float f2) {
                VideoPlayFragment uD = VideoPlayView.this.gVN.uD(VideoPlayView.this.gVM.getCurrentItem());
                if (uD != null) {
                    uD.n(f, f2);
                }
            }

            @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
            public void bzx() {
                VideoPlayFragment uD = VideoPlayView.this.gVN.uD(VideoPlayView.this.gVM.getCurrentItem());
                if (uD != null) {
                    uD.bzx();
                }
            }
        });
        this.gVM.addOnPageChangeListener(this);
        this.gVM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                VideoPlayFragment uD = VideoPlayView.this.gVN.uD(VideoPlayView.this.gVM.getCurrentItem());
                if (uD != null) {
                    return uD.bzL();
                }
                return false;
            }
        });
    }

    public void onResume() {
        if (this.gVU != null) {
            e.fw().removeCallbacks(this.gVV);
            e.fw().postDelayed(this.gVV, 300L);
        }
    }

    public void onPause() {
        if (this.gVU != null) {
            if (this.gVU.isRunning()) {
                this.gVU.stop();
            }
            e.fw().removeCallbacks(this.gVV);
        }
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.gVP = i;
        this.gVN.a(this.mDatas, rect);
        this.gVN.notifyDataSetChanged();
        this.gVM.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.gVN != null) {
            this.gVN.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.gVQ = aVar;
    }

    public void ur(String str) {
        if (this.gVN != null) {
            this.gVN.mFrom = str;
        }
    }

    public void onDestroy() {
        if (this.gVN != null) {
            this.gVN.bzN();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.gVO = i;
        if (!v.w(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.gVQ != null) {
            this.gVQ.bzz();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.gVN != null && this.gVM != null) {
            this.gVN.uE(this.gVM.getCurrentItem());
        }
    }

    public boolean bzL() {
        if (this.gVN == null || this.gVM == null) {
            return false;
        }
        return this.gVN.uD(this.gVM.getCurrentItem()).bzL();
    }

    public void b(int i, int i2, Intent intent) {
        if (this.gVN != null && this.gVM != null) {
            this.gVN.uD(this.gVM.getCurrentItem()).b(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getId() == d.g.video_guide_layout || view2.getId() == d.g.video_guide_image) {
            if (this.gVU != null) {
                this.gVU.stop();
                this.gVU = null;
            }
            if (this.gVS != null) {
                this.gVS.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (VideoPlayView.this.bmh != null) {
                            VideoPlayView.this.bmh.removeView(VideoPlayView.this.gVS);
                        }
                    }
                }).setDuration(250L).start();
                if (this.gVN != null) {
                    SparseArray<VideoPlayFragment> bzM = this.gVN.bzM();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= bzM.size()) {
                            break;
                        }
                        VideoPlayFragment valueAt = bzM.valueAt(i2);
                        if (valueAt != null) {
                            valueAt.bzB();
                        }
                        i = i2 + 1;
                    }
                }
            }
            bzO();
        }
    }

    private void bzO() {
        if (this.gVu) {
            b.getInstance().putBoolean("video_play_vertical_first_in", false);
            this.gVu = false;
            if (this.gVN != null) {
                this.gVN.gVu = false;
            }
        }
    }

    public void us(String str) {
        if (this.gVN != null) {
            this.gVN.gVF = str;
        }
    }
}
