package com.baidu.tieba.write.album;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.GridView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class TransparentHeadGridView extends GridView {
    private Interpolator aQj;
    private Animation.AnimationListener bAa;
    private b gHA;
    private a gHC;
    private boolean gHM;
    private int gHN;
    private View gHO;
    private d gHP;
    private int gHQ;
    private Animation gHR;
    private Animation gHS;
    private AbsListView.OnScrollListener gHT;
    private int gHU;
    private c gHV;
    private float guH;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes2.dex */
    public interface a {
        void uR(int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void boF();

        void uS(int i);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void Iq();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.guH = 0.0f;
        this.gHM = true;
        this.gHN = -1;
        this.gHU = -1;
        this.bAa = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TransparentHeadGridView.this.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gHV = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Iq() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gHA != null) {
                    TransparentHeadGridView.this.gHA.boF();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.gHT != null) {
                    TransparentHeadGridView.this.gHT.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gHC != null && TransparentHeadGridView.this.gHU != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gHC.uR(100);
                        TransparentHeadGridView.this.gHU = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gHN < 0) {
                        TransparentHeadGridView.this.gHN = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gHN);
                    TransparentHeadGridView.this.gHM = i4 == 0;
                    if (TransparentHeadGridView.this.gHO != null) {
                        TransparentHeadGridView.this.gHO.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gHC != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gHU) {
                        TransparentHeadGridView.this.gHC.uR(height);
                        TransparentHeadGridView.this.gHU = height;
                    }
                }
                if (TransparentHeadGridView.this.gHT != null) {
                    TransparentHeadGridView.this.gHT.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.guH = 0.0f;
        this.gHM = true;
        this.gHN = -1;
        this.gHU = -1;
        this.bAa = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TransparentHeadGridView.this.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gHV = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Iq() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gHA != null) {
                    TransparentHeadGridView.this.gHA.boF();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.gHT != null) {
                    TransparentHeadGridView.this.gHT.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gHC != null && TransparentHeadGridView.this.gHU != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gHC.uR(100);
                        TransparentHeadGridView.this.gHU = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gHN < 0) {
                        TransparentHeadGridView.this.gHN = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gHN);
                    TransparentHeadGridView.this.gHM = i4 == 0;
                    if (TransparentHeadGridView.this.gHO != null) {
                        TransparentHeadGridView.this.gHO.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gHC != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gHU) {
                        TransparentHeadGridView.this.gHC.uR(height);
                        TransparentHeadGridView.this.gHU = height;
                    }
                }
                if (TransparentHeadGridView.this.gHT != null) {
                    TransparentHeadGridView.this.gHT.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.guH = 0.0f;
        this.gHM = true;
        this.gHN = -1;
        this.gHU = -1;
        this.bAa = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TransparentHeadGridView.this.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.gHV = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Iq() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gHA != null) {
                    TransparentHeadGridView.this.gHA.boF();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.gHT != null) {
                    TransparentHeadGridView.this.gHT.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gHC != null && TransparentHeadGridView.this.gHU != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gHC.uR(100);
                        TransparentHeadGridView.this.gHU = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gHN < 0) {
                        TransparentHeadGridView.this.gHN = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gHN);
                    TransparentHeadGridView.this.gHM = i4 == 0;
                    if (TransparentHeadGridView.this.gHO != null) {
                        TransparentHeadGridView.this.gHO.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gHC != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gHU) {
                        TransparentHeadGridView.this.gHC.uR(height);
                        TransparentHeadGridView.this.gHU = height;
                    }
                }
                if (TransparentHeadGridView.this.gHT != null) {
                    TransparentHeadGridView.this.gHT.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.gHQ = (int) (com.baidu.adp.lib.util.l.af(context) * 0.22f);
    }

    public void bzH() {
        setVisibility(0);
        setPadding(0, 0, 0, 0);
        this.mState = 0;
        if (this.gHR == null) {
            this.gHR = AnimationUtils.loadAnimation(this.mContext, d.a.in_from_bottom);
        }
        startAnimation(this.gHR);
    }

    public void bzI() {
        this.mState = 0;
        if (this.gHS == null) {
            this.gHS = AnimationUtils.loadAnimation(this.mContext, d.a.out_to_bottom);
            this.gHS.setAnimationListener(this.bAa);
        }
        startAnimation(this.gHS);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.guH = 0.0f;
                if (getPaddingTop() > this.gHQ) {
                    a(getHeight(), 200L, 0L, this.gHV);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
            case 2:
                if (this.guH == 0.0f) {
                    this.guH = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.guH && getPaddingTop() == 0 && this.gHM) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.guH) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.gHA != null && i >= 0 && this.gHQ > 0 && i <= this.gHQ) {
                        this.gHA.uS((i * 100) / this.gHQ);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gHT = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.gHO = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.gHP != null) {
            this.gHP.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aQj == null) {
                this.aQj = new DecelerateInterpolator();
            }
            this.gHP = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.gHP, j2);
            } else {
                post(this.gHP);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private final int aQy;
        private final int aQz;
        private c gHX;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aQB = true;
        private long mStartTime = -1;
        private int aQC = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aQz = i;
            this.aQy = i2;
            this.mInterpolator = TransparentHeadGridView.this.aQj;
            this.mDuration = j;
            this.gHX = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aQC = this.aQz - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aQz - this.aQy));
                TransparentHeadGridView.this.setPadding(0, this.aQC, 0, 0);
                if (TransparentHeadGridView.this.gHA != null && this.aQC >= 0 && TransparentHeadGridView.this.gHQ > 0 && this.aQC <= TransparentHeadGridView.this.gHQ) {
                    TransparentHeadGridView.this.gHA.uS((this.aQC * 100) / TransparentHeadGridView.this.gHQ);
                }
            }
            if (this.aQB && this.aQy != this.aQC) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.gHX != null) {
                this.gHX.Iq();
            }
        }

        public void stop() {
            this.aQB = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.gHC = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.gHA = bVar;
    }
}
