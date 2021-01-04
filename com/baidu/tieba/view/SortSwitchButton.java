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
    private Paint bUX;
    private float bUn;
    private Paint bjo;
    private Path eYH;
    private CustomMessageListener fmh;
    private float hPj;
    private float jrA;
    private boolean jrB;
    private float jrh;
    private int jri;
    private int jrj;
    private int jrk;
    private float jrl;
    private float jrm;
    private int jrn;
    private RectF jrq;
    private RectF jrr;
    private Path jrs;
    private float jru;
    private boolean jrv;
    private boolean jrw;
    private boolean jrx;
    private List<Float> jry;
    private GestureDetector.SimpleOnGestureListener jrz;
    private a lJT;
    private int mBackgroundColorId;
    private Paint mBackgroundPaint;
    private List<q> mData;
    private GestureDetector mGestureDetector;
    private float mHeight;
    private float mMoveDistance;
    private float mTextSize;
    private ValueAnimator mValueAnimator;
    private int nUT;
    private float nUU;
    private float nUV;
    private Paint nUW;
    private RectF nUX;
    private Path nUY;
    private RectF nUZ;
    private Path nVa;
    private com.baidu.tieba.e nVb;
    private boolean nVc;
    private boolean nVd;
    private BdUniqueId nVe;
    private BdUniqueId nVf;
    private e.a nVg;

    /* loaded from: classes.dex */
    public interface a {
        boolean AL(int i);
    }

    public SortSwitchButton(Context context) {
        this(context, null);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nVb = new com.baidu.tieba.e();
        this.jrv = false;
        this.jrw = false;
        this.jrx = true;
        this.nVc = true;
        this.nVd = false;
        this.nVf = BdUniqueId.gen();
        this.fmh = new CustomMessageListener(2921458) { // from class: com.baidu.tieba.view.SortSwitchButton.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage) && (((CustomMessage) customResponsedMessage.getOrginalMessage()).getData() instanceof BdUniqueId)) {
                    BdUniqueId bdUniqueId = (BdUniqueId) ((CustomMessage) customResponsedMessage.getOrginalMessage()).getData();
                    BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                    if (tag != null && bdUniqueId != null && SortSwitchButton.this.nVe != null) {
                        Integer num = (Integer) customResponsedMessage.getData();
                        if (tag.getId() == SortSwitchButton.this.nVe.getId() && bdUniqueId.getId() != SortSwitchButton.this.nVf.getId() && SortSwitchButton.this.nVb.bNh() != num.intValue() && !x.isEmpty(SortSwitchButton.this.mData) && !x.isEmpty(SortSwitchButton.this.jry) && SortSwitchButton.this.jry.size() > num.intValue()) {
                            SortSwitchButton.this.nVb.uq(num.intValue());
                            SortSwitchButton.this.jru = ((Float) SortSwitchButton.this.jry.get(num.intValue())).floatValue();
                            SortSwitchButton.this.invalidate();
                        }
                    }
                }
            }
        };
        this.nVg = new e.a() { // from class: com.baidu.tieba.view.SortSwitchButton.2
            @Override // com.baidu.tieba.e.a
            public void bx(int i2, int i3) {
                ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i3));
                CustomMessage customMessage = new CustomMessage(2921458);
                customMessage.setTag(SortSwitchButton.this.nVe);
                customMessage.setData(SortSwitchButton.this.nVf);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        };
        this.jrz = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.view.SortSwitchButton.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!SortSwitchButton.this.jrw && motionEvent.getX() <= SortSwitchButton.this.bUn && motionEvent.getY() <= SortSwitchButton.this.mHeight) {
                    if (SortSwitchButton.this.getParent() != null) {
                        SortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int bNh = SortSwitchButton.this.nVb.bNh();
                SortSwitchButton.this.jru = motionEvent.getX();
                SortSwitchButton.this.nVb.up(SortSwitchButton.this.cJk());
                SortSwitchButton.this.jrw = true;
                if (SortSwitchButton.this.nVb.bNh() != bNh) {
                    SortSwitchButton.this.AM(bNh);
                    if (SortSwitchButton.this.mValueAnimator != null) {
                        SortSwitchButton.this.mValueAnimator.start();
                    }
                    SortSwitchButton.this.AN(bNh);
                }
                SortSwitchButton.this.jrw = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (SortSwitchButton.this.jrv) {
                    SortSwitchButton.this.jru -= f;
                    if (SortSwitchButton.this.jru < 0.0f) {
                        SortSwitchButton.this.jru = 0.0f;
                    }
                    Float f3 = (Float) x.getItem(SortSwitchButton.this.jry, SortSwitchButton.this.jry.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (SortSwitchButton.this.jru > floatValue) {
                        SortSwitchButton.this.jru = floatValue;
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
        if (this.nVd) {
            this.nVb.a(this.nVg);
            MessageManager.getInstance().registerListener(this.fmh);
        }
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SortSwitchButton);
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_color, R.color.CAM_X0107);
        this.nUT = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_border_color, this.mBackgroundColorId);
        this.nUU = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_background_border_width, 0.0f);
        this.nUV = obtainStyledAttributes.getFloat(R.styleable.SortSwitchButton_background_border_alpha, 1.0f);
        this.jri = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_color, R.color.CAM_X0101);
        this.jrj = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_un_selected_text_color, R.color.CAM_X0105);
        this.jrk = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_selected_text_color, R.color.CAM_X0105);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_size, 5.0f);
        this.jrl = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_horizontal_padding, 0.0f);
        this.jrh = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_height, 0.0f);
        this.jrm = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_border_width, 0.0f);
        this.jrn = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_border_color, R.color.CAM_X0105);
        this.nVd = obtainStyledAttributes.getBoolean(R.styleable.SortSwitchButton_slide_need_sync, false);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.jrq = new RectF();
        this.eYH = new Path();
        this.jrr = new RectF();
        this.jrs = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ao.getColor(this.mBackgroundColorId));
        if (this.nUT > 0 && this.nUU > 0.0f) {
            this.nUX = new RectF();
            this.nUY = new Path();
            this.nUZ = new RectF();
            this.nVa = new Path();
            this.nUW = new Paint(1);
            this.nUW.setStyle(Paint.Style.STROKE);
            this.nUW.setStrokeWidth(this.nUU);
            this.nUW.setColor(com.baidu.tieba.tbadkCore.c.m(ao.getColor(this.mBackgroundColorId), this.nUV));
        }
        this.bUX = new Paint(1);
        this.bjo = new Paint(1);
        this.bjo.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.jry = new ArrayList();
        this.nVb.uq(0);
        this.mGestureDetector = new GestureDetector(context, this.jrz);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SortSwitchButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * SortSwitchButton.this.mMoveDistance;
                if (SortSwitchButton.this.jrB) {
                    SortSwitchButton.this.jru = SortSwitchButton.this.jrA - floatValue;
                } else {
                    SortSwitchButton.this.jru = floatValue + SortSwitchButton.this.jrA;
                }
                SortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.view.SortSwitchButton.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (SortSwitchButton.this.jry.size() > SortSwitchButton.this.nVb.bNh()) {
                    SortSwitchButton.this.jru = ((Float) SortSwitchButton.this.jry.get(SortSwitchButton.this.nVb.bNh())).floatValue();
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
            this.bUn = 0.0f;
            for (int i3 = 0; i3 < count; i3++) {
                q qVar = (q) x.getItem(this.mData, i3);
                if (qVar != null) {
                    float measureText = this.bjo.measureText(qVar.dPr() == null ? "" : qVar.dPr()) + (this.jrl * 2.0f);
                    if (this.jrx) {
                        this.jry.add(Float.valueOf(this.bUn));
                    }
                    this.bUn = measureText + this.bUn;
                }
            }
        } else {
            this.bUn = size;
            float f2 = this.bUn;
            if (count > 0) {
                f2 = this.bUn / count;
            }
            for (int i4 = 0; i4 < count; i4++) {
                if (this.jrx) {
                    this.jry.add(Float.valueOf(f));
                }
                f += f2;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.jrh;
        } else {
            this.mHeight = size2;
            this.jrh = this.mHeight;
        }
        this.jrx = false;
        cJj();
        setMeasuredDimension((int) this.bUn, (int) this.mHeight);
    }

    private void cJj() {
        this.jrq.set(this.nUU, this.nUU, this.bUn - this.nUU, this.mHeight - this.nUU);
        this.eYH.reset();
        this.eYH.addRoundRect(this.jrq, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        if (this.nUX != null && this.nUW != null) {
            this.nUX.set(0.0f, 0.0f, this.bUn, this.mHeight);
            float f = this.nUU * 0.5f;
            this.nUZ.set(-f, -f, this.bUn + f, this.mHeight + f);
            this.nUY.reset();
            this.nVa.reset();
            this.nUY.addRoundRect(this.nUX, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
            this.nVa.addRoundRect(this.nUZ, (this.mHeight + f) * 0.5f, (f + this.mHeight) * 0.5f, Path.Direction.CW);
        }
        Float f2 = (Float) x.getItem(this.jry, this.nVb.bNh());
        this.jru = f2 != null ? f2.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.bjo.getFontMetrics();
        this.hPj = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.nVa != null) {
            canvas.clipPath(this.nVa);
        } else {
            canvas.clipPath(this.eYH);
        }
        super.onDraw(canvas);
        aw(canvas);
        aa(canvas);
        int i = 0;
        while (i < this.mData.size() && i < this.jry.size()) {
            a(canvas, this.mData.get(i).dPr(), this.jry.get(i).floatValue() + this.jrl, this.hPj, this.nVb.bNh() == i);
            i++;
        }
    }

    private void aw(Canvas canvas) {
        canvas.drawPath(this.eYH, this.mBackgroundPaint);
        if (this.nUT > 0 && this.nUU > 0.0f && this.nUW != null) {
            canvas.drawPath(this.nUY, this.nUW);
        }
    }

    private void aa(Canvas canvas) {
        float f;
        if (this.jru < 0.0f) {
            this.jru = 0.0f;
        }
        float floatValue = !x.isEmpty(this.jry) ? ((Float) x.getItem(this.jry, this.nVb.bNh())).floatValue() : 0.0f;
        if (this.nVb.bNh() + 1 < this.jry.size()) {
            f = this.jry.get(this.nVb.bNh() + 1).floatValue();
        } else {
            f = this.nVb.bNh() + 1 == this.jry.size() ? this.bUn : 0.0f;
        }
        float f2 = (f - floatValue) + this.jru;
        if (f2 > this.bUn) {
            f2 = this.bUn;
        }
        this.jrr.set(this.jru, 0.0f, f2, this.mHeight);
        this.jrs.reset();
        this.jrs.addRoundRect(this.jrr, this.jrh / 2.0f, this.jrh / 2.0f, Path.Direction.CW);
        this.bUX.reset();
        this.bUX.setAntiAlias(true);
        this.bUX.setColor(this.nVc ? ao.getColor(this.jri) : ao.getColor(0, this.jri));
        canvas.drawPath(this.jrs, this.bUX);
        this.bUX.reset();
        this.bUX.setAntiAlias(true);
        this.bUX.setColor(this.nVc ? ao.getColor(this.jrn) : ao.getColor(0, this.jrn));
        this.bUX.setStyle(Paint.Style.STROKE);
        this.bUX.setStrokeWidth(this.jrm);
        this.jrr.set(this.jru + (this.jrm / 2.0f), this.jrm / 2.0f, f2 - (this.jrm / 2.0f), this.jrh - (this.jrm / 2.0f));
        float f3 = (this.jrh - this.jrm) / 2.0f;
        canvas.drawRoundRect(this.jrr, f3, f3, this.bUX);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.bjo.setColor(this.nVc ? ao.getColor(this.jrk) : ao.getColor(0, this.jrk));
        } else {
            this.bjo.setColor(this.nVc ? ao.getColor(this.jrj) : ao.getColor(0, this.jrj));
        }
        canvas.drawText(str, f, f2, this.bjo);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.jrv && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int bNh = this.nVb.bNh();
            int cJk = cJk();
            if (Math.abs(cJk - bNh) >= 2 || cJk > bNh) {
                this.nVb.uq(cJk);
            } else if (cJk < bNh) {
                float floatValue = this.jry.size() > cJk ? this.jry.get(cJk).floatValue() : 0.0f;
                float floatValue2 = cJk + 1 < this.jry.size() ? this.jry.get(cJk + 1).floatValue() : floatValue;
                if (this.jru >= floatValue && this.jru <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.nVb.uq(cJk);
                }
            } else {
                float floatValue3 = this.jry.size() > cJk ? this.jry.get(cJk).floatValue() : 0.0f;
                if (this.jru >= (((cJk + 1 < this.jry.size() ? this.jry.get(cJk + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cJk + 1 < this.jry.size()) {
                    this.nVb.uq(cJk + 1);
                }
            }
            this.jrw = true;
            this.jrA = this.jru;
            float floatValue4 = this.jry.size() > this.nVb.bNh() ? this.jry.get(this.nVb.bNh()).floatValue() : 0.0f;
            this.mMoveDistance = Math.abs(this.jrA - floatValue4);
            if (this.nVb.bNh() < bNh) {
                this.jrB = true;
            } else if (this.nVb.bNh() > bNh) {
                this.jrB = false;
            } else {
                this.jrB = this.jrA > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.nVb.bNh() != bNh) {
                AN(bNh);
            }
            this.jrw = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cJk() {
        float floatValue;
        int bNh = this.nVb.bNh();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.jry.size()) {
                return bNh;
            }
            float floatValue2 = ((Float) x.getItem(this.jry, i2)).floatValue();
            if (i2 + 1 == this.jry.size()) {
                floatValue = this.bUn;
            } else {
                floatValue = ((Float) x.getItem(this.jry, i2 + 1)).floatValue();
            }
            if (this.jru <= floatValue2 || this.jru >= floatValue) {
                if (this.jru == floatValue2) {
                    if (bNh - 1 >= 0) {
                        return bNh - 1;
                    }
                } else if (this.jru == floatValue && bNh + 1 < x.getCount(this.jry)) {
                    return bNh + 1;
                }
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AM(int i) {
        if (this.jry.size() > i) {
            this.jrA = this.jry.get(i).floatValue();
        }
        float f = 0.0f;
        if (this.jry.size() > this.nVb.bNh()) {
            f = this.jry.get(this.nVb.bNh()).floatValue();
        }
        this.mMoveDistance = Math.abs(f - this.jrA);
        this.jrB = this.nVb.bNh() < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AN(int i) {
        if (this.lJT != null && !this.lJT.AL(this.nVb.bNh())) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.nVb.up(i);
            if (this.jry.size() > this.nVb.bNh()) {
                this.jru = this.jry.get(this.nVb.bNh()).floatValue();
            }
            invalidate();
        }
    }

    public void setNeedDayNight(boolean z) {
        this.nVc = z;
        if (!this.nVc) {
            this.mBackgroundPaint.setColor(ao.getColor(0, this.mBackgroundColorId));
            if (this.nUW != null) {
                this.nUW.setColor(com.baidu.tieba.tbadkCore.c.m(ao.getColor(0, this.nUT), this.nUV));
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
        if (ds(list) || this.nVb == null || this.nVb.bNh() != i) {
            if (x.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            reset();
            setVisibility(0);
            this.nVb.up(i);
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
        if (qVar.dPq() == qVar2.dPq() && qVar.dPr() != null && qVar.dPr().equals(qVar2.dPr())) {
            return true;
        }
        return qVar.dPq() == qVar2.dPq() && qVar.dPr() == null && qVar2.dPr() == null;
    }

    public void reset() {
        this.nVb.up(0);
        this.jru = 0.0f;
        this.jrw = false;
        this.mData.clear();
        this.jry.clear();
        this.jrx = true;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.lJT = aVar;
    }

    public void onChangeSkinType() {
        if (this.nVc) {
            this.mBackgroundPaint.setColor(ao.getColor(this.mBackgroundColorId));
            if (this.nUW != null) {
                this.nUW.setColor(com.baidu.tieba.tbadkCore.c.m(ao.getColor(this.mBackgroundColorId), this.nUV));
            }
            invalidate();
        }
    }

    public void setCanScroll(boolean z) {
        this.jrv = z;
    }

    public int getState() {
        return this.nVb.bNh();
    }

    public void ki(int i) {
        if (!x.isEmpty(this.mData) && !x.isEmpty(this.jry)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mData.size()) {
                    if (this.mData.get(i3).dPq() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.nVb.up(i3);
                        if (this.jry.size() > i3) {
                            this.jru = this.jry.get(i3).floatValue();
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
        this.nVe = bdUniqueId;
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.nVd) {
            this.fmh.setTag(bdUniqueId);
        }
    }
}
