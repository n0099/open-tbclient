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
/* loaded from: classes4.dex */
public class SwitchButton extends CompoundButton {
    private static boolean oDY = false;
    private float bFi;
    private float dnY;
    private boolean isAnimating;
    private Rect mBounds;
    private boolean mIsChecked;
    private float mLastX;
    private Paint mRectPaint;
    private int mTouchSlop;
    private b oDZ;
    private Rect oEa;
    private Rect oEb;
    private Rect oEc;
    private RectF oEd;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a oEe;
    private a oEf;
    private float oEg;
    private int oEh;
    private CompoundButton.OnCheckedChangeListener oEi;

    @SuppressLint({"NewApi"})
    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsChecked = false;
        this.oEf = new a();
        this.isAnimating = false;
        this.mBounds = null;
        initView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.SwitchButton);
        this.oDZ.NP(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_margin, this.oDZ.ehB()));
        this.oDZ.K(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginTop, this.oDZ.ehC()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginBottom, this.oDZ.ehD()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginLeft, this.oDZ.ehE()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginRight, this.oDZ.ehF()));
        this.oDZ.setRadius(obtainStyledAttributes.getInt(a.j.SwitchButton_kswRadius, b.a.DEFAULT_RADIUS));
        this.oDZ.dP(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_width, -1), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_height, -1));
        this.oDZ.bg(obtainStyledAttributes.getFloat(a.j.SwitchButton_kswMeasureFactor, -1.0f));
        this.oDZ.L(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetLeft, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetTop, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetRight, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetBottom, 0));
        this.oEe.NO(obtainStyledAttributes.getInteger(a.j.SwitchButton_kswAnimationVelocity, -1));
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
        this.oDZ = b.bf(getContext().getResources().getDisplayMetrics().density);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.oEh = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.oEe = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.ehu().a(this.oEf);
        this.mBounds = new Rect();
        if (oDY) {
            this.mRectPaint = new Paint();
            this.mRectPaint.setStyle(Paint.Style.STROKE);
        }
    }

    private void c(TypedArray typedArray) {
        if (this.oDZ != null) {
            this.oDZ.l(a(typedArray, a.j.SwitchButton_kswOffDrawable, a.j.SwitchButton_kswOffColor, b.a.oDQ));
            this.oDZ.m(a(typedArray, a.j.SwitchButton_kswOnDrawable, a.j.SwitchButton_kswOnColor, b.a.oDR));
            this.oDZ.setThumbDrawable(d(typedArray));
        }
    }

    private Drawable a(TypedArray typedArray, int i, int i2, int i3) {
        Drawable drawable = typedArray.getDrawable(i);
        if (drawable == null) {
            int color = typedArray.getColor(i2, i3);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.oDZ.getRadius());
            gradientDrawable.setColor(color);
            return gradientDrawable;
        }
        return drawable;
    }

    private Drawable d(TypedArray typedArray) {
        Drawable drawable = typedArray.getDrawable(a.j.SwitchButton_kswThumbDrawable);
        if (drawable == null) {
            int color = typedArray.getColor(a.j.SwitchButton_kswThumbColor, b.a.oDS);
            int color2 = typedArray.getColor(a.j.SwitchButton_kswThumbPressedColor, b.a.oDT);
            StateListDrawable stateListDrawable = new StateListDrawable();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.oDZ.getRadius());
            gradientDrawable.setColor(color);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(this.oDZ.getRadius());
            gradientDrawable2.setColor(color2);
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, gradientDrawable2);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }
        return drawable;
    }

    public b getConfiguration() {
        return this.oDZ;
    }

    public void setConfiguration(b bVar) {
        if (this.oDZ == null) {
            this.oDZ = b.bf(bVar.getDensity());
        }
        this.oDZ.l(bVar.ehH());
        this.oDZ.m(bVar.ehI());
        this.oDZ.setThumbDrawable(bVar.ehJ());
        this.oDZ.K(bVar.ehC(), bVar.ehD(), bVar.ehE(), bVar.ehF());
        this.oDZ.dP(bVar.ehR(), bVar.ehS());
        this.oDZ.NO(bVar.ehG());
        this.oDZ.bg(bVar.ehK());
        this.oEe.NO(this.oDZ.ehG());
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
        ehU();
        ehT();
        ehV();
        ehW();
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            this.oEd = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
        }
    }

    private void ehT() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.oEa == null) {
                this.oEa = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.oDZ.ehE() > 0 ? this.oDZ.ehE() : 0);
            int paddingRight = (-this.oDZ.ehO()) + ((measuredWidth - getPaddingRight()) - (this.oDZ.ehF() > 0 ? this.oDZ.ehF() : 0));
            this.oEa.set(paddingLeft, (this.oDZ.ehC() > 0 ? this.oDZ.ehC() : 0) + getPaddingTop(), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.oDZ.ehD() > 0 ? this.oDZ.ehD() : 0)) + (-this.oDZ.ehP()));
            this.oEg = this.oEa.left + (((this.oEa.right - this.oEa.left) - this.oDZ.ehR()) / 2);
            return;
        }
        this.oEa = null;
    }

    private void ehU() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.oEb == null) {
                this.oEb = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.oDZ.ehE() > 0 ? 0 : -this.oDZ.ehE());
            int paddingRight = (-this.oDZ.ehO()) + ((measuredWidth - getPaddingRight()) - (this.oDZ.ehF() > 0 ? 0 : -this.oDZ.ehF()));
            this.oEb.set(paddingLeft, (this.oDZ.ehC() > 0 ? 0 : -this.oDZ.ehC()) + getPaddingTop(), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.oDZ.ehD() <= 0 ? -this.oDZ.ehD() : 0)) + (-this.oDZ.ehP()));
            return;
        }
        this.oEb = null;
    }

    private void ehV() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.oEc == null) {
                this.oEc = new Rect();
            }
            int ehR = this.mIsChecked ? this.oEa.right - this.oDZ.ehR() : this.oEa.left;
            int i = this.oEa.top;
            this.oEc.set(ehR, i, this.oDZ.ehR() + ehR, this.oDZ.ehS() + i);
            return;
        }
        this.oEc = null;
    }

    private void ehW() {
        if (this.oEb != null) {
            this.oDZ.ehz().setBounds(this.oEb);
            this.oDZ.ehA().setBounds(this.oEb);
        }
        if (this.oEc != null) {
            this.oDZ.getThumbDrawable().setBounds(this.oEc);
        }
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int ehR = (int) ((this.oDZ.ehR() * this.oDZ.ehK()) + getPaddingLeft() + getPaddingRight());
        int ehE = this.oDZ.ehE() + this.oDZ.ehF();
        if (ehE > 0) {
            ehR += ehE;
        }
        if (mode == 1073741824) {
            ehR = Math.max(size, ehR);
        } else if (mode == Integer.MIN_VALUE) {
            ehR = Math.min(size, ehR);
        }
        return ehR + this.oDZ.ehL().left + this.oDZ.ehL().right;
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int ehS = this.oDZ.ehS() + getPaddingTop() + getPaddingBottom();
        int ehC = this.oDZ.ehC() + this.oDZ.ehD();
        if (ehC > 0) {
            ehS += ehC;
        }
        if (mode == 1073741824) {
            ehS = Math.max(size, ehS);
        } else if (mode == Integer.MIN_VALUE) {
            ehS = Math.min(size, ehS);
        }
        return ehS + this.oDZ.ehL().top + this.oDZ.ehL().bottom;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mBounds);
        if (this.mBounds != null && this.oDZ.ehQ()) {
            this.mBounds.inset(this.oDZ.ehM(), this.oDZ.ehN());
            canvas.clipRect(this.mBounds, Region.Op.REPLACE);
            canvas.translate(this.oDZ.ehL().left, this.oDZ.ehL().top);
        }
        boolean z = !isEnabled() && ehX();
        if (z) {
            canvas.saveLayerAlpha(this.oEd, 127, 31);
        }
        if (this.oDZ.ehA() != null) {
            this.oDZ.ehA().draw(canvas);
        }
        if (this.oDZ.ehz() != null) {
            this.oDZ.ehz().setAlpha(ehY());
            this.oDZ.ehz().draw(canvas);
        }
        if (this.oDZ.getThumbDrawable() != null) {
            this.oDZ.getThumbDrawable().draw(canvas);
        }
        if (z) {
            canvas.restore();
        }
        if (oDY) {
            this.mRectPaint.setColor(Color.parseColor("#AA0000"));
            canvas.drawRect(this.oEb, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#00FF00"));
            canvas.drawRect(this.oEa, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#0000FF"));
            canvas.drawRect(this.oEc, this.mRectPaint);
        }
    }

    private boolean ehX() {
        return ((this.oDZ.getThumbDrawable() instanceof StateListDrawable) && (this.oDZ.ehz() instanceof StateListDrawable) && (this.oDZ.ehA() instanceof StateListDrawable)) ? false : true;
    }

    private int ehY() {
        int ehR;
        if (this.oEa == null || this.oEa.right == this.oEa.left || (ehR = (this.oEa.right - this.oDZ.ehR()) - this.oEa.left) <= 0) {
            return 255;
        }
        return ((this.oEc.left - this.oEa.left) * 255) / ehR;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isAnimating || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX() - this.dnY;
        float y = motionEvent.getY() - this.bFi;
        boolean z = this.mIsChecked;
        switch (action) {
            case 0:
                ehZ();
                this.dnY = motionEvent.getX();
                this.bFi = motionEvent.getY();
                this.mLastX = this.dnY;
                setPressed(true);
                break;
            case 1:
            case 3:
                setPressed(false);
                boolean statusBasedOnPos = getStatusBasedOnPos();
                float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                if (x < this.mTouchSlop && y < this.mTouchSlop && eventTime < this.oEh) {
                    performClick();
                    break;
                } else {
                    zW(statusBasedOnPos);
                    break;
                }
                break;
            case 2:
                float x2 = motionEvent.getX();
                NV((int) (x2 - this.mLastX));
                this.mLastX = x2;
                break;
        }
        invalidate();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getStatusBasedOnPos() {
        return ((float) this.oEc.left) > this.oEg;
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.mBounds != null && this.oDZ.ehQ()) {
            invalidate(this.mBounds);
        } else {
            super.invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    private void ehZ() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void setChecked(boolean z, boolean z2) {
        if (this.oEc != null) {
            NV(z ? getMeasuredWidth() : -getMeasuredWidth());
        }
        aG(z, z2);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        setChecked(z, true);
    }

    public void zV(boolean z) {
        if (z) {
            zW(this.mIsChecked ? false : true);
        } else {
            setChecked(this.mIsChecked ? false : true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        zV(true);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.oDZ != null) {
            setDrawableState(this.oDZ.getThumbDrawable());
            setDrawableState(this.oDZ.ehz());
            setDrawableState(this.oDZ.ehA());
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
        this.oEi = onCheckedChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedInClass(boolean z) {
        aG(z, true);
    }

    private void aG(boolean z, boolean z2) {
        if (this.mIsChecked != z) {
            this.mIsChecked = z;
            refreshDrawableState();
            if (this.oEi != null && z2) {
                this.oEi.onCheckedChanged(this, this.mIsChecked);
            }
        }
    }

    public void zW(boolean z) {
        if (!this.isAnimating) {
            this.oEe.dO(this.oEc.left, z ? this.oEa.right - this.oDZ.ehR() : this.oEa.left);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NV(int i) {
        int i2 = this.oEc.left + i;
        int i3 = this.oEc.right + i;
        if (i2 < this.oEa.left) {
            i2 = this.oEa.left;
            i3 = this.oDZ.ehR() + i2;
        }
        if (i3 > this.oEa.right) {
            i3 = this.oEa.right;
            i2 = i3 - this.oDZ.ehR();
        }
        dQ(i2, i3);
    }

    private void dQ(int i, int i2) {
        this.oEc.set(i, this.oEc.top, i2, this.oEc.bottom);
        this.oDZ.getThumbDrawable().setBounds(this.oEc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements a.b {
        a() {
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void onAnimationStart() {
            SwitchButton.this.isAnimating = true;
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public boolean ehv() {
            return SwitchButton.this.oEc.right < SwitchButton.this.oEa.right && SwitchButton.this.oEc.left > SwitchButton.this.oEa.left;
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void onFrameUpdate(int i) {
            SwitchButton.this.NV(i);
            SwitchButton.this.postInvalidate();
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void ehw() {
            SwitchButton.this.setCheckedInClass(SwitchButton.this.getStatusBasedOnPos());
            SwitchButton.this.isAnimating = false;
        }
    }
}
