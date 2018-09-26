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
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class BdPersonListView extends BdTypeListView {
    private View NU;
    private float NW;
    private float NX;
    private boolean NZ;
    private float Oa;
    private float Ob;
    private final int Oc;
    private final int Od;
    private final Scroller gaZ;
    private View gba;
    private b gbb;
    private b gbc;
    public a gbd;
    private boolean gbe;
    private boolean gbf;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.expandActivityOverflowButtonDrawable, R.attr.adpMode};

    /* loaded from: classes2.dex */
    public interface a {
        void N(float f);

        void onRefresh();

        void ou();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NZ = false;
        this.gbe = true;
        this.gbf = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.gaZ = new Scroller(this.mContext);
        this.Oc = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.ExpandListView);
        this.Od = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.NU = view;
    }

    public void setOuterExpandView(View view) {
        this.gba = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.NU == null || !this.gbe) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.NX = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.NU.getHeight();
                    this.NW = this.NX;
                    this.Oa = this.Ob;
                    this.gbb = new b(0, height, 0, this.Od + height);
                    int height2 = this.gba.getHeight();
                    this.gbc = new b(0, height2, 0, this.Od + height2);
                    break;
                case 1:
                case 3:
                    if (this.NZ) {
                        os();
                        if (this.gbf) {
                            return true;
                        }
                    } else {
                        this.gbd.ou();
                        break;
                    }
                    break;
                case 2:
                    float f = this.Ob - this.Oa;
                    float f2 = this.NX - this.NW;
                    this.Oa = this.Ob;
                    if (this.NU.getParent() == this && this.gbb != null && this.NU.isShown() && this.NU.getTop() >= 0 && Math.abs(f2) >= this.Oc && Math.abs(f) < this.Oc) {
                        int O = this.gbb.O(this.NX - this.NW);
                        if (O > this.gbb.startY && O <= this.gbb.endY) {
                            this.NZ = true;
                            this.NU.setLayoutParams(new AbsListView.LayoutParams(this.NU.getWidth(), O));
                            if (this.gba != null) {
                                int O2 = this.gbc.O(this.NX - this.NW);
                                ViewGroup.LayoutParams layoutParams = this.gba.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = O2;
                                    this.gba.setLayoutParams(layoutParams);
                                }
                            }
                            M(O - this.gbb.startY);
                            break;
                        } else if (O <= this.gbb.startY) {
                            this.NZ = false;
                            break;
                        } else if (O > this.gbb.endY) {
                            this.NZ = true;
                            break;
                        } else {
                            this.NZ = false;
                            break;
                        }
                    } else {
                        this.NZ = false;
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
        if (this.NZ) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.NZ) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void os() {
        if (this.gbb != null) {
            if (this.NU.getHeight() >= this.gbb.endY - (this.Od / 2)) {
                ot();
            } else {
                this.gbd.ou();
            }
            this.mScroller.startScroll(0, this.NU.getHeight(), 0, this.gbb.startY - this.NU.getHeight(), 200);
            this.gaZ.startScroll(0, this.gba.getHeight(), 0, this.gbc.startY - this.gba.getHeight(), 200);
            invalidate();
            this.NZ = false;
        }
    }

    public void ot() {
        if (this.gbd != null) {
            this.gbd.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.gbd = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.NU.setLayoutParams(new AbsListView.LayoutParams(this.NU.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.gaZ.computeScrollOffset()) {
            int currY = this.gaZ.getCurrY();
            if (this.gba != null && (layoutParams = this.gba.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.gba.setLayoutParams(layoutParams);
            }
        }
    }

    private void M(float f) {
        this.gbd.N(360.0f - ((f * 360.0f) / this.Od));
    }

    /* loaded from: classes2.dex */
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

        public int O(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
