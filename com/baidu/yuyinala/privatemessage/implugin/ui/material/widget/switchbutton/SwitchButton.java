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
    private static boolean ouG = false;
    private float byX;
    private float dic;
    private boolean isAnimating;
    private Rect mBounds;
    private boolean mIsChecked;
    private float mLastX;
    private Paint mRectPaint;
    private int mTouchSlop;
    private b ouH;
    private Rect ouI;
    private Rect ouJ;
    private Rect ouK;
    private RectF ouL;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a ouM;
    private a ouN;
    private float ouO;
    private int ouP;
    private CompoundButton.OnCheckedChangeListener ouQ;

    @SuppressLint({"NewApi"})
    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsChecked = false;
        this.ouN = new a();
        this.isAnimating = false;
        this.mBounds = null;
        initView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.SwitchButton);
        this.ouH.Nu(obtainStyledAttributes.getDimensionPixelSize(a.k.SwitchButton_kswThumb_margin, this.ouH.edM()));
        this.ouH.K(obtainStyledAttributes.getDimensionPixelSize(a.k.SwitchButton_kswThumb_marginTop, this.ouH.edN()), obtainStyledAttributes.getDimensionPixelSize(a.k.SwitchButton_kswThumb_marginBottom, this.ouH.edO()), obtainStyledAttributes.getDimensionPixelSize(a.k.SwitchButton_kswThumb_marginLeft, this.ouH.edP()), obtainStyledAttributes.getDimensionPixelSize(a.k.SwitchButton_kswThumb_marginRight, this.ouH.edQ()));
        this.ouH.setRadius(obtainStyledAttributes.getInt(a.k.SwitchButton_kswRadius, b.a.DEFAULT_RADIUS));
        this.ouH.dM(obtainStyledAttributes.getDimensionPixelSize(a.k.SwitchButton_kswThumb_width, -1), obtainStyledAttributes.getDimensionPixelSize(a.k.SwitchButton_kswThumb_height, -1));
        this.ouH.be(obtainStyledAttributes.getFloat(a.k.SwitchButton_kswMeasureFactor, -1.0f));
        this.ouH.L(obtainStyledAttributes.getDimensionPixelSize(a.k.SwitchButton_kswInsetLeft, 0), obtainStyledAttributes.getDimensionPixelSize(a.k.SwitchButton_kswInsetTop, 0), obtainStyledAttributes.getDimensionPixelSize(a.k.SwitchButton_kswInsetRight, 0), obtainStyledAttributes.getDimensionPixelSize(a.k.SwitchButton_kswInsetBottom, 0));
        this.ouM.Nt(obtainStyledAttributes.getInteger(a.k.SwitchButton_kswAnimationVelocity, -1));
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
        this.ouH = b.bd(getContext().getResources().getDisplayMetrics().density);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.ouP = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.ouM = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.edF().a(this.ouN);
        this.mBounds = new Rect();
        if (ouG) {
            this.mRectPaint = new Paint();
            this.mRectPaint.setStyle(Paint.Style.STROKE);
        }
    }

    private void c(TypedArray typedArray) {
        if (this.ouH != null) {
            this.ouH.l(a(typedArray, a.k.SwitchButton_kswOffDrawable, a.k.SwitchButton_kswOffColor, b.a.ouy));
            this.ouH.m(a(typedArray, a.k.SwitchButton_kswOnDrawable, a.k.SwitchButton_kswOnColor, b.a.ouz));
            this.ouH.setThumbDrawable(d(typedArray));
        }
    }

    private Drawable a(TypedArray typedArray, int i, int i2, int i3) {
        Drawable drawable = typedArray.getDrawable(i);
        if (drawable == null) {
            int color = typedArray.getColor(i2, i3);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.ouH.getRadius());
            gradientDrawable.setColor(color);
            return gradientDrawable;
        }
        return drawable;
    }

    private Drawable d(TypedArray typedArray) {
        Drawable drawable = typedArray.getDrawable(a.k.SwitchButton_kswThumbDrawable);
        if (drawable == null) {
            int color = typedArray.getColor(a.k.SwitchButton_kswThumbColor, b.a.ouA);
            int color2 = typedArray.getColor(a.k.SwitchButton_kswThumbPressedColor, b.a.ouB);
            StateListDrawable stateListDrawable = new StateListDrawable();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.ouH.getRadius());
            gradientDrawable.setColor(color);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(this.ouH.getRadius());
            gradientDrawable2.setColor(color2);
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, gradientDrawable2);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }
        return drawable;
    }

    public b getConfiguration() {
        return this.ouH;
    }

    public void setConfiguration(b bVar) {
        if (this.ouH == null) {
            this.ouH = b.bd(bVar.getDensity());
        }
        this.ouH.l(bVar.edS());
        this.ouH.m(bVar.edT());
        this.ouH.setThumbDrawable(bVar.edU());
        this.ouH.K(bVar.edN(), bVar.edO(), bVar.edP(), bVar.edQ());
        this.ouH.dM(bVar.eec(), bVar.eed());
        this.ouH.Nt(bVar.edR());
        this.ouH.be(bVar.edV());
        this.ouM.Nt(this.ouH.edR());
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
        eef();
        eee();
        eeg();
        eeh();
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            this.ouL = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
        }
    }

    private void eee() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.ouI == null) {
                this.ouI = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.ouH.edP() > 0 ? this.ouH.edP() : 0);
            int paddingRight = (-this.ouH.edZ()) + ((measuredWidth - getPaddingRight()) - (this.ouH.edQ() > 0 ? this.ouH.edQ() : 0));
            this.ouI.set(paddingLeft, (this.ouH.edN() > 0 ? this.ouH.edN() : 0) + getPaddingTop(), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.ouH.edO() > 0 ? this.ouH.edO() : 0)) + (-this.ouH.eea()));
            this.ouO = this.ouI.left + (((this.ouI.right - this.ouI.left) - this.ouH.eec()) / 2);
            return;
        }
        this.ouI = null;
    }

    private void eef() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.ouJ == null) {
                this.ouJ = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.ouH.edP() > 0 ? 0 : -this.ouH.edP());
            int paddingRight = (-this.ouH.edZ()) + ((measuredWidth - getPaddingRight()) - (this.ouH.edQ() > 0 ? 0 : -this.ouH.edQ()));
            this.ouJ.set(paddingLeft, (this.ouH.edN() > 0 ? 0 : -this.ouH.edN()) + getPaddingTop(), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.ouH.edO() <= 0 ? -this.ouH.edO() : 0)) + (-this.ouH.eea()));
            return;
        }
        this.ouJ = null;
    }

    private void eeg() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.ouK == null) {
                this.ouK = new Rect();
            }
            int eec = this.mIsChecked ? this.ouI.right - this.ouH.eec() : this.ouI.left;
            int i = this.ouI.top;
            this.ouK.set(eec, i, this.ouH.eec() + eec, this.ouH.eed() + i);
            return;
        }
        this.ouK = null;
    }

    private void eeh() {
        if (this.ouJ != null) {
            this.ouH.edK().setBounds(this.ouJ);
            this.ouH.edL().setBounds(this.ouJ);
        }
        if (this.ouK != null) {
            this.ouH.getThumbDrawable().setBounds(this.ouK);
        }
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int eec = (int) ((this.ouH.eec() * this.ouH.edV()) + getPaddingLeft() + getPaddingRight());
        int edP = this.ouH.edP() + this.ouH.edQ();
        if (edP > 0) {
            eec += edP;
        }
        if (mode == 1073741824) {
            eec = Math.max(size, eec);
        } else if (mode == Integer.MIN_VALUE) {
            eec = Math.min(size, eec);
        }
        return eec + this.ouH.edW().left + this.ouH.edW().right;
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int eed = this.ouH.eed() + getPaddingTop() + getPaddingBottom();
        int edN = this.ouH.edN() + this.ouH.edO();
        if (edN > 0) {
            eed += edN;
        }
        if (mode == 1073741824) {
            eed = Math.max(size, eed);
        } else if (mode == Integer.MIN_VALUE) {
            eed = Math.min(size, eed);
        }
        return eed + this.ouH.edW().top + this.ouH.edW().bottom;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mBounds);
        if (this.mBounds != null && this.ouH.eeb()) {
            this.mBounds.inset(this.ouH.edX(), this.ouH.edY());
            canvas.clipRect(this.mBounds, Region.Op.REPLACE);
            canvas.translate(this.ouH.edW().left, this.ouH.edW().top);
        }
        boolean z = !isEnabled() && eei();
        if (z) {
            canvas.saveLayerAlpha(this.ouL, 127, 31);
        }
        if (this.ouH.edL() != null) {
            this.ouH.edL().draw(canvas);
        }
        if (this.ouH.edK() != null) {
            this.ouH.edK().setAlpha(eej());
            this.ouH.edK().draw(canvas);
        }
        if (this.ouH.getThumbDrawable() != null) {
            this.ouH.getThumbDrawable().draw(canvas);
        }
        if (z) {
            canvas.restore();
        }
        if (ouG) {
            this.mRectPaint.setColor(Color.parseColor("#AA0000"));
            canvas.drawRect(this.ouJ, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#00FF00"));
            canvas.drawRect(this.ouI, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#0000FF"));
            canvas.drawRect(this.ouK, this.mRectPaint);
        }
    }

    private boolean eei() {
        return ((this.ouH.getThumbDrawable() instanceof StateListDrawable) && (this.ouH.edK() instanceof StateListDrawable) && (this.ouH.edL() instanceof StateListDrawable)) ? false : true;
    }

    private int eej() {
        int eec;
        if (this.ouI == null || this.ouI.right == this.ouI.left || (eec = (this.ouI.right - this.ouH.eec()) - this.ouI.left) <= 0) {
            return 255;
        }
        return ((this.ouK.left - this.ouI.left) * 255) / eec;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isAnimating || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX() - this.dic;
        float y = motionEvent.getY() - this.byX;
        boolean z = this.mIsChecked;
        switch (action) {
            case 0:
                eek();
                this.dic = motionEvent.getX();
                this.byX = motionEvent.getY();
                this.mLastX = this.dic;
                setPressed(true);
                break;
            case 1:
            case 3:
                setPressed(false);
                boolean statusBasedOnPos = getStatusBasedOnPos();
                float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                if (x < this.mTouchSlop && y < this.mTouchSlop && eventTime < this.ouP) {
                    performClick();
                    break;
                } else {
                    zL(statusBasedOnPos);
                    break;
                }
                break;
            case 2:
                float x2 = motionEvent.getX();
                NA((int) (x2 - this.mLastX));
                this.mLastX = x2;
                break;
        }
        invalidate();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getStatusBasedOnPos() {
        return ((float) this.ouK.left) > this.ouO;
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.mBounds != null && this.ouH.eeb()) {
            invalidate(this.mBounds);
        } else {
            super.invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    private void eek() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void setChecked(boolean z, boolean z2) {
        if (this.ouK != null) {
            NA(z ? getMeasuredWidth() : -getMeasuredWidth());
        }
        aG(z, z2);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        setChecked(z, true);
    }

    public void zK(boolean z) {
        if (z) {
            zL(this.mIsChecked ? false : true);
        } else {
            setChecked(this.mIsChecked ? false : true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        zK(true);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.ouH != null) {
            setDrawableState(this.ouH.getThumbDrawable());
            setDrawableState(this.ouH.edK());
            setDrawableState(this.ouH.edL());
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
        this.ouQ = onCheckedChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedInClass(boolean z) {
        aG(z, true);
    }

    private void aG(boolean z, boolean z2) {
        if (this.mIsChecked != z) {
            this.mIsChecked = z;
            refreshDrawableState();
            if (this.ouQ != null && z2) {
                this.ouQ.onCheckedChanged(this, this.mIsChecked);
            }
        }
    }

    public void zL(boolean z) {
        if (!this.isAnimating) {
            this.ouM.dL(this.ouK.left, z ? this.ouI.right - this.ouH.eec() : this.ouI.left);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NA(int i) {
        int i2 = this.ouK.left + i;
        int i3 = this.ouK.right + i;
        if (i2 < this.ouI.left) {
            i2 = this.ouI.left;
            i3 = this.ouH.eec() + i2;
        }
        if (i3 > this.ouI.right) {
            i3 = this.ouI.right;
            i2 = i3 - this.ouH.eec();
        }
        dN(i2, i3);
    }

    private void dN(int i, int i2) {
        this.ouK.set(i, this.ouK.top, i2, this.ouK.bottom);
        this.ouH.getThumbDrawable().setBounds(this.ouK);
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
        public boolean edG() {
            return SwitchButton.this.ouK.right < SwitchButton.this.ouI.right && SwitchButton.this.ouK.left > SwitchButton.this.ouI.left;
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void onFrameUpdate(int i) {
            SwitchButton.this.NA(i);
            SwitchButton.this.postInvalidate();
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void edH() {
            SwitchButton.this.setCheckedInClass(SwitchButton.this.getStatusBasedOnPos());
            SwitchButton.this.isAnimating = false;
        }
    }
}
