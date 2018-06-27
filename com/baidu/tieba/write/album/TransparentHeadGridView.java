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
    private Interpolator bdH;
    private Animation.AnimationListener ciF;
    private float hbS;
    private boolean htO;
    private int htP;
    private View htQ;
    private d htR;
    private int htS;
    private a htT;
    private b htU;
    private AbsListView.OnScrollListener htV;
    private int htW;
    private boolean htX;
    private c htY;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes3.dex */
    public interface a {
        void vu(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void bHC();

        void vv(int i);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void Nt();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.hbS = 0.0f;
        this.htO = true;
        this.htP = -1;
        this.htW = -1;
        this.htX = false;
        this.ciF = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.htX) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.htY = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Nt() {
                if (TransparentHeadGridView.this.htX) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.htU != null) {
                    TransparentHeadGridView.this.htU.bHC();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.htV != null) {
                    TransparentHeadGridView.this.htV.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.htT != null && TransparentHeadGridView.this.htW != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.htT.vu(100);
                        TransparentHeadGridView.this.htW = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.htP < 0) {
                        TransparentHeadGridView.this.htP = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.htP);
                    TransparentHeadGridView.this.htO = i4 == 0;
                    if (TransparentHeadGridView.this.htQ != null) {
                        TransparentHeadGridView.this.htQ.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.htT != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.htW) {
                        TransparentHeadGridView.this.htT.vu(height);
                        TransparentHeadGridView.this.htW = height;
                    }
                }
                if (TransparentHeadGridView.this.htV != null) {
                    TransparentHeadGridView.this.htV.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.hbS = 0.0f;
        this.htO = true;
        this.htP = -1;
        this.htW = -1;
        this.htX = false;
        this.ciF = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.htX) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.htY = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Nt() {
                if (TransparentHeadGridView.this.htX) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.htU != null) {
                    TransparentHeadGridView.this.htU.bHC();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.htV != null) {
                    TransparentHeadGridView.this.htV.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.htT != null && TransparentHeadGridView.this.htW != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.htT.vu(100);
                        TransparentHeadGridView.this.htW = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.htP < 0) {
                        TransparentHeadGridView.this.htP = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.htP);
                    TransparentHeadGridView.this.htO = i4 == 0;
                    if (TransparentHeadGridView.this.htQ != null) {
                        TransparentHeadGridView.this.htQ.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.htT != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.htW) {
                        TransparentHeadGridView.this.htT.vu(height);
                        TransparentHeadGridView.this.htW = height;
                    }
                }
                if (TransparentHeadGridView.this.htV != null) {
                    TransparentHeadGridView.this.htV.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.hbS = 0.0f;
        this.htO = true;
        this.htP = -1;
        this.htW = -1;
        this.htX = false;
        this.ciF = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.htX) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.htY = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Nt() {
                if (TransparentHeadGridView.this.htX) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.htU != null) {
                    TransparentHeadGridView.this.htU.bHC();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.htV != null) {
                    TransparentHeadGridView.this.htV.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.htT != null && TransparentHeadGridView.this.htW != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.htT.vu(100);
                        TransparentHeadGridView.this.htW = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.htP < 0) {
                        TransparentHeadGridView.this.htP = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.htP);
                    TransparentHeadGridView.this.htO = i4 == 0;
                    if (TransparentHeadGridView.this.htQ != null) {
                        TransparentHeadGridView.this.htQ.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.htT != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.htW) {
                        TransparentHeadGridView.this.htT.vu(height);
                        TransparentHeadGridView.this.htW = height;
                    }
                }
                if (TransparentHeadGridView.this.htV != null) {
                    TransparentHeadGridView.this.htV.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.htS = (int) (l.aj(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.hbS = 0.0f;
                if (this.htX && getPaddingTop() > this.htS) {
                    a(getHeight(), 200L, 0L, this.htY);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.hbS == 0.0f) {
                    this.hbS = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.hbS && getPaddingTop() == 0 && this.htO) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.hbS) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.htU != null && i >= 0 && this.htS > 0 && i <= this.htS) {
                        this.htU.vv((i * 100) / this.htS);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void bHB() {
        setPadding(0, (int) ((10.0f - this.hbS) / 2.0f), 0, 0);
        this.mState = 0;
        this.hbS = 0.0f;
        if (this.htX && getPaddingTop() > this.htS) {
            a(getHeight(), 200L, 0L, this.htY);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.htV = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.htQ = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.htR != null) {
            this.htR.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bdH == null) {
                this.bdH = new DecelerateInterpolator();
            }
            this.htR = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.htR, j2);
            } else {
                post(this.htR);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private final int bdU;
        private final int bdV;
        private c hua;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bdX = true;
        private long mStartTime = -1;
        private int bdY = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bdV = i;
            this.bdU = i2;
            this.mInterpolator = TransparentHeadGridView.this.bdH;
            this.mDuration = j;
            this.hua = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bdY = this.bdV - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bdV - this.bdU));
                TransparentHeadGridView.this.setPadding(0, this.bdY, 0, 0);
                if (TransparentHeadGridView.this.htU != null && this.bdY >= 0 && TransparentHeadGridView.this.htS > 0 && this.bdY <= TransparentHeadGridView.this.htS) {
                    TransparentHeadGridView.this.htU.vv((this.bdY * 100) / TransparentHeadGridView.this.htS);
                }
            }
            if (this.bdX && this.bdU != this.bdY) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.hua != null) {
                this.hua.Nt();
            }
        }

        public void stop() {
            this.bdX = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.htT = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.htU = bVar;
    }
}
