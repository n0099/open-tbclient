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
/* loaded from: classes2.dex */
public class TransparentHeadGridView extends GridView {
    private Interpolator bJw;
    private Animation.AnimationListener cHz;
    private boolean hGd;
    private int hGe;
    private View hGf;
    private d hGg;
    private int hGh;
    private a hGi;
    private b hGj;
    private AbsListView.OnScrollListener hGk;
    private int hGl;
    private boolean hGm;
    private c hGn;
    private float hpB;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes2.dex */
    public interface a {
        void xq(int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void bGK();

        void xr(int i);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void Rb();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.hpB = 0.0f;
        this.hGd = true;
        this.hGe = -1;
        this.hGl = -1;
        this.hGm = false;
        this.cHz = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hGm) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hGn = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Rb() {
                if (TransparentHeadGridView.this.hGm) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hGj != null) {
                    TransparentHeadGridView.this.hGj.bGK();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hGk != null) {
                    TransparentHeadGridView.this.hGk.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hGi != null && TransparentHeadGridView.this.hGl != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hGi.xq(100);
                        TransparentHeadGridView.this.hGl = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hGe < 0) {
                        TransparentHeadGridView.this.hGe = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hGe);
                    TransparentHeadGridView.this.hGd = i4 == 0;
                    if (TransparentHeadGridView.this.hGf != null) {
                        TransparentHeadGridView.this.hGf.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hGi != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hGl) {
                        TransparentHeadGridView.this.hGi.xq(height);
                        TransparentHeadGridView.this.hGl = height;
                    }
                }
                if (TransparentHeadGridView.this.hGk != null) {
                    TransparentHeadGridView.this.hGk.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.hpB = 0.0f;
        this.hGd = true;
        this.hGe = -1;
        this.hGl = -1;
        this.hGm = false;
        this.cHz = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hGm) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hGn = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Rb() {
                if (TransparentHeadGridView.this.hGm) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hGj != null) {
                    TransparentHeadGridView.this.hGj.bGK();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hGk != null) {
                    TransparentHeadGridView.this.hGk.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hGi != null && TransparentHeadGridView.this.hGl != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hGi.xq(100);
                        TransparentHeadGridView.this.hGl = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hGe < 0) {
                        TransparentHeadGridView.this.hGe = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hGe);
                    TransparentHeadGridView.this.hGd = i4 == 0;
                    if (TransparentHeadGridView.this.hGf != null) {
                        TransparentHeadGridView.this.hGf.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hGi != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hGl) {
                        TransparentHeadGridView.this.hGi.xq(height);
                        TransparentHeadGridView.this.hGl = height;
                    }
                }
                if (TransparentHeadGridView.this.hGk != null) {
                    TransparentHeadGridView.this.hGk.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.hpB = 0.0f;
        this.hGd = true;
        this.hGe = -1;
        this.hGl = -1;
        this.hGm = false;
        this.cHz = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hGm) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hGn = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Rb() {
                if (TransparentHeadGridView.this.hGm) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hGj != null) {
                    TransparentHeadGridView.this.hGj.bGK();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.hGk != null) {
                    TransparentHeadGridView.this.hGk.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hGi != null && TransparentHeadGridView.this.hGl != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hGi.xq(100);
                        TransparentHeadGridView.this.hGl = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hGe < 0) {
                        TransparentHeadGridView.this.hGe = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hGe);
                    TransparentHeadGridView.this.hGd = i4 == 0;
                    if (TransparentHeadGridView.this.hGf != null) {
                        TransparentHeadGridView.this.hGf.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hGi != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hGl) {
                        TransparentHeadGridView.this.hGi.xq(height);
                        TransparentHeadGridView.this.hGl = height;
                    }
                }
                if (TransparentHeadGridView.this.hGk != null) {
                    TransparentHeadGridView.this.hGk.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.hGh = (int) (com.baidu.adp.lib.util.l.aq(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.hpB = 0.0f;
                if (this.hGm && getPaddingTop() > this.hGh) {
                    a(getHeight(), 200L, 0L, this.hGn);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.hpB == 0.0f) {
                    this.hpB = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.hpB && getPaddingTop() == 0 && this.hGd) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.hpB) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.hGj != null && i >= 0 && this.hGh > 0 && i <= this.hGh) {
                        this.hGj.xr((i * 100) / this.hGh);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void bGJ() {
        setPadding(0, (int) ((10.0f - this.hpB) / 2.0f), 0, 0);
        this.mState = 0;
        this.hpB = 0.0f;
        if (this.hGm && getPaddingTop() > this.hGh) {
            a(getHeight(), 200L, 0L, this.hGn);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hGk = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.hGf = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.hGg != null) {
            this.hGg.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bJw == null) {
                this.bJw = new DecelerateInterpolator();
            }
            this.hGg = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.hGg, j2);
            } else {
                post(this.hGg);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private final int bJL;
        private final int bJM;
        private c hGp;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean bJO = true;
        private long mStartTime = -1;
        private int bJP = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bJM = i;
            this.bJL = i2;
            this.mInterpolator = TransparentHeadGridView.this.bJw;
            this.mDuration = j;
            this.hGp = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bJP = this.bJM - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bJM - this.bJL));
                TransparentHeadGridView.this.setPadding(0, this.bJP, 0, 0);
                if (TransparentHeadGridView.this.hGj != null && this.bJP >= 0 && TransparentHeadGridView.this.hGh > 0 && this.bJP <= TransparentHeadGridView.this.hGh) {
                    TransparentHeadGridView.this.hGj.xr((this.bJP * 100) / TransparentHeadGridView.this.hGh);
                }
            }
            if (this.bJO && this.bJL != this.bJP) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.hGp != null) {
                this.hGp.Rb();
            }
        }

        public void stop() {
            this.bJO = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.hGi = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.hGj = bVar;
    }
}
