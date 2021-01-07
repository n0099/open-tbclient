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
/* loaded from: classes8.dex */
public class TransparentHeadGridView extends GridView {
    private AbsListView.OnScrollListener bNC;
    private int bND;
    private boolean bNE;
    private Animation.AnimationListener bNF;
    private float bNt;
    private boolean bNu;
    private int bNv;
    private View bNw;
    private Interpolator bNx;
    private int bNz;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;
    private d nZt;
    private a nZu;
    private b nZv;
    private c nZw;

    /* loaded from: classes8.dex */
    public interface a {
        void gx(int i);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void Xf();

        void gy(int i);
    }

    /* loaded from: classes8.dex */
    public interface c {
        void Xe();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.bNt = 0.0f;
        this.bNu = true;
        this.bNv = -1;
        this.bND = -1;
        this.bNE = false;
        this.bNF = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bNE) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nZw = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Xe() {
                if (TransparentHeadGridView.this.bNE) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.nZv != null) {
                    TransparentHeadGridView.this.nZv.Xf();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bNC != null) {
                    TransparentHeadGridView.this.bNC.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.nZu != null && TransparentHeadGridView.this.bND != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.nZu.gx(100);
                        TransparentHeadGridView.this.bND = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bNv < 0) {
                        TransparentHeadGridView.this.bNv = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bNv);
                    TransparentHeadGridView.this.bNu = i4 == 0;
                    if (TransparentHeadGridView.this.bNw != null) {
                        TransparentHeadGridView.this.bNw.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.nZu != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bND) {
                        TransparentHeadGridView.this.nZu.gx(height);
                        TransparentHeadGridView.this.bND = height;
                    }
                }
                if (TransparentHeadGridView.this.bNC != null) {
                    TransparentHeadGridView.this.bNC.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.bNt = 0.0f;
        this.bNu = true;
        this.bNv = -1;
        this.bND = -1;
        this.bNE = false;
        this.bNF = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bNE) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nZw = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Xe() {
                if (TransparentHeadGridView.this.bNE) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.nZv != null) {
                    TransparentHeadGridView.this.nZv.Xf();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bNC != null) {
                    TransparentHeadGridView.this.bNC.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.nZu != null && TransparentHeadGridView.this.bND != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.nZu.gx(100);
                        TransparentHeadGridView.this.bND = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bNv < 0) {
                        TransparentHeadGridView.this.bNv = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bNv);
                    TransparentHeadGridView.this.bNu = i4 == 0;
                    if (TransparentHeadGridView.this.bNw != null) {
                        TransparentHeadGridView.this.bNw.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.nZu != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bND) {
                        TransparentHeadGridView.this.nZu.gx(height);
                        TransparentHeadGridView.this.bND = height;
                    }
                }
                if (TransparentHeadGridView.this.bNC != null) {
                    TransparentHeadGridView.this.bNC.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.bNt = 0.0f;
        this.bNu = true;
        this.bNv = -1;
        this.bND = -1;
        this.bNE = false;
        this.bNF = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bNE) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nZw = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Xe() {
                if (TransparentHeadGridView.this.bNE) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.nZv != null) {
                    TransparentHeadGridView.this.nZv.Xf();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.bNC != null) {
                    TransparentHeadGridView.this.bNC.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.nZu != null && TransparentHeadGridView.this.bND != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.nZu.gx(100);
                        TransparentHeadGridView.this.bND = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bNv < 0) {
                        TransparentHeadGridView.this.bNv = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bNv);
                    TransparentHeadGridView.this.bNu = i4 == 0;
                    if (TransparentHeadGridView.this.bNw != null) {
                        TransparentHeadGridView.this.bNw.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.nZu != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bND) {
                        TransparentHeadGridView.this.nZu.gx(height);
                        TransparentHeadGridView.this.bND = height;
                    }
                }
                if (TransparentHeadGridView.this.bNC != null) {
                    TransparentHeadGridView.this.bNC.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.bNz = (int) (l.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.bNt = 0.0f;
                if (this.bNE && getPaddingTop() > this.bNz) {
                    a(getHeight(), 200L, 0L, this.nZw);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
            case 2:
                if (this.bNt == 0.0f) {
                    this.bNt = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.bNt && getPaddingTop() == 0 && this.bNu) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.bNt) / 2.0f);
                    if (this.nZv != null && i >= 0 && this.bNz > 0 && i <= this.bNz) {
                        this.nZv.gy((i * 100) / this.bNz);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void Xd() {
        setPadding(0, (int) ((10.0f - this.bNt) / 2.0f), 0, 0);
        this.mState = 0;
        this.bNt = 0.0f;
        if (this.bNE && getPaddingTop() > this.bNz) {
            a(getHeight(), 200L, 0L, this.nZw);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bNC = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.bNw = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.nZt != null) {
            this.nZt.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bNx == null) {
                this.bNx = new DecelerateInterpolator();
            }
            this.nZt = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.nZt, j2);
            } else {
                post(this.nZt);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        private final int bNI;
        private final int bNJ;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private c nZy;
        private boolean bNL = true;
        private long mStartTime = -1;
        private int bNM = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bNJ = i;
            this.bNI = i2;
            this.mInterpolator = TransparentHeadGridView.this.bNx;
            this.mDuration = j;
            this.nZy = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bNM = this.bNJ - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bNJ - this.bNI));
                TransparentHeadGridView.this.setPadding(0, this.bNM, 0, 0);
                if (TransparentHeadGridView.this.nZv != null && this.bNM >= 0 && TransparentHeadGridView.this.bNz > 0 && this.bNM <= TransparentHeadGridView.this.bNz) {
                    TransparentHeadGridView.this.nZv.gy((this.bNM * 100) / TransparentHeadGridView.this.bNz);
                }
            }
            if (this.bNL && this.bNI != this.bNM) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.nZy != null) {
                this.nZy.Xe();
            }
        }

        public void stop() {
            this.bNL = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.nZu = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.nZv = bVar;
    }
}
