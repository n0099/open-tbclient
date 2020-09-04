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
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SortSwitchButton extends View implements View.OnTouchListener {
    private Paint bua;
    private float gJV;
    private float ieJ;
    private int ieK;
    private int ieL;
    private int ieM;
    private float ieN;
    private float ieO;
    private int ieP;
    private RectF ieS;
    private Path ieT;
    private RectF ieU;
    private Path ieV;
    private float ieX;
    private boolean ieY;
    private boolean ieZ;
    private boolean ifa;
    private List<Float> ifb;
    private GestureDetector.SimpleOnGestureListener ifc;
    private float ifd;
    private boolean ife;
    private a kAy;
    private CustomMessageListener listener;
    private int mBackgroundColorId;
    private Paint mBackgroundPaint;
    private List<p> mData;
    private GestureDetector mGestureDetector;
    private float mHeight;
    private int mKm;
    private float mKn;
    private float mKo;
    private Paint mKp;
    private RectF mKq;
    private Path mKr;
    private RectF mKs;
    private Path mKt;
    private com.baidu.tieba.d mKu;
    private boolean mKv;
    private boolean mKw;
    private BdUniqueId mKx;
    private BdUniqueId mKy;
    private d.a mKz;
    private float mMoveDistance;
    private Paint mTextPaint;
    private float mTextSize;
    private ValueAnimator mValueAnimator;
    private float mWidth;

    /* loaded from: classes.dex */
    public interface a {
        boolean xL(int i);
    }

    public SortSwitchButton(Context context) {
        this(context, null);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mKu = new com.baidu.tieba.d();
        this.ieY = false;
        this.ieZ = false;
        this.ifa = true;
        this.mKv = true;
        this.mKw = false;
        this.mKy = BdUniqueId.gen();
        this.listener = new CustomMessageListener(2921458) { // from class: com.baidu.tieba.view.SortSwitchButton.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && (customResponsedMessage.getOrginalMessage() instanceof CustomMessage) && (((CustomMessage) customResponsedMessage.getOrginalMessage()).getData() instanceof BdUniqueId)) {
                    BdUniqueId bdUniqueId = (BdUniqueId) ((CustomMessage) customResponsedMessage.getOrginalMessage()).getData();
                    BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                    if (tag != null && bdUniqueId != null && SortSwitchButton.this.mKx != null) {
                        Integer num = (Integer) customResponsedMessage.getData();
                        if (tag.getId() == SortSwitchButton.this.mKx.getId() && bdUniqueId.getId() != SortSwitchButton.this.mKy.getId() && SortSwitchButton.this.mKu.bzJ() != num.intValue() && !y.isEmpty(SortSwitchButton.this.mData) && !y.isEmpty(SortSwitchButton.this.ifb) && SortSwitchButton.this.ifb.size() > num.intValue()) {
                            SortSwitchButton.this.mKu.rT(num.intValue());
                            SortSwitchButton.this.ieX = ((Float) SortSwitchButton.this.ifb.get(num.intValue())).floatValue();
                            SortSwitchButton.this.invalidate();
                        }
                    }
                }
            }
        };
        this.mKz = new d.a() { // from class: com.baidu.tieba.view.SortSwitchButton.2
            @Override // com.baidu.tieba.d.a
            public void bx(int i2, int i3) {
                ResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921458, Integer.valueOf(i3));
                CustomMessage customMessage = new CustomMessage(2921458);
                customMessage.setTag(SortSwitchButton.this.mKx);
                customMessage.setData(SortSwitchButton.this.mKy);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        };
        this.ifc = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.view.SortSwitchButton.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!SortSwitchButton.this.ieZ && motionEvent.getX() <= SortSwitchButton.this.mWidth && motionEvent.getY() <= SortSwitchButton.this.mHeight) {
                    if (SortSwitchButton.this.getParent() != null) {
                        SortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int bzJ = SortSwitchButton.this.mKu.bzJ();
                SortSwitchButton.this.ieX = motionEvent.getX();
                SortSwitchButton.this.mKu.rS(SortSwitchButton.this.cpV());
                SortSwitchButton.this.ieZ = true;
                if (SortSwitchButton.this.mKu.bzJ() != bzJ) {
                    SortSwitchButton.this.xM(bzJ);
                    if (SortSwitchButton.this.mValueAnimator != null) {
                        SortSwitchButton.this.mValueAnimator.start();
                    }
                    SortSwitchButton.this.xN(bzJ);
                }
                SortSwitchButton.this.ieZ = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (SortSwitchButton.this.ieY) {
                    SortSwitchButton.this.ieX -= f;
                    if (SortSwitchButton.this.ieX < 0.0f) {
                        SortSwitchButton.this.ieX = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(SortSwitchButton.this.ifb, SortSwitchButton.this.ifb.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (SortSwitchButton.this.ieX > floatValue) {
                        SortSwitchButton.this.ieX = floatValue;
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
        if (this.mKw) {
            this.mKu.a(this.mKz);
            MessageManager.getInstance().registerListener(this.listener);
        }
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SortSwitchButton);
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_color, R.color.cp_cont_j);
        this.mKm = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_background_border_color, this.mBackgroundColorId);
        this.mKn = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_background_border_width, 0.0f);
        this.mKo = obtainStyledAttributes.getFloat(R.styleable.SortSwitchButton_background_border_alpha, 1.0f);
        this.ieK = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_color, R.color.cp_cont_a);
        this.ieL = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_un_selected_text_color, R.color.cp_cont_b);
        this.ieM = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_selected_text_color, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_size, 5.0f);
        this.ieN = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_text_horizontal_padding, 0.0f);
        this.ieJ = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_height, 0.0f);
        this.ieO = obtainStyledAttributes.getDimension(R.styleable.SortSwitchButton_slide_border_width, 0.0f);
        this.ieP = obtainStyledAttributes.getResourceId(R.styleable.SortSwitchButton_slide_border_color, R.color.cp_cont_b);
        this.mKw = obtainStyledAttributes.getBoolean(R.styleable.SortSwitchButton_slide_need_sync, false);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.ieS = new RectF();
        this.ieT = new Path();
        this.ieU = new RectF();
        this.ieV = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        if (this.mKm > 0 && this.mKn > 0.0f) {
            this.mKq = new RectF();
            this.mKr = new Path();
            this.mKs = new RectF();
            this.mKt = new Path();
            this.mKp = new Paint(1);
            this.mKp.setStyle(Paint.Style.STROKE);
            this.mKp.setStrokeWidth(this.mKn);
            this.mKp.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(this.mBackgroundColorId), this.mKo));
        }
        this.bua = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.ifb = new ArrayList();
        this.mKu.rT(0);
        this.mGestureDetector = new GestureDetector(context, this.ifc);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.view.SortSwitchButton.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * SortSwitchButton.this.mMoveDistance;
                if (SortSwitchButton.this.ife) {
                    SortSwitchButton.this.ieX = SortSwitchButton.this.ifd - floatValue;
                } else {
                    SortSwitchButton.this.ieX = floatValue + SortSwitchButton.this.ifd;
                }
                SortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.view.SortSwitchButton.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (SortSwitchButton.this.ifb.size() > SortSwitchButton.this.mKu.bzJ()) {
                    SortSwitchButton.this.ieX = ((Float) SortSwitchButton.this.ifb.get(SortSwitchButton.this.mKu.bzJ())).floatValue();
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
                    float measureText = this.mTextPaint.measureText(pVar.dwY() == null ? "" : pVar.dwY()) + (this.ieN * 2.0f);
                    if (this.ifa) {
                        this.ifb.add(Float.valueOf(this.mWidth));
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
                if (this.ifa) {
                    this.ifb.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.ieJ;
        } else {
            this.mHeight = size2;
            this.ieJ = this.mHeight;
        }
        this.ifa = false;
        zu();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void zu() {
        this.ieS.set(this.mKn, this.mKn, this.mWidth - this.mKn, this.mHeight - this.mKn);
        this.ieT.reset();
        this.ieT.addRoundRect(this.ieS, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        if (this.mKq != null && this.mKp != null) {
            this.mKq.set(0.0f, 0.0f, this.mWidth, this.mHeight);
            float f = this.mKn * 0.5f;
            this.mKs.set(-f, -f, this.mWidth + f, this.mHeight + f);
            this.mKr.reset();
            this.mKt.reset();
            this.mKr.addRoundRect(this.mKq, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
            this.mKt.addRoundRect(this.mKs, (this.mHeight + f) * 0.5f, (f + this.mHeight) * 0.5f, Path.Direction.CW);
        }
        Float f2 = (Float) y.getItem(this.ifb, this.mKu.bzJ());
        this.ieX = f2 != null ? f2.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.gJV = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mKt != null) {
            canvas.clipPath(this.mKt);
        } else {
            canvas.clipPath(this.ieT);
        }
        super.onDraw(canvas);
        ao(canvas);
        Q(canvas);
        int i = 0;
        while (i < this.mData.size() && i < this.ifb.size()) {
            a(canvas, this.mData.get(i).dwY(), this.ifb.get(i).floatValue() + this.ieN, this.gJV, this.mKu.bzJ() == i);
            i++;
        }
    }

    private void ao(Canvas canvas) {
        canvas.drawPath(this.ieT, this.mBackgroundPaint);
        if (this.mKm > 0 && this.mKn > 0.0f && this.mKp != null) {
            canvas.drawPath(this.mKr, this.mKp);
        }
    }

    private void Q(Canvas canvas) {
        float f;
        this.ieV.reset();
        if (this.ieX < 0.0f) {
            this.ieX = 0.0f;
        }
        float floatValue = !y.isEmpty(this.ifb) ? ((Float) y.getItem(this.ifb, this.mKu.bzJ())).floatValue() : 0.0f;
        if (this.mKu.bzJ() + 1 < this.ifb.size()) {
            f = this.ifb.get(this.mKu.bzJ() + 1).floatValue();
        } else {
            f = this.mKu.bzJ() + 1 == this.ifb.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.ieX;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.ieU.set(this.ieX, 0.0f, f2, this.mHeight);
        this.ieV.addRoundRect(this.ieU, this.ieJ / 2.0f, this.ieJ / 2.0f, Path.Direction.CW);
        this.bua.setColor(this.mKv ? ap.getColor(this.ieP) : ap.getColor(0, this.ieP));
        canvas.drawPath(this.ieV, this.bua);
        this.ieV.reset();
        this.ieU.set(this.ieX + this.ieO, this.ieO, f2 - this.ieO, this.mHeight - this.ieO);
        this.ieV.addRoundRect(this.ieU, (this.ieJ - (this.ieO * 2.0f)) / 2.0f, (this.ieJ - (this.ieO * 2.0f)) / 2.0f, Path.Direction.CW);
        this.bua.setColor(this.mKv ? ap.getColor(this.ieK) : ap.getColor(0, this.ieK));
        canvas.drawPath(this.ieV, this.bua);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(this.mKv ? ap.getColor(this.ieM) : ap.getColor(0, this.ieM));
        } else {
            this.mTextPaint.setColor(this.mKv ? ap.getColor(this.ieL) : ap.getColor(0, this.ieL));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.ieY && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int bzJ = this.mKu.bzJ();
            int cpV = cpV();
            if (Math.abs(cpV - bzJ) >= 2 || cpV > bzJ) {
                this.mKu.rT(cpV);
            } else if (cpV < bzJ) {
                float floatValue = this.ifb.size() > cpV ? this.ifb.get(cpV).floatValue() : 0.0f;
                float floatValue2 = cpV + 1 < this.ifb.size() ? this.ifb.get(cpV + 1).floatValue() : floatValue;
                if (this.ieX >= floatValue && this.ieX <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.mKu.rT(cpV);
                }
            } else {
                float floatValue3 = this.ifb.size() > cpV ? this.ifb.get(cpV).floatValue() : 0.0f;
                if (this.ieX >= (((cpV + 1 < this.ifb.size() ? this.ifb.get(cpV + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cpV + 1 < this.ifb.size()) {
                    this.mKu.rT(cpV + 1);
                }
            }
            this.ieZ = true;
            this.ifd = this.ieX;
            float floatValue4 = this.ifb.size() > this.mKu.bzJ() ? this.ifb.get(this.mKu.bzJ()).floatValue() : 0.0f;
            this.mMoveDistance = Math.abs(this.ifd - floatValue4);
            if (this.mKu.bzJ() < bzJ) {
                this.ife = true;
            } else if (this.mKu.bzJ() > bzJ) {
                this.ife = false;
            } else {
                this.ife = this.ifd > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.mKu.bzJ() != bzJ) {
                xN(bzJ);
            }
            this.ieZ = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cpV() {
        float floatValue;
        int bzJ = this.mKu.bzJ();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.ifb.size()) {
                return bzJ;
            }
            float floatValue2 = ((Float) y.getItem(this.ifb, i2)).floatValue();
            if (i2 + 1 == this.ifb.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) y.getItem(this.ifb, i2 + 1)).floatValue();
            }
            if (this.ieX <= floatValue2 || this.ieX >= floatValue) {
                if (this.ieX == floatValue2) {
                    if (bzJ - 1 >= 0) {
                        return bzJ - 1;
                    }
                } else if (this.ieX == floatValue && bzJ + 1 < y.getCount(this.ifb)) {
                    return bzJ + 1;
                }
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xM(int i) {
        if (this.ifb.size() > i) {
            this.ifd = this.ifb.get(i).floatValue();
        }
        float f = 0.0f;
        if (this.ifb.size() > this.mKu.bzJ()) {
            f = this.ifb.get(this.mKu.bzJ()).floatValue();
        }
        this.mMoveDistance = Math.abs(f - this.ifd);
        this.ife = this.mKu.bzJ() < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xN(int i) {
        if (this.kAy != null && !this.kAy.xL(this.mKu.bzJ())) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.mKu.rS(i);
            if (this.ifb.size() > this.mKu.bzJ()) {
                this.ieX = this.ifb.get(this.mKu.bzJ()).floatValue();
            }
            invalidate();
        }
    }

    public void setNeedDayNight(boolean z) {
        this.mKv = z;
        if (!this.mKv) {
            this.mBackgroundPaint.setColor(ap.getColor(0, this.mBackgroundColorId));
            if (this.mKp != null) {
                this.mKp.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(0, this.mKm), this.mKo));
            }
        }
    }

    public void setData(List<p> list) {
        if (cG(list)) {
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
        if (cG(list) || this.mKu == null || this.mKu.bzJ() != i) {
            if (y.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            reset();
            setVisibility(0);
            this.mKu.rS(i);
            this.mData = list;
            requestLayout();
        }
    }

    private boolean cG(List<p> list) {
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
        if (pVar.dwX() == pVar2.dwX() && pVar.dwY() != null && pVar.dwY().equals(pVar2.dwY())) {
            return true;
        }
        return pVar.dwX() == pVar2.dwX() && pVar.dwY() == null && pVar2.dwY() == null;
    }

    public void reset() {
        this.mKu.rS(0);
        this.ieX = 0.0f;
        this.ieZ = false;
        this.mData.clear();
        this.ifb.clear();
        this.ifa = true;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.kAy = aVar;
    }

    public void onChangeSkinType() {
        if (this.mKv) {
            this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
            if (this.mKp != null) {
                this.mKp.setColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(this.mBackgroundColorId), this.mKo));
            }
            invalidate();
        }
    }

    public void setCanScroll(boolean z) {
        this.ieY = z;
    }

    public int getState() {
        return this.mKu.bzJ();
    }

    public void changeState(int i) {
        if (!y.isEmpty(this.mData) && !y.isEmpty(this.ifb)) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mData.size()) {
                    if (this.mData.get(i3).dwX() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.mKu.rS(i3);
                        if (this.ifb.size() > i3) {
                            this.ieX = this.ifb.get(i3).floatValue();
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
        this.mKx = bdUniqueId;
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.mKw) {
            this.listener.setTag(bdUniqueId);
        }
    }
}
