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
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.data.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SortSwitchButton extends View implements View.OnTouchListener {
    private float bPB;
    private Paint bQl;
    private Paint bex;
    private Path eTW;
    private CustomMessageListener fhw;
    private float hKD;
    private float jmB;
    private int jmC;
    private int jmD;
    private int jmE;
    private float jmF;
    private float jmG;
    private int jmH;
    private RectF jmK;
    private RectF jmL;
    private Path jmM;
    private float jmO;
    private boolean jmP;
    private boolean jmQ;
    private boolean jmR;
    private List<Float> jmS;
    private GestureDetector.SimpleOnGestureListener jmT;
    private float jmU;
    private boolean jmV;
    private a lFo;
    private int mBackgroundColorId;
    private Paint mBackgroundPaint;
    private List<q> mData;
    private GestureDetector mGestureDetector;
    private float mHeight;
    private float mMoveDistance;
    private float mTextSize;
    private ValueAnimator mValueAnimator;
    private BdUniqueId nQA;
    private e.a nQB;
    private int nQo;
    private float nQp;
    private float nQq;
    private Paint nQr;
    private RectF nQs;
    private Path nQt;
    private RectF nQu;
    private Path nQv;
    private com.baidu.tieba.e nQw;
    private boolean nQx;
    private boolean nQy;
    private BdUniqueId nQz;

    /* loaded from: classes.dex */
    public interface a {
        boolean zf(int i);
    }

    public SortSwitchButton(Context context) {
        this(context, null);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nQw = new com.baidu.tieba.e();
        this.jmP = false;
        this.jmQ = false;
        this.jmR = true;
        this.nQx = true;
        this.nQy = false;
        this.nQA = BdUniqueId.gen();
        this.fhw = new CustomMessageListener(2921458) { // from class: com.baidu.tieba.view.SortSwitchButton.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage) && (((CustomMessage) customResponsedMessage.getOrginalMessage()).getData() instanceof BdUniqueId)) {
                    BdUniqueId bdUniqueId = (BdUniqueId) ((CustomMessage) customResponsedMessage.getOrginalMessage()).getData();
                    BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                    if (tag != null && bdUniqueId != null && SortSwitchButton.this.nQz != null) {
                        Integer num = (Integer) customResponsedMessage.getData();
                        if (tag.getId() == SortSwitchButton.this.nQz.getId() && bdUniqueId.getId() != SortSwitchButton.this.nQA.getId() && SortSwitchButton.this.nQw.bJq() != num.intValue() && !x.isEmpty(SortSwitchButton.this.mData) && !x.isEmpty(SortSwitchButton.this.jmS) && SortSwitchButton.this.jmS.size() > num.intValue()) {
                            SortSwitchButton.this.nQw.sK(num.intValue());
                            SortSwitchButton.this.jmO = ((Float) SortSwitchButton.this.jmS.get(num.intValue())).floatValue();
                            SortSwitchButton.this.invalidate();
                        }
                    }
                }
            }
        };
        this.nQB = new e.a() { // from class: com.baidu.tieba.view.SortSwitchButton.2
            @Override // com.baidu.tieba.e.a
            public void bx(int i2, int i3) {
                ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i3));
                CustomMessage customMessage = new CustomMessage(2921458);
                customMessage.setTag(SortSwitchButton.this.nQz);
                customMessage.setData(SortSwitchButton.this.nQA);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        };
        this.jmT = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.view.SortSwitchButton.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!SortSwitchButton.this.jmQ && motionEvent.getX() <= SortSwitchButton.this.bPB && motionEvent.getY() <= SortSwitchButton.this.mHeight) {
                    if (SortSwitchButton.this.getParent() != null) {
                        SortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int bJq = SortSwitchButton.this.nQw.bJq();
                SortSwitchButton.this.jmO = motionEvent.getX();
                SortSwitchButton.this.nQw.sJ(SortSwitchButton.this.cFt());
                SortSwitchButton.this.jmQ = true;
                if (SortSwitchButton.this.nQw.bJq() != bJq) {
                    SortSwitchButton.this.zg(bJq);
                    if (SortSwitchButton.this.mValueAnimator != null) {
                        SortSwitchButton.this.mValueAnimator.start();
                    }
                    SortSwitchButton.this.zh(bJq);
                }
                SortSwitchButton.this.jmQ = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (SortSwitchButton.this.jmP) {
                    SortSwitchButton.this.jmO -= f;
                    if (SortSwitchButton.this.jmO < 0.0f) {
                        SortSwitchButton.this.jmO = 0.0f;
                    }
                    Float f3 = (Float) x.getItem(SortSwitchButton.this.jmS, SortSwitchButton.this.jmS.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (SortSwitchButton.this.jmO > floatValue) {
                        SortSwitchButton.this.jmO = floatValue;
                    }
                    SortSwitchButton.this.invalidate();
                    return true;
                }
                return false;
            }
        };
        c(context, attributeSet);
        init(context);
        setOnTouchListener(this);
        if (this.nQy) {
            this.nQw.a(this.nQB);
            MessageManager.getInstance().registerListener(this.fhw);
        }
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SortSwitchButton);
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_color, R.color.CAM_X0107);
        this.nQo = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_border_color, this.mBackgroundColorId);
        this.nQp = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_background_border_width, 0.0f);
        this.nQq = obtainStyledAttributes.getFloat(R.styleable.SortSwitchButton_background_border_alpha, 1.0f);
        this.jmC = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_color, R.color.CAM_X0101);
        this.jmD = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_un_selected_text_color, R.color.CAM_X0105);
        this.jmE = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_selected_text_color, R.color.CAM_X0105);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_size, 5.0f);
        this.jmF = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_horizontal_padding, 0.0f);
        this.jmB = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_height, 0.0f);
        this.jmG = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_border_width, 0.0f);
        this.jmH = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_border_color, R.color.CAM_X0105);
        this.nQy = obtainStyledAttributes.getBoolean(R.styleable.SortSwitchButton_slide_need_sync, false);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.jmK = new RectF();
        this.eTW = new Path();
        this.jmL = new RectF();
        this.jmM = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ao.getColor(this.mBackgroundColorId));
        if (this.nQo > 0 && this.nQp > 0.0f) {
            this.nQs = new RectF();
            this.nQt = new Path();
            this.nQu = new RectF();
            this.nQv = new Path();
            this.nQr = new Paint(1);
            this.nQr.setStyle(Paint.Style.STROKE);
            this.nQr.setStrokeWidth(this.nQp);
            this.nQr.setColor(com.baidu.tieba.tbadkCore.c.m(ao.getColor(this.mBackgroundColorId), this.nQq));
        }
        this.bQl = new Paint(1);
        this.bex = new Paint(1);
        this.bex.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.jmS = new ArrayList();
        this.nQw.sK(0);
        this.mGestureDetector = new GestureDetector(context, this.jmT);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SortSwitchButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * SortSwitchButton.this.mMoveDistance;
                if (SortSwitchButton.this.jmV) {
                    SortSwitchButton.this.jmO = SortSwitchButton.this.jmU - floatValue;
                } else {
                    SortSwitchButton.this.jmO = floatValue + SortSwitchButton.this.jmU;
                }
                SortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.view.SortSwitchButton.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (SortSwitchButton.this.jmS.size() > SortSwitchButton.this.nQw.bJq()) {
                    SortSwitchButton.this.jmO = ((Float) SortSwitchButton.this.jmS.get(SortSwitchButton.this.nQw.bJq())).floatValue();
                }
            }
        });
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        float f = 0.0f;
        super.onMeasure(i, i2);
        float size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        float size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int count = x.getCount(this.mData);
        if (mode == Integer.MIN_VALUE) {
            this.bPB = 0.0f;
            for (int i3 = 0; i3 < count; i3++) {
                q qVar = (q) x.getItem(this.mData, i3);
                if (qVar != null) {
                    float measureText = this.bex.measureText(qVar.dLA() == null ? "" : qVar.dLA()) + (this.jmF * 2.0f);
                    if (this.jmR) {
                        this.jmS.add(Float.valueOf(this.bPB));
                    }
                    this.bPB = measureText + this.bPB;
                }
            }
        } else {
            this.bPB = size;
            float f2 = this.bPB;
            if (count > 0) {
                f2 = this.bPB / count;
            }
            for (int i4 = 0; i4 < count; i4++) {
                if (this.jmR) {
                    this.jmS.add(Float.valueOf(f));
                }
                f += f2;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.jmB;
        } else {
            this.mHeight = size2;
            this.jmB = this.mHeight;
        }
        this.jmR = false;
        cFs();
        setMeasuredDimension((int) this.bPB, (int) this.mHeight);
    }

    private void cFs() {
        this.jmK.set(this.nQp, this.nQp, this.bPB - this.nQp, this.mHeight - this.nQp);
        this.eTW.reset();
        this.eTW.addRoundRect(this.jmK, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        if (this.nQs != null && this.nQr != null) {
            this.nQs.set(0.0f, 0.0f, this.bPB, this.mHeight);
            float f = this.nQp * 0.5f;
            this.nQu.set(-f, -f, this.bPB + f, this.mHeight + f);
            this.nQt.reset();
            this.nQv.reset();
            this.nQt.addRoundRect(this.nQs, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
            this.nQv.addRoundRect(this.nQu, (this.mHeight + f) * 0.5f, (f + this.mHeight) * 0.5f, Path.Direction.CW);
        }
        Float f2 = (Float) x.getItem(this.jmS, this.nQw.bJq());
        this.jmO = f2 != null ? f2.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.bex.getFontMetrics();
        this.hKD = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.nQv != null) {
            canvas.clipPath(this.nQv);
        } else {
            canvas.clipPath(this.eTW);
        }
        super.onDraw(canvas);
        aw(canvas);
        aa(canvas);
        int i = 0;
        while (i < this.mData.size() && i < this.jmS.size()) {
            a(canvas, this.mData.get(i).dLA(), this.jmS.get(i).floatValue() + this.jmF, this.hKD, this.nQw.bJq() == i);
            i++;
        }
    }

    private void aw(Canvas canvas) {
        canvas.drawPath(this.eTW, this.mBackgroundPaint);
        if (this.nQo > 0 && this.nQp > 0.0f && this.nQr != null) {
            canvas.drawPath(this.nQt, this.nQr);
        }
    }

    private void aa(Canvas canvas) {
        float f;
        if (this.jmO < 0.0f) {
            this.jmO = 0.0f;
        }
        float floatValue = !x.isEmpty(this.jmS) ? ((Float) x.getItem(this.jmS, this.nQw.bJq())).floatValue() : 0.0f;
        if (this.nQw.bJq() + 1 < this.jmS.size()) {
            f = this.jmS.get(this.nQw.bJq() + 1).floatValue();
        } else {
            f = this.nQw.bJq() + 1 == this.jmS.size() ? this.bPB : 0.0f;
        }
        float f2 = (f - floatValue) + this.jmO;
        if (f2 > this.bPB) {
            f2 = this.bPB;
        }
        this.jmL.set(this.jmO, 0.0f, f2, this.mHeight);
        this.jmM.reset();
        this.jmM.addRoundRect(this.jmL, this.jmB / 2.0f, this.jmB / 2.0f, Path.Direction.CW);
        this.bQl.reset();
        this.bQl.setAntiAlias(true);
        this.bQl.setColor(this.nQx ? ao.getColor(this.jmC) : ao.getColor(0, this.jmC));
        canvas.drawPath(this.jmM, this.bQl);
        this.bQl.reset();
        this.bQl.setAntiAlias(true);
        this.bQl.setColor(this.nQx ? ao.getColor(this.jmH) : ao.getColor(0, this.jmH));
        this.bQl.setStyle(Paint.Style.STROKE);
        this.bQl.setStrokeWidth(this.jmG);
        this.jmL.set(this.jmO + (this.jmG / 2.0f), this.jmG / 2.0f, f2 - (this.jmG / 2.0f), this.jmB - (this.jmG / 2.0f));
        float f3 = (this.jmB - this.jmG) / 2.0f;
        canvas.drawRoundRect(this.jmL, f3, f3, this.bQl);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.bex.setColor(this.nQx ? ao.getColor(this.jmE) : ao.getColor(0, this.jmE));
        } else {
            this.bex.setColor(this.nQx ? ao.getColor(this.jmD) : ao.getColor(0, this.jmD));
        }
        canvas.drawText(str, f, f2, this.bex);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.jmP && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int bJq = this.nQw.bJq();
            int cFt = cFt();
            if (Math.abs(cFt - bJq) >= 2 || cFt > bJq) {
                this.nQw.sK(cFt);
            } else if (cFt < bJq) {
                float floatValue = this.jmS.size() > cFt ? this.jmS.get(cFt).floatValue() : 0.0f;
                float floatValue2 = cFt + 1 < this.jmS.size() ? this.jmS.get(cFt + 1).floatValue() : floatValue;
                if (this.jmO >= floatValue && this.jmO <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.nQw.sK(cFt);
                }
            } else {
                float floatValue3 = this.jmS.size() > cFt ? this.jmS.get(cFt).floatValue() : 0.0f;
                if (this.jmO >= (((cFt + 1 < this.jmS.size() ? this.jmS.get(cFt + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cFt + 1 < this.jmS.size()) {
                    this.nQw.sK(cFt + 1);
                }
            }
            this.jmQ = true;
            this.jmU = this.jmO;
            float floatValue4 = this.jmS.size() > this.nQw.bJq() ? this.jmS.get(this.nQw.bJq()).floatValue() : 0.0f;
            this.mMoveDistance = Math.abs(this.jmU - floatValue4);
            if (this.nQw.bJq() < bJq) {
                this.jmV = true;
            } else if (this.nQw.bJq() > bJq) {
                this.jmV = false;
            } else {
                this.jmV = this.jmU > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.nQw.bJq() != bJq) {
                zh(bJq);
            }
            this.jmQ = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cFt() {
        float floatValue;
        int bJq = this.nQw.bJq();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.jmS.size()) {
                return bJq;
            }
            float floatValue2 = ((Float) x.getItem(this.jmS, i2)).floatValue();
            if (i2 + 1 == this.jmS.size()) {
                floatValue = this.bPB;
            } else {
                floatValue = ((Float) x.getItem(this.jmS, i2 + 1)).floatValue();
            }
            if (this.jmO <= floatValue2 || this.jmO >= floatValue) {
                if (this.jmO == floatValue2) {
                    if (bJq - 1 >= 0) {
                        return bJq - 1;
                    }
                } else if (this.jmO == floatValue && bJq + 1 < x.getCount(this.jmS)) {
                    return bJq + 1;
                }
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zg(int i) {
        if (this.jmS.size() > i) {
            this.jmU = this.jmS.get(i).floatValue();
        }
        float f = 0.0f;
        if (this.jmS.size() > this.nQw.bJq()) {
            f = this.jmS.get(this.nQw.bJq()).floatValue();
        }
        this.mMoveDistance = Math.abs(f - this.jmU);
        this.jmV = this.nQw.bJq() < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(int i) {
        if (this.lFo != null && !this.lFo.zf(this.nQw.bJq())) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.nQw.sJ(i);
            if (this.jmS.size() > this.nQw.bJq()) {
                this.jmO = this.jmS.get(this.nQw.bJq()).floatValue();
            }
            invalidate();
        }
    }

    public void setNeedDayNight(boolean z) {
        this.nQx = z;
        if (!this.nQx) {
            this.mBackgroundPaint.setColor(ao.getColor(0, this.mBackgroundColorId));
            if (this.nQr != null) {
                this.nQr.setColor(com.baidu.tieba.tbadkCore.c.m(ao.getColor(0, this.nQo), this.nQq));
            }
        }
    }

    public void setData(List<q> list) {
        if (ds(list)) {
            if (x.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.mData = list;
            requestLayout();
        }
    }

    public void setData(List<q> list, int i) {
        if (ds(list) || this.nQw == null || this.nQw.bJq() != i) {
            if (x.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            reset();
            setVisibility(0);
            this.nQw.sJ(i);
            this.mData = list;
            requestLayout();
        }
    }

    private boolean ds(List<q> list) {
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

    private boolean a(q qVar, q qVar2) {
        if (qVar == null && qVar2 == null) {
            return true;
        }
        if (qVar == null || qVar2 == null) {
            return false;
        }
        if (qVar.dLz() == qVar2.dLz() && qVar.dLA() != null && qVar.dLA().equals(qVar2.dLA())) {
            return true;
        }
        return qVar.dLz() == qVar2.dLz() && qVar.dLA() == null && qVar2.dLA() == null;
    }

    public void reset() {
        this.nQw.sJ(0);
        this.jmO = 0.0f;
        this.jmQ = false;
        this.mData.clear();
        this.jmS.clear();
        this.jmR = true;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.lFo = aVar;
    }

    public void onChangeSkinType() {
        if (this.nQx) {
            this.mBackgroundPaint.setColor(ao.getColor(this.mBackgroundColorId));
            if (this.nQr != null) {
                this.nQr.setColor(com.baidu.tieba.tbadkCore.c.m(ao.getColor(this.mBackgroundColorId), this.nQq));
            }
            invalidate();
        }
    }

    public void setCanScroll(boolean z) {
        this.jmP = z;
    }

    public int getState() {
        return this.nQw.bJq();
    }

    public void iC(int i) {
        if (!x.isEmpty(this.mData) && !x.isEmpty(this.jmS)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mData.size()) {
                    if (this.mData.get(i3).dLz() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.nQw.sJ(i3);
                        if (this.jmS.size() > i3) {
                            this.jmO = this.jmS.get(i3).floatValue();
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
        this.nQz = bdUniqueId;
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.nQy) {
            this.fhw.setTag(bdUniqueId);
        }
    }
}
