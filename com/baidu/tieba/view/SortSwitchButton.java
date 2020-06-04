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
    private float gfy;
    private float hxA;
    private int hxB;
    private RectF hxE;
    private Path hxF;
    private RectF hxG;
    private Path hxH;
    private float hxJ;
    private boolean hxK;
    private boolean hxL;
    private boolean hxM;
    private List<Float> hxN;
    private GestureDetector.SimpleOnGestureListener hxO;
    private float hxP;
    private boolean hxQ;
    private float hxv;
    private int hxw;
    private int hxx;
    private int hxy;
    private float hxz;
    private a jIL;
    private float lPA;
    private float lPB;
    private Paint lPC;
    private RectF lPD;
    private Path lPE;
    private com.baidu.tieba.d lPF;
    private boolean lPG;
    private boolean lPH;
    private BdUniqueId lPI;
    private BdUniqueId lPJ;
    private d.a lPK;
    private int lPz;
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
        boolean uv(int i);
    }

    public SortSwitchButton(Context context) {
        this(context, null);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lPF = new com.baidu.tieba.d();
        this.hxK = false;
        this.hxL = false;
        this.hxM = true;
        this.lPG = true;
        this.lPH = false;
        this.lPJ = BdUniqueId.gen();
        this.dVL = new CustomMessageListener(2921458) { // from class: com.baidu.tieba.view.SortSwitchButton.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage) && (((CustomMessage) customResponsedMessage.getOrginalMessage()).getData() instanceof BdUniqueId)) {
                    BdUniqueId bdUniqueId = (BdUniqueId) ((CustomMessage) customResponsedMessage.getOrginalMessage()).getData();
                    BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                    if (tag != null && bdUniqueId != null && SortSwitchButton.this.lPI != null) {
                        Integer num = (Integer) customResponsedMessage.getData();
                        if (tag.getId() == SortSwitchButton.this.lPI.getId() && bdUniqueId.getId() != SortSwitchButton.this.lPJ.getId() && SortSwitchButton.this.lPF.bkq() != num.intValue() && !v.isEmpty(SortSwitchButton.this.mData) && !v.isEmpty(SortSwitchButton.this.hxN) && SortSwitchButton.this.hxN.size() > num.intValue()) {
                            SortSwitchButton.this.lPF.oR(num.intValue());
                            SortSwitchButton.this.hxJ = ((Float) SortSwitchButton.this.hxN.get(num.intValue())).floatValue();
                            SortSwitchButton.this.invalidate();
                        }
                    }
                }
            }
        };
        this.lPK = new d.a() { // from class: com.baidu.tieba.view.SortSwitchButton.2
            @Override // com.baidu.tieba.d.a
            public void bh(int i2, int i3) {
                ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i3));
                CustomMessage customMessage = new CustomMessage(2921458);
                customMessage.setTag(SortSwitchButton.this.lPI);
                customMessage.setData(SortSwitchButton.this.lPJ);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        };
        this.hxO = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.view.SortSwitchButton.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!SortSwitchButton.this.hxL && motionEvent.getX() <= SortSwitchButton.this.mWidth && motionEvent.getY() <= SortSwitchButton.this.mHeight) {
                    if (SortSwitchButton.this.getParent() != null) {
                        SortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int bkq = SortSwitchButton.this.lPF.bkq();
                SortSwitchButton.this.hxJ = motionEvent.getX();
                SortSwitchButton.this.lPF.oQ(SortSwitchButton.this.bYC());
                SortSwitchButton.this.hxL = true;
                if (SortSwitchButton.this.lPF.bkq() != bkq) {
                    SortSwitchButton.this.uw(bkq);
                    if (SortSwitchButton.this.mValueAnimator != null) {
                        SortSwitchButton.this.mValueAnimator.start();
                    }
                    SortSwitchButton.this.ux(bkq);
                }
                SortSwitchButton.this.hxL = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (SortSwitchButton.this.hxK) {
                    SortSwitchButton.this.hxJ -= f;
                    if (SortSwitchButton.this.hxJ < 0.0f) {
                        SortSwitchButton.this.hxJ = 0.0f;
                    }
                    Float f3 = (Float) v.getItem(SortSwitchButton.this.hxN, SortSwitchButton.this.hxN.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (SortSwitchButton.this.hxJ > floatValue) {
                        SortSwitchButton.this.hxJ = floatValue;
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
        if (this.lPH) {
            this.lPF.a(this.lPK);
            MessageManager.getInstance().registerListener(this.dVL);
        }
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SortSwitchButton);
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(1, R.color.cp_cont_j);
        this.lPz = obtainStyledAttributes.getResourceId(11, this.mBackgroundColorId);
        this.lPA = obtainStyledAttributes.getDimension(9, 0.0f);
        this.lPB = obtainStyledAttributes.getFloat(12, 1.0f);
        this.hxw = obtainStyledAttributes.getResourceId(2, R.color.cp_cont_a);
        this.hxx = obtainStyledAttributes.getResourceId(3, R.color.cp_cont_b);
        this.hxy = obtainStyledAttributes.getResourceId(4, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(0, 5.0f);
        this.hxz = obtainStyledAttributes.getDimension(5, 0.0f);
        this.hxv = obtainStyledAttributes.getDimension(6, 0.0f);
        this.hxA = obtainStyledAttributes.getDimension(7, 0.0f);
        this.hxB = obtainStyledAttributes.getResourceId(8, R.color.cp_cont_b);
        this.lPH = obtainStyledAttributes.getBoolean(10, false);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.hxE = new RectF();
        this.hxF = new Path();
        this.hxG = new RectF();
        this.hxH = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(am.getColor(this.mBackgroundColorId));
        if (this.lPz > 0 && this.lPA > 0.0f) {
            this.lPD = new RectF();
            this.lPE = new Path();
            this.lPC = new Paint(1);
            this.lPC.setStyle(Paint.Style.STROKE);
            this.lPC.setStrokeWidth(this.lPA);
            this.lPC.setColor(com.baidu.tieba.tbadkCore.c.l(am.getColor(this.mBackgroundColorId), this.lPB));
        }
        this.biN = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.hxN = new ArrayList();
        this.lPF.oR(0);
        this.mGestureDetector = new GestureDetector(context, this.hxO);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SortSwitchButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * SortSwitchButton.this.mMoveDistance;
                if (SortSwitchButton.this.hxQ) {
                    SortSwitchButton.this.hxJ = SortSwitchButton.this.hxP - floatValue;
                } else {
                    SortSwitchButton.this.hxJ = floatValue + SortSwitchButton.this.hxP;
                }
                SortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.view.SortSwitchButton.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SortSwitchButton.this.hxJ = ((Float) SortSwitchButton.this.hxN.get(SortSwitchButton.this.lPF.bkq())).floatValue();
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
                    float measureText = this.mTextPaint.measureText(qVar.dea() == null ? "" : qVar.dea()) + (this.hxz * 2.0f);
                    if (this.hxM) {
                        this.hxN.add(Float.valueOf(this.mWidth));
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
                if (this.hxM) {
                    this.hxN.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.hxv;
        } else {
            this.mHeight = size2;
            this.hxv = this.mHeight;
        }
        this.hxM = false;
        tG();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void tG() {
        this.hxE.set(this.lPA, this.lPA, this.mWidth - this.lPA, this.mHeight - this.lPA);
        this.hxF.reset();
        this.hxF.addRoundRect(this.hxE, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        if (this.lPD != null && this.lPC != null) {
            this.lPD.set(0.0f, 0.0f, this.mWidth, this.mHeight);
            this.lPE.reset();
            this.lPE.addRoundRect(this.lPD, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        }
        Float f = (Float) v.getItem(this.hxN, this.lPF.bkq());
        this.hxJ = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.gfy = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.lPE != null) {
            canvas.clipPath(this.lPE);
        } else {
            canvas.clipPath(this.hxF);
        }
        super.onDraw(canvas);
        ad(canvas);
        I(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).dea(), this.hxN.get(i).floatValue() + this.hxz, this.gfy, this.lPF.bkq() == i);
            i++;
        }
    }

    private void ad(Canvas canvas) {
        canvas.drawPath(this.hxF, this.mBackgroundPaint);
        if (this.lPz > 0 && this.lPA > 0.0f && this.lPC != null) {
            canvas.drawPath(this.lPE, this.lPC);
        }
    }

    private void I(Canvas canvas) {
        float f;
        this.hxH.reset();
        if (this.hxJ < 0.0f) {
            this.hxJ = 0.0f;
        }
        float floatValue = !v.isEmpty(this.hxN) ? ((Float) v.getItem(this.hxN, this.lPF.bkq())).floatValue() : 0.0f;
        if (this.lPF.bkq() + 1 < this.hxN.size()) {
            f = this.hxN.get(this.lPF.bkq() + 1).floatValue();
        } else {
            f = this.lPF.bkq() + 1 == this.hxN.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.hxJ;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.hxG.set(this.hxJ, 0.0f, f2, this.mHeight);
        this.hxH.addRoundRect(this.hxG, this.hxv / 2.0f, this.hxv / 2.0f, Path.Direction.CW);
        this.biN.setColor(this.lPG ? am.getColor(this.hxB) : am.getColor(0, this.hxB));
        canvas.drawPath(this.hxH, this.biN);
        this.hxH.reset();
        this.hxG.set(this.hxJ + this.hxA, this.hxA, f2 - this.hxA, this.mHeight - this.hxA);
        this.hxH.addRoundRect(this.hxG, (this.hxv - (this.hxA * 2.0f)) / 2.0f, (this.hxv - (this.hxA * 2.0f)) / 2.0f, Path.Direction.CW);
        this.biN.setColor(this.lPG ? am.getColor(this.hxw) : am.getColor(0, this.hxw));
        canvas.drawPath(this.hxH, this.biN);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(this.lPG ? am.getColor(this.hxy) : am.getColor(0, this.hxy));
        } else {
            this.mTextPaint.setColor(this.lPG ? am.getColor(this.hxx) : am.getColor(0, this.hxx));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.hxK && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int bkq = this.lPF.bkq();
            int bYC = bYC();
            if (Math.abs(bYC - bkq) >= 2 || bYC > bkq) {
                this.lPF.oR(bYC);
            } else if (bYC < bkq) {
                float floatValue = this.hxN.get(bYC).floatValue();
                float floatValue2 = bYC + 1 < this.hxN.size() ? this.hxN.get(bYC + 1).floatValue() : floatValue;
                if (this.hxJ >= floatValue && this.hxJ <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.lPF.oR(bYC);
                }
            } else {
                float floatValue3 = this.hxN.get(bYC).floatValue();
                if (this.hxJ >= (((bYC + 1 < this.hxN.size() ? this.hxN.get(bYC + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && bYC + 1 < this.hxN.size()) {
                    this.lPF.oR(bYC + 1);
                }
            }
            this.hxL = true;
            this.hxP = this.hxJ;
            float floatValue4 = this.hxN.get(this.lPF.bkq()).floatValue();
            this.mMoveDistance = Math.abs(this.hxP - floatValue4);
            if (this.lPF.bkq() < bkq) {
                this.hxQ = true;
            } else if (this.lPF.bkq() > bkq) {
                this.hxQ = false;
            } else {
                this.hxQ = this.hxP > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.lPF.bkq() != bkq) {
                ux(bkq);
            }
            this.hxL = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bYC() {
        float floatValue;
        int bkq = this.lPF.bkq();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.hxN.size()) {
                return bkq;
            }
            float floatValue2 = ((Float) v.getItem(this.hxN, i2)).floatValue();
            if (i2 + 1 == this.hxN.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) v.getItem(this.hxN, i2 + 1)).floatValue();
            }
            if (this.hxJ <= floatValue2 || this.hxJ >= floatValue) {
                if (this.hxJ == floatValue2) {
                    if (bkq - 1 >= 0) {
                        return bkq - 1;
                    }
                } else if (this.hxJ == floatValue && bkq + 1 < v.getCount(this.hxN)) {
                    return bkq + 1;
                }
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uw(int i) {
        this.hxP = this.hxN.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.hxN.get(this.lPF.bkq()).floatValue() - this.hxP);
        this.hxQ = this.lPF.bkq() < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux(int i) {
        if (this.jIL != null && !this.jIL.uv(this.lPF.bkq())) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.lPF.oQ(i);
            this.hxJ = this.hxN.get(this.lPF.bkq()).floatValue();
            invalidate();
        }
    }

    public void setNeedDayNight(boolean z) {
        this.lPG = z;
        if (!this.lPG) {
            this.mBackgroundPaint.setColor(am.getColor(0, this.mBackgroundColorId));
            if (this.lPC != null) {
                this.lPC.setColor(com.baidu.tieba.tbadkCore.c.l(am.getColor(0, this.lPz), this.lPB));
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
            this.lPF.oQ(i);
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
        if (qVar.ddZ() == qVar2.ddZ() && qVar.dea() != null && qVar.dea().equals(qVar2.dea())) {
            return true;
        }
        return qVar.ddZ() == qVar2.ddZ() && qVar.dea() == null && qVar2.dea() == null;
    }

    public void reset() {
        this.lPF.oQ(0);
        this.hxJ = 0.0f;
        this.hxL = false;
        this.mData.clear();
        this.hxN.clear();
        this.hxM = true;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.jIL = aVar;
    }

    public void onChangeSkinType() {
        if (this.lPG) {
            this.mBackgroundPaint.setColor(am.getColor(this.mBackgroundColorId));
            if (this.lPC != null) {
                this.lPC.setColor(com.baidu.tieba.tbadkCore.c.l(am.getColor(this.mBackgroundColorId), this.lPB));
            }
            invalidate();
        }
    }

    public void setCanScroll(boolean z) {
        this.hxK = z;
    }

    public int getState() {
        return this.lPF.bkq();
    }

    public void changeState(int i) {
        if (!v.isEmpty(this.mData) && !v.isEmpty(this.hxN)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mData.size()) {
                    if (this.mData.get(i3).ddZ() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.lPF.oQ(i3);
                        this.hxJ = this.hxN.get(i3).floatValue();
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
        this.lPI = bdUniqueId;
        if (this.lPH) {
            this.dVL.setTag(this.lPI);
        }
    }
}
