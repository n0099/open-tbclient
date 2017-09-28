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
    private b gHQ;
    private a gHS;
    private boolean gIc;
    private int gId;
    private View gIe;
    private d gIf;
    private int gIg;
    private Animation gIh;
    private Animation gIi;
    private AbsListView.OnScrollListener gIj;
    private int gIk;
    private c gIl;
    private float guW;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes2.dex */
    public interface a {
        void uS(int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void boN();

        void uT(int i);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void Iw();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.guW = 0.0f;
        this.gIc = true;
        this.gId = -1;
        this.gIk = -1;
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
        this.gIl = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Iw() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gHQ != null) {
                    TransparentHeadGridView.this.gHQ.boN();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.gIj != null) {
                    TransparentHeadGridView.this.gIj.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gHS != null && TransparentHeadGridView.this.gIk != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gHS.uS(100);
                        TransparentHeadGridView.this.gIk = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gId < 0) {
                        TransparentHeadGridView.this.gId = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gId);
                    TransparentHeadGridView.this.gIc = i4 == 0;
                    if (TransparentHeadGridView.this.gIe != null) {
                        TransparentHeadGridView.this.gIe.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gHS != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gIk) {
                        TransparentHeadGridView.this.gHS.uS(height);
                        TransparentHeadGridView.this.gIk = height;
                    }
                }
                if (TransparentHeadGridView.this.gIj != null) {
                    TransparentHeadGridView.this.gIj.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.guW = 0.0f;
        this.gIc = true;
        this.gId = -1;
        this.gIk = -1;
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
        this.gIl = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Iw() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gHQ != null) {
                    TransparentHeadGridView.this.gHQ.boN();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.gIj != null) {
                    TransparentHeadGridView.this.gIj.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gHS != null && TransparentHeadGridView.this.gIk != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gHS.uS(100);
                        TransparentHeadGridView.this.gIk = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gId < 0) {
                        TransparentHeadGridView.this.gId = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gId);
                    TransparentHeadGridView.this.gIc = i4 == 0;
                    if (TransparentHeadGridView.this.gIe != null) {
                        TransparentHeadGridView.this.gIe.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gHS != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gIk) {
                        TransparentHeadGridView.this.gHS.uS(height);
                        TransparentHeadGridView.this.gIk = height;
                    }
                }
                if (TransparentHeadGridView.this.gIj != null) {
                    TransparentHeadGridView.this.gIj.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.guW = 0.0f;
        this.gIc = true;
        this.gId = -1;
        this.gIk = -1;
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
        this.gIl = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void Iw() {
                TransparentHeadGridView.this.setVisibility(8);
                if (TransparentHeadGridView.this.gHQ != null) {
                    TransparentHeadGridView.this.gHQ.boN();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.gIj != null) {
                    TransparentHeadGridView.this.gIj.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.gHS != null && TransparentHeadGridView.this.gIk != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.gHS.uS(100);
                        TransparentHeadGridView.this.gIk = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.gId < 0) {
                        TransparentHeadGridView.this.gId = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.gId);
                    TransparentHeadGridView.this.gIc = i4 == 0;
                    if (TransparentHeadGridView.this.gIe != null) {
                        TransparentHeadGridView.this.gIe.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.gHS != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.gIk) {
                        TransparentHeadGridView.this.gHS.uS(height);
                        TransparentHeadGridView.this.gIk = height;
                    }
                }
                if (TransparentHeadGridView.this.gIj != null) {
                    TransparentHeadGridView.this.gIj.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.gIg = (int) (com.baidu.adp.lib.util.l.af(context) * 0.22f);
    }

    public void bzO() {
        setVisibility(0);
        setPadding(0, 0, 0, 0);
        this.mState = 0;
        if (this.gIh == null) {
            this.gIh = AnimationUtils.loadAnimation(this.mContext, d.a.in_from_bottom);
        }
        startAnimation(this.gIh);
    }

    public void bzP() {
        this.mState = 0;
        if (this.gIi == null) {
            this.gIi = AnimationUtils.loadAnimation(this.mContext, d.a.out_to_bottom);
            this.gIi.setAnimationListener(this.bAm);
        }
        startAnimation(this.gIi);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.guW = 0.0f;
                if (getPaddingTop() > this.gIg) {
                    a(getHeight(), 200L, 0L, this.gIl);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
            case 2:
                if (this.guW == 0.0f) {
                    this.guW = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.guW && getPaddingTop() == 0 && this.gIc) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.guW) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.gHQ != null && i >= 0 && this.gIg > 0 && i <= this.gIg) {
                        this.gHQ.uT((i * 100) / this.gIg);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gIj = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.gIe = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.gIf != null) {
            this.gIf.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.aQw == null) {
                this.aQw = new DecelerateInterpolator();
            }
            this.gIf = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.gIf, j2);
            } else {
                post(this.gIf);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private final int aQL;
        private final int aQM;
        private c gIn;
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
            this.gIn = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aQP = this.aQM - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aQM - this.aQL));
                TransparentHeadGridView.this.setPadding(0, this.aQP, 0, 0);
                if (TransparentHeadGridView.this.gHQ != null && this.aQP >= 0 && TransparentHeadGridView.this.gIg > 0 && this.aQP <= TransparentHeadGridView.this.gIg) {
                    TransparentHeadGridView.this.gHQ.uT((this.aQP * 100) / TransparentHeadGridView.this.gIg);
                }
            }
            if (this.aQO && this.aQL != this.aQP) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.gIn != null) {
                this.gIn.Iw();
            }
        }

        public void stop() {
            this.aQO = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.gHS = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.gHQ = bVar;
    }
}
