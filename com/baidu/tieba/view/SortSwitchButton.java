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
    private Paint bxt;
    private float gNl;
    private float ilJ;
    private int ilK;
    private int ilL;
    private int ilM;
    private float ilN;
    private float ilO;
    private int ilP;
    private RectF ilS;
    private Path ilT;
    private RectF ilU;
    private Path ilV;
    private float ilX;
    private boolean ilY;
    private boolean ilZ;
    private boolean ima;
    private List<Float> imb;
    private GestureDetector.SimpleOnGestureListener imc;
    private float imd;
    private boolean ime;
    private a kIV;
    private CustomMessageListener listener;
    private int mBackgroundColorId;
    private Paint mBackgroundPaint;
    private List<p> mData;
    private GestureDetector mGestureDetector;
    private float mHeight;
    private float mMoveDistance;
    private Paint mTextPaint;
    private float mTextSize;
    private int mUc;
    private float mUd;
    private float mUe;
    private Paint mUf;
    private RectF mUg;
    private Path mUh;
    private RectF mUi;
    private Path mUj;
    private com.baidu.tieba.e mUl;
    private boolean mUm;
    private boolean mUn;
    private BdUniqueId mUo;
    private BdUniqueId mUp;
    private e.a mUq;
    private ValueAnimator mValueAnimator;
    private float mWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean yk(int i);
    }

    public SortSwitchButton(Context context) {
        this(context, null);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mUl = new com.baidu.tieba.e();
        this.ilY = false;
        this.ilZ = false;
        this.ima = true;
        this.mUm = true;
        this.mUn = false;
        this.mUp = BdUniqueId.gen();
        this.listener = new CustomMessageListener(2921458) { // from class: com.baidu.tieba.view.SortSwitchButton.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage) && (((CustomMessage) customResponsedMessage.getOrginalMessage()).getData() instanceof BdUniqueId)) {
                    BdUniqueId bdUniqueId = (BdUniqueId) ((CustomMessage) customResponsedMessage.getOrginalMessage()).getData();
                    BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                    if (tag != null && bdUniqueId != null && SortSwitchButton.this.mUo != null) {
                        Integer num = (Integer) customResponsedMessage.getData();
                        if (tag.getId() == SortSwitchButton.this.mUo.getId() && bdUniqueId.getId() != SortSwitchButton.this.mUp.getId() && SortSwitchButton.this.mUl.bAS() != num.intValue() && !y.isEmpty(SortSwitchButton.this.mData) && !y.isEmpty(SortSwitchButton.this.imb) && SortSwitchButton.this.imb.size() > num.intValue()) {
                            SortSwitchButton.this.mUl.sk(num.intValue());
                            SortSwitchButton.this.ilX = ((Float) SortSwitchButton.this.imb.get(num.intValue())).floatValue();
                            SortSwitchButton.this.invalidate();
                        }
                    }
                }
            }
        };
        this.mUq = new e.a() { // from class: com.baidu.tieba.view.SortSwitchButton.2
            @Override // com.baidu.tieba.e.a
            public void bx(int i2, int i3) {
                ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i3));
                CustomMessage customMessage = new CustomMessage(2921458);
                customMessage.setTag(SortSwitchButton.this.mUo);
                customMessage.setData(SortSwitchButton.this.mUp);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        };
        this.imc = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.view.SortSwitchButton.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!SortSwitchButton.this.ilZ && motionEvent.getX() <= SortSwitchButton.this.mWidth && motionEvent.getY() <= SortSwitchButton.this.mHeight) {
                    if (SortSwitchButton.this.getParent() != null) {
                        SortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int bAS = SortSwitchButton.this.mUl.bAS();
                SortSwitchButton.this.ilX = motionEvent.getX();
                SortSwitchButton.this.mUl.sj(SortSwitchButton.this.cti());
                SortSwitchButton.this.ilZ = true;
                if (SortSwitchButton.this.mUl.bAS() != bAS) {
                    SortSwitchButton.this.yl(bAS);
                    if (SortSwitchButton.this.mValueAnimator != null) {
                        SortSwitchButton.this.mValueAnimator.start();
                    }
                    SortSwitchButton.this.ym(bAS);
                }
                SortSwitchButton.this.ilZ = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (SortSwitchButton.this.ilY) {
                    SortSwitchButton.this.ilX -= f;
                    if (SortSwitchButton.this.ilX < 0.0f) {
                        SortSwitchButton.this.ilX = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(SortSwitchButton.this.imb, SortSwitchButton.this.imb.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (SortSwitchButton.this.ilX > floatValue) {
                        SortSwitchButton.this.ilX = floatValue;
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
        if (this.mUn) {
            this.mUl.a(this.mUq);
            MessageManager.getInstance().registerListener(this.listener);
        }
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SortSwitchButton);
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_color, R.color.cp_cont_j);
        this.mUc = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_border_color, this.mBackgroundColorId);
        this.mUd = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_background_border_width, 0.0f);
        this.mUe = obtainStyledAttributes.getFloat(R.styleable.SortSwitchButton_background_border_alpha, 1.0f);
        this.ilK = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_color, R.color.cp_cont_a);
        this.ilL = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_un_selected_text_color, R.color.cp_cont_b);
        this.ilM = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_selected_text_color, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_size, 5.0f);
        this.ilN = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_horizontal_padding, 0.0f);
        this.ilJ = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_height, 0.0f);
        this.ilO = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_border_width, 0.0f);
        this.ilP = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_border_color, R.color.cp_cont_b);
        this.mUn = obtainStyledAttributes.getBoolean(R.styleable.SortSwitchButton_slide_need_sync, false);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.ilS = new RectF();
        this.ilT = new Path();
        this.ilU = new RectF();
        this.ilV = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        if (this.mUc > 0 && this.mUd > 0.0f) {
            this.mUg = new RectF();
            this.mUh = new Path();
            this.mUi = new RectF();
            this.mUj = new Path();
            this.mUf = new Paint(1);
            this.mUf.setStyle(Paint.Style.STROKE);
            this.mUf.setStrokeWidth(this.mUd);
            this.mUf.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(this.mBackgroundColorId), this.mUe));
        }
        this.bxt = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.imb = new ArrayList();
        this.mUl.sk(0);
        this.mGestureDetector = new GestureDetector(context, this.imc);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SortSwitchButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * SortSwitchButton.this.mMoveDistance;
                if (SortSwitchButton.this.ime) {
                    SortSwitchButton.this.ilX = SortSwitchButton.this.imd - floatValue;
                } else {
                    SortSwitchButton.this.ilX = floatValue + SortSwitchButton.this.imd;
                }
                SortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.view.SortSwitchButton.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (SortSwitchButton.this.imb.size() > SortSwitchButton.this.mUl.bAS()) {
                    SortSwitchButton.this.ilX = ((Float) SortSwitchButton.this.imb.get(SortSwitchButton.this.mUl.bAS())).floatValue();
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
                    float measureText = this.mTextPaint.measureText(pVar.dAR() == null ? "" : pVar.dAR()) + (this.ilN * 2.0f);
                    if (this.ima) {
                        this.imb.add(Float.valueOf(this.mWidth));
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
                if (this.ima) {
                    this.imb.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.ilJ;
        } else {
            this.mHeight = size2;
            this.ilJ = this.mHeight;
        }
        this.ima = false;
        zI();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void zI() {
        this.ilS.set(this.mUd, this.mUd, this.mWidth - this.mUd, this.mHeight - this.mUd);
        this.ilT.reset();
        this.ilT.addRoundRect(this.ilS, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        if (this.mUg != null && this.mUf != null) {
            this.mUg.set(0.0f, 0.0f, this.mWidth, this.mHeight);
            float f = this.mUd * 0.5f;
            this.mUi.set(-f, -f, this.mWidth + f, this.mHeight + f);
            this.mUh.reset();
            this.mUj.reset();
            this.mUh.addRoundRect(this.mUg, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
            this.mUj.addRoundRect(this.mUi, (this.mHeight + f) * 0.5f, (f + this.mHeight) * 0.5f, Path.Direction.CW);
        }
        Float f2 = (Float) y.getItem(this.imb, this.mUl.bAS());
        this.ilX = f2 != null ? f2.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.gNl = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mUj != null) {
            canvas.clipPath(this.mUj);
        } else {
            canvas.clipPath(this.ilT);
        }
        super.onDraw(canvas);
        ao(canvas);
        Q(canvas);
        int i = 0;
        while (i < this.mData.size() && i < this.imb.size()) {
            a(canvas, this.mData.get(i).dAR(), this.imb.get(i).floatValue() + this.ilN, this.gNl, this.mUl.bAS() == i);
            i++;
        }
    }

    private void ao(Canvas canvas) {
        canvas.drawPath(this.ilT, this.mBackgroundPaint);
        if (this.mUc > 0 && this.mUd > 0.0f && this.mUf != null) {
            canvas.drawPath(this.mUh, this.mUf);
        }
    }

    private void Q(Canvas canvas) {
        float f;
        this.ilV.reset();
        if (this.ilX < 0.0f) {
            this.ilX = 0.0f;
        }
        float floatValue = !y.isEmpty(this.imb) ? ((Float) y.getItem(this.imb, this.mUl.bAS())).floatValue() : 0.0f;
        if (this.mUl.bAS() + 1 < this.imb.size()) {
            f = this.imb.get(this.mUl.bAS() + 1).floatValue();
        } else {
            f = this.mUl.bAS() + 1 == this.imb.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.ilX;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.ilU.set(this.ilX, 0.0f, f2, this.mHeight);
        this.ilV.addRoundRect(this.ilU, this.ilJ / 2.0f, this.ilJ / 2.0f, Path.Direction.CW);
        this.bxt.setColor(this.mUm ? ap.getColor(this.ilP) : ap.getColor(0, this.ilP));
        canvas.drawPath(this.ilV, this.bxt);
        this.ilV.reset();
        this.ilU.set(this.ilX + this.ilO, this.ilO, f2 - this.ilO, this.mHeight - this.ilO);
        this.ilV.addRoundRect(this.ilU, (this.ilJ - (this.ilO * 2.0f)) / 2.0f, (this.ilJ - (this.ilO * 2.0f)) / 2.0f, Path.Direction.CW);
        this.bxt.setColor(this.mUm ? ap.getColor(this.ilK) : ap.getColor(0, this.ilK));
        canvas.drawPath(this.ilV, this.bxt);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(this.mUm ? ap.getColor(this.ilM) : ap.getColor(0, this.ilM));
        } else {
            this.mTextPaint.setColor(this.mUm ? ap.getColor(this.ilL) : ap.getColor(0, this.ilL));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.ilY && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int bAS = this.mUl.bAS();
            int cti = cti();
            if (Math.abs(cti - bAS) >= 2 || cti > bAS) {
                this.mUl.sk(cti);
            } else if (cti < bAS) {
                float floatValue = this.imb.size() > cti ? this.imb.get(cti).floatValue() : 0.0f;
                float floatValue2 = cti + 1 < this.imb.size() ? this.imb.get(cti + 1).floatValue() : floatValue;
                if (this.ilX >= floatValue && this.ilX <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.mUl.sk(cti);
                }
            } else {
                float floatValue3 = this.imb.size() > cti ? this.imb.get(cti).floatValue() : 0.0f;
                if (this.ilX >= (((cti + 1 < this.imb.size() ? this.imb.get(cti + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cti + 1 < this.imb.size()) {
                    this.mUl.sk(cti + 1);
                }
            }
            this.ilZ = true;
            this.imd = this.ilX;
            float floatValue4 = this.imb.size() > this.mUl.bAS() ? this.imb.get(this.mUl.bAS()).floatValue() : 0.0f;
            this.mMoveDistance = Math.abs(this.imd - floatValue4);
            if (this.mUl.bAS() < bAS) {
                this.ime = true;
            } else if (this.mUl.bAS() > bAS) {
                this.ime = false;
            } else {
                this.ime = this.imd > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.mUl.bAS() != bAS) {
                ym(bAS);
            }
            this.ilZ = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cti() {
        float floatValue;
        int bAS = this.mUl.bAS();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.imb.size()) {
                return bAS;
            }
            float floatValue2 = ((Float) y.getItem(this.imb, i2)).floatValue();
            if (i2 + 1 == this.imb.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) y.getItem(this.imb, i2 + 1)).floatValue();
            }
            if (this.ilX <= floatValue2 || this.ilX >= floatValue) {
                if (this.ilX == floatValue2) {
                    if (bAS - 1 >= 0) {
                        return bAS - 1;
                    }
                } else if (this.ilX == floatValue && bAS + 1 < y.getCount(this.imb)) {
                    return bAS + 1;
                }
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl(int i) {
        if (this.imb.size() > i) {
            this.imd = this.imb.get(i).floatValue();
        }
        float f = 0.0f;
        if (this.imb.size() > this.mUl.bAS()) {
            f = this.imb.get(this.mUl.bAS()).floatValue();
        }
        this.mMoveDistance = Math.abs(f - this.imd);
        this.ime = this.mUl.bAS() < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ym(int i) {
        if (this.kIV != null && !this.kIV.yk(this.mUl.bAS())) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.mUl.sj(i);
            if (this.imb.size() > this.mUl.bAS()) {
                this.ilX = this.imb.get(this.mUl.bAS()).floatValue();
            }
            invalidate();
        }
    }

    public void setNeedDayNight(boolean z) {
        this.mUm = z;
        if (!this.mUm) {
            this.mBackgroundPaint.setColor(ap.getColor(0, this.mBackgroundColorId));
            if (this.mUf != null) {
                this.mUf.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(0, this.mUc), this.mUe));
            }
        }
    }

    public void setData(List<p> list) {
        if (cM(list)) {
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
        if (cM(list) || this.mUl == null || this.mUl.bAS() != i) {
            if (y.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            reset();
            setVisibility(0);
            this.mUl.sj(i);
            this.mData = list;
            requestLayout();
        }
    }

    private boolean cM(List<p> list) {
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
        if (pVar.dAQ() == pVar2.dAQ() && pVar.dAR() != null && pVar.dAR().equals(pVar2.dAR())) {
            return true;
        }
        return pVar.dAQ() == pVar2.dAQ() && pVar.dAR() == null && pVar2.dAR() == null;
    }

    public void reset() {
        this.mUl.sj(0);
        this.ilX = 0.0f;
        this.ilZ = false;
        this.mData.clear();
        this.imb.clear();
        this.ima = true;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.kIV = aVar;
    }

    public void onChangeSkinType() {
        if (this.mUm) {
            this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
            if (this.mUf != null) {
                this.mUf.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(this.mBackgroundColorId), this.mUe));
            }
            invalidate();
        }
    }

    public void setCanScroll(boolean z) {
        this.ilY = z;
    }

    public int getState() {
        return this.mUl.bAS();
    }

    public void iX(int i) {
        if (!y.isEmpty(this.mData) && !y.isEmpty(this.imb)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mData.size()) {
                    if (this.mData.get(i3).dAQ() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.mUl.sj(i3);
                        if (this.imb.size() > i3) {
                            this.ilX = this.imb.get(i3).floatValue();
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
        this.mUo = bdUniqueId;
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.mUn) {
            this.listener.setTag(bdUniqueId);
        }
    }
}
