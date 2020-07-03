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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SortSwitchButton extends View implements View.OnTouchListener {
    private Paint bnQ;
    private float gsv;
    private RectF hKB;
    private Path hKC;
    private RectF hKD;
    private Path hKE;
    private float hKG;
    private boolean hKH;
    private boolean hKI;
    private boolean hKJ;
    private List<Float> hKK;
    private GestureDetector.SimpleOnGestureListener hKL;
    private float hKM;
    private boolean hKN;
    private float hKs;
    private int hKt;
    private int hKu;
    private int hKv;
    private float hKw;
    private float hKx;
    private int hKy;
    private a kcv;
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
    private int mjG;
    private float mjH;
    private float mjI;
    private Paint mjJ;
    private RectF mjK;
    private Path mjL;
    private com.baidu.tieba.d mjM;
    private boolean mjN;
    private boolean mjO;
    private BdUniqueId mjP;
    private BdUniqueId mjQ;
    private d.a mjR;

    /* loaded from: classes.dex */
    public interface a {
        boolean va(int i);
    }

    public SortSwitchButton(Context context) {
        this(context, null);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mjM = new com.baidu.tieba.d();
        this.hKH = false;
        this.hKI = false;
        this.hKJ = true;
        this.mjN = true;
        this.mjO = false;
        this.mjQ = BdUniqueId.gen();
        this.listener = new CustomMessageListener(2921458) { // from class: com.baidu.tieba.view.SortSwitchButton.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage) && (((CustomMessage) customResponsedMessage.getOrginalMessage()).getData() instanceof BdUniqueId)) {
                    BdUniqueId bdUniqueId = (BdUniqueId) ((CustomMessage) customResponsedMessage.getOrginalMessage()).getData();
                    BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                    if (tag != null && bdUniqueId != null && SortSwitchButton.this.mjP != null) {
                        Integer num = (Integer) customResponsedMessage.getData();
                        if (tag.getId() == SortSwitchButton.this.mjP.getId() && bdUniqueId.getId() != SortSwitchButton.this.mjQ.getId() && SortSwitchButton.this.mjM.bmP() != num.intValue() && !w.isEmpty(SortSwitchButton.this.mData) && !w.isEmpty(SortSwitchButton.this.hKK) && SortSwitchButton.this.hKK.size() > num.intValue()) {
                            SortSwitchButton.this.mjM.pq(num.intValue());
                            SortSwitchButton.this.hKG = ((Float) SortSwitchButton.this.hKK.get(num.intValue())).floatValue();
                            SortSwitchButton.this.invalidate();
                        }
                    }
                }
            }
        };
        this.mjR = new d.a() { // from class: com.baidu.tieba.view.SortSwitchButton.2
            @Override // com.baidu.tieba.d.a
            public void bl(int i2, int i3) {
                ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i3));
                CustomMessage customMessage = new CustomMessage(2921458);
                customMessage.setTag(SortSwitchButton.this.mjP);
                customMessage.setData(SortSwitchButton.this.mjQ);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        };
        this.hKL = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.view.SortSwitchButton.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!SortSwitchButton.this.hKI && motionEvent.getX() <= SortSwitchButton.this.mWidth && motionEvent.getY() <= SortSwitchButton.this.mHeight) {
                    if (SortSwitchButton.this.getParent() != null) {
                        SortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int bmP = SortSwitchButton.this.mjM.bmP();
                SortSwitchButton.this.hKG = motionEvent.getX();
                SortSwitchButton.this.mjM.pp(SortSwitchButton.this.cbQ());
                SortSwitchButton.this.hKI = true;
                if (SortSwitchButton.this.mjM.bmP() != bmP) {
                    SortSwitchButton.this.vb(bmP);
                    if (SortSwitchButton.this.mValueAnimator != null) {
                        SortSwitchButton.this.mValueAnimator.start();
                    }
                    SortSwitchButton.this.vc(bmP);
                }
                SortSwitchButton.this.hKI = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (SortSwitchButton.this.hKH) {
                    SortSwitchButton.this.hKG -= f;
                    if (SortSwitchButton.this.hKG < 0.0f) {
                        SortSwitchButton.this.hKG = 0.0f;
                    }
                    Float f3 = (Float) w.getItem(SortSwitchButton.this.hKK, SortSwitchButton.this.hKK.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (SortSwitchButton.this.hKG > floatValue) {
                        SortSwitchButton.this.hKG = floatValue;
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
        if (this.mjO) {
            this.mjM.a(this.mjR);
            MessageManager.getInstance().registerListener(this.listener);
        }
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SortSwitchButton);
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(1, R.color.cp_cont_j);
        this.mjG = obtainStyledAttributes.getResourceId(11, this.mBackgroundColorId);
        this.mjH = obtainStyledAttributes.getDimension(9, 0.0f);
        this.mjI = obtainStyledAttributes.getFloat(12, 1.0f);
        this.hKt = obtainStyledAttributes.getResourceId(2, R.color.cp_cont_a);
        this.hKu = obtainStyledAttributes.getResourceId(3, R.color.cp_cont_b);
        this.hKv = obtainStyledAttributes.getResourceId(4, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(0, 5.0f);
        this.hKw = obtainStyledAttributes.getDimension(5, 0.0f);
        this.hKs = obtainStyledAttributes.getDimension(6, 0.0f);
        this.hKx = obtainStyledAttributes.getDimension(7, 0.0f);
        this.hKy = obtainStyledAttributes.getResourceId(8, R.color.cp_cont_b);
        this.mjO = obtainStyledAttributes.getBoolean(10, false);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.hKB = new RectF();
        this.hKC = new Path();
        this.hKD = new RectF();
        this.hKE = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(an.getColor(this.mBackgroundColorId));
        if (this.mjG > 0 && this.mjH > 0.0f) {
            this.mjK = new RectF();
            this.mjL = new Path();
            this.mjJ = new Paint(1);
            this.mjJ.setStyle(Paint.Style.STROKE);
            this.mjJ.setStrokeWidth(this.mjH);
            this.mjJ.setColor(com.baidu.tieba.tbadkCore.c.l(an.getColor(this.mBackgroundColorId), this.mjI));
        }
        this.bnQ = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.hKK = new ArrayList();
        this.mjM.pq(0);
        this.mGestureDetector = new GestureDetector(context, this.hKL);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SortSwitchButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * SortSwitchButton.this.mMoveDistance;
                if (SortSwitchButton.this.hKN) {
                    SortSwitchButton.this.hKG = SortSwitchButton.this.hKM - floatValue;
                } else {
                    SortSwitchButton.this.hKG = floatValue + SortSwitchButton.this.hKM;
                }
                SortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.view.SortSwitchButton.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SortSwitchButton.this.hKG = ((Float) SortSwitchButton.this.hKK.get(SortSwitchButton.this.mjM.bmP())).floatValue();
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
        int count = w.getCount(this.mData);
        if (mode == Integer.MIN_VALUE) {
            this.mWidth = 0.0f;
            for (int i3 = 0; i3 < count; i3++) {
                p pVar = (p) w.getItem(this.mData, i3);
                if (pVar != null) {
                    float measureText = this.mTextPaint.measureText(pVar.dim() == null ? "" : pVar.dim()) + (this.hKw * 2.0f);
                    if (this.hKJ) {
                        this.hKK.add(Float.valueOf(this.mWidth));
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
                if (this.hKJ) {
                    this.hKK.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.hKs;
        } else {
            this.mHeight = size2;
            this.hKs = this.mHeight;
        }
        this.hKJ = false;
        tY();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void tY() {
        this.hKB.set(this.mjH, this.mjH, this.mWidth - this.mjH, this.mHeight - this.mjH);
        this.hKC.reset();
        this.hKC.addRoundRect(this.hKB, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        if (this.mjK != null && this.mjJ != null) {
            this.mjK.set(0.0f, 0.0f, this.mWidth, this.mHeight);
            this.mjL.reset();
            this.mjL.addRoundRect(this.mjK, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        }
        Float f = (Float) w.getItem(this.hKK, this.mjM.bmP());
        this.hKG = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.gsv = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mjL != null) {
            canvas.clipPath(this.mjL);
        } else {
            canvas.clipPath(this.hKC);
        }
        super.onDraw(canvas);
        ai(canvas);
        J(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).dim(), this.hKK.get(i).floatValue() + this.hKw, this.gsv, this.mjM.bmP() == i);
            i++;
        }
    }

    private void ai(Canvas canvas) {
        canvas.drawPath(this.hKC, this.mBackgroundPaint);
        if (this.mjG > 0 && this.mjH > 0.0f && this.mjJ != null) {
            canvas.drawPath(this.mjL, this.mjJ);
        }
    }

    private void J(Canvas canvas) {
        float f;
        this.hKE.reset();
        if (this.hKG < 0.0f) {
            this.hKG = 0.0f;
        }
        float floatValue = !w.isEmpty(this.hKK) ? ((Float) w.getItem(this.hKK, this.mjM.bmP())).floatValue() : 0.0f;
        if (this.mjM.bmP() + 1 < this.hKK.size()) {
            f = this.hKK.get(this.mjM.bmP() + 1).floatValue();
        } else {
            f = this.mjM.bmP() + 1 == this.hKK.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.hKG;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.hKD.set(this.hKG, 0.0f, f2, this.mHeight);
        this.hKE.addRoundRect(this.hKD, this.hKs / 2.0f, this.hKs / 2.0f, Path.Direction.CW);
        this.bnQ.setColor(this.mjN ? an.getColor(this.hKy) : an.getColor(0, this.hKy));
        canvas.drawPath(this.hKE, this.bnQ);
        this.hKE.reset();
        this.hKD.set(this.hKG + this.hKx, this.hKx, f2 - this.hKx, this.mHeight - this.hKx);
        this.hKE.addRoundRect(this.hKD, (this.hKs - (this.hKx * 2.0f)) / 2.0f, (this.hKs - (this.hKx * 2.0f)) / 2.0f, Path.Direction.CW);
        this.bnQ.setColor(this.mjN ? an.getColor(this.hKt) : an.getColor(0, this.hKt));
        canvas.drawPath(this.hKE, this.bnQ);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(this.mjN ? an.getColor(this.hKv) : an.getColor(0, this.hKv));
        } else {
            this.mTextPaint.setColor(this.mjN ? an.getColor(this.hKu) : an.getColor(0, this.hKu));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.hKH && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int bmP = this.mjM.bmP();
            int cbQ = cbQ();
            if (Math.abs(cbQ - bmP) >= 2 || cbQ > bmP) {
                this.mjM.pq(cbQ);
            } else if (cbQ < bmP) {
                float floatValue = this.hKK.get(cbQ).floatValue();
                float floatValue2 = cbQ + 1 < this.hKK.size() ? this.hKK.get(cbQ + 1).floatValue() : floatValue;
                if (this.hKG >= floatValue && this.hKG <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.mjM.pq(cbQ);
                }
            } else {
                float floatValue3 = this.hKK.get(cbQ).floatValue();
                if (this.hKG >= (((cbQ + 1 < this.hKK.size() ? this.hKK.get(cbQ + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cbQ + 1 < this.hKK.size()) {
                    this.mjM.pq(cbQ + 1);
                }
            }
            this.hKI = true;
            this.hKM = this.hKG;
            float floatValue4 = this.hKK.get(this.mjM.bmP()).floatValue();
            this.mMoveDistance = Math.abs(this.hKM - floatValue4);
            if (this.mjM.bmP() < bmP) {
                this.hKN = true;
            } else if (this.mjM.bmP() > bmP) {
                this.hKN = false;
            } else {
                this.hKN = this.hKM > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.mjM.bmP() != bmP) {
                vc(bmP);
            }
            this.hKI = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cbQ() {
        float floatValue;
        int bmP = this.mjM.bmP();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.hKK.size()) {
                return bmP;
            }
            float floatValue2 = ((Float) w.getItem(this.hKK, i2)).floatValue();
            if (i2 + 1 == this.hKK.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) w.getItem(this.hKK, i2 + 1)).floatValue();
            }
            if (this.hKG <= floatValue2 || this.hKG >= floatValue) {
                if (this.hKG == floatValue2) {
                    if (bmP - 1 >= 0) {
                        return bmP - 1;
                    }
                } else if (this.hKG == floatValue && bmP + 1 < w.getCount(this.hKK)) {
                    return bmP + 1;
                }
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vb(int i) {
        this.hKM = this.hKK.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.hKK.get(this.mjM.bmP()).floatValue() - this.hKM);
        this.hKN = this.mjM.bmP() < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vc(int i) {
        if (this.kcv != null && !this.kcv.va(this.mjM.bmP())) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.mjM.pp(i);
            this.hKG = this.hKK.get(this.mjM.bmP()).floatValue();
            invalidate();
        }
    }

    public void setNeedDayNight(boolean z) {
        this.mjN = z;
        if (!this.mjN) {
            this.mBackgroundPaint.setColor(an.getColor(0, this.mBackgroundColorId));
            if (this.mjJ != null) {
                this.mjJ.setColor(com.baidu.tieba.tbadkCore.c.l(an.getColor(0, this.mjG), this.mjI));
            }
        }
    }

    public void setData(List<p> list) {
        if (cz(list)) {
            if (w.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.mData = list;
            requestLayout();
        }
    }

    public void setData(List<p> list, int i) {
        if (cz(list)) {
            if (w.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            reset();
            setVisibility(0);
            this.mjM.pp(i);
            this.mData = list;
            requestLayout();
        }
    }

    private boolean cz(List<p> list) {
        if (!w.isEmpty(list) && list.size() == this.mData.size()) {
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
        if (pVar.dil() == pVar2.dil() && pVar.dim() != null && pVar.dim().equals(pVar2.dim())) {
            return true;
        }
        return pVar.dil() == pVar2.dil() && pVar.dim() == null && pVar2.dim() == null;
    }

    public void reset() {
        this.mjM.pp(0);
        this.hKG = 0.0f;
        this.hKI = false;
        this.mData.clear();
        this.hKK.clear();
        this.hKJ = true;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.kcv = aVar;
    }

    public void onChangeSkinType() {
        if (this.mjN) {
            this.mBackgroundPaint.setColor(an.getColor(this.mBackgroundColorId));
            if (this.mjJ != null) {
                this.mjJ.setColor(com.baidu.tieba.tbadkCore.c.l(an.getColor(this.mBackgroundColorId), this.mjI));
            }
            invalidate();
        }
    }

    public void setCanScroll(boolean z) {
        this.hKH = z;
    }

    public int getState() {
        return this.mjM.bmP();
    }

    public void changeState(int i) {
        if (!w.isEmpty(this.mData) && !w.isEmpty(this.hKK)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mData.size()) {
                    if (this.mData.get(i3).dil() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.mjM.pp(i3);
                        this.hKG = this.hKK.get(i3).floatValue();
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
        this.mjP = bdUniqueId;
        if (this.mjO) {
            this.listener.setTag(this.mjP);
        }
    }
}
