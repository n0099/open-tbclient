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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class TransparentHeadGridView extends GridView {
    private Interpolator aMa;
    private float eVI;
    private b fNL;
    private a fNN;
    private boolean fOc;
    private int fOd;
    private View fOe;
    private d fOf;
    private int fOg;
    private Animation fOh;
    private Animation fOi;
    private AbsListView.OnScrollListener fOj;
    private int fOk;
    private c fOl;
    private Animation.AnimationListener mAnimationListener;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes.dex */
    public interface a {
        void sR(int i);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bmI();

        void sS(int i);
    }

    /* loaded from: classes.dex */
    public interface c {
        void Ht();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.eVI = 0.0f;
        this.fOc = true;
        this.fOd = -1;
        this.fOk = -1;
        this.mAnimationListener = new az(this);
        this.fOl = new ba(this);
        this.mOnScrollListener = new bb(this);
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.eVI = 0.0f;
        this.fOc = true;
        this.fOd = -1;
        this.fOk = -1;
        this.mAnimationListener = new az(this);
        this.fOl = new ba(this);
        this.mOnScrollListener = new bb(this);
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.eVI = 0.0f;
        this.fOc = true;
        this.fOd = -1;
        this.fOk = -1;
        this.mAnimationListener = new az(this);
        this.fOl = new ba(this);
        this.mOnScrollListener = new bb(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.fOg = (int) (com.baidu.adp.lib.util.k.ag(context) * 0.22f);
    }

    public void bmM() {
        setVisibility(0);
        setPadding(0, 0, 0, 0);
        this.mState = 0;
        if (this.fOh == null) {
            this.fOh = AnimationUtils.loadAnimation(this.mContext, w.a.in_from_bottom);
        }
        startAnimation(this.fOh);
    }

    public void bmN() {
        this.mState = 0;
        if (this.fOi == null) {
            this.fOi = AnimationUtils.loadAnimation(this.mContext, w.a.out_to_bottom);
            this.fOi.setAnimationListener(this.mAnimationListener);
        }
        startAnimation(this.fOi);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.eVI = 0.0f;
                if (getPaddingTop() > this.fOg) {
                    a(getHeight(), 200L, 0L, this.fOl);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
            case 2:
                if (this.eVI == 0.0f) {
                    this.eVI = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.eVI && getPaddingTop() == 0 && this.fOc) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.eVI) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.fNL != null && i >= 0 && this.fOg > 0 && i <= this.fOg) {
                        this.fNL.sS((i * 100) / this.fOg);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fOj = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.fOe = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.fOf != null) {
            this.fOf.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aMa == null) {
                this.aMa = new DecelerateInterpolator();
            }
            this.fOf = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.fOf, j2);
            } else {
                post(this.fOf);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        private final int aMp;
        private final int aMq;
        private final long aMr;
        private c fOn;
        private final Interpolator mInterpolator;
        private boolean aMt = true;
        private long mStartTime = -1;
        private int aMu = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aMq = i;
            this.aMp = i2;
            this.mInterpolator = TransparentHeadGridView.this.aMa;
            this.aMr = j;
            this.fOn = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aMu = this.aMq - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.aMr, 1000L), 0L)) / 1000.0f) * (this.aMq - this.aMp));
                TransparentHeadGridView.this.setPadding(0, this.aMu, 0, 0);
                if (TransparentHeadGridView.this.fNL != null && this.aMu >= 0 && TransparentHeadGridView.this.fOg > 0 && this.aMu <= TransparentHeadGridView.this.fOg) {
                    TransparentHeadGridView.this.fNL.sS((this.aMu * 100) / TransparentHeadGridView.this.fOg);
                }
            }
            if (this.aMt && this.aMp != this.aMu) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.fOn != null) {
                this.fOn.Ht();
            }
        }

        public void stop() {
            this.aMt = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.fNN = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.fNL = bVar;
    }
}
