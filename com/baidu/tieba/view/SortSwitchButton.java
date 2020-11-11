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
    private Paint bMx;
    private float htW;
    private float iSX;
    private int iSY;
    private int iSZ;
    private int iTa;
    private float iTb;
    private float iTc;
    private int iTd;
    private RectF iTg;
    private Path iTh;
    private RectF iTi;
    private Path iTj;
    private float iTl;
    private boolean iTm;
    private boolean iTn;
    private boolean iTo;
    private List<Float> iTp;
    private GestureDetector.SimpleOnGestureListener iTq;
    private float iTr;
    private boolean iTs;
    private CustomMessageListener listener;
    private a lqG;
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
    private int nBX;
    private float nBY;
    private float nBZ;
    private Paint nCa;
    private RectF nCb;
    private Path nCc;
    private RectF nCd;
    private Path nCe;
    private com.baidu.tieba.e nCf;
    private boolean nCg;
    private boolean nCh;
    private BdUniqueId nCi;
    private BdUniqueId nCj;
    private e.a nCk;

    /* loaded from: classes.dex */
    public interface a {
        boolean zw(int i);
    }

    public SortSwitchButton(Context context) {
        this(context, null);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nCf = new com.baidu.tieba.e();
        this.iTm = false;
        this.iTn = false;
        this.iTo = true;
        this.nCg = true;
        this.nCh = false;
        this.nCj = BdUniqueId.gen();
        this.listener = new CustomMessageListener(2921458) { // from class: com.baidu.tieba.view.SortSwitchButton.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage) && (((CustomMessage) customResponsedMessage.getOrginalMessage()).getData() instanceof BdUniqueId)) {
                    BdUniqueId bdUniqueId = (BdUniqueId) ((CustomMessage) customResponsedMessage.getOrginalMessage()).getData();
                    BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                    if (tag != null && bdUniqueId != null && SortSwitchButton.this.nCi != null) {
                        Integer num = (Integer) customResponsedMessage.getData();
                        if (tag.getId() == SortSwitchButton.this.nCi.getId() && bdUniqueId.getId() != SortSwitchButton.this.nCj.getId() && SortSwitchButton.this.nCf.bHW() != num.intValue() && !y.isEmpty(SortSwitchButton.this.mData) && !y.isEmpty(SortSwitchButton.this.iTp) && SortSwitchButton.this.iTp.size() > num.intValue()) {
                            SortSwitchButton.this.nCf.td(num.intValue());
                            SortSwitchButton.this.iTl = ((Float) SortSwitchButton.this.iTp.get(num.intValue())).floatValue();
                            SortSwitchButton.this.invalidate();
                        }
                    }
                }
            }
        };
        this.nCk = new e.a() { // from class: com.baidu.tieba.view.SortSwitchButton.2
            @Override // com.baidu.tieba.e.a
            public void bx(int i2, int i3) {
                ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i3));
                CustomMessage customMessage = new CustomMessage(2921458);
                customMessage.setTag(SortSwitchButton.this.nCi);
                customMessage.setData(SortSwitchButton.this.nCj);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        };
        this.iTq = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.view.SortSwitchButton.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!SortSwitchButton.this.iTn && motionEvent.getX() <= SortSwitchButton.this.mWidth && motionEvent.getY() <= SortSwitchButton.this.mHeight) {
                    if (SortSwitchButton.this.getParent() != null) {
                        SortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int bHW = SortSwitchButton.this.nCf.bHW();
                SortSwitchButton.this.iTl = motionEvent.getX();
                SortSwitchButton.this.nCf.tc(SortSwitchButton.this.cCn());
                SortSwitchButton.this.iTn = true;
                if (SortSwitchButton.this.nCf.bHW() != bHW) {
                    SortSwitchButton.this.zx(bHW);
                    if (SortSwitchButton.this.mValueAnimator != null) {
                        SortSwitchButton.this.mValueAnimator.start();
                    }
                    SortSwitchButton.this.zy(bHW);
                }
                SortSwitchButton.this.iTn = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (SortSwitchButton.this.iTm) {
                    SortSwitchButton.this.iTl -= f;
                    if (SortSwitchButton.this.iTl < 0.0f) {
                        SortSwitchButton.this.iTl = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(SortSwitchButton.this.iTp, SortSwitchButton.this.iTp.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (SortSwitchButton.this.iTl > floatValue) {
                        SortSwitchButton.this.iTl = floatValue;
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
        if (this.nCh) {
            this.nCf.a(this.nCk);
            MessageManager.getInstance().registerListener(this.listener);
        }
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SortSwitchButton);
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_color, R.color.cp_cont_j);
        this.nBX = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_border_color, this.mBackgroundColorId);
        this.nBY = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_background_border_width, 0.0f);
        this.nBZ = obtainStyledAttributes.getFloat(R.styleable.SortSwitchButton_background_border_alpha, 1.0f);
        this.iSY = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_color, R.color.cp_cont_a);
        this.iSZ = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_un_selected_text_color, R.color.cp_cont_b);
        this.iTa = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_selected_text_color, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_size, 5.0f);
        this.iTb = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_horizontal_padding, 0.0f);
        this.iSX = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_height, 0.0f);
        this.iTc = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_border_width, 0.0f);
        this.iTd = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_border_color, R.color.cp_cont_b);
        this.nCh = obtainStyledAttributes.getBoolean(R.styleable.SortSwitchButton_slide_need_sync, false);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.iTg = new RectF();
        this.iTh = new Path();
        this.iTi = new RectF();
        this.iTj = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        if (this.nBX > 0 && this.nBY > 0.0f) {
            this.nCb = new RectF();
            this.nCc = new Path();
            this.nCd = new RectF();
            this.nCe = new Path();
            this.nCa = new Paint(1);
            this.nCa.setStyle(Paint.Style.STROKE);
            this.nCa.setStrokeWidth(this.nBY);
            this.nCa.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(this.mBackgroundColorId), this.nBZ));
        }
        this.bMx = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.iTp = new ArrayList();
        this.nCf.td(0);
        this.mGestureDetector = new GestureDetector(context, this.iTq);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SortSwitchButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * SortSwitchButton.this.mMoveDistance;
                if (SortSwitchButton.this.iTs) {
                    SortSwitchButton.this.iTl = SortSwitchButton.this.iTr - floatValue;
                } else {
                    SortSwitchButton.this.iTl = floatValue + SortSwitchButton.this.iTr;
                }
                SortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.view.SortSwitchButton.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (SortSwitchButton.this.iTp.size() > SortSwitchButton.this.nCf.bHW()) {
                    SortSwitchButton.this.iTl = ((Float) SortSwitchButton.this.iTp.get(SortSwitchButton.this.nCf.bHW())).floatValue();
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
                    float measureText = this.mTextPaint.measureText(pVar.dKn() == null ? "" : pVar.dKn()) + (this.iTb * 2.0f);
                    if (this.iTo) {
                        this.iTp.add(Float.valueOf(this.mWidth));
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
                if (this.iTo) {
                    this.iTp.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.iSX;
        } else {
            this.mHeight = size2;
            this.iSX = this.mHeight;
        }
        this.iTo = false;
        zQ();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void zQ() {
        this.iTg.set(this.nBY, this.nBY, this.mWidth - this.nBY, this.mHeight - this.nBY);
        this.iTh.reset();
        this.iTh.addRoundRect(this.iTg, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        if (this.nCb != null && this.nCa != null) {
            this.nCb.set(0.0f, 0.0f, this.mWidth, this.mHeight);
            float f = this.nBY * 0.5f;
            this.nCd.set(-f, -f, this.mWidth + f, this.mHeight + f);
            this.nCc.reset();
            this.nCe.reset();
            this.nCc.addRoundRect(this.nCb, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
            this.nCe.addRoundRect(this.nCd, (this.mHeight + f) * 0.5f, (f + this.mHeight) * 0.5f, Path.Direction.CW);
        }
        Float f2 = (Float) y.getItem(this.iTp, this.nCf.bHW());
        this.iTl = f2 != null ? f2.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.htW = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.nCe != null) {
            canvas.clipPath(this.nCe);
        } else {
            canvas.clipPath(this.iTh);
        }
        super.onDraw(canvas);
        ap(canvas);
        R(canvas);
        int i = 0;
        while (i < this.mData.size() && i < this.iTp.size()) {
            a(canvas, this.mData.get(i).dKn(), this.iTp.get(i).floatValue() + this.iTb, this.htW, this.nCf.bHW() == i);
            i++;
        }
    }

    private void ap(Canvas canvas) {
        canvas.drawPath(this.iTh, this.mBackgroundPaint);
        if (this.nBX > 0 && this.nBY > 0.0f && this.nCa != null) {
            canvas.drawPath(this.nCc, this.nCa);
        }
    }

    private void R(Canvas canvas) {
        float f;
        this.iTj.reset();
        if (this.iTl < 0.0f) {
            this.iTl = 0.0f;
        }
        float floatValue = !y.isEmpty(this.iTp) ? ((Float) y.getItem(this.iTp, this.nCf.bHW())).floatValue() : 0.0f;
        if (this.nCf.bHW() + 1 < this.iTp.size()) {
            f = this.iTp.get(this.nCf.bHW() + 1).floatValue();
        } else {
            f = this.nCf.bHW() + 1 == this.iTp.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.iTl;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.iTi.set(this.iTl, 0.0f, f2, this.mHeight);
        this.iTj.addRoundRect(this.iTi, this.iSX / 2.0f, this.iSX / 2.0f, Path.Direction.CW);
        this.bMx.setColor(this.nCg ? ap.getColor(this.iTd) : ap.getColor(0, this.iTd));
        canvas.drawPath(this.iTj, this.bMx);
        this.iTj.reset();
        this.iTi.set(this.iTl + this.iTc, this.iTc, f2 - this.iTc, this.mHeight - this.iTc);
        this.iTj.addRoundRect(this.iTi, (this.iSX - (this.iTc * 2.0f)) / 2.0f, (this.iSX - (this.iTc * 2.0f)) / 2.0f, Path.Direction.CW);
        this.bMx.setColor(this.nCg ? ap.getColor(this.iSY) : ap.getColor(0, this.iSY));
        canvas.drawPath(this.iTj, this.bMx);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(this.nCg ? ap.getColor(this.iTa) : ap.getColor(0, this.iTa));
        } else {
            this.mTextPaint.setColor(this.nCg ? ap.getColor(this.iSZ) : ap.getColor(0, this.iSZ));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.iTm && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int bHW = this.nCf.bHW();
            int cCn = cCn();
            if (Math.abs(cCn - bHW) >= 2 || cCn > bHW) {
                this.nCf.td(cCn);
            } else if (cCn < bHW) {
                float floatValue = this.iTp.size() > cCn ? this.iTp.get(cCn).floatValue() : 0.0f;
                float floatValue2 = cCn + 1 < this.iTp.size() ? this.iTp.get(cCn + 1).floatValue() : floatValue;
                if (this.iTl >= floatValue && this.iTl <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.nCf.td(cCn);
                }
            } else {
                float floatValue3 = this.iTp.size() > cCn ? this.iTp.get(cCn).floatValue() : 0.0f;
                if (this.iTl >= (((cCn + 1 < this.iTp.size() ? this.iTp.get(cCn + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cCn + 1 < this.iTp.size()) {
                    this.nCf.td(cCn + 1);
                }
            }
            this.iTn = true;
            this.iTr = this.iTl;
            float floatValue4 = this.iTp.size() > this.nCf.bHW() ? this.iTp.get(this.nCf.bHW()).floatValue() : 0.0f;
            this.mMoveDistance = Math.abs(this.iTr - floatValue4);
            if (this.nCf.bHW() < bHW) {
                this.iTs = true;
            } else if (this.nCf.bHW() > bHW) {
                this.iTs = false;
            } else {
                this.iTs = this.iTr > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.nCf.bHW() != bHW) {
                zy(bHW);
            }
            this.iTn = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cCn() {
        float floatValue;
        int bHW = this.nCf.bHW();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.iTp.size()) {
                return bHW;
            }
            float floatValue2 = ((Float) y.getItem(this.iTp, i2)).floatValue();
            if (i2 + 1 == this.iTp.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) y.getItem(this.iTp, i2 + 1)).floatValue();
            }
            if (this.iTl <= floatValue2 || this.iTl >= floatValue) {
                if (this.iTl == floatValue2) {
                    if (bHW - 1 >= 0) {
                        return bHW - 1;
                    }
                } else if (this.iTl == floatValue && bHW + 1 < y.getCount(this.iTp)) {
                    return bHW + 1;
                }
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zx(int i) {
        if (this.iTp.size() > i) {
            this.iTr = this.iTp.get(i).floatValue();
        }
        float f = 0.0f;
        if (this.iTp.size() > this.nCf.bHW()) {
            f = this.iTp.get(this.nCf.bHW()).floatValue();
        }
        this.mMoveDistance = Math.abs(f - this.iTr);
        this.iTs = this.nCf.bHW() < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zy(int i) {
        if (this.lqG != null && !this.lqG.zw(this.nCf.bHW())) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.nCf.tc(i);
            if (this.iTp.size() > this.nCf.bHW()) {
                this.iTl = this.iTp.get(this.nCf.bHW()).floatValue();
            }
            invalidate();
        }
    }

    public void setNeedDayNight(boolean z) {
        this.nCg = z;
        if (!this.nCg) {
            this.mBackgroundPaint.setColor(ap.getColor(0, this.mBackgroundColorId));
            if (this.nCa != null) {
                this.nCa.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(0, this.nBX), this.nBZ));
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
        if (dg(list) || this.nCf == null || this.nCf.bHW() != i) {
            if (y.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            reset();
            setVisibility(0);
            this.nCf.tc(i);
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
        if (pVar.dKm() == pVar2.dKm() && pVar.dKn() != null && pVar.dKn().equals(pVar2.dKn())) {
            return true;
        }
        return pVar.dKm() == pVar2.dKm() && pVar.dKn() == null && pVar2.dKn() == null;
    }

    public void reset() {
        this.nCf.tc(0);
        this.iTl = 0.0f;
        this.iTn = false;
        this.mData.clear();
        this.iTp.clear();
        this.iTo = true;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.lqG = aVar;
    }

    public void onChangeSkinType() {
        if (this.nCg) {
            this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
            if (this.nCa != null) {
                this.nCa.setColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(this.mBackgroundColorId), this.nBZ));
            }
            invalidate();
        }
    }

    public void setCanScroll(boolean z) {
        this.iTm = z;
    }

    public int getState() {
        return this.nCf.bHW();
    }

    public void jP(int i) {
        if (!y.isEmpty(this.mData) && !y.isEmpty(this.iTp)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mData.size()) {
                    if (this.mData.get(i3).dKm() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.nCf.tc(i3);
                        if (this.iTp.size() > i3) {
                            this.iTl = this.iTp.get(i3).floatValue();
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
        this.nCi = bdUniqueId;
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.nCh) {
            this.listener.setTag(bdUniqueId);
        }
    }
}
