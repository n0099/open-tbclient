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
    private RectF hQB;
    private Path hQC;
    private RectF hQD;
    private Path hQE;
    private float hQG;
    private boolean hQH;
    private boolean hQI;
    private boolean hQJ;
    private List<Float> hQK;
    private GestureDetector.SimpleOnGestureListener hQL;
    private float hQM;
    private boolean hQN;
    private float hQs;
    private int hQt;
    private int hQu;
    private int hQv;
    private float hQw;
    private float hQx;
    private int hQy;
    private a kkX;
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
    private int mrH;
    private float mrI;
    private float mrJ;
    private Paint mrK;
    private RectF mrL;
    private Path mrM;
    private RectF mrN;
    private Path mrO;
    private com.baidu.tieba.d mrP;
    private boolean mrQ;
    private boolean mrR;
    private BdUniqueId mrS;
    private BdUniqueId mrT;
    private d.a mrU;

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
        this.mrP = new com.baidu.tieba.d();
        this.hQH = false;
        this.hQI = false;
        this.hQJ = true;
        this.mrQ = true;
        this.mrR = false;
        this.mrT = BdUniqueId.gen();
        this.listener = new CustomMessageListener(2921458) { // from class: com.baidu.tieba.view.SortSwitchButton.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage) && (((CustomMessage) customResponsedMessage.getOrginalMessage()).getData() instanceof BdUniqueId)) {
                    BdUniqueId bdUniqueId = (BdUniqueId) ((CustomMessage) customResponsedMessage.getOrginalMessage()).getData();
                    BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                    if (tag != null && bdUniqueId != null && SortSwitchButton.this.mrS != null) {
                        Integer num = (Integer) customResponsedMessage.getData();
                        if (tag.getId() == SortSwitchButton.this.mrS.getId() && bdUniqueId.getId() != SortSwitchButton.this.mrT.getId() && SortSwitchButton.this.mrP.bqK() != num.intValue() && !x.isEmpty(SortSwitchButton.this.mData) && !x.isEmpty(SortSwitchButton.this.hQK) && SortSwitchButton.this.hQK.size() > num.intValue()) {
                            SortSwitchButton.this.mrP.pH(num.intValue());
                            SortSwitchButton.this.hQG = ((Float) SortSwitchButton.this.hQK.get(num.intValue())).floatValue();
                            SortSwitchButton.this.invalidate();
                        }
                    }
                }
            }
        };
        this.mrU = new d.a() { // from class: com.baidu.tieba.view.SortSwitchButton.2
            @Override // com.baidu.tieba.d.a
            public void bo(int i2, int i3) {
                ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i3));
                CustomMessage customMessage = new CustomMessage(2921458);
                customMessage.setTag(SortSwitchButton.this.mrS);
                customMessage.setData(SortSwitchButton.this.mrT);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        };
        this.hQL = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.view.SortSwitchButton.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!SortSwitchButton.this.hQI && motionEvent.getX() <= SortSwitchButton.this.mWidth && motionEvent.getY() <= SortSwitchButton.this.mHeight) {
                    if (SortSwitchButton.this.getParent() != null) {
                        SortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int bqK = SortSwitchButton.this.mrP.bqK();
                SortSwitchButton.this.hQG = motionEvent.getX();
                SortSwitchButton.this.mrP.pG(SortSwitchButton.this.cfp());
                SortSwitchButton.this.hQI = true;
                if (SortSwitchButton.this.mrP.bqK() != bqK) {
                    SortSwitchButton.this.vt(bqK);
                    if (SortSwitchButton.this.mValueAnimator != null) {
                        SortSwitchButton.this.mValueAnimator.start();
                    }
                    SortSwitchButton.this.vu(bqK);
                }
                SortSwitchButton.this.hQI = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (SortSwitchButton.this.hQH) {
                    SortSwitchButton.this.hQG -= f;
                    if (SortSwitchButton.this.hQG < 0.0f) {
                        SortSwitchButton.this.hQG = 0.0f;
                    }
                    Float f3 = (Float) x.getItem(SortSwitchButton.this.hQK, SortSwitchButton.this.hQK.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (SortSwitchButton.this.hQG > floatValue) {
                        SortSwitchButton.this.hQG = floatValue;
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
        if (this.mrR) {
            this.mrP.a(this.mrU);
            MessageManager.getInstance().registerListener(this.listener);
        }
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SortSwitchButton);
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_color, R.color.cp_cont_j);
        this.mrH = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_border_color, this.mBackgroundColorId);
        this.mrI = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_background_border_width, 0.0f);
        this.mrJ = obtainStyledAttributes.getFloat(R.styleable.SortSwitchButton_background_border_alpha, 1.0f);
        this.hQt = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_color, R.color.cp_cont_a);
        this.hQu = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_un_selected_text_color, R.color.cp_cont_b);
        this.hQv = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_selected_text_color, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_size, 5.0f);
        this.hQw = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_horizontal_padding, 0.0f);
        this.hQs = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_height, 0.0f);
        this.hQx = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_border_width, 0.0f);
        this.hQy = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_border_color, R.color.cp_cont_b);
        this.mrR = obtainStyledAttributes.getBoolean(R.styleable.SortSwitchButton_slide_need_sync, false);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.hQB = new RectF();
        this.hQC = new Path();
        this.hQD = new RectF();
        this.hQE = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ao.getColor(this.mBackgroundColorId));
        if (this.mrH > 0 && this.mrI > 0.0f) {
            this.mrL = new RectF();
            this.mrM = new Path();
            this.mrN = new RectF();
            this.mrO = new Path();
            this.mrK = new Paint(1);
            this.mrK.setStyle(Paint.Style.STROKE);
            this.mrK.setStrokeWidth(this.mrI);
            this.mrK.setColor(com.baidu.tieba.tbadkCore.c.l(ao.getColor(this.mBackgroundColorId), this.mrJ));
        }
        this.bol = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.hQK = new ArrayList();
        this.mrP.pH(0);
        this.mGestureDetector = new GestureDetector(context, this.hQL);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SortSwitchButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * SortSwitchButton.this.mMoveDistance;
                if (SortSwitchButton.this.hQN) {
                    SortSwitchButton.this.hQG = SortSwitchButton.this.hQM - floatValue;
                } else {
                    SortSwitchButton.this.hQG = floatValue + SortSwitchButton.this.hQM;
                }
                SortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.view.SortSwitchButton.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (SortSwitchButton.this.hQK.size() > SortSwitchButton.this.mrP.bqK()) {
                    SortSwitchButton.this.hQG = ((Float) SortSwitchButton.this.hQK.get(SortSwitchButton.this.mrP.bqK())).floatValue();
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
                    float measureText = this.mTextPaint.measureText(pVar.dlv() == null ? "" : pVar.dlv()) + (this.hQw * 2.0f);
                    if (this.hQJ) {
                        this.hQK.add(Float.valueOf(this.mWidth));
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
                if (this.hQJ) {
                    this.hQK.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.hQs;
        } else {
            this.mHeight = size2;
            this.hQs = this.mHeight;
        }
        this.hQJ = false;
        tY();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void tY() {
        this.hQB.set(this.mrI, this.mrI, this.mWidth - this.mrI, this.mHeight - this.mrI);
        this.hQC.reset();
        this.hQC.addRoundRect(this.hQB, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        if (this.mrL != null && this.mrK != null) {
            this.mrL.set(0.0f, 0.0f, this.mWidth, this.mHeight);
            float f = this.mrI * 0.5f;
            this.mrN.set(-f, -f, this.mWidth + f, this.mHeight + f);
            this.mrM.reset();
            this.mrO.reset();
            this.mrM.addRoundRect(this.mrL, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
            this.mrO.addRoundRect(this.mrN, (this.mHeight + f) * 0.5f, (f + this.mHeight) * 0.5f, Path.Direction.CW);
        }
        Float f2 = (Float) x.getItem(this.hQK, this.mrP.bqK());
        this.hQG = f2 != null ? f2.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.gxS = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mrO != null) {
            canvas.clipPath(this.mrO);
        } else {
            canvas.clipPath(this.hQC);
        }
        super.onDraw(canvas);
        ai(canvas);
        J(canvas);
        int i = 0;
        while (i < this.mData.size() && i < this.hQK.size()) {
            a(canvas, this.mData.get(i).dlv(), this.hQK.get(i).floatValue() + this.hQw, this.gxS, this.mrP.bqK() == i);
            i++;
        }
    }

    private void ai(Canvas canvas) {
        canvas.drawPath(this.hQC, this.mBackgroundPaint);
        if (this.mrH > 0 && this.mrI > 0.0f && this.mrK != null) {
            canvas.drawPath(this.mrM, this.mrK);
        }
    }

    private void J(Canvas canvas) {
        float f;
        this.hQE.reset();
        if (this.hQG < 0.0f) {
            this.hQG = 0.0f;
        }
        float floatValue = !x.isEmpty(this.hQK) ? ((Float) x.getItem(this.hQK, this.mrP.bqK())).floatValue() : 0.0f;
        if (this.mrP.bqK() + 1 < this.hQK.size()) {
            f = this.hQK.get(this.mrP.bqK() + 1).floatValue();
        } else {
            f = this.mrP.bqK() + 1 == this.hQK.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.hQG;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.hQD.set(this.hQG, 0.0f, f2, this.mHeight);
        this.hQE.addRoundRect(this.hQD, this.hQs / 2.0f, this.hQs / 2.0f, Path.Direction.CW);
        this.bol.setColor(this.mrQ ? ao.getColor(this.hQy) : ao.getColor(0, this.hQy));
        canvas.drawPath(this.hQE, this.bol);
        this.hQE.reset();
        this.hQD.set(this.hQG + this.hQx, this.hQx, f2 - this.hQx, this.mHeight - this.hQx);
        this.hQE.addRoundRect(this.hQD, (this.hQs - (this.hQx * 2.0f)) / 2.0f, (this.hQs - (this.hQx * 2.0f)) / 2.0f, Path.Direction.CW);
        this.bol.setColor(this.mrQ ? ao.getColor(this.hQt) : ao.getColor(0, this.hQt));
        canvas.drawPath(this.hQE, this.bol);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(this.mrQ ? ao.getColor(this.hQv) : ao.getColor(0, this.hQv));
        } else {
            this.mTextPaint.setColor(this.mrQ ? ao.getColor(this.hQu) : ao.getColor(0, this.hQu));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.hQH && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int bqK = this.mrP.bqK();
            int cfp = cfp();
            if (Math.abs(cfp - bqK) >= 2 || cfp > bqK) {
                this.mrP.pH(cfp);
            } else if (cfp < bqK) {
                float floatValue = this.hQK.size() > cfp ? this.hQK.get(cfp).floatValue() : 0.0f;
                float floatValue2 = cfp + 1 < this.hQK.size() ? this.hQK.get(cfp + 1).floatValue() : floatValue;
                if (this.hQG >= floatValue && this.hQG <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.mrP.pH(cfp);
                }
            } else {
                float floatValue3 = this.hQK.size() > cfp ? this.hQK.get(cfp).floatValue() : 0.0f;
                if (this.hQG >= (((cfp + 1 < this.hQK.size() ? this.hQK.get(cfp + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cfp + 1 < this.hQK.size()) {
                    this.mrP.pH(cfp + 1);
                }
            }
            this.hQI = true;
            this.hQM = this.hQG;
            float floatValue4 = this.hQK.size() > this.mrP.bqK() ? this.hQK.get(this.mrP.bqK()).floatValue() : 0.0f;
            this.mMoveDistance = Math.abs(this.hQM - floatValue4);
            if (this.mrP.bqK() < bqK) {
                this.hQN = true;
            } else if (this.mrP.bqK() > bqK) {
                this.hQN = false;
            } else {
                this.hQN = this.hQM > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.mrP.bqK() != bqK) {
                vu(bqK);
            }
            this.hQI = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cfp() {
        float floatValue;
        int bqK = this.mrP.bqK();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.hQK.size()) {
                return bqK;
            }
            float floatValue2 = ((Float) x.getItem(this.hQK, i2)).floatValue();
            if (i2 + 1 == this.hQK.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) x.getItem(this.hQK, i2 + 1)).floatValue();
            }
            if (this.hQG <= floatValue2 || this.hQG >= floatValue) {
                if (this.hQG == floatValue2) {
                    if (bqK - 1 >= 0) {
                        return bqK - 1;
                    }
                } else if (this.hQG == floatValue && bqK + 1 < x.getCount(this.hQK)) {
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
        if (this.hQK.size() > i) {
            this.hQM = this.hQK.get(i).floatValue();
        }
        float f = 0.0f;
        if (this.hQK.size() > this.mrP.bqK()) {
            f = this.hQK.get(this.mrP.bqK()).floatValue();
        }
        this.mMoveDistance = Math.abs(f - this.hQM);
        this.hQN = this.mrP.bqK() < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vu(int i) {
        if (this.kkX != null && !this.kkX.vs(this.mrP.bqK())) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.mrP.pG(i);
            if (this.hQK.size() > this.mrP.bqK()) {
                this.hQG = this.hQK.get(this.mrP.bqK()).floatValue();
            }
            invalidate();
        }
    }

    public void setNeedDayNight(boolean z) {
        this.mrQ = z;
        if (!this.mrQ) {
            this.mBackgroundPaint.setColor(ao.getColor(0, this.mBackgroundColorId));
            if (this.mrK != null) {
                this.mrK.setColor(com.baidu.tieba.tbadkCore.c.l(ao.getColor(0, this.mrH), this.mrJ));
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
        if (cE(list) || this.mrP == null || this.mrP.bqK() != i) {
            if (x.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            reset();
            setVisibility(0);
            this.mrP.pG(i);
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
        if (pVar.dlu() == pVar2.dlu() && pVar.dlv() != null && pVar.dlv().equals(pVar2.dlv())) {
            return true;
        }
        return pVar.dlu() == pVar2.dlu() && pVar.dlv() == null && pVar2.dlv() == null;
    }

    public void reset() {
        this.mrP.pG(0);
        this.hQG = 0.0f;
        this.hQI = false;
        this.mData.clear();
        this.hQK.clear();
        this.hQJ = true;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.kkX = aVar;
    }

    public void onChangeSkinType() {
        if (this.mrQ) {
            this.mBackgroundPaint.setColor(ao.getColor(this.mBackgroundColorId));
            if (this.mrK != null) {
                this.mrK.setColor(com.baidu.tieba.tbadkCore.c.l(ao.getColor(this.mBackgroundColorId), this.mrJ));
            }
            invalidate();
        }
    }

    public void setCanScroll(boolean z) {
        this.hQH = z;
    }

    public int getState() {
        return this.mrP.bqK();
    }

    public void changeState(int i) {
        if (!x.isEmpty(this.mData) && !x.isEmpty(this.hQK)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mData.size()) {
                    if (this.mData.get(i3).dlu() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.mrP.pG(i3);
                        if (this.hQK.size() > i3) {
                            this.hQG = this.hQK.get(i3).floatValue();
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
        this.mrS = bdUniqueId;
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.mrR) {
            this.listener.setTag(bdUniqueId);
        }
    }
}
