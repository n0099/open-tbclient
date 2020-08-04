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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SortSwitchButton extends View implements View.OnTouchListener {
    private Paint bol;
    private float gxS;
    private int hQA;
    private RectF hQD;
    private Path hQE;
    private RectF hQF;
    private Path hQG;
    private float hQI;
    private boolean hQJ;
    private boolean hQK;
    private boolean hQL;
    private List<Float> hQM;
    private GestureDetector.SimpleOnGestureListener hQN;
    private float hQO;
    private boolean hQP;
    private float hQu;
    private int hQv;
    private int hQw;
    private int hQx;
    private float hQy;
    private float hQz;
    private a kkZ;
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
    private float mWidth;
    private int mrJ;
    private float mrK;
    private float mrL;
    private Paint mrM;
    private RectF mrN;
    private Path mrO;
    private RectF mrP;
    private Path mrQ;
    private com.baidu.tieba.d mrR;
    private boolean mrS;
    private boolean mrT;
    private BdUniqueId mrU;
    private BdUniqueId mrV;
    private d.a mrW;

    /* loaded from: classes.dex */
    public interface a {
        boolean vs(int i);
    }

    public SortSwitchButton(Context context) {
        this(context, null);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mrR = new com.baidu.tieba.d();
        this.hQJ = false;
        this.hQK = false;
        this.hQL = true;
        this.mrS = true;
        this.mrT = false;
        this.mrV = BdUniqueId.gen();
        this.listener = new CustomMessageListener(2921458) { // from class: com.baidu.tieba.view.SortSwitchButton.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage) && (((CustomMessage) customResponsedMessage.getOrginalMessage()).getData() instanceof BdUniqueId)) {
                    BdUniqueId bdUniqueId = (BdUniqueId) ((CustomMessage) customResponsedMessage.getOrginalMessage()).getData();
                    BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                    if (tag != null && bdUniqueId != null && SortSwitchButton.this.mrU != null) {
                        Integer num = (Integer) customResponsedMessage.getData();
                        if (tag.getId() == SortSwitchButton.this.mrU.getId() && bdUniqueId.getId() != SortSwitchButton.this.mrV.getId() && SortSwitchButton.this.mrR.bqK() != num.intValue() && !x.isEmpty(SortSwitchButton.this.mData) && !x.isEmpty(SortSwitchButton.this.hQM) && SortSwitchButton.this.hQM.size() > num.intValue()) {
                            SortSwitchButton.this.mrR.pH(num.intValue());
                            SortSwitchButton.this.hQI = ((Float) SortSwitchButton.this.hQM.get(num.intValue())).floatValue();
                            SortSwitchButton.this.invalidate();
                        }
                    }
                }
            }
        };
        this.mrW = new d.a() { // from class: com.baidu.tieba.view.SortSwitchButton.2
            @Override // com.baidu.tieba.d.a
            public void bo(int i2, int i3) {
                ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i3));
                CustomMessage customMessage = new CustomMessage(2921458);
                customMessage.setTag(SortSwitchButton.this.mrU);
                customMessage.setData(SortSwitchButton.this.mrV);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        };
        this.hQN = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.view.SortSwitchButton.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!SortSwitchButton.this.hQK && motionEvent.getX() <= SortSwitchButton.this.mWidth && motionEvent.getY() <= SortSwitchButton.this.mHeight) {
                    if (SortSwitchButton.this.getParent() != null) {
                        SortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int bqK = SortSwitchButton.this.mrR.bqK();
                SortSwitchButton.this.hQI = motionEvent.getX();
                SortSwitchButton.this.mrR.pG(SortSwitchButton.this.cfp());
                SortSwitchButton.this.hQK = true;
                if (SortSwitchButton.this.mrR.bqK() != bqK) {
                    SortSwitchButton.this.vt(bqK);
                    if (SortSwitchButton.this.mValueAnimator != null) {
                        SortSwitchButton.this.mValueAnimator.start();
                    }
                    SortSwitchButton.this.vu(bqK);
                }
                SortSwitchButton.this.hQK = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (SortSwitchButton.this.hQJ) {
                    SortSwitchButton.this.hQI -= f;
                    if (SortSwitchButton.this.hQI < 0.0f) {
                        SortSwitchButton.this.hQI = 0.0f;
                    }
                    Float f3 = (Float) x.getItem(SortSwitchButton.this.hQM, SortSwitchButton.this.hQM.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (SortSwitchButton.this.hQI > floatValue) {
                        SortSwitchButton.this.hQI = floatValue;
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
        if (this.mrT) {
            this.mrR.a(this.mrW);
            MessageManager.getInstance().registerListener(this.listener);
        }
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SortSwitchButton);
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_color, R.color.cp_cont_j);
        this.mrJ = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_border_color, this.mBackgroundColorId);
        this.mrK = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_background_border_width, 0.0f);
        this.mrL = obtainStyledAttributes.getFloat(R.styleable.SortSwitchButton_background_border_alpha, 1.0f);
        this.hQv = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_color, R.color.cp_cont_a);
        this.hQw = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_un_selected_text_color, R.color.cp_cont_b);
        this.hQx = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_selected_text_color, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_size, 5.0f);
        this.hQy = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_horizontal_padding, 0.0f);
        this.hQu = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_height, 0.0f);
        this.hQz = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_border_width, 0.0f);
        this.hQA = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_border_color, R.color.cp_cont_b);
        this.mrT = obtainStyledAttributes.getBoolean(R.styleable.SortSwitchButton_slide_need_sync, false);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.hQD = new RectF();
        this.hQE = new Path();
        this.hQF = new RectF();
        this.hQG = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ao.getColor(this.mBackgroundColorId));
        if (this.mrJ > 0 && this.mrK > 0.0f) {
            this.mrN = new RectF();
            this.mrO = new Path();
            this.mrP = new RectF();
            this.mrQ = new Path();
            this.mrM = new Paint(1);
            this.mrM.setStyle(Paint.Style.STROKE);
            this.mrM.setStrokeWidth(this.mrK);
            this.mrM.setColor(com.baidu.tieba.tbadkCore.c.l(ao.getColor(this.mBackgroundColorId), this.mrL));
        }
        this.bol = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.hQM = new ArrayList();
        this.mrR.pH(0);
        this.mGestureDetector = new GestureDetector(context, this.hQN);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SortSwitchButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * SortSwitchButton.this.mMoveDistance;
                if (SortSwitchButton.this.hQP) {
                    SortSwitchButton.this.hQI = SortSwitchButton.this.hQO - floatValue;
                } else {
                    SortSwitchButton.this.hQI = floatValue + SortSwitchButton.this.hQO;
                }
                SortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.view.SortSwitchButton.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (SortSwitchButton.this.hQM.size() > SortSwitchButton.this.mrR.bqK()) {
                    SortSwitchButton.this.hQI = ((Float) SortSwitchButton.this.hQM.get(SortSwitchButton.this.mrR.bqK())).floatValue();
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
        int count = x.getCount(this.mData);
        if (mode == Integer.MIN_VALUE) {
            this.mWidth = 0.0f;
            for (int i3 = 0; i3 < count; i3++) {
                p pVar = (p) x.getItem(this.mData, i3);
                if (pVar != null) {
                    float measureText = this.mTextPaint.measureText(pVar.dlw() == null ? "" : pVar.dlw()) + (this.hQy * 2.0f);
                    if (this.hQL) {
                        this.hQM.add(Float.valueOf(this.mWidth));
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
                if (this.hQL) {
                    this.hQM.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.hQu;
        } else {
            this.mHeight = size2;
            this.hQu = this.mHeight;
        }
        this.hQL = false;
        tY();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void tY() {
        this.hQD.set(this.mrK, this.mrK, this.mWidth - this.mrK, this.mHeight - this.mrK);
        this.hQE.reset();
        this.hQE.addRoundRect(this.hQD, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        if (this.mrN != null && this.mrM != null) {
            this.mrN.set(0.0f, 0.0f, this.mWidth, this.mHeight);
            float f = this.mrK * 0.5f;
            this.mrP.set(-f, -f, this.mWidth + f, this.mHeight + f);
            this.mrO.reset();
            this.mrQ.reset();
            this.mrO.addRoundRect(this.mrN, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
            this.mrQ.addRoundRect(this.mrP, (this.mHeight + f) * 0.5f, (f + this.mHeight) * 0.5f, Path.Direction.CW);
        }
        Float f2 = (Float) x.getItem(this.hQM, this.mrR.bqK());
        this.hQI = f2 != null ? f2.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.gxS = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mrQ != null) {
            canvas.clipPath(this.mrQ);
        } else {
            canvas.clipPath(this.hQE);
        }
        super.onDraw(canvas);
        ai(canvas);
        J(canvas);
        int i = 0;
        while (i < this.mData.size() && i < this.hQM.size()) {
            a(canvas, this.mData.get(i).dlw(), this.hQM.get(i).floatValue() + this.hQy, this.gxS, this.mrR.bqK() == i);
            i++;
        }
    }

    private void ai(Canvas canvas) {
        canvas.drawPath(this.hQE, this.mBackgroundPaint);
        if (this.mrJ > 0 && this.mrK > 0.0f && this.mrM != null) {
            canvas.drawPath(this.mrO, this.mrM);
        }
    }

    private void J(Canvas canvas) {
        float f;
        this.hQG.reset();
        if (this.hQI < 0.0f) {
            this.hQI = 0.0f;
        }
        float floatValue = !x.isEmpty(this.hQM) ? ((Float) x.getItem(this.hQM, this.mrR.bqK())).floatValue() : 0.0f;
        if (this.mrR.bqK() + 1 < this.hQM.size()) {
            f = this.hQM.get(this.mrR.bqK() + 1).floatValue();
        } else {
            f = this.mrR.bqK() + 1 == this.hQM.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.hQI;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.hQF.set(this.hQI, 0.0f, f2, this.mHeight);
        this.hQG.addRoundRect(this.hQF, this.hQu / 2.0f, this.hQu / 2.0f, Path.Direction.CW);
        this.bol.setColor(this.mrS ? ao.getColor(this.hQA) : ao.getColor(0, this.hQA));
        canvas.drawPath(this.hQG, this.bol);
        this.hQG.reset();
        this.hQF.set(this.hQI + this.hQz, this.hQz, f2 - this.hQz, this.mHeight - this.hQz);
        this.hQG.addRoundRect(this.hQF, (this.hQu - (this.hQz * 2.0f)) / 2.0f, (this.hQu - (this.hQz * 2.0f)) / 2.0f, Path.Direction.CW);
        this.bol.setColor(this.mrS ? ao.getColor(this.hQv) : ao.getColor(0, this.hQv));
        canvas.drawPath(this.hQG, this.bol);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(this.mrS ? ao.getColor(this.hQx) : ao.getColor(0, this.hQx));
        } else {
            this.mTextPaint.setColor(this.mrS ? ao.getColor(this.hQw) : ao.getColor(0, this.hQw));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.hQJ && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int bqK = this.mrR.bqK();
            int cfp = cfp();
            if (Math.abs(cfp - bqK) >= 2 || cfp > bqK) {
                this.mrR.pH(cfp);
            } else if (cfp < bqK) {
                float floatValue = this.hQM.size() > cfp ? this.hQM.get(cfp).floatValue() : 0.0f;
                float floatValue2 = cfp + 1 < this.hQM.size() ? this.hQM.get(cfp + 1).floatValue() : floatValue;
                if (this.hQI >= floatValue && this.hQI <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.mrR.pH(cfp);
                }
            } else {
                float floatValue3 = this.hQM.size() > cfp ? this.hQM.get(cfp).floatValue() : 0.0f;
                if (this.hQI >= (((cfp + 1 < this.hQM.size() ? this.hQM.get(cfp + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cfp + 1 < this.hQM.size()) {
                    this.mrR.pH(cfp + 1);
                }
            }
            this.hQK = true;
            this.hQO = this.hQI;
            float floatValue4 = this.hQM.size() > this.mrR.bqK() ? this.hQM.get(this.mrR.bqK()).floatValue() : 0.0f;
            this.mMoveDistance = Math.abs(this.hQO - floatValue4);
            if (this.mrR.bqK() < bqK) {
                this.hQP = true;
            } else if (this.mrR.bqK() > bqK) {
                this.hQP = false;
            } else {
                this.hQP = this.hQO > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.mrR.bqK() != bqK) {
                vu(bqK);
            }
            this.hQK = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cfp() {
        float floatValue;
        int bqK = this.mrR.bqK();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.hQM.size()) {
                return bqK;
            }
            float floatValue2 = ((Float) x.getItem(this.hQM, i2)).floatValue();
            if (i2 + 1 == this.hQM.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) x.getItem(this.hQM, i2 + 1)).floatValue();
            }
            if (this.hQI <= floatValue2 || this.hQI >= floatValue) {
                if (this.hQI == floatValue2) {
                    if (bqK - 1 >= 0) {
                        return bqK - 1;
                    }
                } else if (this.hQI == floatValue && bqK + 1 < x.getCount(this.hQM)) {
                    return bqK + 1;
                }
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vt(int i) {
        if (this.hQM.size() > i) {
            this.hQO = this.hQM.get(i).floatValue();
        }
        float f = 0.0f;
        if (this.hQM.size() > this.mrR.bqK()) {
            f = this.hQM.get(this.mrR.bqK()).floatValue();
        }
        this.mMoveDistance = Math.abs(f - this.hQO);
        this.hQP = this.mrR.bqK() < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vu(int i) {
        if (this.kkZ != null && !this.kkZ.vs(this.mrR.bqK())) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.mrR.pG(i);
            if (this.hQM.size() > this.mrR.bqK()) {
                this.hQI = this.hQM.get(this.mrR.bqK()).floatValue();
            }
            invalidate();
        }
    }

    public void setNeedDayNight(boolean z) {
        this.mrS = z;
        if (!this.mrS) {
            this.mBackgroundPaint.setColor(ao.getColor(0, this.mBackgroundColorId));
            if (this.mrM != null) {
                this.mrM.setColor(com.baidu.tieba.tbadkCore.c.l(ao.getColor(0, this.mrJ), this.mrL));
            }
        }
    }

    public void setData(List<p> list) {
        if (cE(list)) {
            if (x.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.mData = list;
            requestLayout();
        }
    }

    public void setData(List<p> list, int i) {
        if (cE(list) || this.mrR == null || this.mrR.bqK() != i) {
            if (x.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            reset();
            setVisibility(0);
            this.mrR.pG(i);
            this.mData = list;
            requestLayout();
        }
    }

    private boolean cE(List<p> list) {
        if (!x.isEmpty(list) && list.size() == this.mData.size()) {
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
        if (pVar.dlv() == pVar2.dlv() && pVar.dlw() != null && pVar.dlw().equals(pVar2.dlw())) {
            return true;
        }
        return pVar.dlv() == pVar2.dlv() && pVar.dlw() == null && pVar2.dlw() == null;
    }

    public void reset() {
        this.mrR.pG(0);
        this.hQI = 0.0f;
        this.hQK = false;
        this.mData.clear();
        this.hQM.clear();
        this.hQL = true;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.kkZ = aVar;
    }

    public void onChangeSkinType() {
        if (this.mrS) {
            this.mBackgroundPaint.setColor(ao.getColor(this.mBackgroundColorId));
            if (this.mrM != null) {
                this.mrM.setColor(com.baidu.tieba.tbadkCore.c.l(ao.getColor(this.mBackgroundColorId), this.mrL));
            }
            invalidate();
        }
    }

    public void setCanScroll(boolean z) {
        this.hQJ = z;
    }

    public int getState() {
        return this.mrR.bqK();
    }

    public void changeState(int i) {
        if (!x.isEmpty(this.mData) && !x.isEmpty(this.hQM)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mData.size()) {
                    if (this.mData.get(i3).dlv() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.mrR.pG(i3);
                        if (this.hQM.size() > i3) {
                            this.hQI = this.hQM.get(i3).floatValue();
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
        this.mrU = bdUniqueId;
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.mrT) {
            this.listener.setTag(bdUniqueId);
        }
    }
}
