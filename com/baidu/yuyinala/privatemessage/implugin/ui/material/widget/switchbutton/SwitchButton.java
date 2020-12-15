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
    private static boolean oUK = false;
    private float bIF;
    private float dtt;
    private boolean isAnimating;
    private Rect mBounds;
    private boolean mIsChecked;
    private float mLastX;
    private Paint mRectPaint;
    private int mTouchSlop;
    private b oUL;
    private Rect oUM;
    private Rect oUN;
    private Rect oUO;
    private RectF oUP;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a oUQ;
    private a oUR;
    private float oUS;
    private int oUT;
    private CompoundButton.OnCheckedChangeListener oUU;

    @SuppressLint({"NewApi"})
    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsChecked = false;
        this.oUR = new a();
        this.isAnimating = false;
        this.mBounds = null;
        initView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.SwitchButton);
        this.oUL.Pq(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_margin, this.oUL.enp()));
        this.oUL.P(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginTop, this.oUL.enq()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginBottom, this.oUL.enr()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginLeft, this.oUL.ens()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginRight, this.oUL.ent()));
        this.oUL.setRadius(obtainStyledAttributes.getInt(a.j.SwitchButton_kswRadius, b.a.DEFAULT_RADIUS));
        this.oUL.dV(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_width, -1), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_height, -1));
        this.oUL.bo(obtainStyledAttributes.getFloat(a.j.SwitchButton_kswMeasureFactor, -1.0f));
        this.oUL.Q(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetLeft, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetTop, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetRight, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetBottom, 0));
        this.oUQ.Pp(obtainStyledAttributes.getInteger(a.j.SwitchButton_kswAnimationVelocity, -1));
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
        this.oUL = b.bn(getContext().getResources().getDisplayMetrics().density);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.oUT = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.oUQ = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.eni().a(this.oUR);
        this.mBounds = new Rect();
        if (oUK) {
            this.mRectPaint = new Paint();
            this.mRectPaint.setStyle(Paint.Style.STROKE);
        }
    }

    private void c(TypedArray typedArray) {
        if (this.oUL != null) {
            this.oUL.m(a(typedArray, a.j.SwitchButton_kswOffDrawable, a.j.SwitchButton_kswOffColor, b.a.oUC));
            this.oUL.n(a(typedArray, a.j.SwitchButton_kswOnDrawable, a.j.SwitchButton_kswOnColor, b.a.oUD));
            this.oUL.setThumbDrawable(d(typedArray));
        }
    }

    private Drawable a(TypedArray typedArray, int i, int i2, int i3) {
        Drawable drawable = typedArray.getDrawable(i);
        if (drawable == null) {
            int color = typedArray.getColor(i2, i3);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.oUL.getRadius());
            gradientDrawable.setColor(color);
            return gradientDrawable;
        }
        return drawable;
    }

    private Drawable d(TypedArray typedArray) {
        Drawable drawable = typedArray.getDrawable(a.j.SwitchButton_kswThumbDrawable);
        if (drawable == null) {
            int color = typedArray.getColor(a.j.SwitchButton_kswThumbColor, b.a.oUE);
            int color2 = typedArray.getColor(a.j.SwitchButton_kswThumbPressedColor, b.a.oUF);
            StateListDrawable stateListDrawable = new StateListDrawable();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.oUL.getRadius());
            gradientDrawable.setColor(color);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(this.oUL.getRadius());
            gradientDrawable2.setColor(color2);
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, gradientDrawable2);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }
        return drawable;
    }

    public b getConfiguration() {
        return this.oUL;
    }

    public void setConfiguration(b bVar) {
        if (this.oUL == null) {
            this.oUL = b.bn(bVar.getDensity());
        }
        this.oUL.m(bVar.env());
        this.oUL.n(bVar.enw());
        this.oUL.setThumbDrawable(bVar.enx());
        this.oUL.P(bVar.enq(), bVar.enr(), bVar.ens(), bVar.ent());
        this.oUL.dV(bVar.enF(), bVar.enG());
        this.oUL.Pp(bVar.enu());
        this.oUL.bo(bVar.eny());
        this.oUQ.Pp(this.oUL.enu());
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
        enI();
        enH();
        enJ();
        enK();
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            this.oUP = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
        }
    }

    private void enH() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.oUM == null) {
                this.oUM = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.oUL.ens() > 0 ? this.oUL.ens() : 0);
            int paddingRight = (-this.oUL.enC()) + ((measuredWidth - getPaddingRight()) - (this.oUL.ent() > 0 ? this.oUL.ent() : 0));
            this.oUM.set(paddingLeft, (this.oUL.enq() > 0 ? this.oUL.enq() : 0) + getPaddingTop(), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.oUL.enr() > 0 ? this.oUL.enr() : 0)) + (-this.oUL.enD()));
            this.oUS = this.oUM.left + (((this.oUM.right - this.oUM.left) - this.oUL.enF()) / 2);
            return;
        }
        this.oUM = null;
    }

    private void enI() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.oUN == null) {
                this.oUN = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.oUL.ens() > 0 ? 0 : -this.oUL.ens());
            int paddingRight = (-this.oUL.enC()) + ((measuredWidth - getPaddingRight()) - (this.oUL.ent() > 0 ? 0 : -this.oUL.ent()));
            this.oUN.set(paddingLeft, (this.oUL.enq() > 0 ? 0 : -this.oUL.enq()) + getPaddingTop(), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.oUL.enr() <= 0 ? -this.oUL.enr() : 0)) + (-this.oUL.enD()));
            return;
        }
        this.oUN = null;
    }

    private void enJ() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.oUO == null) {
                this.oUO = new Rect();
            }
            int enF = this.mIsChecked ? this.oUM.right - this.oUL.enF() : this.oUM.left;
            int i = this.oUM.top;
            this.oUO.set(enF, i, this.oUL.enF() + enF, this.oUL.enG() + i);
            return;
        }
        this.oUO = null;
    }

    private void enK() {
        if (this.oUN != null) {
            this.oUL.enn().setBounds(this.oUN);
            this.oUL.eno().setBounds(this.oUN);
        }
        if (this.oUO != null) {
            this.oUL.getThumbDrawable().setBounds(this.oUO);
        }
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int enF = (int) ((this.oUL.enF() * this.oUL.eny()) + getPaddingLeft() + getPaddingRight());
        int ens = this.oUL.ens() + this.oUL.ent();
        if (ens > 0) {
            enF += ens;
        }
        if (mode == 1073741824) {
            enF = Math.max(size, enF);
        } else if (mode == Integer.MIN_VALUE) {
            enF = Math.min(size, enF);
        }
        return enF + this.oUL.enz().left + this.oUL.enz().right;
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int enG = this.oUL.enG() + getPaddingTop() + getPaddingBottom();
        int enq = this.oUL.enq() + this.oUL.enr();
        if (enq > 0) {
            enG += enq;
        }
        if (mode == 1073741824) {
            enG = Math.max(size, enG);
        } else if (mode == Integer.MIN_VALUE) {
            enG = Math.min(size, enG);
        }
        return enG + this.oUL.enz().top + this.oUL.enz().bottom;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mBounds);
        if (this.mBounds != null && this.oUL.enE()) {
            this.mBounds.inset(this.oUL.enA(), this.oUL.enB());
            canvas.clipRect(this.mBounds, Region.Op.REPLACE);
            canvas.translate(this.oUL.enz().left, this.oUL.enz().top);
        }
        boolean z = !isEnabled() && enL();
        if (z) {
            canvas.saveLayerAlpha(this.oUP, 127, 31);
        }
        if (this.oUL.eno() != null) {
            this.oUL.eno().draw(canvas);
        }
        if (this.oUL.enn() != null) {
            this.oUL.enn().setAlpha(enM());
            this.oUL.enn().draw(canvas);
        }
        if (this.oUL.getThumbDrawable() != null) {
            this.oUL.getThumbDrawable().draw(canvas);
        }
        if (z) {
            canvas.restore();
        }
        if (oUK) {
            this.mRectPaint.setColor(Color.parseColor("#AA0000"));
            canvas.drawRect(this.oUN, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#00FF00"));
            canvas.drawRect(this.oUM, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#0000FF"));
            canvas.drawRect(this.oUO, this.mRectPaint);
        }
    }

    private boolean enL() {
        return ((this.oUL.getThumbDrawable() instanceof StateListDrawable) && (this.oUL.enn() instanceof StateListDrawable) && (this.oUL.eno() instanceof StateListDrawable)) ? false : true;
    }

    private int enM() {
        int enF;
        if (this.oUM == null || this.oUM.right == this.oUM.left || (enF = (this.oUM.right - this.oUL.enF()) - this.oUM.left) <= 0) {
            return 255;
        }
        return ((this.oUO.left - this.oUM.left) * 255) / enF;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isAnimating || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX() - this.dtt;
        float y = motionEvent.getY() - this.bIF;
        boolean z = this.mIsChecked;
        switch (action) {
            case 0:
                enN();
                this.dtt = motionEvent.getX();
                this.bIF = motionEvent.getY();
                this.mLastX = this.dtt;
                setPressed(true);
                break;
            case 1:
            case 3:
                setPressed(false);
                boolean statusBasedOnPos = getStatusBasedOnPos();
                float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                if (x < this.mTouchSlop && y < this.mTouchSlop && eventTime < this.oUT) {
                    performClick();
                    break;
                } else {
                    AH(statusBasedOnPos);
                    break;
                }
                break;
            case 2:
                float x2 = motionEvent.getX();
                Pw((int) (x2 - this.mLastX));
                this.mLastX = x2;
                break;
        }
        invalidate();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getStatusBasedOnPos() {
        return ((float) this.oUO.left) > this.oUS;
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.mBounds != null && this.oUL.enE()) {
            invalidate(this.mBounds);
        } else {
            super.invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    private void enN() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void setChecked(boolean z, boolean z2) {
        if (this.oUO != null) {
            Pw(z ? getMeasuredWidth() : -getMeasuredWidth());
        }
        aF(z, z2);
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
        if (this.oUL != null) {
            setDrawableState(this.oUL.getThumbDrawable());
            setDrawableState(this.oUL.enn());
            setDrawableState(this.oUL.eno());
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
        this.oUU = onCheckedChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedInClass(boolean z) {
        aF(z, true);
    }

    private void aF(boolean z, boolean z2) {
        if (this.mIsChecked != z) {
            this.mIsChecked = z;
            refreshDrawableState();
            if (this.oUU != null && z2) {
                this.oUU.onCheckedChanged(this, this.mIsChecked);
            }
        }
    }

    public void AH(boolean z) {
        if (!this.isAnimating) {
            this.oUQ.dU(this.oUO.left, z ? this.oUM.right - this.oUL.enF() : this.oUM.left);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pw(int i) {
        int i2 = this.oUO.left + i;
        int i3 = this.oUO.right + i;
        if (i2 < this.oUM.left) {
            i2 = this.oUM.left;
            i3 = this.oUL.enF() + i2;
        }
        if (i3 > this.oUM.right) {
            i3 = this.oUM.right;
            i2 = i3 - this.oUL.enF();
        }
        dW(i2, i3);
    }

    private void dW(int i, int i2) {
        this.oUO.set(i, this.oUO.top, i2, this.oUO.bottom);
        this.oUL.getThumbDrawable().setBounds(this.oUO);
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
        public boolean enj() {
            return SwitchButton.this.oUO.right < SwitchButton.this.oUM.right && SwitchButton.this.oUO.left > SwitchButton.this.oUM.left;
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void onFrameUpdate(int i) {
            SwitchButton.this.Pw(i);
            SwitchButton.this.postInvalidate();
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void enk() {
            SwitchButton.this.setCheckedInClass(SwitchButton.this.getStatusBasedOnPos());
            SwitchButton.this.isAnimating = false;
        }
    }
}
