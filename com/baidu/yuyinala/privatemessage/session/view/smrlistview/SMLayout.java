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
    private int pnC;
    private SMView pnD;
    private int pnE;
    private GestureDetector.OnGestureListener pnF;
    private boolean pnG;
    private int pnH;
    private int pnI;
    private ScrollerCompat pnJ;
    private ScrollerCompat pnK;
    private int pnL;
    private Interpolator pnM;
    private Interpolator pnN;
    private int position;
    private int state;

    public SMLayout(View view, SMView sMView, Interpolator interpolator, Interpolator interpolator2) {
        super(view.getContext());
        this.state = 0;
        this.pnH = vA(15);
        this.pnI = -vA(500);
        this.pnM = interpolator;
        this.pnN = interpolator2;
        this.mContentView = view;
        this.pnD = sMView;
        this.pnD.setLayout(this);
        init();
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
        this.pnD.setPosition(i);
    }

    public void setSwipeDirection(int i) {
        this.pnC = i;
    }

    private void init() {
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        this.pnF = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMLayout.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                SMLayout.this.pnG = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > SMLayout.this.pnH && f < SMLayout.this.pnI) {
                    SMLayout.this.pnG = true;
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
        };
        this.mGestureDetector = new GestureDetectorCompat(getContext(), this.pnF);
        if (this.pnM != null) {
            this.pnK = ScrollerCompat.create(getContext(), this.pnM);
        } else {
            this.pnK = ScrollerCompat.create(getContext());
        }
        if (this.pnN != null) {
            this.pnJ = ScrollerCompat.create(getContext(), this.pnN);
        } else {
            this.pnJ = ScrollerCompat.create(getContext());
        }
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        if (this.mContentView.getId() < 1) {
            this.mContentView.setId(1);
        }
        this.pnD.setId(2);
        this.pnD.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(this.mContentView);
        addView(this.pnD);
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
                this.pnE = (int) motionEvent.getX();
                this.pnG = false;
                break;
            case 1:
                if ((this.pnG || Math.abs(this.pnE - motionEvent.getX()) > this.pnD.getWidth() / 2) && Math.signum(this.pnE - motionEvent.getX()) == this.pnC) {
                    ent();
                    break;
                } else {
                    ens();
                    return false;
                }
            case 2:
                int x = (int) (this.pnE - motionEvent.getX());
                if (this.state == 1) {
                    x += this.pnD.getWidth() * this.pnC;
                }
                Oq(x);
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

    private void Oq(int i) {
        if (Math.signum(i) != this.pnC) {
            i = 0;
        } else if (Math.abs(i) > this.pnD.getWidth()) {
            i = this.pnD.getWidth() * this.pnC;
        }
        this.mContentView.layout(-i, this.mContentView.getTop(), this.mContentView.getWidth() - i, getMeasuredHeight());
        if (this.pnC == 1) {
            this.pnD.layout(this.mContentView.getWidth() - i, this.pnD.getTop(), (this.mContentView.getWidth() + this.pnD.getWidth()) - i, this.pnD.getBottom());
        } else {
            this.pnD.layout((-this.pnD.getWidth()) - i, this.pnD.getTop(), -i, this.pnD.getBottom());
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.state == 1) {
            if (this.pnJ.computeScrollOffset()) {
                Oq(this.pnJ.getCurrX() * this.pnC);
                postInvalidate();
            }
        } else if (this.pnK.computeScrollOffset()) {
            Oq((this.pnL - this.pnK.getCurrX()) * this.pnC);
            postInvalidate();
        }
    }

    public void ens() {
        this.state = 0;
        if (this.pnC == 1) {
            this.pnL = -this.mContentView.getLeft();
            this.pnK.startScroll(0, 0, this.pnD.getWidth(), 0, 350);
        } else {
            this.pnL = this.pnD.getRight();
            this.pnK.startScroll(0, 0, this.pnD.getWidth(), 0, 350);
        }
        postInvalidate();
    }

    public void ent() {
        this.state = 1;
        if (this.pnC == 1) {
            this.pnJ.startScroll(-this.mContentView.getLeft(), 0, this.pnD.getWidth(), 0, 350);
        } else {
            this.pnJ.startScroll(this.mContentView.getLeft(), 0, this.pnD.getWidth(), 0, 350);
        }
        postInvalidate();
    }

    public void enu() {
        if (this.pnK.computeScrollOffset()) {
            this.pnK.abortAnimation();
        }
        if (this.state == 1) {
            this.state = 0;
            Oq(0);
        }
    }

    public View getContentView() {
        return this.mContentView;
    }

    public SMView getMenuView() {
        return this.pnD;
    }

    private int vA(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.pnD.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mContentView.layout(0, 0, getMeasuredWidth(), this.mContentView.getMeasuredHeight());
        if (this.pnC == 1) {
            this.pnD.layout(getMeasuredWidth(), 0, getMeasuredWidth() + this.pnD.getMeasuredWidth(), this.mContentView.getMeasuredHeight());
        } else {
            this.pnD.layout(-this.pnD.getMeasuredWidth(), 0, 0, this.mContentView.getMeasuredHeight());
        }
    }

    public void setMenuHeight(int i) {
        Log.i("byz", "pos = " + this.position + ", height = " + i);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.pnD.getLayoutParams();
        if (layoutParams.height != i) {
            layoutParams.height = i;
            this.pnD.setLayoutParams(this.pnD.getLayoutParams());
        }
    }
}
