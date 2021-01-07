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
/* loaded from: classes11.dex */
public class SwitchButton extends CompoundButton {
    private static boolean paQ = false;
    private float bNt;
    private float dyT;
    private boolean isAnimating;
    private Rect mBounds;
    private boolean mIsChecked;
    private float mLastX;
    private Paint mRectPaint;
    private int mTouchSlop;
    private b paR;
    private Rect paS;
    private Rect paT;
    private Rect paU;
    private RectF paV;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a paW;
    private a paX;
    private float paY;
    private int paZ;
    private CompoundButton.OnCheckedChangeListener pba;

    @SuppressLint({"NewApi"})
    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsChecked = false;
        this.paX = new a();
        this.isAnimating = false;
        this.mBounds = null;
        initView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.SwitchButton);
        this.paR.Pe(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_margin, this.paR.ens()));
        this.paR.P(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginTop, this.paR.ent()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginBottom, this.paR.enu()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginLeft, this.paR.env()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginRight, this.paR.enw()));
        this.paR.setRadius(obtainStyledAttributes.getInt(a.j.SwitchButton_kswRadius, b.a.DEFAULT_RADIUS));
        this.paR.dT(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_width, -1), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_height, -1));
        this.paR.bz(obtainStyledAttributes.getFloat(a.j.SwitchButton_kswMeasureFactor, -1.0f));
        this.paR.Q(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetLeft, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetTop, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetRight, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetBottom, 0));
        this.paW.Pd(obtainStyledAttributes.getInteger(a.j.SwitchButton_kswAnimationVelocity, -1));
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
        this.paR = b.by(getContext().getResources().getDisplayMetrics().density);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.paZ = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.paW = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.enl().a(this.paX);
        this.mBounds = new Rect();
        if (paQ) {
            this.mRectPaint = new Paint();
            this.mRectPaint.setStyle(Paint.Style.STROKE);
        }
    }

    private void c(TypedArray typedArray) {
        if (this.paR != null) {
            this.paR.r(a(typedArray, a.j.SwitchButton_kswOffDrawable, a.j.SwitchButton_kswOffColor, b.a.paI));
            this.paR.s(a(typedArray, a.j.SwitchButton_kswOnDrawable, a.j.SwitchButton_kswOnColor, b.a.paJ));
            this.paR.setThumbDrawable(d(typedArray));
        }
    }

    private Drawable a(TypedArray typedArray, int i, int i2, int i3) {
        Drawable drawable = typedArray.getDrawable(i);
        if (drawable == null) {
            int color = typedArray.getColor(i2, i3);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.paR.getRadius());
            gradientDrawable.setColor(color);
            return gradientDrawable;
        }
        return drawable;
    }

    private Drawable d(TypedArray typedArray) {
        Drawable drawable = typedArray.getDrawable(a.j.SwitchButton_kswThumbDrawable);
        if (drawable == null) {
            int color = typedArray.getColor(a.j.SwitchButton_kswThumbColor, b.a.paK);
            int color2 = typedArray.getColor(a.j.SwitchButton_kswThumbPressedColor, b.a.paL);
            StateListDrawable stateListDrawable = new StateListDrawable();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.paR.getRadius());
            gradientDrawable.setColor(color);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(this.paR.getRadius());
            gradientDrawable2.setColor(color2);
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, gradientDrawable2);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }
        return drawable;
    }

    public b getConfiguration() {
        return this.paR;
    }

    public void setConfiguration(b bVar) {
        if (this.paR == null) {
            this.paR = b.by(bVar.getDensity());
        }
        this.paR.r(bVar.eny());
        this.paR.s(bVar.enz());
        this.paR.setThumbDrawable(bVar.enA());
        this.paR.P(bVar.ent(), bVar.enu(), bVar.env(), bVar.enw());
        this.paR.dT(bVar.enI(), bVar.enJ());
        this.paR.Pd(bVar.enx());
        this.paR.bz(bVar.enB());
        this.paW.Pd(this.paR.enx());
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
        enL();
        enK();
        enM();
        enN();
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            this.paV = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
        }
    }

    private void enK() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.paS == null) {
                this.paS = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.paR.env() > 0 ? this.paR.env() : 0);
            int paddingRight = (-this.paR.enF()) + ((measuredWidth - getPaddingRight()) - (this.paR.enw() > 0 ? this.paR.enw() : 0));
            this.paS.set(paddingLeft, (this.paR.ent() > 0 ? this.paR.ent() : 0) + getPaddingTop(), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.paR.enu() > 0 ? this.paR.enu() : 0)) + (-this.paR.enG()));
            this.paY = this.paS.left + (((this.paS.right - this.paS.left) - this.paR.enI()) / 2);
            return;
        }
        this.paS = null;
    }

    private void enL() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.paT == null) {
                this.paT = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.paR.env() > 0 ? 0 : -this.paR.env());
            int paddingRight = (-this.paR.enF()) + ((measuredWidth - getPaddingRight()) - (this.paR.enw() > 0 ? 0 : -this.paR.enw()));
            this.paT.set(paddingLeft, (this.paR.ent() > 0 ? 0 : -this.paR.ent()) + getPaddingTop(), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.paR.enu() <= 0 ? -this.paR.enu() : 0)) + (-this.paR.enG()));
            return;
        }
        this.paT = null;
    }

    private void enM() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.paU == null) {
                this.paU = new Rect();
            }
            int enI = this.mIsChecked ? this.paS.right - this.paR.enI() : this.paS.left;
            int i = this.paS.top;
            this.paU.set(enI, i, this.paR.enI() + enI, this.paR.enJ() + i);
            return;
        }
        this.paU = null;
    }

    private void enN() {
        if (this.paT != null) {
            this.paR.enq().setBounds(this.paT);
            this.paR.enr().setBounds(this.paT);
        }
        if (this.paU != null) {
            this.paR.getThumbDrawable().setBounds(this.paU);
        }
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int enI = (int) ((this.paR.enI() * this.paR.enB()) + getPaddingLeft() + getPaddingRight());
        int env = this.paR.env() + this.paR.enw();
        if (env > 0) {
            enI += env;
        }
        if (mode == 1073741824) {
            enI = Math.max(size, enI);
        } else if (mode == Integer.MIN_VALUE) {
            enI = Math.min(size, enI);
        }
        return enI + this.paR.enC().left + this.paR.enC().right;
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int enJ = this.paR.enJ() + getPaddingTop() + getPaddingBottom();
        int ent = this.paR.ent() + this.paR.enu();
        if (ent > 0) {
            enJ += ent;
        }
        if (mode == 1073741824) {
            enJ = Math.max(size, enJ);
        } else if (mode == Integer.MIN_VALUE) {
            enJ = Math.min(size, enJ);
        }
        return enJ + this.paR.enC().top + this.paR.enC().bottom;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mBounds);
        if (this.mBounds != null && this.paR.enH()) {
            this.mBounds.inset(this.paR.enD(), this.paR.enE());
            canvas.clipRect(this.mBounds, Region.Op.REPLACE);
            canvas.translate(this.paR.enC().left, this.paR.enC().top);
        }
        boolean z = !isEnabled() && enO();
        if (z) {
            canvas.saveLayerAlpha(this.paV, 127, 31);
        }
        if (this.paR.enr() != null) {
            this.paR.enr().draw(canvas);
        }
        if (this.paR.enq() != null) {
            this.paR.enq().setAlpha(enP());
            this.paR.enq().draw(canvas);
        }
        if (this.paR.getThumbDrawable() != null) {
            this.paR.getThumbDrawable().draw(canvas);
        }
        if (z) {
            canvas.restore();
        }
        if (paQ) {
            this.mRectPaint.setColor(Color.parseColor("#AA0000"));
            canvas.drawRect(this.paT, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#00FF00"));
            canvas.drawRect(this.paS, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#0000FF"));
            canvas.drawRect(this.paU, this.mRectPaint);
        }
    }

    private boolean enO() {
        return ((this.paR.getThumbDrawable() instanceof StateListDrawable) && (this.paR.enq() instanceof StateListDrawable) && (this.paR.enr() instanceof StateListDrawable)) ? false : true;
    }

    private int enP() {
        int enI;
        if (this.paS == null || this.paS.right == this.paS.left || (enI = (this.paS.right - this.paR.enI()) - this.paS.left) <= 0) {
            return 255;
        }
        return ((this.paU.left - this.paS.left) * 255) / enI;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isAnimating || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX() - this.dyT;
        float y = motionEvent.getY() - this.bNt;
        boolean z = this.mIsChecked;
        switch (action) {
            case 0:
                enQ();
                this.dyT = motionEvent.getX();
                this.bNt = motionEvent.getY();
                this.mLastX = this.dyT;
                setPressed(true);
                break;
            case 1:
            case 3:
                setPressed(false);
                boolean statusBasedOnPos = getStatusBasedOnPos();
                float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                if (x < this.mTouchSlop && y < this.mTouchSlop && eventTime < this.paZ) {
                    performClick();
                    break;
                } else {
                    AH(statusBasedOnPos);
                    break;
                }
                break;
            case 2:
                float x2 = motionEvent.getX();
                Pk((int) (x2 - this.mLastX));
                this.mLastX = x2;
                break;
        }
        invalidate();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getStatusBasedOnPos() {
        return ((float) this.paU.left) > this.paY;
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.mBounds != null && this.paR.enH()) {
            invalidate(this.mBounds);
        } else {
            super.invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    private void enQ() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void setChecked(boolean z, boolean z2) {
        if (this.paU != null) {
            Pk(z ? getMeasuredWidth() : -getMeasuredWidth());
        }
        aI(z, z2);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        setChecked(z, true);
    }

    public void AG(boolean z) {
        if (z) {
            AH(this.mIsChecked ? false : true);
        } else {
            setChecked(this.mIsChecked ? false : true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        AG(true);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.paR != null) {
            setDrawableState(this.paR.getThumbDrawable());
            setDrawableState(this.paR.enq());
            setDrawableState(this.paR.enr());
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
        this.pba = onCheckedChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedInClass(boolean z) {
        aI(z, true);
    }

    private void aI(boolean z, boolean z2) {
        if (this.mIsChecked != z) {
            this.mIsChecked = z;
            refreshDrawableState();
            if (this.pba != null && z2) {
                this.pba.onCheckedChanged(this, this.mIsChecked);
            }
        }
    }

    public void AH(boolean z) {
        if (!this.isAnimating) {
            this.paW.dS(this.paU.left, z ? this.paS.right - this.paR.enI() : this.paS.left);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pk(int i) {
        int i2 = this.paU.left + i;
        int i3 = this.paU.right + i;
        if (i2 < this.paS.left) {
            i2 = this.paS.left;
            i3 = this.paR.enI() + i2;
        }
        if (i3 > this.paS.right) {
            i3 = this.paS.right;
            i2 = i3 - this.paR.enI();
        }
        dU(i2, i3);
    }

    private void dU(int i, int i2) {
        this.paU.set(i, this.paU.top, i2, this.paU.bottom);
        this.paR.getThumbDrawable().setBounds(this.paU);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class a implements a.b {
        a() {
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void onAnimationStart() {
            SwitchButton.this.isAnimating = true;
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public boolean enm() {
            return SwitchButton.this.paU.right < SwitchButton.this.paS.right && SwitchButton.this.paU.left > SwitchButton.this.paS.left;
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void onFrameUpdate(int i) {
            SwitchButton.this.Pk(i);
            SwitchButton.this.postInvalidate();
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void enn() {
            SwitchButton.this.setCheckedInClass(SwitchButton.this.getStatusBasedOnPos());
            SwitchButton.this.isAnimating = false;
        }
    }
}
