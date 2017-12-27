package com.baidu.tieba.person.listview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Scroller;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.R;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class BdPersonListView extends BdTypeListView {
    private View auP;
    private float auR;
    private float auS;
    private boolean auU;
    private float auV;
    private float auW;
    private final int auX;
    private final int auY;
    private final Scroller geZ;
    private View gfa;
    private b gfb;
    private b gfc;
    public a gfd;
    private boolean gfe;
    private boolean gff;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.expandActivityOverflowButtonDrawable, R.attr.adpMode};

    /* loaded from: classes.dex */
    public interface a {
        void L(float f);

        void onRefresh();

        void st();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.auU = false;
        this.gfe = true;
        this.gff = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.geZ = new Scroller(this.mContext);
        this.auX = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandListView);
        this.auY = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.auP = view;
    }

    public void setOuterExpandView(View view) {
        this.gfa = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.auP == null || !this.gfe) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.auS = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.auP.getHeight();
                    this.auR = this.auS;
                    this.auV = this.auW;
                    this.gfb = new b(0, height, 0, this.auY + height);
                    int height2 = this.gfa.getHeight();
                    this.gfc = new b(0, height2, 0, this.auY + height2);
                    break;
                case 1:
                case 3:
                    if (this.auU) {
                        sr();
                        if (this.gff) {
                            return true;
                        }
                    } else {
                        this.gfd.st();
                        break;
                    }
                    break;
                case 2:
                    float f = this.auW - this.auV;
                    float f2 = this.auS - this.auR;
                    this.auV = this.auW;
                    if (this.auP.getParent() == this && this.gfb != null && this.auP.isShown() && this.auP.getTop() >= 0 && Math.abs(f2) >= this.auX && Math.abs(f) < this.auX) {
                        int M = this.gfb.M(this.auS - this.auR);
                        if (M > this.gfb.startY && M <= this.gfb.endY) {
                            this.auU = true;
                            this.auP.setLayoutParams(new AbsListView.LayoutParams(this.auP.getWidth(), M));
                            if (this.gfa != null) {
                                int M2 = this.gfc.M(this.auS - this.auR);
                                ViewGroup.LayoutParams layoutParams = this.gfa.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = M2;
                                    this.gfa.setLayoutParams(layoutParams);
                                }
                            }
                            K(M - this.gfb.startY);
                            break;
                        } else if (M <= this.gfb.startY) {
                            this.auU = false;
                            break;
                        } else if (M > this.gfb.endY) {
                            this.auU = true;
                            break;
                        } else {
                            this.auU = false;
                            break;
                        }
                    } else {
                        this.auU = false;
                        break;
                    }
                    break;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.auU) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.auU) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void sr() {
        if (this.gfb != null) {
            if (this.auP.getHeight() >= this.gfb.endY - (this.auY / 2)) {
                ss();
            } else {
                this.gfd.st();
            }
            this.mScroller.startScroll(0, this.auP.getHeight(), 0, this.gfb.startY - this.auP.getHeight(), 200);
            this.geZ.startScroll(0, this.gfa.getHeight(), 0, this.gfc.startY - this.gfa.getHeight(), 200);
            invalidate();
            this.auU = false;
        }
    }

    public void ss() {
        if (this.gfd != null) {
            this.gfd.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.gfd = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.auP.setLayoutParams(new AbsListView.LayoutParams(this.auP.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.geZ.computeScrollOffset()) {
            int currY = this.geZ.getCurrY();
            if (this.gfa != null && (layoutParams = this.gfa.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.gfa.setLayoutParams(layoutParams);
            }
        }
    }

    private void K(float f) {
        this.gfd.L(360.0f - ((f * 360.0f) / this.auY));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int endX;
        public int endY;
        public int startX;
        public int startY;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.endX = i3;
            this.endY = i4;
        }

        public int M(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
