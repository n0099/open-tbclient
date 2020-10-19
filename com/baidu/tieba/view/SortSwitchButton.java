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
    private Paint bDW;
    private float hci;
    private float iAE;
    private int iAF;
    private int iAG;
    private int iAH;
    private float iAI;
    private float iAJ;
    private int iAK;
    private RectF iAN;
    private Path iAO;
    private RectF iAP;
    private Path iAQ;
    private float iAS;
    private boolean iAT;
    private boolean iAU;
    private boolean iAV;
    private List<Float> iAW;
    private GestureDetector.SimpleOnGestureListener iAX;
    private float iAY;
    private boolean iAZ;
    private a kYg;
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
    private int njC;
    private float njD;
    private float njE;
    private Paint njF;
    private RectF njG;
    private Path njH;
    private RectF njI;
    private Path njJ;
    private com.baidu.tieba.e njK;
    private boolean njL;
    private boolean njM;
    private BdUniqueId njN;
    private BdUniqueId njO;
    private e.a njP;

    /* loaded from: classes.dex */
    public interface a {
        boolean yQ(int i);
    }

    public SortSwitchButton(Context context) {
        this(context, null);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.njK = new com.baidu.tieba.e();
        this.iAT = false;
        this.iAU = false;
        this.iAV = true;
        this.njL = true;
        this.njM = false;
        this.njO = BdUniqueId.gen();
        this.listener = new CustomMessageListener(2921458) { // from class: com.baidu.tieba.view.SortSwitchButton.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage) && (((CustomMessage) customResponsedMessage.getOrginalMessage()).getData() instanceof BdUniqueId)) {
                    BdUniqueId bdUniqueId = (BdUniqueId) ((CustomMessage) customResponsedMessage.getOrginalMessage()).getData();
                    BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                    if (tag != null && bdUniqueId != null && SortSwitchButton.this.njN != null) {
                        Integer num = (Integer) customResponsedMessage.getData();
                        if (tag.getId() == SortSwitchButton.this.njN.getId() && bdUniqueId.getId() != SortSwitchButton.this.njO.getId() && SortSwitchButton.this.njK.bDE() != num.intValue() && !y.isEmpty(SortSwitchButton.this.mData) && !y.isEmpty(SortSwitchButton.this.iAW) && SortSwitchButton.this.iAW.size() > num.intValue()) {
                            SortSwitchButton.this.njK.sI(num.intValue());
                            SortSwitchButton.this.iAS = ((Float) SortSwitchButton.this.iAW.get(num.intValue())).floatValue();
                            SortSwitchButton.this.invalidate();
                        }
                    }
                }
            }
        };
        this.njP = new e.a() { // from class: com.baidu.tieba.view.SortSwitchButton.2
            @Override // com.baidu.tieba.e.a
            public void bw(int i2, int i3) {
                ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i3));
                CustomMessage customMessage = new CustomMessage(2921458);
                customMessage.setTag(SortSwitchButton.this.njN);
                customMessage.setData(SortSwitchButton.this.njO);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        };
        this.iAX = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.view.SortSwitchButton.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!SortSwitchButton.this.iAU && motionEvent.getX() <= SortSwitchButton.this.mWidth && motionEvent.getY() <= SortSwitchButton.this.mHeight) {
                    if (SortSwitchButton.this.getParent() != null) {
                        SortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int bDE = SortSwitchButton.this.njK.bDE();
                SortSwitchButton.this.iAS = motionEvent.getX();
                SortSwitchButton.this.njK.sH(SortSwitchButton.this.cwF());
                SortSwitchButton.this.iAU = true;
                if (SortSwitchButton.this.njK.bDE() != bDE) {
                    SortSwitchButton.this.yR(bDE);
                    if (SortSwitchButton.this.mValueAnimator != null) {
                        SortSwitchButton.this.mValueAnimator.start();
                    }
                    SortSwitchButton.this.yS(bDE);
                }
                SortSwitchButton.this.iAU = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (SortSwitchButton.this.iAT) {
                    SortSwitchButton.this.iAS -= f;
                    if (SortSwitchButton.this.iAS < 0.0f) {
                        SortSwitchButton.this.iAS = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(SortSwitchButton.this.iAW, SortSwitchButton.this.iAW.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (SortSwitchButton.this.iAS > floatValue) {
                        SortSwitchButton.this.iAS = floatValue;
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
        if (this.njM) {
            this.njK.a(this.njP);
            MessageManager.getInstance().registerListener(this.listener);
        }
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SortSwitchButton);
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_color, R.color.cp_cont_j);
        this.njC = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_border_color, this.mBackgroundColorId);
        this.njD = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_background_border_width, 0.0f);
        this.njE = obtainStyledAttributes.getFloat(R.styleable.SortSwitchButton_background_border_alpha, 1.0f);
        this.iAF = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_color, R.color.cp_cont_a);
        this.iAG = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_un_selected_text_color, R.color.cp_cont_b);
        this.iAH = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_selected_text_color, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_size, 5.0f);
        this.iAI = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_horizontal_padding, 0.0f);
        this.iAE = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_height, 0.0f);
        this.iAJ = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_border_width, 0.0f);
        this.iAK = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_border_color, R.color.cp_cont_b);
        this.njM = obtainStyledAttributes.getBoolean(R.styleable.SortSwitchButton_slide_need_sync, false);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.iAN = new RectF();
        this.iAO = new Path();
        this.iAP = new RectF();
        this.iAQ = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        if (this.njC > 0 && this.njD > 0.0f) {
            this.njG = new RectF();
            this.njH = new Path();
            this.njI = new RectF();
            this.njJ = new Path();
            this.njF = new Paint(1);
            this.njF.setStyle(Paint.Style.STROKE);
            this.njF.setStrokeWidth(this.njD);
            this.njF.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(this.mBackgroundColorId), this.njE));
        }
        this.bDW = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.iAW = new ArrayList();
        this.njK.sI(0);
        this.mGestureDetector = new GestureDetector(context, this.iAX);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SortSwitchButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * SortSwitchButton.this.mMoveDistance;
                if (SortSwitchButton.this.iAZ) {
                    SortSwitchButton.this.iAS = SortSwitchButton.this.iAY - floatValue;
                } else {
                    SortSwitchButton.this.iAS = floatValue + SortSwitchButton.this.iAY;
                }
                SortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.view.SortSwitchButton.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (SortSwitchButton.this.iAW.size() > SortSwitchButton.this.njK.bDE()) {
                    SortSwitchButton.this.iAS = ((Float) SortSwitchButton.this.iAW.get(SortSwitchButton.this.njK.bDE())).floatValue();
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
                    float measureText = this.mTextPaint.measureText(pVar.dED() == null ? "" : pVar.dED()) + (this.iAI * 2.0f);
                    if (this.iAV) {
                        this.iAW.add(Float.valueOf(this.mWidth));
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
                if (this.iAV) {
                    this.iAW.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.iAE;
        } else {
            this.mHeight = size2;
            this.iAE = this.mHeight;
        }
        this.iAV = false;
        zQ();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void zQ() {
        this.iAN.set(this.njD, this.njD, this.mWidth - this.njD, this.mHeight - this.njD);
        this.iAO.reset();
        this.iAO.addRoundRect(this.iAN, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        if (this.njG != null && this.njF != null) {
            this.njG.set(0.0f, 0.0f, this.mWidth, this.mHeight);
            float f = this.njD * 0.5f;
            this.njI.set(-f, -f, this.mWidth + f, this.mHeight + f);
            this.njH.reset();
            this.njJ.reset();
            this.njH.addRoundRect(this.njG, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
            this.njJ.addRoundRect(this.njI, (this.mHeight + f) * 0.5f, (f + this.mHeight) * 0.5f, Path.Direction.CW);
        }
        Float f2 = (Float) y.getItem(this.iAW, this.njK.bDE());
        this.iAS = f2 != null ? f2.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.hci = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.njJ != null) {
            canvas.clipPath(this.njJ);
        } else {
            canvas.clipPath(this.iAO);
        }
        super.onDraw(canvas);
        ap(canvas);
        R(canvas);
        int i = 0;
        while (i < this.mData.size() && i < this.iAW.size()) {
            a(canvas, this.mData.get(i).dED(), this.iAW.get(i).floatValue() + this.iAI, this.hci, this.njK.bDE() == i);
            i++;
        }
    }

    private void ap(Canvas canvas) {
        canvas.drawPath(this.iAO, this.mBackgroundPaint);
        if (this.njC > 0 && this.njD > 0.0f && this.njF != null) {
            canvas.drawPath(this.njH, this.njF);
        }
    }

    private void R(Canvas canvas) {
        float f;
        this.iAQ.reset();
        if (this.iAS < 0.0f) {
            this.iAS = 0.0f;
        }
        float floatValue = !y.isEmpty(this.iAW) ? ((Float) y.getItem(this.iAW, this.njK.bDE())).floatValue() : 0.0f;
        if (this.njK.bDE() + 1 < this.iAW.size()) {
            f = this.iAW.get(this.njK.bDE() + 1).floatValue();
        } else {
            f = this.njK.bDE() + 1 == this.iAW.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.iAS;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.iAP.set(this.iAS, 0.0f, f2, this.mHeight);
        this.iAQ.addRoundRect(this.iAP, this.iAE / 2.0f, this.iAE / 2.0f, Path.Direction.CW);
        this.bDW.setColor(this.njL ? ap.getColor(this.iAK) : ap.getColor(0, this.iAK));
        canvas.drawPath(this.iAQ, this.bDW);
        this.iAQ.reset();
        this.iAP.set(this.iAS + this.iAJ, this.iAJ, f2 - this.iAJ, this.mHeight - this.iAJ);
        this.iAQ.addRoundRect(this.iAP, (this.iAE - (this.iAJ * 2.0f)) / 2.0f, (this.iAE - (this.iAJ * 2.0f)) / 2.0f, Path.Direction.CW);
        this.bDW.setColor(this.njL ? ap.getColor(this.iAF) : ap.getColor(0, this.iAF));
        canvas.drawPath(this.iAQ, this.bDW);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(this.njL ? ap.getColor(this.iAH) : ap.getColor(0, this.iAH));
        } else {
            this.mTextPaint.setColor(this.njL ? ap.getColor(this.iAG) : ap.getColor(0, this.iAG));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.iAT && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int bDE = this.njK.bDE();
            int cwF = cwF();
            if (Math.abs(cwF - bDE) >= 2 || cwF > bDE) {
                this.njK.sI(cwF);
            } else if (cwF < bDE) {
                float floatValue = this.iAW.size() > cwF ? this.iAW.get(cwF).floatValue() : 0.0f;
                float floatValue2 = cwF + 1 < this.iAW.size() ? this.iAW.get(cwF + 1).floatValue() : floatValue;
                if (this.iAS >= floatValue && this.iAS <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.njK.sI(cwF);
                }
            } else {
                float floatValue3 = this.iAW.size() > cwF ? this.iAW.get(cwF).floatValue() : 0.0f;
                if (this.iAS >= (((cwF + 1 < this.iAW.size() ? this.iAW.get(cwF + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cwF + 1 < this.iAW.size()) {
                    this.njK.sI(cwF + 1);
                }
            }
            this.iAU = true;
            this.iAY = this.iAS;
            float floatValue4 = this.iAW.size() > this.njK.bDE() ? this.iAW.get(this.njK.bDE()).floatValue() : 0.0f;
            this.mMoveDistance = Math.abs(this.iAY - floatValue4);
            if (this.njK.bDE() < bDE) {
                this.iAZ = true;
            } else if (this.njK.bDE() > bDE) {
                this.iAZ = false;
            } else {
                this.iAZ = this.iAY > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.njK.bDE() != bDE) {
                yS(bDE);
            }
            this.iAU = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cwF() {
        float floatValue;
        int bDE = this.njK.bDE();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.iAW.size()) {
                return bDE;
            }
            float floatValue2 = ((Float) y.getItem(this.iAW, i2)).floatValue();
            if (i2 + 1 == this.iAW.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) y.getItem(this.iAW, i2 + 1)).floatValue();
            }
            if (this.iAS <= floatValue2 || this.iAS >= floatValue) {
                if (this.iAS == floatValue2) {
                    if (bDE - 1 >= 0) {
                        return bDE - 1;
                    }
                } else if (this.iAS == floatValue && bDE + 1 < y.getCount(this.iAW)) {
                    return bDE + 1;
                }
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yR(int i) {
        if (this.iAW.size() > i) {
            this.iAY = this.iAW.get(i).floatValue();
        }
        float f = 0.0f;
        if (this.iAW.size() > this.njK.bDE()) {
            f = this.iAW.get(this.njK.bDE()).floatValue();
        }
        this.mMoveDistance = Math.abs(f - this.iAY);
        this.iAZ = this.njK.bDE() < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yS(int i) {
        if (this.kYg != null && !this.kYg.yQ(this.njK.bDE())) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.njK.sH(i);
            if (this.iAW.size() > this.njK.bDE()) {
                this.iAS = this.iAW.get(this.njK.bDE()).floatValue();
            }
            invalidate();
        }
    }

    public void setNeedDayNight(boolean z) {
        this.njL = z;
        if (!this.njL) {
            this.mBackgroundPaint.setColor(ap.getColor(0, this.mBackgroundColorId));
            if (this.njF != null) {
                this.njF.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(0, this.njC), this.njE));
            }
        }
    }

    public void setData(List<p> list) {
        if (cP(list)) {
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
        if (cP(list) || this.njK == null || this.njK.bDE() != i) {
            if (y.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            reset();
            setVisibility(0);
            this.njK.sH(i);
            this.mData = list;
            requestLayout();
        }
    }

    private boolean cP(List<p> list) {
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
        if (pVar.dEC() == pVar2.dEC() && pVar.dED() != null && pVar.dED().equals(pVar2.dED())) {
            return true;
        }
        return pVar.dEC() == pVar2.dEC() && pVar.dED() == null && pVar2.dED() == null;
    }

    public void reset() {
        this.njK.sH(0);
        this.iAS = 0.0f;
        this.iAU = false;
        this.mData.clear();
        this.iAW.clear();
        this.iAV = true;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.kYg = aVar;
    }

    public void onChangeSkinType() {
        if (this.njL) {
            this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
            if (this.njF != null) {
                this.njF.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(this.mBackgroundColorId), this.njE));
            }
            invalidate();
        }
    }

    public void setCanScroll(boolean z) {
        this.iAT = z;
    }

    public int getState() {
        return this.njK.bDE();
    }

    public void ju(int i) {
        if (!y.isEmpty(this.mData) && !y.isEmpty(this.iAW)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mData.size()) {
                    if (this.mData.get(i3).dEC() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.njK.sH(i3);
                        if (this.iAW.size() > i3) {
                            this.iAS = this.iAW.get(i3).floatValue();
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
        this.njN = bdUniqueId;
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.njM) {
            this.listener.setTag(bdUniqueId);
        }
    }
}
