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
    private ViewGroup boD;
    private float bvU;
    private float cfs;
    private int dLD;
    private ImageView deF;
    private double eUF;
    private double eUG;
    private int eUH;
    private int eUI;
    private int eUJ;
    private int eUK;
    private a eUL;
    private b eUM;
    private int eUN;
    private boolean eUO;
    private boolean eUP;
    private boolean eUQ;
    private boolean eUR;
    private LinearLayout eUS;
    private LinearLayout eUT;
    private boolean eUU;
    private boolean eUV;
    private int eUW;
    private long eUX;
    private float eUv;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes.dex */
    public interface a {
        void b(EmotionImageData emotionImageData, boolean z);

        void cE(List<String> list);
    }

    /* loaded from: classes.dex */
    public interface b {
        void V(float f);
    }

    public c(Context context) {
        super(context);
        this.eUO = false;
        this.eUP = false;
        this.eUQ = false;
        this.eUR = false;
        this.eUU = false;
        init();
    }

    private void init() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        this.eUO = bVar.getBoolean("pb_emotion_bar_slide", true);
        this.eUQ = bVar.getBoolean("pb_emotion_bar_search", true);
        this.mScreenWidth = k.ae(getContext());
        this.cfs = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = k.f(getContext(), d.f.ds150);
        this.eUJ = k.f(getContext(), d.f.ds60);
        this.eUK = k.f(getContext(), d.f.ds126);
        this.dLD = k.f(getContext(), d.f.ds7);
        this.eUI = this.mScreenWidth - k.f(getContext(), d.f.ds130);
        setPadding(this.dLD, this.dLD * 2, 0, this.dLD * 2);
        aj.k(this, d.e.cp_bg_line_d);
    }

    private void pG(int i) {
        int i2 = (int) (this.eUG * (i - this.eUH));
        if (i2 <= 255 && i2 >= 0) {
            getBackground().setAlpha(i2);
            if (this.deF != null) {
                this.deF.getBackground().setAlpha(i2);
            }
        }
    }

    public void a(ViewGroup viewGroup, int i, com.baidu.tieba.pb.pb.main.emotion.a.a aVar, boolean z) {
        if (aVar != null && aVar.adX() != null && !aVar.adX().isEmpty()) {
            this.boD = viewGroup;
            this.eUW = i;
            this.mData = aVar;
            List<EmotionImageData> adX = aVar.adX();
            this.eUF = (this.eUJ - this.eUK) * (1.0d / this.eUI);
            setData(adX);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.eUI;
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
            this.eUN = i2;
            viewGroup.addView(this, this.eUN, layoutParams);
            if (!z) {
                setVisibility(8);
            }
            jS(true);
            aUw();
        }
    }

    public void setBottomMargin(int i) {
        FrameLayout.LayoutParams layoutParams;
        if (this.eUW != i) {
            this.eUW = i;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) getLayoutParams();
            if (layoutParams2 != null && layoutParams2.bottomMargin != i) {
                layoutParams2.bottomMargin = i;
                setLayoutParams(layoutParams2);
            }
            if (this.deF != null && (layoutParams = (FrameLayout.LayoutParams) this.deF.getLayoutParams()) != null && layoutParams.bottomMargin != i) {
                layoutParams.bottomMargin = i;
                this.deF.setLayoutParams(layoutParams);
            }
        }
    }

    private void aUw() {
        this.deF = new ImageView(getContext());
        aj.c(this.deF, d.g.icon_pb_emotion_search);
        this.deF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eUL != null) {
                    c.this.eUL.cE(c.this.mData.aUa());
                }
                TiebaStatic.log("c12177");
            }
        });
        aj.k(this.deF, d.e.cp_bg_line_d);
        this.deF.setTranslationX(this.eUK);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.eUJ, this.eUJ + (this.dLD * 4));
        layoutParams.leftMargin = this.dLD * 2;
        layoutParams.bottomMargin = this.eUW;
        layoutParams.gravity = 85;
        this.boD.addView(this.deF, this.eUN + 1, layoutParams);
    }

    private void setData(List<EmotionImageData> list) {
        for (final EmotionImageData emotionImageData : list) {
            EmotionView emotionView = new EmotionView(getContext());
            emotionView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (((FrameLayout.LayoutParams) c.this.getLayoutParams()).leftMargin <= 0) {
                        if (c.this.eUL != null && (view instanceof EmotionView)) {
                            c.this.eUL.b(emotionImageData, ((EmotionView) view).getIsGif());
                        }
                        TiebaStatic.log("c12176");
                    }
                }
            });
            emotionView.adY();
            e(emotionView, this.dLD);
            emotionView.a(emotionImageData);
        }
        this.eUH = this.mScreenWidth - Math.max(((list.size() + 1) * this.eUK) + ((list.size() + 4) * this.dLD), this.mScreenWidth);
        this.eUG = 255.0d * (1.0d / (this.eUH - this.eUI));
    }

    private void e(ImageView imageView, int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.eUJ, this.eUJ);
        layoutParams.leftMargin = i;
        layoutParams.gravity = 16;
        addView(imageView, layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        switch (motionEvent.getAction()) {
            case 0:
                this.eUX = System.currentTimeMillis();
                if (((FrameLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanChildShowPreview(false);
                }
                this.Fb = motionEvent.getRawX();
                this.bvU = motionEvent.getRawY();
                this.eUv = motionEvent.getRawX();
                jT(false);
                return false;
            case 1:
                if (layoutParams.leftMargin == this.eUI && t(motionEvent) && System.currentTimeMillis() - this.eUX < 300) {
                    jR(true);
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
                        jR(false);
                        break;
                    } else {
                        jR(true);
                        break;
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    jR(false);
                    break;
                } else {
                    jR(true);
                    break;
                }
                break;
            case 2:
                jS(false);
                setCanChildShowPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.eUv));
                if (rawX2 >= this.eUH && rawX2 <= this.eUI) {
                    layoutParams.leftMargin = rawX2;
                    int pH = pH(rawX2);
                    if (pH <= this.eUK && pH >= this.eUJ) {
                        pI(pH);
                        pG(rawX2);
                        pJ(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                }
                this.eUv = motionEvent.getRawX();
                k(motionEvent.getRawX(), motionEvent.getRawY());
                if (rawX2 <= this.eUH && this.eUH < 0) {
                    jT(true);
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
        return Math.abs(motionEvent.getRawX() - this.Fb) < this.cfs && Math.abs(motionEvent.getRawY() - this.bvU) < this.cfs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int pH(int i) {
        return (int) ((this.eUF * i) + this.eUK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pI(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i;
            childAt.setLayoutParams(layoutParams);
        }
        if (this.deF != null) {
            ViewGroup.LayoutParams layoutParams2 = this.deF.getLayoutParams();
            layoutParams2.width = i;
            layoutParams2.height = (this.dLD * 4) + i;
            this.deF.setLayoutParams(layoutParams2);
        }
    }

    public void aUx() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        setCanChildShowPreview(false);
        if (this.eUP) {
            jS(false);
        }
        if (this.eUR) {
            jT(false);
        }
        bp(layoutParams.leftMargin, this.eUI);
    }

    private void bp(int i, final int i2) {
        if (i != i2) {
            final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    c.this.pI(c.this.pH(layoutParams.leftMargin));
                    c.this.setLayoutParams(layoutParams);
                    c.this.pJ(layoutParams.leftMargin);
                }
            });
            ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (((FrameLayout.LayoutParams) c.this.getLayoutParams()).leftMargin <= 0) {
                        c.this.setCanChildShowPreview(true);
                    }
                    if (i2 == 0 && c.this.eUH == 0) {
                        c.this.jT(true);
                    }
                }
            });
            ofInt.setDuration(300L).start();
        }
    }

    public void jR(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin < 0) {
            setCanChildShowPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.eUI;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        bp(i, i2);
    }

    public void setOnEmotionClickListener(a aVar) {
        this.eUL = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pJ(int i) {
        if (this.eUM != null) {
            this.eUM.V((this.eUI - i) * (1.0f / this.eUI));
        }
        pK(i);
    }

    private void pK(int i) {
        if (this.deF != null) {
            float f = (1.0f - ((this.eUK - i) * (1.0f / this.eUK))) * this.eUK;
            if (f < 0.0f) {
                f = 0.0f;
            } else if (f > this.eUK) {
                f = this.eUK;
            }
            if (i <= this.eUK && !this.eUV) {
                this.deF.setTranslationX(f);
                if (f == 0.0f) {
                    this.eUV = true;
                }
            } else if (i <= this.eUK && this.eUV) {
                this.deF.setTranslationX(f);
                if (f == this.eUK) {
                    this.eUV = false;
                }
            } else if (i > this.eUK) {
                this.deF.setTranslationX(this.eUK);
                if (f == this.eUK) {
                    this.eUV = false;
                }
            }
        }
    }

    public void setOnMoveListener(b bVar) {
        this.eUM = bVar;
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

    private void jS(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                if (this.eUO) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_emotion_bar_slide", false);
                    this.eUO = false;
                    this.eUP = true;
                    if (this.eUS == null) {
                        this.eUS = new LinearLayout(getContext());
                        this.eUS.setBackgroundResource(d.g.icon_pb_emotion_bar_slide_tip);
                        this.eUS.setOrientation(1);
                        TextView textView = new TextView(getContext());
                        textView.setText(getContext().getText(d.l.pb_emotion_bar_slide_tip));
                        textView.setTextColor(getResources().getColor(d.e.cp_cont_g));
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 17;
                        layoutParams.topMargin = k.f(getContext(), d.f.ds10);
                        this.eUS.addView(textView, layoutParams);
                    }
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams2.rightMargin = this.eUJ / 3;
                    layoutParams2.bottomMargin = (int) (((FrameLayout.LayoutParams) getLayoutParams()).bottomMargin + (this.eUJ * 1.5d));
                    layoutParams2.gravity = 85;
                    this.boD.addView(this.eUS, this.eUN + 1, layoutParams2);
                }
            } else if (this.eUS != null && this.eUS.getVisibility() == 0 && this.eUP) {
                this.eUP = false;
                ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.5
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        c.this.eUS.setAlpha(floatValue);
                        if (floatValue == 0.0f) {
                            c.this.eUS.setVisibility(8);
                            if (c.this.eUS.getParent() != null && c.this.eUS.getParent() == c.this.boD) {
                                c.this.boD.removeView(c.this.eUS);
                            }
                        }
                    }
                });
                ofFloat.setDuration(300L).start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jT(boolean z) {
        if (getVisibility() == 0) {
            if (z) {
                if (this.deF != null && this.eUQ) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_emotion_bar_search", false);
                    this.eUQ = false;
                    this.eUR = true;
                    if (this.eUT == null) {
                        this.eUT = new LinearLayout(getContext());
                        this.eUT.setBackgroundResource(d.g.icon_pb_emotion_bar_search_tip);
                        this.eUT.setOrientation(1);
                        TextView textView = new TextView(getContext());
                        textView.setSingleLine(true);
                        textView.setText(getContext().getText(d.l.pb_emotion_bar_search_tip));
                        textView.setTextColor(getResources().getColor(d.e.cp_cont_g));
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 17;
                        layoutParams.topMargin = k.f(getContext(), d.f.ds10);
                        this.eUT.addView(textView, layoutParams);
                    }
                    int[] iArr = new int[2];
                    this.deF.getLocationOnScreen(iArr);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams2.leftMargin = iArr[0] - k.f(getContext(), d.f.ds350);
                    layoutParams2.bottomMargin = (int) (((FrameLayout.LayoutParams) getLayoutParams()).bottomMargin + (this.eUK * 1.2d));
                    layoutParams2.gravity = 80;
                    this.boD.addView(this.eUT, this.eUN + 1, layoutParams2);
                }
            } else if (this.eUT != null) {
                this.eUT.setVisibility(8);
                this.eUR = false;
                if (this.eUT.getParent() != null && this.eUT.getParent() == this.boD) {
                    this.boD.removeView(this.eUT);
                }
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.eUP && this.eUS != null) {
            this.eUS.setVisibility(i);
        }
        if (this.eUR && this.eUT != null) {
            this.eUT.setVisibility(i);
        }
        if (this.deF != null) {
            this.deF.setVisibility(i);
        }
    }
}
