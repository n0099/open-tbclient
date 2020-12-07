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
    private float hDg;
    private float jeG;
    private int jeH;
    private int jeI;
    private int jeJ;
    private float jeK;
    private float jeL;
    private int jeM;
    private RectF jeP;
    private RectF jeQ;
    private Path jeR;
    private float jeT;
    private boolean jeU;
    private boolean jeV;
    private boolean jeW;
    private List<Float> jeX;
    private GestureDetector.SimpleOnGestureListener jeY;
    private float jeZ;
    private boolean jfa;
    private a lEE;
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
    private RectF nRA;
    private Path nRB;
    private RectF nRC;
    private Path nRD;
    private com.baidu.tieba.e nRE;
    private boolean nRF;
    private boolean nRG;
    private BdUniqueId nRH;
    private BdUniqueId nRI;
    private e.a nRJ;
    private int nRw;
    private float nRx;
    private float nRy;
    private Paint nRz;

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
        this.nRE = new com.baidu.tieba.e();
        this.jeU = false;
        this.jeV = false;
        this.jeW = true;
        this.nRF = true;
        this.nRG = false;
        this.nRI = BdUniqueId.gen();
        this.listener = new CustomMessageListener(2921458) { // from class: com.baidu.tieba.view.SortSwitchButton.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage) && (((CustomMessage) customResponsedMessage.getOrginalMessage()).getData() instanceof BdUniqueId)) {
                    BdUniqueId bdUniqueId = (BdUniqueId) ((CustomMessage) customResponsedMessage.getOrginalMessage()).getData();
                    BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                    if (tag != null && bdUniqueId != null && SortSwitchButton.this.nRH != null) {
                        Integer num = (Integer) customResponsedMessage.getData();
                        if (tag.getId() == SortSwitchButton.this.nRH.getId() && bdUniqueId.getId() != SortSwitchButton.this.nRI.getId() && SortSwitchButton.this.nRE.bKP() != num.intValue() && !y.isEmpty(SortSwitchButton.this.mData) && !y.isEmpty(SortSwitchButton.this.jeX) && SortSwitchButton.this.jeX.size() > num.intValue()) {
                            SortSwitchButton.this.nRE.ue(num.intValue());
                            SortSwitchButton.this.jeT = ((Float) SortSwitchButton.this.jeX.get(num.intValue())).floatValue();
                            SortSwitchButton.this.invalidate();
                        }
                    }
                }
            }
        };
        this.nRJ = new e.a() { // from class: com.baidu.tieba.view.SortSwitchButton.2
            @Override // com.baidu.tieba.e.a
            public void bz(int i2, int i3) {
                ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i3));
                CustomMessage customMessage = new CustomMessage(2921458);
                customMessage.setTag(SortSwitchButton.this.nRH);
                customMessage.setData(SortSwitchButton.this.nRI);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        };
        this.jeY = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.view.SortSwitchButton.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!SortSwitchButton.this.jeV && motionEvent.getX() <= SortSwitchButton.this.bPi && motionEvent.getY() <= SortSwitchButton.this.mHeight) {
                    if (SortSwitchButton.this.getParent() != null) {
                        SortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int bKP = SortSwitchButton.this.nRE.bKP();
                SortSwitchButton.this.jeT = motionEvent.getX();
                SortSwitchButton.this.nRE.ud(SortSwitchButton.this.cGk());
                SortSwitchButton.this.jeV = true;
                if (SortSwitchButton.this.nRE.bKP() != bKP) {
                    SortSwitchButton.this.AA(bKP);
                    if (SortSwitchButton.this.mValueAnimator != null) {
                        SortSwitchButton.this.mValueAnimator.start();
                    }
                    SortSwitchButton.this.AB(bKP);
                }
                SortSwitchButton.this.jeV = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (SortSwitchButton.this.jeU) {
                    SortSwitchButton.this.jeT -= f;
                    if (SortSwitchButton.this.jeT < 0.0f) {
                        SortSwitchButton.this.jeT = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(SortSwitchButton.this.jeX, SortSwitchButton.this.jeX.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (SortSwitchButton.this.jeT > floatValue) {
                        SortSwitchButton.this.jeT = floatValue;
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
        if (this.nRG) {
            this.nRE.a(this.nRJ);
            MessageManager.getInstance().registerListener(this.listener);
        }
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SortSwitchButton);
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_color, R.color.CAM_X0107);
        this.nRw = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_border_color, this.mBackgroundColorId);
        this.nRx = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_background_border_width, 0.0f);
        this.nRy = obtainStyledAttributes.getFloat(R.styleable.SortSwitchButton_background_border_alpha, 1.0f);
        this.jeH = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_color, R.color.CAM_X0101);
        this.jeI = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_un_selected_text_color, R.color.CAM_X0105);
        this.jeJ = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_selected_text_color, R.color.CAM_X0105);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_size, 5.0f);
        this.jeK = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_horizontal_padding, 0.0f);
        this.jeG = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_height, 0.0f);
        this.jeL = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_border_width, 0.0f);
        this.jeM = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_border_color, R.color.CAM_X0105);
        this.nRG = obtainStyledAttributes.getBoolean(R.styleable.SortSwitchButton_slide_need_sync, false);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.jeP = new RectF();
        this.eOI = new Path();
        this.jeQ = new RectF();
        this.jeR = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        if (this.nRw > 0 && this.nRx > 0.0f) {
            this.nRA = new RectF();
            this.nRB = new Path();
            this.nRC = new RectF();
            this.nRD = new Path();
            this.nRz = new Paint(1);
            this.nRz.setStyle(Paint.Style.STROKE);
            this.nRz.setStrokeWidth(this.nRx);
            this.nRz.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(this.mBackgroundColorId), this.nRy));
        }
        this.bPT = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.jeX = new ArrayList();
        this.nRE.ue(0);
        this.mGestureDetector = new GestureDetector(context, this.jeY);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SortSwitchButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * SortSwitchButton.this.mMoveDistance;
                if (SortSwitchButton.this.jfa) {
                    SortSwitchButton.this.jeT = SortSwitchButton.this.jeZ - floatValue;
                } else {
                    SortSwitchButton.this.jeT = floatValue + SortSwitchButton.this.jeZ;
                }
                SortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.view.SortSwitchButton.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (SortSwitchButton.this.jeX.size() > SortSwitchButton.this.nRE.bKP()) {
                    SortSwitchButton.this.jeT = ((Float) SortSwitchButton.this.jeX.get(SortSwitchButton.this.nRE.bKP())).floatValue();
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
                    float measureText = this.mTextPaint.measureText(pVar.dPu() == null ? "" : pVar.dPu()) + (this.jeK * 2.0f);
                    if (this.jeW) {
                        this.jeX.add(Float.valueOf(this.bPi));
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
                if (this.jeW) {
                    this.jeX.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.jeG;
        } else {
            this.mHeight = size2;
            this.jeG = this.mHeight;
        }
        this.jeW = false;
        cGj();
        setMeasuredDimension((int) this.bPi, (int) this.mHeight);
    }

    private void cGj() {
        this.jeP.set(this.nRx, this.nRx, this.bPi - this.nRx, this.mHeight - this.nRx);
        this.eOI.reset();
        this.eOI.addRoundRect(this.jeP, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        if (this.nRA != null && this.nRz != null) {
            this.nRA.set(0.0f, 0.0f, this.bPi, this.mHeight);
            float f = this.nRx * 0.5f;
            this.nRC.set(-f, -f, this.bPi + f, this.mHeight + f);
            this.nRB.reset();
            this.nRD.reset();
            this.nRB.addRoundRect(this.nRA, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
            this.nRD.addRoundRect(this.nRC, (this.mHeight + f) * 0.5f, (f + this.mHeight) * 0.5f, Path.Direction.CW);
        }
        Float f2 = (Float) y.getItem(this.jeX, this.nRE.bKP());
        this.jeT = f2 != null ? f2.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.hDg = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.nRD != null) {
            canvas.clipPath(this.nRD);
        } else {
            canvas.clipPath(this.eOI);
        }
        super.onDraw(canvas);
        aq(canvas);
        U(canvas);
        int i = 0;
        while (i < this.mData.size() && i < this.jeX.size()) {
            a(canvas, this.mData.get(i).dPu(), this.jeX.get(i).floatValue() + this.jeK, this.hDg, this.nRE.bKP() == i);
            i++;
        }
    }

    private void aq(Canvas canvas) {
        canvas.drawPath(this.eOI, this.mBackgroundPaint);
        if (this.nRw > 0 && this.nRx > 0.0f && this.nRz != null) {
            canvas.drawPath(this.nRB, this.nRz);
        }
    }

    private void U(Canvas canvas) {
        float f;
        if (this.jeT < 0.0f) {
            this.jeT = 0.0f;
        }
        float floatValue = !y.isEmpty(this.jeX) ? ((Float) y.getItem(this.jeX, this.nRE.bKP())).floatValue() : 0.0f;
        if (this.nRE.bKP() + 1 < this.jeX.size()) {
            f = this.jeX.get(this.nRE.bKP() + 1).floatValue();
        } else {
            f = this.nRE.bKP() + 1 == this.jeX.size() ? this.bPi : 0.0f;
        }
        float f2 = (f - floatValue) + this.jeT;
        if (f2 > this.bPi) {
            f2 = this.bPi;
        }
        this.jeQ.set(this.jeT, 0.0f, f2, this.mHeight);
        this.jeR.reset();
        this.jeR.addRoundRect(this.jeQ, this.jeG / 2.0f, this.jeG / 2.0f, Path.Direction.CW);
        this.bPT.reset();
        this.bPT.setAntiAlias(true);
        this.bPT.setColor(this.nRF ? ap.getColor(this.jeH) : ap.getColor(0, this.jeH));
        canvas.drawPath(this.jeR, this.bPT);
        this.bPT.reset();
        this.bPT.setAntiAlias(true);
        this.bPT.setColor(this.nRF ? ap.getColor(this.jeM) : ap.getColor(0, this.jeM));
        this.bPT.setStyle(Paint.Style.STROKE);
        this.bPT.setStrokeWidth(this.jeL);
        this.jeQ.set(this.jeT + (this.jeL / 2.0f), this.jeL / 2.0f, f2 - (this.jeL / 2.0f), this.jeG - (this.jeL / 2.0f));
        float f3 = (this.jeG - this.jeL) / 2.0f;
        canvas.drawRoundRect(this.jeQ, f3, f3, this.bPT);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(this.nRF ? ap.getColor(this.jeJ) : ap.getColor(0, this.jeJ));
        } else {
            this.mTextPaint.setColor(this.nRF ? ap.getColor(this.jeI) : ap.getColor(0, this.jeI));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.jeU && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int bKP = this.nRE.bKP();
            int cGk = cGk();
            if (Math.abs(cGk - bKP) >= 2 || cGk > bKP) {
                this.nRE.ue(cGk);
            } else if (cGk < bKP) {
                float floatValue = this.jeX.size() > cGk ? this.jeX.get(cGk).floatValue() : 0.0f;
                float floatValue2 = cGk + 1 < this.jeX.size() ? this.jeX.get(cGk + 1).floatValue() : floatValue;
                if (this.jeT >= floatValue && this.jeT <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.nRE.ue(cGk);
                }
            } else {
                float floatValue3 = this.jeX.size() > cGk ? this.jeX.get(cGk).floatValue() : 0.0f;
                if (this.jeT >= (((cGk + 1 < this.jeX.size() ? this.jeX.get(cGk + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cGk + 1 < this.jeX.size()) {
                    this.nRE.ue(cGk + 1);
                }
            }
            this.jeV = true;
            this.jeZ = this.jeT;
            float floatValue4 = this.jeX.size() > this.nRE.bKP() ? this.jeX.get(this.nRE.bKP()).floatValue() : 0.0f;
            this.mMoveDistance = Math.abs(this.jeZ - floatValue4);
            if (this.nRE.bKP() < bKP) {
                this.jfa = true;
            } else if (this.nRE.bKP() > bKP) {
                this.jfa = false;
            } else {
                this.jfa = this.jeZ > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.nRE.bKP() != bKP) {
                AB(bKP);
            }
            this.jeV = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cGk() {
        float floatValue;
        int bKP = this.nRE.bKP();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.jeX.size()) {
                return bKP;
            }
            float floatValue2 = ((Float) y.getItem(this.jeX, i2)).floatValue();
            if (i2 + 1 == this.jeX.size()) {
                floatValue = this.bPi;
            } else {
                floatValue = ((Float) y.getItem(this.jeX, i2 + 1)).floatValue();
            }
            if (this.jeT <= floatValue2 || this.jeT >= floatValue) {
                if (this.jeT == floatValue2) {
                    if (bKP - 1 >= 0) {
                        return bKP - 1;
                    }
                } else if (this.jeT == floatValue && bKP + 1 < y.getCount(this.jeX)) {
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
        if (this.jeX.size() > i) {
            this.jeZ = this.jeX.get(i).floatValue();
        }
        float f = 0.0f;
        if (this.jeX.size() > this.nRE.bKP()) {
            f = this.jeX.get(this.nRE.bKP()).floatValue();
        }
        this.mMoveDistance = Math.abs(f - this.jeZ);
        this.jfa = this.nRE.bKP() < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AB(int i) {
        if (this.lEE != null && !this.lEE.Az(this.nRE.bKP())) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.nRE.ud(i);
            if (this.jeX.size() > this.nRE.bKP()) {
                this.jeT = this.jeX.get(this.nRE.bKP()).floatValue();
            }
            invalidate();
        }
    }

    public void setNeedDayNight(boolean z) {
        this.nRF = z;
        if (!this.nRF) {
            this.mBackgroundPaint.setColor(ap.getColor(0, this.mBackgroundColorId));
            if (this.nRz != null) {
                this.nRz.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(0, this.nRw), this.nRy));
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
        if (dk(list) || this.nRE == null || this.nRE.bKP() != i) {
            if (y.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            reset();
            setVisibility(0);
            this.nRE.ud(i);
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
        if (pVar.dPt() == pVar2.dPt() && pVar.dPu() != null && pVar.dPu().equals(pVar2.dPu())) {
            return true;
        }
        return pVar.dPt() == pVar2.dPt() && pVar.dPu() == null && pVar2.dPu() == null;
    }

    public void reset() {
        this.nRE.ud(0);
        this.jeT = 0.0f;
        this.jeV = false;
        this.mData.clear();
        this.jeX.clear();
        this.jeW = true;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.lEE = aVar;
    }

    public void onChangeSkinType() {
        if (this.nRF) {
            this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
            if (this.nRz != null) {
                this.nRz.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(this.mBackgroundColorId), this.nRy));
            }
            invalidate();
        }
    }

    public void setCanScroll(boolean z) {
        this.jeU = z;
    }

    public int getState() {
        return this.nRE.bKP();
    }

    public void kj(int i) {
        if (!y.isEmpty(this.mData) && !y.isEmpty(this.jeX)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mData.size()) {
                    if (this.mData.get(i3).dPt() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.nRE.ud(i3);
                        if (this.jeX.size() > i3) {
                            this.jeT = this.jeX.get(i3).floatValue();
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
        this.nRH = bdUniqueId;
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.nRG) {
            this.listener.setTag(bdUniqueId);
        }
    }
}
