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
    private VerticalViewPager gVP;
    private VideoPlayFragmentAdapter gVQ;
    public int gVS;
    private a gVT;
    private VideoPlayActivity gVU;
    private FrameLayout gVV;
    private ImageView gVW;
    private AnimationDrawable gVX;
    private List<VideoItemData> mDatas;
    public int gVR = 0;
    private Runnable gVY = new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPlayView.this.gVV != null) {
                VideoPlayView.this.gVV.animate().alphaBy(0.0f).alpha(1.0f).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (VideoPlayView.this.gVX != null) {
                            VideoPlayView.this.gVX.start();
                        }
                    }
                }).start();
            }
        }
    };
    private boolean gVx = b.getInstance().getBoolean("video_play_vertical_first_in", true);

    /* loaded from: classes2.dex */
    public interface a {
        void bzz();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity) {
        this.gVU = videoPlayActivity;
        if (this.gVx) {
            this.bmh = (FrameLayout) videoPlayActivity.findViewById(d.g.container);
            this.gVV = (FrameLayout) videoPlayActivity.findViewById(d.g.video_guide_layout);
            this.gVW = (ImageView) videoPlayActivity.findViewById(d.g.video_guide_image);
            this.gVW.setImageResource(d.f.animation_video_slide_guide);
            this.gVX = (AnimationDrawable) this.gVW.getDrawable();
            this.gVV.setOnClickListener(this);
            this.gVW.setOnClickListener(this);
            this.gVV.setVisibility(0);
            this.gVV.setAlpha(0.0f);
        }
        this.gVP = (VerticalViewPager) videoPlayActivity.findViewById(d.g.video_play_viewpager);
        this.gVQ = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.gVQ.gVx = this.gVx;
        this.gVP.setAdapter(this.gVQ);
        this.gVP.setOffscreenPageLimit(1);
        this.gVP.setOnViewClickListener(new VerticalViewPager.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
            public void bzv() {
                VideoPlayFragment uD = VideoPlayView.this.gVQ.uD(VideoPlayView.this.gVP.getCurrentItem());
                if (uD != null) {
                    uD.bzv();
                }
            }

            @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
            public void n(float f, float f2) {
                VideoPlayFragment uD = VideoPlayView.this.gVQ.uD(VideoPlayView.this.gVP.getCurrentItem());
                if (uD != null) {
                    uD.n(f, f2);
                }
            }

            @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
            public void bzx() {
                VideoPlayFragment uD = VideoPlayView.this.gVQ.uD(VideoPlayView.this.gVP.getCurrentItem());
                if (uD != null) {
                    uD.bzx();
                }
            }
        });
        this.gVP.addOnPageChangeListener(this);
        this.gVP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                VideoPlayFragment uD = VideoPlayView.this.gVQ.uD(VideoPlayView.this.gVP.getCurrentItem());
                if (uD != null) {
                    return uD.bzL();
                }
                return false;
            }
        });
    }

    public void onResume() {
        if (this.gVX != null) {
            e.fw().removeCallbacks(this.gVY);
            e.fw().postDelayed(this.gVY, 300L);
        }
    }

    public void onPause() {
        if (this.gVX != null) {
            if (this.gVX.isRunning()) {
                this.gVX.stop();
            }
            e.fw().removeCallbacks(this.gVY);
        }
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.gVS = i;
        this.gVQ.a(this.mDatas, rect);
        this.gVQ.notifyDataSetChanged();
        this.gVP.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.gVQ != null) {
            this.gVQ.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.gVT = aVar;
    }

    public void ur(String str) {
        if (this.gVQ != null) {
            this.gVQ.mFrom = str;
        }
    }

    public void onDestroy() {
        if (this.gVQ != null) {
            this.gVQ.bzN();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.gVR = i;
        if (!v.w(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.gVT != null) {
            this.gVT.bzz();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.gVQ != null && this.gVP != null) {
            this.gVQ.uE(this.gVP.getCurrentItem());
        }
    }

    public boolean bzL() {
        if (this.gVQ == null || this.gVP == null) {
            return false;
        }
        return this.gVQ.uD(this.gVP.getCurrentItem()).bzL();
    }

    public void b(int i, int i2, Intent intent) {
        if (this.gVQ != null && this.gVP != null) {
            this.gVQ.uD(this.gVP.getCurrentItem()).b(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getId() == d.g.video_guide_layout || view2.getId() == d.g.video_guide_image) {
            if (this.gVX != null) {
                this.gVX.stop();
                this.gVX = null;
            }
            if (this.gVV != null) {
                this.gVV.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (VideoPlayView.this.bmh != null) {
                            VideoPlayView.this.bmh.removeView(VideoPlayView.this.gVV);
                        }
                    }
                }).setDuration(250L).start();
                if (this.gVQ != null) {
                    SparseArray<VideoPlayFragment> bzM = this.gVQ.bzM();
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
        if (this.gVx) {
            b.getInstance().putBoolean("video_play_vertical_first_in", false);
            this.gVx = false;
            if (this.gVQ != null) {
                this.gVQ.gVx = false;
            }
        }
    }

    public void us(String str) {
        if (this.gVQ != null) {
            this.gVQ.gVI = str;
        }
    }
}
