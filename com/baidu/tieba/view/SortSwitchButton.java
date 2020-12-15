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
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.data.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SortSwitchButton extends View implements View.OnTouchListener {
    private Paint bPT;
    private float bPi;
    private Path eOI;
    private float hDi;
    private float jeI;
    private int jeJ;
    private int jeK;
    private int jeL;
    private float jeM;
    private float jeN;
    private int jeO;
    private RectF jeR;
    private RectF jeS;
    private Path jeT;
    private float jeV;
    private boolean jeW;
    private boolean jeX;
    private boolean jeY;
    private List<Float> jeZ;
    private GestureDetector.SimpleOnGestureListener jfa;
    private float jfb;
    private boolean jfc;
    private a lEG;
    private CustomMessageListener listener;
    private int mBackgroundColorId;
    private Paint mBackgroundPaint;
    private List<p> mData;
    private GestureDetector mGestureDetector;
    private float mHeight;
    private float mMoveDistance;
    private Paint mTextPaint;
    private float mTextSize;
    private ValueAnimator mValueAnimator;
    private float nRA;
    private Paint nRB;
    private RectF nRC;
    private Path nRD;
    private RectF nRE;
    private Path nRF;
    private com.baidu.tieba.e nRG;
    private boolean nRH;
    private boolean nRI;
    private BdUniqueId nRJ;
    private BdUniqueId nRK;
    private e.a nRL;
    private int nRy;
    private float nRz;

    /* loaded from: classes.dex */
    public interface a {
        boolean Az(int i);
    }

    public SortSwitchButton(Context context) {
        this(context, null);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nRG = new com.baidu.tieba.e();
        this.jeW = false;
        this.jeX = false;
        this.jeY = true;
        this.nRH = true;
        this.nRI = false;
        this.nRK = BdUniqueId.gen();
        this.listener = new CustomMessageListener(2921458) { // from class: com.baidu.tieba.view.SortSwitchButton.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage) && (((CustomMessage) customResponsedMessage.getOrginalMessage()).getData() instanceof BdUniqueId)) {
                    BdUniqueId bdUniqueId = (BdUniqueId) ((CustomMessage) customResponsedMessage.getOrginalMessage()).getData();
                    BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                    if (tag != null && bdUniqueId != null && SortSwitchButton.this.nRJ != null) {
                        Integer num = (Integer) customResponsedMessage.getData();
                        if (tag.getId() == SortSwitchButton.this.nRJ.getId() && bdUniqueId.getId() != SortSwitchButton.this.nRK.getId() && SortSwitchButton.this.nRG.bKP() != num.intValue() && !y.isEmpty(SortSwitchButton.this.mData) && !y.isEmpty(SortSwitchButton.this.jeZ) && SortSwitchButton.this.jeZ.size() > num.intValue()) {
                            SortSwitchButton.this.nRG.ue(num.intValue());
                            SortSwitchButton.this.jeV = ((Float) SortSwitchButton.this.jeZ.get(num.intValue())).floatValue();
                            SortSwitchButton.this.invalidate();
                        }
                    }
                }
            }
        };
        this.nRL = new e.a() { // from class: com.baidu.tieba.view.SortSwitchButton.2
            @Override // com.baidu.tieba.e.a
            public void bz(int i2, int i3) {
                ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i3));
                CustomMessage customMessage = new CustomMessage(2921458);
                customMessage.setTag(SortSwitchButton.this.nRJ);
                customMessage.setData(SortSwitchButton.this.nRK);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        };
        this.jfa = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.view.SortSwitchButton.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!SortSwitchButton.this.jeX && motionEvent.getX() <= SortSwitchButton.this.bPi && motionEvent.getY() <= SortSwitchButton.this.mHeight) {
                    if (SortSwitchButton.this.getParent() != null) {
                        SortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int bKP = SortSwitchButton.this.nRG.bKP();
                SortSwitchButton.this.jeV = motionEvent.getX();
                SortSwitchButton.this.nRG.ud(SortSwitchButton.this.cGl());
                SortSwitchButton.this.jeX = true;
                if (SortSwitchButton.this.nRG.bKP() != bKP) {
                    SortSwitchButton.this.AA(bKP);
                    if (SortSwitchButton.this.mValueAnimator != null) {
                        SortSwitchButton.this.mValueAnimator.start();
                    }
                    SortSwitchButton.this.AB(bKP);
                }
                SortSwitchButton.this.jeX = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (SortSwitchButton.this.jeW) {
                    SortSwitchButton.this.jeV -= f;
                    if (SortSwitchButton.this.jeV < 0.0f) {
                        SortSwitchButton.this.jeV = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(SortSwitchButton.this.jeZ, SortSwitchButton.this.jeZ.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (SortSwitchButton.this.jeV > floatValue) {
                        SortSwitchButton.this.jeV = floatValue;
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
        if (this.nRI) {
            this.nRG.a(this.nRL);
            MessageManager.getInstance().registerListener(this.listener);
        }
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SortSwitchButton);
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_color, R.color.CAM_X0107);
        this.nRy = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_border_color, this.mBackgroundColorId);
        this.nRz = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_background_border_width, 0.0f);
        this.nRA = obtainStyledAttributes.getFloat(R.styleable.SortSwitchButton_background_border_alpha, 1.0f);
        this.jeJ = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_color, R.color.CAM_X0101);
        this.jeK = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_un_selected_text_color, R.color.CAM_X0105);
        this.jeL = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_selected_text_color, R.color.CAM_X0105);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_size, 5.0f);
        this.jeM = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_horizontal_padding, 0.0f);
        this.jeI = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_height, 0.0f);
        this.jeN = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_border_width, 0.0f);
        this.jeO = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_border_color, R.color.CAM_X0105);
        this.nRI = obtainStyledAttributes.getBoolean(R.styleable.SortSwitchButton_slide_need_sync, false);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.jeR = new RectF();
        this.eOI = new Path();
        this.jeS = new RectF();
        this.jeT = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        if (this.nRy > 0 && this.nRz > 0.0f) {
            this.nRC = new RectF();
            this.nRD = new Path();
            this.nRE = new RectF();
            this.nRF = new Path();
            this.nRB = new Paint(1);
            this.nRB.setStyle(Paint.Style.STROKE);
            this.nRB.setStrokeWidth(this.nRz);
            this.nRB.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(this.mBackgroundColorId), this.nRA));
        }
        this.bPT = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.jeZ = new ArrayList();
        this.nRG.ue(0);
        this.mGestureDetector = new GestureDetector(context, this.jfa);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SortSwitchButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * SortSwitchButton.this.mMoveDistance;
                if (SortSwitchButton.this.jfc) {
                    SortSwitchButton.this.jeV = SortSwitchButton.this.jfb - floatValue;
                } else {
                    SortSwitchButton.this.jeV = floatValue + SortSwitchButton.this.jfb;
                }
                SortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.view.SortSwitchButton.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (SortSwitchButton.this.jeZ.size() > SortSwitchButton.this.nRG.bKP()) {
                    SortSwitchButton.this.jeV = ((Float) SortSwitchButton.this.jeZ.get(SortSwitchButton.this.nRG.bKP())).floatValue();
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
            this.bPi = 0.0f;
            for (int i3 = 0; i3 < count; i3++) {
                p pVar = (p) y.getItem(this.mData, i3);
                if (pVar != null) {
                    float measureText = this.mTextPaint.measureText(pVar.dPv() == null ? "" : pVar.dPv()) + (this.jeM * 2.0f);
                    if (this.jeY) {
                        this.jeZ.add(Float.valueOf(this.bPi));
                    }
                    this.bPi = measureText + this.bPi;
                }
            }
        } else {
            this.bPi = size;
            float f = this.bPi;
            if (count > 0) {
                f = this.bPi / count;
            }
            float f2 = 0.0f;
            for (int i4 = 0; i4 < count; i4++) {
                if (this.jeY) {
                    this.jeZ.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.jeI;
        } else {
            this.mHeight = size2;
            this.jeI = this.mHeight;
        }
        this.jeY = false;
        cGk();
        setMeasuredDimension((int) this.bPi, (int) this.mHeight);
    }

    private void cGk() {
        this.jeR.set(this.nRz, this.nRz, this.bPi - this.nRz, this.mHeight - this.nRz);
        this.eOI.reset();
        this.eOI.addRoundRect(this.jeR, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        if (this.nRC != null && this.nRB != null) {
            this.nRC.set(0.0f, 0.0f, this.bPi, this.mHeight);
            float f = this.nRz * 0.5f;
            this.nRE.set(-f, -f, this.bPi + f, this.mHeight + f);
            this.nRD.reset();
            this.nRF.reset();
            this.nRD.addRoundRect(this.nRC, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
            this.nRF.addRoundRect(this.nRE, (this.mHeight + f) * 0.5f, (f + this.mHeight) * 0.5f, Path.Direction.CW);
        }
        Float f2 = (Float) y.getItem(this.jeZ, this.nRG.bKP());
        this.jeV = f2 != null ? f2.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.hDi = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.nRF != null) {
            canvas.clipPath(this.nRF);
        } else {
            canvas.clipPath(this.eOI);
        }
        super.onDraw(canvas);
        aq(canvas);
        U(canvas);
        int i = 0;
        while (i < this.mData.size() && i < this.jeZ.size()) {
            a(canvas, this.mData.get(i).dPv(), this.jeZ.get(i).floatValue() + this.jeM, this.hDi, this.nRG.bKP() == i);
            i++;
        }
    }

    private void aq(Canvas canvas) {
        canvas.drawPath(this.eOI, this.mBackgroundPaint);
        if (this.nRy > 0 && this.nRz > 0.0f && this.nRB != null) {
            canvas.drawPath(this.nRD, this.nRB);
        }
    }

    private void U(Canvas canvas) {
        float f;
        if (this.jeV < 0.0f) {
            this.jeV = 0.0f;
        }
        float floatValue = !y.isEmpty(this.jeZ) ? ((Float) y.getItem(this.jeZ, this.nRG.bKP())).floatValue() : 0.0f;
        if (this.nRG.bKP() + 1 < this.jeZ.size()) {
            f = this.jeZ.get(this.nRG.bKP() + 1).floatValue();
        } else {
            f = this.nRG.bKP() + 1 == this.jeZ.size() ? this.bPi : 0.0f;
        }
        float f2 = (f - floatValue) + this.jeV;
        if (f2 > this.bPi) {
            f2 = this.bPi;
        }
        this.jeS.set(this.jeV, 0.0f, f2, this.mHeight);
        this.jeT.reset();
        this.jeT.addRoundRect(this.jeS, this.jeI / 2.0f, this.jeI / 2.0f, Path.Direction.CW);
        this.bPT.reset();
        this.bPT.setAntiAlias(true);
        this.bPT.setColor(this.nRH ? ap.getColor(this.jeJ) : ap.getColor(0, this.jeJ));
        canvas.drawPath(this.jeT, this.bPT);
        this.bPT.reset();
        this.bPT.setAntiAlias(true);
        this.bPT.setColor(this.nRH ? ap.getColor(this.jeO) : ap.getColor(0, this.jeO));
        this.bPT.setStyle(Paint.Style.STROKE);
        this.bPT.setStrokeWidth(this.jeN);
        this.jeS.set(this.jeV + (this.jeN / 2.0f), this.jeN / 2.0f, f2 - (this.jeN / 2.0f), this.jeI - (this.jeN / 2.0f));
        float f3 = (this.jeI - this.jeN) / 2.0f;
        canvas.drawRoundRect(this.jeS, f3, f3, this.bPT);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(this.nRH ? ap.getColor(this.jeL) : ap.getColor(0, this.jeL));
        } else {
            this.mTextPaint.setColor(this.nRH ? ap.getColor(this.jeK) : ap.getColor(0, this.jeK));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.jeW && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int bKP = this.nRG.bKP();
            int cGl = cGl();
            if (Math.abs(cGl - bKP) >= 2 || cGl > bKP) {
                this.nRG.ue(cGl);
            } else if (cGl < bKP) {
                float floatValue = this.jeZ.size() > cGl ? this.jeZ.get(cGl).floatValue() : 0.0f;
                float floatValue2 = cGl + 1 < this.jeZ.size() ? this.jeZ.get(cGl + 1).floatValue() : floatValue;
                if (this.jeV >= floatValue && this.jeV <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.nRG.ue(cGl);
                }
            } else {
                float floatValue3 = this.jeZ.size() > cGl ? this.jeZ.get(cGl).floatValue() : 0.0f;
                if (this.jeV >= (((cGl + 1 < this.jeZ.size() ? this.jeZ.get(cGl + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cGl + 1 < this.jeZ.size()) {
                    this.nRG.ue(cGl + 1);
                }
            }
            this.jeX = true;
            this.jfb = this.jeV;
            float floatValue4 = this.jeZ.size() > this.nRG.bKP() ? this.jeZ.get(this.nRG.bKP()).floatValue() : 0.0f;
            this.mMoveDistance = Math.abs(this.jfb - floatValue4);
            if (this.nRG.bKP() < bKP) {
                this.jfc = true;
            } else if (this.nRG.bKP() > bKP) {
                this.jfc = false;
            } else {
                this.jfc = this.jfb > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.nRG.bKP() != bKP) {
                AB(bKP);
            }
            this.jeX = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cGl() {
        float floatValue;
        int bKP = this.nRG.bKP();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.jeZ.size()) {
                return bKP;
            }
            float floatValue2 = ((Float) y.getItem(this.jeZ, i2)).floatValue();
            if (i2 + 1 == this.jeZ.size()) {
                floatValue = this.bPi;
            } else {
                floatValue = ((Float) y.getItem(this.jeZ, i2 + 1)).floatValue();
            }
            if (this.jeV <= floatValue2 || this.jeV >= floatValue) {
                if (this.jeV == floatValue2) {
                    if (bKP - 1 >= 0) {
                        return bKP - 1;
                    }
                } else if (this.jeV == floatValue && bKP + 1 < y.getCount(this.jeZ)) {
                    return bKP + 1;
                }
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AA(int i) {
        if (this.jeZ.size() > i) {
            this.jfb = this.jeZ.get(i).floatValue();
        }
        float f = 0.0f;
        if (this.jeZ.size() > this.nRG.bKP()) {
            f = this.jeZ.get(this.nRG.bKP()).floatValue();
        }
        this.mMoveDistance = Math.abs(f - this.jfb);
        this.jfc = this.nRG.bKP() < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AB(int i) {
        if (this.lEG != null && !this.lEG.Az(this.nRG.bKP())) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.nRG.ud(i);
            if (this.jeZ.size() > this.nRG.bKP()) {
                this.jeV = this.jeZ.get(this.nRG.bKP()).floatValue();
            }
            invalidate();
        }
    }

    public void setNeedDayNight(boolean z) {
        this.nRH = z;
        if (!this.nRH) {
            this.mBackgroundPaint.setColor(ap.getColor(0, this.mBackgroundColorId));
            if (this.nRB != null) {
                this.nRB.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(0, this.nRy), this.nRA));
            }
        }
    }

    public void setData(List<p> list) {
        if (dk(list)) {
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
        if (dk(list) || this.nRG == null || this.nRG.bKP() != i) {
            if (y.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            reset();
            setVisibility(0);
            this.nRG.ud(i);
            this.mData = list;
            requestLayout();
        }
    }

    private boolean dk(List<p> list) {
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
        if (pVar.dPu() == pVar2.dPu() && pVar.dPv() != null && pVar.dPv().equals(pVar2.dPv())) {
            return true;
        }
        return pVar.dPu() == pVar2.dPu() && pVar.dPv() == null && pVar2.dPv() == null;
    }

    public void reset() {
        this.nRG.ud(0);
        this.jeV = 0.0f;
        this.jeX = false;
        this.mData.clear();
        this.jeZ.clear();
        this.jeY = true;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.lEG = aVar;
    }

    public void onChangeSkinType() {
        if (this.nRH) {
            this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
            if (this.nRB != null) {
                this.nRB.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(this.mBackgroundColorId), this.nRA));
            }
            invalidate();
        }
    }

    public void setCanScroll(boolean z) {
        this.jeW = z;
    }

    public int getState() {
        return this.nRG.bKP();
    }

    public void kj(int i) {
        if (!y.isEmpty(this.mData) && !y.isEmpty(this.jeZ)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mData.size()) {
                    if (this.mData.get(i3).dPu() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.nRG.ud(i3);
                        if (this.jeZ.size() > i3) {
                            this.jeV = this.jeZ.get(i3).floatValue();
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
        this.nRJ = bdUniqueId;
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.nRI) {
            this.listener.setTag(bdUniqueId);
        }
    }
}
