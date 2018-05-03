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
    private Interpolator aUo;
    private Animation.AnimationListener bXD;
    private float gLi;
    private boolean hcF;
    private int hcG;
    private View hcH;
    private d hcI;
    private int hcJ;
    private a hcK;
    private b hcL;
    private AbsListView.OnScrollListener hcM;
    private int hcN;
    private boolean hcO;
    private c hcP;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes3.dex */
    public interface a {
        void uU(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void bBX();

        void uV(int i);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void JD();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.gLi = 0.0f;
        this.hcF = true;
        this.hcG = -1;
        this.hcN = -1;
        this.hcO = false;
        this.bXD = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hcO) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hcP = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void JD() {
                if (TransparentHeadGridView.this.hcO) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hcL != null) {
                    TransparentHeadGridView.this.hcL.bBX();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hcM != null) {
                    TransparentHeadGridView.this.hcM.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hcK != null && TransparentHeadGridView.this.hcN != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hcK.uU(100);
                        TransparentHeadGridView.this.hcN = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hcG < 0) {
                        TransparentHeadGridView.this.hcG = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hcG);
                    TransparentHeadGridView.this.hcF = i4 == 0;
                    if (TransparentHeadGridView.this.hcH != null) {
                        TransparentHeadGridView.this.hcH.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hcK != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hcN) {
                        TransparentHeadGridView.this.hcK.uU(height);
                        TransparentHeadGridView.this.hcN = height;
                    }
                }
                if (TransparentHeadGridView.this.hcM != null) {
                    TransparentHeadGridView.this.hcM.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.gLi = 0.0f;
        this.hcF = true;
        this.hcG = -1;
        this.hcN = -1;
        this.hcO = false;
        this.bXD = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hcO) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hcP = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void JD() {
                if (TransparentHeadGridView.this.hcO) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hcL != null) {
                    TransparentHeadGridView.this.hcL.bBX();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.hcM != null) {
                    TransparentHeadGridView.this.hcM.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hcK != null && TransparentHeadGridView.this.hcN != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hcK.uU(100);
                        TransparentHeadGridView.this.hcN = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hcG < 0) {
                        TransparentHeadGridView.this.hcG = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hcG);
                    TransparentHeadGridView.this.hcF = i4 == 0;
                    if (TransparentHeadGridView.this.hcH != null) {
                        TransparentHeadGridView.this.hcH.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hcK != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hcN) {
                        TransparentHeadGridView.this.hcK.uU(height);
                        TransparentHeadGridView.this.hcN = height;
                    }
                }
                if (TransparentHeadGridView.this.hcM != null) {
                    TransparentHeadGridView.this.hcM.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.gLi = 0.0f;
        this.hcF = true;
        this.hcG = -1;
        this.hcN = -1;
        this.hcO = false;
        this.bXD = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.hcO) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.hcP = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void JD() {
                if (TransparentHeadGridView.this.hcO) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.hcL != null) {
                    TransparentHeadGridView.this.hcL.bBX();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.hcM != null) {
                    TransparentHeadGridView.this.hcM.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.hcK != null && TransparentHeadGridView.this.hcN != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.hcK.uU(100);
                        TransparentHeadGridView.this.hcN = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.hcG < 0) {
                        TransparentHeadGridView.this.hcG = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.hcG);
                    TransparentHeadGridView.this.hcF = i4 == 0;
                    if (TransparentHeadGridView.this.hcH != null) {
                        TransparentHeadGridView.this.hcH.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.hcK != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.hcN) {
                        TransparentHeadGridView.this.hcK.uU(height);
                        TransparentHeadGridView.this.hcN = height;
                    }
                }
                if (TransparentHeadGridView.this.hcM != null) {
                    TransparentHeadGridView.this.hcM.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.hcJ = (int) (l.ah(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.gLi = 0.0f;
                if (this.hcO && getPaddingTop() > this.hcJ) {
                    a(getHeight(), 200L, 0L, this.hcP);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.gLi == 0.0f) {
                    this.gLi = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.gLi && getPaddingTop() == 0 && this.hcF) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.gLi) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.hcL != null && i >= 0 && this.hcJ > 0 && i <= this.hcJ) {
                        this.hcL.uV((i * 100) / this.hcJ);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void bBW() {
        setPadding(0, (int) ((10.0f - this.gLi) / 2.0f), 0, 0);
        this.mState = 0;
        this.gLi = 0.0f;
        if (this.hcO && getPaddingTop() > this.hcJ) {
            a(getHeight(), 200L, 0L, this.hcP);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.hcM = onScrollListener;
    }

    public void setBottomMoveView(View view2) {
        this.hcH = view2;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.hcI != null) {
            this.hcI.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aUo == null) {
                this.aUo = new DecelerateInterpolator();
            }
            this.hcI = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.hcI, j2);
            } else {
                post(this.hcI);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private final int aUB;
        private final int aUC;
        private c hcR;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aUE = true;
        private long mStartTime = -1;
        private int aUF = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aUC = i;
            this.aUB = i2;
            this.mInterpolator = TransparentHeadGridView.this.aUo;
            this.mDuration = j;
            this.hcR = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aUF = this.aUC - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aUC - this.aUB));
                TransparentHeadGridView.this.setPadding(0, this.aUF, 0, 0);
                if (TransparentHeadGridView.this.hcL != null && this.aUF >= 0 && TransparentHeadGridView.this.hcJ > 0 && this.aUF <= TransparentHeadGridView.this.hcJ) {
                    TransparentHeadGridView.this.hcL.uV((this.aUF * 100) / TransparentHeadGridView.this.hcJ);
                }
            }
            if (this.aUE && this.aUB != this.aUF) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.hcR != null) {
                this.hcR.JD();
            }
        }

        public void stop() {
            this.aUE = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.hcK = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.hcL = bVar;
    }
}
