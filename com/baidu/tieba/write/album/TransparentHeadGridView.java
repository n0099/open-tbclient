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
    private float aIY;
    private Interpolator cJz;
    private Animation.AnimationListener ecH;
    private boolean jGY;
    private int jGZ;
    private View jHa;
    private d jHb;
    private int jHc;
    private a jHd;
    private b jHe;
    private AbsListView.OnScrollListener jHf;
    private int jHg;
    private boolean jHh;
    private c jHi;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes3.dex */
    public interface a {
        void Cp(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void Cq(int i);

        void cxu();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void axw();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.aIY = 0.0f;
        this.jGY = true;
        this.jGZ = -1;
        this.jHg = -1;
        this.jHh = false;
        this.ecH = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.jHh) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jHi = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void axw() {
                if (TransparentHeadGridView.this.jHh) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.jHe != null) {
                    TransparentHeadGridView.this.jHe.cxu();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.jHf != null) {
                    TransparentHeadGridView.this.jHf.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.jHd != null && TransparentHeadGridView.this.jHg != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.jHd.Cp(100);
                        TransparentHeadGridView.this.jHg = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.jGZ < 0) {
                        TransparentHeadGridView.this.jGZ = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.jGZ);
                    TransparentHeadGridView.this.jGY = i4 == 0;
                    if (TransparentHeadGridView.this.jHa != null) {
                        TransparentHeadGridView.this.jHa.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.jHd != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.jHg) {
                        TransparentHeadGridView.this.jHd.Cp(height);
                        TransparentHeadGridView.this.jHg = height;
                    }
                }
                if (TransparentHeadGridView.this.jHf != null) {
                    TransparentHeadGridView.this.jHf.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.aIY = 0.0f;
        this.jGY = true;
        this.jGZ = -1;
        this.jHg = -1;
        this.jHh = false;
        this.ecH = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.jHh) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jHi = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void axw() {
                if (TransparentHeadGridView.this.jHh) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.jHe != null) {
                    TransparentHeadGridView.this.jHe.cxu();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.jHf != null) {
                    TransparentHeadGridView.this.jHf.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.jHd != null && TransparentHeadGridView.this.jHg != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.jHd.Cp(100);
                        TransparentHeadGridView.this.jHg = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.jGZ < 0) {
                        TransparentHeadGridView.this.jGZ = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.jGZ);
                    TransparentHeadGridView.this.jGY = i4 == 0;
                    if (TransparentHeadGridView.this.jHa != null) {
                        TransparentHeadGridView.this.jHa.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.jHd != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.jHg) {
                        TransparentHeadGridView.this.jHd.Cp(height);
                        TransparentHeadGridView.this.jHg = height;
                    }
                }
                if (TransparentHeadGridView.this.jHf != null) {
                    TransparentHeadGridView.this.jHf.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.aIY = 0.0f;
        this.jGY = true;
        this.jGZ = -1;
        this.jHg = -1;
        this.jHh = false;
        this.ecH = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.jHh) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jHi = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void axw() {
                if (TransparentHeadGridView.this.jHh) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.jHe != null) {
                    TransparentHeadGridView.this.jHe.cxu();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.jHf != null) {
                    TransparentHeadGridView.this.jHf.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.jHd != null && TransparentHeadGridView.this.jHg != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.jHd.Cp(100);
                        TransparentHeadGridView.this.jHg = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.jGZ < 0) {
                        TransparentHeadGridView.this.jGZ = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.jGZ);
                    TransparentHeadGridView.this.jGY = i4 == 0;
                    if (TransparentHeadGridView.this.jHa != null) {
                        TransparentHeadGridView.this.jHa.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.jHd != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.jHg) {
                        TransparentHeadGridView.this.jHd.Cp(height);
                        TransparentHeadGridView.this.jHg = height;
                    }
                }
                if (TransparentHeadGridView.this.jHf != null) {
                    TransparentHeadGridView.this.jHf.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.jHc = (int) (l.ah(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.aIY = 0.0f;
                if (this.jHh && getPaddingTop() > this.jHc) {
                    a(getHeight(), 200L, 0L, this.jHi);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.aIY == 0.0f) {
                    this.aIY = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.aIY && getPaddingTop() == 0 && this.jGY) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.aIY) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.jHe != null && i >= 0 && this.jHc > 0 && i <= this.jHc) {
                        this.jHe.Cq((i * 100) / this.jHc);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void cxt() {
        setPadding(0, (int) ((10.0f - this.aIY) / 2.0f), 0, 0);
        this.mState = 0;
        this.aIY = 0.0f;
        if (this.jHh && getPaddingTop() > this.jHc) {
            a(getHeight(), 200L, 0L, this.jHi);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.jHf = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.jHa = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.jHb != null) {
            this.jHb.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.cJz == null) {
                this.cJz = new DecelerateInterpolator();
            }
            this.jHb = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.jHb, j2);
            } else {
                post(this.jHb);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private final int aLq;
        private final int aLr;
        private c jHk;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aLs = true;
        private long mStartTime = -1;
        private int aLt = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aLr = i;
            this.aLq = i2;
            this.mInterpolator = TransparentHeadGridView.this.cJz;
            this.mDuration = j;
            this.jHk = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aLt = this.aLr - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aLr - this.aLq));
                TransparentHeadGridView.this.setPadding(0, this.aLt, 0, 0);
                if (TransparentHeadGridView.this.jHe != null && this.aLt >= 0 && TransparentHeadGridView.this.jHc > 0 && this.aLt <= TransparentHeadGridView.this.jHc) {
                    TransparentHeadGridView.this.jHe.Cq((this.aLt * 100) / TransparentHeadGridView.this.jHc);
                }
            }
            if (this.aLs && this.aLq != this.aLt) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.jHk != null) {
                this.jHk.axw();
            }
        }

        public void stop() {
            this.aLs = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.jHd = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.jHe = bVar;
    }
}
