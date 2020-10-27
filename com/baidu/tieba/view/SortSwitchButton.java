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
    private Paint bGS;
    private float hnY;
    private float iNa;
    private int iNb;
    private int iNc;
    private int iNd;
    private float iNe;
    private float iNf;
    private int iNg;
    private RectF iNj;
    private Path iNk;
    private RectF iNl;
    private Path iNm;
    private float iNo;
    private boolean iNp;
    private boolean iNq;
    private boolean iNr;
    private List<Float> iNs;
    private GestureDetector.SimpleOnGestureListener iNt;
    private float iNu;
    private boolean iNv;
    private CustomMessageListener listener;
    private a lkF;
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
    private int nwd;
    private float nwe;
    private float nwf;
    private Paint nwg;
    private RectF nwh;
    private Path nwi;
    private RectF nwj;
    private Path nwk;
    private com.baidu.tieba.e nwl;
    private boolean nwm;
    private boolean nwn;
    private BdUniqueId nwo;
    private BdUniqueId nwp;
    private e.a nwq;

    /* loaded from: classes.dex */
    public interface a {
        boolean zj(int i);
    }

    public SortSwitchButton(Context context) {
        this(context, null);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nwl = new com.baidu.tieba.e();
        this.iNp = false;
        this.iNq = false;
        this.iNr = true;
        this.nwm = true;
        this.nwn = false;
        this.nwp = BdUniqueId.gen();
        this.listener = new CustomMessageListener(2921458) { // from class: com.baidu.tieba.view.SortSwitchButton.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage) && (((CustomMessage) customResponsedMessage.getOrginalMessage()).getData() instanceof BdUniqueId)) {
                    BdUniqueId bdUniqueId = (BdUniqueId) ((CustomMessage) customResponsedMessage.getOrginalMessage()).getData();
                    BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                    if (tag != null && bdUniqueId != null && SortSwitchButton.this.nwo != null) {
                        Integer num = (Integer) customResponsedMessage.getData();
                        if (tag.getId() == SortSwitchButton.this.nwo.getId() && bdUniqueId.getId() != SortSwitchButton.this.nwp.getId() && SortSwitchButton.this.nwl.bFx() != num.intValue() && !y.isEmpty(SortSwitchButton.this.mData) && !y.isEmpty(SortSwitchButton.this.iNs) && SortSwitchButton.this.iNs.size() > num.intValue()) {
                            SortSwitchButton.this.nwl.sT(num.intValue());
                            SortSwitchButton.this.iNo = ((Float) SortSwitchButton.this.iNs.get(num.intValue())).floatValue();
                            SortSwitchButton.this.invalidate();
                        }
                    }
                }
            }
        };
        this.nwq = new e.a() { // from class: com.baidu.tieba.view.SortSwitchButton.2
            @Override // com.baidu.tieba.e.a
            public void bx(int i2, int i3) {
                ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i3));
                CustomMessage customMessage = new CustomMessage(2921458);
                customMessage.setTag(SortSwitchButton.this.nwo);
                customMessage.setData(SortSwitchButton.this.nwp);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        };
        this.iNt = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.view.SortSwitchButton.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!SortSwitchButton.this.iNq && motionEvent.getX() <= SortSwitchButton.this.mWidth && motionEvent.getY() <= SortSwitchButton.this.mHeight) {
                    if (SortSwitchButton.this.getParent() != null) {
                        SortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int bFx = SortSwitchButton.this.nwl.bFx();
                SortSwitchButton.this.iNo = motionEvent.getX();
                SortSwitchButton.this.nwl.sS(SortSwitchButton.this.czM());
                SortSwitchButton.this.iNq = true;
                if (SortSwitchButton.this.nwl.bFx() != bFx) {
                    SortSwitchButton.this.zk(bFx);
                    if (SortSwitchButton.this.mValueAnimator != null) {
                        SortSwitchButton.this.mValueAnimator.start();
                    }
                    SortSwitchButton.this.zl(bFx);
                }
                SortSwitchButton.this.iNq = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (SortSwitchButton.this.iNp) {
                    SortSwitchButton.this.iNo -= f;
                    if (SortSwitchButton.this.iNo < 0.0f) {
                        SortSwitchButton.this.iNo = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(SortSwitchButton.this.iNs, SortSwitchButton.this.iNs.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (SortSwitchButton.this.iNo > floatValue) {
                        SortSwitchButton.this.iNo = floatValue;
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
        if (this.nwn) {
            this.nwl.a(this.nwq);
            MessageManager.getInstance().registerListener(this.listener);
        }
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SortSwitchButton);
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_color, R.color.cp_cont_j);
        this.nwd = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_border_color, this.mBackgroundColorId);
        this.nwe = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_background_border_width, 0.0f);
        this.nwf = obtainStyledAttributes.getFloat(R.styleable.SortSwitchButton_background_border_alpha, 1.0f);
        this.iNb = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_color, R.color.cp_cont_a);
        this.iNc = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_un_selected_text_color, R.color.cp_cont_b);
        this.iNd = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_selected_text_color, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_size, 5.0f);
        this.iNe = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_horizontal_padding, 0.0f);
        this.iNa = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_height, 0.0f);
        this.iNf = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_border_width, 0.0f);
        this.iNg = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_border_color, R.color.cp_cont_b);
        this.nwn = obtainStyledAttributes.getBoolean(R.styleable.SortSwitchButton_slide_need_sync, false);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.iNj = new RectF();
        this.iNk = new Path();
        this.iNl = new RectF();
        this.iNm = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        if (this.nwd > 0 && this.nwe > 0.0f) {
            this.nwh = new RectF();
            this.nwi = new Path();
            this.nwj = new RectF();
            this.nwk = new Path();
            this.nwg = new Paint(1);
            this.nwg.setStyle(Paint.Style.STROKE);
            this.nwg.setStrokeWidth(this.nwe);
            this.nwg.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(this.mBackgroundColorId), this.nwf));
        }
        this.bGS = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.iNs = new ArrayList();
        this.nwl.sT(0);
        this.mGestureDetector = new GestureDetector(context, this.iNt);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SortSwitchButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * SortSwitchButton.this.mMoveDistance;
                if (SortSwitchButton.this.iNv) {
                    SortSwitchButton.this.iNo = SortSwitchButton.this.iNu - floatValue;
                } else {
                    SortSwitchButton.this.iNo = floatValue + SortSwitchButton.this.iNu;
                }
                SortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.view.SortSwitchButton.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (SortSwitchButton.this.iNs.size() > SortSwitchButton.this.nwl.bFx()) {
                    SortSwitchButton.this.iNo = ((Float) SortSwitchButton.this.iNs.get(SortSwitchButton.this.nwl.bFx())).floatValue();
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
                    float measureText = this.mTextPaint.measureText(pVar.dHL() == null ? "" : pVar.dHL()) + (this.iNe * 2.0f);
                    if (this.iNr) {
                        this.iNs.add(Float.valueOf(this.mWidth));
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
                if (this.iNr) {
                    this.iNs.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.iNa;
        } else {
            this.mHeight = size2;
            this.iNa = this.mHeight;
        }
        this.iNr = false;
        zQ();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void zQ() {
        this.iNj.set(this.nwe, this.nwe, this.mWidth - this.nwe, this.mHeight - this.nwe);
        this.iNk.reset();
        this.iNk.addRoundRect(this.iNj, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        if (this.nwh != null && this.nwg != null) {
            this.nwh.set(0.0f, 0.0f, this.mWidth, this.mHeight);
            float f = this.nwe * 0.5f;
            this.nwj.set(-f, -f, this.mWidth + f, this.mHeight + f);
            this.nwi.reset();
            this.nwk.reset();
            this.nwi.addRoundRect(this.nwh, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
            this.nwk.addRoundRect(this.nwj, (this.mHeight + f) * 0.5f, (f + this.mHeight) * 0.5f, Path.Direction.CW);
        }
        Float f2 = (Float) y.getItem(this.iNs, this.nwl.bFx());
        this.iNo = f2 != null ? f2.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.hnY = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.nwk != null) {
            canvas.clipPath(this.nwk);
        } else {
            canvas.clipPath(this.iNk);
        }
        super.onDraw(canvas);
        ap(canvas);
        R(canvas);
        int i = 0;
        while (i < this.mData.size() && i < this.iNs.size()) {
            a(canvas, this.mData.get(i).dHL(), this.iNs.get(i).floatValue() + this.iNe, this.hnY, this.nwl.bFx() == i);
            i++;
        }
    }

    private void ap(Canvas canvas) {
        canvas.drawPath(this.iNk, this.mBackgroundPaint);
        if (this.nwd > 0 && this.nwe > 0.0f && this.nwg != null) {
            canvas.drawPath(this.nwi, this.nwg);
        }
    }

    private void R(Canvas canvas) {
        float f;
        this.iNm.reset();
        if (this.iNo < 0.0f) {
            this.iNo = 0.0f;
        }
        float floatValue = !y.isEmpty(this.iNs) ? ((Float) y.getItem(this.iNs, this.nwl.bFx())).floatValue() : 0.0f;
        if (this.nwl.bFx() + 1 < this.iNs.size()) {
            f = this.iNs.get(this.nwl.bFx() + 1).floatValue();
        } else {
            f = this.nwl.bFx() + 1 == this.iNs.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.iNo;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.iNl.set(this.iNo, 0.0f, f2, this.mHeight);
        this.iNm.addRoundRect(this.iNl, this.iNa / 2.0f, this.iNa / 2.0f, Path.Direction.CW);
        this.bGS.setColor(this.nwm ? ap.getColor(this.iNg) : ap.getColor(0, this.iNg));
        canvas.drawPath(this.iNm, this.bGS);
        this.iNm.reset();
        this.iNl.set(this.iNo + this.iNf, this.iNf, f2 - this.iNf, this.mHeight - this.iNf);
        this.iNm.addRoundRect(this.iNl, (this.iNa - (this.iNf * 2.0f)) / 2.0f, (this.iNa - (this.iNf * 2.0f)) / 2.0f, Path.Direction.CW);
        this.bGS.setColor(this.nwm ? ap.getColor(this.iNb) : ap.getColor(0, this.iNb));
        canvas.drawPath(this.iNm, this.bGS);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(this.nwm ? ap.getColor(this.iNd) : ap.getColor(0, this.iNd));
        } else {
            this.mTextPaint.setColor(this.nwm ? ap.getColor(this.iNc) : ap.getColor(0, this.iNc));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.iNp && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int bFx = this.nwl.bFx();
            int czM = czM();
            if (Math.abs(czM - bFx) >= 2 || czM > bFx) {
                this.nwl.sT(czM);
            } else if (czM < bFx) {
                float floatValue = this.iNs.size() > czM ? this.iNs.get(czM).floatValue() : 0.0f;
                float floatValue2 = czM + 1 < this.iNs.size() ? this.iNs.get(czM + 1).floatValue() : floatValue;
                if (this.iNo >= floatValue && this.iNo <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.nwl.sT(czM);
                }
            } else {
                float floatValue3 = this.iNs.size() > czM ? this.iNs.get(czM).floatValue() : 0.0f;
                if (this.iNo >= (((czM + 1 < this.iNs.size() ? this.iNs.get(czM + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && czM + 1 < this.iNs.size()) {
                    this.nwl.sT(czM + 1);
                }
            }
            this.iNq = true;
            this.iNu = this.iNo;
            float floatValue4 = this.iNs.size() > this.nwl.bFx() ? this.iNs.get(this.nwl.bFx()).floatValue() : 0.0f;
            this.mMoveDistance = Math.abs(this.iNu - floatValue4);
            if (this.nwl.bFx() < bFx) {
                this.iNv = true;
            } else if (this.nwl.bFx() > bFx) {
                this.iNv = false;
            } else {
                this.iNv = this.iNu > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.nwl.bFx() != bFx) {
                zl(bFx);
            }
            this.iNq = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int czM() {
        float floatValue;
        int bFx = this.nwl.bFx();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.iNs.size()) {
                return bFx;
            }
            float floatValue2 = ((Float) y.getItem(this.iNs, i2)).floatValue();
            if (i2 + 1 == this.iNs.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) y.getItem(this.iNs, i2 + 1)).floatValue();
            }
            if (this.iNo <= floatValue2 || this.iNo >= floatValue) {
                if (this.iNo == floatValue2) {
                    if (bFx - 1 >= 0) {
                        return bFx - 1;
                    }
                } else if (this.iNo == floatValue && bFx + 1 < y.getCount(this.iNs)) {
                    return bFx + 1;
                }
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zk(int i) {
        if (this.iNs.size() > i) {
            this.iNu = this.iNs.get(i).floatValue();
        }
        float f = 0.0f;
        if (this.iNs.size() > this.nwl.bFx()) {
            f = this.iNs.get(this.nwl.bFx()).floatValue();
        }
        this.mMoveDistance = Math.abs(f - this.iNu);
        this.iNv = this.nwl.bFx() < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zl(int i) {
        if (this.lkF != null && !this.lkF.zj(this.nwl.bFx())) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.nwl.sS(i);
            if (this.iNs.size() > this.nwl.bFx()) {
                this.iNo = this.iNs.get(this.nwl.bFx()).floatValue();
            }
            invalidate();
        }
    }

    public void setNeedDayNight(boolean z) {
        this.nwm = z;
        if (!this.nwm) {
            this.mBackgroundPaint.setColor(ap.getColor(0, this.mBackgroundColorId));
            if (this.nwg != null) {
                this.nwg.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(0, this.nwd), this.nwf));
            }
        }
    }

    public void setData(List<p> list) {
        if (cY(list)) {
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
        if (cY(list) || this.nwl == null || this.nwl.bFx() != i) {
            if (y.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            reset();
            setVisibility(0);
            this.nwl.sS(i);
            this.mData = list;
            requestLayout();
        }
    }

    private boolean cY(List<p> list) {
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
        if (pVar.dHK() == pVar2.dHK() && pVar.dHL() != null && pVar.dHL().equals(pVar2.dHL())) {
            return true;
        }
        return pVar.dHK() == pVar2.dHK() && pVar.dHL() == null && pVar2.dHL() == null;
    }

    public void reset() {
        this.nwl.sS(0);
        this.iNo = 0.0f;
        this.iNq = false;
        this.mData.clear();
        this.iNs.clear();
        this.iNr = true;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.lkF = aVar;
    }

    public void onChangeSkinType() {
        if (this.nwm) {
            this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
            if (this.nwg != null) {
                this.nwg.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(this.mBackgroundColorId), this.nwf));
            }
            invalidate();
        }
    }

    public void setCanScroll(boolean z) {
        this.iNp = z;
    }

    public int getState() {
        return this.nwl.bFx();
    }

    public void jF(int i) {
        if (!y.isEmpty(this.mData) && !y.isEmpty(this.iNs)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mData.size()) {
                    if (this.mData.get(i3).dHK() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.nwl.sS(i3);
                        if (this.iNs.size() > i3) {
                            this.iNo = this.iNs.get(i3).floatValue();
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
        this.nwo = bdUniqueId;
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.nwn) {
            this.listener.setTag(bdUniqueId);
        }
    }
}
