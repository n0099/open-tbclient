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
    private float bTr;
    private Paint bUb;
    private Paint bhF;
    private Path eWm;
    private CustomMessageListener fjP;
    private float hOX;
    private float jsA;
    private boolean jsB;
    private float jsh;
    private int jsi;
    private int jsj;
    private int jsk;
    private float jsl;
    private float jsm;
    private int jsn;
    private RectF jsq;
    private RectF jsr;
    private Path jss;
    private float jsu;
    private boolean jsv;
    private boolean jsw;
    private boolean jsx;
    private List<Float> jsy;
    private GestureDetector.SimpleOnGestureListener jsz;
    private a lOe;
    private int mBackgroundColorId;
    private Paint mBackgroundPaint;
    private List<r> mData;
    private GestureDetector mGestureDetector;
    private float mHeight;
    private float mMoveDistance;
    private float mTextSize;
    private ValueAnimator mValueAnimator;
    private com.baidu.tieba.e oaA;
    private boolean oaB;
    private boolean oaC;
    private BdUniqueId oaD;
    private BdUniqueId oaE;
    private e.a oaF;
    private int oas;
    private float oat;
    private float oau;
    private Paint oav;
    private RectF oaw;
    private Path oax;
    private RectF oay;
    private Path oaz;

    /* loaded from: classes.dex */
    public interface a {
        boolean zp(int i);
    }

    public SortSwitchButton(Context context) {
        this(context, null);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oaA = new com.baidu.tieba.e();
        this.jsv = false;
        this.jsw = false;
        this.jsx = true;
        this.oaB = true;
        this.oaC = false;
        this.oaE = BdUniqueId.gen();
        this.fjP = new CustomMessageListener(2921458) { // from class: com.baidu.tieba.view.SortSwitchButton.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage) && (((CustomMessage) customResponsedMessage.getOrginalMessage()).getData() instanceof BdUniqueId)) {
                    BdUniqueId bdUniqueId = (BdUniqueId) ((CustomMessage) customResponsedMessage.getOrginalMessage()).getData();
                    BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                    if (tag != null && bdUniqueId != null && SortSwitchButton.this.oaD != null) {
                        Integer num = (Integer) customResponsedMessage.getData();
                        if (tag.getId() == SortSwitchButton.this.oaD.getId() && bdUniqueId.getId() != SortSwitchButton.this.oaE.getId() && SortSwitchButton.this.oaA.bJK() != num.intValue() && !y.isEmpty(SortSwitchButton.this.mData) && !y.isEmpty(SortSwitchButton.this.jsy) && SortSwitchButton.this.jsy.size() > num.intValue()) {
                            SortSwitchButton.this.oaA.sP(num.intValue());
                            SortSwitchButton.this.jsu = ((Float) SortSwitchButton.this.jsy.get(num.intValue())).floatValue();
                            SortSwitchButton.this.invalidate();
                        }
                    }
                }
            }
        };
        this.oaF = new e.a() { // from class: com.baidu.tieba.view.SortSwitchButton.2
            @Override // com.baidu.tieba.e.a
            public void bu(int i2, int i3) {
                ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i3));
                CustomMessage customMessage = new CustomMessage(2921458);
                customMessage.setTag(SortSwitchButton.this.oaD);
                customMessage.setData(SortSwitchButton.this.oaE);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        };
        this.jsz = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.view.SortSwitchButton.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!SortSwitchButton.this.jsw && motionEvent.getX() <= SortSwitchButton.this.bTr && motionEvent.getY() <= SortSwitchButton.this.mHeight) {
                    if (SortSwitchButton.this.getParent() != null) {
                        SortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int bJK = SortSwitchButton.this.oaA.bJK();
                SortSwitchButton.this.jsu = motionEvent.getX();
                SortSwitchButton.this.oaA.sO(SortSwitchButton.this.cGG());
                SortSwitchButton.this.jsw = true;
                if (SortSwitchButton.this.oaA.bJK() != bJK) {
                    SortSwitchButton.this.zq(bJK);
                    if (SortSwitchButton.this.mValueAnimator != null) {
                        SortSwitchButton.this.mValueAnimator.start();
                    }
                    SortSwitchButton.this.zr(bJK);
                }
                SortSwitchButton.this.jsw = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (SortSwitchButton.this.jsv) {
                    SortSwitchButton.this.jsu -= f;
                    if (SortSwitchButton.this.jsu < 0.0f) {
                        SortSwitchButton.this.jsu = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(SortSwitchButton.this.jsy, SortSwitchButton.this.jsy.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (SortSwitchButton.this.jsu > floatValue) {
                        SortSwitchButton.this.jsu = floatValue;
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
        if (this.oaC) {
            this.oaA.a(this.oaF);
            MessageManager.getInstance().registerListener(this.fjP);
        }
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SortSwitchButton);
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_color, R.color.CAM_X0107);
        this.oas = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_border_color, this.mBackgroundColorId);
        this.oat = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_background_border_width, 0.0f);
        this.oau = obtainStyledAttributes.getFloat(R.styleable.SortSwitchButton_background_border_alpha, 1.0f);
        this.jsi = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_color, R.color.CAM_X0101);
        this.jsj = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_un_selected_text_color, R.color.CAM_X0105);
        this.jsk = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_selected_text_color, R.color.CAM_X0105);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_size, 5.0f);
        this.jsl = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_horizontal_padding, 0.0f);
        this.jsh = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_height, 0.0f);
        this.jsm = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_border_width, 0.0f);
        this.jsn = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_border_color, R.color.CAM_X0105);
        this.oaC = obtainStyledAttributes.getBoolean(R.styleable.SortSwitchButton_slide_need_sync, false);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.jsq = new RectF();
        this.eWm = new Path();
        this.jsr = new RectF();
        this.jss = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        if (this.oas > 0 && this.oat > 0.0f) {
            this.oaw = new RectF();
            this.oax = new Path();
            this.oay = new RectF();
            this.oaz = new Path();
            this.oav = new Paint(1);
            this.oav.setStyle(Paint.Style.STROKE);
            this.oav.setStrokeWidth(this.oat);
            this.oav.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(this.mBackgroundColorId), this.oau));
        }
        this.bUb = new Paint(1);
        this.bhF = new Paint(1);
        this.bhF.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.jsy = new ArrayList();
        this.oaA.sP(0);
        this.mGestureDetector = new GestureDetector(context, this.jsz);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SortSwitchButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * SortSwitchButton.this.mMoveDistance;
                if (SortSwitchButton.this.jsB) {
                    SortSwitchButton.this.jsu = SortSwitchButton.this.jsA - floatValue;
                } else {
                    SortSwitchButton.this.jsu = floatValue + SortSwitchButton.this.jsA;
                }
                SortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.view.SortSwitchButton.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (SortSwitchButton.this.jsy.size() > SortSwitchButton.this.oaA.bJK()) {
                    SortSwitchButton.this.jsu = ((Float) SortSwitchButton.this.jsy.get(SortSwitchButton.this.oaA.bJK())).floatValue();
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
            this.bTr = 0.0f;
            for (int i3 = 0; i3 < count; i3++) {
                r rVar = (r) y.getItem(this.mData, i3);
                if (rVar != null) {
                    float measureText = this.bhF.measureText(rVar.dNL() == null ? "" : rVar.dNL()) + (this.jsl * 2.0f);
                    if (this.jsx) {
                        this.jsy.add(Float.valueOf(this.bTr));
                    }
                    this.bTr = measureText + this.bTr;
                }
            }
        } else {
            this.bTr = size;
            float f2 = this.bTr;
            if (count > 0) {
                f2 = this.bTr / count;
            }
            for (int i4 = 0; i4 < count; i4++) {
                if (this.jsx) {
                    this.jsy.add(Float.valueOf(f));
                }
                f += f2;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.jsh;
        } else {
            this.mHeight = size2;
            this.jsh = this.mHeight;
        }
        this.jsx = false;
        cGF();
        setMeasuredDimension((int) this.bTr, (int) this.mHeight);
    }

    private void cGF() {
        this.jsq.set(this.oat, this.oat, this.bTr - this.oat, this.mHeight - this.oat);
        this.eWm.reset();
        this.eWm.addRoundRect(this.jsq, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        if (this.oaw != null && this.oav != null) {
            this.oaw.set(0.0f, 0.0f, this.bTr, this.mHeight);
            float f = this.oat * 0.5f;
            this.oay.set(-f, -f, this.bTr + f, this.mHeight + f);
            this.oax.reset();
            this.oaz.reset();
            this.oax.addRoundRect(this.oaw, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
            this.oaz.addRoundRect(this.oay, (this.mHeight + f) * 0.5f, (f + this.mHeight) * 0.5f, Path.Direction.CW);
        }
        Float f2 = (Float) y.getItem(this.jsy, this.oaA.bJK());
        this.jsu = f2 != null ? f2.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.bhF.getFontMetrics();
        this.hOX = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.oaz != null) {
            canvas.clipPath(this.oaz);
        } else {
            canvas.clipPath(this.eWm);
        }
        super.onDraw(canvas);
        aw(canvas);
        aa(canvas);
        int i = 0;
        while (i < this.mData.size() && i < this.jsy.size()) {
            a(canvas, this.mData.get(i).dNL(), this.jsy.get(i).floatValue() + this.jsl, this.hOX, this.oaA.bJK() == i);
            i++;
        }
    }

    private void aw(Canvas canvas) {
        canvas.drawPath(this.eWm, this.mBackgroundPaint);
        if (this.oas > 0 && this.oat > 0.0f && this.oav != null) {
            canvas.drawPath(this.oax, this.oav);
        }
    }

    private void aa(Canvas canvas) {
        float f;
        if (this.jsu < 0.0f) {
            this.jsu = 0.0f;
        }
        float floatValue = !y.isEmpty(this.jsy) ? ((Float) y.getItem(this.jsy, this.oaA.bJK())).floatValue() : 0.0f;
        if (this.oaA.bJK() + 1 < this.jsy.size()) {
            f = this.jsy.get(this.oaA.bJK() + 1).floatValue();
        } else {
            f = this.oaA.bJK() + 1 == this.jsy.size() ? this.bTr : 0.0f;
        }
        float f2 = (f - floatValue) + this.jsu;
        if (f2 > this.bTr) {
            f2 = this.bTr;
        }
        this.jsr.set(this.jsu, 0.0f, f2, this.mHeight);
        this.jss.reset();
        this.jss.addRoundRect(this.jsr, this.jsh / 2.0f, this.jsh / 2.0f, Path.Direction.CW);
        this.bUb.reset();
        this.bUb.setAntiAlias(true);
        this.bUb.setColor(this.oaB ? ap.getColor(this.jsi) : ap.getColor(0, this.jsi));
        canvas.drawPath(this.jss, this.bUb);
        this.bUb.reset();
        this.bUb.setAntiAlias(true);
        this.bUb.setColor(this.oaB ? ap.getColor(this.jsn) : ap.getColor(0, this.jsn));
        this.bUb.setStyle(Paint.Style.STROKE);
        this.bUb.setStrokeWidth(this.jsm);
        this.jsr.set(this.jsu + (this.jsm / 2.0f), this.jsm / 2.0f, f2 - (this.jsm / 2.0f), this.jsh - (this.jsm / 2.0f));
        float f3 = (this.jsh - this.jsm) / 2.0f;
        canvas.drawRoundRect(this.jsr, f3, f3, this.bUb);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.bhF.setColor(this.oaB ? ap.getColor(this.jsk) : ap.getColor(0, this.jsk));
        } else {
            this.bhF.setColor(this.oaB ? ap.getColor(this.jsj) : ap.getColor(0, this.jsj));
        }
        canvas.drawText(str, f, f2, this.bhF);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.jsv && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int bJK = this.oaA.bJK();
            int cGG = cGG();
            if (Math.abs(cGG - bJK) >= 2 || cGG > bJK) {
                this.oaA.sP(cGG);
            } else if (cGG < bJK) {
                float floatValue = this.jsy.size() > cGG ? this.jsy.get(cGG).floatValue() : 0.0f;
                float floatValue2 = cGG + 1 < this.jsy.size() ? this.jsy.get(cGG + 1).floatValue() : floatValue;
                if (this.jsu >= floatValue && this.jsu <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.oaA.sP(cGG);
                }
            } else {
                float floatValue3 = this.jsy.size() > cGG ? this.jsy.get(cGG).floatValue() : 0.0f;
                if (this.jsu >= (((cGG + 1 < this.jsy.size() ? this.jsy.get(cGG + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cGG + 1 < this.jsy.size()) {
                    this.oaA.sP(cGG + 1);
                }
            }
            this.jsw = true;
            this.jsA = this.jsu;
            float floatValue4 = this.jsy.size() > this.oaA.bJK() ? this.jsy.get(this.oaA.bJK()).floatValue() : 0.0f;
            this.mMoveDistance = Math.abs(this.jsA - floatValue4);
            if (this.oaA.bJK() < bJK) {
                this.jsB = true;
            } else if (this.oaA.bJK() > bJK) {
                this.jsB = false;
            } else {
                this.jsB = this.jsA > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.oaA.bJK() != bJK) {
                zr(bJK);
            }
            this.jsw = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cGG() {
        float floatValue;
        int bJK = this.oaA.bJK();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.jsy.size()) {
                return bJK;
            }
            float floatValue2 = ((Float) y.getItem(this.jsy, i2)).floatValue();
            if (i2 + 1 == this.jsy.size()) {
                floatValue = this.bTr;
            } else {
                floatValue = ((Float) y.getItem(this.jsy, i2 + 1)).floatValue();
            }
            if (this.jsu <= floatValue2 || this.jsu >= floatValue) {
                if (this.jsu == floatValue2) {
                    if (bJK - 1 >= 0) {
                        return bJK - 1;
                    }
                } else if (this.jsu == floatValue && bJK + 1 < y.getCount(this.jsy)) {
                    return bJK + 1;
                }
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zq(int i) {
        if (this.jsy.size() > i) {
            this.jsA = this.jsy.get(i).floatValue();
        }
        float f = 0.0f;
        if (this.jsy.size() > this.oaA.bJK()) {
            f = this.jsy.get(this.oaA.bJK()).floatValue();
        }
        this.mMoveDistance = Math.abs(f - this.jsA);
        this.jsB = this.oaA.bJK() < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zr(int i) {
        if (this.lOe != null && !this.lOe.zp(this.oaA.bJK())) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.oaA.sO(i);
            if (this.jsy.size() > this.oaA.bJK()) {
                this.jsu = this.jsy.get(this.oaA.bJK()).floatValue();
            }
            invalidate();
        }
    }

    public void setNeedDayNight(boolean z) {
        this.oaB = z;
        if (!this.oaB) {
            this.mBackgroundPaint.setColor(ap.getColor(0, this.mBackgroundColorId));
            if (this.oav != null) {
                this.oav.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(0, this.oas), this.oau));
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
        if (dn(list) || this.oaA == null || this.oaA.bJK() != i) {
            if (y.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            reset();
            setVisibility(0);
            this.oaA.sO(i);
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
        if (rVar.dNK() == rVar2.dNK() && rVar.dNL() != null && rVar.dNL().equals(rVar2.dNL())) {
            return true;
        }
        return rVar.dNK() == rVar2.dNK() && rVar.dNL() == null && rVar2.dNL() == null;
    }

    public void reset() {
        this.oaA.sO(0);
        this.jsu = 0.0f;
        this.jsw = false;
        this.mData.clear();
        this.jsy.clear();
        this.jsx = true;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.lOe = aVar;
    }

    public void onChangeSkinType() {
        if (this.oaB) {
            this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
            if (this.oav != null) {
                this.oav.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(this.mBackgroundColorId), this.oau));
            }
            invalidate();
        }
    }

    public void setCanScroll(boolean z) {
        this.jsv = z;
    }

    public int getState() {
        return this.oaA.bJK();
    }

    public void iF(int i) {
        if (!y.isEmpty(this.mData) && !y.isEmpty(this.jsy)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mData.size()) {
                    if (this.mData.get(i3).dNK() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.oaA.sO(i3);
                        if (this.jsy.size() > i3) {
                            this.jsu = this.jsy.get(i3).floatValue();
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
        this.oaD = bdUniqueId;
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.oaC) {
            this.fjP.setTag(bdUniqueId);
        }
    }
}
