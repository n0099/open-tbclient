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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.data.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SortSwitchButton extends View implements View.OnTouchListener {
    private float bUR;
    private Paint bVB;
    private Paint bjh;
    private Path eXL;
    private CustomMessageListener flo;
    private float hQU;
    private float jue;
    private int juf;
    private int jug;
    private int juh;
    private float jui;
    private float juj;
    private int juk;
    private RectF jun;
    private RectF juo;
    private Path jup;
    private float jur;
    private boolean jus;
    private boolean jut;
    private boolean juu;
    private List<Float> juv;
    private GestureDetector.SimpleOnGestureListener juw;
    private float jux;
    private boolean juy;
    private a lQv;
    private int mBackgroundColorId;
    private Paint mBackgroundPaint;
    private List<r> mData;
    private GestureDetector mGestureDetector;
    private float mHeight;
    private float mMoveDistance;
    private float mTextSize;
    private ValueAnimator mValueAnimator;
    private int ocZ;
    private float oda;
    private float odb;
    private Paint odc;
    private RectF odd;
    private Path ode;
    private RectF odf;
    private Path odg;
    private com.baidu.tieba.e odh;
    private boolean odi;
    private boolean odj;
    private BdUniqueId odk;
    private BdUniqueId odl;
    private e.a odm;

    /* loaded from: classes.dex */
    public interface a {
        boolean zq(int i);
    }

    public SortSwitchButton(Context context) {
        this(context, null);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.odh = new com.baidu.tieba.e();
        this.jus = false;
        this.jut = false;
        this.juu = true;
        this.odi = true;
        this.odj = false;
        this.odl = BdUniqueId.gen();
        this.flo = new CustomMessageListener(2921458) { // from class: com.baidu.tieba.view.SortSwitchButton.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage) && (((CustomMessage) customResponsedMessage.getOrginalMessage()).getData() instanceof BdUniqueId)) {
                    BdUniqueId bdUniqueId = (BdUniqueId) ((CustomMessage) customResponsedMessage.getOrginalMessage()).getData();
                    BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                    if (tag != null && bdUniqueId != null && SortSwitchButton.this.odk != null) {
                        Integer num = (Integer) customResponsedMessage.getData();
                        if (tag.getId() == SortSwitchButton.this.odk.getId() && bdUniqueId.getId() != SortSwitchButton.this.odl.getId() && SortSwitchButton.this.odh.bJT() != num.intValue() && !y.isEmpty(SortSwitchButton.this.mData) && !y.isEmpty(SortSwitchButton.this.juv) && SortSwitchButton.this.juv.size() > num.intValue()) {
                            SortSwitchButton.this.odh.sR(num.intValue());
                            SortSwitchButton.this.jur = ((Float) SortSwitchButton.this.juv.get(num.intValue())).floatValue();
                            SortSwitchButton.this.invalidate();
                        }
                    }
                }
            }
        };
        this.odm = new e.a() { // from class: com.baidu.tieba.view.SortSwitchButton.2
            @Override // com.baidu.tieba.e.a
            public void bu(int i2, int i3) {
                ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i3));
                CustomMessage customMessage = new CustomMessage(2921458);
                customMessage.setTag(SortSwitchButton.this.odk);
                customMessage.setData(SortSwitchButton.this.odl);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        };
        this.juw = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.view.SortSwitchButton.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!SortSwitchButton.this.jut && motionEvent.getX() <= SortSwitchButton.this.bUR && motionEvent.getY() <= SortSwitchButton.this.mHeight) {
                    if (SortSwitchButton.this.getParent() != null) {
                        SortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int bJT = SortSwitchButton.this.odh.bJT();
                SortSwitchButton.this.jur = motionEvent.getX();
                SortSwitchButton.this.odh.sQ(SortSwitchButton.this.cGT());
                SortSwitchButton.this.jut = true;
                if (SortSwitchButton.this.odh.bJT() != bJT) {
                    SortSwitchButton.this.zr(bJT);
                    if (SortSwitchButton.this.mValueAnimator != null) {
                        SortSwitchButton.this.mValueAnimator.start();
                    }
                    SortSwitchButton.this.zs(bJT);
                }
                SortSwitchButton.this.jut = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (SortSwitchButton.this.jus) {
                    SortSwitchButton.this.jur -= f;
                    if (SortSwitchButton.this.jur < 0.0f) {
                        SortSwitchButton.this.jur = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(SortSwitchButton.this.juv, SortSwitchButton.this.juv.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (SortSwitchButton.this.jur > floatValue) {
                        SortSwitchButton.this.jur = floatValue;
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
        if (this.odj) {
            this.odh.a(this.odm);
            MessageManager.getInstance().registerListener(this.flo);
        }
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SortSwitchButton);
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_color, R.color.CAM_X0107);
        this.ocZ = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_border_color, this.mBackgroundColorId);
        this.oda = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_background_border_width, 0.0f);
        this.odb = obtainStyledAttributes.getFloat(R.styleable.SortSwitchButton_background_border_alpha, 1.0f);
        this.juf = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_color, R.color.CAM_X0101);
        this.jug = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_un_selected_text_color, R.color.CAM_X0105);
        this.juh = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_selected_text_color, R.color.CAM_X0105);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_size, 5.0f);
        this.jui = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_horizontal_padding, 0.0f);
        this.jue = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_height, 0.0f);
        this.juj = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_border_width, 0.0f);
        this.juk = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_border_color, R.color.CAM_X0105);
        this.odj = obtainStyledAttributes.getBoolean(R.styleable.SortSwitchButton_slide_need_sync, false);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.jun = new RectF();
        this.eXL = new Path();
        this.juo = new RectF();
        this.jup = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        if (this.ocZ > 0 && this.oda > 0.0f) {
            this.odd = new RectF();
            this.ode = new Path();
            this.odf = new RectF();
            this.odg = new Path();
            this.odc = new Paint(1);
            this.odc.setStyle(Paint.Style.STROKE);
            this.odc.setStrokeWidth(this.oda);
            this.odc.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(this.mBackgroundColorId), this.odb));
        }
        this.bVB = new Paint(1);
        this.bjh = new Paint(1);
        this.bjh.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.juv = new ArrayList();
        this.odh.sR(0);
        this.mGestureDetector = new GestureDetector(context, this.juw);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SortSwitchButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * SortSwitchButton.this.mMoveDistance;
                if (SortSwitchButton.this.juy) {
                    SortSwitchButton.this.jur = SortSwitchButton.this.jux - floatValue;
                } else {
                    SortSwitchButton.this.jur = floatValue + SortSwitchButton.this.jux;
                }
                SortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.view.SortSwitchButton.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (SortSwitchButton.this.juv.size() > SortSwitchButton.this.odh.bJT()) {
                    SortSwitchButton.this.jur = ((Float) SortSwitchButton.this.juv.get(SortSwitchButton.this.odh.bJT())).floatValue();
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
        int count = y.getCount(this.mData);
        if (mode == Integer.MIN_VALUE) {
            this.bUR = 0.0f;
            for (int i3 = 0; i3 < count; i3++) {
                r rVar = (r) y.getItem(this.mData, i3);
                if (rVar != null) {
                    float measureText = this.bjh.measureText(rVar.dOc() == null ? "" : rVar.dOc()) + (this.jui * 2.0f);
                    if (this.juu) {
                        this.juv.add(Float.valueOf(this.bUR));
                    }
                    this.bUR = measureText + this.bUR;
                }
            }
        } else {
            this.bUR = size;
            float f2 = this.bUR;
            if (count > 0) {
                f2 = this.bUR / count;
            }
            for (int i4 = 0; i4 < count; i4++) {
                if (this.juu) {
                    this.juv.add(Float.valueOf(f));
                }
                f += f2;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.jue;
        } else {
            this.mHeight = size2;
            this.jue = this.mHeight;
        }
        this.juu = false;
        cGS();
        setMeasuredDimension((int) this.bUR, (int) this.mHeight);
    }

    private void cGS() {
        this.jun.set(this.oda, this.oda, this.bUR - this.oda, this.mHeight - this.oda);
        this.eXL.reset();
        this.eXL.addRoundRect(this.jun, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        if (this.odd != null && this.odc != null) {
            this.odd.set(0.0f, 0.0f, this.bUR, this.mHeight);
            float f = this.oda * 0.5f;
            this.odf.set(-f, -f, this.bUR + f, this.mHeight + f);
            this.ode.reset();
            this.odg.reset();
            this.ode.addRoundRect(this.odd, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
            this.odg.addRoundRect(this.odf, (this.mHeight + f) * 0.5f, (f + this.mHeight) * 0.5f, Path.Direction.CW);
        }
        Float f2 = (Float) y.getItem(this.juv, this.odh.bJT());
        this.jur = f2 != null ? f2.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.bjh.getFontMetrics();
        this.hQU = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.odg != null) {
            canvas.clipPath(this.odg);
        } else {
            canvas.clipPath(this.eXL);
        }
        super.onDraw(canvas);
        aw(canvas);
        aa(canvas);
        int i = 0;
        while (i < this.mData.size() && i < this.juv.size()) {
            a(canvas, this.mData.get(i).dOc(), this.juv.get(i).floatValue() + this.jui, this.hQU, this.odh.bJT() == i);
            i++;
        }
    }

    private void aw(Canvas canvas) {
        canvas.drawPath(this.eXL, this.mBackgroundPaint);
        if (this.ocZ > 0 && this.oda > 0.0f && this.odc != null) {
            canvas.drawPath(this.ode, this.odc);
        }
    }

    private void aa(Canvas canvas) {
        float f;
        if (this.jur < 0.0f) {
            this.jur = 0.0f;
        }
        float floatValue = !y.isEmpty(this.juv) ? ((Float) y.getItem(this.juv, this.odh.bJT())).floatValue() : 0.0f;
        if (this.odh.bJT() + 1 < this.juv.size()) {
            f = this.juv.get(this.odh.bJT() + 1).floatValue();
        } else {
            f = this.odh.bJT() + 1 == this.juv.size() ? this.bUR : 0.0f;
        }
        float f2 = (f - floatValue) + this.jur;
        if (f2 > this.bUR) {
            f2 = this.bUR;
        }
        this.juo.set(this.jur, 0.0f, f2, this.mHeight);
        this.jup.reset();
        this.jup.addRoundRect(this.juo, this.jue / 2.0f, this.jue / 2.0f, Path.Direction.CW);
        this.bVB.reset();
        this.bVB.setAntiAlias(true);
        this.bVB.setColor(this.odi ? ap.getColor(this.juf) : ap.getColor(0, this.juf));
        canvas.drawPath(this.jup, this.bVB);
        this.bVB.reset();
        this.bVB.setAntiAlias(true);
        this.bVB.setColor(this.odi ? ap.getColor(this.juk) : ap.getColor(0, this.juk));
        this.bVB.setStyle(Paint.Style.STROKE);
        this.bVB.setStrokeWidth(this.juj);
        this.juo.set(this.jur + (this.juj / 2.0f), this.juj / 2.0f, f2 - (this.juj / 2.0f), this.jue - (this.juj / 2.0f));
        float f3 = (this.jue - this.juj) / 2.0f;
        canvas.drawRoundRect(this.juo, f3, f3, this.bVB);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.bjh.setColor(this.odi ? ap.getColor(this.juh) : ap.getColor(0, this.juh));
        } else {
            this.bjh.setColor(this.odi ? ap.getColor(this.jug) : ap.getColor(0, this.jug));
        }
        canvas.drawText(str, f, f2, this.bjh);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.jus && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int bJT = this.odh.bJT();
            int cGT = cGT();
            if (Math.abs(cGT - bJT) >= 2 || cGT > bJT) {
                this.odh.sR(cGT);
            } else if (cGT < bJT) {
                float floatValue = this.juv.size() > cGT ? this.juv.get(cGT).floatValue() : 0.0f;
                float floatValue2 = cGT + 1 < this.juv.size() ? this.juv.get(cGT + 1).floatValue() : floatValue;
                if (this.jur >= floatValue && this.jur <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.odh.sR(cGT);
                }
            } else {
                float floatValue3 = this.juv.size() > cGT ? this.juv.get(cGT).floatValue() : 0.0f;
                if (this.jur >= (((cGT + 1 < this.juv.size() ? this.juv.get(cGT + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cGT + 1 < this.juv.size()) {
                    this.odh.sR(cGT + 1);
                }
            }
            this.jut = true;
            this.jux = this.jur;
            float floatValue4 = this.juv.size() > this.odh.bJT() ? this.juv.get(this.odh.bJT()).floatValue() : 0.0f;
            this.mMoveDistance = Math.abs(this.jux - floatValue4);
            if (this.odh.bJT() < bJT) {
                this.juy = true;
            } else if (this.odh.bJT() > bJT) {
                this.juy = false;
            } else {
                this.juy = this.jux > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.odh.bJT() != bJT) {
                zs(bJT);
            }
            this.jut = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cGT() {
        float floatValue;
        int bJT = this.odh.bJT();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.juv.size()) {
                return bJT;
            }
            float floatValue2 = ((Float) y.getItem(this.juv, i2)).floatValue();
            if (i2 + 1 == this.juv.size()) {
                floatValue = this.bUR;
            } else {
                floatValue = ((Float) y.getItem(this.juv, i2 + 1)).floatValue();
            }
            if (this.jur <= floatValue2 || this.jur >= floatValue) {
                if (this.jur == floatValue2) {
                    if (bJT - 1 >= 0) {
                        return bJT - 1;
                    }
                } else if (this.jur == floatValue && bJT + 1 < y.getCount(this.juv)) {
                    return bJT + 1;
                }
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zr(int i) {
        if (this.juv.size() > i) {
            this.jux = this.juv.get(i).floatValue();
        }
        float f = 0.0f;
        if (this.juv.size() > this.odh.bJT()) {
            f = this.juv.get(this.odh.bJT()).floatValue();
        }
        this.mMoveDistance = Math.abs(f - this.jux);
        this.juy = this.odh.bJT() < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zs(int i) {
        if (this.lQv != null && !this.lQv.zq(this.odh.bJT())) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.odh.sQ(i);
            if (this.juv.size() > this.odh.bJT()) {
                this.jur = this.juv.get(this.odh.bJT()).floatValue();
            }
            invalidate();
        }
    }

    public void setNeedDayNight(boolean z) {
        this.odi = z;
        if (!this.odi) {
            this.mBackgroundPaint.setColor(ap.getColor(0, this.mBackgroundColorId));
            if (this.odc != null) {
                this.odc.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(0, this.ocZ), this.odb));
            }
        }
    }

    public void setData(List<r> list) {
        if (dn(list)) {
            if (y.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.mData = list;
            requestLayout();
        }
    }

    public void setData(List<r> list, int i) {
        if (dn(list) || this.odh == null || this.odh.bJT() != i) {
            if (y.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            reset();
            setVisibility(0);
            this.odh.sQ(i);
            this.mData = list;
            requestLayout();
        }
    }

    private boolean dn(List<r> list) {
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

    private boolean a(r rVar, r rVar2) {
        if (rVar == null && rVar2 == null) {
            return true;
        }
        if (rVar == null || rVar2 == null) {
            return false;
        }
        if (rVar.dOb() == rVar2.dOb() && rVar.dOc() != null && rVar.dOc().equals(rVar2.dOc())) {
            return true;
        }
        return rVar.dOb() == rVar2.dOb() && rVar.dOc() == null && rVar2.dOc() == null;
    }

    public void reset() {
        this.odh.sQ(0);
        this.jur = 0.0f;
        this.jut = false;
        this.mData.clear();
        this.juv.clear();
        this.juu = true;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.lQv = aVar;
    }

    public void onChangeSkinType() {
        if (this.odi) {
            this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
            if (this.odc != null) {
                this.odc.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(this.mBackgroundColorId), this.odb));
            }
            invalidate();
        }
    }

    public void setCanScroll(boolean z) {
        this.jus = z;
    }

    public int getState() {
        return this.odh.bJT();
    }

    public void iG(int i) {
        if (!y.isEmpty(this.mData) && !y.isEmpty(this.juv)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mData.size()) {
                    if (this.mData.get(i3).dOb() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.odh.sQ(i3);
                        if (this.juv.size() > i3) {
                            this.jur = this.juv.get(i3).floatValue();
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
        this.odk = bdUniqueId;
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.odj) {
            this.flo.setTag(bdUniqueId);
        }
    }
}
