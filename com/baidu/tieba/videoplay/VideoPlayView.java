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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager;
import java.util.List;
/* loaded from: classes2.dex */
public class VideoPlayView implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private FrameLayout buC;
    private AnimationDrawable hiA;
    private VerticalViewPager his;
    private VideoPlayFragmentAdapter hit;
    public int hiv;
    private a hiw;
    private VideoPlayActivity hix;
    private FrameLayout hiy;
    private ImageView hiz;
    private List<VideoItemData> mDatas;
    public int hiu = 0;
    private Runnable hiB = new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPlayView.this.hiy != null) {
                VideoPlayView.this.hiy.animate().alphaBy(0.0f).alpha(1.0f).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (VideoPlayView.this.hiA != null) {
                            VideoPlayView.this.hiA.start();
                        }
                    }
                }).start();
            }
        }
    };
    private boolean hhZ = b.getInstance().getBoolean("video_play_vertical_first_in", true);

    /* loaded from: classes2.dex */
    public interface a {
        void aAE();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity) {
        this.hix = videoPlayActivity;
        if (this.hhZ) {
            this.buC = (FrameLayout) videoPlayActivity.findViewById(d.g.container);
            this.hiy = (FrameLayout) videoPlayActivity.findViewById(d.g.video_guide_layout);
            this.hiz = (ImageView) videoPlayActivity.findViewById(d.g.video_guide_image);
            this.hiz.setImageResource(d.f.animation_video_slide_guide);
            this.hiA = (AnimationDrawable) this.hiz.getDrawable();
            this.hiy.setOnClickListener(this);
            this.hiz.setOnClickListener(this);
            this.hiy.setVisibility(0);
            this.hiy.setAlpha(0.0f);
        }
        this.his = (VerticalViewPager) videoPlayActivity.findViewById(d.g.video_play_viewpager);
        this.hit = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.hit.hhZ = this.hhZ;
        this.his.setAdapter(this.hit);
        this.his.setOffscreenPageLimit(1);
        this.his.setOnViewClickListener(new VerticalViewPager.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
            public void bEz() {
                VideoPlayFragment uP = VideoPlayView.this.hit.uP(VideoPlayView.this.his.getCurrentItem());
                if (uP != null) {
                    uP.bEz();
                }
            }

            @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
            public void u(float f, float f2) {
                VideoPlayFragment uP = VideoPlayView.this.hit.uP(VideoPlayView.this.his.getCurrentItem());
                if (uP != null) {
                    uP.u(f, f2);
                }
            }

            @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
            public void bEB() {
                VideoPlayFragment uP = VideoPlayView.this.hit.uP(VideoPlayView.this.his.getCurrentItem());
                if (uP != null) {
                    uP.bEB();
                }
            }
        });
        this.his.addOnPageChangeListener(this);
        this.his.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment uP = VideoPlayView.this.hit.uP(VideoPlayView.this.his.getCurrentItem());
                if (uP != null) {
                    return uP.bEO();
                }
                return false;
            }
        });
    }

    public void onResume() {
        if (this.hiA != null) {
            e.im().removeCallbacks(this.hiB);
            e.im().postDelayed(this.hiB, 300L);
        }
    }

    public void onPause() {
        if (this.hiA != null) {
            if (this.hiA.isRunning()) {
                this.hiA.stop();
            }
            e.im().removeCallbacks(this.hiB);
        }
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.hiv = i;
        this.hit.a(this.mDatas, rect);
        this.hit.notifyDataSetChanged();
        this.his.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.hit != null) {
            this.hit.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.hiw = aVar;
    }

    public void vo(String str) {
        if (this.hit != null) {
            this.hit.mFrom = str;
        }
    }

    public void onDestroy() {
        if (this.hit != null) {
            this.hit.bEQ();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.hiu = i;
        if (!w.z(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.hiw != null) {
            this.hiw.aAE();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.hit != null && this.his != null) {
            this.hit.uQ(this.his.getCurrentItem());
        }
    }

    public boolean bEO() {
        if (this.hit == null || this.his == null) {
            return false;
        }
        return this.hit.uP(this.his.getCurrentItem()).bEO();
    }

    public void b(int i, int i2, Intent intent) {
        if (this.hit != null && this.his != null) {
            this.hit.uP(this.his.getCurrentItem()).b(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.video_guide_layout || view.getId() == d.g.video_guide_image) {
            if (this.hiA != null) {
                this.hiA.stop();
                this.hiA = null;
            }
            if (this.hiy != null) {
                this.hiy.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (VideoPlayView.this.buC != null) {
                            VideoPlayView.this.buC.removeView(VideoPlayView.this.hiy);
                        }
                    }
                }).setDuration(250L).start();
                if (this.hit != null) {
                    SparseArray<VideoPlayFragment> bEP = this.hit.bEP();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= bEP.size()) {
                            break;
                        }
                        VideoPlayFragment valueAt = bEP.valueAt(i2);
                        if (valueAt != null) {
                            valueAt.bEE();
                        }
                        i = i2 + 1;
                    }
                }
            }
            bER();
        }
    }

    private void bER() {
        if (this.hhZ) {
            b.getInstance().putBoolean("video_play_vertical_first_in", false);
            this.hhZ = false;
            if (this.hit != null) {
                this.hit.hhZ = false;
            }
        }
    }

    public void vp(String str) {
        if (this.hit != null) {
            this.hit.hil = str;
        }
    }
}
