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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SortSwitchButton extends View implements View.OnTouchListener {
    private Paint biN;
    private CustomMessageListener dVL;
    private float gfn;
    private boolean hxA;
    private boolean hxB;
    private List<Float> hxC;
    private GestureDetector.SimpleOnGestureListener hxD;
    private float hxE;
    private boolean hxF;
    private float hxk;
    private int hxl;
    private int hxm;
    private int hxn;
    private float hxo;
    private float hxp;
    private int hxq;
    private RectF hxt;
    private Path hxu;
    private RectF hxv;
    private Path hxw;
    private float hxy;
    private boolean hxz;
    private a jHF;
    private BdUniqueId lOA;
    private BdUniqueId lOB;
    private d.a lOC;
    private int lOr;
    private float lOs;
    private float lOt;
    private Paint lOu;
    private RectF lOv;
    private Path lOw;
    private com.baidu.tieba.d lOx;
    private boolean lOy;
    private boolean lOz;
    private int mBackgroundColorId;
    private Paint mBackgroundPaint;
    private List<q> mData;
    private GestureDetector mGestureDetector;
    private float mHeight;
    private float mMoveDistance;
    private Paint mTextPaint;
    private float mTextSize;
    private ValueAnimator mValueAnimator;
    private float mWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean ut(int i);
    }

    public SortSwitchButton(Context context) {
        this(context, null);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lOx = new com.baidu.tieba.d();
        this.hxz = false;
        this.hxA = false;
        this.hxB = true;
        this.lOy = true;
        this.lOz = false;
        this.lOB = BdUniqueId.gen();
        this.dVL = new CustomMessageListener(2921458) { // from class: com.baidu.tieba.view.SortSwitchButton.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage) && (((CustomMessage) customResponsedMessage.getOrginalMessage()).getData() instanceof BdUniqueId)) {
                    BdUniqueId bdUniqueId = (BdUniqueId) ((CustomMessage) customResponsedMessage.getOrginalMessage()).getData();
                    BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                    if (tag != null && bdUniqueId != null && SortSwitchButton.this.lOA != null) {
                        Integer num = (Integer) customResponsedMessage.getData();
                        if (tag.getId() == SortSwitchButton.this.lOA.getId() && bdUniqueId.getId() != SortSwitchButton.this.lOB.getId() && SortSwitchButton.this.lOx.bko() != num.intValue() && !v.isEmpty(SortSwitchButton.this.mData) && !v.isEmpty(SortSwitchButton.this.hxC) && SortSwitchButton.this.hxC.size() > num.intValue()) {
                            SortSwitchButton.this.lOx.oP(num.intValue());
                            SortSwitchButton.this.hxy = ((Float) SortSwitchButton.this.hxC.get(num.intValue())).floatValue();
                            SortSwitchButton.this.invalidate();
                        }
                    }
                }
            }
        };
        this.lOC = new d.a() { // from class: com.baidu.tieba.view.SortSwitchButton.2
            @Override // com.baidu.tieba.d.a
            public void bh(int i2, int i3) {
                ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i3));
                CustomMessage customMessage = new CustomMessage(2921458);
                customMessage.setTag(SortSwitchButton.this.lOA);
                customMessage.setData(SortSwitchButton.this.lOB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        };
        this.hxD = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.view.SortSwitchButton.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!SortSwitchButton.this.hxA && motionEvent.getX() <= SortSwitchButton.this.mWidth && motionEvent.getY() <= SortSwitchButton.this.mHeight) {
                    if (SortSwitchButton.this.getParent() != null) {
                        SortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int bko = SortSwitchButton.this.lOx.bko();
                SortSwitchButton.this.hxy = motionEvent.getX();
                SortSwitchButton.this.lOx.oO(SortSwitchButton.this.bYz());
                SortSwitchButton.this.hxA = true;
                if (SortSwitchButton.this.lOx.bko() != bko) {
                    SortSwitchButton.this.uu(bko);
                    if (SortSwitchButton.this.mValueAnimator != null) {
                        SortSwitchButton.this.mValueAnimator.start();
                    }
                    SortSwitchButton.this.uv(bko);
                }
                SortSwitchButton.this.hxA = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (SortSwitchButton.this.hxz) {
                    SortSwitchButton.this.hxy -= f;
                    if (SortSwitchButton.this.hxy < 0.0f) {
                        SortSwitchButton.this.hxy = 0.0f;
                    }
                    Float f3 = (Float) v.getItem(SortSwitchButton.this.hxC, SortSwitchButton.this.hxC.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (SortSwitchButton.this.hxy > floatValue) {
                        SortSwitchButton.this.hxy = floatValue;
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
        if (this.lOz) {
            this.lOx.a(this.lOC);
            MessageManager.getInstance().registerListener(this.dVL);
        }
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SortSwitchButton);
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(1, R.color.cp_cont_j);
        this.lOr = obtainStyledAttributes.getResourceId(11, this.mBackgroundColorId);
        this.lOs = obtainStyledAttributes.getDimension(9, 0.0f);
        this.lOt = obtainStyledAttributes.getFloat(12, 1.0f);
        this.hxl = obtainStyledAttributes.getResourceId(2, R.color.cp_cont_a);
        this.hxm = obtainStyledAttributes.getResourceId(3, R.color.cp_cont_b);
        this.hxn = obtainStyledAttributes.getResourceId(4, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(0, 5.0f);
        this.hxo = obtainStyledAttributes.getDimension(5, 0.0f);
        this.hxk = obtainStyledAttributes.getDimension(6, 0.0f);
        this.hxp = obtainStyledAttributes.getDimension(7, 0.0f);
        this.hxq = obtainStyledAttributes.getResourceId(8, R.color.cp_cont_b);
        this.lOz = obtainStyledAttributes.getBoolean(10, false);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.hxt = new RectF();
        this.hxu = new Path();
        this.hxv = new RectF();
        this.hxw = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(am.getColor(this.mBackgroundColorId));
        if (this.lOr > 0 && this.lOs > 0.0f) {
            this.lOv = new RectF();
            this.lOw = new Path();
            this.lOu = new Paint(1);
            this.lOu.setStyle(Paint.Style.STROKE);
            this.lOu.setStrokeWidth(this.lOs);
            this.lOu.setColor(com.baidu.tieba.tbadkCore.c.l(am.getColor(this.mBackgroundColorId), this.lOt));
        }
        this.biN = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.hxC = new ArrayList();
        this.lOx.oP(0);
        this.mGestureDetector = new GestureDetector(context, this.hxD);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SortSwitchButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * SortSwitchButton.this.mMoveDistance;
                if (SortSwitchButton.this.hxF) {
                    SortSwitchButton.this.hxy = SortSwitchButton.this.hxE - floatValue;
                } else {
                    SortSwitchButton.this.hxy = floatValue + SortSwitchButton.this.hxE;
                }
                SortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.view.SortSwitchButton.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SortSwitchButton.this.hxy = ((Float) SortSwitchButton.this.hxC.get(SortSwitchButton.this.lOx.bko())).floatValue();
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
        int count = v.getCount(this.mData);
        if (mode == Integer.MIN_VALUE) {
            this.mWidth = 0.0f;
            for (int i3 = 0; i3 < count; i3++) {
                q qVar = (q) v.getItem(this.mData, i3);
                if (qVar != null) {
                    float measureText = this.mTextPaint.measureText(qVar.ddL() == null ? "" : qVar.ddL()) + (this.hxo * 2.0f);
                    if (this.hxB) {
                        this.hxC.add(Float.valueOf(this.mWidth));
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
                if (this.hxB) {
                    this.hxC.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.hxk;
        } else {
            this.mHeight = size2;
            this.hxk = this.mHeight;
        }
        this.hxB = false;
        tG();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void tG() {
        this.hxt.set(this.lOs, this.lOs, this.mWidth - this.lOs, this.mHeight - this.lOs);
        this.hxu.reset();
        this.hxu.addRoundRect(this.hxt, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        if (this.lOv != null && this.lOu != null) {
            this.lOv.set(0.0f, 0.0f, this.mWidth, this.mHeight);
            this.lOw.reset();
            this.lOw.addRoundRect(this.lOv, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        }
        Float f = (Float) v.getItem(this.hxC, this.lOx.bko());
        this.hxy = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.gfn = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.lOw != null) {
            canvas.clipPath(this.lOw);
        } else {
            canvas.clipPath(this.hxu);
        }
        super.onDraw(canvas);
        ad(canvas);
        I(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).ddL(), this.hxC.get(i).floatValue() + this.hxo, this.gfn, this.lOx.bko() == i);
            i++;
        }
    }

    private void ad(Canvas canvas) {
        canvas.drawPath(this.hxu, this.mBackgroundPaint);
        if (this.lOr > 0 && this.lOs > 0.0f && this.lOu != null) {
            canvas.drawPath(this.lOw, this.lOu);
        }
    }

    private void I(Canvas canvas) {
        float f;
        this.hxw.reset();
        if (this.hxy < 0.0f) {
            this.hxy = 0.0f;
        }
        float floatValue = !v.isEmpty(this.hxC) ? ((Float) v.getItem(this.hxC, this.lOx.bko())).floatValue() : 0.0f;
        if (this.lOx.bko() + 1 < this.hxC.size()) {
            f = this.hxC.get(this.lOx.bko() + 1).floatValue();
        } else {
            f = this.lOx.bko() + 1 == this.hxC.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.hxy;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.hxv.set(this.hxy, 0.0f, f2, this.mHeight);
        this.hxw.addRoundRect(this.hxv, this.hxk / 2.0f, this.hxk / 2.0f, Path.Direction.CW);
        this.biN.setColor(this.lOy ? am.getColor(this.hxq) : am.getColor(0, this.hxq));
        canvas.drawPath(this.hxw, this.biN);
        this.hxw.reset();
        this.hxv.set(this.hxy + this.hxp, this.hxp, f2 - this.hxp, this.mHeight - this.hxp);
        this.hxw.addRoundRect(this.hxv, (this.hxk - (this.hxp * 2.0f)) / 2.0f, (this.hxk - (this.hxp * 2.0f)) / 2.0f, Path.Direction.CW);
        this.biN.setColor(this.lOy ? am.getColor(this.hxl) : am.getColor(0, this.hxl));
        canvas.drawPath(this.hxw, this.biN);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(this.lOy ? am.getColor(this.hxn) : am.getColor(0, this.hxn));
        } else {
            this.mTextPaint.setColor(this.lOy ? am.getColor(this.hxm) : am.getColor(0, this.hxm));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.hxz && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int bko = this.lOx.bko();
            int bYz = bYz();
            if (Math.abs(bYz - bko) >= 2 || bYz > bko) {
                this.lOx.oP(bYz);
            } else if (bYz < bko) {
                float floatValue = this.hxC.get(bYz).floatValue();
                float floatValue2 = bYz + 1 < this.hxC.size() ? this.hxC.get(bYz + 1).floatValue() : floatValue;
                if (this.hxy >= floatValue && this.hxy <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.lOx.oP(bYz);
                }
            } else {
                float floatValue3 = this.hxC.get(bYz).floatValue();
                if (this.hxy >= (((bYz + 1 < this.hxC.size() ? this.hxC.get(bYz + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && bYz + 1 < this.hxC.size()) {
                    this.lOx.oP(bYz + 1);
                }
            }
            this.hxA = true;
            this.hxE = this.hxy;
            float floatValue4 = this.hxC.get(this.lOx.bko()).floatValue();
            this.mMoveDistance = Math.abs(this.hxE - floatValue4);
            if (this.lOx.bko() < bko) {
                this.hxF = true;
            } else if (this.lOx.bko() > bko) {
                this.hxF = false;
            } else {
                this.hxF = this.hxE > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.lOx.bko() != bko) {
                uv(bko);
            }
            this.hxA = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bYz() {
        float floatValue;
        int bko = this.lOx.bko();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.hxC.size()) {
                return bko;
            }
            float floatValue2 = ((Float) v.getItem(this.hxC, i2)).floatValue();
            if (i2 + 1 == this.hxC.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) v.getItem(this.hxC, i2 + 1)).floatValue();
            }
            if (this.hxy <= floatValue2 || this.hxy >= floatValue) {
                if (this.hxy == floatValue2) {
                    if (bko - 1 >= 0) {
                        return bko - 1;
                    }
                } else if (this.hxy == floatValue && bko + 1 < v.getCount(this.hxC)) {
                    return bko + 1;
                }
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uu(int i) {
        this.hxE = this.hxC.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.hxC.get(this.lOx.bko()).floatValue() - this.hxE);
        this.hxF = this.lOx.bko() < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uv(int i) {
        if (this.jHF != null && !this.jHF.ut(this.lOx.bko())) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.lOx.oO(i);
            this.hxy = this.hxC.get(this.lOx.bko()).floatValue();
            invalidate();
        }
    }

    public void setNeedDayNight(boolean z) {
        this.lOy = z;
        if (!this.lOy) {
            this.mBackgroundPaint.setColor(am.getColor(0, this.mBackgroundColorId));
            if (this.lOu != null) {
                this.lOu.setColor(com.baidu.tieba.tbadkCore.c.l(am.getColor(0, this.lOr), this.lOt));
            }
        }
    }

    public void setData(List<q> list) {
        if (cp(list)) {
            if (v.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.mData = list;
            requestLayout();
        }
    }

    public void setData(List<q> list, int i) {
        if (cp(list)) {
            if (v.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            reset();
            setVisibility(0);
            this.lOx.oO(i);
            this.mData = list;
            requestLayout();
        }
    }

    private boolean cp(List<q> list) {
        if (!v.isEmpty(list) && list.size() == this.mData.size()) {
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
        if (qVar.ddK() == qVar2.ddK() && qVar.ddL() != null && qVar.ddL().equals(qVar2.ddL())) {
            return true;
        }
        return qVar.ddK() == qVar2.ddK() && qVar.ddL() == null && qVar2.ddL() == null;
    }

    public void reset() {
        this.lOx.oO(0);
        this.hxy = 0.0f;
        this.hxA = false;
        this.mData.clear();
        this.hxC.clear();
        this.hxB = true;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.jHF = aVar;
    }

    public void onChangeSkinType() {
        if (this.lOy) {
            this.mBackgroundPaint.setColor(am.getColor(this.mBackgroundColorId));
            if (this.lOu != null) {
                this.lOu.setColor(com.baidu.tieba.tbadkCore.c.l(am.getColor(this.mBackgroundColorId), this.lOt));
            }
            invalidate();
        }
    }

    public void setCanScroll(boolean z) {
        this.hxz = z;
    }

    public int getState() {
        return this.lOx.bko();
    }

    public void changeState(int i) {
        if (!v.isEmpty(this.mData) && !v.isEmpty(this.hxC)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mData.size()) {
                    if (this.mData.get(i3).ddK() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.lOx.oO(i3);
                        this.hxy = this.hxC.get(i3).floatValue();
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
        this.lOA = bdUniqueId;
        if (this.lOz) {
            this.dVL.setTag(this.lOA);
        }
    }
}
