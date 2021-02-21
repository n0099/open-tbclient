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
    private GestureDetector.OnGestureListener plA;
    private boolean plB;
    private int plC;
    private int plD;
    private ScrollerCompat plE;
    private ScrollerCompat plF;
    private int plG;
    private Interpolator plH;
    private Interpolator plI;
    private int plx;
    private SMView ply;
    private int plz;
    private int position;
    private int state;

    public SMLayout(View view, SMView sMView, Interpolator interpolator, Interpolator interpolator2) {
        super(view.getContext());
        this.state = 0;
        this.plC = vy(15);
        this.plD = -vy(500);
        this.plH = interpolator;
        this.plI = interpolator2;
        this.mContentView = view;
        this.ply = sMView;
        this.ply.setLayout(this);
        init();
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
        this.ply.setPosition(i);
    }

    public void setSwipeDirection(int i) {
        this.plx = i;
    }

    private void init() {
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        this.plA = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMLayout.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                SMLayout.this.plB = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > SMLayout.this.plC && f < SMLayout.this.plD) {
                    SMLayout.this.plB = true;
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
        };
        this.mGestureDetector = new GestureDetectorCompat(getContext(), this.plA);
        if (this.plH != null) {
            this.plF = ScrollerCompat.create(getContext(), this.plH);
        } else {
            this.plF = ScrollerCompat.create(getContext());
        }
        if (this.plI != null) {
            this.plE = ScrollerCompat.create(getContext(), this.plI);
        } else {
            this.plE = ScrollerCompat.create(getContext());
        }
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        if (this.mContentView.getId() < 1) {
            this.mContentView.setId(1);
        }
        this.ply.setId(2);
        this.ply.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(this.mContentView);
        addView(this.ply);
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
                this.plz = (int) motionEvent.getX();
                this.plB = false;
                break;
            case 1:
                if ((this.plB || Math.abs(this.plz - motionEvent.getX()) > this.ply.getWidth() / 2) && Math.signum(this.plz - motionEvent.getX()) == this.plx) {
                    enj();
                    break;
                } else {
                    eni();
                    return false;
                }
            case 2:
                int x = (int) (this.plz - motionEvent.getX());
                if (this.state == 1) {
                    x += this.ply.getWidth() * this.plx;
                }
                Om(x);
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

    private void Om(int i) {
        if (Math.signum(i) != this.plx) {
            i = 0;
        } else if (Math.abs(i) > this.ply.getWidth()) {
            i = this.ply.getWidth() * this.plx;
        }
        this.mContentView.layout(-i, this.mContentView.getTop(), this.mContentView.getWidth() - i, getMeasuredHeight());
        if (this.plx == 1) {
            this.ply.layout(this.mContentView.getWidth() - i, this.ply.getTop(), (this.mContentView.getWidth() + this.ply.getWidth()) - i, this.ply.getBottom());
        } else {
            this.ply.layout((-this.ply.getWidth()) - i, this.ply.getTop(), -i, this.ply.getBottom());
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.state == 1) {
            if (this.plE.computeScrollOffset()) {
                Om(this.plE.getCurrX() * this.plx);
                postInvalidate();
            }
        } else if (this.plF.computeScrollOffset()) {
            Om((this.plG - this.plF.getCurrX()) * this.plx);
            postInvalidate();
        }
    }

    public void eni() {
        this.state = 0;
        if (this.plx == 1) {
            this.plG = -this.mContentView.getLeft();
            this.plF.startScroll(0, 0, this.ply.getWidth(), 0, 350);
        } else {
            this.plG = this.ply.getRight();
            this.plF.startScroll(0, 0, this.ply.getWidth(), 0, 350);
        }
        postInvalidate();
    }

    public void enj() {
        this.state = 1;
        if (this.plx == 1) {
            this.plE.startScroll(-this.mContentView.getLeft(), 0, this.ply.getWidth(), 0, 350);
        } else {
            this.plE.startScroll(this.mContentView.getLeft(), 0, this.ply.getWidth(), 0, 350);
        }
        postInvalidate();
    }

    public void enk() {
        if (this.plF.computeScrollOffset()) {
            this.plF.abortAnimation();
        }
        if (this.state == 1) {
            this.state = 0;
            Om(0);
        }
    }

    public View getContentView() {
        return this.mContentView;
    }

    public SMView getMenuView() {
        return this.ply;
    }

    private int vy(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.ply.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mContentView.layout(0, 0, getMeasuredWidth(), this.mContentView.getMeasuredHeight());
        if (this.plx == 1) {
            this.ply.layout(getMeasuredWidth(), 0, getMeasuredWidth() + this.ply.getMeasuredWidth(), this.mContentView.getMeasuredHeight());
        } else {
            this.ply.layout(-this.ply.getMeasuredWidth(), 0, 0, this.mContentView.getMeasuredHeight());
        }
    }

    public void setMenuHeight(int i) {
        Log.i("byz", "pos = " + this.position + ", height = " + i);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ply.getLayoutParams();
        if (layoutParams.height != i) {
            layoutParams.height = i;
            this.ply.setLayoutParams(this.ply.getLayoutParams());
        }
    }
}
