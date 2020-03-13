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
    private float aDe;
    private boolean aDf;
    private int aDg;
    private View aDh;
    private Interpolator aDi;
    private int aDk;
    private AbsListView.OnScrollListener aDn;
    private int aDo;
    private boolean aDp;
    private Animation.AnimationListener aDq;
    private d kNS;
    private a kNT;
    private b kNU;
    private c kNV;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes13.dex */
    public interface a {
        void cT(int i);
    }

    /* loaded from: classes13.dex */
    public interface b {
        void AS();

        void cU(int i);
    }

    /* loaded from: classes13.dex */
    public interface c {
        void AR();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.aDe = 0.0f;
        this.aDf = true;
        this.aDg = -1;
        this.aDo = -1;
        this.aDp = false;
        this.aDq = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aDp) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kNV = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void AR() {
                if (TransparentHeadGridView.this.aDp) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.kNU != null) {
                    TransparentHeadGridView.this.kNU.AS();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.aDn != null) {
                    TransparentHeadGridView.this.aDn.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.kNT != null && TransparentHeadGridView.this.aDo != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.kNT.cT(100);
                        TransparentHeadGridView.this.aDo = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aDg < 0) {
                        TransparentHeadGridView.this.aDg = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aDg);
                    TransparentHeadGridView.this.aDf = i4 == 0;
                    if (TransparentHeadGridView.this.aDh != null) {
                        TransparentHeadGridView.this.aDh.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.kNT != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aDo) {
                        TransparentHeadGridView.this.kNT.cT(height);
                        TransparentHeadGridView.this.aDo = height;
                    }
                }
                if (TransparentHeadGridView.this.aDn != null) {
                    TransparentHeadGridView.this.aDn.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.aDe = 0.0f;
        this.aDf = true;
        this.aDg = -1;
        this.aDo = -1;
        this.aDp = false;
        this.aDq = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aDp) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kNV = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void AR() {
                if (TransparentHeadGridView.this.aDp) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.kNU != null) {
                    TransparentHeadGridView.this.kNU.AS();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.aDn != null) {
                    TransparentHeadGridView.this.aDn.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.kNT != null && TransparentHeadGridView.this.aDo != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.kNT.cT(100);
                        TransparentHeadGridView.this.aDo = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aDg < 0) {
                        TransparentHeadGridView.this.aDg = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aDg);
                    TransparentHeadGridView.this.aDf = i4 == 0;
                    if (TransparentHeadGridView.this.aDh != null) {
                        TransparentHeadGridView.this.aDh.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.kNT != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aDo) {
                        TransparentHeadGridView.this.kNT.cT(height);
                        TransparentHeadGridView.this.aDo = height;
                    }
                }
                if (TransparentHeadGridView.this.aDn != null) {
                    TransparentHeadGridView.this.aDn.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.aDe = 0.0f;
        this.aDf = true;
        this.aDg = -1;
        this.aDo = -1;
        this.aDp = false;
        this.aDq = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.aDp) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.kNV = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void AR() {
                if (TransparentHeadGridView.this.aDp) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.kNU != null) {
                    TransparentHeadGridView.this.kNU.AS();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.aDn != null) {
                    TransparentHeadGridView.this.aDn.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.kNT != null && TransparentHeadGridView.this.aDo != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.kNT.cT(100);
                        TransparentHeadGridView.this.aDo = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.aDg < 0) {
                        TransparentHeadGridView.this.aDg = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.aDg);
                    TransparentHeadGridView.this.aDf = i4 == 0;
                    if (TransparentHeadGridView.this.aDh != null) {
                        TransparentHeadGridView.this.aDh.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.kNT != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.aDo) {
                        TransparentHeadGridView.this.kNT.cT(height);
                        TransparentHeadGridView.this.aDo = height;
                    }
                }
                if (TransparentHeadGridView.this.aDn != null) {
                    TransparentHeadGridView.this.aDn.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.aDk = (int) (l.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.aDe = 0.0f;
                if (this.aDp && getPaddingTop() > this.aDk) {
                    a(getHeight(), 200L, 0L, this.kNV);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.aDe == 0.0f) {
                    this.aDe = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.aDe && getPaddingTop() == 0 && this.aDf) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.aDe) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.kNU != null && i >= 0 && this.aDk > 0 && i <= this.aDk) {
                        this.kNU.cU((i * 100) / this.aDk);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void AQ() {
        setPadding(0, (int) ((10.0f - this.aDe) / 2.0f), 0, 0);
        this.mState = 0;
        this.aDe = 0.0f;
        if (this.aDp && getPaddingTop() > this.aDk) {
            a(getHeight(), 200L, 0L, this.kNV);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.aDn = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.aDh = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.kNS != null) {
            this.kNS.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aDi == null) {
                this.aDi = new DecelerateInterpolator();
            }
            this.kNS = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.kNS, j2);
            } else {
                post(this.kNS);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class d implements Runnable {
        private final int aDt;
        private final int aDu;
        private c kNX;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aDw = true;
        private long mStartTime = -1;
        private int mCurrentY = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aDu = i;
            this.aDt = i2;
            this.mInterpolator = TransparentHeadGridView.this.aDi;
            this.mDuration = j;
            this.kNX = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.mCurrentY = this.aDu - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aDu - this.aDt));
                TransparentHeadGridView.this.setPadding(0, this.mCurrentY, 0, 0);
                if (TransparentHeadGridView.this.kNU != null && this.mCurrentY >= 0 && TransparentHeadGridView.this.aDk > 0 && this.mCurrentY <= TransparentHeadGridView.this.aDk) {
                    TransparentHeadGridView.this.kNU.cU((this.mCurrentY * 100) / TransparentHeadGridView.this.aDk);
                }
            }
            if (this.aDw && this.aDt != this.mCurrentY) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.kNX != null) {
                this.kNX.AR();
            }
        }

        public void stop() {
            this.aDw = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.kNT = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.kNU = bVar;
    }
}
