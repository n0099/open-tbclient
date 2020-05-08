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
/* loaded from: classes2.dex */
public class TransparentHeadGridView extends GridView {
    private float aXf;
    private boolean aXg;
    private int aXh;
    private View aXi;
    private Interpolator aXj;
    private int aXl;
    private AbsListView.OnScrollListener aXo;
    private int aXp;
    private boolean aXq;
    private Animation.AnimationListener aXr;
    private d lyY;
    private a lyZ;
    private b lza;
    private c lzb;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes2.dex */
    public interface a {
        void di(int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void FW();

        void dj(int i);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void FV();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.aXf = 0.0f;
        this.aXg = true;
        this.aXh = -1;
        this.aXp = -1;
        this.aXq = false;
        this.aXr = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aXq) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.lzb = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void FV() {
                if (TransparentHeadGridView.this.aXq) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.lza != null) {
                    TransparentHeadGridView.this.lza.FW();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.aXo != null) {
                    TransparentHeadGridView.this.aXo.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.lyZ != null && TransparentHeadGridView.this.aXp != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.lyZ.di(100);
                        TransparentHeadGridView.this.aXp = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aXh < 0) {
                        TransparentHeadGridView.this.aXh = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aXh);
                    TransparentHeadGridView.this.aXg = i4 == 0;
                    if (TransparentHeadGridView.this.aXi != null) {
                        TransparentHeadGridView.this.aXi.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.lyZ != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aXp) {
                        TransparentHeadGridView.this.lyZ.di(height);
                        TransparentHeadGridView.this.aXp = height;
                    }
                }
                if (TransparentHeadGridView.this.aXo != null) {
                    TransparentHeadGridView.this.aXo.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.aXf = 0.0f;
        this.aXg = true;
        this.aXh = -1;
        this.aXp = -1;
        this.aXq = false;
        this.aXr = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aXq) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.lzb = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void FV() {
                if (TransparentHeadGridView.this.aXq) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.lza != null) {
                    TransparentHeadGridView.this.lza.FW();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.aXo != null) {
                    TransparentHeadGridView.this.aXo.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.lyZ != null && TransparentHeadGridView.this.aXp != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.lyZ.di(100);
                        TransparentHeadGridView.this.aXp = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aXh < 0) {
                        TransparentHeadGridView.this.aXh = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aXh);
                    TransparentHeadGridView.this.aXg = i4 == 0;
                    if (TransparentHeadGridView.this.aXi != null) {
                        TransparentHeadGridView.this.aXi.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.lyZ != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aXp) {
                        TransparentHeadGridView.this.lyZ.di(height);
                        TransparentHeadGridView.this.aXp = height;
                    }
                }
                if (TransparentHeadGridView.this.aXo != null) {
                    TransparentHeadGridView.this.aXo.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.aXf = 0.0f;
        this.aXg = true;
        this.aXh = -1;
        this.aXp = -1;
        this.aXq = false;
        this.aXr = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aXq) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.lzb = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void FV() {
                if (TransparentHeadGridView.this.aXq) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.lza != null) {
                    TransparentHeadGridView.this.lza.FW();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.aXo != null) {
                    TransparentHeadGridView.this.aXo.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.lyZ != null && TransparentHeadGridView.this.aXp != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.lyZ.di(100);
                        TransparentHeadGridView.this.aXp = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aXh < 0) {
                        TransparentHeadGridView.this.aXh = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aXh);
                    TransparentHeadGridView.this.aXg = i4 == 0;
                    if (TransparentHeadGridView.this.aXi != null) {
                        TransparentHeadGridView.this.aXi.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.lyZ != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aXp) {
                        TransparentHeadGridView.this.lyZ.di(height);
                        TransparentHeadGridView.this.aXp = height;
                    }
                }
                if (TransparentHeadGridView.this.aXo != null) {
                    TransparentHeadGridView.this.aXo.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.aXl = (int) (l.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.aXf = 0.0f;
                if (this.aXq && getPaddingTop() > this.aXl) {
                    a(getHeight(), 200L, 0L, this.lzb);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.aXf == 0.0f) {
                    this.aXf = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.aXf && getPaddingTop() == 0 && this.aXg) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.aXf) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.lza != null && i >= 0 && this.aXl > 0 && i <= this.aXl) {
                        this.lza.dj((i * 100) / this.aXl);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void FU() {
        setPadding(0, (int) ((10.0f - this.aXf) / 2.0f), 0, 0);
        this.mState = 0;
        this.aXf = 0.0f;
        if (this.aXq && getPaddingTop() > this.aXl) {
            a(getHeight(), 200L, 0L, this.lzb);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aXo = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.aXi = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.lyY != null) {
            this.lyY.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aXj == null) {
                this.aXj = new DecelerateInterpolator();
            }
            this.lyY = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.lyY, j2);
            } else {
                post(this.lyY);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private final int aXu;
        private final int aXv;
        private c lzd;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aXx = true;
        private long mStartTime = -1;
        private int aXy = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aXv = i;
            this.aXu = i2;
            this.mInterpolator = TransparentHeadGridView.this.aXj;
            this.mDuration = j;
            this.lzd = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aXy = this.aXv - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aXv - this.aXu));
                TransparentHeadGridView.this.setPadding(0, this.aXy, 0, 0);
                if (TransparentHeadGridView.this.lza != null && this.aXy >= 0 && TransparentHeadGridView.this.aXl > 0 && this.aXy <= TransparentHeadGridView.this.aXl) {
                    TransparentHeadGridView.this.lza.dj((this.aXy * 100) / TransparentHeadGridView.this.aXl);
                }
            }
            if (this.aXx && this.aXu != this.aXy) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.lzd != null) {
                this.lzd.FV();
            }
        }

        public void stop() {
            this.aXx = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.lyZ = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.lza = bVar;
    }
}
