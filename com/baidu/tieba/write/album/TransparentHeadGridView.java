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
    private float aHa;
    private Interpolator cBq;
    private Animation.AnimationListener dST;
    private boolean jol;
    private int jom;
    private View jon;
    private d joo;
    private int jop;
    private a joq;
    private b jor;
    private AbsListView.OnScrollListener jos;
    private int jot;
    private boolean jou;
    private c jov;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes3.dex */
    public interface a {
        void Bk(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void Bl(int i);

        void cpn();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void asu();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.aHa = 0.0f;
        this.jol = true;
        this.jom = -1;
        this.jot = -1;
        this.jou = false;
        this.dST = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.jou) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jov = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void asu() {
                if (TransparentHeadGridView.this.jou) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.jor != null) {
                    TransparentHeadGridView.this.jor.cpn();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.jos != null) {
                    TransparentHeadGridView.this.jos.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.joq != null && TransparentHeadGridView.this.jot != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.joq.Bk(100);
                        TransparentHeadGridView.this.jot = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.jom < 0) {
                        TransparentHeadGridView.this.jom = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.jom);
                    TransparentHeadGridView.this.jol = i4 == 0;
                    if (TransparentHeadGridView.this.jon != null) {
                        TransparentHeadGridView.this.jon.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.joq != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.jot) {
                        TransparentHeadGridView.this.joq.Bk(height);
                        TransparentHeadGridView.this.jot = height;
                    }
                }
                if (TransparentHeadGridView.this.jos != null) {
                    TransparentHeadGridView.this.jos.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.aHa = 0.0f;
        this.jol = true;
        this.jom = -1;
        this.jot = -1;
        this.jou = false;
        this.dST = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.jou) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jov = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void asu() {
                if (TransparentHeadGridView.this.jou) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.jor != null) {
                    TransparentHeadGridView.this.jor.cpn();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.jos != null) {
                    TransparentHeadGridView.this.jos.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.joq != null && TransparentHeadGridView.this.jot != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.joq.Bk(100);
                        TransparentHeadGridView.this.jot = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.jom < 0) {
                        TransparentHeadGridView.this.jom = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.jom);
                    TransparentHeadGridView.this.jol = i4 == 0;
                    if (TransparentHeadGridView.this.jon != null) {
                        TransparentHeadGridView.this.jon.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.joq != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.jot) {
                        TransparentHeadGridView.this.joq.Bk(height);
                        TransparentHeadGridView.this.jot = height;
                    }
                }
                if (TransparentHeadGridView.this.jos != null) {
                    TransparentHeadGridView.this.jos.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.aHa = 0.0f;
        this.jol = true;
        this.jom = -1;
        this.jot = -1;
        this.jou = false;
        this.dST = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.jou) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jov = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void asu() {
                if (TransparentHeadGridView.this.jou) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.jor != null) {
                    TransparentHeadGridView.this.jor.cpn();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.jos != null) {
                    TransparentHeadGridView.this.jos.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.joq != null && TransparentHeadGridView.this.jot != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.joq.Bk(100);
                        TransparentHeadGridView.this.jot = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.jom < 0) {
                        TransparentHeadGridView.this.jom = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.jom);
                    TransparentHeadGridView.this.jol = i4 == 0;
                    if (TransparentHeadGridView.this.jon != null) {
                        TransparentHeadGridView.this.jon.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.joq != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.jot) {
                        TransparentHeadGridView.this.joq.Bk(height);
                        TransparentHeadGridView.this.jot = height;
                    }
                }
                if (TransparentHeadGridView.this.jos != null) {
                    TransparentHeadGridView.this.jos.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.jop = (int) (l.aQ(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.aHa = 0.0f;
                if (this.jou && getPaddingTop() > this.jop) {
                    a(getHeight(), 200L, 0L, this.jov);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.aHa == 0.0f) {
                    this.aHa = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.aHa && getPaddingTop() == 0 && this.jol) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.aHa) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.jor != null && i >= 0 && this.jop > 0 && i <= this.jop) {
                        this.jor.Bl((i * 100) / this.jop);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void cpm() {
        setPadding(0, (int) ((10.0f - this.aHa) / 2.0f), 0, 0);
        this.mState = 0;
        this.aHa = 0.0f;
        if (this.jou && getPaddingTop() > this.jop) {
            a(getHeight(), 200L, 0L, this.jov);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.jos = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.jon = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.joo != null) {
            this.joo.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.cBq == null) {
                this.cBq = new DecelerateInterpolator();
            }
            this.joo = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.joo, j2);
            } else {
                post(this.joo);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private final int aJs;
        private final int aJt;
        private c jox;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aJu = true;
        private long mStartTime = -1;
        private int aJv = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aJt = i;
            this.aJs = i2;
            this.mInterpolator = TransparentHeadGridView.this.cBq;
            this.mDuration = j;
            this.jox = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aJv = this.aJt - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aJt - this.aJs));
                TransparentHeadGridView.this.setPadding(0, this.aJv, 0, 0);
                if (TransparentHeadGridView.this.jor != null && this.aJv >= 0 && TransparentHeadGridView.this.jop > 0 && this.aJv <= TransparentHeadGridView.this.jop) {
                    TransparentHeadGridView.this.jor.Bl((this.aJv * 100) / TransparentHeadGridView.this.jop);
                }
            }
            if (this.aJu && this.aJs != this.aJv) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.jox != null) {
                this.jox.asu();
            }
        }

        public void stop() {
            this.aJu = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.joq = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.jor = bVar;
    }
}
