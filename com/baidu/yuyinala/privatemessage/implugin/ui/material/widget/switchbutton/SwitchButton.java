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
    private static boolean oWm = false;
    private float bIH;
    private float duh;
    private boolean isAnimating;
    private Rect mBounds;
    private boolean mIsChecked;
    private float mLastX;
    private Paint mRectPaint;
    private int mTouchSlop;
    private b oWn;
    private Rect oWo;
    private Rect oWp;
    private Rect oWq;
    private RectF oWr;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a oWs;
    private a oWt;
    private float oWu;
    private int oWv;
    private CompoundButton.OnCheckedChangeListener oWw;

    @SuppressLint({"NewApi"})
    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsChecked = false;
        this.oWt = new a();
        this.isAnimating = false;
        this.mBounds = null;
        initView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.SwitchButton);
        this.oWn.Nx(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_margin, this.oWn.ejx()));
        this.oWn.P(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginTop, this.oWn.ejy()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginBottom, this.oWn.ejz()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginLeft, this.oWn.ejA()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginRight, this.oWn.ejB()));
        this.oWn.setRadius(obtainStyledAttributes.getInt(a.j.SwitchButton_kswRadius, b.a.DEFAULT_RADIUS));
        this.oWn.dT(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_width, -1), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_height, -1));
        this.oWn.bz(obtainStyledAttributes.getFloat(a.j.SwitchButton_kswMeasureFactor, -1.0f));
        this.oWn.Q(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetLeft, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetTop, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetRight, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetBottom, 0));
        this.oWs.Nw(obtainStyledAttributes.getInteger(a.j.SwitchButton_kswAnimationVelocity, -1));
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
        this.oWn = b.by(getContext().getResources().getDisplayMetrics().density);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.oWv = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.oWs = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.ejq().a(this.oWt);
        this.mBounds = new Rect();
        if (oWm) {
            this.mRectPaint = new Paint();
            this.mRectPaint.setStyle(Paint.Style.STROKE);
        }
    }

    private void c(TypedArray typedArray) {
        if (this.oWn != null) {
            this.oWn.r(a(typedArray, a.j.SwitchButton_kswOffDrawable, a.j.SwitchButton_kswOffColor, b.a.oWe));
            this.oWn.s(a(typedArray, a.j.SwitchButton_kswOnDrawable, a.j.SwitchButton_kswOnColor, b.a.oWf));
            this.oWn.setThumbDrawable(d(typedArray));
        }
    }

    private Drawable a(TypedArray typedArray, int i, int i2, int i3) {
        Drawable drawable = typedArray.getDrawable(i);
        if (drawable == null) {
            int color = typedArray.getColor(i2, i3);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.oWn.getRadius());
            gradientDrawable.setColor(color);
            return gradientDrawable;
        }
        return drawable;
    }

    private Drawable d(TypedArray typedArray) {
        Drawable drawable = typedArray.getDrawable(a.j.SwitchButton_kswThumbDrawable);
        if (drawable == null) {
            int color = typedArray.getColor(a.j.SwitchButton_kswThumbColor, b.a.oWg);
            int color2 = typedArray.getColor(a.j.SwitchButton_kswThumbPressedColor, b.a.oWh);
            StateListDrawable stateListDrawable = new StateListDrawable();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.oWn.getRadius());
            gradientDrawable.setColor(color);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(this.oWn.getRadius());
            gradientDrawable2.setColor(color2);
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, gradientDrawable2);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }
        return drawable;
    }

    public b getConfiguration() {
        return this.oWn;
    }

    public void setConfiguration(b bVar) {
        if (this.oWn == null) {
            this.oWn = b.by(bVar.getDensity());
        }
        this.oWn.r(bVar.ejD());
        this.oWn.s(bVar.ejE());
        this.oWn.setThumbDrawable(bVar.ejF());
        this.oWn.P(bVar.ejy(), bVar.ejz(), bVar.ejA(), bVar.ejB());
        this.oWn.dT(bVar.ejN(), bVar.ejO());
        this.oWn.Nw(bVar.ejC());
        this.oWn.bz(bVar.ejG());
        this.oWs.Nw(this.oWn.ejC());
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
            this.oWr = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
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
            if (this.oWo == null) {
                this.oWo = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.oWn.ejA() > 0 ? this.oWn.ejA() : 0);
            int paddingRight = (-this.oWn.ejK()) + ((measuredWidth - getPaddingRight()) - (this.oWn.ejB() > 0 ? this.oWn.ejB() : 0));
            this.oWo.set(paddingLeft, (this.oWn.ejy() > 0 ? this.oWn.ejy() : 0) + getPaddingTop(), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.oWn.ejz() > 0 ? this.oWn.ejz() : 0)) + (-this.oWn.ejL()));
            this.oWu = this.oWo.left + (((this.oWo.right - this.oWo.left) - this.oWn.ejN()) / 2);
            return;
        }
        this.oWo = null;
    }

    private void ejQ() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.oWp == null) {
                this.oWp = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.oWn.ejA() > 0 ? 0 : -this.oWn.ejA());
            int paddingRight = (-this.oWn.ejK()) + ((measuredWidth - getPaddingRight()) - (this.oWn.ejB() > 0 ? 0 : -this.oWn.ejB()));
            this.oWp.set(paddingLeft, (this.oWn.ejy() > 0 ? 0 : -this.oWn.ejy()) + getPaddingTop(), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.oWn.ejz() <= 0 ? -this.oWn.ejz() : 0)) + (-this.oWn.ejL()));
            return;
        }
        this.oWp = null;
    }

    private void ejR() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.oWq == null) {
                this.oWq = new Rect();
            }
            int ejN = this.mIsChecked ? this.oWo.right - this.oWn.ejN() : this.oWo.left;
            int i = this.oWo.top;
            this.oWq.set(ejN, i, this.oWn.ejN() + ejN, this.oWn.ejO() + i);
            return;
        }
        this.oWq = null;
    }

    private void ejS() {
        if (this.oWp != null) {
            this.oWn.ejv().setBounds(this.oWp);
            this.oWn.ejw().setBounds(this.oWp);
        }
        if (this.oWq != null) {
            this.oWn.getThumbDrawable().setBounds(this.oWq);
        }
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int ejN = (int) ((this.oWn.ejN() * this.oWn.ejG()) + getPaddingLeft() + getPaddingRight());
        int ejA = this.oWn.ejA() + this.oWn.ejB();
        if (ejA > 0) {
            ejN += ejA;
        }
        if (mode == 1073741824) {
            ejN = Math.max(size, ejN);
        } else if (mode == Integer.MIN_VALUE) {
            ejN = Math.min(size, ejN);
        }
        return ejN + this.oWn.ejH().left + this.oWn.ejH().right;
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int ejO = this.oWn.ejO() + getPaddingTop() + getPaddingBottom();
        int ejy = this.oWn.ejy() + this.oWn.ejz();
        if (ejy > 0) {
            ejO += ejy;
        }
        if (mode == 1073741824) {
            ejO = Math.max(size, ejO);
        } else if (mode == Integer.MIN_VALUE) {
            ejO = Math.min(size, ejO);
        }
        return ejO + this.oWn.ejH().top + this.oWn.ejH().bottom;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mBounds);
        if (this.mBounds != null && this.oWn.ejM()) {
            this.mBounds.inset(this.oWn.ejI(), this.oWn.ejJ());
            canvas.clipRect(this.mBounds, Region.Op.REPLACE);
            canvas.translate(this.oWn.ejH().left, this.oWn.ejH().top);
        }
        boolean z = !isEnabled() && ejT();
        if (z) {
            canvas.saveLayerAlpha(this.oWr, 127, 31);
        }
        if (this.oWn.ejw() != null) {
            this.oWn.ejw().draw(canvas);
        }
        if (this.oWn.ejv() != null) {
            this.oWn.ejv().setAlpha(ejU());
            this.oWn.ejv().draw(canvas);
        }
        if (this.oWn.getThumbDrawable() != null) {
            this.oWn.getThumbDrawable().draw(canvas);
        }
        if (z) {
            canvas.restore();
        }
        if (oWm) {
            this.mRectPaint.setColor(Color.parseColor("#AA0000"));
            canvas.drawRect(this.oWp, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#00FF00"));
            canvas.drawRect(this.oWo, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#0000FF"));
            canvas.drawRect(this.oWq, this.mRectPaint);
        }
    }

    private boolean ejT() {
        return ((this.oWn.getThumbDrawable() instanceof StateListDrawable) && (this.oWn.ejv() instanceof StateListDrawable) && (this.oWn.ejw() instanceof StateListDrawable)) ? false : true;
    }

    private int ejU() {
        int ejN;
        if (this.oWo == null || this.oWo.right == this.oWo.left || (ejN = (this.oWo.right - this.oWn.ejN()) - this.oWo.left) <= 0) {
            return 255;
        }
        return ((this.oWq.left - this.oWo.left) * 255) / ejN;
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
                if (x < this.mTouchSlop && y < this.mTouchSlop && eventTime < this.oWv) {
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
        return ((float) this.oWq.left) > this.oWu;
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.mBounds != null && this.oWn.ejM()) {
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
        if (this.oWq != null) {
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
        if (this.oWn != null) {
            setDrawableState(this.oWn.getThumbDrawable());
            setDrawableState(this.oWn.ejv());
            setDrawableState(this.oWn.ejw());
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
        this.oWw = onCheckedChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedInClass(boolean z) {
        aI(z, true);
    }

    private void aI(boolean z, boolean z2) {
        if (this.mIsChecked != z) {
            this.mIsChecked = z;
            refreshDrawableState();
            if (this.oWw != null && z2) {
                this.oWw.onCheckedChanged(this, this.mIsChecked);
            }
        }
    }

    public void AD(boolean z) {
        if (!this.isAnimating) {
            this.oWs.dS(this.oWq.left, z ? this.oWo.right - this.oWn.ejN() : this.oWo.left);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ND(int i) {
        int i2 = this.oWq.left + i;
        int i3 = this.oWq.right + i;
        if (i2 < this.oWo.left) {
            i2 = this.oWo.left;
            i3 = this.oWn.ejN() + i2;
        }
        if (i3 > this.oWo.right) {
            i3 = this.oWo.right;
            i2 = i3 - this.oWn.ejN();
        }
        dU(i2, i3);
    }

    private void dU(int i, int i2) {
        this.oWq.set(i, this.oWq.top, i2, this.oWq.bottom);
        this.oWn.getThumbDrawable().setBounds(this.oWq);
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
            return SwitchButton.this.oWq.right < SwitchButton.this.oWo.right && SwitchButton.this.oWq.left > SwitchButton.this.oWo.left;
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
