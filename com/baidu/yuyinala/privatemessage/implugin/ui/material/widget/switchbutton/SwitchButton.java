package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CompoundButton;
import com.baidu.live.sdk.a;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.b;
/* loaded from: classes10.dex */
public class SwitchButton extends CompoundButton {
    private static boolean oWn = false;
    private float bIH;
    private float duh;
    private boolean isAnimating;
    private Rect mBounds;
    private boolean mIsChecked;
    private float mLastX;
    private Paint mRectPaint;
    private int mTouchSlop;
    private b oWo;
    private Rect oWp;
    private Rect oWq;
    private Rect oWr;
    private RectF oWs;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a oWt;
    private a oWu;
    private float oWv;
    private int oWw;
    private CompoundButton.OnCheckedChangeListener oWx;

    @SuppressLint({"NewApi"})
    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsChecked = false;
        this.oWu = new a();
        this.isAnimating = false;
        this.mBounds = null;
        initView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.SwitchButton);
        this.oWo.Nx(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_margin, this.oWo.ejx()));
        this.oWo.P(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginTop, this.oWo.ejy()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginBottom, this.oWo.ejz()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginLeft, this.oWo.ejA()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginRight, this.oWo.ejB()));
        this.oWo.setRadius(obtainStyledAttributes.getInt(a.j.SwitchButton_kswRadius, b.a.DEFAULT_RADIUS));
        this.oWo.dT(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_width, -1), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_height, -1));
        this.oWo.bz(obtainStyledAttributes.getFloat(a.j.SwitchButton_kswMeasureFactor, -1.0f));
        this.oWo.Q(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetLeft, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetTop, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetRight, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetBottom, 0));
        this.oWt.Nw(obtainStyledAttributes.getInteger(a.j.SwitchButton_kswAnimationVelocity, -1));
        c(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchButton(Context context) {
        this(context, null);
    }

    private void initView() {
        this.oWo = b.by(getContext().getResources().getDisplayMetrics().density);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.oWw = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.oWt = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.ejq().a(this.oWu);
        this.mBounds = new Rect();
        if (oWn) {
            this.mRectPaint = new Paint();
            this.mRectPaint.setStyle(Paint.Style.STROKE);
        }
    }

    private void c(TypedArray typedArray) {
        if (this.oWo != null) {
            this.oWo.r(a(typedArray, a.j.SwitchButton_kswOffDrawable, a.j.SwitchButton_kswOffColor, b.a.oWf));
            this.oWo.s(a(typedArray, a.j.SwitchButton_kswOnDrawable, a.j.SwitchButton_kswOnColor, b.a.oWg));
            this.oWo.setThumbDrawable(d(typedArray));
        }
    }

    private Drawable a(TypedArray typedArray, int i, int i2, int i3) {
        Drawable drawable = typedArray.getDrawable(i);
        if (drawable == null) {
            int color = typedArray.getColor(i2, i3);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.oWo.getRadius());
            gradientDrawable.setColor(color);
            return gradientDrawable;
        }
        return drawable;
    }

    private Drawable d(TypedArray typedArray) {
        Drawable drawable = typedArray.getDrawable(a.j.SwitchButton_kswThumbDrawable);
        if (drawable == null) {
            int color = typedArray.getColor(a.j.SwitchButton_kswThumbColor, b.a.oWh);
            int color2 = typedArray.getColor(a.j.SwitchButton_kswThumbPressedColor, b.a.oWi);
            StateListDrawable stateListDrawable = new StateListDrawable();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.oWo.getRadius());
            gradientDrawable.setColor(color);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(this.oWo.getRadius());
            gradientDrawable2.setColor(color2);
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, gradientDrawable2);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }
        return drawable;
    }

    public b getConfiguration() {
        return this.oWo;
    }

    public void setConfiguration(b bVar) {
        if (this.oWo == null) {
            this.oWo = b.by(bVar.getDensity());
        }
        this.oWo.r(bVar.ejD());
        this.oWo.s(bVar.ejE());
        this.oWo.setThumbDrawable(bVar.ejF());
        this.oWo.P(bVar.ejy(), bVar.ejz(), bVar.ejA(), bVar.ejB());
        this.oWo.dT(bVar.ejN(), bVar.ejO());
        this.oWo.Nw(bVar.ejC());
        this.oWo.bz(bVar.ejG());
        this.oWt.Nw(this.oWo.ejC());
        requestLayout();
        setup();
        setChecked(this.mIsChecked);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setup();
    }

    private void setup() {
        ejQ();
        ejP();
        ejR();
        ejS();
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            this.oWs = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
        }
    }

    private void ejP() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.oWp == null) {
                this.oWp = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.oWo.ejA() > 0 ? this.oWo.ejA() : 0);
            int paddingRight = (-this.oWo.ejK()) + ((measuredWidth - getPaddingRight()) - (this.oWo.ejB() > 0 ? this.oWo.ejB() : 0));
            this.oWp.set(paddingLeft, (this.oWo.ejy() > 0 ? this.oWo.ejy() : 0) + getPaddingTop(), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.oWo.ejz() > 0 ? this.oWo.ejz() : 0)) + (-this.oWo.ejL()));
            this.oWv = this.oWp.left + (((this.oWp.right - this.oWp.left) - this.oWo.ejN()) / 2);
            return;
        }
        this.oWp = null;
    }

    private void ejQ() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.oWq == null) {
                this.oWq = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.oWo.ejA() > 0 ? 0 : -this.oWo.ejA());
            int paddingRight = (-this.oWo.ejK()) + ((measuredWidth - getPaddingRight()) - (this.oWo.ejB() > 0 ? 0 : -this.oWo.ejB()));
            this.oWq.set(paddingLeft, (this.oWo.ejy() > 0 ? 0 : -this.oWo.ejy()) + getPaddingTop(), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.oWo.ejz() <= 0 ? -this.oWo.ejz() : 0)) + (-this.oWo.ejL()));
            return;
        }
        this.oWq = null;
    }

    private void ejR() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.oWr == null) {
                this.oWr = new Rect();
            }
            int ejN = this.mIsChecked ? this.oWp.right - this.oWo.ejN() : this.oWp.left;
            int i = this.oWp.top;
            this.oWr.set(ejN, i, this.oWo.ejN() + ejN, this.oWo.ejO() + i);
            return;
        }
        this.oWr = null;
    }

    private void ejS() {
        if (this.oWq != null) {
            this.oWo.ejv().setBounds(this.oWq);
            this.oWo.ejw().setBounds(this.oWq);
        }
        if (this.oWr != null) {
            this.oWo.getThumbDrawable().setBounds(this.oWr);
        }
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int ejN = (int) ((this.oWo.ejN() * this.oWo.ejG()) + getPaddingLeft() + getPaddingRight());
        int ejA = this.oWo.ejA() + this.oWo.ejB();
        if (ejA > 0) {
            ejN += ejA;
        }
        if (mode == 1073741824) {
            ejN = Math.max(size, ejN);
        } else if (mode == Integer.MIN_VALUE) {
            ejN = Math.min(size, ejN);
        }
        return ejN + this.oWo.ejH().left + this.oWo.ejH().right;
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int ejO = this.oWo.ejO() + getPaddingTop() + getPaddingBottom();
        int ejy = this.oWo.ejy() + this.oWo.ejz();
        if (ejy > 0) {
            ejO += ejy;
        }
        if (mode == 1073741824) {
            ejO = Math.max(size, ejO);
        } else if (mode == Integer.MIN_VALUE) {
            ejO = Math.min(size, ejO);
        }
        return ejO + this.oWo.ejH().top + this.oWo.ejH().bottom;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mBounds);
        if (this.mBounds != null && this.oWo.ejM()) {
            this.mBounds.inset(this.oWo.ejI(), this.oWo.ejJ());
            canvas.clipRect(this.mBounds, Region.Op.REPLACE);
            canvas.translate(this.oWo.ejH().left, this.oWo.ejH().top);
        }
        boolean z = !isEnabled() && ejT();
        if (z) {
            canvas.saveLayerAlpha(this.oWs, 127, 31);
        }
        if (this.oWo.ejw() != null) {
            this.oWo.ejw().draw(canvas);
        }
        if (this.oWo.ejv() != null) {
            this.oWo.ejv().setAlpha(ejU());
            this.oWo.ejv().draw(canvas);
        }
        if (this.oWo.getThumbDrawable() != null) {
            this.oWo.getThumbDrawable().draw(canvas);
        }
        if (z) {
            canvas.restore();
        }
        if (oWn) {
            this.mRectPaint.setColor(Color.parseColor("#AA0000"));
            canvas.drawRect(this.oWq, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#00FF00"));
            canvas.drawRect(this.oWp, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#0000FF"));
            canvas.drawRect(this.oWr, this.mRectPaint);
        }
    }

    private boolean ejT() {
        return ((this.oWo.getThumbDrawable() instanceof StateListDrawable) && (this.oWo.ejv() instanceof StateListDrawable) && (this.oWo.ejw() instanceof StateListDrawable)) ? false : true;
    }

    private int ejU() {
        int ejN;
        if (this.oWp == null || this.oWp.right == this.oWp.left || (ejN = (this.oWp.right - this.oWo.ejN()) - this.oWp.left) <= 0) {
            return 255;
        }
        return ((this.oWr.left - this.oWp.left) * 255) / ejN;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isAnimating || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX() - this.duh;
        float y = motionEvent.getY() - this.bIH;
        boolean z = this.mIsChecked;
        switch (action) {
            case 0:
                ejV();
                this.duh = motionEvent.getX();
                this.bIH = motionEvent.getY();
                this.mLastX = this.duh;
                setPressed(true);
                break;
            case 1:
            case 3:
                setPressed(false);
                boolean statusBasedOnPos = getStatusBasedOnPos();
                float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                if (x < this.mTouchSlop && y < this.mTouchSlop && eventTime < this.oWw) {
                    performClick();
                    break;
                } else {
                    AD(statusBasedOnPos);
                    break;
                }
                break;
            case 2:
                float x2 = motionEvent.getX();
                ND((int) (x2 - this.mLastX));
                this.mLastX = x2;
                break;
        }
        invalidate();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getStatusBasedOnPos() {
        return ((float) this.oWr.left) > this.oWv;
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.mBounds != null && this.oWo.ejM()) {
            invalidate(this.mBounds);
        } else {
            super.invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    private void ejV() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void setChecked(boolean z, boolean z2) {
        if (this.oWr != null) {
            ND(z ? getMeasuredWidth() : -getMeasuredWidth());
        }
        aI(z, z2);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        setChecked(z, true);
    }

    public void AC(boolean z) {
        if (z) {
            AD(this.mIsChecked ? false : true);
        } else {
            setChecked(this.mIsChecked ? false : true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        AC(true);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.oWo != null) {
            setDrawableState(this.oWo.getThumbDrawable());
            setDrawableState(this.oWo.ejv());
            setDrawableState(this.oWo.ejw());
        }
    }

    private void setDrawableState(Drawable drawable) {
        if (drawable != null) {
            drawable.setState(getDrawableState());
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.oWx = onCheckedChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedInClass(boolean z) {
        aI(z, true);
    }

    private void aI(boolean z, boolean z2) {
        if (this.mIsChecked != z) {
            this.mIsChecked = z;
            refreshDrawableState();
            if (this.oWx != null && z2) {
                this.oWx.onCheckedChanged(this, this.mIsChecked);
            }
        }
    }

    public void AD(boolean z) {
        if (!this.isAnimating) {
            this.oWt.dS(this.oWr.left, z ? this.oWp.right - this.oWo.ejN() : this.oWp.left);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ND(int i) {
        int i2 = this.oWr.left + i;
        int i3 = this.oWr.right + i;
        if (i2 < this.oWp.left) {
            i2 = this.oWp.left;
            i3 = this.oWo.ejN() + i2;
        }
        if (i3 > this.oWp.right) {
            i3 = this.oWp.right;
            i2 = i3 - this.oWo.ejN();
        }
        dU(i2, i3);
    }

    private void dU(int i, int i2) {
        this.oWr.set(i, this.oWr.top, i2, this.oWr.bottom);
        this.oWo.getThumbDrawable().setBounds(this.oWr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a implements a.b {
        a() {
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void onAnimationStart() {
            SwitchButton.this.isAnimating = true;
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public boolean ejr() {
            return SwitchButton.this.oWr.right < SwitchButton.this.oWp.right && SwitchButton.this.oWr.left > SwitchButton.this.oWp.left;
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void onFrameUpdate(int i) {
            SwitchButton.this.ND(i);
            SwitchButton.this.postInvalidate();
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void ejs() {
            SwitchButton.this.setCheckedInClass(SwitchButton.this.getStatusBasedOnPos());
            SwitchButton.this.isAnimating = false;
        }
    }
}
