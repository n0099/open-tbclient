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
/* loaded from: classes2.dex */
public class TransparentHeadGridView extends GridView {
    private Interpolator bJG;
    private Animation.AnimationListener cHI;
    private boolean hFS;
    private int hFT;
    private View hFU;
    private d hFV;
    private int hFW;
    private a hFX;
    private b hFY;
    private AbsListView.OnScrollListener hFZ;
    private int hGa;
    private boolean hGb;
    private c hGc;
    private float hpq;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes2.dex */
    public interface a {
        void xp(int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void bGG();

        void xq(int i);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void Rb();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.hpq = 0.0f;
        this.hFS = true;
        this.hFT = -1;
        this.hGa = -1;
        this.hGb = false;
        this.cHI = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hGb) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hGc = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Rb() {
                if (TransparentHeadGridView.this.hGb) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hFY != null) {
                    TransparentHeadGridView.this.hFY.bGG();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hFZ != null) {
                    TransparentHeadGridView.this.hFZ.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hFX != null && TransparentHeadGridView.this.hGa != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hFX.xp(100);
                        TransparentHeadGridView.this.hGa = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hFT < 0) {
                        TransparentHeadGridView.this.hFT = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hFT);
                    TransparentHeadGridView.this.hFS = i4 == 0;
                    if (TransparentHeadGridView.this.hFU != null) {
                        TransparentHeadGridView.this.hFU.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hFX != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hGa) {
                        TransparentHeadGridView.this.hFX.xp(height);
                        TransparentHeadGridView.this.hGa = height;
                    }
                }
                if (TransparentHeadGridView.this.hFZ != null) {
                    TransparentHeadGridView.this.hFZ.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.hpq = 0.0f;
        this.hFS = true;
        this.hFT = -1;
        this.hGa = -1;
        this.hGb = false;
        this.cHI = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hGb) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hGc = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Rb() {
                if (TransparentHeadGridView.this.hGb) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hFY != null) {
                    TransparentHeadGridView.this.hFY.bGG();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hFZ != null) {
                    TransparentHeadGridView.this.hFZ.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hFX != null && TransparentHeadGridView.this.hGa != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hFX.xp(100);
                        TransparentHeadGridView.this.hGa = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hFT < 0) {
                        TransparentHeadGridView.this.hFT = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hFT);
                    TransparentHeadGridView.this.hFS = i4 == 0;
                    if (TransparentHeadGridView.this.hFU != null) {
                        TransparentHeadGridView.this.hFU.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hFX != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hGa) {
                        TransparentHeadGridView.this.hFX.xp(height);
                        TransparentHeadGridView.this.hGa = height;
                    }
                }
                if (TransparentHeadGridView.this.hFZ != null) {
                    TransparentHeadGridView.this.hFZ.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.hpq = 0.0f;
        this.hFS = true;
        this.hFT = -1;
        this.hGa = -1;
        this.hGb = false;
        this.cHI = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hGb) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hGc = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Rb() {
                if (TransparentHeadGridView.this.hGb) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hFY != null) {
                    TransparentHeadGridView.this.hFY.bGG();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.hFZ != null) {
                    TransparentHeadGridView.this.hFZ.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hFX != null && TransparentHeadGridView.this.hGa != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hFX.xp(100);
                        TransparentHeadGridView.this.hGa = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hFT < 0) {
                        TransparentHeadGridView.this.hFT = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hFT);
                    TransparentHeadGridView.this.hFS = i4 == 0;
                    if (TransparentHeadGridView.this.hFU != null) {
                        TransparentHeadGridView.this.hFU.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hFX != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hGa) {
                        TransparentHeadGridView.this.hFX.xp(height);
                        TransparentHeadGridView.this.hGa = height;
                    }
                }
                if (TransparentHeadGridView.this.hFZ != null) {
                    TransparentHeadGridView.this.hFZ.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.hFW = (int) (com.baidu.adp.lib.util.l.aq(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.hpq = 0.0f;
                if (this.hGb && getPaddingTop() > this.hFW) {
                    a(getHeight(), 200L, 0L, this.hGc);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.hpq == 0.0f) {
                    this.hpq = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.hpq && getPaddingTop() == 0 && this.hFS) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.hpq) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.hFY != null && i >= 0 && this.hFW > 0 && i <= this.hFW) {
                        this.hFY.xq((i * 100) / this.hFW);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void bGF() {
        setPadding(0, (int) ((10.0f - this.hpq) / 2.0f), 0, 0);
        this.mState = 0;
        this.hpq = 0.0f;
        if (this.hGb && getPaddingTop() > this.hFW) {
            a(getHeight(), 200L, 0L, this.hGc);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hFZ = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.hFU = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.hFV != null) {
            this.hFV.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bJG == null) {
                this.bJG = new DecelerateInterpolator();
            }
            this.hFV = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.hFV, j2);
            } else {
                post(this.hFV);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private final int bJV;
        private final int bJW;
        private c hGe;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bJY = true;
        private long mStartTime = -1;
        private int bJZ = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bJW = i;
            this.bJV = i2;
            this.mInterpolator = TransparentHeadGridView.this.bJG;
            this.mDuration = j;
            this.hGe = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bJZ = this.bJW - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bJW - this.bJV));
                TransparentHeadGridView.this.setPadding(0, this.bJZ, 0, 0);
                if (TransparentHeadGridView.this.hFY != null && this.bJZ >= 0 && TransparentHeadGridView.this.hFW > 0 && this.bJZ <= TransparentHeadGridView.this.hFW) {
                    TransparentHeadGridView.this.hFY.xq((this.bJZ * 100) / TransparentHeadGridView.this.hFW);
                }
            }
            if (this.bJY && this.bJV != this.bJZ) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.hGe != null) {
                this.hGe.Rb();
            }
        }

        public void stop() {
            this.bJY = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.hFX = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.hFY = bVar;
    }
}
