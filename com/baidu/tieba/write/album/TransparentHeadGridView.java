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
    private float aHe;
    private Interpolator cBp;
    private Animation.AnimationListener dSg;
    private boolean jnR;
    private int jnS;
    private View jnT;
    private d jnU;
    private int jnV;
    private a jnW;
    private b jnX;
    private AbsListView.OnScrollListener jnY;
    private int jnZ;
    private boolean joa;
    private c job;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes3.dex */
    public interface a {
        void Bg(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void Bh(int i);

        void cpo();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void asq();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.aHe = 0.0f;
        this.jnR = true;
        this.jnS = -1;
        this.jnZ = -1;
        this.joa = false;
        this.dSg = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.joa) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.job = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void asq() {
                if (TransparentHeadGridView.this.joa) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.jnX != null) {
                    TransparentHeadGridView.this.jnX.cpo();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.jnY != null) {
                    TransparentHeadGridView.this.jnY.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.jnW != null && TransparentHeadGridView.this.jnZ != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.jnW.Bg(100);
                        TransparentHeadGridView.this.jnZ = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.jnS < 0) {
                        TransparentHeadGridView.this.jnS = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.jnS);
                    TransparentHeadGridView.this.jnR = i4 == 0;
                    if (TransparentHeadGridView.this.jnT != null) {
                        TransparentHeadGridView.this.jnT.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.jnW != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.jnZ) {
                        TransparentHeadGridView.this.jnW.Bg(height);
                        TransparentHeadGridView.this.jnZ = height;
                    }
                }
                if (TransparentHeadGridView.this.jnY != null) {
                    TransparentHeadGridView.this.jnY.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.aHe = 0.0f;
        this.jnR = true;
        this.jnS = -1;
        this.jnZ = -1;
        this.joa = false;
        this.dSg = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.joa) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.job = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void asq() {
                if (TransparentHeadGridView.this.joa) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.jnX != null) {
                    TransparentHeadGridView.this.jnX.cpo();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.jnY != null) {
                    TransparentHeadGridView.this.jnY.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.jnW != null && TransparentHeadGridView.this.jnZ != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.jnW.Bg(100);
                        TransparentHeadGridView.this.jnZ = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.jnS < 0) {
                        TransparentHeadGridView.this.jnS = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.jnS);
                    TransparentHeadGridView.this.jnR = i4 == 0;
                    if (TransparentHeadGridView.this.jnT != null) {
                        TransparentHeadGridView.this.jnT.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.jnW != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.jnZ) {
                        TransparentHeadGridView.this.jnW.Bg(height);
                        TransparentHeadGridView.this.jnZ = height;
                    }
                }
                if (TransparentHeadGridView.this.jnY != null) {
                    TransparentHeadGridView.this.jnY.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.aHe = 0.0f;
        this.jnR = true;
        this.jnS = -1;
        this.jnZ = -1;
        this.joa = false;
        this.dSg = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.joa) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.job = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void asq() {
                if (TransparentHeadGridView.this.joa) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.jnX != null) {
                    TransparentHeadGridView.this.jnX.cpo();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.jnY != null) {
                    TransparentHeadGridView.this.jnY.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.jnW != null && TransparentHeadGridView.this.jnZ != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.jnW.Bg(100);
                        TransparentHeadGridView.this.jnZ = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.jnS < 0) {
                        TransparentHeadGridView.this.jnS = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.jnS);
                    TransparentHeadGridView.this.jnR = i4 == 0;
                    if (TransparentHeadGridView.this.jnT != null) {
                        TransparentHeadGridView.this.jnT.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.jnW != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.jnZ) {
                        TransparentHeadGridView.this.jnW.Bg(height);
                        TransparentHeadGridView.this.jnZ = height;
                    }
                }
                if (TransparentHeadGridView.this.jnY != null) {
                    TransparentHeadGridView.this.jnY.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.jnV = (int) (l.aQ(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.aHe = 0.0f;
                if (this.joa && getPaddingTop() > this.jnV) {
                    a(getHeight(), 200L, 0L, this.job);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.aHe == 0.0f) {
                    this.aHe = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.aHe && getPaddingTop() == 0 && this.jnR) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.aHe) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.jnX != null && i >= 0 && this.jnV > 0 && i <= this.jnV) {
                        this.jnX.Bh((i * 100) / this.jnV);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void cpn() {
        setPadding(0, (int) ((10.0f - this.aHe) / 2.0f), 0, 0);
        this.mState = 0;
        this.aHe = 0.0f;
        if (this.joa && getPaddingTop() > this.jnV) {
            a(getHeight(), 200L, 0L, this.job);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.jnY = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.jnT = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.jnU != null) {
            this.jnU.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.cBp == null) {
                this.cBp = new DecelerateInterpolator();
            }
            this.jnU = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.jnU, j2);
            } else {
                post(this.jnU);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private final int aJw;
        private final int aJx;
        private c jod;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aJy = true;
        private long mStartTime = -1;
        private int aJz = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aJx = i;
            this.aJw = i2;
            this.mInterpolator = TransparentHeadGridView.this.cBp;
            this.mDuration = j;
            this.jod = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aJz = this.aJx - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aJx - this.aJw));
                TransparentHeadGridView.this.setPadding(0, this.aJz, 0, 0);
                if (TransparentHeadGridView.this.jnX != null && this.aJz >= 0 && TransparentHeadGridView.this.jnV > 0 && this.aJz <= TransparentHeadGridView.this.jnV) {
                    TransparentHeadGridView.this.jnX.Bh((this.aJz * 100) / TransparentHeadGridView.this.jnV);
                }
            }
            if (this.aJy && this.aJw != this.aJz) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.jod != null) {
                this.jod.asq();
            }
        }

        public void stop() {
            this.aJy = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.jnW = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.jnX = bVar;
    }
}
