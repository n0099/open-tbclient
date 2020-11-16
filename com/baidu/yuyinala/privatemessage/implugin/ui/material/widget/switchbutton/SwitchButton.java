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
    private static boolean oFC = false;
    private float bDx;
    private float dmq;
    private boolean isAnimating;
    private Rect mBounds;
    private boolean mIsChecked;
    private float mLastX;
    private Paint mRectPaint;
    private int mTouchSlop;
    private b oFD;
    private Rect oFE;
    private Rect oFF;
    private Rect oFG;
    private RectF oFH;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a oFI;
    private a oFJ;
    private float oFK;
    private int oFL;
    private CompoundButton.OnCheckedChangeListener oFM;

    @SuppressLint({"NewApi"})
    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsChecked = false;
        this.oFJ = new a();
        this.isAnimating = false;
        this.mBounds = null;
        initView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.SwitchButton);
        this.oFD.Os(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_margin, this.oFD.ehz()));
        this.oFD.L(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginTop, this.oFD.ehA()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginBottom, this.oFD.ehB()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginLeft, this.oFD.ehC()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginRight, this.oFD.ehD()));
        this.oFD.setRadius(obtainStyledAttributes.getInt(a.j.SwitchButton_kswRadius, b.a.DEFAULT_RADIUS));
        this.oFD.dQ(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_width, -1), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_height, -1));
        this.oFD.bn(obtainStyledAttributes.getFloat(a.j.SwitchButton_kswMeasureFactor, -1.0f));
        this.oFD.M(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetLeft, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetTop, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetRight, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetBottom, 0));
        this.oFI.Or(obtainStyledAttributes.getInteger(a.j.SwitchButton_kswAnimationVelocity, -1));
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
        this.oFD = b.bm(getContext().getResources().getDisplayMetrics().density);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.oFL = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.oFI = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.ehs().a(this.oFJ);
        this.mBounds = new Rect();
        if (oFC) {
            this.mRectPaint = new Paint();
            this.mRectPaint.setStyle(Paint.Style.STROKE);
        }
    }

    private void c(TypedArray typedArray) {
        if (this.oFD != null) {
            this.oFD.m(a(typedArray, a.j.SwitchButton_kswOffDrawable, a.j.SwitchButton_kswOffColor, b.a.oFu));
            this.oFD.n(a(typedArray, a.j.SwitchButton_kswOnDrawable, a.j.SwitchButton_kswOnColor, b.a.oFv));
            this.oFD.setThumbDrawable(d(typedArray));
        }
    }

    private Drawable a(TypedArray typedArray, int i, int i2, int i3) {
        Drawable drawable = typedArray.getDrawable(i);
        if (drawable == null) {
            int color = typedArray.getColor(i2, i3);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.oFD.getRadius());
            gradientDrawable.setColor(color);
            return gradientDrawable;
        }
        return drawable;
    }

    private Drawable d(TypedArray typedArray) {
        Drawable drawable = typedArray.getDrawable(a.j.SwitchButton_kswThumbDrawable);
        if (drawable == null) {
            int color = typedArray.getColor(a.j.SwitchButton_kswThumbColor, b.a.oFw);
            int color2 = typedArray.getColor(a.j.SwitchButton_kswThumbPressedColor, b.a.oFx);
            StateListDrawable stateListDrawable = new StateListDrawable();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.oFD.getRadius());
            gradientDrawable.setColor(color);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(this.oFD.getRadius());
            gradientDrawable2.setColor(color2);
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, gradientDrawable2);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }
        return drawable;
    }

    public b getConfiguration() {
        return this.oFD;
    }

    public void setConfiguration(b bVar) {
        if (this.oFD == null) {
            this.oFD = b.bm(bVar.getDensity());
        }
        this.oFD.m(bVar.ehF());
        this.oFD.n(bVar.ehG());
        this.oFD.setThumbDrawable(bVar.ehH());
        this.oFD.L(bVar.ehA(), bVar.ehB(), bVar.ehC(), bVar.ehD());
        this.oFD.dQ(bVar.ehP(), bVar.ehQ());
        this.oFD.Or(bVar.ehE());
        this.oFD.bn(bVar.ehI());
        this.oFI.Or(this.oFD.ehE());
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
        ehS();
        ehR();
        ehT();
        ehU();
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            this.oFH = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
        }
    }

    private void ehR() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.oFE == null) {
                this.oFE = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.oFD.ehC() > 0 ? this.oFD.ehC() : 0);
            int paddingRight = (-this.oFD.ehM()) + ((measuredWidth - getPaddingRight()) - (this.oFD.ehD() > 0 ? this.oFD.ehD() : 0));
            this.oFE.set(paddingLeft, (this.oFD.ehA() > 0 ? this.oFD.ehA() : 0) + getPaddingTop(), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.oFD.ehB() > 0 ? this.oFD.ehB() : 0)) + (-this.oFD.ehN()));
            this.oFK = this.oFE.left + (((this.oFE.right - this.oFE.left) - this.oFD.ehP()) / 2);
            return;
        }
        this.oFE = null;
    }

    private void ehS() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.oFF == null) {
                this.oFF = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.oFD.ehC() > 0 ? 0 : -this.oFD.ehC());
            int paddingRight = (-this.oFD.ehM()) + ((measuredWidth - getPaddingRight()) - (this.oFD.ehD() > 0 ? 0 : -this.oFD.ehD()));
            this.oFF.set(paddingLeft, (this.oFD.ehA() > 0 ? 0 : -this.oFD.ehA()) + getPaddingTop(), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.oFD.ehB() <= 0 ? -this.oFD.ehB() : 0)) + (-this.oFD.ehN()));
            return;
        }
        this.oFF = null;
    }

    private void ehT() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.oFG == null) {
                this.oFG = new Rect();
            }
            int ehP = this.mIsChecked ? this.oFE.right - this.oFD.ehP() : this.oFE.left;
            int i = this.oFE.top;
            this.oFG.set(ehP, i, this.oFD.ehP() + ehP, this.oFD.ehQ() + i);
            return;
        }
        this.oFG = null;
    }

    private void ehU() {
        if (this.oFF != null) {
            this.oFD.ehx().setBounds(this.oFF);
            this.oFD.ehy().setBounds(this.oFF);
        }
        if (this.oFG != null) {
            this.oFD.getThumbDrawable().setBounds(this.oFG);
        }
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int ehP = (int) ((this.oFD.ehP() * this.oFD.ehI()) + getPaddingLeft() + getPaddingRight());
        int ehC = this.oFD.ehC() + this.oFD.ehD();
        if (ehC > 0) {
            ehP += ehC;
        }
        if (mode == 1073741824) {
            ehP = Math.max(size, ehP);
        } else if (mode == Integer.MIN_VALUE) {
            ehP = Math.min(size, ehP);
        }
        return ehP + this.oFD.ehJ().left + this.oFD.ehJ().right;
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int ehQ = this.oFD.ehQ() + getPaddingTop() + getPaddingBottom();
        int ehA = this.oFD.ehA() + this.oFD.ehB();
        if (ehA > 0) {
            ehQ += ehA;
        }
        if (mode == 1073741824) {
            ehQ = Math.max(size, ehQ);
        } else if (mode == Integer.MIN_VALUE) {
            ehQ = Math.min(size, ehQ);
        }
        return ehQ + this.oFD.ehJ().top + this.oFD.ehJ().bottom;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mBounds);
        if (this.mBounds != null && this.oFD.ehO()) {
            this.mBounds.inset(this.oFD.ehK(), this.oFD.ehL());
            canvas.clipRect(this.mBounds, Region.Op.REPLACE);
            canvas.translate(this.oFD.ehJ().left, this.oFD.ehJ().top);
        }
        boolean z = !isEnabled() && ehV();
        if (z) {
            canvas.saveLayerAlpha(this.oFH, 127, 31);
        }
        if (this.oFD.ehy() != null) {
            this.oFD.ehy().draw(canvas);
        }
        if (this.oFD.ehx() != null) {
            this.oFD.ehx().setAlpha(ehW());
            this.oFD.ehx().draw(canvas);
        }
        if (this.oFD.getThumbDrawable() != null) {
            this.oFD.getThumbDrawable().draw(canvas);
        }
        if (z) {
            canvas.restore();
        }
        if (oFC) {
            this.mRectPaint.setColor(Color.parseColor("#AA0000"));
            canvas.drawRect(this.oFF, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#00FF00"));
            canvas.drawRect(this.oFE, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#0000FF"));
            canvas.drawRect(this.oFG, this.mRectPaint);
        }
    }

    private boolean ehV() {
        return ((this.oFD.getThumbDrawable() instanceof StateListDrawable) && (this.oFD.ehx() instanceof StateListDrawable) && (this.oFD.ehy() instanceof StateListDrawable)) ? false : true;
    }

    private int ehW() {
        int ehP;
        if (this.oFE == null || this.oFE.right == this.oFE.left || (ehP = (this.oFE.right - this.oFD.ehP()) - this.oFE.left) <= 0) {
            return 255;
        }
        return ((this.oFG.left - this.oFE.left) * 255) / ehP;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isAnimating || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX() - this.dmq;
        float y = motionEvent.getY() - this.bDx;
        boolean z = this.mIsChecked;
        switch (action) {
            case 0:
                ehX();
                this.dmq = motionEvent.getX();
                this.bDx = motionEvent.getY();
                this.mLastX = this.dmq;
                setPressed(true);
                break;
            case 1:
            case 3:
                setPressed(false);
                boolean statusBasedOnPos = getStatusBasedOnPos();
                float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                if (x < this.mTouchSlop && y < this.mTouchSlop && eventTime < this.oFL) {
                    performClick();
                    break;
                } else {
                    Ad(statusBasedOnPos);
                    break;
                }
                break;
            case 2:
                float x2 = motionEvent.getX();
                Oy((int) (x2 - this.mLastX));
                this.mLastX = x2;
                break;
        }
        invalidate();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getStatusBasedOnPos() {
        return ((float) this.oFG.left) > this.oFK;
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.mBounds != null && this.oFD.ehO()) {
            invalidate(this.mBounds);
        } else {
            super.invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    private void ehX() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void setChecked(boolean z, boolean z2) {
        if (this.oFG != null) {
            Oy(z ? getMeasuredWidth() : -getMeasuredWidth());
        }
        aE(z, z2);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        setChecked(z, true);
    }

    public void Ac(boolean z) {
        if (z) {
            Ad(this.mIsChecked ? false : true);
        } else {
            setChecked(this.mIsChecked ? false : true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        Ac(true);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.oFD != null) {
            setDrawableState(this.oFD.getThumbDrawable());
            setDrawableState(this.oFD.ehx());
            setDrawableState(this.oFD.ehy());
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
        this.oFM = onCheckedChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedInClass(boolean z) {
        aE(z, true);
    }

    private void aE(boolean z, boolean z2) {
        if (this.mIsChecked != z) {
            this.mIsChecked = z;
            refreshDrawableState();
            if (this.oFM != null && z2) {
                this.oFM.onCheckedChanged(this, this.mIsChecked);
            }
        }
    }

    public void Ad(boolean z) {
        if (!this.isAnimating) {
            this.oFI.dP(this.oFG.left, z ? this.oFE.right - this.oFD.ehP() : this.oFE.left);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oy(int i) {
        int i2 = this.oFG.left + i;
        int i3 = this.oFG.right + i;
        if (i2 < this.oFE.left) {
            i2 = this.oFE.left;
            i3 = this.oFD.ehP() + i2;
        }
        if (i3 > this.oFE.right) {
            i3 = this.oFE.right;
            i2 = i3 - this.oFD.ehP();
        }
        dR(i2, i3);
    }

    private void dR(int i, int i2) {
        this.oFG.set(i, this.oFG.top, i2, this.oFG.bottom);
        this.oFD.getThumbDrawable().setBounds(this.oFG);
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
        public boolean eht() {
            return SwitchButton.this.oFG.right < SwitchButton.this.oFE.right && SwitchButton.this.oFG.left > SwitchButton.this.oFE.left;
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void onFrameUpdate(int i) {
            SwitchButton.this.Oy(i);
            SwitchButton.this.postInvalidate();
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void ehu() {
            SwitchButton.this.setCheckedInClass(SwitchButton.this.getStatusBasedOnPos());
            SwitchButton.this.isAnimating = false;
        }
    }
}
