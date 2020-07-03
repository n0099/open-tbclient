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
    private float bjK;
    private boolean bjL;
    private int bjM;
    private View bjN;
    private Interpolator bjO;
    private int bjQ;
    private AbsListView.OnScrollListener bjT;
    private int bjU;
    private boolean bjV;
    private Animation.AnimationListener bjW;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;
    private d mnP;
    private a mnQ;
    private b mnR;
    private c mnS;

    /* loaded from: classes2.dex */
    public interface a {
        void dz(int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void Jc();

        void dA(int i);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void Jb();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.bjK = 0.0f;
        this.bjL = true;
        this.bjM = -1;
        this.bjU = -1;
        this.bjV = false;
        this.bjW = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bjV) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mnS = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Jb() {
                if (TransparentHeadGridView.this.bjV) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.mnR != null) {
                    TransparentHeadGridView.this.mnR.Jc();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bjT != null) {
                    TransparentHeadGridView.this.bjT.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.mnQ != null && TransparentHeadGridView.this.bjU != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.mnQ.dz(100);
                        TransparentHeadGridView.this.bjU = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bjM < 0) {
                        TransparentHeadGridView.this.bjM = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bjM);
                    TransparentHeadGridView.this.bjL = i4 == 0;
                    if (TransparentHeadGridView.this.bjN != null) {
                        TransparentHeadGridView.this.bjN.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.mnQ != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bjU) {
                        TransparentHeadGridView.this.mnQ.dz(height);
                        TransparentHeadGridView.this.bjU = height;
                    }
                }
                if (TransparentHeadGridView.this.bjT != null) {
                    TransparentHeadGridView.this.bjT.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.bjK = 0.0f;
        this.bjL = true;
        this.bjM = -1;
        this.bjU = -1;
        this.bjV = false;
        this.bjW = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bjV) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mnS = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Jb() {
                if (TransparentHeadGridView.this.bjV) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.mnR != null) {
                    TransparentHeadGridView.this.mnR.Jc();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bjT != null) {
                    TransparentHeadGridView.this.bjT.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.mnQ != null && TransparentHeadGridView.this.bjU != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.mnQ.dz(100);
                        TransparentHeadGridView.this.bjU = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bjM < 0) {
                        TransparentHeadGridView.this.bjM = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bjM);
                    TransparentHeadGridView.this.bjL = i4 == 0;
                    if (TransparentHeadGridView.this.bjN != null) {
                        TransparentHeadGridView.this.bjN.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.mnQ != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bjU) {
                        TransparentHeadGridView.this.mnQ.dz(height);
                        TransparentHeadGridView.this.bjU = height;
                    }
                }
                if (TransparentHeadGridView.this.bjT != null) {
                    TransparentHeadGridView.this.bjT.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.bjK = 0.0f;
        this.bjL = true;
        this.bjM = -1;
        this.bjU = -1;
        this.bjV = false;
        this.bjW = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bjV) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.mnS = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Jb() {
                if (TransparentHeadGridView.this.bjV) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.mnR != null) {
                    TransparentHeadGridView.this.mnR.Jc();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.bjT != null) {
                    TransparentHeadGridView.this.bjT.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.mnQ != null && TransparentHeadGridView.this.bjU != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.mnQ.dz(100);
                        TransparentHeadGridView.this.bjU = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bjM < 0) {
                        TransparentHeadGridView.this.bjM = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bjM);
                    TransparentHeadGridView.this.bjL = i4 == 0;
                    if (TransparentHeadGridView.this.bjN != null) {
                        TransparentHeadGridView.this.bjN.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.mnQ != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bjU) {
                        TransparentHeadGridView.this.mnQ.dz(height);
                        TransparentHeadGridView.this.bjU = height;
                    }
                }
                if (TransparentHeadGridView.this.bjT != null) {
                    TransparentHeadGridView.this.bjT.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.bjQ = (int) (l.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.bjK = 0.0f;
                if (this.bjV && getPaddingTop() > this.bjQ) {
                    a(getHeight(), 200L, 0L, this.mnS);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
            case 2:
                if (this.bjK == 0.0f) {
                    this.bjK = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.bjK && getPaddingTop() == 0 && this.bjL) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.bjK) / 2.0f);
                    if (this.mnR != null && i >= 0 && this.bjQ > 0 && i <= this.bjQ) {
                        this.mnR.dA((i * 100) / this.bjQ);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void Ja() {
        setPadding(0, (int) ((10.0f - this.bjK) / 2.0f), 0, 0);
        this.mState = 0;
        this.bjK = 0.0f;
        if (this.bjV && getPaddingTop() > this.bjQ) {
            a(getHeight(), 200L, 0L, this.mnS);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bjT = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.bjN = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.mnP != null) {
            this.mnP.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bjO == null) {
                this.bjO = new DecelerateInterpolator();
            }
            this.mnP = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.mnP, j2);
            } else {
                post(this.mnP);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private final int bjZ;
        private final int bka;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private c mnU;
        private boolean bkc = true;
        private long mStartTime = -1;
        private int bkd = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bka = i;
            this.bjZ = i2;
            this.mInterpolator = TransparentHeadGridView.this.bjO;
            this.mDuration = j;
            this.mnU = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bkd = this.bka - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bka - this.bjZ));
                TransparentHeadGridView.this.setPadding(0, this.bkd, 0, 0);
                if (TransparentHeadGridView.this.mnR != null && this.bkd >= 0 && TransparentHeadGridView.this.bjQ > 0 && this.bkd <= TransparentHeadGridView.this.bjQ) {
                    TransparentHeadGridView.this.mnR.dA((this.bkd * 100) / TransparentHeadGridView.this.bjQ);
                }
            }
            if (this.bkc && this.bjZ != this.bkd) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.mnU != null) {
                this.mnU.Jb();
            }
        }

        public void stop() {
            this.bkc = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.mnQ = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.mnR = bVar;
    }
}
