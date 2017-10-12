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
    private Interpolator aQw;
    private Animation.AnimationListener bAm;
    private b gHP;
    private a gHR;
    private boolean gIb;
    private int gIc;
    private View gId;
    private d gIe;
    private int gIf;
    private Animation gIg;
    private Animation gIh;
    private AbsListView.OnScrollListener gIi;
    private int gIj;
    private c gIk;
    private float guV;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes2.dex */
    public interface a {
        void uS(int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void boM();

        void uT(int i);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void Iw();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.guV = 0.0f;
        this.gIb = true;
        this.gIc = -1;
        this.gIj = -1;
        this.bAm = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
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
        this.gIk = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Iw() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gHP != null) {
                    TransparentHeadGridView.this.gHP.boM();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.gIi != null) {
                    TransparentHeadGridView.this.gIi.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gHR != null && TransparentHeadGridView.this.gIj != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gHR.uS(100);
                        TransparentHeadGridView.this.gIj = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gIc < 0) {
                        TransparentHeadGridView.this.gIc = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gIc);
                    TransparentHeadGridView.this.gIb = i4 == 0;
                    if (TransparentHeadGridView.this.gId != null) {
                        TransparentHeadGridView.this.gId.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gHR != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gIj) {
                        TransparentHeadGridView.this.gHR.uS(height);
                        TransparentHeadGridView.this.gIj = height;
                    }
                }
                if (TransparentHeadGridView.this.gIi != null) {
                    TransparentHeadGridView.this.gIi.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.guV = 0.0f;
        this.gIb = true;
        this.gIc = -1;
        this.gIj = -1;
        this.bAm = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
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
        this.gIk = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Iw() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gHP != null) {
                    TransparentHeadGridView.this.gHP.boM();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.gIi != null) {
                    TransparentHeadGridView.this.gIi.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gHR != null && TransparentHeadGridView.this.gIj != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gHR.uS(100);
                        TransparentHeadGridView.this.gIj = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gIc < 0) {
                        TransparentHeadGridView.this.gIc = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gIc);
                    TransparentHeadGridView.this.gIb = i4 == 0;
                    if (TransparentHeadGridView.this.gId != null) {
                        TransparentHeadGridView.this.gId.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gHR != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gIj) {
                        TransparentHeadGridView.this.gHR.uS(height);
                        TransparentHeadGridView.this.gIj = height;
                    }
                }
                if (TransparentHeadGridView.this.gIi != null) {
                    TransparentHeadGridView.this.gIi.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.guV = 0.0f;
        this.gIb = true;
        this.gIc = -1;
        this.gIj = -1;
        this.bAm = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
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
        this.gIk = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Iw() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gHP != null) {
                    TransparentHeadGridView.this.gHP.boM();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.gIi != null) {
                    TransparentHeadGridView.this.gIi.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gHR != null && TransparentHeadGridView.this.gIj != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gHR.uS(100);
                        TransparentHeadGridView.this.gIj = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gIc < 0) {
                        TransparentHeadGridView.this.gIc = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gIc);
                    TransparentHeadGridView.this.gIb = i4 == 0;
                    if (TransparentHeadGridView.this.gId != null) {
                        TransparentHeadGridView.this.gId.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gHR != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gIj) {
                        TransparentHeadGridView.this.gHR.uS(height);
                        TransparentHeadGridView.this.gIj = height;
                    }
                }
                if (TransparentHeadGridView.this.gIi != null) {
                    TransparentHeadGridView.this.gIi.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.gIf = (int) (com.baidu.adp.lib.util.l.af(context) * 0.22f);
    }

    public void bzN() {
        setVisibility(0);
        setPadding(0, 0, 0, 0);
        this.mState = 0;
        if (this.gIg == null) {
            this.gIg = AnimationUtils.loadAnimation(this.mContext, d.a.in_from_bottom);
        }
        startAnimation(this.gIg);
    }

    public void bzO() {
        this.mState = 0;
        if (this.gIh == null) {
            this.gIh = AnimationUtils.loadAnimation(this.mContext, d.a.out_to_bottom);
            this.gIh.setAnimationListener(this.bAm);
        }
        startAnimation(this.gIh);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.guV = 0.0f;
                if (getPaddingTop() > this.gIf) {
                    a(getHeight(), 200L, 0L, this.gIk);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
            case 2:
                if (this.guV == 0.0f) {
                    this.guV = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.guV && getPaddingTop() == 0 && this.gIb) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.guV) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.gHP != null && i >= 0 && this.gIf > 0 && i <= this.gIf) {
                        this.gHP.uT((i * 100) / this.gIf);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gIi = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.gId = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.gIe != null) {
            this.gIe.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aQw == null) {
                this.aQw = new DecelerateInterpolator();
            }
            this.gIe = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.gIe, j2);
            } else {
                post(this.gIe);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private final int aQL;
        private final int aQM;
        private c gIm;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aQO = true;
        private long mStartTime = -1;
        private int aQP = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aQM = i;
            this.aQL = i2;
            this.mInterpolator = TransparentHeadGridView.this.aQw;
            this.mDuration = j;
            this.gIm = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aQP = this.aQM - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aQM - this.aQL));
                TransparentHeadGridView.this.setPadding(0, this.aQP, 0, 0);
                if (TransparentHeadGridView.this.gHP != null && this.aQP >= 0 && TransparentHeadGridView.this.gIf > 0 && this.aQP <= TransparentHeadGridView.this.gIf) {
                    TransparentHeadGridView.this.gHP.uT((this.aQP * 100) / TransparentHeadGridView.this.gIf);
                }
            }
            if (this.aQO && this.aQL != this.aQP) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.gIm != null) {
                this.gIm.Iw();
            }
        }

        public void stop() {
            this.aQO = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.gHR = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.gHP = bVar;
    }
}
