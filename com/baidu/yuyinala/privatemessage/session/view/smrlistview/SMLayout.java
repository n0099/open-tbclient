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
/* loaded from: classes10.dex */
public class SMLayout extends FrameLayout {
    private View mContentView;
    private GestureDetectorCompat mGestureDetector;
    private int paH;
    private SMView paI;
    private int paJ;
    private GestureDetector.OnGestureListener paK;
    private boolean paL;
    private int paM;
    private int paN;
    private ScrollerCompat paO;
    private ScrollerCompat paP;
    private int paQ;
    private Interpolator paR;
    private Interpolator paS;
    private int position;
    private int state;

    public SMLayout(View view, SMView sMView, Interpolator interpolator, Interpolator interpolator2) {
        super(view.getContext());
        this.state = 0;
        this.paM = vn(15);
        this.paN = -vn(500);
        this.paR = interpolator;
        this.paS = interpolator2;
        this.mContentView = view;
        this.paI = sMView;
        this.paI.setLayout(this);
        init();
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
        this.paI.setPosition(i);
    }

    public void setSwipeDirection(int i) {
        this.paH = i;
    }

    private void init() {
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        this.paK = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMLayout.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                SMLayout.this.paL = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > SMLayout.this.paM && f < SMLayout.this.paN) {
                    SMLayout.this.paL = true;
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
        };
        this.mGestureDetector = new GestureDetectorCompat(getContext(), this.paK);
        if (this.paR != null) {
            this.paP = ScrollerCompat.create(getContext(), this.paR);
        } else {
            this.paP = ScrollerCompat.create(getContext());
        }
        if (this.paS != null) {
            this.paO = ScrollerCompat.create(getContext(), this.paS);
        } else {
            this.paO = ScrollerCompat.create(getContext());
        }
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        if (this.mContentView.getId() < 1) {
            this.mContentView.setId(1);
        }
        this.paI.setId(2);
        this.paI.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(this.mContentView);
        addView(this.paI);
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
                this.paJ = (int) motionEvent.getX();
                this.paL = false;
                break;
            case 1:
                if ((this.paL || Math.abs(this.paJ - motionEvent.getX()) > this.paI.getWidth() / 2) && Math.signum(this.paJ - motionEvent.getX()) == this.paH) {
                    ekI();
                    break;
                } else {
                    ekH();
                    return false;
                }
            case 2:
                int x = (int) (this.paJ - motionEvent.getX());
                if (this.state == 1) {
                    x += this.paI.getWidth() * this.paH;
                }
                NQ(x);
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

    private void NQ(int i) {
        if (Math.signum(i) != this.paH) {
            i = 0;
        } else if (Math.abs(i) > this.paI.getWidth()) {
            i = this.paI.getWidth() * this.paH;
        }
        this.mContentView.layout(-i, this.mContentView.getTop(), this.mContentView.getWidth() - i, getMeasuredHeight());
        if (this.paH == 1) {
            this.paI.layout(this.mContentView.getWidth() - i, this.paI.getTop(), (this.mContentView.getWidth() + this.paI.getWidth()) - i, this.paI.getBottom());
        } else {
            this.paI.layout((-this.paI.getWidth()) - i, this.paI.getTop(), -i, this.paI.getBottom());
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.state == 1) {
            if (this.paO.computeScrollOffset()) {
                NQ(this.paO.getCurrX() * this.paH);
                postInvalidate();
            }
        } else if (this.paP.computeScrollOffset()) {
            NQ((this.paQ - this.paP.getCurrX()) * this.paH);
            postInvalidate();
        }
    }

    public void ekH() {
        this.state = 0;
        if (this.paH == 1) {
            this.paQ = -this.mContentView.getLeft();
            this.paP.startScroll(0, 0, this.paI.getWidth(), 0, 350);
        } else {
            this.paQ = this.paI.getRight();
            this.paP.startScroll(0, 0, this.paI.getWidth(), 0, 350);
        }
        postInvalidate();
    }

    public void ekI() {
        this.state = 1;
        if (this.paH == 1) {
            this.paO.startScroll(-this.mContentView.getLeft(), 0, this.paI.getWidth(), 0, 350);
        } else {
            this.paO.startScroll(this.mContentView.getLeft(), 0, this.paI.getWidth(), 0, 350);
        }
        postInvalidate();
    }

    public void ekJ() {
        if (this.paP.computeScrollOffset()) {
            this.paP.abortAnimation();
        }
        if (this.state == 1) {
            this.state = 0;
            NQ(0);
        }
    }

    public View getContentView() {
        return this.mContentView;
    }

    public SMView getMenuView() {
        return this.paI;
    }

    private int vn(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.paI.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mContentView.layout(0, 0, getMeasuredWidth(), this.mContentView.getMeasuredHeight());
        if (this.paH == 1) {
            this.paI.layout(getMeasuredWidth(), 0, getMeasuredWidth() + this.paI.getMeasuredWidth(), this.mContentView.getMeasuredHeight());
        } else {
            this.paI.layout(-this.paI.getMeasuredWidth(), 0, 0, this.mContentView.getMeasuredHeight());
        }
    }

    public void setMenuHeight(int i) {
        Log.i("byz", "pos = " + this.position + ", height = " + i);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.paI.getLayoutParams();
        if (layoutParams.height != i) {
            layoutParams.height = i;
            this.paI.setLayoutParams(this.paI.getLayoutParams());
        }
    }
}
