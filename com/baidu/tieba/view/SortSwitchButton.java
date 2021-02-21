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
    private float hPl;
    private float jsA;
    private int jsB;
    private RectF jsE;
    private RectF jsF;
    private Path jsG;
    private float jsI;
    private boolean jsJ;
    private boolean jsK;
    private boolean jsL;
    private List<Float> jsM;
    private GestureDetector.SimpleOnGestureListener jsN;
    private float jsO;
    private boolean jsP;
    private float jsv;
    private int jsw;
    private int jsx;
    private int jsy;
    private float jsz;
    private a lOt;
    private int mBackgroundColorId;
    private Paint mBackgroundPaint;
    private List<r> mData;
    private GestureDetector mGestureDetector;
    private float mHeight;
    private float mMoveDistance;
    private float mTextSize;
    private ValueAnimator mValueAnimator;
    private int oaS;
    private float oaT;
    private float oaU;
    private Paint oaV;
    private RectF oaW;
    private Path oaX;
    private RectF oaY;
    private Path oaZ;
    private com.baidu.tieba.e oba;
    private boolean obb;
    private boolean obc;
    private BdUniqueId obd;
    private BdUniqueId obe;
    private e.a obf;

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
        this.oba = new com.baidu.tieba.e();
        this.jsJ = false;
        this.jsK = false;
        this.jsL = true;
        this.obb = true;
        this.obc = false;
        this.obe = BdUniqueId.gen();
        this.fjP = new CustomMessageListener(2921458) { // from class: com.baidu.tieba.view.SortSwitchButton.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage) && (((CustomMessage) customResponsedMessage.getOrginalMessage()).getData() instanceof BdUniqueId)) {
                    BdUniqueId bdUniqueId = (BdUniqueId) ((CustomMessage) customResponsedMessage.getOrginalMessage()).getData();
                    BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                    if (tag != null && bdUniqueId != null && SortSwitchButton.this.obd != null) {
                        Integer num = (Integer) customResponsedMessage.getData();
                        if (tag.getId() == SortSwitchButton.this.obd.getId() && bdUniqueId.getId() != SortSwitchButton.this.obe.getId() && SortSwitchButton.this.oba.bJP() != num.intValue() && !y.isEmpty(SortSwitchButton.this.mData) && !y.isEmpty(SortSwitchButton.this.jsM) && SortSwitchButton.this.jsM.size() > num.intValue()) {
                            SortSwitchButton.this.oba.sP(num.intValue());
                            SortSwitchButton.this.jsI = ((Float) SortSwitchButton.this.jsM.get(num.intValue())).floatValue();
                            SortSwitchButton.this.invalidate();
                        }
                    }
                }
            }
        };
        this.obf = new e.a() { // from class: com.baidu.tieba.view.SortSwitchButton.2
            @Override // com.baidu.tieba.e.a
            public void bu(int i2, int i3) {
                ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i3));
                CustomMessage customMessage = new CustomMessage(2921458);
                customMessage.setTag(SortSwitchButton.this.obd);
                customMessage.setData(SortSwitchButton.this.obe);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        };
        this.jsN = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.view.SortSwitchButton.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!SortSwitchButton.this.jsK && motionEvent.getX() <= SortSwitchButton.this.bTr && motionEvent.getY() <= SortSwitchButton.this.mHeight) {
                    if (SortSwitchButton.this.getParent() != null) {
                        SortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int bJP = SortSwitchButton.this.oba.bJP();
                SortSwitchButton.this.jsI = motionEvent.getX();
                SortSwitchButton.this.oba.sO(SortSwitchButton.this.cGN());
                SortSwitchButton.this.jsK = true;
                if (SortSwitchButton.this.oba.bJP() != bJP) {
                    SortSwitchButton.this.zq(bJP);
                    if (SortSwitchButton.this.mValueAnimator != null) {
                        SortSwitchButton.this.mValueAnimator.start();
                    }
                    SortSwitchButton.this.zr(bJP);
                }
                SortSwitchButton.this.jsK = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (SortSwitchButton.this.jsJ) {
                    SortSwitchButton.this.jsI -= f;
                    if (SortSwitchButton.this.jsI < 0.0f) {
                        SortSwitchButton.this.jsI = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(SortSwitchButton.this.jsM, SortSwitchButton.this.jsM.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (SortSwitchButton.this.jsI > floatValue) {
                        SortSwitchButton.this.jsI = floatValue;
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
        if (this.obc) {
            this.oba.a(this.obf);
            MessageManager.getInstance().registerListener(this.fjP);
        }
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SortSwitchButton);
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_color, R.color.CAM_X0107);
        this.oaS = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_border_color, this.mBackgroundColorId);
        this.oaT = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_background_border_width, 0.0f);
        this.oaU = obtainStyledAttributes.getFloat(R.styleable.SortSwitchButton_background_border_alpha, 1.0f);
        this.jsw = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_color, R.color.CAM_X0101);
        this.jsx = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_un_selected_text_color, R.color.CAM_X0105);
        this.jsy = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_selected_text_color, R.color.CAM_X0105);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_size, 5.0f);
        this.jsz = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_horizontal_padding, 0.0f);
        this.jsv = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_height, 0.0f);
        this.jsA = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_border_width, 0.0f);
        this.jsB = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_border_color, R.color.CAM_X0105);
        this.obc = obtainStyledAttributes.getBoolean(R.styleable.SortSwitchButton_slide_need_sync, false);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.jsE = new RectF();
        this.eWm = new Path();
        this.jsF = new RectF();
        this.jsG = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        if (this.oaS > 0 && this.oaT > 0.0f) {
            this.oaW = new RectF();
            this.oaX = new Path();
            this.oaY = new RectF();
            this.oaZ = new Path();
            this.oaV = new Paint(1);
            this.oaV.setStyle(Paint.Style.STROKE);
            this.oaV.setStrokeWidth(this.oaT);
            this.oaV.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(this.mBackgroundColorId), this.oaU));
        }
        this.bUb = new Paint(1);
        this.bhF = new Paint(1);
        this.bhF.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.jsM = new ArrayList();
        this.oba.sP(0);
        this.mGestureDetector = new GestureDetector(context, this.jsN);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SortSwitchButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * SortSwitchButton.this.mMoveDistance;
                if (SortSwitchButton.this.jsP) {
                    SortSwitchButton.this.jsI = SortSwitchButton.this.jsO - floatValue;
                } else {
                    SortSwitchButton.this.jsI = floatValue + SortSwitchButton.this.jsO;
                }
                SortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.view.SortSwitchButton.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (SortSwitchButton.this.jsM.size() > SortSwitchButton.this.oba.bJP()) {
                    SortSwitchButton.this.jsI = ((Float) SortSwitchButton.this.jsM.get(SortSwitchButton.this.oba.bJP())).floatValue();
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
                    float measureText = this.bhF.measureText(rVar.dNT() == null ? "" : rVar.dNT()) + (this.jsz * 2.0f);
                    if (this.jsL) {
                        this.jsM.add(Float.valueOf(this.bTr));
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
                if (this.jsL) {
                    this.jsM.add(Float.valueOf(f));
                }
                f += f2;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.jsv;
        } else {
            this.mHeight = size2;
            this.jsv = this.mHeight;
        }
        this.jsL = false;
        cGM();
        setMeasuredDimension((int) this.bTr, (int) this.mHeight);
    }

    private void cGM() {
        this.jsE.set(this.oaT, this.oaT, this.bTr - this.oaT, this.mHeight - this.oaT);
        this.eWm.reset();
        this.eWm.addRoundRect(this.jsE, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        if (this.oaW != null && this.oaV != null) {
            this.oaW.set(0.0f, 0.0f, this.bTr, this.mHeight);
            float f = this.oaT * 0.5f;
            this.oaY.set(-f, -f, this.bTr + f, this.mHeight + f);
            this.oaX.reset();
            this.oaZ.reset();
            this.oaX.addRoundRect(this.oaW, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
            this.oaZ.addRoundRect(this.oaY, (this.mHeight + f) * 0.5f, (f + this.mHeight) * 0.5f, Path.Direction.CW);
        }
        Float f2 = (Float) y.getItem(this.jsM, this.oba.bJP());
        this.jsI = f2 != null ? f2.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.bhF.getFontMetrics();
        this.hPl = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.oaZ != null) {
            canvas.clipPath(this.oaZ);
        } else {
            canvas.clipPath(this.eWm);
        }
        super.onDraw(canvas);
        aw(canvas);
        aa(canvas);
        int i = 0;
        while (i < this.mData.size() && i < this.jsM.size()) {
            a(canvas, this.mData.get(i).dNT(), this.jsM.get(i).floatValue() + this.jsz, this.hPl, this.oba.bJP() == i);
            i++;
        }
    }

    private void aw(Canvas canvas) {
        canvas.drawPath(this.eWm, this.mBackgroundPaint);
        if (this.oaS > 0 && this.oaT > 0.0f && this.oaV != null) {
            canvas.drawPath(this.oaX, this.oaV);
        }
    }

    private void aa(Canvas canvas) {
        float f;
        if (this.jsI < 0.0f) {
            this.jsI = 0.0f;
        }
        float floatValue = !y.isEmpty(this.jsM) ? ((Float) y.getItem(this.jsM, this.oba.bJP())).floatValue() : 0.0f;
        if (this.oba.bJP() + 1 < this.jsM.size()) {
            f = this.jsM.get(this.oba.bJP() + 1).floatValue();
        } else {
            f = this.oba.bJP() + 1 == this.jsM.size() ? this.bTr : 0.0f;
        }
        float f2 = (f - floatValue) + this.jsI;
        if (f2 > this.bTr) {
            f2 = this.bTr;
        }
        this.jsF.set(this.jsI, 0.0f, f2, this.mHeight);
        this.jsG.reset();
        this.jsG.addRoundRect(this.jsF, this.jsv / 2.0f, this.jsv / 2.0f, Path.Direction.CW);
        this.bUb.reset();
        this.bUb.setAntiAlias(true);
        this.bUb.setColor(this.obb ? ap.getColor(this.jsw) : ap.getColor(0, this.jsw));
        canvas.drawPath(this.jsG, this.bUb);
        this.bUb.reset();
        this.bUb.setAntiAlias(true);
        this.bUb.setColor(this.obb ? ap.getColor(this.jsB) : ap.getColor(0, this.jsB));
        this.bUb.setStyle(Paint.Style.STROKE);
        this.bUb.setStrokeWidth(this.jsA);
        this.jsF.set(this.jsI + (this.jsA / 2.0f), this.jsA / 2.0f, f2 - (this.jsA / 2.0f), this.jsv - (this.jsA / 2.0f));
        float f3 = (this.jsv - this.jsA) / 2.0f;
        canvas.drawRoundRect(this.jsF, f3, f3, this.bUb);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.bhF.setColor(this.obb ? ap.getColor(this.jsy) : ap.getColor(0, this.jsy));
        } else {
            this.bhF.setColor(this.obb ? ap.getColor(this.jsx) : ap.getColor(0, this.jsx));
        }
        canvas.drawText(str, f, f2, this.bhF);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.jsJ && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int bJP = this.oba.bJP();
            int cGN = cGN();
            if (Math.abs(cGN - bJP) >= 2 || cGN > bJP) {
                this.oba.sP(cGN);
            } else if (cGN < bJP) {
                float floatValue = this.jsM.size() > cGN ? this.jsM.get(cGN).floatValue() : 0.0f;
                float floatValue2 = cGN + 1 < this.jsM.size() ? this.jsM.get(cGN + 1).floatValue() : floatValue;
                if (this.jsI >= floatValue && this.jsI <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.oba.sP(cGN);
                }
            } else {
                float floatValue3 = this.jsM.size() > cGN ? this.jsM.get(cGN).floatValue() : 0.0f;
                if (this.jsI >= (((cGN + 1 < this.jsM.size() ? this.jsM.get(cGN + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cGN + 1 < this.jsM.size()) {
                    this.oba.sP(cGN + 1);
                }
            }
            this.jsK = true;
            this.jsO = this.jsI;
            float floatValue4 = this.jsM.size() > this.oba.bJP() ? this.jsM.get(this.oba.bJP()).floatValue() : 0.0f;
            this.mMoveDistance = Math.abs(this.jsO - floatValue4);
            if (this.oba.bJP() < bJP) {
                this.jsP = true;
            } else if (this.oba.bJP() > bJP) {
                this.jsP = false;
            } else {
                this.jsP = this.jsO > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.oba.bJP() != bJP) {
                zr(bJP);
            }
            this.jsK = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cGN() {
        float floatValue;
        int bJP = this.oba.bJP();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.jsM.size()) {
                return bJP;
            }
            float floatValue2 = ((Float) y.getItem(this.jsM, i2)).floatValue();
            if (i2 + 1 == this.jsM.size()) {
                floatValue = this.bTr;
            } else {
                floatValue = ((Float) y.getItem(this.jsM, i2 + 1)).floatValue();
            }
            if (this.jsI <= floatValue2 || this.jsI >= floatValue) {
                if (this.jsI == floatValue2) {
                    if (bJP - 1 >= 0) {
                        return bJP - 1;
                    }
                } else if (this.jsI == floatValue && bJP + 1 < y.getCount(this.jsM)) {
                    return bJP + 1;
                }
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zq(int i) {
        if (this.jsM.size() > i) {
            this.jsO = this.jsM.get(i).floatValue();
        }
        float f = 0.0f;
        if (this.jsM.size() > this.oba.bJP()) {
            f = this.jsM.get(this.oba.bJP()).floatValue();
        }
        this.mMoveDistance = Math.abs(f - this.jsO);
        this.jsP = this.oba.bJP() < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zr(int i) {
        if (this.lOt != null && !this.lOt.zp(this.oba.bJP())) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.oba.sO(i);
            if (this.jsM.size() > this.oba.bJP()) {
                this.jsI = this.jsM.get(this.oba.bJP()).floatValue();
            }
            invalidate();
        }
    }

    public void setNeedDayNight(boolean z) {
        this.obb = z;
        if (!this.obb) {
            this.mBackgroundPaint.setColor(ap.getColor(0, this.mBackgroundColorId));
            if (this.oaV != null) {
                this.oaV.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(0, this.oaS), this.oaU));
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
        if (dn(list) || this.oba == null || this.oba.bJP() != i) {
            if (y.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            reset();
            setVisibility(0);
            this.oba.sO(i);
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
        if (rVar.dNS() == rVar2.dNS() && rVar.dNT() != null && rVar.dNT().equals(rVar2.dNT())) {
            return true;
        }
        return rVar.dNS() == rVar2.dNS() && rVar.dNT() == null && rVar2.dNT() == null;
    }

    public void reset() {
        this.oba.sO(0);
        this.jsI = 0.0f;
        this.jsK = false;
        this.mData.clear();
        this.jsM.clear();
        this.jsL = true;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.lOt = aVar;
    }

    public void onChangeSkinType() {
        if (this.obb) {
            this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
            if (this.oaV != null) {
                this.oaV.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(this.mBackgroundColorId), this.oaU));
            }
            invalidate();
        }
    }

    public void setCanScroll(boolean z) {
        this.jsJ = z;
    }

    public int getState() {
        return this.oba.bJP();
    }

    public void iF(int i) {
        if (!y.isEmpty(this.mData) && !y.isEmpty(this.jsM)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mData.size()) {
                    if (this.mData.get(i3).dNS() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.oba.sO(i3);
                        if (this.jsM.size() > i3) {
                            this.jsI = this.jsM.get(i3).floatValue();
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
        this.obd = bdUniqueId;
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.obc) {
            this.fjP.setTag(bdUniqueId);
        }
    }
}
