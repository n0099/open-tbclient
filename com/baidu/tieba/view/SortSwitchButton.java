package com.baidu.tieba.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class SortSwitchButton extends View implements View.OnTouchListener {
    private Paint btX;
    private float gJR;
    private float ieD;
    private int ieE;
    private int ieF;
    private int ieG;
    private float ieH;
    private float ieI;
    private int ieJ;
    private RectF ieM;
    private Path ieN;
    private RectF ieO;
    private Path ieP;
    private float ieR;
    private boolean ieS;
    private boolean ieT;
    private boolean ieU;
    private List<Float> ieV;
    private GestureDetector.SimpleOnGestureListener ieW;
    private float ieX;
    private boolean ieY;
    private a kAr;
    private CustomMessageListener listener;
    private int mBackgroundColorId;
    private Paint mBackgroundPaint;
    private List<p> mData;
    private GestureDetector mGestureDetector;
    private float mHeight;
    private int mJU;
    private float mJV;
    private float mJW;
    private Paint mJX;
    private RectF mJY;
    private Path mJZ;
    private RectF mKa;
    private Path mKb;
    private com.baidu.tieba.d mKc;
    private boolean mKd;
    private boolean mKe;
    private BdUniqueId mKf;
    private BdUniqueId mKg;
    private d.a mKh;
    private float mMoveDistance;
    private Paint mTextPaint;
    private float mTextSize;
    private ValueAnimator mValueAnimator;
    private float mWidth;

    /* loaded from: classes2.dex */
    public interface a {
        boolean xL(int i);
    }

    public SortSwitchButton(Context context) {
        this(context, null);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mKc = new com.baidu.tieba.d();
        this.ieS = false;
        this.ieT = false;
        this.ieU = true;
        this.mKd = true;
        this.mKe = false;
        this.mKg = BdUniqueId.gen();
        this.listener = new CustomMessageListener(2921458) { // from class: com.baidu.tieba.view.SortSwitchButton.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage) && (((CustomMessage) customResponsedMessage.getOrginalMessage()).getData() instanceof BdUniqueId)) {
                    BdUniqueId bdUniqueId = (BdUniqueId) ((CustomMessage) customResponsedMessage.getOrginalMessage()).getData();
                    BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                    if (tag != null && bdUniqueId != null && SortSwitchButton.this.mKf != null) {
                        Integer num = (Integer) customResponsedMessage.getData();
                        if (tag.getId() == SortSwitchButton.this.mKf.getId() && bdUniqueId.getId() != SortSwitchButton.this.mKg.getId() && SortSwitchButton.this.mKc.bzI() != num.intValue() && !y.isEmpty(SortSwitchButton.this.mData) && !y.isEmpty(SortSwitchButton.this.ieV) && SortSwitchButton.this.ieV.size() > num.intValue()) {
                            SortSwitchButton.this.mKc.rT(num.intValue());
                            SortSwitchButton.this.ieR = ((Float) SortSwitchButton.this.ieV.get(num.intValue())).floatValue();
                            SortSwitchButton.this.invalidate();
                        }
                    }
                }
            }
        };
        this.mKh = new d.a() { // from class: com.baidu.tieba.view.SortSwitchButton.2
            @Override // com.baidu.tieba.d.a
            public void bx(int i2, int i3) {
                ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i3));
                CustomMessage customMessage = new CustomMessage(2921458);
                customMessage.setTag(SortSwitchButton.this.mKf);
                customMessage.setData(SortSwitchButton.this.mKg);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        };
        this.ieW = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.view.SortSwitchButton.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!SortSwitchButton.this.ieT && motionEvent.getX() <= SortSwitchButton.this.mWidth && motionEvent.getY() <= SortSwitchButton.this.mHeight) {
                    if (SortSwitchButton.this.getParent() != null) {
                        SortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int bzI = SortSwitchButton.this.mKc.bzI();
                SortSwitchButton.this.ieR = motionEvent.getX();
                SortSwitchButton.this.mKc.rS(SortSwitchButton.this.cpU());
                SortSwitchButton.this.ieT = true;
                if (SortSwitchButton.this.mKc.bzI() != bzI) {
                    SortSwitchButton.this.xM(bzI);
                    if (SortSwitchButton.this.mValueAnimator != null) {
                        SortSwitchButton.this.mValueAnimator.start();
                    }
                    SortSwitchButton.this.xN(bzI);
                }
                SortSwitchButton.this.ieT = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (SortSwitchButton.this.ieS) {
                    SortSwitchButton.this.ieR -= f;
                    if (SortSwitchButton.this.ieR < 0.0f) {
                        SortSwitchButton.this.ieR = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(SortSwitchButton.this.ieV, SortSwitchButton.this.ieV.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (SortSwitchButton.this.ieR > floatValue) {
                        SortSwitchButton.this.ieR = floatValue;
                    }
                    SortSwitchButton.this.invalidate();
                    return true;
                }
                return false;
            }
        };
        initAttrs(context, attributeSet);
        init(context);
        setOnTouchListener(this);
        if (this.mKe) {
            this.mKc.a(this.mKh);
            MessageManager.getInstance().registerListener(this.listener);
        }
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SortSwitchButton);
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_color, R.color.cp_cont_j);
        this.mJU = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_border_color, this.mBackgroundColorId);
        this.mJV = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_background_border_width, 0.0f);
        this.mJW = obtainStyledAttributes.getFloat(R.styleable.SortSwitchButton_background_border_alpha, 1.0f);
        this.ieE = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_color, R.color.cp_cont_a);
        this.ieF = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_un_selected_text_color, R.color.cp_cont_b);
        this.ieG = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_selected_text_color, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_size, 5.0f);
        this.ieH = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_horizontal_padding, 0.0f);
        this.ieD = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_height, 0.0f);
        this.ieI = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_border_width, 0.0f);
        this.ieJ = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_border_color, R.color.cp_cont_b);
        this.mKe = obtainStyledAttributes.getBoolean(R.styleable.SortSwitchButton_slide_need_sync, false);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.ieM = new RectF();
        this.ieN = new Path();
        this.ieO = new RectF();
        this.ieP = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        if (this.mJU > 0 && this.mJV > 0.0f) {
            this.mJY = new RectF();
            this.mJZ = new Path();
            this.mKa = new RectF();
            this.mKb = new Path();
            this.mJX = new Paint(1);
            this.mJX.setStyle(Paint.Style.STROKE);
            this.mJX.setStrokeWidth(this.mJV);
            this.mJX.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(this.mBackgroundColorId), this.mJW));
        }
        this.btX = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.ieV = new ArrayList();
        this.mKc.rT(0);
        this.mGestureDetector = new GestureDetector(context, this.ieW);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SortSwitchButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * SortSwitchButton.this.mMoveDistance;
                if (SortSwitchButton.this.ieY) {
                    SortSwitchButton.this.ieR = SortSwitchButton.this.ieX - floatValue;
                } else {
                    SortSwitchButton.this.ieR = floatValue + SortSwitchButton.this.ieX;
                }
                SortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.view.SortSwitchButton.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (SortSwitchButton.this.ieV.size() > SortSwitchButton.this.mKc.bzI()) {
                    SortSwitchButton.this.ieR = ((Float) SortSwitchButton.this.ieV.get(SortSwitchButton.this.mKc.bzI())).floatValue();
                }
            }
        });
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        float size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        float size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int count = y.getCount(this.mData);
        if (mode == Integer.MIN_VALUE) {
            this.mWidth = 0.0f;
            for (int i3 = 0; i3 < count; i3++) {
                p pVar = (p) y.getItem(this.mData, i3);
                if (pVar != null) {
                    float measureText = this.mTextPaint.measureText(pVar.dwT() == null ? "" : pVar.dwT()) + (this.ieH * 2.0f);
                    if (this.ieU) {
                        this.ieV.add(Float.valueOf(this.mWidth));
                    }
                    this.mWidth = measureText + this.mWidth;
                }
            }
        } else {
            this.mWidth = size;
            float f = this.mWidth;
            if (count > 0) {
                f = this.mWidth / count;
            }
            float f2 = 0.0f;
            for (int i4 = 0; i4 < count; i4++) {
                if (this.ieU) {
                    this.ieV.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.ieD;
        } else {
            this.mHeight = size2;
            this.ieD = this.mHeight;
        }
        this.ieU = false;
        zu();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void zu() {
        this.ieM.set(this.mJV, this.mJV, this.mWidth - this.mJV, this.mHeight - this.mJV);
        this.ieN.reset();
        this.ieN.addRoundRect(this.ieM, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        if (this.mJY != null && this.mJX != null) {
            this.mJY.set(0.0f, 0.0f, this.mWidth, this.mHeight);
            float f = this.mJV * 0.5f;
            this.mKa.set(-f, -f, this.mWidth + f, this.mHeight + f);
            this.mJZ.reset();
            this.mKb.reset();
            this.mJZ.addRoundRect(this.mJY, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
            this.mKb.addRoundRect(this.mKa, (this.mHeight + f) * 0.5f, (f + this.mHeight) * 0.5f, Path.Direction.CW);
        }
        Float f2 = (Float) y.getItem(this.ieV, this.mKc.bzI());
        this.ieR = f2 != null ? f2.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.gJR = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mKb != null) {
            canvas.clipPath(this.mKb);
        } else {
            canvas.clipPath(this.ieN);
        }
        super.onDraw(canvas);
        ao(canvas);
        Q(canvas);
        int i = 0;
        while (i < this.mData.size() && i < this.ieV.size()) {
            a(canvas, this.mData.get(i).dwT(), this.ieV.get(i).floatValue() + this.ieH, this.gJR, this.mKc.bzI() == i);
            i++;
        }
    }

    private void ao(Canvas canvas) {
        canvas.drawPath(this.ieN, this.mBackgroundPaint);
        if (this.mJU > 0 && this.mJV > 0.0f && this.mJX != null) {
            canvas.drawPath(this.mJZ, this.mJX);
        }
    }

    private void Q(Canvas canvas) {
        float f;
        this.ieP.reset();
        if (this.ieR < 0.0f) {
            this.ieR = 0.0f;
        }
        float floatValue = !y.isEmpty(this.ieV) ? ((Float) y.getItem(this.ieV, this.mKc.bzI())).floatValue() : 0.0f;
        if (this.mKc.bzI() + 1 < this.ieV.size()) {
            f = this.ieV.get(this.mKc.bzI() + 1).floatValue();
        } else {
            f = this.mKc.bzI() + 1 == this.ieV.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.ieR;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.ieO.set(this.ieR, 0.0f, f2, this.mHeight);
        this.ieP.addRoundRect(this.ieO, this.ieD / 2.0f, this.ieD / 2.0f, Path.Direction.CW);
        this.btX.setColor(this.mKd ? ap.getColor(this.ieJ) : ap.getColor(0, this.ieJ));
        canvas.drawPath(this.ieP, this.btX);
        this.ieP.reset();
        this.ieO.set(this.ieR + this.ieI, this.ieI, f2 - this.ieI, this.mHeight - this.ieI);
        this.ieP.addRoundRect(this.ieO, (this.ieD - (this.ieI * 2.0f)) / 2.0f, (this.ieD - (this.ieI * 2.0f)) / 2.0f, Path.Direction.CW);
        this.btX.setColor(this.mKd ? ap.getColor(this.ieE) : ap.getColor(0, this.ieE));
        canvas.drawPath(this.ieP, this.btX);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(this.mKd ? ap.getColor(this.ieG) : ap.getColor(0, this.ieG));
        } else {
            this.mTextPaint.setColor(this.mKd ? ap.getColor(this.ieF) : ap.getColor(0, this.ieF));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.ieS && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int bzI = this.mKc.bzI();
            int cpU = cpU();
            if (Math.abs(cpU - bzI) >= 2 || cpU > bzI) {
                this.mKc.rT(cpU);
            } else if (cpU < bzI) {
                float floatValue = this.ieV.size() > cpU ? this.ieV.get(cpU).floatValue() : 0.0f;
                float floatValue2 = cpU + 1 < this.ieV.size() ? this.ieV.get(cpU + 1).floatValue() : floatValue;
                if (this.ieR >= floatValue && this.ieR <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.mKc.rT(cpU);
                }
            } else {
                float floatValue3 = this.ieV.size() > cpU ? this.ieV.get(cpU).floatValue() : 0.0f;
                if (this.ieR >= (((cpU + 1 < this.ieV.size() ? this.ieV.get(cpU + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cpU + 1 < this.ieV.size()) {
                    this.mKc.rT(cpU + 1);
                }
            }
            this.ieT = true;
            this.ieX = this.ieR;
            float floatValue4 = this.ieV.size() > this.mKc.bzI() ? this.ieV.get(this.mKc.bzI()).floatValue() : 0.0f;
            this.mMoveDistance = Math.abs(this.ieX - floatValue4);
            if (this.mKc.bzI() < bzI) {
                this.ieY = true;
            } else if (this.mKc.bzI() > bzI) {
                this.ieY = false;
            } else {
                this.ieY = this.ieX > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.mKc.bzI() != bzI) {
                xN(bzI);
            }
            this.ieT = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cpU() {
        float floatValue;
        int bzI = this.mKc.bzI();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.ieV.size()) {
                return bzI;
            }
            float floatValue2 = ((Float) y.getItem(this.ieV, i2)).floatValue();
            if (i2 + 1 == this.ieV.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) y.getItem(this.ieV, i2 + 1)).floatValue();
            }
            if (this.ieR <= floatValue2 || this.ieR >= floatValue) {
                if (this.ieR == floatValue2) {
                    if (bzI - 1 >= 0) {
                        return bzI - 1;
                    }
                } else if (this.ieR == floatValue && bzI + 1 < y.getCount(this.ieV)) {
                    return bzI + 1;
                }
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xM(int i) {
        if (this.ieV.size() > i) {
            this.ieX = this.ieV.get(i).floatValue();
        }
        float f = 0.0f;
        if (this.ieV.size() > this.mKc.bzI()) {
            f = this.ieV.get(this.mKc.bzI()).floatValue();
        }
        this.mMoveDistance = Math.abs(f - this.ieX);
        this.ieY = this.mKc.bzI() < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xN(int i) {
        if (this.kAr != null && !this.kAr.xL(this.mKc.bzI())) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.mKc.rS(i);
            if (this.ieV.size() > this.mKc.bzI()) {
                this.ieR = this.ieV.get(this.mKc.bzI()).floatValue();
            }
            invalidate();
        }
    }

    public void setNeedDayNight(boolean z) {
        this.mKd = z;
        if (!this.mKd) {
            this.mBackgroundPaint.setColor(ap.getColor(0, this.mBackgroundColorId));
            if (this.mJX != null) {
                this.mJX.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(0, this.mJU), this.mJW));
            }
        }
    }

    public void setData(List<p> list) {
        if (cG(list)) {
            if (y.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.mData = list;
            requestLayout();
        }
    }

    public void setData(List<p> list, int i) {
        if (cG(list) || this.mKc == null || this.mKc.bzI() != i) {
            if (y.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            reset();
            setVisibility(0);
            this.mKc.rS(i);
            this.mData = list;
            requestLayout();
        }
    }

    private boolean cG(List<p> list) {
        if (!y.isEmpty(list) && list.size() == this.mData.size()) {
            for (int i = 0; i < list.size(); i++) {
                if (!a(list.get(i), this.mData.get(i))) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private boolean a(p pVar, p pVar2) {
        if (pVar == null && pVar2 == null) {
            return true;
        }
        if (pVar == null || pVar2 == null) {
            return false;
        }
        if (pVar.dwS() == pVar2.dwS() && pVar.dwT() != null && pVar.dwT().equals(pVar2.dwT())) {
            return true;
        }
        return pVar.dwS() == pVar2.dwS() && pVar.dwT() == null && pVar2.dwT() == null;
    }

    public void reset() {
        this.mKc.rS(0);
        this.ieR = 0.0f;
        this.ieT = false;
        this.mData.clear();
        this.ieV.clear();
        this.ieU = true;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.kAr = aVar;
    }

    public void onChangeSkinType() {
        if (this.mKd) {
            this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
            if (this.mJX != null) {
                this.mJX.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(this.mBackgroundColorId), this.mJW));
            }
            invalidate();
        }
    }

    public void setCanScroll(boolean z) {
        this.ieS = z;
    }

    public int getState() {
        return this.mKc.bzI();
    }

    public void changeState(int i) {
        if (!y.isEmpty(this.mData) && !y.isEmpty(this.ieV)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mData.size()) {
                    if (this.mData.get(i3).dwS() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.mKc.rS(i3);
                        if (this.ieV.size() > i3) {
                            this.ieR = this.ieV.get(i3).floatValue();
                        }
                        invalidate();
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setCommenId(BdUniqueId bdUniqueId) {
        this.mKf = bdUniqueId;
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.mKe) {
            this.listener.setTag(bdUniqueId);
        }
    }
}
