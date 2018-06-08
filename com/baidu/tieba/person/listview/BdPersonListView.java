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
/* loaded from: classes2.dex */
public class BdPersonListView extends BdTypeListView {
    private float LA;
    private final int LB;
    private final int LC;
    private View Lt;
    private float Lv;
    private float Lw;
    private boolean Ly;
    private float Lz;
    private final Scroller fPC;
    private View fPD;
    private b fPE;
    private b fPF;
    public a fPG;
    private boolean fPH;
    private boolean fPI;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.contentInsetLeft, R.attr.contentInsetRight};

    /* loaded from: classes2.dex */
    public interface a {
        void N(float f);

        void nm();

        void onRefresh();
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ly = false;
        this.fPH = true;
        this.fPI = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.fPC = new Scroller(this.mContext);
        this.LB = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.ExpandListView);
        this.LC = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.Lt = view;
    }

    public void setOuterExpandView(View view) {
        this.fPD = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.Lt == null || !this.fPH) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Lw = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Lt.getHeight();
                    this.Lv = this.Lw;
                    this.Lz = this.LA;
                    this.fPE = new b(0, height, 0, this.LC + height);
                    int height2 = this.fPD.getHeight();
                    this.fPF = new b(0, height2, 0, this.LC + height2);
                    break;
                case 1:
                case 3:
                    if (this.Ly) {
                        nk();
                        if (this.fPI) {
                            return true;
                        }
                    } else {
                        this.fPG.nm();
                        break;
                    }
                    break;
                case 2:
                    float f = this.LA - this.Lz;
                    float f2 = this.Lw - this.Lv;
                    this.Lz = this.LA;
                    if (this.Lt.getParent() == this && this.fPE != null && this.Lt.isShown() && this.Lt.getTop() >= 0 && Math.abs(f2) >= this.LB && Math.abs(f) < this.LB) {
                        int O = this.fPE.O(this.Lw - this.Lv);
                        if (O > this.fPE.startY && O <= this.fPE.endY) {
                            this.Ly = true;
                            this.Lt.setLayoutParams(new AbsListView.LayoutParams(this.Lt.getWidth(), O));
                            if (this.fPD != null) {
                                int O2 = this.fPF.O(this.Lw - this.Lv);
                                ViewGroup.LayoutParams layoutParams = this.fPD.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = O2;
                                    this.fPD.setLayoutParams(layoutParams);
                                }
                            }
                            M(O - this.fPE.startY);
                            break;
                        } else if (O <= this.fPE.startY) {
                            this.Ly = false;
                            break;
                        } else if (O > this.fPE.endY) {
                            this.Ly = true;
                            break;
                        } else {
                            this.Ly = false;
                            break;
                        }
                    } else {
                        this.Ly = false;
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
        if (this.Ly) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Ly) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void nk() {
        if (this.fPE != null) {
            if (this.Lt.getHeight() >= this.fPE.endY - (this.LC / 2)) {
                nl();
            } else {
                this.fPG.nm();
            }
            this.mScroller.startScroll(0, this.Lt.getHeight(), 0, this.fPE.startY - this.Lt.getHeight(), 200);
            this.fPC.startScroll(0, this.fPD.getHeight(), 0, this.fPF.startY - this.fPD.getHeight(), 200);
            invalidate();
            this.Ly = false;
        }
    }

    public void nl() {
        if (this.fPG != null) {
            this.fPG.onRefresh();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.fPG = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewGroup.LayoutParams layoutParams;
        if (this.mScroller.computeScrollOffset()) {
            this.Lt.setLayoutParams(new AbsListView.LayoutParams(this.Lt.getWidth(), this.mScroller.getCurrY()));
        } else {
            super.computeScroll();
        }
        if (this.fPC.computeScrollOffset()) {
            int currY = this.fPC.getCurrY();
            if (this.fPD != null && (layoutParams = this.fPD.getLayoutParams()) != null) {
                layoutParams.height = currY;
                this.fPD.setLayoutParams(layoutParams);
            }
        }
    }

    private void M(float f) {
        this.fPG.N(360.0f - ((f * 360.0f) / this.LC));
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
