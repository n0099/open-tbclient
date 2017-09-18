package com.baidu.tieba.person.listview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.Scroller;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.R;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class BdPersonListView extends BdTypeListView {
    private View Ha;
    private float Hc;
    private float Hd;
    private boolean Hf;
    private float Hg;
    private float Hh;
    private final int Hi;
    private final int Hj;
    private b ffH;
    public a ffI;
    private boolean ffJ;
    private boolean ffK;
    private final Context mContext;
    private final Scroller mScroller;
    public static int ExpandListView_expandDistance = 1;
    public static final int[] ExpandListView = {R.attr.bl_arrowWidth, R.attr.bl_cornersRadius};

    /* loaded from: classes.dex */
    public interface a {
        void kZ();

        void la();

        void v(float f);
    }

    public BdPersonListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hf = false;
        this.ffJ = true;
        this.ffK = false;
        this.mContext = context;
        this.mScroller = new Scroller(this.mContext);
        this.Hi = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.ExpandListView);
        this.Hj = obtainStyledAttributes.getDimensionPixelSize(ExpandListView_expandDistance, 0);
        obtainStyledAttributes.recycle();
    }

    public void setExpandView(View view) {
        this.Ha = view;
    }

    public void setIsNeedExpand(boolean z) {
        this.ffJ = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.Ha == null || !this.ffJ) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (this.mScroller.isFinished()) {
            this.Hd = motionEvent.getY();
            switch (action) {
                case 0:
                    int height = this.Ha.getHeight();
                    this.Hc = this.Hd;
                    this.Hg = this.Hh;
                    this.ffH = new b(0, height, 0, this.Hj + height);
                    break;
                case 1:
                case 3:
                    if (this.Hf) {
                        kX();
                        if (this.ffK) {
                            return true;
                        }
                    } else {
                        this.ffI.kZ();
                        break;
                    }
                    break;
                case 2:
                    float f = this.Hh - this.Hg;
                    float f2 = this.Hd - this.Hc;
                    this.Hg = this.Hh;
                    if (this.Ha.getParent() == this && this.ffH != null && this.Ha.isShown() && this.Ha.getTop() >= 0 && Math.abs(f2) >= this.Hi && Math.abs(f) < this.Hi) {
                        int w = this.ffH.w(this.Hd - this.Hc);
                        if (w > this.ffH.Hn && w <= this.ffH.Hp) {
                            this.Hf = true;
                            this.Ha.setLayoutParams(new AbsListView.LayoutParams(this.Ha.getWidth(), w));
                            u(w - this.ffH.Hn);
                            break;
                        } else if (w <= this.ffH.Hn) {
                            this.Hf = false;
                            break;
                        } else if (w > this.ffH.Hp) {
                            this.Hf = true;
                            break;
                        } else {
                            this.Hf = false;
                            break;
                        }
                    } else {
                        this.Hf = false;
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
        if (this.Hf) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Hf) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void kX() {
        if (this.ffH != null) {
            if (this.Ha.getHeight() >= this.ffH.Hp - (this.Hj / 2)) {
                kY();
            } else {
                this.ffI.kZ();
            }
            this.mScroller.startScroll(0, this.Ha.getHeight(), 0, this.ffH.Hn - this.Ha.getHeight(), 200);
            invalidate();
            this.Hf = false;
        }
    }

    public void kY() {
        if (this.ffI != null) {
            this.ffI.la();
        }
    }

    public void setPersonListRefreshListener(a aVar) {
        this.ffI = aVar;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.Ha.setLayoutParams(new AbsListView.LayoutParams(this.Ha.getWidth(), this.mScroller.getCurrY()));
            return;
        }
        super.computeScroll();
    }

    private void u(float f) {
        this.ffI.v(360.0f - ((f * 360.0f) / this.Hj));
    }

    /* loaded from: classes.dex */
    public static class b {
        public int Hm;
        public int Hn;
        public int Ho;
        public int Hp;

        public b(int i, int i2, int i3, int i4) {
            this.Hm = i;
            this.Hn = i2;
            this.Ho = i3;
            this.Hp = i4;
        }

        public int w(float f) {
            return (int) (this.Hn + (f / 2.5f));
        }
    }
}
