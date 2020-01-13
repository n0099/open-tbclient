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
/* loaded from: classes11.dex */
public class TransparentHeadGridView extends GridView {
    private float ayM;
    private boolean ayN;
    private int ayO;
    private View ayP;
    private Interpolator ayQ;
    private int ayS;
    private AbsListView.OnScrollListener ayV;
    private int ayW;
    private boolean ayX;
    private Animation.AnimationListener ayY;
    private d kMT;
    private a kMU;
    private b kMV;
    private c kMW;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes11.dex */
    public interface a {
        void cD(int i);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void cE(int i);

        void yz();
    }

    /* loaded from: classes11.dex */
    public interface c {
        void yy();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.ayM = 0.0f;
        this.ayN = true;
        this.ayO = -1;
        this.ayW = -1;
        this.ayX = false;
        this.ayY = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.ayX) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kMW = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void yy() {
                if (TransparentHeadGridView.this.ayX) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.kMV != null) {
                    TransparentHeadGridView.this.kMV.yz();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.ayV != null) {
                    TransparentHeadGridView.this.ayV.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.kMU != null && TransparentHeadGridView.this.ayW != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.kMU.cD(100);
                        TransparentHeadGridView.this.ayW = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.ayO < 0) {
                        TransparentHeadGridView.this.ayO = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.ayO);
                    TransparentHeadGridView.this.ayN = i4 == 0;
                    if (TransparentHeadGridView.this.ayP != null) {
                        TransparentHeadGridView.this.ayP.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.kMU != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.ayW) {
                        TransparentHeadGridView.this.kMU.cD(height);
                        TransparentHeadGridView.this.ayW = height;
                    }
                }
                if (TransparentHeadGridView.this.ayV != null) {
                    TransparentHeadGridView.this.ayV.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.ayM = 0.0f;
        this.ayN = true;
        this.ayO = -1;
        this.ayW = -1;
        this.ayX = false;
        this.ayY = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.ayX) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kMW = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void yy() {
                if (TransparentHeadGridView.this.ayX) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.kMV != null) {
                    TransparentHeadGridView.this.kMV.yz();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.ayV != null) {
                    TransparentHeadGridView.this.ayV.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.kMU != null && TransparentHeadGridView.this.ayW != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.kMU.cD(100);
                        TransparentHeadGridView.this.ayW = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.ayO < 0) {
                        TransparentHeadGridView.this.ayO = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.ayO);
                    TransparentHeadGridView.this.ayN = i4 == 0;
                    if (TransparentHeadGridView.this.ayP != null) {
                        TransparentHeadGridView.this.ayP.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.kMU != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.ayW) {
                        TransparentHeadGridView.this.kMU.cD(height);
                        TransparentHeadGridView.this.ayW = height;
                    }
                }
                if (TransparentHeadGridView.this.ayV != null) {
                    TransparentHeadGridView.this.ayV.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.ayM = 0.0f;
        this.ayN = true;
        this.ayO = -1;
        this.ayW = -1;
        this.ayX = false;
        this.ayY = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.ayX) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kMW = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void yy() {
                if (TransparentHeadGridView.this.ayX) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.kMV != null) {
                    TransparentHeadGridView.this.kMV.yz();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.ayV != null) {
                    TransparentHeadGridView.this.ayV.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.kMU != null && TransparentHeadGridView.this.ayW != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.kMU.cD(100);
                        TransparentHeadGridView.this.ayW = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.ayO < 0) {
                        TransparentHeadGridView.this.ayO = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.ayO);
                    TransparentHeadGridView.this.ayN = i4 == 0;
                    if (TransparentHeadGridView.this.ayP != null) {
                        TransparentHeadGridView.this.ayP.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.kMU != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.ayW) {
                        TransparentHeadGridView.this.kMU.cD(height);
                        TransparentHeadGridView.this.ayW = height;
                    }
                }
                if (TransparentHeadGridView.this.ayV != null) {
                    TransparentHeadGridView.this.ayV.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.ayS = (int) (l.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.ayM = 0.0f;
                if (this.ayX && getPaddingTop() > this.ayS) {
                    a(getHeight(), 200L, 0L, this.kMW);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.ayM == 0.0f) {
                    this.ayM = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.ayM && getPaddingTop() == 0 && this.ayN) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.ayM) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.kMV != null && i >= 0 && this.ayS > 0 && i <= this.ayS) {
                        this.kMV.cE((i * 100) / this.ayS);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void yx() {
        setPadding(0, (int) ((10.0f - this.ayM) / 2.0f), 0, 0);
        this.mState = 0;
        this.ayM = 0.0f;
        if (this.ayX && getPaddingTop() > this.ayS) {
            a(getHeight(), 200L, 0L, this.kMW);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.ayV = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.ayP = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.kMT != null) {
            this.kMT.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.ayQ == null) {
                this.ayQ = new DecelerateInterpolator();
            }
            this.kMT = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.kMT, j2);
            } else {
                post(this.kMT);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements Runnable {
        private final int azb;
        private final int azc;
        private c kMY;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aze = true;
        private long mStartTime = -1;
        private int mCurrentY = -1;

        public d(int i, int i2, long j, c cVar) {
            this.azc = i;
            this.azb = i2;
            this.mInterpolator = TransparentHeadGridView.this.ayQ;
            this.mDuration = j;
            this.kMY = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.mCurrentY = this.azc - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.azc - this.azb));
                TransparentHeadGridView.this.setPadding(0, this.mCurrentY, 0, 0);
                if (TransparentHeadGridView.this.kMV != null && this.mCurrentY >= 0 && TransparentHeadGridView.this.ayS > 0 && this.mCurrentY <= TransparentHeadGridView.this.ayS) {
                    TransparentHeadGridView.this.kMV.cE((this.mCurrentY * 100) / TransparentHeadGridView.this.ayS);
                }
            }
            if (this.aze && this.azb != this.mCurrentY) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.kMY != null) {
                this.kMY.yy();
            }
        }

        public void stop() {
            this.aze = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.kMU = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.kMV = bVar;
    }
}
