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
    private int paI;
    private SMView paJ;
    private int paK;
    private GestureDetector.OnGestureListener paL;
    private boolean paM;
    private int paN;
    private int paO;
    private ScrollerCompat paP;
    private ScrollerCompat paQ;
    private int paR;
    private Interpolator paS;
    private Interpolator paT;
    private int position;
    private int state;

    public SMLayout(View view, SMView sMView, Interpolator interpolator, Interpolator interpolator2) {
        super(view.getContext());
        this.state = 0;
        this.paN = vn(15);
        this.paO = -vn(500);
        this.paS = interpolator;
        this.paT = interpolator2;
        this.mContentView = view;
        this.paJ = sMView;
        this.paJ.setLayout(this);
        init();
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
        this.paJ.setPosition(i);
    }

    public void setSwipeDirection(int i) {
        this.paI = i;
    }

    private void init() {
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        this.paL = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMLayout.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                SMLayout.this.paM = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > SMLayout.this.paN && f < SMLayout.this.paO) {
                    SMLayout.this.paM = true;
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
        };
        this.mGestureDetector = new GestureDetectorCompat(getContext(), this.paL);
        if (this.paS != null) {
            this.paQ = ScrollerCompat.create(getContext(), this.paS);
        } else {
            this.paQ = ScrollerCompat.create(getContext());
        }
        if (this.paT != null) {
            this.paP = ScrollerCompat.create(getContext(), this.paT);
        } else {
            this.paP = ScrollerCompat.create(getContext());
        }
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        if (this.mContentView.getId() < 1) {
            this.mContentView.setId(1);
        }
        this.paJ.setId(2);
        this.paJ.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(this.mContentView);
        addView(this.paJ);
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
                this.paK = (int) motionEvent.getX();
                this.paM = false;
                break;
            case 1:
                if ((this.paM || Math.abs(this.paK - motionEvent.getX()) > this.paJ.getWidth() / 2) && Math.signum(this.paK - motionEvent.getX()) == this.paI) {
                    ekI();
                    break;
                } else {
                    ekH();
                    return false;
                }
            case 2:
                int x = (int) (this.paK - motionEvent.getX());
                if (this.state == 1) {
                    x += this.paJ.getWidth() * this.paI;
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
        if (Math.signum(i) != this.paI) {
            i = 0;
        } else if (Math.abs(i) > this.paJ.getWidth()) {
            i = this.paJ.getWidth() * this.paI;
        }
        this.mContentView.layout(-i, this.mContentView.getTop(), this.mContentView.getWidth() - i, getMeasuredHeight());
        if (this.paI == 1) {
            this.paJ.layout(this.mContentView.getWidth() - i, this.paJ.getTop(), (this.mContentView.getWidth() + this.paJ.getWidth()) - i, this.paJ.getBottom());
        } else {
            this.paJ.layout((-this.paJ.getWidth()) - i, this.paJ.getTop(), -i, this.paJ.getBottom());
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.state == 1) {
            if (this.paP.computeScrollOffset()) {
                NQ(this.paP.getCurrX() * this.paI);
                postInvalidate();
            }
        } else if (this.paQ.computeScrollOffset()) {
            NQ((this.paR - this.paQ.getCurrX()) * this.paI);
            postInvalidate();
        }
    }

    public void ekH() {
        this.state = 0;
        if (this.paI == 1) {
            this.paR = -this.mContentView.getLeft();
            this.paQ.startScroll(0, 0, this.paJ.getWidth(), 0, 350);
        } else {
            this.paR = this.paJ.getRight();
            this.paQ.startScroll(0, 0, this.paJ.getWidth(), 0, 350);
        }
        postInvalidate();
    }

    public void ekI() {
        this.state = 1;
        if (this.paI == 1) {
            this.paP.startScroll(-this.mContentView.getLeft(), 0, this.paJ.getWidth(), 0, 350);
        } else {
            this.paP.startScroll(this.mContentView.getLeft(), 0, this.paJ.getWidth(), 0, 350);
        }
        postInvalidate();
    }

    public void ekJ() {
        if (this.paQ.computeScrollOffset()) {
            this.paQ.abortAnimation();
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
        return this.paJ;
    }

    private int vn(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.paJ.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mContentView.layout(0, 0, getMeasuredWidth(), this.mContentView.getMeasuredHeight());
        if (this.paI == 1) {
            this.paJ.layout(getMeasuredWidth(), 0, getMeasuredWidth() + this.paJ.getMeasuredWidth(), this.mContentView.getMeasuredHeight());
        } else {
            this.paJ.layout(-this.paJ.getMeasuredWidth(), 0, 0, this.mContentView.getMeasuredHeight());
        }
    }

    public void setMenuHeight(int i) {
        Log.i("byz", "pos = " + this.position + ", height = " + i);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.paJ.getLayoutParams();
        if (layoutParams.height != i) {
            layoutParams.height = i;
            this.paJ.setLayoutParams(this.paJ.getLayoutParams());
        }
    }
}
