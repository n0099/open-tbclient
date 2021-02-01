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
    private int pkX;
    private SMView pkY;
    private int pkZ;
    private GestureDetector.OnGestureListener pla;
    private boolean plb;
    private int plc;
    private int pld;
    private ScrollerCompat ple;
    private ScrollerCompat plf;
    private int plg;
    private Interpolator plh;
    private Interpolator pli;
    private int position;
    private int state;

    public SMLayout(View view, SMView sMView, Interpolator interpolator, Interpolator interpolator2) {
        super(view.getContext());
        this.state = 0;
        this.plc = vy(15);
        this.pld = -vy(500);
        this.plh = interpolator;
        this.pli = interpolator2;
        this.mContentView = view;
        this.pkY = sMView;
        this.pkY.setLayout(this);
        init();
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
        this.pkY.setPosition(i);
    }

    public void setSwipeDirection(int i) {
        this.pkX = i;
    }

    private void init() {
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        this.pla = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.session.view.smrlistview.SMLayout.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                SMLayout.this.plb = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (Math.abs(motionEvent.getX() - motionEvent2.getX()) > SMLayout.this.plc && f < SMLayout.this.pld) {
                    SMLayout.this.plb = true;
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
        };
        this.mGestureDetector = new GestureDetectorCompat(getContext(), this.pla);
        if (this.plh != null) {
            this.plf = ScrollerCompat.create(getContext(), this.plh);
        } else {
            this.plf = ScrollerCompat.create(getContext());
        }
        if (this.pli != null) {
            this.ple = ScrollerCompat.create(getContext(), this.pli);
        } else {
            this.ple = ScrollerCompat.create(getContext());
        }
        this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        if (this.mContentView.getId() < 1) {
            this.mContentView.setId(1);
        }
        this.pkY.setId(2);
        this.pkY.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(this.mContentView);
        addView(this.pkY);
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
                this.pkZ = (int) motionEvent.getX();
                this.plb = false;
                break;
            case 1:
                if ((this.plb || Math.abs(this.pkZ - motionEvent.getX()) > this.pkY.getWidth() / 2) && Math.signum(this.pkZ - motionEvent.getX()) == this.pkX) {
                    ena();
                    break;
                } else {
                    emZ();
                    return false;
                }
            case 2:
                int x = (int) (this.pkZ - motionEvent.getX());
                if (this.state == 1) {
                    x += this.pkY.getWidth() * this.pkX;
                }
                Ol(x);
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

    private void Ol(int i) {
        if (Math.signum(i) != this.pkX) {
            i = 0;
        } else if (Math.abs(i) > this.pkY.getWidth()) {
            i = this.pkY.getWidth() * this.pkX;
        }
        this.mContentView.layout(-i, this.mContentView.getTop(), this.mContentView.getWidth() - i, getMeasuredHeight());
        if (this.pkX == 1) {
            this.pkY.layout(this.mContentView.getWidth() - i, this.pkY.getTop(), (this.mContentView.getWidth() + this.pkY.getWidth()) - i, this.pkY.getBottom());
        } else {
            this.pkY.layout((-this.pkY.getWidth()) - i, this.pkY.getTop(), -i, this.pkY.getBottom());
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.state == 1) {
            if (this.ple.computeScrollOffset()) {
                Ol(this.ple.getCurrX() * this.pkX);
                postInvalidate();
            }
        } else if (this.plf.computeScrollOffset()) {
            Ol((this.plg - this.plf.getCurrX()) * this.pkX);
            postInvalidate();
        }
    }

    public void emZ() {
        this.state = 0;
        if (this.pkX == 1) {
            this.plg = -this.mContentView.getLeft();
            this.plf.startScroll(0, 0, this.pkY.getWidth(), 0, 350);
        } else {
            this.plg = this.pkY.getRight();
            this.plf.startScroll(0, 0, this.pkY.getWidth(), 0, 350);
        }
        postInvalidate();
    }

    public void ena() {
        this.state = 1;
        if (this.pkX == 1) {
            this.ple.startScroll(-this.mContentView.getLeft(), 0, this.pkY.getWidth(), 0, 350);
        } else {
            this.ple.startScroll(this.mContentView.getLeft(), 0, this.pkY.getWidth(), 0, 350);
        }
        postInvalidate();
    }

    public void enb() {
        if (this.plf.computeScrollOffset()) {
            this.plf.abortAnimation();
        }
        if (this.state == 1) {
            this.state = 0;
            Ol(0);
        }
    }

    public View getContentView() {
        return this.mContentView;
    }

    public SMView getMenuView() {
        return this.pkY;
    }

    private int vy(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.pkY.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mContentView.layout(0, 0, getMeasuredWidth(), this.mContentView.getMeasuredHeight());
        if (this.pkX == 1) {
            this.pkY.layout(getMeasuredWidth(), 0, getMeasuredWidth() + this.pkY.getMeasuredWidth(), this.mContentView.getMeasuredHeight());
        } else {
            this.pkY.layout(-this.pkY.getMeasuredWidth(), 0, 0, this.mContentView.getMeasuredHeight());
        }
    }

    public void setMenuHeight(int i) {
        Log.i("byz", "pos = " + this.position + ", height = " + i);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.pkY.getLayoutParams();
        if (layoutParams.height != i) {
            layoutParams.height = i;
            this.pkY.setLayoutParams(this.pkY.getLayoutParams());
        }
    }
}
