package com.baidu.yuyinala.privatemessage.session.view.smrlistview;

import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.widget.ScrollerCompat;
/* loaded from: classes11.dex */
public class SMLayout extends FrameLayout {
    private View mContentView;
    private GestureDetectorCompat mGestureDetector;
    private int pfk;
    private SMView pfl;
    private int pfm;
    private GestureDetector.OnGestureListener pfn;
    private boolean pfo;
    private int pfp;
    private int pfq;
    private ScrollerCompat pfr;
    private ScrollerCompat pfs;
    private int pft;
    private Interpolator pfu;
    private Interpolator pfv;
    private int position;
    private int state;

    public SMLayout(View view, SMView sMView, Interpolator interpolator, Interpolator interpolator2) {
        super(view.getContext());
        this.state = 0;
        this.pfp = wT(15);
        this.pfq = -wT(500);
        this.pfu = interpolator;
        this.pfv = interpolator2;
        this.mContentView = view;
        this.pfl = sMView;
        this.pfl.setLayout(this);
        init();
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
        this.pfl.setPosition(i);
    }

    public void setSwipeDirection(int i) {
        this.pfk = i;
    }

    private void init() {
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        this.pfn = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMLayout.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                SMLayout.this.pfo = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > SMLayout.this.pfp && f < SMLayout.this.pfq) {
                    SMLayout.this.pfo = true;
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
        };
        this.mGestureDetector = new GestureDetectorCompat(getContext(), this.pfn);
        if (this.pfu != null) {
            this.pfs = ScrollerCompat.create(getContext(), this.pfu);
        } else {
            this.pfs = ScrollerCompat.create(getContext());
        }
        if (this.pfv != null) {
            this.pfr = ScrollerCompat.create(getContext(), this.pfv);
        } else {
            this.pfr = ScrollerCompat.create(getContext());
        }
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        if (this.mContentView.getId() < 1) {
            this.mContentView.setId(1);
        }
        this.pfl.setId(2);
        this.pfl.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(this.mContentView);
        addView(this.pfl);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public boolean at(MotionEvent motionEvent) {
        this.mGestureDetector.onTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.pfm = (int) motionEvent.getX();
                this.pfo = false;
                break;
            case 1:
                if ((this.pfo || Math.abs(this.pfm - motionEvent.getX()) > this.pfl.getWidth() / 2) && Math.signum(this.pfm - motionEvent.getX()) == this.pfk) {
                    eoD();
                    break;
                } else {
                    eoC();
                    return false;
                }
            case 2:
                int x = (int) (this.pfm - motionEvent.getX());
                if (this.state == 1) {
                    x += this.pfl.getWidth() * this.pfk;
                }
                Px(x);
                break;
        }
        return true;
    }

    public boolean isOpen() {
        return this.state == 1;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    private void Px(int i) {
        if (Math.signum(i) != this.pfk) {
            i = 0;
        } else if (Math.abs(i) > this.pfl.getWidth()) {
            i = this.pfl.getWidth() * this.pfk;
        }
        this.mContentView.layout(-i, this.mContentView.getTop(), this.mContentView.getWidth() - i, getMeasuredHeight());
        if (this.pfk == 1) {
            this.pfl.layout(this.mContentView.getWidth() - i, this.pfl.getTop(), (this.mContentView.getWidth() + this.pfl.getWidth()) - i, this.pfl.getBottom());
        } else {
            this.pfl.layout((-this.pfl.getWidth()) - i, this.pfl.getTop(), -i, this.pfl.getBottom());
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.state == 1) {
            if (this.pfr.computeScrollOffset()) {
                Px(this.pfr.getCurrX() * this.pfk);
                postInvalidate();
            }
        } else if (this.pfs.computeScrollOffset()) {
            Px((this.pft - this.pfs.getCurrX()) * this.pfk);
            postInvalidate();
        }
    }

    public void eoC() {
        this.state = 0;
        if (this.pfk == 1) {
            this.pft = -this.mContentView.getLeft();
            this.pfs.startScroll(0, 0, this.pfl.getWidth(), 0, 350);
        } else {
            this.pft = this.pfl.getRight();
            this.pfs.startScroll(0, 0, this.pfl.getWidth(), 0, 350);
        }
        postInvalidate();
    }

    public void eoD() {
        this.state = 1;
        if (this.pfk == 1) {
            this.pfr.startScroll(-this.mContentView.getLeft(), 0, this.pfl.getWidth(), 0, 350);
        } else {
            this.pfr.startScroll(this.mContentView.getLeft(), 0, this.pfl.getWidth(), 0, 350);
        }
        postInvalidate();
    }

    public void eoE() {
        if (this.pfs.computeScrollOffset()) {
            this.pfs.abortAnimation();
        }
        if (this.state == 1) {
            this.state = 0;
            Px(0);
        }
    }

    public View getContentView() {
        return this.mContentView;
    }

    public SMView getMenuView() {
        return this.pfl;
    }

    private int wT(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.pfl.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mContentView.layout(0, 0, getMeasuredWidth(), this.mContentView.getMeasuredHeight());
        if (this.pfk == 1) {
            this.pfl.layout(getMeasuredWidth(), 0, getMeasuredWidth() + this.pfl.getMeasuredWidth(), this.mContentView.getMeasuredHeight());
        } else {
            this.pfl.layout(-this.pfl.getMeasuredWidth(), 0, 0, this.mContentView.getMeasuredHeight());
        }
    }

    public void setMenuHeight(int i) {
        Log.i("byz", "pos = " + this.position + ", height = " + i);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.pfl.getLayoutParams();
        if (layoutParams.height != i) {
            layoutParams.height = i;
            this.pfl.setLayoutParams(this.pfl.getLayoutParams());
        }
    }
}
