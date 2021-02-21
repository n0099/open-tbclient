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
import com.thunder.livesdk.system.ThunderNetStateService;
/* loaded from: classes11.dex */
public class SwitchButton extends CompoundButton {
    private static boolean pha = false;
    private float bMr;
    private float dwp;
    private boolean isAnimating;
    private Rect mBounds;
    private boolean mIsChecked;
    private float mLastX;
    private Paint mRectPaint;
    private int mTouchSlop;
    private b phb;
    private Rect phc;
    private Rect phd;
    private Rect phe;
    private RectF phf;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a phg;
    private a phh;
    private float phi;
    private int phj;
    private CompoundButton.OnCheckedChangeListener phk;

    @SuppressLint({"NewApi"})
    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsChecked = false;
        this.phh = new a();
        this.isAnimating = false;
        this.mBounds = null;
        initView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.SwitchButton);
        this.phb.NT(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_margin, this.phb.elZ()));
        this.phb.N(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginTop, this.phb.ema()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginBottom, this.phb.emb()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginLeft, this.phb.emc()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginRight, this.phb.emd()));
        this.phb.setRadius(obtainStyledAttributes.getInt(a.j.SwitchButton_kswRadius, b.a.DEFAULT_RADIUS));
        this.phb.dR(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_width, -1), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_height, -1));
        this.phb.bC(obtainStyledAttributes.getFloat(a.j.SwitchButton_kswMeasureFactor, -1.0f));
        this.phb.O(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetLeft, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetTop, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetRight, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetBottom, 0));
        this.phg.NS(obtainStyledAttributes.getInteger(a.j.SwitchButton_kswAnimationVelocity, -1));
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
        this.phb = b.bB(getContext().getResources().getDisplayMetrics().density);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.phj = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.phg = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.elS().a(this.phh);
        this.mBounds = new Rect();
        if (pha) {
            this.mRectPaint = new Paint();
            this.mRectPaint.setStyle(Paint.Style.STROKE);
        }
    }

    private void c(TypedArray typedArray) {
        if (this.phb != null) {
            this.phb.r(a(typedArray, a.j.SwitchButton_kswOffDrawable, a.j.SwitchButton_kswOffColor, b.a.pgS));
            this.phb.s(a(typedArray, a.j.SwitchButton_kswOnDrawable, a.j.SwitchButton_kswOnColor, b.a.pgT));
            this.phb.setThumbDrawable(d(typedArray));
        }
    }

    private Drawable a(TypedArray typedArray, int i, int i2, int i3) {
        Drawable drawable = typedArray.getDrawable(i);
        if (drawable == null) {
            int color = typedArray.getColor(i2, i3);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.phb.getRadius());
            gradientDrawable.setColor(color);
            return gradientDrawable;
        }
        return drawable;
    }

    private Drawable d(TypedArray typedArray) {
        Drawable drawable = typedArray.getDrawable(a.j.SwitchButton_kswThumbDrawable);
        if (drawable == null) {
            int color = typedArray.getColor(a.j.SwitchButton_kswThumbColor, b.a.pgU);
            int color2 = typedArray.getColor(a.j.SwitchButton_kswThumbPressedColor, b.a.pgV);
            StateListDrawable stateListDrawable = new StateListDrawable();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.phb.getRadius());
            gradientDrawable.setColor(color);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(this.phb.getRadius());
            gradientDrawable2.setColor(color2);
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, gradientDrawable2);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }
        return drawable;
    }

    public b getConfiguration() {
        return this.phb;
    }

    public void setConfiguration(b bVar) {
        if (this.phb == null) {
            this.phb = b.bB(bVar.getDensity());
        }
        this.phb.r(bVar.emf());
        this.phb.s(bVar.emg());
        this.phb.setThumbDrawable(bVar.emh());
        this.phb.N(bVar.ema(), bVar.emb(), bVar.emc(), bVar.emd());
        this.phb.dR(bVar.getThumbWidth(), bVar.getThumbHeight());
        this.phb.NS(bVar.eme());
        this.phb.bC(bVar.emi());
        this.phg.NS(this.phb.eme());
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
        emq();
        emp();
        emr();
        ems();
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            this.phf = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
        }
    }

    private void emp() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.phc == null) {
                this.phc = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.phb.emc() > 0 ? this.phb.emc() : 0);
            int paddingRight = (-this.phb.emm()) + ((measuredWidth - getPaddingRight()) - (this.phb.emd() > 0 ? this.phb.emd() : 0));
            this.phc.set(paddingLeft, (this.phb.ema() > 0 ? this.phb.ema() : 0) + getPaddingTop(), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.phb.emb() > 0 ? this.phb.emb() : 0)) + (-this.phb.emn()));
            this.phi = this.phc.left + (((this.phc.right - this.phc.left) - this.phb.getThumbWidth()) / 2);
            return;
        }
        this.phc = null;
    }

    private void emq() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.phd == null) {
                this.phd = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.phb.emc() > 0 ? 0 : -this.phb.emc());
            int paddingRight = (-this.phb.emm()) + ((measuredWidth - getPaddingRight()) - (this.phb.emd() > 0 ? 0 : -this.phb.emd()));
            this.phd.set(paddingLeft, (this.phb.ema() > 0 ? 0 : -this.phb.ema()) + getPaddingTop(), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.phb.emb() <= 0 ? -this.phb.emb() : 0)) + (-this.phb.emn()));
            return;
        }
        this.phd = null;
    }

    private void emr() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.phe == null) {
                this.phe = new Rect();
            }
            int thumbWidth = this.mIsChecked ? this.phc.right - this.phb.getThumbWidth() : this.phc.left;
            int i = this.phc.top;
            this.phe.set(thumbWidth, i, this.phb.getThumbWidth() + thumbWidth, this.phb.getThumbHeight() + i);
            return;
        }
        this.phe = null;
    }

    private void ems() {
        if (this.phd != null) {
            this.phb.elX().setBounds(this.phd);
            this.phb.elY().setBounds(this.phd);
        }
        if (this.phe != null) {
            this.phb.getThumbDrawable().setBounds(this.phe);
        }
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int thumbWidth = (int) ((this.phb.getThumbWidth() * this.phb.emi()) + getPaddingLeft() + getPaddingRight());
        int emc = this.phb.emc() + this.phb.emd();
        if (emc > 0) {
            thumbWidth += emc;
        }
        if (mode == 1073741824) {
            thumbWidth = Math.max(size, thumbWidth);
        } else if (mode == Integer.MIN_VALUE) {
            thumbWidth = Math.min(size, thumbWidth);
        }
        return thumbWidth + this.phb.emj().left + this.phb.emj().right;
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int thumbHeight = this.phb.getThumbHeight() + getPaddingTop() + getPaddingBottom();
        int ema = this.phb.ema() + this.phb.emb();
        if (ema > 0) {
            thumbHeight += ema;
        }
        if (mode == 1073741824) {
            thumbHeight = Math.max(size, thumbHeight);
        } else if (mode == Integer.MIN_VALUE) {
            thumbHeight = Math.min(size, thumbHeight);
        }
        return thumbHeight + this.phb.emj().top + this.phb.emj().bottom;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mBounds);
        if (this.mBounds != null && this.phb.emo()) {
            this.mBounds.inset(this.phb.emk(), this.phb.eml());
            canvas.clipRect(this.mBounds, Region.Op.REPLACE);
            canvas.translate(this.phb.emj().left, this.phb.emj().top);
        }
        boolean z = !isEnabled() && emt();
        if (z) {
            canvas.saveLayerAlpha(this.phf, ThunderNetStateService.NetState.SYSNET_UNKNOWN, 31);
        }
        if (this.phb.elY() != null) {
            this.phb.elY().draw(canvas);
        }
        if (this.phb.elX() != null) {
            this.phb.elX().setAlpha(emu());
            this.phb.elX().draw(canvas);
        }
        if (this.phb.getThumbDrawable() != null) {
            this.phb.getThumbDrawable().draw(canvas);
        }
        if (z) {
            canvas.restore();
        }
        if (pha) {
            this.mRectPaint.setColor(Color.parseColor("#AA0000"));
            canvas.drawRect(this.phd, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#00FF00"));
            canvas.drawRect(this.phc, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#0000FF"));
            canvas.drawRect(this.phe, this.mRectPaint);
        }
    }

    private boolean emt() {
        return ((this.phb.getThumbDrawable() instanceof StateListDrawable) && (this.phb.elX() instanceof StateListDrawable) && (this.phb.elY() instanceof StateListDrawable)) ? false : true;
    }

    private int emu() {
        int thumbWidth;
        if (this.phc == null || this.phc.right == this.phc.left || (thumbWidth = (this.phc.right - this.phb.getThumbWidth()) - this.phc.left) <= 0) {
            return 255;
        }
        return ((this.phe.left - this.phc.left) * 255) / thumbWidth;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isAnimating || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX() - this.dwp;
        float y = motionEvent.getY() - this.bMr;
        boolean z = this.mIsChecked;
        switch (action) {
            case 0:
                emv();
                this.dwp = motionEvent.getX();
                this.bMr = motionEvent.getY();
                this.mLastX = this.dwp;
                setPressed(true);
                break;
            case 1:
            case 3:
                setPressed(false);
                boolean statusBasedOnPos = getStatusBasedOnPos();
                float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                if (x < this.mTouchSlop && y < this.mTouchSlop && eventTime < this.phj) {
                    performClick();
                    break;
                } else {
                    AW(statusBasedOnPos);
                    break;
                }
                break;
            case 2:
                float x2 = motionEvent.getX();
                NZ((int) (x2 - this.mLastX));
                this.mLastX = x2;
                break;
        }
        invalidate();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getStatusBasedOnPos() {
        return ((float) this.phe.left) > this.phi;
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.mBounds != null && this.phb.emo()) {
            invalidate(this.mBounds);
        } else {
            super.invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    private void emv() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void setChecked(boolean z, boolean z2) {
        if (this.phe != null) {
            NZ(z ? getMeasuredWidth() : -getMeasuredWidth());
        }
        aI(z, z2);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        setChecked(z, true);
    }

    public void AV(boolean z) {
        if (z) {
            AW(this.mIsChecked ? false : true);
        } else {
            setChecked(this.mIsChecked ? false : true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        AV(true);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.phb != null) {
            setDrawableState(this.phb.getThumbDrawable());
            setDrawableState(this.phb.elX());
            setDrawableState(this.phb.elY());
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
        this.phk = onCheckedChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedInClass(boolean z) {
        aI(z, true);
    }

    private void aI(boolean z, boolean z2) {
        if (this.mIsChecked != z) {
            this.mIsChecked = z;
            refreshDrawableState();
            if (this.phk != null && z2) {
                this.phk.onCheckedChanged(this, this.mIsChecked);
            }
        }
    }

    public void AW(boolean z) {
        if (!this.isAnimating) {
            this.phg.dQ(this.phe.left, z ? this.phc.right - this.phb.getThumbWidth() : this.phc.left);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NZ(int i) {
        int i2 = this.phe.left + i;
        int i3 = this.phe.right + i;
        if (i2 < this.phc.left) {
            i2 = this.phc.left;
            i3 = this.phb.getThumbWidth() + i2;
        }
        if (i3 > this.phc.right) {
            i3 = this.phc.right;
            i2 = i3 - this.phb.getThumbWidth();
        }
        dS(i2, i3);
    }

    private void dS(int i, int i2) {
        this.phe.set(i, this.phe.top, i2, this.phe.bottom);
        this.phb.getThumbDrawable().setBounds(this.phe);
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
        public boolean elT() {
            return SwitchButton.this.phe.right < SwitchButton.this.phc.right && SwitchButton.this.phe.left > SwitchButton.this.phc.left;
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void onFrameUpdate(int i) {
            SwitchButton.this.NZ(i);
            SwitchButton.this.postInvalidate();
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void elU() {
            SwitchButton.this.setCheckedInClass(SwitchButton.this.getStatusBasedOnPos());
            SwitchButton.this.isAnimating = false;
        }
    }
}
