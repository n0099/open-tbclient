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
    private Interpolator aLX;
    private boolean fVJ;
    private int fVK;
    private View fVL;
    private d fVM;
    private int fVN;
    private Animation fVO;
    private Animation fVP;
    private AbsListView.OnScrollListener fVQ;
    private int fVR;
    private c fVS;
    private b fVs;
    private a fVu;
    private float feD;
    private Animation.AnimationListener mAnimationListener;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes.dex */
    public interface a {
        void tm(int i);
    }

    /* loaded from: classes.dex */
    public interface b {
        void bof();

        void tn(int i);
    }

    /* loaded from: classes.dex */
    public interface c {
        void Ho();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.feD = 0.0f;
        this.fVJ = true;
        this.fVK = -1;
        this.fVR = -1;
        this.mAnimationListener = new az(this);
        this.fVS = new ba(this);
        this.mOnScrollListener = new bb(this);
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.feD = 0.0f;
        this.fVJ = true;
        this.fVK = -1;
        this.fVR = -1;
        this.mAnimationListener = new az(this);
        this.fVS = new ba(this);
        this.mOnScrollListener = new bb(this);
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.feD = 0.0f;
        this.fVJ = true;
        this.fVK = -1;
        this.fVR = -1;
        this.mAnimationListener = new az(this);
        this.fVS = new ba(this);
        this.mOnScrollListener = new bb(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.fVN = (int) (com.baidu.adp.lib.util.k.ag(context) * 0.22f);
    }

    public void boj() {
        setVisibility(0);
        setPadding(0, 0, 0, 0);
        this.mState = 0;
        if (this.fVO == null) {
            this.fVO = AnimationUtils.loadAnimation(this.mContext, w.a.in_from_bottom);
        }
        startAnimation(this.fVO);
    }

    public void bok() {
        this.mState = 0;
        if (this.fVP == null) {
            this.fVP = AnimationUtils.loadAnimation(this.mContext, w.a.out_to_bottom);
            this.fVP.setAnimationListener(this.mAnimationListener);
        }
        startAnimation(this.fVP);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.feD = 0.0f;
                if (getPaddingTop() > this.fVN) {
                    a(getHeight(), 200L, 0L, this.fVS);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
            case 2:
                if (this.feD == 0.0f) {
                    this.feD = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.feD && getPaddingTop() == 0 && this.fVJ) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.feD) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.fVs != null && i >= 0 && this.fVN > 0 && i <= this.fVN) {
                        this.fVs.tn((i * 100) / this.fVN);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fVQ = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.fVL = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.fVM != null) {
            this.fVM.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aLX == null) {
                this.aLX = new DecelerateInterpolator();
            }
            this.fVM = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.fVM, j2);
            } else {
                post(this.fVM);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        private final int aMm;
        private final int aMn;
        private final long aMo;
        private c fVU;
        private final Interpolator mInterpolator;
        private boolean aMq = true;
        private long mStartTime = -1;
        private int aMr = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aMn = i;
            this.aMm = i2;
            this.mInterpolator = TransparentHeadGridView.this.aLX;
            this.aMo = j;
            this.fVU = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aMr = this.aMn - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.aMo, 1000L), 0L)) / 1000.0f) * (this.aMn - this.aMm));
                TransparentHeadGridView.this.setPadding(0, this.aMr, 0, 0);
                if (TransparentHeadGridView.this.fVs != null && this.aMr >= 0 && TransparentHeadGridView.this.fVN > 0 && this.aMr <= TransparentHeadGridView.this.fVN) {
                    TransparentHeadGridView.this.fVs.tn((this.aMr * 100) / TransparentHeadGridView.this.fVN);
                }
            }
            if (this.aMq && this.aMm != this.aMr) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.fVU != null) {
                this.fVU.Ho();
            }
        }

        public void stop() {
            this.aMq = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.fVu = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.fVs = bVar;
    }
}
