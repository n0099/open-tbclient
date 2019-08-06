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
    private Interpolator cLa;
    private Animation.AnimationListener ehk;
    private boolean jPi;
    private int jPj;
    private View jPk;
    private d jPl;
    private int jPm;
    private a jPn;
    private b jPo;
    private AbsListView.OnScrollListener jPp;
    private int jPq;
    private boolean jPr;
    private c jPs;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes3.dex */
    public interface a {
        void CY(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void CZ(int i);

        void cAQ();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void ayK();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.aJG = 0.0f;
        this.jPi = true;
        this.jPj = -1;
        this.jPq = -1;
        this.jPr = false;
        this.ehk = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.jPr) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jPs = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void ayK() {
                if (TransparentHeadGridView.this.jPr) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.jPo != null) {
                    TransparentHeadGridView.this.jPo.cAQ();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.jPp != null) {
                    TransparentHeadGridView.this.jPp.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.jPn != null && TransparentHeadGridView.this.jPq != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.jPn.CY(100);
                        TransparentHeadGridView.this.jPq = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.jPj < 0) {
                        TransparentHeadGridView.this.jPj = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.jPj);
                    TransparentHeadGridView.this.jPi = i4 == 0;
                    if (TransparentHeadGridView.this.jPk != null) {
                        TransparentHeadGridView.this.jPk.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.jPn != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.jPq) {
                        TransparentHeadGridView.this.jPn.CY(height);
                        TransparentHeadGridView.this.jPq = height;
                    }
                }
                if (TransparentHeadGridView.this.jPp != null) {
                    TransparentHeadGridView.this.jPp.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.aJG = 0.0f;
        this.jPi = true;
        this.jPj = -1;
        this.jPq = -1;
        this.jPr = false;
        this.ehk = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.jPr) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jPs = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void ayK() {
                if (TransparentHeadGridView.this.jPr) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.jPo != null) {
                    TransparentHeadGridView.this.jPo.cAQ();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.jPp != null) {
                    TransparentHeadGridView.this.jPp.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.jPn != null && TransparentHeadGridView.this.jPq != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.jPn.CY(100);
                        TransparentHeadGridView.this.jPq = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.jPj < 0) {
                        TransparentHeadGridView.this.jPj = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.jPj);
                    TransparentHeadGridView.this.jPi = i4 == 0;
                    if (TransparentHeadGridView.this.jPk != null) {
                        TransparentHeadGridView.this.jPk.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.jPn != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.jPq) {
                        TransparentHeadGridView.this.jPn.CY(height);
                        TransparentHeadGridView.this.jPq = height;
                    }
                }
                if (TransparentHeadGridView.this.jPp != null) {
                    TransparentHeadGridView.this.jPp.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.aJG = 0.0f;
        this.jPi = true;
        this.jPj = -1;
        this.jPq = -1;
        this.jPr = false;
        this.ehk = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.jPr) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jPs = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void ayK() {
                if (TransparentHeadGridView.this.jPr) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.jPo != null) {
                    TransparentHeadGridView.this.jPo.cAQ();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.jPp != null) {
                    TransparentHeadGridView.this.jPp.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.jPn != null && TransparentHeadGridView.this.jPq != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.jPn.CY(100);
                        TransparentHeadGridView.this.jPq = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.jPj < 0) {
                        TransparentHeadGridView.this.jPj = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.jPj);
                    TransparentHeadGridView.this.jPi = i4 == 0;
                    if (TransparentHeadGridView.this.jPk != null) {
                        TransparentHeadGridView.this.jPk.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.jPn != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.jPq) {
                        TransparentHeadGridView.this.jPn.CY(height);
                        TransparentHeadGridView.this.jPq = height;
                    }
                }
                if (TransparentHeadGridView.this.jPp != null) {
                    TransparentHeadGridView.this.jPp.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.jPm = (int) (l.ah(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.aJG = 0.0f;
                if (this.jPr && getPaddingTop() > this.jPm) {
                    a(getHeight(), 200L, 0L, this.jPs);
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
                if (y > this.aJG && getPaddingTop() == 0 && this.jPi) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.aJG) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.jPo != null && i >= 0 && this.jPm > 0 && i <= this.jPm) {
                        this.jPo.CZ((i * 100) / this.jPm);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void cAP() {
        setPadding(0, (int) ((10.0f - this.aJG) / 2.0f), 0, 0);
        this.mState = 0;
        this.aJG = 0.0f;
        if (this.jPr && getPaddingTop() > this.jPm) {
            a(getHeight(), 200L, 0L, this.jPs);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.jPp = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.jPk = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.jPl != null) {
            this.jPl.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.cLa == null) {
                this.cLa = new DecelerateInterpolator();
            }
            this.jPl = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.jPl, j2);
            } else {
                post(this.jPl);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private final int aLY;
        private final int aLZ;
        private c jPu;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aMa = true;
        private long mStartTime = -1;
        private int aMb = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aLZ = i;
            this.aLY = i2;
            this.mInterpolator = TransparentHeadGridView.this.cLa;
            this.mDuration = j;
            this.jPu = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aMb = this.aLZ - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aLZ - this.aLY));
                TransparentHeadGridView.this.setPadding(0, this.aMb, 0, 0);
                if (TransparentHeadGridView.this.jPo != null && this.aMb >= 0 && TransparentHeadGridView.this.jPm > 0 && this.aMb <= TransparentHeadGridView.this.jPm) {
                    TransparentHeadGridView.this.jPo.CZ((this.aMb * 100) / TransparentHeadGridView.this.jPm);
                }
            }
            if (this.aMa && this.aLY != this.aMb) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.jPu != null) {
                this.jPu.ayK();
            }
        }

        public void stop() {
            this.aMa = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.jPn = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.jPo = bVar;
    }
}
