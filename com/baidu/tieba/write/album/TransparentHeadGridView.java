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
    private float aHb;
    private Interpolator cBn;
    private Animation.AnimationListener dSP;
    private boolean jod;
    private int joe;
    private View jof;
    private d jog;
    private int joh;
    private a joi;
    private b joj;
    private AbsListView.OnScrollListener jok;
    private int jol;
    private boolean jom;
    private c jon;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes3.dex */
    public interface a {
        void Bk(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void Bl(int i);

        void cpq();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void ast();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.aHb = 0.0f;
        this.jod = true;
        this.joe = -1;
        this.jol = -1;
        this.jom = false;
        this.dSP = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.jom) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jon = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void ast() {
                if (TransparentHeadGridView.this.jom) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.joj != null) {
                    TransparentHeadGridView.this.joj.cpq();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.jok != null) {
                    TransparentHeadGridView.this.jok.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.joi != null && TransparentHeadGridView.this.jol != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.joi.Bk(100);
                        TransparentHeadGridView.this.jol = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.joe < 0) {
                        TransparentHeadGridView.this.joe = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.joe);
                    TransparentHeadGridView.this.jod = i4 == 0;
                    if (TransparentHeadGridView.this.jof != null) {
                        TransparentHeadGridView.this.jof.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.joi != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.jol) {
                        TransparentHeadGridView.this.joi.Bk(height);
                        TransparentHeadGridView.this.jol = height;
                    }
                }
                if (TransparentHeadGridView.this.jok != null) {
                    TransparentHeadGridView.this.jok.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.aHb = 0.0f;
        this.jod = true;
        this.joe = -1;
        this.jol = -1;
        this.jom = false;
        this.dSP = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.jom) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jon = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void ast() {
                if (TransparentHeadGridView.this.jom) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.joj != null) {
                    TransparentHeadGridView.this.joj.cpq();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.jok != null) {
                    TransparentHeadGridView.this.jok.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.joi != null && TransparentHeadGridView.this.jol != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.joi.Bk(100);
                        TransparentHeadGridView.this.jol = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.joe < 0) {
                        TransparentHeadGridView.this.joe = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.joe);
                    TransparentHeadGridView.this.jod = i4 == 0;
                    if (TransparentHeadGridView.this.jof != null) {
                        TransparentHeadGridView.this.jof.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.joi != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.jol) {
                        TransparentHeadGridView.this.joi.Bk(height);
                        TransparentHeadGridView.this.jol = height;
                    }
                }
                if (TransparentHeadGridView.this.jok != null) {
                    TransparentHeadGridView.this.jok.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.aHb = 0.0f;
        this.jod = true;
        this.joe = -1;
        this.jol = -1;
        this.jom = false;
        this.dSP = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.jom) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jon = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void ast() {
                if (TransparentHeadGridView.this.jom) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.joj != null) {
                    TransparentHeadGridView.this.joj.cpq();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.jok != null) {
                    TransparentHeadGridView.this.jok.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.joi != null && TransparentHeadGridView.this.jol != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.joi.Bk(100);
                        TransparentHeadGridView.this.jol = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.joe < 0) {
                        TransparentHeadGridView.this.joe = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.joe);
                    TransparentHeadGridView.this.jod = i4 == 0;
                    if (TransparentHeadGridView.this.jof != null) {
                        TransparentHeadGridView.this.jof.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.joi != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.jol) {
                        TransparentHeadGridView.this.joi.Bk(height);
                        TransparentHeadGridView.this.jol = height;
                    }
                }
                if (TransparentHeadGridView.this.jok != null) {
                    TransparentHeadGridView.this.jok.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.joh = (int) (l.aQ(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.aHb = 0.0f;
                if (this.jom && getPaddingTop() > this.joh) {
                    a(getHeight(), 200L, 0L, this.jon);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.aHb == 0.0f) {
                    this.aHb = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.aHb && getPaddingTop() == 0 && this.jod) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.aHb) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.joj != null && i >= 0 && this.joh > 0 && i <= this.joh) {
                        this.joj.Bl((i * 100) / this.joh);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void cpp() {
        setPadding(0, (int) ((10.0f - this.aHb) / 2.0f), 0, 0);
        this.mState = 0;
        this.aHb = 0.0f;
        if (this.jom && getPaddingTop() > this.joh) {
            a(getHeight(), 200L, 0L, this.jon);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.jok = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.jof = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.jog != null) {
            this.jog.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.cBn == null) {
                this.cBn = new DecelerateInterpolator();
            }
            this.jog = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.jog, j2);
            } else {
                post(this.jog);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private final int aJt;
        private final int aJu;
        private c jop;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aJv = true;
        private long mStartTime = -1;
        private int aJw = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aJu = i;
            this.aJt = i2;
            this.mInterpolator = TransparentHeadGridView.this.cBn;
            this.mDuration = j;
            this.jop = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aJw = this.aJu - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aJu - this.aJt));
                TransparentHeadGridView.this.setPadding(0, this.aJw, 0, 0);
                if (TransparentHeadGridView.this.joj != null && this.aJw >= 0 && TransparentHeadGridView.this.joh > 0 && this.aJw <= TransparentHeadGridView.this.joh) {
                    TransparentHeadGridView.this.joj.Bl((this.aJw * 100) / TransparentHeadGridView.this.joh);
                }
            }
            if (this.aJv && this.aJt != this.aJw) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.jop != null) {
                this.jop.ast();
            }
        }

        public void stop() {
            this.aJv = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.joi = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.joj = bVar;
    }
}
