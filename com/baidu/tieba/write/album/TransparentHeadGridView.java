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
    private float aKe;
    private Interpolator cLQ;
    private Animation.AnimationListener eiU;
    private boolean jRD;
    private int jRE;
    private View jRF;
    private d jRG;
    private int jRH;
    private a jRI;
    private b jRJ;
    private AbsListView.OnScrollListener jRK;
    private int jRL;
    private boolean jRM;
    private c jRN;
    private Context mContext;
    private AbsListView.OnScrollListener mOnScrollListener;
    private int mState;

    /* loaded from: classes3.dex */
    public interface a {
        void Dc(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void Dd(int i);

        void cBE();
    }

    /* loaded from: classes3.dex */
    public interface c {
        void ayW();
    }

    public TransparentHeadGridView(Context context) {
        super(context);
        this.mState = 0;
        this.aKe = 0.0f;
        this.jRD = true;
        this.jRE = -1;
        this.jRL = -1;
        this.jRM = false;
        this.eiU = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.jRM) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jRN = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void ayW() {
                if (TransparentHeadGridView.this.jRM) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.jRJ != null) {
                    TransparentHeadGridView.this.jRJ.cBE();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.jRK != null) {
                    TransparentHeadGridView.this.jRK.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.jRI != null && TransparentHeadGridView.this.jRL != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.jRI.Dc(100);
                        TransparentHeadGridView.this.jRL = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.jRE < 0) {
                        TransparentHeadGridView.this.jRE = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.jRE);
                    TransparentHeadGridView.this.jRD = i4 == 0;
                    if (TransparentHeadGridView.this.jRF != null) {
                        TransparentHeadGridView.this.jRF.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.jRI != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.jRL) {
                        TransparentHeadGridView.this.jRI.Dc(height);
                        TransparentHeadGridView.this.jRL = height;
                    }
                }
                if (TransparentHeadGridView.this.jRK != null) {
                    TransparentHeadGridView.this.jRK.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 0;
        this.aKe = 0.0f;
        this.jRD = true;
        this.jRE = -1;
        this.jRL = -1;
        this.jRM = false;
        this.eiU = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.jRM) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jRN = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void ayW() {
                if (TransparentHeadGridView.this.jRM) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.jRJ != null) {
                    TransparentHeadGridView.this.jRJ.cBE();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (TransparentHeadGridView.this.jRK != null) {
                    TransparentHeadGridView.this.jRK.onScrollStateChanged(absListView, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int height;
                if (i != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.jRI != null && TransparentHeadGridView.this.jRL != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.jRI.Dc(100);
                        TransparentHeadGridView.this.jRL = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.jRE < 0) {
                        TransparentHeadGridView.this.jRE = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.jRE);
                    TransparentHeadGridView.this.jRD = i4 == 0;
                    if (TransparentHeadGridView.this.jRF != null) {
                        TransparentHeadGridView.this.jRF.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.jRI != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.jRL) {
                        TransparentHeadGridView.this.jRI.Dc(height);
                        TransparentHeadGridView.this.jRL = height;
                    }
                }
                if (TransparentHeadGridView.this.jRK != null) {
                    TransparentHeadGridView.this.jRK.onScroll(absListView, i, i2, i3);
                }
            }
        };
        init(context);
    }

    public TransparentHeadGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = 0;
        this.aKe = 0.0f;
        this.jRD = true;
        this.jRE = -1;
        this.jRL = -1;
        this.jRM = false;
        this.eiU = new Animation.AnimationListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (TransparentHeadGridView.this.jRM) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        this.jRN = new c() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.2
            @Override // com.baidu.tieba.write.album.TransparentHeadGridView.c
            public void ayW() {
                if (TransparentHeadGridView.this.jRM) {
                    TransparentHeadGridView.this.setVisibility(8);
                }
                if (TransparentHeadGridView.this.jRJ != null) {
                    TransparentHeadGridView.this.jRJ.cBE();
                }
            }
        };
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.write.album.TransparentHeadGridView.3
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                if (TransparentHeadGridView.this.jRK != null) {
                    TransparentHeadGridView.this.jRK.onScrollStateChanged(absListView, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                int height;
                if (i2 != 0 || absListView == null || absListView.getChildAt(0) == null || absListView.getPaddingTop() != 0) {
                    if (TransparentHeadGridView.this.jRI != null && TransparentHeadGridView.this.jRL != 100 && TransparentHeadGridView.this.getPaddingTop() == 0) {
                        TransparentHeadGridView.this.jRI.Dc(100);
                        TransparentHeadGridView.this.jRL = 100;
                    }
                } else {
                    View childAt = absListView.getChildAt(0);
                    if (TransparentHeadGridView.this.jRE < 0) {
                        TransparentHeadGridView.this.jRE = childAt.getTop();
                    }
                    int i4 = -(childAt.getTop() - TransparentHeadGridView.this.jRE);
                    TransparentHeadGridView.this.jRD = i4 == 0;
                    if (TransparentHeadGridView.this.jRF != null) {
                        TransparentHeadGridView.this.jRF.scrollTo(0, i4);
                    }
                    if (TransparentHeadGridView.this.jRI != null && childAt.getHeight() != 0 && TransparentHeadGridView.this.getPaddingTop() == 0 && (height = (((int) (-childAt.getY())) * 100) / childAt.getHeight()) != TransparentHeadGridView.this.jRL) {
                        TransparentHeadGridView.this.jRI.Dc(height);
                        TransparentHeadGridView.this.jRL = height;
                    }
                }
                if (TransparentHeadGridView.this.jRK != null) {
                    TransparentHeadGridView.this.jRK.onScroll(absListView, i2, i22, i3);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOnScrollListener(this.mOnScrollListener);
        this.jRH = (int) (l.ah(context) * 0.22f);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                this.mState = 0;
                this.aKe = 0.0f;
                if (this.jRM && getPaddingTop() > this.jRH) {
                    a(getHeight(), 200L, 0L, this.jRN);
                    break;
                } else {
                    a(0, 200L, 0L, null);
                    break;
                }
                break;
            case 2:
                if (this.aKe == 0.0f) {
                    this.aKe = motionEvent.getY();
                }
                float y = motionEvent.getY();
                if (y > this.aKe && getPaddingTop() == 0 && this.jRD) {
                    this.mState = 1;
                }
                if (this.mState == 1) {
                    int i = (int) ((y - this.aKe) / 2.0f);
                    setPadding(0, i, 0, 0);
                    if (this.jRJ != null && i >= 0 && this.jRH > 0 && i <= this.jRH) {
                        this.jRJ.Dd((i * 100) / this.jRH);
                        break;
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void cBD() {
        setPadding(0, (int) ((10.0f - this.aKe) / 2.0f), 0, 0);
        this.mState = 0;
        this.aKe = 0.0f;
        if (this.jRM && getPaddingTop() > this.jRH) {
            a(getHeight(), 200L, 0L, this.jRN);
        } else {
            a(0, 200L, 0L, null);
        }
    }

    public void setOuterOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.jRK = onScrollListener;
    }

    public void setBottomMoveView(View view) {
        this.jRF = view;
    }

    private void a(int i, long j, long j2, c cVar) {
        if (this.jRG != null) {
            this.jRG.stop();
        }
        int paddingTop = getPaddingTop();
        if (paddingTop != i) {
            if (this.cLQ == null) {
                this.cLQ = new DecelerateInterpolator();
            }
            this.jRG = new d(paddingTop, i, j, cVar);
            if (j2 > 0) {
                postDelayed(this.jRG, j2);
            } else {
                post(this.jRG);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        private final int aMw;
        private final int aMx;
        private c jRP;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private boolean aMy = true;
        private long mStartTime = -1;
        private int aMz = -1;

        public d(int i, int i2, long j, c cVar) {
            this.aMx = i;
            this.aMw = i2;
            this.mInterpolator = TransparentHeadGridView.this.cLQ;
            this.mDuration = j;
            this.jRP = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                this.aMz = this.aMx - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000L), 0L)) / 1000.0f) * (this.aMx - this.aMw));
                TransparentHeadGridView.this.setPadding(0, this.aMz, 0, 0);
                if (TransparentHeadGridView.this.jRJ != null && this.aMz >= 0 && TransparentHeadGridView.this.jRH > 0 && this.aMz <= TransparentHeadGridView.this.jRH) {
                    TransparentHeadGridView.this.jRJ.Dd((this.aMz * 100) / TransparentHeadGridView.this.jRH);
                }
            }
            if (this.aMy && this.aMw != this.aMz) {
                TransparentHeadGridView.this.postDelayed(this, 16L);
            } else if (this.jRP != null) {
                this.jRP.ayW();
            }
        }

        public void stop() {
            this.aMy = false;
            TransparentHeadGridView.this.removeCallbacks(this);
        }
    }

    public void setOnHeadDisplayChangeListener(a aVar) {
        this.jRI = aVar;
    }

    public void setOnPullChangeListener(b bVar) {
        this.jRJ = bVar;
    }
}
