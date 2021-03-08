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
/* loaded from: classes10.dex */
public class SwitchButton extends CompoundButton {
    private static boolean pji = false;
    private float bNR;
    private float dxQ;
    private boolean isAnimating;
    private Rect mBounds;
    private boolean mIsChecked;
    private float mLastX;
    private Paint mRectPaint;
    private int mTouchSlop;
    private b pjj;
    private Rect pjk;
    private Rect pjl;
    private Rect pjm;
    private RectF pjn;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a pjo;
    private a pjp;
    private float pjq;
    private int pjr;
    private CompoundButton.OnCheckedChangeListener pjs;

    @SuppressLint({"NewApi"})
    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsChecked = false;
        this.pjp = new a();
        this.isAnimating = false;
        this.mBounds = null;
        initView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.SwitchButton);
        this.pjj.NX(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_margin, this.pjj.emj()));
        this.pjj.N(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginTop, this.pjj.emk()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginBottom, this.pjj.eml()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginLeft, this.pjj.emm()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginRight, this.pjj.emn()));
        this.pjj.setRadius(obtainStyledAttributes.getInt(a.j.SwitchButton_kswRadius, b.a.DEFAULT_RADIUS));
        this.pjj.dR(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_width, -1), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_height, -1));
        this.pjj.bG(obtainStyledAttributes.getFloat(a.j.SwitchButton_kswMeasureFactor, -1.0f));
        this.pjj.O(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetLeft, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetTop, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetRight, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetBottom, 0));
        this.pjo.NW(obtainStyledAttributes.getInteger(a.j.SwitchButton_kswAnimationVelocity, -1));
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
        this.pjj = b.bF(getContext().getResources().getDisplayMetrics().density);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.pjr = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.pjo = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.emc().a(this.pjp);
        this.mBounds = new Rect();
        if (pji) {
            this.mRectPaint = new Paint();
            this.mRectPaint.setStyle(Paint.Style.STROKE);
        }
    }

    private void c(TypedArray typedArray) {
        if (this.pjj != null) {
            this.pjj.r(a(typedArray, a.j.SwitchButton_kswOffDrawable, a.j.SwitchButton_kswOffColor, b.a.pja));
            this.pjj.s(a(typedArray, a.j.SwitchButton_kswOnDrawable, a.j.SwitchButton_kswOnColor, b.a.pjb));
            this.pjj.setThumbDrawable(d(typedArray));
        }
    }

    private Drawable a(TypedArray typedArray, int i, int i2, int i3) {
        Drawable drawable = typedArray.getDrawable(i);
        if (drawable == null) {
            int color = typedArray.getColor(i2, i3);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.pjj.getRadius());
            gradientDrawable.setColor(color);
            return gradientDrawable;
        }
        return drawable;
    }

    private Drawable d(TypedArray typedArray) {
        Drawable drawable = typedArray.getDrawable(a.j.SwitchButton_kswThumbDrawable);
        if (drawable == null) {
            int color = typedArray.getColor(a.j.SwitchButton_kswThumbColor, b.a.pjc);
            int color2 = typedArray.getColor(a.j.SwitchButton_kswThumbPressedColor, b.a.pjd);
            StateListDrawable stateListDrawable = new StateListDrawable();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.pjj.getRadius());
            gradientDrawable.setColor(color);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(this.pjj.getRadius());
            gradientDrawable2.setColor(color2);
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, gradientDrawable2);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }
        return drawable;
    }

    public b getConfiguration() {
        return this.pjj;
    }

    public void setConfiguration(b bVar) {
        if (this.pjj == null) {
            this.pjj = b.bF(bVar.getDensity());
        }
        this.pjj.r(bVar.emp());
        this.pjj.s(bVar.emq());
        this.pjj.setThumbDrawable(bVar.emr());
        this.pjj.N(bVar.emk(), bVar.eml(), bVar.emm(), bVar.emn());
        this.pjj.dR(bVar.getThumbWidth(), bVar.getThumbHeight());
        this.pjj.NW(bVar.emo());
        this.pjj.bG(bVar.ems());
        this.pjo.NW(this.pjj.emo());
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
        emA();
        emz();
        emB();
        emC();
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            this.pjn = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
        }
    }

    private void emz() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.pjk == null) {
                this.pjk = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.pjj.emm() > 0 ? this.pjj.emm() : 0);
            int paddingRight = (-this.pjj.emw()) + ((measuredWidth - getPaddingRight()) - (this.pjj.emn() > 0 ? this.pjj.emn() : 0));
            this.pjk.set(paddingLeft, (this.pjj.emk() > 0 ? this.pjj.emk() : 0) + getPaddingTop(), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.pjj.eml() > 0 ? this.pjj.eml() : 0)) + (-this.pjj.emx()));
            this.pjq = this.pjk.left + (((this.pjk.right - this.pjk.left) - this.pjj.getThumbWidth()) / 2);
            return;
        }
        this.pjk = null;
    }

    private void emA() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.pjl == null) {
                this.pjl = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.pjj.emm() > 0 ? 0 : -this.pjj.emm());
            int paddingRight = (-this.pjj.emw()) + ((measuredWidth - getPaddingRight()) - (this.pjj.emn() > 0 ? 0 : -this.pjj.emn()));
            this.pjl.set(paddingLeft, (this.pjj.emk() > 0 ? 0 : -this.pjj.emk()) + getPaddingTop(), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.pjj.eml() <= 0 ? -this.pjj.eml() : 0)) + (-this.pjj.emx()));
            return;
        }
        this.pjl = null;
    }

    private void emB() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.pjm == null) {
                this.pjm = new Rect();
            }
            int thumbWidth = this.mIsChecked ? this.pjk.right - this.pjj.getThumbWidth() : this.pjk.left;
            int i = this.pjk.top;
            this.pjm.set(thumbWidth, i, this.pjj.getThumbWidth() + thumbWidth, this.pjj.getThumbHeight() + i);
            return;
        }
        this.pjm = null;
    }

    private void emC() {
        if (this.pjl != null) {
            this.pjj.emh().setBounds(this.pjl);
            this.pjj.emi().setBounds(this.pjl);
        }
        if (this.pjm != null) {
            this.pjj.getThumbDrawable().setBounds(this.pjm);
        }
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int thumbWidth = (int) ((this.pjj.getThumbWidth() * this.pjj.ems()) + getPaddingLeft() + getPaddingRight());
        int emm = this.pjj.emm() + this.pjj.emn();
        if (emm > 0) {
            thumbWidth += emm;
        }
        if (mode == 1073741824) {
            thumbWidth = Math.max(size, thumbWidth);
        } else if (mode == Integer.MIN_VALUE) {
            thumbWidth = Math.min(size, thumbWidth);
        }
        return thumbWidth + this.pjj.emt().left + this.pjj.emt().right;
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int thumbHeight = this.pjj.getThumbHeight() + getPaddingTop() + getPaddingBottom();
        int emk = this.pjj.emk() + this.pjj.eml();
        if (emk > 0) {
            thumbHeight += emk;
        }
        if (mode == 1073741824) {
            thumbHeight = Math.max(size, thumbHeight);
        } else if (mode == Integer.MIN_VALUE) {
            thumbHeight = Math.min(size, thumbHeight);
        }
        return thumbHeight + this.pjj.emt().top + this.pjj.emt().bottom;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mBounds);
        if (this.mBounds != null && this.pjj.emy()) {
            this.mBounds.inset(this.pjj.emu(), this.pjj.emv());
            canvas.clipRect(this.mBounds, Region.Op.REPLACE);
            canvas.translate(this.pjj.emt().left, this.pjj.emt().top);
        }
        boolean z = !isEnabled() && emD();
        if (z) {
            canvas.saveLayerAlpha(this.pjn, ThunderNetStateService.NetState.SYSNET_UNKNOWN, 31);
        }
        if (this.pjj.emi() != null) {
            this.pjj.emi().draw(canvas);
        }
        if (this.pjj.emh() != null) {
            this.pjj.emh().setAlpha(emE());
            this.pjj.emh().draw(canvas);
        }
        if (this.pjj.getThumbDrawable() != null) {
            this.pjj.getThumbDrawable().draw(canvas);
        }
        if (z) {
            canvas.restore();
        }
        if (pji) {
            this.mRectPaint.setColor(Color.parseColor("#AA0000"));
            canvas.drawRect(this.pjl, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#00FF00"));
            canvas.drawRect(this.pjk, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#0000FF"));
            canvas.drawRect(this.pjm, this.mRectPaint);
        }
    }

    private boolean emD() {
        return ((this.pjj.getThumbDrawable() instanceof StateListDrawable) && (this.pjj.emh() instanceof StateListDrawable) && (this.pjj.emi() instanceof StateListDrawable)) ? false : true;
    }

    private int emE() {
        int thumbWidth;
        if (this.pjk == null || this.pjk.right == this.pjk.left || (thumbWidth = (this.pjk.right - this.pjj.getThumbWidth()) - this.pjk.left) <= 0) {
            return 255;
        }
        return ((this.pjm.left - this.pjk.left) * 255) / thumbWidth;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isAnimating || !isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX() - this.dxQ;
        float y = motionEvent.getY() - this.bNR;
        boolean z = this.mIsChecked;
        switch (action) {
            case 0:
                emF();
                this.dxQ = motionEvent.getX();
                this.bNR = motionEvent.getY();
                this.mLastX = this.dxQ;
                setPressed(true);
                break;
            case 1:
            case 3:
                setPressed(false);
                boolean statusBasedOnPos = getStatusBasedOnPos();
                float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                if (x < this.mTouchSlop && y < this.mTouchSlop && eventTime < this.pjr) {
                    performClick();
                    break;
                } else {
                    AV(statusBasedOnPos);
                    break;
                }
                break;
            case 2:
                float x2 = motionEvent.getX();
                Od((int) (x2 - this.mLastX));
                this.mLastX = x2;
                break;
        }
        invalidate();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getStatusBasedOnPos() {
        return ((float) this.pjm.left) > this.pjq;
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.mBounds != null && this.pjj.emy()) {
            invalidate(this.mBounds);
        } else {
            super.invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    private void emF() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void setChecked(boolean z, boolean z2) {
        if (this.pjm != null) {
            Od(z ? getMeasuredWidth() : -getMeasuredWidth());
        }
        aI(z, z2);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        setChecked(z, true);
    }

    public void AU(boolean z) {
        if (z) {
            AV(this.mIsChecked ? false : true);
        } else {
            setChecked(this.mIsChecked ? false : true);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        AU(true);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public boolean isChecked() {
        return this.mIsChecked;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.pjj != null) {
            setDrawableState(this.pjj.getThumbDrawable());
            setDrawableState(this.pjj.emh());
            setDrawableState(this.pjj.emi());
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
        this.pjs = onCheckedChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedInClass(boolean z) {
        aI(z, true);
    }

    private void aI(boolean z, boolean z2) {
        if (this.mIsChecked != z) {
            this.mIsChecked = z;
            refreshDrawableState();
            if (this.pjs != null && z2) {
                this.pjs.onCheckedChanged(this, this.mIsChecked);
            }
        }
    }

    public void AV(boolean z) {
        if (!this.isAnimating) {
            this.pjo.dQ(this.pjm.left, z ? this.pjk.right - this.pjj.getThumbWidth() : this.pjk.left);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Od(int i) {
        int i2 = this.pjm.left + i;
        int i3 = this.pjm.right + i;
        if (i2 < this.pjk.left) {
            i2 = this.pjk.left;
            i3 = this.pjj.getThumbWidth() + i2;
        }
        if (i3 > this.pjk.right) {
            i3 = this.pjk.right;
            i2 = i3 - this.pjj.getThumbWidth();
        }
        dS(i2, i3);
    }

    private void dS(int i, int i2) {
        this.pjm.set(i, this.pjm.top, i2, this.pjm.bottom);
        this.pjj.getThumbDrawable().setBounds(this.pjm);
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
        public boolean emd() {
            return SwitchButton.this.pjm.right < SwitchButton.this.pjk.right && SwitchButton.this.pjm.left > SwitchButton.this.pjk.left;
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void onFrameUpdate(int i) {
            SwitchButton.this.Od(i);
            SwitchButton.this.postInvalidate();
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void eme() {
            SwitchButton.this.setCheckedInClass(SwitchButton.this.getStatusBasedOnPos());
            SwitchButton.this.isAnimating = false;
        }
    }
}
