package com.baidu.tieba.pb.pb.main.emotion.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes.dex */
public class c extends LinearLayout {
    private float Fb;
    private float bvg;
    private float ceA;
    private int dKI;
    private ViewGroup dKX;
    private ImageView ddJ;
    private float eTB;
    private double eTL;
    private double eTM;
    private int eTN;
    private int eTO;
    private int eTP;
    private int eTQ;
    private a eTR;
    private b eTS;
    private int eTT;
    private boolean eTU;
    private boolean eTV;
    private boolean eTW;
    private boolean eTX;
    private LinearLayout eTY;
    private LinearLayout eTZ;
    private boolean eUa;
    private boolean eUb;
    private int eUc;
    private long eUd;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes.dex */
    public interface a {
        void b(EmotionImageData emotionImageData, boolean z);

        void cD(List<String> list);
    }

    /* loaded from: classes.dex */
    public interface b {
        void V(float f);
    }

    public c(Context context) {
        super(context);
        this.eTU = false;
        this.eTV = false;
        this.eTW = false;
        this.eTX = false;
        this.eUa = false;
        init();
    }

    private void init() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        this.eTU = bVar.getBoolean("pb_emotion_bar_slide", true);
        this.eTW = bVar.getBoolean("pb_emotion_bar_search", true);
        this.mScreenWidth = k.ad(getContext());
        this.ceA = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = k.g(getContext(), d.f.ds150);
        this.eTP = k.g(getContext(), d.f.ds60);
        this.eTQ = k.g(getContext(), d.f.ds126);
        this.dKI = k.g(getContext(), d.f.ds7);
        this.eTO = this.mScreenWidth - k.g(getContext(), d.f.ds130);
        setPadding(this.dKI, this.dKI * 2, 0, this.dKI * 2);
        aj.k(this, d.e.cp_bg_line_d);
    }

    private void pE(int i) {
        int i2 = (int) (this.eTM * (i - this.eTN));
        if (i2 <= 255 && i2 >= 0) {
            getBackground().setAlpha(i2);
            if (this.ddJ != null) {
                this.ddJ.getBackground().setAlpha(i2);
            }
        }
    }

    public void a(ViewGroup viewGroup, int i, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.adM() != null && !aVar.adM().isEmpty()) {
            this.dKX = viewGroup;
            this.eUc = i;
            this.mData = aVar;
            List<EmotionImageData> adM = aVar.adM();
            this.eTL = (this.eTP - this.eTQ) * (1.0d / this.eTO);
            setData(adM);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.eTO;
            layoutParams.bottomMargin = i;
            layoutParams.gravity = 80;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                i2++;
                View childAt = viewGroup.getChildAt(i3);
                if (childAt != null && (childAt instanceof com.baidu.adp.widget.d)) {
                    break;
                }
            }
            this.eTT = i2;
            viewGroup.addView(this, this.eTT, layoutParams);
            if (!z) {
                setVisibility(8);
            }
            jR(true);
            aUl();
        }
    }

    public void setBottomMargin(int i) {
        FrameLayout.LayoutParams layoutParams;
        if (this.eUc != i) {
            this.eUc = i;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) getLayoutParams();
            if (layoutParams2 != null && layoutParams2.bottomMargin != i) {
                layoutParams2.bottomMargin = i;
                setLayoutParams(layoutParams2);
            }
            if (this.ddJ != null && (layoutParams = (FrameLayout.LayoutParams) this.ddJ.getLayoutParams()) != null && layoutParams.bottomMargin != i) {
                layoutParams.bottomMargin = i;
                this.ddJ.setLayoutParams(layoutParams);
            }
        }
    }

    private void aUl() {
        this.ddJ = new ImageView(getContext());
        aj.c(this.ddJ, d.g.icon_pb_emotion_search);
        this.ddJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eTR != null) {
                    c.this.eTR.cD(c.this.mData.aTP());
                }
                TiebaStatic.log("c12177");
            }
        });
        aj.k(this.ddJ, d.e.cp_bg_line_d);
        this.ddJ.setTranslationX(this.eTQ);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.eTP, this.eTP + (this.dKI * 4));
        layoutParams.leftMargin = this.dKI * 2;
        layoutParams.bottomMargin = this.eUc;
        layoutParams.gravity = 85;
        this.dKX.addView(this.ddJ, this.eTT + 1, layoutParams);
    }

    private void setData(List<EmotionImageData> list) {
        for (final EmotionImageData emotionImageData : list) {
            EmotionView emotionView = new EmotionView(getContext());
            emotionView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (((FrameLayout.LayoutParams) c.this.getLayoutParams()).leftMargin <= 0) {
                        if (c.this.eTR != null && (view instanceof EmotionView)) {
                            c.this.eTR.b(emotionImageData, ((EmotionView) view).getIsGif());
                        }
                        TiebaStatic.log("c12176");
                    }
                }
            });
            emotionView.adN();
            e(emotionView, this.dKI);
            emotionView.a(emotionImageData);
        }
        this.eTN = this.mScreenWidth - Math.max(((list.size() + 1) * this.eTQ) + ((list.size() + 4) * this.dKI), this.mScreenWidth);
        this.eTM = 255.0d * (1.0d / (this.eTN - this.eTO));
    }

    private void e(ImageView imageView, int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.eTP, this.eTP);
        layoutParams.leftMargin = i;
        layoutParams.gravity = 16;
        addView(imageView, layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        switch (motionEvent.getAction()) {
            case 0:
                this.eUd = System.currentTimeMillis();
                if (((FrameLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanChildShowPreview(false);
                }
                this.Fb = motionEvent.getRawX();
                this.bvg = motionEvent.getRawY();
                this.eTB = motionEvent.getRawX();
                jS(false);
                return false;
            case 1:
                if (layoutParams.leftMargin == this.eTO && t(motionEvent) && System.currentTimeMillis() - this.eUd < 300) {
                    jQ(true);
                }
                return false;
            case 2:
                return !t(motionEvent);
            default:
                return super.onInterceptTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCanChildShowPreview(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof EmotionView) {
                    ((EmotionView) getChildAt(i2)).setCanShowPreview(z);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void k(float f, float f2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof EmotionView) {
                    ((EmotionView) getChildAt(i2)).g(f, f2);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        switch (motionEvent.getAction()) {
            case 1:
                this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                float xVelocity = this.mVelocityTracker.getXVelocity();
                int rawX = (int) (motionEvent.getRawX() - this.Fb);
                if (Math.abs(xVelocity) > this.mMinimumVelocity && Math.abs(rawX) > this.mFlingDistance) {
                    if (rawX > 0) {
                        jQ(false);
                        break;
                    } else {
                        jQ(true);
                        break;
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    jQ(false);
                    break;
                } else {
                    jQ(true);
                    break;
                }
                break;
            case 2:
                jR(false);
                setCanChildShowPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.eTB));
                if (rawX2 >= this.eTN && rawX2 <= this.eTO) {
                    layoutParams.leftMargin = rawX2;
                    int pF = pF(rawX2);
                    if (pF <= this.eTQ && pF >= this.eTP) {
                        pG(pF);
                        pE(rawX2);
                        pH(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                }
                this.eTB = motionEvent.getRawX();
                k(motionEvent.getRawX(), motionEvent.getRawY());
                if (rawX2 <= this.eTN && this.eTN < 0) {
                    jS(true);
                    break;
                }
                break;
            case 3:
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.clear();
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    break;
                }
                break;
        }
        return true;
    }

    private boolean t(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.Fb) < this.ceA && Math.abs(motionEvent.getRawY() - this.bvg) < this.ceA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int pF(int i) {
        return (int) ((this.eTL * i) + this.eTQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pG(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i;
            childAt.setLayoutParams(layoutParams);
        }
        if (this.ddJ != null) {
            ViewGroup.LayoutParams layoutParams2 = this.ddJ.getLayoutParams();
            layoutParams2.width = i;
            layoutParams2.height = (this.dKI * 4) + i;
            this.ddJ.setLayoutParams(layoutParams2);
        }
    }

    public void aUm() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        setCanChildShowPreview(false);
        if (this.eTV) {
            jR(false);
        }
        if (this.eTX) {
            jS(false);
        }
        bl(layoutParams.leftMargin, this.eTO);
    }

    private void bl(int i, final int i2) {
        if (i != i2) {
            final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    c.this.pG(c.this.pF(layoutParams.leftMargin));
                    c.this.setLayoutParams(layoutParams);
                    c.this.pH(layoutParams.leftMargin);
                }
            });
            ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (((FrameLayout.LayoutParams) c.this.getLayoutParams()).leftMargin <= 0) {
                        c.this.setCanChildShowPreview(true);
                    }
                    if (i2 == 0 && c.this.eTN == 0) {
                        c.this.jS(true);
                    }
                }
            });
            ofInt.setDuration(300L).start();
        }
    }

    public void jQ(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin < 0) {
            setCanChildShowPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.eTO;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        bl(i, i2);
    }

    public void setOnEmotionClickListener(a aVar) {
        this.eTR = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pH(int i) {
        if (this.eTS != null) {
            this.eTS.V((this.eTO - i) * (1.0f / this.eTO));
        }
        pI(i);
    }

    private void pI(int i) {
        if (this.ddJ != null) {
            float f = (1.0f - ((this.eTQ - i) * (1.0f / this.eTQ))) * this.eTQ;
            if (f < 0.0f) {
                f = 0.0f;
            } else if (f > this.eTQ) {
                f = this.eTQ;
            }
            if (i <= this.eTQ && !this.eUb) {
                this.ddJ.setTranslationX(f);
                if (f == 0.0f) {
                    this.eUb = true;
                }
            } else if (i <= this.eTQ && this.eUb) {
                this.ddJ.setTranslationX(f);
                if (f == this.eTQ) {
                    this.eUb = false;
                }
            } else if (i > this.eTQ) {
                this.ddJ.setTranslationX(this.eTQ);
                if (f == this.eTQ) {
                    this.eUb = false;
                }
            }
        }
    }

    public void setOnMoveListener(b bVar) {
        this.eTS = bVar;
    }

    public void onResume() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof EmotionView)) {
                    ((EmotionView) childAt).refresh();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void jR(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                if (this.eTU) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_emotion_bar_slide", false);
                    this.eTU = false;
                    this.eTV = true;
                    if (this.eTY == null) {
                        this.eTY = new LinearLayout(getContext());
                        this.eTY.setBackgroundResource(d.g.icon_pb_emotion_bar_slide_tip);
                        this.eTY.setOrientation(1);
                        TextView textView = new TextView(getContext());
                        textView.setText(getContext().getText(d.l.pb_emotion_bar_slide_tip));
                        textView.setTextColor(getResources().getColor(d.e.cp_cont_g));
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 17;
                        layoutParams.topMargin = k.g(getContext(), d.f.ds10);
                        this.eTY.addView(textView, layoutParams);
                    }
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams2.rightMargin = this.eTP / 3;
                    layoutParams2.bottomMargin = (int) (((FrameLayout.LayoutParams) getLayoutParams()).bottomMargin + (this.eTP * 1.5d));
                    layoutParams2.gravity = 85;
                    this.dKX.addView(this.eTY, this.eTT + 1, layoutParams2);
                }
            } else if (this.eTY != null && this.eTY.getVisibility() == 0 && this.eTV) {
                this.eTV = false;
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.5
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        c.this.eTY.setAlpha(floatValue);
                        if (floatValue == 0.0f) {
                            c.this.eTY.setVisibility(8);
                            if (c.this.eTY.getParent() != null && c.this.eTY.getParent() == c.this.dKX) {
                                c.this.dKX.removeView(c.this.eTY);
                            }
                        }
                    }
                });
                ofFloat.setDuration(300L).start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jS(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                if (this.ddJ != null && this.eTW) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_emotion_bar_search", false);
                    this.eTW = false;
                    this.eTX = true;
                    if (this.eTZ == null) {
                        this.eTZ = new LinearLayout(getContext());
                        this.eTZ.setBackgroundResource(d.g.icon_pb_emotion_bar_search_tip);
                        this.eTZ.setOrientation(1);
                        TextView textView = new TextView(getContext());
                        textView.setSingleLine(true);
                        textView.setText(getContext().getText(d.l.pb_emotion_bar_search_tip));
                        textView.setTextColor(getResources().getColor(d.e.cp_cont_g));
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 17;
                        layoutParams.topMargin = k.g(getContext(), d.f.ds10);
                        this.eTZ.addView(textView, layoutParams);
                    }
                    int[] iArr = new int[2];
                    this.ddJ.getLocationOnScreen(iArr);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams2.leftMargin = iArr[0] - k.g(getContext(), d.f.ds350);
                    layoutParams2.bottomMargin = (int) (((FrameLayout.LayoutParams) getLayoutParams()).bottomMargin + (this.eTQ * 1.2d));
                    layoutParams2.gravity = 80;
                    this.dKX.addView(this.eTZ, this.eTT + 1, layoutParams2);
                }
            } else if (this.eTZ != null) {
                this.eTZ.setVisibility(8);
                this.eTX = false;
                if (this.eTZ.getParent() != null && this.eTZ.getParent() == this.dKX) {
                    this.dKX.removeView(this.eTZ);
                }
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.eTV && this.eTY != null) {
            this.eTY.setVisibility(i);
        }
        if (this.eTX && this.eTZ != null) {
            this.eTZ.setVisibility(i);
        }
        if (this.ddJ != null) {
            this.ddJ.setVisibility(i);
        }
    }
}
