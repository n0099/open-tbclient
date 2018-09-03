package com.baidu.tieba.write.album;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.GridView;
import com.baidu.adp.lib.util.l;
/* loaded from: classes3.dex */
public class TransparentHeadGridView extends GridView {
    private Interpolator bdU;
    private Animation.AnimationListener ckj;
    private float hdg;
    private boolean huW;
    private int huX;
    private View huY;
    private d huZ;
    private int hva;
    private a hvb;
    private b hvc;
    private AbsListView.OnScrollListener hvd;
    private int hve;
    private boolean hvf;
    private c hvg;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes3.dex */
    public interface a {
        void vt(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void bGr();

        void vu(int i);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void Nt();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.hdg = 0.0f;
        this.huW = true;
        this.huX = -1;
        this.hve = -1;
        this.hvf = false;
        this.ckj = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hvf) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hvg = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Nt() {
                if (TransparentHeadGridView.this.hvf) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hvc != null) {
                    TransparentHeadGridView.this.hvc.bGr();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hvd != null) {
                    TransparentHeadGridView.this.hvd.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hvb != null && TransparentHeadGridView.this.hve != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hvb.vt(100);
                        TransparentHeadGridView.this.hve = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.huX < 0) {
                        TransparentHeadGridView.this.huX = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.huX);
                    TransparentHeadGridView.this.huW = i4 == 0;
                    if (TransparentHeadGridView.this.huY != null) {
                        TransparentHeadGridView.this.huY.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hvb != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hve) {
                        TransparentHeadGridView.this.hvb.vt(height);
                        TransparentHeadGridView.this.hve = height;
                    }
                }
                if (TransparentHeadGridView.this.hvd != null) {
                    TransparentHeadGridView.this.hvd.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.hdg = 0.0f;
        this.huW = true;
        this.huX = -1;
        this.hve = -1;
        this.hvf = false;
        this.ckj = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hvf) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hvg = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Nt() {
                if (TransparentHeadGridView.this.hvf) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hvc != null) {
                    TransparentHeadGridView.this.hvc.bGr();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hvd != null) {
                    TransparentHeadGridView.this.hvd.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hvb != null && TransparentHeadGridView.this.hve != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hvb.vt(100);
                        TransparentHeadGridView.this.hve = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.huX < 0) {
                        TransparentHeadGridView.this.huX = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.huX);
                    TransparentHeadGridView.this.huW = i4 == 0;
                    if (TransparentHeadGridView.this.huY != null) {
                        TransparentHeadGridView.this.huY.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hvb != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hve) {
                        TransparentHeadGridView.this.hvb.vt(height);
                        TransparentHeadGridView.this.hve = height;
                    }
                }
                if (TransparentHeadGridView.this.hvd != null) {
                    TransparentHeadGridView.this.hvd.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.hdg = 0.0f;
        this.huW = true;
        this.huX = -1;
        this.hve = -1;
        this.hvf = false;
        this.ckj = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hvf) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hvg = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Nt() {
                if (TransparentHeadGridView.this.hvf) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hvc != null) {
                    TransparentHeadGridView.this.hvc.bGr();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.hvd != null) {
                    TransparentHeadGridView.this.hvd.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hvb != null && TransparentHeadGridView.this.hve != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hvb.vt(100);
                        TransparentHeadGridView.this.hve = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.huX < 0) {
                        TransparentHeadGridView.this.huX = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.huX);
                    TransparentHeadGridView.this.huW = i4 == 0;
                    if (TransparentHeadGridView.this.huY != null) {
                        TransparentHeadGridView.this.huY.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hvb != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hve) {
                        TransparentHeadGridView.this.hvb.vt(height);
                        TransparentHeadGridView.this.hve = height;
                    }
                }
                if (TransparentHeadGridView.this.hvd != null) {
                    TransparentHeadGridView.this.hvd.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.hva = (int) (l.aj(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.hdg = 0.0f;
                if (this.hvf && getPaddingTop() > this.hva) {
                    a(getHeight(), 200L, 0L, this.hvg);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.hdg == 0.0f) {
                    this.hdg = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.hdg && getPaddingTop() == 0 && this.huW) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.hdg) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.hvc != null && i >= 0 && this.hva > 0 && i <= this.hva) {
                        this.hvc.vu((i * 100) / this.hva);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void bGq() {
        setPadding(0, (int) ((10.0f - this.hdg) / 2.0f), 0, 0);
        this.mState = 0;
        this.hdg = 0.0f;
        if (this.hvf && getPaddingTop() > this.hva) {
            a(getHeight(), 200L, 0L, this.hvg);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hvd = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.huY = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.huZ != null) {
            this.huZ.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bdU == null) {
                this.bdU = new DecelerateInterpolator();
            }
            this.huZ = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.huZ, j2);
            } else {
                post(this.huZ);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private final int beh;
        private final int bei;
        private c hvi;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bek = true;
        private long mStartTime = -1;
        private int bel = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bei = i;
            this.beh = i2;
            this.mInterpolator = TransparentHeadGridView.this.bdU;
            this.mDuration = j;
            this.hvi = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bel = this.bei - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bei - this.beh));
                TransparentHeadGridView.this.setPadding(0, this.bel, 0, 0);
                if (TransparentHeadGridView.this.hvc != null && this.bel >= 0 && TransparentHeadGridView.this.hva > 0 && this.bel <= TransparentHeadGridView.this.hva) {
                    TransparentHeadGridView.this.hvc.vu((this.bel * 100) / TransparentHeadGridView.this.hva);
                }
            }
            if (this.bek && this.beh != this.bel) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.hvi != null) {
                this.hvi.Nt();
            }
        }

        public void stop() {
            this.bek = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.hvb = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.hvc = bVar;
    }
}
