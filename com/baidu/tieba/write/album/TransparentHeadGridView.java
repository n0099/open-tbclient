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
    private Interpolator bhp;
    private Animation.AnimationListener cqb;
    private boolean hCR;
    private int hCS;
    private View hCT;
    private d hCU;
    private int hCV;
    private a hCW;
    private b hCX;
    private AbsListView.OnScrollListener hCY;
    private int hCZ;
    private boolean hDa;
    private c hDb;
    private float hkY;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes3.dex */
    public interface a {
        void vT(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void bJh();

        void vU(int i);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void OM();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.hkY = 0.0f;
        this.hCR = true;
        this.hCS = -1;
        this.hCZ = -1;
        this.hDa = false;
        this.cqb = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hDa) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hDb = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void OM() {
                if (TransparentHeadGridView.this.hDa) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hCX != null) {
                    TransparentHeadGridView.this.hCX.bJh();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hCY != null) {
                    TransparentHeadGridView.this.hCY.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hCW != null && TransparentHeadGridView.this.hCZ != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hCW.vT(100);
                        TransparentHeadGridView.this.hCZ = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hCS < 0) {
                        TransparentHeadGridView.this.hCS = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hCS);
                    TransparentHeadGridView.this.hCR = i4 == 0;
                    if (TransparentHeadGridView.this.hCT != null) {
                        TransparentHeadGridView.this.hCT.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hCW != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hCZ) {
                        TransparentHeadGridView.this.hCW.vT(height);
                        TransparentHeadGridView.this.hCZ = height;
                    }
                }
                if (TransparentHeadGridView.this.hCY != null) {
                    TransparentHeadGridView.this.hCY.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.hkY = 0.0f;
        this.hCR = true;
        this.hCS = -1;
        this.hCZ = -1;
        this.hDa = false;
        this.cqb = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hDa) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hDb = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void OM() {
                if (TransparentHeadGridView.this.hDa) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hCX != null) {
                    TransparentHeadGridView.this.hCX.bJh();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hCY != null) {
                    TransparentHeadGridView.this.hCY.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hCW != null && TransparentHeadGridView.this.hCZ != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hCW.vT(100);
                        TransparentHeadGridView.this.hCZ = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hCS < 0) {
                        TransparentHeadGridView.this.hCS = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hCS);
                    TransparentHeadGridView.this.hCR = i4 == 0;
                    if (TransparentHeadGridView.this.hCT != null) {
                        TransparentHeadGridView.this.hCT.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hCW != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hCZ) {
                        TransparentHeadGridView.this.hCW.vT(height);
                        TransparentHeadGridView.this.hCZ = height;
                    }
                }
                if (TransparentHeadGridView.this.hCY != null) {
                    TransparentHeadGridView.this.hCY.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.hkY = 0.0f;
        this.hCR = true;
        this.hCS = -1;
        this.hCZ = -1;
        this.hDa = false;
        this.cqb = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hDa) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hDb = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void OM() {
                if (TransparentHeadGridView.this.hDa) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hCX != null) {
                    TransparentHeadGridView.this.hCX.bJh();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.hCY != null) {
                    TransparentHeadGridView.this.hCY.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hCW != null && TransparentHeadGridView.this.hCZ != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hCW.vT(100);
                        TransparentHeadGridView.this.hCZ = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hCS < 0) {
                        TransparentHeadGridView.this.hCS = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hCS);
                    TransparentHeadGridView.this.hCR = i4 == 0;
                    if (TransparentHeadGridView.this.hCT != null) {
                        TransparentHeadGridView.this.hCT.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hCW != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hCZ) {
                        TransparentHeadGridView.this.hCW.vT(height);
                        TransparentHeadGridView.this.hCZ = height;
                    }
                }
                if (TransparentHeadGridView.this.hCY != null) {
                    TransparentHeadGridView.this.hCY.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.hCV = (int) (l.aQ(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.hkY = 0.0f;
                if (this.hDa && getPaddingTop() > this.hCV) {
                    a(getHeight(), 200L, 0L, this.hDb);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.hkY == 0.0f) {
                    this.hkY = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.hkY && getPaddingTop() == 0 && this.hCR) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.hkY) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.hCX != null && i >= 0 && this.hCV > 0 && i <= this.hCV) {
                        this.hCX.vU((i * 100) / this.hCV);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void bJg() {
        setPadding(0, (int) ((10.0f - this.hkY) / 2.0f), 0, 0);
        this.mState = 0;
        this.hkY = 0.0f;
        if (this.hDa && getPaddingTop() > this.hCV) {
            a(getHeight(), 200L, 0L, this.hDb);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hCY = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.hCT = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.hCU != null) {
            this.hCU.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bhp == null) {
                this.bhp = new DecelerateInterpolator();
            }
            this.hCU = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.hCU, j2);
            } else {
                post(this.hCU);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private final int bhC;
        private final int bhD;
        private c hDd;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bhF = true;
        private long mStartTime = -1;
        private int bhG = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bhD = i;
            this.bhC = i2;
            this.mInterpolator = TransparentHeadGridView.this.bhp;
            this.mDuration = j;
            this.hDd = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bhG = this.bhD - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bhD - this.bhC));
                TransparentHeadGridView.this.setPadding(0, this.bhG, 0, 0);
                if (TransparentHeadGridView.this.hCX != null && this.bhG >= 0 && TransparentHeadGridView.this.hCV > 0 && this.bhG <= TransparentHeadGridView.this.hCV) {
                    TransparentHeadGridView.this.hCX.vU((this.bhG * 100) / TransparentHeadGridView.this.hCV);
                }
            }
            if (this.bhF && this.bhC != this.bhG) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.hDd != null) {
                this.hDd.OM();
            }
        }

        public void stop() {
            this.bhF = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.hCW = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.hCX = bVar;
    }
}
