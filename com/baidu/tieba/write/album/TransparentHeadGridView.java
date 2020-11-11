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
    private float bFi;
    private boolean bFj;
    private int bFk;
    private View bFl;
    private Interpolator bFm;
    private int bFo;
    private AbsListView.OnScrollListener bFr;
    private int bFs;
    private boolean bFt;
    private Animation.AnimationListener bFu;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;
    private d nGp;
    private a nGq;
    private b nGr;
    private c nGs;

    /* loaded from: classes3.dex */
    public interface a {
        void gb(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void Ul();

        void gc(int i);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void Uk();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.bFi = 0.0f;
        this.bFj = true;
        this.bFk = -1;
        this.bFs = -1;
        this.bFt = false;
        this.bFu = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bFt) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nGs = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Uk() {
                if (TransparentHeadGridView.this.bFt) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.nGr != null) {
                    TransparentHeadGridView.this.nGr.Ul();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bFr != null) {
                    TransparentHeadGridView.this.bFr.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.nGq != null && TransparentHeadGridView.this.bFs != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.nGq.gb(100);
                        TransparentHeadGridView.this.bFs = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bFk < 0) {
                        TransparentHeadGridView.this.bFk = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bFk);
                    TransparentHeadGridView.this.bFj = i4 == 0;
                    if (TransparentHeadGridView.this.bFl != null) {
                        TransparentHeadGridView.this.bFl.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.nGq != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bFs) {
                        TransparentHeadGridView.this.nGq.gb(height);
                        TransparentHeadGridView.this.bFs = height;
                    }
                }
                if (TransparentHeadGridView.this.bFr != null) {
                    TransparentHeadGridView.this.bFr.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.bFi = 0.0f;
        this.bFj = true;
        this.bFk = -1;
        this.bFs = -1;
        this.bFt = false;
        this.bFu = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bFt) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nGs = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Uk() {
                if (TransparentHeadGridView.this.bFt) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.nGr != null) {
                    TransparentHeadGridView.this.nGr.Ul();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.bFr != null) {
                    TransparentHeadGridView.this.bFr.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.nGq != null && TransparentHeadGridView.this.bFs != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.nGq.gb(100);
                        TransparentHeadGridView.this.bFs = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bFk < 0) {
                        TransparentHeadGridView.this.bFk = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bFk);
                    TransparentHeadGridView.this.bFj = i4 == 0;
                    if (TransparentHeadGridView.this.bFl != null) {
                        TransparentHeadGridView.this.bFl.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.nGq != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bFs) {
                        TransparentHeadGridView.this.nGq.gb(height);
                        TransparentHeadGridView.this.bFs = height;
                    }
                }
                if (TransparentHeadGridView.this.bFr != null) {
                    TransparentHeadGridView.this.bFr.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.bFi = 0.0f;
        this.bFj = true;
        this.bFk = -1;
        this.bFs = -1;
        this.bFt = false;
        this.bFu = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.bFt) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.nGs = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Uk() {
                if (TransparentHeadGridView.this.bFt) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.nGr != null) {
                    TransparentHeadGridView.this.nGr.Ul();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.bFr != null) {
                    TransparentHeadGridView.this.bFr.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.nGq != null && TransparentHeadGridView.this.bFs != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.nGq.gb(100);
                        TransparentHeadGridView.this.bFs = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.bFk < 0) {
                        TransparentHeadGridView.this.bFk = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.bFk);
                    TransparentHeadGridView.this.bFj = i4 == 0;
                    if (TransparentHeadGridView.this.bFl != null) {
                        TransparentHeadGridView.this.bFl.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.nGq != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.bFs) {
                        TransparentHeadGridView.this.nGq.gb(height);
                        TransparentHeadGridView.this.bFs = height;
                    }
                }
                if (TransparentHeadGridView.this.bFr != null) {
                    TransparentHeadGridView.this.bFr.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.bFo = (int) (l.getEquipmentHeight(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.bFi = 0.0f;
                if (this.bFt && getPaddingTop() > this.bFo) {
                    a(getHeight(), 200L, 0L, this.nGs);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
            case 2:
                if (this.bFi == 0.0f) {
                    this.bFi = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.bFi && getPaddingTop() == 0 && this.bFj) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.bFi) / 2.0f);
                    if (this.nGr != null && i >= 0 && this.bFo > 0 && i <= this.bFo) {
                        this.nGr.gc((i * 100) / this.bFo);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void Uj() {
        setPadding(0, (int) ((10.0f - this.bFi) / 2.0f), 0, 0);
        this.mState = 0;
        this.bFi = 0.0f;
        if (this.bFt && getPaddingTop() > this.bFo) {
            a(getHeight(), 200L, 0L, this.nGs);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.bFr = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.bFl = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.nGp != null) {
            this.nGp.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.bFm == null) {
                this.bFm = new DecelerateInterpolator();
            }
            this.nGp = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.nGp, j2);
            } else {
                post(this.nGp);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private final int bFx;
        private final int bFy;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private c nGu;
        private boolean bFA = true;
        private long mStartTime = -1;
        private int bFB = -1;

        public d(int i, int i2, long j, c cVar) {
            this.bFy = i;
            this.bFx = i2;
            this.mInterpolator = TransparentHeadGridView.this.bFm;
            this.mDuration = j;
            this.nGu = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.bFB = this.bFy - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.bFy - this.bFx));
                TransparentHeadGridView.this.setPadding(0, this.bFB, 0, 0);
                if (TransparentHeadGridView.this.nGr != null && this.bFB >= 0 && TransparentHeadGridView.this.bFo > 0 && this.bFB <= TransparentHeadGridView.this.bFo) {
                    TransparentHeadGridView.this.nGr.gc((this.bFB * 100) / TransparentHeadGridView.this.bFo);
                }
            }
            if (this.bFA && this.bFx != this.bFB) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.nGu != null) {
                this.nGu.Uk();
            }
        }

        public void stop() {
            this.bFA = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.nGq = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.nGr = bVar;
    }
}
