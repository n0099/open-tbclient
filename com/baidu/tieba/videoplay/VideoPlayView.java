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
    private FrameLayout bvX;
    public int hmA;
    private a hmB;
    private VideoPlayActivity hmC;
    private FrameLayout hmD;
    private ImageView hmE;
    private AnimationDrawable hmF;
    private boolean hmf;
    private VerticalViewPager hmx;
    private VideoPlayFragmentAdapter hmy;
    private List<VideoItemData> mDatas;
    private String mFrom;
    public int hmz = 0;
    private Runnable hmG = new Runnable() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPlayView.this.hmD != null) {
                VideoPlayView.this.hmD.animate().alphaBy(0.0f).alpha(1.0f).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayView.3.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (VideoPlayView.this.hmF != null) {
                            VideoPlayView.this.hmF.start();
                        }
                    }
                }).start();
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void aBl();
    }

    public VideoPlayView(VideoPlayActivity videoPlayActivity, String str) {
        this.hmC = videoPlayActivity;
        this.mFrom = str;
        this.hmf = b.getInstance().getBoolean("video_play_vertical_first_in" + this.mFrom, true);
        if (this.hmf) {
            this.bvX = (FrameLayout) videoPlayActivity.findViewById(d.g.container);
            this.hmD = (FrameLayout) videoPlayActivity.findViewById(d.g.video_guide_layout);
            this.hmE = (ImageView) videoPlayActivity.findViewById(d.g.video_guide_image);
            this.hmE.setImageResource(d.f.animation_video_slide_guide);
            this.hmF = (AnimationDrawable) this.hmE.getDrawable();
            this.hmD.setOnClickListener(this);
            this.hmE.setOnClickListener(this);
            this.hmD.setVisibility(0);
            this.hmD.setAlpha(0.0f);
        }
        this.hmx = (VerticalViewPager) videoPlayActivity.findViewById(d.g.video_play_viewpager);
        this.hmy = new VideoPlayFragmentAdapter(videoPlayActivity.getSupportFragmentManager());
        this.hmy.bBe = this.mFrom;
        this.hmy.hmf = this.hmf;
        this.hmx.setAdapter(this.hmy);
        this.hmx.setOffscreenPageLimit(1);
        this.hmx.setOnViewClickListener(new VerticalViewPager.a() { // from class: com.baidu.tieba.videoplay.VideoPlayView.1
            @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
            public void bEZ() {
                VideoPlayFragment uX = VideoPlayView.this.hmy.uX(VideoPlayView.this.hmx.getCurrentItem());
                if (uX != null) {
                    uX.bEZ();
                }
            }

            @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
            public void u(float f, float f2) {
                VideoPlayFragment uX = VideoPlayView.this.hmy.uX(VideoPlayView.this.hmx.getCurrentItem());
                if (uX != null) {
                    uX.u(f, f2);
                }
            }

            @Override // com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.a
            public void bFb() {
                VideoPlayFragment uX = VideoPlayView.this.hmy.uX(VideoPlayView.this.hmx.getCurrentItem());
                if (uX != null) {
                    uX.bFb();
                }
            }
        });
        this.hmx.addOnPageChangeListener(this);
        this.hmx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.videoplay.VideoPlayView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoPlayFragment uX = VideoPlayView.this.hmy.uX(VideoPlayView.this.hmx.getCurrentItem());
                if (uX != null) {
                    return uX.bFo();
                }
                return false;
            }
        });
    }

    public void onResume() {
        if (this.hmF != null) {
            e.im().removeCallbacks(this.hmG);
            e.im().postDelayed(this.hmG, 300L);
        }
    }

    public void onPause() {
        if (this.hmF != null) {
            if (this.hmF.isRunning()) {
                this.hmF.stop();
            }
            e.im().removeCallbacks(this.hmG);
        }
    }

    public void a(List<VideoItemData> list, int i, Rect rect) {
        this.mDatas = list;
        this.hmA = i;
        this.hmy.a(this.mDatas, rect);
        this.hmy.notifyDataSetChanged();
        this.hmx.setCurrentItem(i);
    }

    public void notifyDataSetChanged() {
        if (this.hmy != null) {
            this.hmy.notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.hmB = aVar;
    }

    public void vk(String str) {
        if (this.hmy != null) {
            this.hmy.mFrom = str;
        }
    }

    public void onDestroy() {
        if (this.hmy != null) {
            this.hmy.bFq();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.hmz = i;
        if (!w.A(this.mDatas) && this.mDatas.size() - 1 > 0 && this.mDatas.size() - i <= 2 && this.hmB != null) {
            this.hmB.aBl();
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.hmy != null && this.hmx != null) {
            this.hmy.uY(this.hmx.getCurrentItem());
        }
    }

    public boolean bFo() {
        if (this.hmy == null || this.hmx == null) {
            return false;
        }
        return this.hmy.uX(this.hmx.getCurrentItem()).bFo();
    }

    public void b(int i, int i2, Intent intent) {
        if (this.hmy != null && this.hmx != null) {
            this.hmy.uX(this.hmx.getCurrentItem()).b(i, i2, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.video_guide_layout || view.getId() == d.g.video_guide_image) {
            if (this.hmF != null) {
                this.hmF.stop();
                this.hmF = null;
            }
            if (this.hmD != null) {
                this.hmD.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.videoplay.VideoPlayView.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (VideoPlayView.this.bvX != null) {
                            VideoPlayView.this.bvX.removeView(VideoPlayView.this.hmD);
                        }
                    }
                }).setDuration(250L).start();
                if (this.hmy != null) {
                    SparseArray<VideoPlayFragment> bFp = this.hmy.bFp();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= bFp.size()) {
                            break;
                        }
                        VideoPlayFragment valueAt = bFp.valueAt(i2);
                        if (valueAt != null) {
                            valueAt.bFe();
                        }
                        i = i2 + 1;
                    }
                }
            }
            bFr();
        }
    }

    private void bFr() {
        if (this.hmf) {
            b.getInstance().putBoolean("video_play_vertical_first_in" + this.mFrom, false);
            this.hmf = false;
            if (this.hmy != null) {
                this.hmy.hmf = false;
            }
        }
    }

    public void vl(String str) {
        if (this.hmy != null) {
            this.hmy.hmq = str;
        }
    }
}
