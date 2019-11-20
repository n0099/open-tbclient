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
    private Animation.AnimationListener aqA;
    private float aqo;
    private boolean aqp;
    private int aqq;
    private View aqr;
    private Interpolator aqs;
    private int aqu;
    private AbsListView.OnScrollListener aqx;
    private int aqy;
    private boolean aqz;
    private d jOF;
    private a jOG;
    private b jOH;
    private c jOI;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes3.dex */
    public interface a {
        void ck(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void cl(int i);

        void wl();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void wk();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.aqo = 0.0f;
        this.aqp = true;
        this.aqq = -1;
        this.aqy = -1;
        this.aqz = false;
        this.aqA = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aqz) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jOI = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void wk() {
                if (TransparentHeadGridView.this.aqz) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.jOH != null) {
                    TransparentHeadGridView.this.jOH.wl();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.aqx != null) {
                    TransparentHeadGridView.this.aqx.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.jOG != null && TransparentHeadGridView.this.aqy != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.jOG.ck(100);
                        TransparentHeadGridView.this.aqy = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aqq < 0) {
                        TransparentHeadGridView.this.aqq = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aqq);
                    TransparentHeadGridView.this.aqp = i4 == 0;
                    if (TransparentHeadGridView.this.aqr != null) {
                        TransparentHeadGridView.this.aqr.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.jOG != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aqy) {
                        TransparentHeadGridView.this.jOG.ck(height);
                        TransparentHeadGridView.this.aqy = height;
                    }
                }
                if (TransparentHeadGridView.this.aqx != null) {
                    TransparentHeadGridView.this.aqx.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.aqo = 0.0f;
        this.aqp = true;
        this.aqq = -1;
        this.aqy = -1;
        this.aqz = false;
        this.aqA = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aqz) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jOI = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void wk() {
                if (TransparentHeadGridView.this.aqz) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.jOH != null) {
                    TransparentHeadGridView.this.jOH.wl();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.aqx != null) {
                    TransparentHeadGridView.this.aqx.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.jOG != null && TransparentHeadGridView.this.aqy != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.jOG.ck(100);
                        TransparentHeadGridView.this.aqy = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aqq < 0) {
                        TransparentHeadGridView.this.aqq = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aqq);
                    TransparentHeadGridView.this.aqp = i4 == 0;
                    if (TransparentHeadGridView.this.aqr != null) {
                        TransparentHeadGridView.this.aqr.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.jOG != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aqy) {
                        TransparentHeadGridView.this.jOG.ck(height);
                        TransparentHeadGridView.this.aqy = height;
                    }
                }
                if (TransparentHeadGridView.this.aqx != null) {
                    TransparentHeadGridView.this.aqx.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.aqo = 0.0f;
        this.aqp = true;
        this.aqq = -1;
        this.aqy = -1;
        this.aqz = false;
        this.aqA = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aqz) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jOI = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void wk() {
                if (TransparentHeadGridView.this.aqz) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.jOH != null) {
                    TransparentHeadGridView.this.jOH.wl();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.aqx != null) {
                    TransparentHeadGridView.this.aqx.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.jOG != null && TransparentHeadGridView.this.aqy != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.jOG.ck(100);
                        TransparentHeadGridView.this.aqy = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aqq < 0) {
                        TransparentHeadGridView.this.aqq = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aqq);
                    TransparentHeadGridView.this.aqp = i4 == 0;
                    if (TransparentHeadGridView.this.aqr != null) {
                        TransparentHeadGridView.this.aqr.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.jOG != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aqy) {
                        TransparentHeadGridView.this.jOG.ck(height);
                        TransparentHeadGridView.this.aqy = height;
                    }
                }
                if (TransparentHeadGridView.this.aqx != null) {
                    TransparentHeadGridView.this.aqx.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.aqu = (int) (l.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.aqo = 0.0f;
                if (this.aqz && getPaddingTop() > this.aqu) {
                    a(getHeight(), 200L, 0L, this.jOI);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.aqo == 0.0f) {
                    this.aqo = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.aqo && getPaddingTop() == 0 && this.aqp) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.aqo) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.jOH != null && i >= 0 && this.aqu > 0 && i <= this.aqu) {
                        this.jOH.cl((i * 100) / this.aqu);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void wj() {
        setPadding(0, (int) ((10.0f - this.aqo) / 2.0f), 0, 0);
        this.mState = 0;
        this.aqo = 0.0f;
        if (this.aqz && getPaddingTop() > this.aqu) {
            a(getHeight(), 200L, 0L, this.jOI);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aqx = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.aqr = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.jOF != null) {
            this.jOF.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aqs == null) {
                this.aqs = new DecelerateInterpolator();
            }
            this.jOF = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.jOF, j2);
            } else {
                post(this.jOF);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private final int aqD;
        private final int aqE;
        private c jOK;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aqG = true;
        private long mStartTime = -1;
        private int aqH = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aqE = i;
            this.aqD = i2;
            this.mInterpolator = TransparentHeadGridView.this.aqs;
            this.mDuration = j;
            this.jOK = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aqH = this.aqE - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aqE - this.aqD));
                TransparentHeadGridView.this.setPadding(0, this.aqH, 0, 0);
                if (TransparentHeadGridView.this.jOH != null && this.aqH >= 0 && TransparentHeadGridView.this.aqu > 0 && this.aqH <= TransparentHeadGridView.this.aqu) {
                    TransparentHeadGridView.this.jOH.cl((this.aqH * 100) / TransparentHeadGridView.this.aqu);
                }
            }
            if (this.aqG && this.aqD != this.aqH) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.jOK != null) {
                this.jOK.wk();
            }
        }

        public void stop() {
            this.aqG = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.jOG = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.jOH = bVar;
    }
}
