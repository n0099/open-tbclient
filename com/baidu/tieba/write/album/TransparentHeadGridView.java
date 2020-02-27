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
/* loaded from: classes13.dex */
public class TransparentHeadGridView extends GridView {
    private float aDc;
    private boolean aDd;
    private int aDe;
    private View aDf;
    private Interpolator aDg;
    private int aDi;
    private AbsListView.OnScrollListener aDl;
    private int aDm;
    private boolean aDn;
    private Animation.AnimationListener aDo;
    private d kNE;
    private a kNF;
    private b kNG;
    private c kNH;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes13.dex */
    public interface a {
        void cT(int i);
    }

    /* loaded from: classes13.dex */
    public interface b {
        void AQ();

        void cU(int i);
    }

    /* loaded from: classes13.dex */
    public interface c {
        void AP();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.aDc = 0.0f;
        this.aDd = true;
        this.aDe = -1;
        this.aDm = -1;
        this.aDn = false;
        this.aDo = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aDn) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kNH = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void AP() {
                if (TransparentHeadGridView.this.aDn) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.kNG != null) {
                    TransparentHeadGridView.this.kNG.AQ();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.aDl != null) {
                    TransparentHeadGridView.this.aDl.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.kNF != null && TransparentHeadGridView.this.aDm != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.kNF.cT(100);
                        TransparentHeadGridView.this.aDm = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aDe < 0) {
                        TransparentHeadGridView.this.aDe = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aDe);
                    TransparentHeadGridView.this.aDd = i4 == 0;
                    if (TransparentHeadGridView.this.aDf != null) {
                        TransparentHeadGridView.this.aDf.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.kNF != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aDm) {
                        TransparentHeadGridView.this.kNF.cT(height);
                        TransparentHeadGridView.this.aDm = height;
                    }
                }
                if (TransparentHeadGridView.this.aDl != null) {
                    TransparentHeadGridView.this.aDl.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.aDc = 0.0f;
        this.aDd = true;
        this.aDe = -1;
        this.aDm = -1;
        this.aDn = false;
        this.aDo = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aDn) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kNH = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void AP() {
                if (TransparentHeadGridView.this.aDn) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.kNG != null) {
                    TransparentHeadGridView.this.kNG.AQ();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.aDl != null) {
                    TransparentHeadGridView.this.aDl.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.kNF != null && TransparentHeadGridView.this.aDm != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.kNF.cT(100);
                        TransparentHeadGridView.this.aDm = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aDe < 0) {
                        TransparentHeadGridView.this.aDe = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aDe);
                    TransparentHeadGridView.this.aDd = i4 == 0;
                    if (TransparentHeadGridView.this.aDf != null) {
                        TransparentHeadGridView.this.aDf.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.kNF != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aDm) {
                        TransparentHeadGridView.this.kNF.cT(height);
                        TransparentHeadGridView.this.aDm = height;
                    }
                }
                if (TransparentHeadGridView.this.aDl != null) {
                    TransparentHeadGridView.this.aDl.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.aDc = 0.0f;
        this.aDd = true;
        this.aDe = -1;
        this.aDm = -1;
        this.aDn = false;
        this.aDo = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aDn) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kNH = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void AP() {
                if (TransparentHeadGridView.this.aDn) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.kNG != null) {
                    TransparentHeadGridView.this.kNG.AQ();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.aDl != null) {
                    TransparentHeadGridView.this.aDl.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.kNF != null && TransparentHeadGridView.this.aDm != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.kNF.cT(100);
                        TransparentHeadGridView.this.aDm = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aDe < 0) {
                        TransparentHeadGridView.this.aDe = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aDe);
                    TransparentHeadGridView.this.aDd = i4 == 0;
                    if (TransparentHeadGridView.this.aDf != null) {
                        TransparentHeadGridView.this.aDf.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.kNF != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aDm) {
                        TransparentHeadGridView.this.kNF.cT(height);
                        TransparentHeadGridView.this.aDm = height;
                    }
                }
                if (TransparentHeadGridView.this.aDl != null) {
                    TransparentHeadGridView.this.aDl.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.aDi = (int) (l.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.aDc = 0.0f;
                if (this.aDn && getPaddingTop() > this.aDi) {
                    a(getHeight(), 200L, 0L, this.kNH);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.aDc == 0.0f) {
                    this.aDc = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.aDc && getPaddingTop() == 0 && this.aDd) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.aDc) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.kNG != null && i >= 0 && this.aDi > 0 && i <= this.aDi) {
                        this.kNG.cU((i * 100) / this.aDi);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void AO() {
        setPadding(0, (int) ((10.0f - this.aDc) / 2.0f), 0, 0);
        this.mState = 0;
        this.aDc = 0.0f;
        if (this.aDn && getPaddingTop() > this.aDi) {
            a(getHeight(), 200L, 0L, this.kNH);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aDl = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.aDf = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.kNE != null) {
            this.kNE.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aDg == null) {
                this.aDg = new DecelerateInterpolator();
            }
            this.kNE = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.kNE, j2);
            } else {
                post(this.kNE);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class d implements Runnable {
        private final int aDr;
        private final int aDs;
        private c kNJ;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aDu = true;
        private long mStartTime = -1;
        private int mCurrentY = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aDs = i;
            this.aDr = i2;
            this.mInterpolator = TransparentHeadGridView.this.aDg;
            this.mDuration = j;
            this.kNJ = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.mCurrentY = this.aDs - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aDs - this.aDr));
                TransparentHeadGridView.this.setPadding(0, this.mCurrentY, 0, 0);
                if (TransparentHeadGridView.this.kNG != null && this.mCurrentY >= 0 && TransparentHeadGridView.this.aDi > 0 && this.mCurrentY <= TransparentHeadGridView.this.aDi) {
                    TransparentHeadGridView.this.kNG.cU((this.mCurrentY * 100) / TransparentHeadGridView.this.aDi);
                }
            }
            if (this.aDu && this.aDr != this.mCurrentY) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.kNJ != null) {
                this.kNJ.AP();
            }
        }

        public void stop() {
            this.aDu = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.kNF = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.kNG = bVar;
    }
}
