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
    private float aJG;
    private Interpolator cKT;
    private Animation.AnimationListener ehd;
    private boolean jOb;
    private int jOc;
    private View jOd;
    private d jOe;
    private int jOf;
    private a jOg;
    private b jOh;
    private AbsListView.OnScrollListener jOi;
    private int jOj;
    private boolean jOk;
    private c jOl;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes3.dex */
    public interface a {
        void CW(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void CX(int i);

        void cAv();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void ayI();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.aJG = 0.0f;
        this.jOb = true;
        this.jOc = -1;
        this.jOj = -1;
        this.jOk = false;
        this.ehd = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.jOk) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jOl = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void ayI() {
                if (TransparentHeadGridView.this.jOk) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.jOh != null) {
                    TransparentHeadGridView.this.jOh.cAv();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.jOi != null) {
                    TransparentHeadGridView.this.jOi.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.jOg != null && TransparentHeadGridView.this.jOj != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.jOg.CW(100);
                        TransparentHeadGridView.this.jOj = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.jOc < 0) {
                        TransparentHeadGridView.this.jOc = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.jOc);
                    TransparentHeadGridView.this.jOb = i4 == 0;
                    if (TransparentHeadGridView.this.jOd != null) {
                        TransparentHeadGridView.this.jOd.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.jOg != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.jOj) {
                        TransparentHeadGridView.this.jOg.CW(height);
                        TransparentHeadGridView.this.jOj = height;
                    }
                }
                if (TransparentHeadGridView.this.jOi != null) {
                    TransparentHeadGridView.this.jOi.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.aJG = 0.0f;
        this.jOb = true;
        this.jOc = -1;
        this.jOj = -1;
        this.jOk = false;
        this.ehd = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.jOk) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jOl = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void ayI() {
                if (TransparentHeadGridView.this.jOk) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.jOh != null) {
                    TransparentHeadGridView.this.jOh.cAv();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.jOi != null) {
                    TransparentHeadGridView.this.jOi.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.jOg != null && TransparentHeadGridView.this.jOj != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.jOg.CW(100);
                        TransparentHeadGridView.this.jOj = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.jOc < 0) {
                        TransparentHeadGridView.this.jOc = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.jOc);
                    TransparentHeadGridView.this.jOb = i4 == 0;
                    if (TransparentHeadGridView.this.jOd != null) {
                        TransparentHeadGridView.this.jOd.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.jOg != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.jOj) {
                        TransparentHeadGridView.this.jOg.CW(height);
                        TransparentHeadGridView.this.jOj = height;
                    }
                }
                if (TransparentHeadGridView.this.jOi != null) {
                    TransparentHeadGridView.this.jOi.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.aJG = 0.0f;
        this.jOb = true;
        this.jOc = -1;
        this.jOj = -1;
        this.jOk = false;
        this.ehd = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.jOk) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jOl = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void ayI() {
                if (TransparentHeadGridView.this.jOk) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.jOh != null) {
                    TransparentHeadGridView.this.jOh.cAv();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.jOi != null) {
                    TransparentHeadGridView.this.jOi.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.jOg != null && TransparentHeadGridView.this.jOj != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.jOg.CW(100);
                        TransparentHeadGridView.this.jOj = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.jOc < 0) {
                        TransparentHeadGridView.this.jOc = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.jOc);
                    TransparentHeadGridView.this.jOb = i4 == 0;
                    if (TransparentHeadGridView.this.jOd != null) {
                        TransparentHeadGridView.this.jOd.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.jOg != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.jOj) {
                        TransparentHeadGridView.this.jOg.CW(height);
                        TransparentHeadGridView.this.jOj = height;
                    }
                }
                if (TransparentHeadGridView.this.jOi != null) {
                    TransparentHeadGridView.this.jOi.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.jOf = (int) (l.ah(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.aJG = 0.0f;
                if (this.jOk && getPaddingTop() > this.jOf) {
                    a(getHeight(), 200L, 0L, this.jOl);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.aJG == 0.0f) {
                    this.aJG = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.aJG && getPaddingTop() == 0 && this.jOb) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.aJG) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.jOh != null && i >= 0 && this.jOf > 0 && i <= this.jOf) {
                        this.jOh.CX((i * 100) / this.jOf);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void cAu() {
        setPadding(0, (int) ((10.0f - this.aJG) / 2.0f), 0, 0);
        this.mState = 0;
        this.aJG = 0.0f;
        if (this.jOk && getPaddingTop() > this.jOf) {
            a(getHeight(), 200L, 0L, this.jOl);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.jOi = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.jOd = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.jOe != null) {
            this.jOe.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.cKT == null) {
                this.cKT = new DecelerateInterpolator();
            }
            this.jOe = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.jOe, j2);
            } else {
                post(this.jOe);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private final int aLY;
        private final int aLZ;
        private c jOn;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aMa = true;
        private long mStartTime = -1;
        private int aMb = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aLZ = i;
            this.aLY = i2;
            this.mInterpolator = TransparentHeadGridView.this.cKT;
            this.mDuration = j;
            this.jOn = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aMb = this.aLZ - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aLZ - this.aLY));
                TransparentHeadGridView.this.setPadding(0, this.aMb, 0, 0);
                if (TransparentHeadGridView.this.jOh != null && this.aMb >= 0 && TransparentHeadGridView.this.jOf > 0 && this.aMb <= TransparentHeadGridView.this.jOf) {
                    TransparentHeadGridView.this.jOh.CX((this.aMb * 100) / TransparentHeadGridView.this.jOf);
                }
            }
            if (this.aMa && this.aLY != this.aMb) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.jOn != null) {
                this.jOn.ayI();
            }
        }

        public void stop() {
            this.aMa = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.jOg = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.jOh = bVar;
    }
}
