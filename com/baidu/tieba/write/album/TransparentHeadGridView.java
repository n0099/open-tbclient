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
    private Interpolator aNn;
    private float foT;
    private Animation ggA;
    private AbsListView.OnScrollListener ggB;
    private int ggC;
    private c ggD;
    private b ggd;
    private a ggf;
    private boolean ggu;
    private int ggv;
    private View ggw;
    private d ggx;
    private int ggy;
    private Animation ggz;
    private Animation.AnimationListener mAnimationListener;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes.dex */
    public interface a {
        void tH(int i);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bsC();

        void tI(int i);
    }

    /* loaded from: classes.dex */
    public interface c {
        void HL();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.foT = 0.0f;
        this.ggu = true;
        this.ggv = -1;
        this.ggC = -1;
        this.mAnimationListener = new az(this);
        this.ggD = new ba(this);
        this.mOnScrollListener = new bb(this);
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.foT = 0.0f;
        this.ggu = true;
        this.ggv = -1;
        this.ggC = -1;
        this.mAnimationListener = new az(this);
        this.ggD = new ba(this);
        this.mOnScrollListener = new bb(this);
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.foT = 0.0f;
        this.ggu = true;
        this.ggv = -1;
        this.ggC = -1;
        this.mAnimationListener = new az(this);
        this.ggD = new ba(this);
        this.mOnScrollListener = new bb(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.ggy = (int) (com.baidu.adp.lib.util.k.ag(context) * 0.22f);
    }

    public void bsG() {
        setVisibility(0);
        setPadding(0, 0, 0, 0);
        this.mState = 0;
        if (this.ggz == null) {
            this.ggz = AnimationUtils.loadAnimation(this.mContext, w.a.in_from_bottom);
        }
        startAnimation(this.ggz);
    }

    public void bsH() {
        this.mState = 0;
        if (this.ggA == null) {
            this.ggA = AnimationUtils.loadAnimation(this.mContext, w.a.out_to_bottom);
            this.ggA.setAnimationListener(this.mAnimationListener);
        }
        startAnimation(this.ggA);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.foT = 0.0f;
                if (getPaddingTop() > this.ggy) {
                    a(getHeight(), 200L, 0L, this.ggD);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
            case 2:
                if (this.foT == 0.0f) {
                    this.foT = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.foT && getPaddingTop() == 0 && this.ggu) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.foT) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.ggd != null && i >= 0 && this.ggy > 0 && i <= this.ggy) {
                        this.ggd.tI((i * 100) / this.ggy);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.ggB = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.ggw = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.ggx != null) {
            this.ggx.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aNn == null) {
                this.aNn = new DecelerateInterpolator();
            }
            this.ggx = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.ggx, j2);
            } else {
                post(this.ggx);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        private final int aNC;
        private final int aND;
        private final long aNE;
        private c ggF;
        private final Interpolator mInterpolator;
        private boolean aNG = true;
        private long mStartTime = -1;
        private int aNH = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aND = i;
            this.aNC = i2;
            this.mInterpolator = TransparentHeadGridView.this.aNn;
            this.aNE = j;
            this.ggF = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aNH = this.aND - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.aNE, 1000L), 0L)) / 1000.0f) * (this.aND - this.aNC));
                TransparentHeadGridView.this.setPadding(0, this.aNH, 0, 0);
                if (TransparentHeadGridView.this.ggd != null && this.aNH >= 0 && TransparentHeadGridView.this.ggy > 0 && this.aNH <= TransparentHeadGridView.this.ggy) {
                    TransparentHeadGridView.this.ggd.tI((this.aNH * 100) / TransparentHeadGridView.this.ggy);
                }
            }
            if (this.aNG && this.aNC != this.aNH) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.ggF != null) {
                this.ggF.HL();
            }
        }

        public void stop() {
            this.aNG = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.ggf = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.ggd = bVar;
    }
}
