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
    private float Hf;
    private float bue;
    private ImageView cVd;
    private float caW;
    private int dCh;
    private ViewGroup dCw;
    private boolean eTA;
    private boolean eTB;
    private LinearLayout eTC;
    private LinearLayout eTD;
    private boolean eTE;
    private boolean eTF;
    private int eTG;
    private long eTH;
    private float eTf;
    private double eTp;
    private double eTq;
    private int eTr;
    private int eTs;
    private int eTt;
    private int eTu;
    private a eTv;
    private b eTw;
    private int eTx;
    private boolean eTy;
    private boolean eTz;
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
        void ag(float f);
    }

    public c(Context context) {
        super(context);
        this.eTy = false;
        this.eTz = false;
        this.eTA = false;
        this.eTB = false;
        this.eTE = false;
        init();
    }

    private void init() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        this.eTy = bVar.getBoolean("pb_emotion_bar_slide", true);
        this.eTA = bVar.getBoolean("pb_emotion_bar_search", true);
        this.mScreenWidth = k.ag(getContext());
        this.caW = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = k.g(getContext(), d.f.ds150);
        this.eTt = k.g(getContext(), d.f.ds60);
        this.eTu = k.g(getContext(), d.f.ds116);
        this.dCh = k.g(getContext(), d.f.ds10);
        this.eTs = this.mScreenWidth - k.g(getContext(), d.f.ds130);
        setPadding(this.dCh, this.dCh * 2, this.dCh, this.dCh * 2);
        ai.k(this, d.e.cp_bg_line_d);
    }

    private void pq(int i) {
        int i2 = (int) (this.eTq * (i - this.eTr));
        if (i2 <= 255 && i2 >= 0) {
            getBackground().setAlpha(i2);
            if (this.cVd != null) {
                this.cVd.getBackground().setAlpha(i2);
            }
        }
    }

    public void a(ViewGroup viewGroup, int i, com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
        if (aVar != null && aVar.acx() != null && !aVar.acx().isEmpty()) {
            this.dCw = viewGroup;
            this.eTG = i;
            this.mData = aVar;
            List<EmotionImageData> acx = aVar.acx();
            this.eTp = (this.eTt - this.eTu) * (1.0d / this.eTs);
            setData(acx);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.eTs;
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
            this.eTx = i2;
            viewGroup.addView(this, this.eTx, layoutParams);
            jP(true);
            aUy();
        }
    }

    public void setBottomMargin(int i) {
        FrameLayout.LayoutParams layoutParams;
        if (this.eTG != i) {
            this.eTG = i;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) getLayoutParams();
            if (layoutParams2 != null && layoutParams2.bottomMargin != i) {
                layoutParams2.bottomMargin = i;
                setLayoutParams(layoutParams2);
            }
            if (this.cVd != null && (layoutParams = (FrameLayout.LayoutParams) this.cVd.getLayoutParams()) != null && layoutParams.bottomMargin != i) {
                layoutParams.bottomMargin = i;
                this.cVd.setLayoutParams(layoutParams);
            }
        }
    }

    private void aUy() {
        this.cVd = new ImageView(getContext());
        ai.c(this.cVd, d.g.icon_pb_emotion_search);
        this.cVd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eTv != null) {
                    c.this.eTv.cD(c.this.mData.aUc());
                }
                TiebaStatic.log("c12177");
            }
        });
        ai.k(this.cVd, d.e.cp_bg_line_d);
        this.cVd.setTranslationX(this.eTu);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.eTt, this.eTt + (this.dCh * 4));
        layoutParams.leftMargin = this.dCh * 2;
        layoutParams.bottomMargin = this.eTG;
        layoutParams.gravity = 85;
        this.dCw.addView(this.cVd, this.eTx + 1, layoutParams);
    }

    private void setData(List<EmotionImageData> list) {
        for (final EmotionImageData emotionImageData : list) {
            EmotionView emotionView = new EmotionView(getContext());
            emotionView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (((FrameLayout.LayoutParams) c.this.getLayoutParams()).leftMargin <= 0) {
                        if (c.this.eTv != null && (view instanceof EmotionView)) {
                            c.this.eTv.b(emotionImageData, ((EmotionView) view).getIsGif());
                        }
                        TiebaStatic.log("c12176");
                    }
                }
            });
            emotionView.acy();
            e(emotionView, this.dCh);
            emotionView.a(emotionImageData);
        }
        this.eTr = this.mScreenWidth - Math.max(((list.size() + 1) * this.eTu) + ((list.size() + 4) * this.dCh), this.mScreenWidth);
        this.eTq = 255.0d * (1.0d / (this.eTr - this.eTs));
    }

    private void e(ImageView imageView, int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.eTt, this.eTt);
        layoutParams.leftMargin = i;
        layoutParams.gravity = 16;
        addView(imageView, layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        switch (motionEvent.getAction()) {
            case 0:
                this.eTH = System.currentTimeMillis();
                if (((FrameLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanChildShowPreview(false);
                }
                this.Hf = motionEvent.getRawX();
                this.bue = motionEvent.getRawY();
                this.eTf = motionEvent.getRawX();
                jQ(false);
                return false;
            case 1:
                if (layoutParams.leftMargin == this.eTs && t(motionEvent) && System.currentTimeMillis() - this.eTH < 300) {
                    jO(true);
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
                int rawX = (int) (motionEvent.getRawX() - this.Hf);
                if (Math.abs(xVelocity) > this.mMinimumVelocity && Math.abs(rawX) > this.mFlingDistance) {
                    if (rawX > 0) {
                        jO(false);
                        break;
                    } else {
                        jO(true);
                        break;
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    jO(false);
                    break;
                } else {
                    jO(true);
                    break;
                }
                break;
            case 2:
                jP(false);
                setCanChildShowPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.eTf));
                if (rawX2 >= this.eTr && rawX2 <= this.eTs) {
                    layoutParams.leftMargin = rawX2;
                    int pr = pr(rawX2);
                    if (pr <= this.eTu && pr >= this.eTt) {
                        ps(pr);
                        pq(rawX2);
                        pt(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                }
                this.eTf = motionEvent.getRawX();
                l(motionEvent.getRawX(), motionEvent.getRawY());
                if (rawX2 <= this.eTr && this.eTr < 0) {
                    jQ(true);
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
        return Math.abs(motionEvent.getRawX() - this.Hf) < this.caW && Math.abs(motionEvent.getRawY() - this.bue) < this.caW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int pr(int i) {
        return (int) ((this.eTp * i) + this.eTu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ps(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i;
            childAt.setLayoutParams(layoutParams);
        }
        if (this.cVd != null) {
            ViewGroup.LayoutParams layoutParams2 = this.cVd.getLayoutParams();
            layoutParams2.width = i;
            layoutParams2.height = (this.dCh * 4) + i;
            this.cVd.setLayoutParams(layoutParams2);
        }
    }

    public void aUz() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        setCanChildShowPreview(false);
        if (this.eTz) {
            jP(false);
        }
        if (this.eTB) {
            jQ(false);
        }
        be(layoutParams.leftMargin, this.eTs);
    }

    private void be(int i, final int i2) {
        if (i != i2) {
            final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    c.this.ps(c.this.pr(layoutParams.leftMargin));
                    c.this.setLayoutParams(layoutParams);
                    c.this.pt(layoutParams.leftMargin);
                }
            });
            ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (((FrameLayout.LayoutParams) c.this.getLayoutParams()).leftMargin <= 0) {
                        c.this.setCanChildShowPreview(true);
                    }
                    if (i2 == 0 && c.this.eTr == 0) {
                        c.this.jQ(true);
                    }
                }
            });
            ofInt.setDuration(300L).start();
        }
    }

    public void jO(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin < 0) {
            setCanChildShowPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.eTs;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        be(i, i2);
    }

    public void setOnEmotionClickListener(a aVar) {
        this.eTv = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pt(int i) {
        if (this.eTw != null) {
            this.eTw.ag((this.eTs - i) * (1.0f / this.eTs));
        }
        pu(i);
    }

    private void pu(int i) {
        if (this.cVd != null) {
            float f = (1.0f - ((this.eTu - i) * (1.0f / this.eTu))) * this.eTu;
            if (f < 0.0f) {
                f = 0.0f;
            } else if (f > this.eTu) {
                f = this.eTu;
            }
            if (i <= this.eTu && !this.eTF) {
                this.cVd.setTranslationX(f);
                if (f == 0.0f) {
                    this.eTF = true;
                }
            } else if (i <= this.eTu && this.eTF) {
                this.cVd.setTranslationX(f);
                if (f == this.eTu) {
                    this.eTF = false;
                }
            } else if (i > this.eTu) {
                this.cVd.setTranslationX(this.eTu);
                if (f == this.eTu) {
                    this.eTF = false;
                }
            }
        }
    }

    public void setOnMoveListener(b bVar) {
        this.eTw = bVar;
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

    private void jP(boolean z) {
        if (z) {
            if (this.eTy) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_emotion_bar_slide", false);
                this.eTy = false;
                this.eTz = true;
                if (this.eTC == null) {
                    this.eTC = new LinearLayout(getContext());
                    this.eTC.setBackgroundResource(d.g.icon_pb_emotion_bar_slide_tip);
                    this.eTC.setOrientation(1);
                    TextView textView = new TextView(getContext());
                    textView.setText(getContext().getText(d.l.pb_emotion_bar_slide_tip));
                    textView.setTextColor(getResources().getColor(d.e.cp_cont_g));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    layoutParams.topMargin = k.g(getContext(), d.f.ds10);
                    this.eTC.addView(textView, layoutParams);
                }
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.rightMargin = this.eTt / 3;
                layoutParams2.bottomMargin = (int) (((FrameLayout.LayoutParams) getLayoutParams()).bottomMargin + (this.eTt * 1.5d));
                layoutParams2.gravity = 85;
                this.dCw.addView(this.eTC, this.eTx + 1, layoutParams2);
            }
        } else if (this.eTC != null && this.eTC.getVisibility() == 0 && this.eTz) {
            this.eTz = false;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    c.this.eTC.setAlpha(floatValue);
                    if (floatValue == 0.0f) {
                        c.this.eTC.setVisibility(8);
                        if (c.this.eTC.getParent() != null && c.this.eTC.getParent() == c.this.dCw) {
                            c.this.dCw.removeView(c.this.eTC);
                        }
                    }
                }
            });
            ofFloat.setDuration(300L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jQ(boolean z) {
        if (z) {
            if (this.cVd != null && this.eTA) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_emotion_bar_search", false);
                this.eTA = false;
                this.eTB = true;
                if (this.eTD == null) {
                    this.eTD = new LinearLayout(getContext());
                    this.eTD.setBackgroundResource(d.g.icon_pb_emotion_bar_search_tip);
                    this.eTD.setOrientation(1);
                    TextView textView = new TextView(getContext());
                    textView.setSingleLine(true);
                    textView.setText(getContext().getText(d.l.pb_emotion_bar_search_tip));
                    textView.setTextColor(getResources().getColor(d.e.cp_cont_g));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    layoutParams.topMargin = k.g(getContext(), d.f.ds10);
                    this.eTD.addView(textView, layoutParams);
                }
                int[] iArr = new int[2];
                this.cVd.getLocationOnScreen(iArr);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.leftMargin = iArr[0] - k.g(getContext(), d.f.ds350);
                layoutParams2.bottomMargin = (int) (((FrameLayout.LayoutParams) getLayoutParams()).bottomMargin + (this.eTu * 1.2d));
                layoutParams2.gravity = 80;
                this.dCw.addView(this.eTD, this.eTx + 1, layoutParams2);
            }
        } else if (this.eTD != null) {
            this.eTD.setVisibility(8);
            this.eTB = false;
            if (this.eTD.getParent() != null && this.eTD.getParent() == this.dCw) {
                this.dCw.removeView(this.eTD);
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.eTz && this.eTC != null) {
            this.eTC.setVisibility(i);
        }
        if (this.eTB && this.eTD != null) {
            this.eTD.setVisibility(i);
        }
        if (this.cVd != null) {
            this.cVd.setVisibility(i);
        }
    }
}
