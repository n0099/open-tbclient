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
    private View GO;
    private float GQ;
    private float GR;
    private boolean GU;
    private float GV;
    private float GW;
    private final int GX;
    private final int GY;
    private final Scroller fsh;
    private View fsi;
    private b fsj;
    private b fsk;
    public a fsl;
    private boolean fsm;
    private boolean fsn;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.bl_arrowWidth, R.attr.bl_cornersRadius};

    /* loaded from: classes.dex */
    public interface a {
        void kV();

        void kW();

        void v(float f);
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GU = false;
        this.fsm = true;
        this.fsn = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.fsh = new Scroller(this.mContext);
        this.GX = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.ExpandListView);
        this.GY = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.GO = view;
    }

    public void setOuterExpandView(View view) {
        this.fsi = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.GO == null || !this.fsm) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.GR = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.GO.getHeight();
                    this.GQ = this.GR;
                    this.GV = this.GW;
                    this.fsj = new b(0, height, 0, this.GY + height);
                    int height2 = this.fsi.getHeight();
                    this.fsk = new b(0, height2, 0, this.GY + height2);
                    break;
                case 1:
                case 3:
                    if (this.GU) {
                        kT();
                        if (this.fsn) {
                            return true;
                        }
                    } else {
                        this.fsl.kV();
                        break;
                    }
                    break;
                case 2:
                    float f = this.GW - this.GV;
                    float f2 = this.GR - this.GQ;
                    this.GV = this.GW;
                    if (this.GO.getParent() == this && this.fsj != null && this.GO.isShown() && this.GO.getTop() >= 0 && Math.abs(f2) >= this.GX && Math.abs(f) < this.GX) {
                        int w = this.fsj.w(this.GR - this.GQ);
                        if (w > this.fsj.startY && w <= this.fsj.Hb) {
                            this.GU = true;
                            this.GO.setLayoutParams(new AbsListView.LayoutParams(this.GO.getWidth(), w));
                            if (this.fsi != null) {
                                int w2 = this.fsk.w(this.GR - this.GQ);
                                ViewGroup.LayoutParams layoutParams = this.fsi.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = w2;
                                    this.fsi.setLayoutParams(layoutParams);
                                }
                            }
                            u(w - this.fsj.startY);
                            break;
                        } else if (w <= this.fsj.startY) {
                            this.GU = false;
                            break;
                        } else if (w > this.fsj.Hb) {
                            this.GU = true;
                            break;
                        } else {
                            this.GU = false;
                            break;
                        }
                    } else {
                        this.GU = false;
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
        if (this.GU) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.GU) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void kT() {
        if (this.fsj != null) {
            if (this.GO.getHeight() >= this.fsj.Hb - (this.GY / 2)) {
                kU();
            } else {
                this.fsl.kV();
            }
            this.mScroller.startScroll(0, this.GO.getHeight(), 0, this.fsj.startY - this.GO.getHeight(), 200);
            this.fsh.startScroll(0, this.fsi.getHeight(), 0, this.fsk.startY - this.fsi.getHeight(), 200);
            invalidate();
            this.GU = false;
        }
    }

    public void kU() {
        if (this.fsl != null) {
            this.fsl.kW();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.fsl = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.GO.setLayoutParams(new AbsListView.LayoutParams(this.GO.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.fsh.computeScrollOffset()) {
            int currY = this.fsh.getCurrY();
            if (this.fsi != null && (layoutParams = this.fsi.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.fsi.setLayoutParams(layoutParams);
            }
        }
    }

    private void u(float f) {
        this.fsl.v(360.0f - ((f * 360.0f) / this.GY));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Hb;
        public int endX;
        public int startX;
        public int startY;

        public b(int i, int i2, int i3, int i4) {
            this.startX = i;
            this.startY = i2;
            this.endX = i3;
            this.Hb = i4;
        }

        public int w(float f) {
            return (int) (this.startY + (f / 2.5f));
        }
    }
}
