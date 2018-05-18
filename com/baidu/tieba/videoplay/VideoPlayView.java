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
    private FrameLayout bmw;
    private VerticalViewPager gWQ;
    private VideoPlayFragmentAdapter gWR;
    public int gWT;
    private a gWU;
    private VideoPlayActivity gWV;
    private FrameLayout gWW;
    private ImageView gWX;
    private AnimationDrawable gWY;
    private List<VideoItemData> mDatas;
    public int gWS = 0;
    private Runnable gWZ = new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPlayView.this.gWW != null) {
                VideoPlayView.this.gWW.animate().alphaBy(0.0f).alpha(1.0f).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (VideoPlayView.this.gWY != null) {
                            VideoPlayView.this.gWY.start();
                        }
                    }
                }).start();
            }
        }
    };
    private boolean gWy = b.getInstance().getBoolean("video_play_vertical_first_in", true);

    /* loaded from: classes2.dex */
    public interface a {
        void bzx();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity) {
        this.gWV = videoPlayActivity;
        if (this.gWy) {
            this.bmw = (FrameLayout) videoPlayActivity.findViewById(d.g.container);
            this.gWW = (FrameLayout) videoPlayActivity.findViewById(d.g.video_guide_layout);
            this.gWX = (ImageView) videoPlayActivity.findViewById(d.g.video_guide_image);
            this.gWX.setImageResource(d.f.animation_video_slide_guide);
            this.gWY = (AnimationDrawable) this.gWX.getDrawable();
            this.gWW.setOnClickListener(this);
            this.gWX.setOnClickListener(this);
            this.gWW.setVisibility(0);
            this.gWW.setAlpha(0.0f);
        }
        this.gWQ = (VerticalViewPager) videoPlayActivity.findViewById(d.g.video_play_viewpager);
        this.gWR = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.gWR.gWy = this.gWy;
        this.gWQ.setAdapter(this.gWR);
        this.gWQ.setOffscreenPageLimit(1);
        this.gWQ.setOnViewClickListener(new VerticalViewPager.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
            public void bzt() {
                VideoPlayFragment uC = VideoPlayView.this.gWR.uC(VideoPlayView.this.gWQ.getCurrentItem());
                if (uC != null) {
                    uC.bzt();
                }
            }

            @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
            public void n(float f, float f2) {
                VideoPlayFragment uC = VideoPlayView.this.gWR.uC(VideoPlayView.this.gWQ.getCurrentItem());
                if (uC != null) {
                    uC.n(f, f2);
                }
            }

            @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
            public void bzv() {
                VideoPlayFragment uC = VideoPlayView.this.gWR.uC(VideoPlayView.this.gWQ.getCurrentItem());
                if (uC != null) {
                    uC.bzv();
                }
            }
        });
        this.gWQ.addOnPageChangeListener(this);
        this.gWQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                VideoPlayFragment uC = VideoPlayView.this.gWR.uC(VideoPlayView.this.gWQ.getCurrentItem());
                if (uC != null) {
                    return uC.bzJ();
                }
                return false;
            }
        });
    }

    public void onResume() {
        if (this.gWY != null) {
            e.fw().removeCallbacks(this.gWZ);
            e.fw().postDelayed(this.gWZ, 300L);
        }
    }

    public void onPause() {
        if (this.gWY != null) {
            if (this.gWY.isRunning()) {
                this.gWY.stop();
            }
            e.fw().removeCallbacks(this.gWZ);
        }
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.gWT = i;
        this.gWR.a(this.mDatas, rect);
        this.gWR.notifyDataSetChanged();
        this.gWQ.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.gWR != null) {
            this.gWR.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.gWU = aVar;
    }

    public void uu(String str) {
        if (this.gWR != null) {
            this.gWR.mFrom = str;
        }
    }

    public void onDestroy() {
        if (this.gWR != null) {
            this.gWR.bzL();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.gWS = i;
        if (!v.w(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.gWU != null) {
            this.gWU.bzx();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.gWR != null && this.gWQ != null) {
            this.gWR.uD(this.gWQ.getCurrentItem());
        }
    }

    public boolean bzJ() {
        if (this.gWR == null || this.gWQ == null) {
            return false;
        }
        return this.gWR.uC(this.gWQ.getCurrentItem()).bzJ();
    }

    public void b(int i, int i2, Intent intent) {
        if (this.gWR != null && this.gWQ != null) {
            this.gWR.uC(this.gWQ.getCurrentItem()).b(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getId() == d.g.video_guide_layout || view2.getId() == d.g.video_guide_image) {
            if (this.gWY != null) {
                this.gWY.stop();
                this.gWY = null;
            }
            if (this.gWW != null) {
                this.gWW.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (VideoPlayView.this.bmw != null) {
                            VideoPlayView.this.bmw.removeView(VideoPlayView.this.gWW);
                        }
                    }
                }).setDuration(250L).start();
                if (this.gWR != null) {
                    SparseArray<VideoPlayFragment> bzK = this.gWR.bzK();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= bzK.size()) {
                            break;
                        }
                        VideoPlayFragment valueAt = bzK.valueAt(i2);
                        if (valueAt != null) {
                            valueAt.bzz();
                        }
                        i = i2 + 1;
                    }
                }
            }
            bzM();
        }
    }

    private void bzM() {
        if (this.gWy) {
            b.getInstance().putBoolean("video_play_vertical_first_in", false);
            this.gWy = false;
            if (this.gWR != null) {
                this.gWR.gWy = false;
            }
        }
    }

    public void uv(String str) {
        if (this.gWR != null) {
            this.gWR.gWJ = str;
        }
    }
}
