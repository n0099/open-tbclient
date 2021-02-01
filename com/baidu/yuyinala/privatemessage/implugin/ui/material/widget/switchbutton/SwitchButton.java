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
    private static boolean pgA = false;
    private float bMr;
    private float dwp;
    private boolean isAnimating;
    private Rect mBounds;
    private boolean mIsChecked;
    private float mLastX;
    private Paint mRectPaint;
    private int mTouchSlop;
    private b pgB;
    private Rect pgC;
    private Rect pgD;
    private Rect pgE;
    private RectF pgF;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a pgG;
    private a pgH;
    private float pgI;
    private int pgJ;
    private CompoundButton.OnCheckedChangeListener pgK;

    @SuppressLint({"NewApi"})
    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsChecked = false;
        this.pgH = new a();
        this.isAnimating = false;
        this.mBounds = null;
        initView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.SwitchButton);
        this.pgB.NS(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_margin, this.pgB.elR()));
        this.pgB.N(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginTop, this.pgB.elS()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginBottom, this.pgB.elT()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginLeft, this.pgB.elU()), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_marginRight, this.pgB.elV()));
        this.pgB.setRadius(obtainStyledAttributes.getInt(a.j.SwitchButton_kswRadius, b.a.DEFAULT_RADIUS));
        this.pgB.dQ(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_width, -1), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswThumb_height, -1));
        this.pgB.bC(obtainStyledAttributes.getFloat(a.j.SwitchButton_kswMeasureFactor, -1.0f));
        this.pgB.O(obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetLeft, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetTop, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetRight, 0), obtainStyledAttributes.getDimensionPixelSize(a.j.SwitchButton_kswInsetBottom, 0));
        this.pgG.NR(obtainStyledAttributes.getInteger(a.j.SwitchButton_kswAnimationVelocity, -1));
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
        this.pgB = b.bB(getContext().getResources().getDisplayMetrics().density);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.pgJ = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.pgG = com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.elK().a(this.pgH);
        this.mBounds = new Rect();
        if (pgA) {
            this.mRectPaint = new Paint();
            this.mRectPaint.setStyle(Paint.Style.STROKE);
        }
    }

    private void c(TypedArray typedArray) {
        if (this.pgB != null) {
            this.pgB.r(a(typedArray, a.j.SwitchButton_kswOffDrawable, a.j.SwitchButton_kswOffColor, b.a.pgs));
            this.pgB.s(a(typedArray, a.j.SwitchButton_kswOnDrawable, a.j.SwitchButton_kswOnColor, b.a.pgt));
            this.pgB.setThumbDrawable(d(typedArray));
        }
    }

    private Drawable a(TypedArray typedArray, int i, int i2, int i3) {
        Drawable drawable = typedArray.getDrawable(i);
        if (drawable == null) {
            int color = typedArray.getColor(i2, i3);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.pgB.getRadius());
            gradientDrawable.setColor(color);
            return gradientDrawable;
        }
        return drawable;
    }

    private Drawable d(TypedArray typedArray) {
        Drawable drawable = typedArray.getDrawable(a.j.SwitchButton_kswThumbDrawable);
        if (drawable == null) {
            int color = typedArray.getColor(a.j.SwitchButton_kswThumbColor, b.a.pgu);
            int color2 = typedArray.getColor(a.j.SwitchButton_kswThumbPressedColor, b.a.pgv);
            StateListDrawable stateListDrawable = new StateListDrawable();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.pgB.getRadius());
            gradientDrawable.setColor(color);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(this.pgB.getRadius());
            gradientDrawable2.setColor(color2);
            stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, gradientDrawable2);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }
        return drawable;
    }

    public b getConfiguration() {
        return this.pgB;
    }

    public void setConfiguration(b bVar) {
        if (this.pgB == null) {
            this.pgB = b.bB(bVar.getDensity());
        }
        this.pgB.r(bVar.elX());
        this.pgB.s(bVar.elY());
        this.pgB.setThumbDrawable(bVar.elZ());
        this.pgB.N(bVar.elS(), bVar.elT(), bVar.elU(), bVar.elV());
        this.pgB.dQ(bVar.getThumbWidth(), bVar.getThumbHeight());
        this.pgB.NR(bVar.elW());
        this.pgB.bC(bVar.ema());
        this.pgG.NR(this.pgB.elW());
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
        emi();
        emh();
        emj();
        emk();
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            this.pgF = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
        }
    }

    private void emh() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.pgC == null) {
                this.pgC = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.pgB.elU() > 0 ? this.pgB.elU() : 0);
            int paddingRight = (-this.pgB.eme()) + ((measuredWidth - getPaddingRight()) - (this.pgB.elV() > 0 ? this.pgB.elV() : 0));
            this.pgC.set(paddingLeft, (this.pgB.elS() > 0 ? this.pgB.elS() : 0) + getPaddingTop(), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.pgB.elT() > 0 ? this.pgB.elT() : 0)) + (-this.pgB.emf()));
            this.pgI = this.pgC.left + (((this.pgC.right - this.pgC.left) - this.pgB.getThumbWidth()) / 2);
            return;
        }
        this.pgC = null;
    }

    private void emi() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.pgD == null) {
                this.pgD = new Rect();
            }
            int paddingLeft = getPaddingLeft() + (this.pgB.elU() > 0 ? 0 : -this.pgB.elU());
            int paddingRight = (-this.pgB.eme()) + ((measuredWidth - getPaddingRight()) - (this.pgB.elV() > 0 ? 0 : -this.pgB.elV()));
            this.pgD.set(paddingLeft, (this.pgB.elS() > 0 ? 0 : -this.pgB.elS()) + getPaddingTop(), paddingRight, ((measuredHeight - getPaddingBottom()) - (this.pgB.elT() <= 0 ? -this.pgB.elT() : 0)) + (-this.pgB.emf()));
            return;
        }
        this.pgD = null;
    }

    private void emj() {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.pgE == null) {
                this.pgE = new Rect();
            }
            int thumbWidth = this.mIsChecked ? this.pgC.right - this.pgB.getThumbWidth() : this.pgC.left;
            int i = this.pgC.top;
            this.pgE.set(thumbWidth, i, this.pgB.getThumbWidth() + thumbWidth, this.pgB.getThumbHeight() + i);
            return;
        }
        this.pgE = null;
    }

    private void emk() {
        if (this.pgD != null) {
            this.pgB.elP().setBounds(this.pgD);
            this.pgB.elQ().setBounds(this.pgD);
        }
        if (this.pgE != null) {
            this.pgB.getThumbDrawable().setBounds(this.pgE);
        }
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int thumbWidth = (int) ((this.pgB.getThumbWidth() * this.pgB.ema()) + getPaddingLeft() + getPaddingRight());
        int elU = this.pgB.elU() + this.pgB.elV();
        if (elU > 0) {
            thumbWidth += elU;
        }
        if (mode == 1073741824) {
            thumbWidth = Math.max(size, thumbWidth);
        } else if (mode == Integer.MIN_VALUE) {
            thumbWidth = Math.min(size, thumbWidth);
        }
        return thumbWidth + this.pgB.emb().left + this.pgB.emb().right;
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int thumbHeight = this.pgB.getThumbHeight() + getPaddingTop() + getPaddingBottom();
        int elS = this.pgB.elS() + this.pgB.elT();
        if (elS > 0) {
            thumbHeight += elS;
        }
        if (mode == 1073741824) {
            thumbHeight = Math.max(size, thumbHeight);
        } else if (mode == Integer.MIN_VALUE) {
            thumbHeight = Math.min(size, thumbHeight);
        }
        return thumbHeight + this.pgB.emb().top + this.pgB.emb().bottom;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mBounds);
        if (this.mBounds != null && this.pgB.emg()) {
            this.mBounds.inset(this.pgB.emc(), this.pgB.emd());
            canvas.clipRect(this.mBounds, Region.Op.REPLACE);
            canvas.translate(this.pgB.emb().left, this.pgB.emb().top);
        }
        boolean z = !isEnabled() && eml();
        if (z) {
            canvas.saveLayerAlpha(this.pgF, ThunderNetStateService.NetState.SYSNET_UNKNOWN, 31);
        }
        if (this.pgB.elQ() != null) {
            this.pgB.elQ().draw(canvas);
        }
        if (this.pgB.elP() != null) {
            this.pgB.elP().setAlpha(emm());
            this.pgB.elP().draw(canvas);
        }
        if (this.pgB.getThumbDrawable() != null) {
            this.pgB.getThumbDrawable().draw(canvas);
        }
        if (z) {
            canvas.restore();
        }
        if (pgA) {
            this.mRectPaint.setColor(Color.parseColor("#AA0000"));
            canvas.drawRect(this.pgD, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#00FF00"));
            canvas.drawRect(this.pgC, this.mRectPaint);
            this.mRectPaint.setColor(Color.parseColor("#0000FF"));
            canvas.drawRect(this.pgE, this.mRectPaint);
        }
    }

    private boolean eml() {
        return ((this.pgB.getThumbDrawable() instanceof StateListDrawable) && (this.pgB.elP() instanceof StateListDrawable) && (this.pgB.elQ() instanceof StateListDrawable)) ? false : true;
    }

    private int emm() {
        int thumbWidth;
        if (this.pgC == null || this.pgC.right == this.pgC.left || (thumbWidth = (this.pgC.right - this.pgB.getThumbWidth()) - this.pgC.left) <= 0) {
            return 255;
        }
        return ((this.pgE.left - this.pgC.left) * 255) / thumbWidth;
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
                emn();
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
                if (x < this.mTouchSlop && y < this.mTouchSlop && eventTime < this.pgJ) {
                    performClick();
                    break;
                } else {
                    AW(statusBasedOnPos);
                    break;
                }
                break;
            case 2:
                float x2 = motionEvent.getX();
                NY((int) (x2 - this.mLastX));
                this.mLastX = x2;
                break;
        }
        invalidate();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getStatusBasedOnPos() {
        return ((float) this.pgE.left) > this.pgI;
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.mBounds != null && this.pgB.emg()) {
            invalidate(this.mBounds);
        } else {
            super.invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    private void emn() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void setChecked(boolean z, boolean z2) {
        if (this.pgE != null) {
            NY(z ? getMeasuredWidth() : -getMeasuredWidth());
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
        if (this.pgB != null) {
            setDrawableState(this.pgB.getThumbDrawable());
            setDrawableState(this.pgB.elP());
            setDrawableState(this.pgB.elQ());
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
        this.pgK = onCheckedChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedInClass(boolean z) {
        aI(z, true);
    }

    private void aI(boolean z, boolean z2) {
        if (this.mIsChecked != z) {
            this.mIsChecked = z;
            refreshDrawableState();
            if (this.pgK != null && z2) {
                this.pgK.onCheckedChanged(this, this.mIsChecked);
            }
        }
    }

    public void AW(boolean z) {
        if (!this.isAnimating) {
            this.pgG.dP(this.pgE.left, z ? this.pgC.right - this.pgB.getThumbWidth() : this.pgC.left);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NY(int i) {
        int i2 = this.pgE.left + i;
        int i3 = this.pgE.right + i;
        if (i2 < this.pgC.left) {
            i2 = this.pgC.left;
            i3 = this.pgB.getThumbWidth() + i2;
        }
        if (i3 > this.pgC.right) {
            i3 = this.pgC.right;
            i2 = i3 - this.pgB.getThumbWidth();
        }
        dR(i2, i3);
    }

    private void dR(int i, int i2) {
        this.pgE.set(i, this.pgE.top, i2, this.pgE.bottom);
        this.pgB.getThumbDrawable().setBounds(this.pgE);
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
        public boolean elL() {
            return SwitchButton.this.pgE.right < SwitchButton.this.pgC.right && SwitchButton.this.pgE.left > SwitchButton.this.pgC.left;
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void onFrameUpdate(int i) {
            SwitchButton.this.NY(i);
            SwitchButton.this.postInvalidate();
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.switchbutton.a.b
        public void elM() {
            SwitchButton.this.setCheckedInClass(SwitchButton.this.getStatusBasedOnPos());
            SwitchButton.this.isAnimating = false;
        }
    }
}
