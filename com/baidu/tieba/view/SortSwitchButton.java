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
    private Paint bKN;
    private float bKb;
    private Path eHy;
    private float htD;
    private float iTK;
    private int iTL;
    private int iTM;
    private int iTN;
    private float iTO;
    private float iTP;
    private int iTQ;
    private RectF iTT;
    private RectF iTU;
    private Path iTV;
    private float iTX;
    private boolean iTY;
    private boolean iTZ;
    private boolean iUa;
    private List<Float> iUb;
    private GestureDetector.SimpleOnGestureListener iUc;
    private float iUd;
    private boolean iUe;
    private CustomMessageListener listener;
    private a lqV;
    private int mBackgroundColorId;
    private Paint mBackgroundPaint;
    private List<p> mData;
    private GestureDetector mGestureDetector;
    private float mHeight;
    private float mMoveDistance;
    private Paint mTextPaint;
    private float mTextSize;
    private ValueAnimator mValueAnimator;
    private RectF nDA;
    private Path nDB;
    private com.baidu.tieba.e nDC;
    private boolean nDD;
    private boolean nDE;
    private BdUniqueId nDF;
    private BdUniqueId nDG;
    private e.a nDH;
    private int nDu;
    private float nDv;
    private float nDw;
    private Paint nDx;
    private RectF nDy;
    private Path nDz;

    /* loaded from: classes.dex */
    public interface a {
        boolean zU(int i);
    }

    public SortSwitchButton(Context context) {
        this(context, null);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nDC = new com.baidu.tieba.e();
        this.iTY = false;
        this.iTZ = false;
        this.iUa = true;
        this.nDD = true;
        this.nDE = false;
        this.nDG = BdUniqueId.gen();
        this.listener = new CustomMessageListener(2921458) { // from class: com.baidu.tieba.view.SortSwitchButton.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage) && (((CustomMessage) customResponsedMessage.getOrginalMessage()).getData() instanceof BdUniqueId)) {
                    BdUniqueId bdUniqueId = (BdUniqueId) ((CustomMessage) customResponsedMessage.getOrginalMessage()).getData();
                    BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                    if (tag != null && bdUniqueId != null && SortSwitchButton.this.nDF != null) {
                        Integer num = (Integer) customResponsedMessage.getData();
                        if (tag.getId() == SortSwitchButton.this.nDF.getId() && bdUniqueId.getId() != SortSwitchButton.this.nDG.getId() && SortSwitchButton.this.nDC.bHp() != num.intValue() && !y.isEmpty(SortSwitchButton.this.mData) && !y.isEmpty(SortSwitchButton.this.iUb) && SortSwitchButton.this.iUb.size() > num.intValue()) {
                            SortSwitchButton.this.nDC.tB(num.intValue());
                            SortSwitchButton.this.iTX = ((Float) SortSwitchButton.this.iUb.get(num.intValue())).floatValue();
                            SortSwitchButton.this.invalidate();
                        }
                    }
                }
            }
        };
        this.nDH = new e.a() { // from class: com.baidu.tieba.view.SortSwitchButton.2
            @Override // com.baidu.tieba.e.a
            public void bx(int i2, int i3) {
                ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i3));
                CustomMessage customMessage = new CustomMessage(2921458);
                customMessage.setTag(SortSwitchButton.this.nDF);
                customMessage.setData(SortSwitchButton.this.nDG);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        };
        this.iUc = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.view.SortSwitchButton.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!SortSwitchButton.this.iTZ && motionEvent.getX() <= SortSwitchButton.this.bKb && motionEvent.getY() <= SortSwitchButton.this.mHeight) {
                    if (SortSwitchButton.this.getParent() != null) {
                        SortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int bHp = SortSwitchButton.this.nDC.bHp();
                SortSwitchButton.this.iTX = motionEvent.getX();
                SortSwitchButton.this.nDC.tA(SortSwitchButton.this.cBR());
                SortSwitchButton.this.iTZ = true;
                if (SortSwitchButton.this.nDC.bHp() != bHp) {
                    SortSwitchButton.this.zV(bHp);
                    if (SortSwitchButton.this.mValueAnimator != null) {
                        SortSwitchButton.this.mValueAnimator.start();
                    }
                    SortSwitchButton.this.zW(bHp);
                }
                SortSwitchButton.this.iTZ = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (SortSwitchButton.this.iTY) {
                    SortSwitchButton.this.iTX -= f;
                    if (SortSwitchButton.this.iTX < 0.0f) {
                        SortSwitchButton.this.iTX = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(SortSwitchButton.this.iUb, SortSwitchButton.this.iUb.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (SortSwitchButton.this.iTX > floatValue) {
                        SortSwitchButton.this.iTX = floatValue;
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
        if (this.nDE) {
            this.nDC.a(this.nDH);
            MessageManager.getInstance().registerListener(this.listener);
        }
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SortSwitchButton);
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_color, R.color.CAM_X0107);
        this.nDu = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_border_color, this.mBackgroundColorId);
        this.nDv = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_background_border_width, 0.0f);
        this.nDw = obtainStyledAttributes.getFloat(R.styleable.SortSwitchButton_background_border_alpha, 1.0f);
        this.iTL = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_color, R.color.CAM_X0101);
        this.iTM = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_un_selected_text_color, R.color.CAM_X0105);
        this.iTN = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_selected_text_color, R.color.CAM_X0105);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_size, 5.0f);
        this.iTO = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_horizontal_padding, 0.0f);
        this.iTK = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_height, 0.0f);
        this.iTP = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_border_width, 0.0f);
        this.iTQ = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_border_color, R.color.CAM_X0105);
        this.nDE = obtainStyledAttributes.getBoolean(R.styleable.SortSwitchButton_slide_need_sync, false);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.iTT = new RectF();
        this.eHy = new Path();
        this.iTU = new RectF();
        this.iTV = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        if (this.nDu > 0 && this.nDv > 0.0f) {
            this.nDy = new RectF();
            this.nDz = new Path();
            this.nDA = new RectF();
            this.nDB = new Path();
            this.nDx = new Paint(1);
            this.nDx.setStyle(Paint.Style.STROKE);
            this.nDx.setStrokeWidth(this.nDv);
            this.nDx.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(this.mBackgroundColorId), this.nDw));
        }
        this.bKN = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.iUb = new ArrayList();
        this.nDC.tB(0);
        this.mGestureDetector = new GestureDetector(context, this.iUc);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SortSwitchButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * SortSwitchButton.this.mMoveDistance;
                if (SortSwitchButton.this.iUe) {
                    SortSwitchButton.this.iTX = SortSwitchButton.this.iUd - floatValue;
                } else {
                    SortSwitchButton.this.iTX = floatValue + SortSwitchButton.this.iUd;
                }
                SortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.view.SortSwitchButton.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (SortSwitchButton.this.iUb.size() > SortSwitchButton.this.nDC.bHp()) {
                    SortSwitchButton.this.iTX = ((Float) SortSwitchButton.this.iUb.get(SortSwitchButton.this.nDC.bHp())).floatValue();
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
            this.bKb = 0.0f;
            for (int i3 = 0; i3 < count; i3++) {
                p pVar = (p) y.getItem(this.mData, i3);
                if (pVar != null) {
                    float measureText = this.mTextPaint.measureText(pVar.dKe() == null ? "" : pVar.dKe()) + (this.iTO * 2.0f);
                    if (this.iUa) {
                        this.iUb.add(Float.valueOf(this.bKb));
                    }
                    this.bKb = measureText + this.bKb;
                }
            }
        } else {
            this.bKb = size;
            float f = this.bKb;
            if (count > 0) {
                f = this.bKb / count;
            }
            float f2 = 0.0f;
            for (int i4 = 0; i4 < count; i4++) {
                if (this.iUa) {
                    this.iUb.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.iTK;
        } else {
            this.mHeight = size2;
            this.iTK = this.mHeight;
        }
        this.iUa = false;
        cBQ();
        setMeasuredDimension((int) this.bKb, (int) this.mHeight);
    }

    private void cBQ() {
        this.iTT.set(this.nDv, this.nDv, this.bKb - this.nDv, this.mHeight - this.nDv);
        this.eHy.reset();
        this.eHy.addRoundRect(this.iTT, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        if (this.nDy != null && this.nDx != null) {
            this.nDy.set(0.0f, 0.0f, this.bKb, this.mHeight);
            float f = this.nDv * 0.5f;
            this.nDA.set(-f, -f, this.bKb + f, this.mHeight + f);
            this.nDz.reset();
            this.nDB.reset();
            this.nDz.addRoundRect(this.nDy, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
            this.nDB.addRoundRect(this.nDA, (this.mHeight + f) * 0.5f, (f + this.mHeight) * 0.5f, Path.Direction.CW);
        }
        Float f2 = (Float) y.getItem(this.iUb, this.nDC.bHp());
        this.iTX = f2 != null ? f2.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.htD = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.nDB != null) {
            canvas.clipPath(this.nDB);
        } else {
            canvas.clipPath(this.eHy);
        }
        super.onDraw(canvas);
        aq(canvas);
        U(canvas);
        int i = 0;
        while (i < this.mData.size() && i < this.iUb.size()) {
            a(canvas, this.mData.get(i).dKe(), this.iUb.get(i).floatValue() + this.iTO, this.htD, this.nDC.bHp() == i);
            i++;
        }
    }

    private void aq(Canvas canvas) {
        canvas.drawPath(this.eHy, this.mBackgroundPaint);
        if (this.nDu > 0 && this.nDv > 0.0f && this.nDx != null) {
            canvas.drawPath(this.nDz, this.nDx);
        }
    }

    private void U(Canvas canvas) {
        float f;
        if (this.iTX < 0.0f) {
            this.iTX = 0.0f;
        }
        float floatValue = !y.isEmpty(this.iUb) ? ((Float) y.getItem(this.iUb, this.nDC.bHp())).floatValue() : 0.0f;
        if (this.nDC.bHp() + 1 < this.iUb.size()) {
            f = this.iUb.get(this.nDC.bHp() + 1).floatValue();
        } else {
            f = this.nDC.bHp() + 1 == this.iUb.size() ? this.bKb : 0.0f;
        }
        float f2 = (f - floatValue) + this.iTX;
        if (f2 > this.bKb) {
            f2 = this.bKb;
        }
        this.iTU.set(this.iTX, 0.0f, f2, this.mHeight);
        this.iTV.reset();
        this.iTV.addRoundRect(this.iTU, this.iTK / 2.0f, this.iTK / 2.0f, Path.Direction.CW);
        this.bKN.reset();
        this.bKN.setAntiAlias(true);
        this.bKN.setColor(this.nDD ? ap.getColor(this.iTL) : ap.getColor(0, this.iTL));
        canvas.drawPath(this.iTV, this.bKN);
        this.bKN.reset();
        this.bKN.setAntiAlias(true);
        this.bKN.setColor(this.nDD ? ap.getColor(this.iTQ) : ap.getColor(0, this.iTQ));
        this.bKN.setStyle(Paint.Style.STROKE);
        this.bKN.setStrokeWidth(this.iTP);
        this.iTU.set(this.iTX + (this.iTP / 2.0f), this.iTP / 2.0f, f2 - (this.iTP / 2.0f), this.iTK - (this.iTP / 2.0f));
        float f3 = (this.iTK - this.iTP) / 2.0f;
        canvas.drawRoundRect(this.iTU, f3, f3, this.bKN);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(this.nDD ? ap.getColor(this.iTN) : ap.getColor(0, this.iTN));
        } else {
            this.mTextPaint.setColor(this.nDD ? ap.getColor(this.iTM) : ap.getColor(0, this.iTM));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.iTY && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int bHp = this.nDC.bHp();
            int cBR = cBR();
            if (Math.abs(cBR - bHp) >= 2 || cBR > bHp) {
                this.nDC.tB(cBR);
            } else if (cBR < bHp) {
                float floatValue = this.iUb.size() > cBR ? this.iUb.get(cBR).floatValue() : 0.0f;
                float floatValue2 = cBR + 1 < this.iUb.size() ? this.iUb.get(cBR + 1).floatValue() : floatValue;
                if (this.iTX >= floatValue && this.iTX <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.nDC.tB(cBR);
                }
            } else {
                float floatValue3 = this.iUb.size() > cBR ? this.iUb.get(cBR).floatValue() : 0.0f;
                if (this.iTX >= (((cBR + 1 < this.iUb.size() ? this.iUb.get(cBR + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cBR + 1 < this.iUb.size()) {
                    this.nDC.tB(cBR + 1);
                }
            }
            this.iTZ = true;
            this.iUd = this.iTX;
            float floatValue4 = this.iUb.size() > this.nDC.bHp() ? this.iUb.get(this.nDC.bHp()).floatValue() : 0.0f;
            this.mMoveDistance = Math.abs(this.iUd - floatValue4);
            if (this.nDC.bHp() < bHp) {
                this.iUe = true;
            } else if (this.nDC.bHp() > bHp) {
                this.iUe = false;
            } else {
                this.iUe = this.iUd > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.nDC.bHp() != bHp) {
                zW(bHp);
            }
            this.iTZ = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cBR() {
        float floatValue;
        int bHp = this.nDC.bHp();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.iUb.size()) {
                return bHp;
            }
            float floatValue2 = ((Float) y.getItem(this.iUb, i2)).floatValue();
            if (i2 + 1 == this.iUb.size()) {
                floatValue = this.bKb;
            } else {
                floatValue = ((Float) y.getItem(this.iUb, i2 + 1)).floatValue();
            }
            if (this.iTX <= floatValue2 || this.iTX >= floatValue) {
                if (this.iTX == floatValue2) {
                    if (bHp - 1 >= 0) {
                        return bHp - 1;
                    }
                } else if (this.iTX == floatValue && bHp + 1 < y.getCount(this.iUb)) {
                    return bHp + 1;
                }
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zV(int i) {
        if (this.iUb.size() > i) {
            this.iUd = this.iUb.get(i).floatValue();
        }
        float f = 0.0f;
        if (this.iUb.size() > this.nDC.bHp()) {
            f = this.iUb.get(this.nDC.bHp()).floatValue();
        }
        this.mMoveDistance = Math.abs(f - this.iUd);
        this.iUe = this.nDC.bHp() < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zW(int i) {
        if (this.lqV != null && !this.lqV.zU(this.nDC.bHp())) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.nDC.tA(i);
            if (this.iUb.size() > this.nDC.bHp()) {
                this.iTX = this.iUb.get(this.nDC.bHp()).floatValue();
            }
            invalidate();
        }
    }

    public void setNeedDayNight(boolean z) {
        this.nDD = z;
        if (!this.nDD) {
            this.mBackgroundPaint.setColor(ap.getColor(0, this.mBackgroundColorId));
            if (this.nDx != null) {
                this.nDx.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(0, this.nDu), this.nDw));
            }
        }
    }

    public void setData(List<p> list) {
        if (dg(list)) {
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
        if (dg(list) || this.nDC == null || this.nDC.bHp() != i) {
            if (y.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            reset();
            setVisibility(0);
            this.nDC.tA(i);
            this.mData = list;
            requestLayout();
        }
    }

    private boolean dg(List<p> list) {
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
        if (pVar.dKd() == pVar2.dKd() && pVar.dKe() != null && pVar.dKe().equals(pVar2.dKe())) {
            return true;
        }
        return pVar.dKd() == pVar2.dKd() && pVar.dKe() == null && pVar2.dKe() == null;
    }

    public void reset() {
        this.nDC.tA(0);
        this.iTX = 0.0f;
        this.iTZ = false;
        this.mData.clear();
        this.iUb.clear();
        this.iUa = true;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.lqV = aVar;
    }

    public void onChangeSkinType() {
        if (this.nDD) {
            this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
            if (this.nDx != null) {
                this.nDx.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(this.mBackgroundColorId), this.nDw));
            }
            invalidate();
        }
    }

    public void setCanScroll(boolean z) {
        this.iTY = z;
    }

    public int getState() {
        return this.nDC.bHp();
    }

    public void jL(int i) {
        if (!y.isEmpty(this.mData) && !y.isEmpty(this.iUb)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mData.size()) {
                    if (this.mData.get(i3).dKd() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.nDC.tA(i3);
                        if (this.iUb.size() > i3) {
                            this.iTX = this.iUb.get(i3).floatValue();
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
        this.nDF = bdUniqueId;
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.nDE) {
            this.listener.setTag(bdUniqueId);
        }
    }
}
