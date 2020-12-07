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
    private static boolean oUI = false;
    private float bIF;
    private float dtt;
    private boolean isAnimating;
    private Rect mBounds;
    private boolean mIsChecked;
    private float mLastX;
    private Paint mRectPaint;
    private int mTouchSlop;
    private b oUJ;
    private Rect oUK;
    private Rect oUL;
    private Rect oUM;
    private RectF oUN;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a oUO;
    private a oUP;
    private float oUQ;
    private int oUR;
    private CompoundButton.OnCheckedChangeListener oUS;

    @SuppressLint({"NewApi"})
    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsChecked = false;
        this.oUP = new a();
        this.isAnimating = false;
        this.mBounds = null;
        initView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.SwitchButton);
        this.oUJ.Pq(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_margin, this.oUJ.eno()));
        this.oUJ.P(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginTop, this.oUJ.enp()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginBottom, this.oUJ.enq()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginLeft, this.oUJ.enr()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginRight, this.oUJ.ens()));
        this.oUJ.setRadius(obtainStyledAttributes.getInt(a.j.SwitchButton_kswRadius, b.a.DEFAULT_RADIUS));
        this.oUJ.dV(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_width, -1), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_height, -1));
        this.oUJ.bo(obtainStyledAttributes.getFloat(a.j.SwitchButton_kswMeasureFactor, -1.0f));
        this.oUJ.Q(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetLeft, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetTop, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetRight, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetBottom, 0));
        this.oUO.Pp(obtainStyledAttributes.getInteger(a.j.SwitchButton_kswAnimationVelocity, -1));
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
        this.oUJ = b.bn(getContext().getResources().getDisplayMetrics().density);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.oUR = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.oUO = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.enh().a(this.oUP);
        this.mBounds = new Rect();
        if (oUI) {
            this.mRectPaint = new Paint();
            this.mRectPaint.setStyle(Paint.Style.STROKE);
        }
    }

    private void c(TypedArray typedArray) {
        if (this.oUJ != null) {
            this.oUJ.m(a(typedArray, a.j.SwitchButton_kswOffDrawable, a.j.SwitchButton_kswOffColor, b.a.oUA));
            this.oUJ.n(a(typedArray, a.j.SwitchButton_kswOnDrawable, a.j.SwitchButton_kswOnColor, b.a.oUB));
            this.oUJ.setThumbDrawable(d(typedArray));
        }
    }

    private Drawable a(TypedArray typedArray, int i, int i2, int i3) {
        Drawable drawable = typedArray.getDrawable(i);
        if (drawable == null) {
            int color = typedArray.getColor(i2, i3);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.oUJ.getRadius());
            gradientDrawable.setColor(color);
            return gradientDrawable;
        }
        return drawable;
    }

    private Drawable d(TypedArray typedArray) {
        Drawable drawable = typedArray.getDrawable(a.j.SwitchButton_kswThumbDrawable);
        if (drawable == null) {
            int color = typedArray.getColor(a.j.SwitchButton_kswThumbColor, b.a.oUC);
            int color2 = typedArray.getColor(a.j.SwitchButton_kswThumbPressedColor, b.a.oUD);
            StateListDrawable stateListDrawable = new StateListDrawable();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.oUJ.getRadius());
            gradientDrawable.setColor(color);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(this.oUJ.getRadius());
            gradientDrawable2.setColor(color2);
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, gradientDrawable2);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }
        return drawable;
    }

    public b getConfiguration() {
        return this.oUJ;
    }

    public void setConfiguration(b bVar) {
        if (this.oUJ == null) {
            this.oUJ = b.bn(bVar.getDensity());
        }
        this.oUJ.m(bVar.enu());
        this.oUJ.n(bVar.env());
        this.oUJ.setThumbDrawable(bVar.enw());
        this.oUJ.P(bVar.enp(), bVar.enq(), bVar.enr(), bVar.ens());
        this.oUJ.dV(bVar.enE(), bVar.enF());
        this.oUJ.Pp(bVar.ent());
        this.oUJ.bo(bVar.enx());
        this.oUO.Pp(this.oUJ.ent());
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
        enH();
        enG();
        enI();
        enJ();
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            this.oUN = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
        }
    }

    private void enG() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.oUK == null) {
                this.oUK = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.oUJ.enr() > 0 ? this.oUJ.enr() : 0);
            int paddingRight = (-this.oUJ.enB()) + ((measuredWidth - getPaddingRight()) - (this.oUJ.ens() > 0 ? this.oUJ.ens() : 0));
            this.oUK.set(paddingLeft, (this.oUJ.enp() > 0 ? this.oUJ.enp() : 0) + getPaddingTop(), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.oUJ.enq() > 0 ? this.oUJ.enq() : 0)) + (-this.oUJ.enC()));
            this.oUQ = this.oUK.left + (((this.oUK.right - this.oUK.left) - this.oUJ.enE()) / 2);
            return;
        }
        this.oUK = null;
    }

    private void enH() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.oUL == null) {
                this.oUL = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.oUJ.enr() > 0 ? 0 : -this.oUJ.enr());
            int paddingRight = (-this.oUJ.enB()) + ((measuredWidth - getPaddingRight()) - (this.oUJ.ens() > 0 ? 0 : -this.oUJ.ens()));
            this.oUL.set(paddingLeft, (this.oUJ.enp() > 0 ? 0 : -this.oUJ.enp()) + getPaddingTop(), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.oUJ.enq() <= 0 ? -this.oUJ.enq() : 0)) + (-this.oUJ.enC()));
            return;
        }
        this.oUL = null;
    }

    private void enI() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.oUM == null) {
                this.oUM = new Rect();
            }
            int enE = this.mIsChecked ? this.oUK.right - this.oUJ.enE() : this.oUK.left;
            int i = this.oUK.top;
            this.oUM.set(enE, i, this.oUJ.enE() + enE, this.oUJ.enF() + i);
            return;
        }
        this.oUM = null;
    }

    private void enJ() {
        if (this.oUL != null) {
            this.oUJ.enm().setBounds(this.oUL);
            this.oUJ.enn().setBounds(this.oUL);
        }
        if (this.oUM != null) {
            this.oUJ.getThumbDrawable().setBounds(this.oUM);
        }
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int enE = (int) ((this.oUJ.enE() * this.oUJ.enx()) + getPaddingLeft() + getPaddingRight());
        int enr = this.oUJ.enr() + this.oUJ.ens();
        if (enr > 0) {
            enE += enr;
        }
        if (mode == 1073741824) {
            enE = Math.max(size, enE);
        } else if (mode == Integer.MIN_VALUE) {
            enE = Math.min(size, enE);
        }
        return enE + this.oUJ.eny().left + this.oUJ.eny().right;
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int enF = this.oUJ.enF() + getPaddingTop() + getPaddingBottom();
        int enp = this.oUJ.enp() + this.oUJ.enq();
        if (enp > 0) {
            enF += enp;
        }
        if (mode == 1073741824) {
            enF = Math.max(size, enF);
        } else if (mode == Integer.MIN_VALUE) {
            enF = Math.min(size, enF);
        }
        return enF + this.oUJ.eny().top + this.oUJ.eny().bottom;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mBounds);
        if (this.mBounds != null && this.oUJ.enD()) {
            this.mBounds.inset(this.oUJ.enz(), this.oUJ.enA());
            canvas.clipRect(this.mBounds, Region.Op.REPLACE);
            canvas.translate(this.oUJ.eny().left, this.oUJ.eny().top);
        }
        boolean z = !isEnabled() && enK();
        if (z) {
            canvas.saveLayerAlpha(this.oUN, 127, 31);
        }
        if (this.oUJ.enn() != null) {
            this.oUJ.enn().draw(canvas);
        }
        if (this.oUJ.enm() != null) {
            this.oUJ.enm().setAlpha(enL());
            this.oUJ.enm().draw(canvas);
        }
        if (this.oUJ.getThumbDrawable() != null) {
            this.oUJ.getThumbDrawable().draw(canvas);
        }
        if (z) {
            canvas.restore();
        }
        if (oUI) {
            this.mRectPaint.setColor(Color.parseColor("#AA0000"));
            canvas.drawRect(this.oUL, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#00FF00"));
            canvas.drawRect(this.oUK, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#0000FF"));
            canvas.drawRect(this.oUM, this.mRectPaint);
        }
    }

    private boolean enK() {
        return ((this.oUJ.getThumbDrawable() instanceof StateListDrawable) && (this.oUJ.enm() instanceof StateListDrawable) && (this.oUJ.enn() instanceof StateListDrawable)) ? false : true;
    }

    private int enL() {
        int enE;
        if (this.oUK == null || this.oUK.right == this.oUK.left || (enE = (this.oUK.right - this.oUJ.enE()) - this.oUK.left) <= 0) {
            return 255;
        }
        return ((this.oUM.left - this.oUK.left) * 255) / enE;
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
                enM();
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
                if (x < this.mTouchSlop && y < this.mTouchSlop && eventTime < this.oUR) {
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
        return ((float) this.oUM.left) > this.oUQ;
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.mBounds != null && this.oUJ.enD()) {
            invalidate(this.mBounds);
        } else {
            super.invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    private void enM() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void setChecked(boolean z, boolean z2) {
        if (this.oUM != null) {
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
        if (this.oUJ != null) {
            setDrawableState(this.oUJ.getThumbDrawable());
            setDrawableState(this.oUJ.enm());
            setDrawableState(this.oUJ.enn());
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
        this.oUS = onCheckedChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedInClass(boolean z) {
        aF(z, true);
    }

    private void aF(boolean z, boolean z2) {
        if (this.mIsChecked != z) {
            this.mIsChecked = z;
            refreshDrawableState();
            if (this.oUS != null && z2) {
                this.oUS.onCheckedChanged(this, this.mIsChecked);
            }
        }
    }

    public void AH(boolean z) {
        if (!this.isAnimating) {
            this.oUO.dU(this.oUM.left, z ? this.oUK.right - this.oUJ.enE() : this.oUK.left);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pw(int i) {
        int i2 = this.oUM.left + i;
        int i3 = this.oUM.right + i;
        if (i2 < this.oUK.left) {
            i2 = this.oUK.left;
            i3 = this.oUJ.enE() + i2;
        }
        if (i3 > this.oUK.right) {
            i3 = this.oUK.right;
            i2 = i3 - this.oUJ.enE();
        }
        dW(i2, i3);
    }

    private void dW(int i, int i2) {
        this.oUM.set(i, this.oUM.top, i2, this.oUM.bottom);
        this.oUJ.getThumbDrawable().setBounds(this.oUM);
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
        public boolean eni() {
            return SwitchButton.this.oUM.right < SwitchButton.this.oUK.right && SwitchButton.this.oUM.left > SwitchButton.this.oUK.left;
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void onFrameUpdate(int i) {
            SwitchButton.this.Pw(i);
            SwitchButton.this.postInvalidate();
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void enj() {
            SwitchButton.this.setCheckedInClass(SwitchButton.this.getStatusBasedOnPos());
            SwitchButton.this.isAnimating = false;
        }
    }
}
