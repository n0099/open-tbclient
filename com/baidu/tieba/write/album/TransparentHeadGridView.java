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
    private float bwJ;
    private boolean bwK;
    private int bwL;
    private View bwM;
    private Interpolator bwN;
    private int bwP;
    private AbsListView.OnScrollListener bwS;
    private int bwT;
    private boolean bwU;
    private Animation.AnimationListener bwV;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;
    private d nnU;
    private a nnV;
    private b nnW;
    private c nnX;

    /* loaded from: classes3.dex */
    public interface a {
        void fM(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void QI();

        void fN(int i);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void QH();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.bwJ = 0.0f;
        this.bwK = true;
        this.bwL = -1;
        this.bwT = -1;
        this.bwU = false;
        this.bwV = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bwU) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nnX = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void QH() {
                if (TransparentHeadGridView.this.bwU) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.nnW != null) {
                    TransparentHeadGridView.this.nnW.QI();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bwS != null) {
                    TransparentHeadGridView.this.bwS.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.nnV != null && TransparentHeadGridView.this.bwT != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.nnV.fM(100);
                        TransparentHeadGridView.this.bwT = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bwL < 0) {
                        TransparentHeadGridView.this.bwL = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bwL);
                    TransparentHeadGridView.this.bwK = i4 == 0;
                    if (TransparentHeadGridView.this.bwM != null) {
                        TransparentHeadGridView.this.bwM.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.nnV != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bwT) {
                        TransparentHeadGridView.this.nnV.fM(height);
                        TransparentHeadGridView.this.bwT = height;
                    }
                }
                if (TransparentHeadGridView.this.bwS != null) {
                    TransparentHeadGridView.this.bwS.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.bwJ = 0.0f;
        this.bwK = true;
        this.bwL = -1;
        this.bwT = -1;
        this.bwU = false;
        this.bwV = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bwU) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nnX = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void QH() {
                if (TransparentHeadGridView.this.bwU) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.nnW != null) {
                    TransparentHeadGridView.this.nnW.QI();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bwS != null) {
                    TransparentHeadGridView.this.bwS.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.nnV != null && TransparentHeadGridView.this.bwT != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.nnV.fM(100);
                        TransparentHeadGridView.this.bwT = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bwL < 0) {
                        TransparentHeadGridView.this.bwL = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bwL);
                    TransparentHeadGridView.this.bwK = i4 == 0;
                    if (TransparentHeadGridView.this.bwM != null) {
                        TransparentHeadGridView.this.bwM.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.nnV != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bwT) {
                        TransparentHeadGridView.this.nnV.fM(height);
                        TransparentHeadGridView.this.bwT = height;
                    }
                }
                if (TransparentHeadGridView.this.bwS != null) {
                    TransparentHeadGridView.this.bwS.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.bwJ = 0.0f;
        this.bwK = true;
        this.bwL = -1;
        this.bwT = -1;
        this.bwU = false;
        this.bwV = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bwU) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nnX = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void QH() {
                if (TransparentHeadGridView.this.bwU) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.nnW != null) {
                    TransparentHeadGridView.this.nnW.QI();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.bwS != null) {
                    TransparentHeadGridView.this.bwS.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.nnV != null && TransparentHeadGridView.this.bwT != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.nnV.fM(100);
                        TransparentHeadGridView.this.bwT = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bwL < 0) {
                        TransparentHeadGridView.this.bwL = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bwL);
                    TransparentHeadGridView.this.bwK = i4 == 0;
                    if (TransparentHeadGridView.this.bwM != null) {
                        TransparentHeadGridView.this.bwM.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.nnV != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bwT) {
                        TransparentHeadGridView.this.nnV.fM(height);
                        TransparentHeadGridView.this.bwT = height;
                    }
                }
                if (TransparentHeadGridView.this.bwS != null) {
                    TransparentHeadGridView.this.bwS.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.bwP = (int) (l.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.bwJ = 0.0f;
                if (this.bwU && getPaddingTop() > this.bwP) {
                    a(getHeight(), 200L, 0L, this.nnX);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
            case 2:
                if (this.bwJ == 0.0f) {
                    this.bwJ = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.bwJ && getPaddingTop() == 0 && this.bwK) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.bwJ) / 2.0f);
                    if (this.nnW != null && i >= 0 && this.bwP > 0 && i <= this.bwP) {
                        this.nnW.fN((i * 100) / this.bwP);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void QG() {
        setPadding(0, (int) ((10.0f - this.bwJ) / 2.0f), 0, 0);
        this.mState = 0;
        this.bwJ = 0.0f;
        if (this.bwU && getPaddingTop() > this.bwP) {
            a(getHeight(), 200L, 0L, this.nnX);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bwS = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.bwM = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.nnU != null) {
            this.nnU.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bwN == null) {
                this.bwN = new DecelerateInterpolator();
            }
            this.nnU = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.nnU, j2);
            } else {
                post(this.nnU);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private final int bwY;
        private final int bwZ;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private c nnZ;
        private boolean bxb = true;
        private long mStartTime = -1;
        private int bxc = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bwZ = i;
            this.bwY = i2;
            this.mInterpolator = TransparentHeadGridView.this.bwN;
            this.mDuration = j;
            this.nnZ = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bxc = this.bwZ - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bwZ - this.bwY));
                TransparentHeadGridView.this.setPadding(0, this.bxc, 0, 0);
                if (TransparentHeadGridView.this.nnW != null && this.bxc >= 0 && TransparentHeadGridView.this.bwP > 0 && this.bxc <= TransparentHeadGridView.this.bwP) {
                    TransparentHeadGridView.this.nnW.fN((this.bxc * 100) / TransparentHeadGridView.this.bwP);
                }
            }
            if (this.bxb && this.bwY != this.bxc) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.nnZ != null) {
                this.nnZ.QH();
            }
        }

        public void stop() {
            this.bxb = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.nnV = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.nnW = bVar;
    }
}
