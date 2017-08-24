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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes.dex */
public class c extends LinearLayout {
    private float Hh;
    private float buu;
    private ImageView cXc;
    private float cbJ;
    private int dEe;
    private ViewGroup dEt;
    private boolean eVA;
    private int eVB;
    private long eVC;
    private float eVa;
    private double eVk;
    private double eVl;
    private int eVm;
    private int eVn;
    private int eVo;
    private int eVp;
    private a eVq;
    private b eVr;
    private int eVs;
    private boolean eVt;
    private boolean eVu;
    private boolean eVv;
    private boolean eVw;
    private LinearLayout eVx;
    private LinearLayout eVy;
    private boolean eVz;
    private com.baidu.tieba.pb.pb.main.emotion.a.a mData;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes.dex */
    public interface a {
        void b(EmotionImageData emotionImageData, boolean z);

        void cG(List<String> list);
    }

    /* loaded from: classes.dex */
    public interface b {
        void ag(float f);
    }

    public c(Context context) {
        super(context);
        this.eVt = false;
        this.eVu = false;
        this.eVv = false;
        this.eVw = false;
        this.eVz = false;
        init();
    }

    private void init() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        this.eVt = bVar.getBoolean("pb_emotion_bar_slide", true);
        this.eVv = bVar.getBoolean("pb_emotion_bar_search", true);
        this.mScreenWidth = k.ag(getContext());
        this.cbJ = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = k.g(getContext(), d.f.ds150);
        this.eVo = k.g(getContext(), d.f.ds60);
        this.eVp = k.g(getContext(), d.f.ds116);
        this.dEe = k.g(getContext(), d.f.ds10);
        this.eVn = this.mScreenWidth - k.g(getContext(), d.f.ds130);
        setPadding(this.dEe, this.dEe * 2, this.dEe, this.dEe * 2);
        ai.k(this, d.e.cp_bg_line_d);
    }

    private void pA(int i) {
        int i2 = (int) (this.eVl * (i - this.eVm));
        if (i2 <= 255 && i2 >= 0) {
            getBackground().setAlpha(i2);
            if (this.cXc != null) {
                this.cXc.getBackground().setAlpha(i2);
            }
        }
    }

    public void a(ViewGroup viewGroup, int i, com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
        if (aVar != null && aVar.acO() != null && !aVar.acO().isEmpty()) {
            this.dEt = viewGroup;
            this.eVB = i;
            this.mData = aVar;
            List<EmotionImageData> acO = aVar.acO();
            this.eVk = (this.eVo - this.eVp) * (1.0d / this.eVn);
            setData(acO);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.eVn;
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
            this.eVs = i2;
            viewGroup.addView(this, this.eVs, layoutParams);
            jS(true);
            aVa();
        }
    }

    public void setBottomMargin(int i) {
        FrameLayout.LayoutParams layoutParams;
        if (this.eVB != i) {
            this.eVB = i;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) getLayoutParams();
            if (layoutParams2 != null && layoutParams2.bottomMargin != i) {
                layoutParams2.bottomMargin = i;
                setLayoutParams(layoutParams2);
            }
            if (this.cXc != null && (layoutParams = (FrameLayout.LayoutParams) this.cXc.getLayoutParams()) != null && layoutParams.bottomMargin != i) {
                layoutParams.bottomMargin = i;
                this.cXc.setLayoutParams(layoutParams);
            }
        }
    }

    private void aVa() {
        this.cXc = new ImageView(getContext());
        ai.c(this.cXc, d.g.icon_pb_emotion_search);
        this.cXc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eVq != null) {
                    c.this.eVq.cG(c.this.mData.aUE());
                }
                TiebaStatic.log("c12177");
            }
        });
        ai.k(this.cXc, d.e.cp_bg_line_d);
        this.cXc.setTranslationX(this.eVp);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.eVo, this.eVo + (this.dEe * 4));
        layoutParams.leftMargin = this.dEe * 2;
        layoutParams.bottomMargin = this.eVB;
        layoutParams.gravity = 85;
        this.dEt.addView(this.cXc, this.eVs + 1, layoutParams);
    }

    private void setData(List<EmotionImageData> list) {
        for (final EmotionImageData emotionImageData : list) {
            EmotionView emotionView = new EmotionView(getContext());
            emotionView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (((FrameLayout.LayoutParams) c.this.getLayoutParams()).leftMargin <= 0) {
                        if (c.this.eVq != null && (view instanceof EmotionView)) {
                            c.this.eVq.b(emotionImageData, ((EmotionView) view).getIsGif());
                        }
                        TiebaStatic.log("c12176");
                    }
                }
            });
            emotionView.acP();
            e(emotionView, this.dEe);
            emotionView.a(emotionImageData);
        }
        this.eVm = this.mScreenWidth - Math.max(((list.size() + 1) * this.eVp) + ((list.size() + 4) * this.dEe), this.mScreenWidth);
        this.eVl = 255.0d * (1.0d / (this.eVm - this.eVn));
    }

    private void e(ImageView imageView, int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.eVo, this.eVo);
        layoutParams.leftMargin = i;
        layoutParams.gravity = 16;
        addView(imageView, layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        switch (motionEvent.getAction()) {
            case 0:
                this.eVC = System.currentTimeMillis();
                if (((FrameLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanChildShowPreview(false);
                }
                this.Hh = motionEvent.getRawX();
                this.buu = motionEvent.getRawY();
                this.eVa = motionEvent.getRawX();
                jT(false);
                return false;
            case 1:
                if (layoutParams.leftMargin == this.eVn && t(motionEvent) && System.currentTimeMillis() - this.eVC < 300) {
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

    private void l(float f, float f2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof EmotionView) {
                    ((EmotionView) getChildAt(i2)).h(f, f2);
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
                int rawX = (int) (motionEvent.getRawX() - this.Hh);
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
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.eVa));
                if (rawX2 >= this.eVm && rawX2 <= this.eVn) {
                    layoutParams.leftMargin = rawX2;
                    int pB = pB(rawX2);
                    if (pB <= this.eVp && pB >= this.eVo) {
                        pC(pB);
                        pA(rawX2);
                        pD(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                }
                this.eVa = motionEvent.getRawX();
                l(motionEvent.getRawX(), motionEvent.getRawY());
                if (rawX2 <= this.eVm && this.eVm < 0) {
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
        return Math.abs(motionEvent.getRawX() - this.Hh) < this.cbJ && Math.abs(motionEvent.getRawY() - this.buu) < this.cbJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int pB(int i) {
        return (int) ((this.eVk * i) + this.eVp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pC(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i;
            childAt.setLayoutParams(layoutParams);
        }
        if (this.cXc != null) {
            ViewGroup.LayoutParams layoutParams2 = this.cXc.getLayoutParams();
            layoutParams2.width = i;
            layoutParams2.height = (this.dEe * 4) + i;
            this.cXc.setLayoutParams(layoutParams2);
        }
    }

    public void aVb() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        setCanChildShowPreview(false);
        if (this.eVu) {
            jS(false);
        }
        if (this.eVw) {
            jT(false);
        }
        bm(layoutParams.leftMargin, this.eVn);
    }

    private void bm(int i, final int i2) {
        if (i != i2) {
            final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    c.this.pC(c.this.pB(layoutParams.leftMargin));
                    c.this.setLayoutParams(layoutParams);
                    c.this.pD(layoutParams.leftMargin);
                }
            });
            ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (((FrameLayout.LayoutParams) c.this.getLayoutParams()).leftMargin <= 0) {
                        c.this.setCanChildShowPreview(true);
                    }
                    if (i2 == 0 && c.this.eVm == 0) {
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
        int i2 = this.eVn;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        bm(i, i2);
    }

    public void setOnEmotionClickListener(a aVar) {
        this.eVq = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pD(int i) {
        if (this.eVr != null) {
            this.eVr.ag((this.eVn - i) * (1.0f / this.eVn));
        }
        pE(i);
    }

    private void pE(int i) {
        if (this.cXc != null) {
            float f = (1.0f - ((this.eVp - i) * (1.0f / this.eVp))) * this.eVp;
            if (f < 0.0f) {
                f = 0.0f;
            } else if (f > this.eVp) {
                f = this.eVp;
            }
            if (i <= this.eVp && !this.eVA) {
                this.cXc.setTranslationX(f);
                if (f == 0.0f) {
                    this.eVA = true;
                }
            } else if (i <= this.eVp && this.eVA) {
                this.cXc.setTranslationX(f);
                if (f == this.eVp) {
                    this.eVA = false;
                }
            } else if (i > this.eVp) {
                this.cXc.setTranslationX(this.eVp);
                if (f == this.eVp) {
                    this.eVA = false;
                }
            }
        }
    }

    public void setOnMoveListener(b bVar) {
        this.eVr = bVar;
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
        if (z) {
            if (this.eVt) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_emotion_bar_slide", false);
                this.eVt = false;
                this.eVu = true;
                if (this.eVx == null) {
                    this.eVx = new LinearLayout(getContext());
                    this.eVx.setBackgroundResource(d.g.icon_pb_emotion_bar_slide_tip);
                    this.eVx.setOrientation(1);
                    TextView textView = new TextView(getContext());
                    textView.setText(getContext().getText(d.l.pb_emotion_bar_slide_tip));
                    textView.setTextColor(getResources().getColor(d.e.cp_cont_g));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    layoutParams.topMargin = k.g(getContext(), d.f.ds10);
                    this.eVx.addView(textView, layoutParams);
                }
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.rightMargin = this.eVo / 3;
                layoutParams2.bottomMargin = (int) (((FrameLayout.LayoutParams) getLayoutParams()).bottomMargin + (this.eVo * 1.5d));
                layoutParams2.gravity = 85;
                this.dEt.addView(this.eVx, this.eVs + 1, layoutParams2);
            }
        } else if (this.eVx != null && this.eVx.getVisibility() == 0 && this.eVu) {
            this.eVu = false;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    c.this.eVx.setAlpha(floatValue);
                    if (floatValue == 0.0f) {
                        c.this.eVx.setVisibility(8);
                        if (c.this.eVx.getParent() != null && c.this.eVx.getParent() == c.this.dEt) {
                            c.this.dEt.removeView(c.this.eVx);
                        }
                    }
                }
            });
            ofFloat.setDuration(300L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jT(boolean z) {
        if (z) {
            if (this.cXc != null && this.eVv) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_emotion_bar_search", false);
                this.eVv = false;
                this.eVw = true;
                if (this.eVy == null) {
                    this.eVy = new LinearLayout(getContext());
                    this.eVy.setBackgroundResource(d.g.icon_pb_emotion_bar_search_tip);
                    this.eVy.setOrientation(1);
                    TextView textView = new TextView(getContext());
                    textView.setSingleLine(true);
                    textView.setText(getContext().getText(d.l.pb_emotion_bar_search_tip));
                    textView.setTextColor(getResources().getColor(d.e.cp_cont_g));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    layoutParams.topMargin = k.g(getContext(), d.f.ds10);
                    this.eVy.addView(textView, layoutParams);
                }
                int[] iArr = new int[2];
                this.cXc.getLocationOnScreen(iArr);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.leftMargin = iArr[0] - k.g(getContext(), d.f.ds350);
                layoutParams2.bottomMargin = (int) (((FrameLayout.LayoutParams) getLayoutParams()).bottomMargin + (this.eVp * 1.2d));
                layoutParams2.gravity = 80;
                this.dEt.addView(this.eVy, this.eVs + 1, layoutParams2);
            }
        } else if (this.eVy != null) {
            this.eVy.setVisibility(8);
            this.eVw = false;
            if (this.eVy.getParent() != null && this.eVy.getParent() == this.dEt) {
                this.dEt.removeView(this.eVy);
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.eVu && this.eVx != null) {
            this.eVx.setVisibility(i);
        }
        if (this.eVw && this.eVy != null) {
            this.eVy.setVisibility(i);
        }
        if (this.cXc != null) {
            this.cXc.setVisibility(i);
        }
    }
}
