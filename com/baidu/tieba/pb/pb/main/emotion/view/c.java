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
    private float FG;
    private float bZQ;
    private float bsT;
    private ImageView cTK;
    private int dAQ;
    private ViewGroup dBf;
    private float eRS;
    private double eSc;
    private double eSd;
    private int eSe;
    private int eSf;
    private int eSg;
    private int eSh;
    private a eSi;
    private b eSj;
    private int eSk;
    private boolean eSl;
    private boolean eSm;
    private boolean eSn;
    private boolean eSo;
    private LinearLayout eSp;
    private LinearLayout eSq;
    private boolean eSr;
    private boolean eSs;
    private int eSt;
    private long eSu;
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
        this.eSl = false;
        this.eSm = false;
        this.eSn = false;
        this.eSo = false;
        this.eSr = false;
        init();
    }

    private void init() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        this.eSl = bVar.getBoolean("pb_emotion_bar_slide", true);
        this.eSn = bVar.getBoolean("pb_emotion_bar_search", true);
        this.mScreenWidth = k.af(getContext());
        this.bZQ = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = k.g(getContext(), d.f.ds150);
        this.eSg = k.g(getContext(), d.f.ds60);
        this.eSh = k.g(getContext(), d.f.ds116);
        this.dAQ = k.g(getContext(), d.f.ds10);
        this.eSf = this.mScreenWidth - k.g(getContext(), d.f.ds130);
        setPadding(this.dAQ, this.dAQ * 2, this.dAQ, this.dAQ * 2);
        ai.k(this, d.e.cp_bg_line_d);
    }

    private void pr(int i) {
        int i2 = (int) (this.eSd * (i - this.eSe));
        if (i2 <= 255 && i2 >= 0) {
            getBackground().setAlpha(i2);
            if (this.cTK != null) {
                this.cTK.getBackground().setAlpha(i2);
            }
        }
    }

    public void a(ViewGroup viewGroup, int i, com.baidu.tieba.pb.pb.main.emotion.a.a aVar) {
        if (aVar != null && aVar.acs() != null && !aVar.acs().isEmpty()) {
            this.dBf = viewGroup;
            this.eSt = i;
            this.mData = aVar;
            List<EmotionImageData> acs = aVar.acs();
            this.eSc = (this.eSg - this.eSh) * (1.0d / this.eSf);
            setData(acs);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.eSf;
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
            this.eSk = i2;
            viewGroup.addView(this, this.eSk, layoutParams);
            jP(true);
            aUn();
        }
    }

    public void setBottomMargin(int i) {
        FrameLayout.LayoutParams layoutParams;
        if (this.eSt != i) {
            this.eSt = i;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) getLayoutParams();
            if (layoutParams2 != null && layoutParams2.bottomMargin != i) {
                layoutParams2.bottomMargin = i;
                setLayoutParams(layoutParams2);
            }
            if (this.cTK != null && (layoutParams = (FrameLayout.LayoutParams) this.cTK.getLayoutParams()) != null && layoutParams.bottomMargin != i) {
                layoutParams.bottomMargin = i;
                this.cTK.setLayoutParams(layoutParams);
            }
        }
    }

    private void aUn() {
        this.cTK = new ImageView(getContext());
        ai.c(this.cTK, d.g.icon_pb_emotion_search);
        this.cTK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.eSi != null) {
                    c.this.eSi.cD(c.this.mData.aTR());
                }
                TiebaStatic.log("c12177");
            }
        });
        ai.k(this.cTK, d.e.cp_bg_line_d);
        this.cTK.setTranslationX(this.eSh);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.eSg, this.eSg + (this.dAQ * 4));
        layoutParams.leftMargin = this.dAQ * 2;
        layoutParams.bottomMargin = this.eSt;
        layoutParams.gravity = 85;
        this.dBf.addView(this.cTK, this.eSk + 1, layoutParams);
    }

    private void setData(List<EmotionImageData> list) {
        for (final EmotionImageData emotionImageData : list) {
            EmotionView emotionView = new EmotionView(getContext());
            emotionView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (((FrameLayout.LayoutParams) c.this.getLayoutParams()).leftMargin <= 0) {
                        if (c.this.eSi != null && (view instanceof EmotionView)) {
                            c.this.eSi.b(emotionImageData, ((EmotionView) view).getIsGif());
                        }
                        TiebaStatic.log("c12176");
                    }
                }
            });
            emotionView.act();
            e(emotionView, this.dAQ);
            emotionView.a(emotionImageData);
        }
        this.eSe = this.mScreenWidth - Math.max(((list.size() + 1) * this.eSh) + ((list.size() + 4) * this.dAQ), this.mScreenWidth);
        this.eSd = 255.0d * (1.0d / (this.eSe - this.eSf));
    }

    private void e(ImageView imageView, int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.eSg, this.eSg);
        layoutParams.leftMargin = i;
        layoutParams.gravity = 16;
        addView(imageView, layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        switch (motionEvent.getAction()) {
            case 0:
                this.eSu = System.currentTimeMillis();
                if (((FrameLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanChildShowPreview(false);
                }
                this.FG = motionEvent.getRawX();
                this.bsT = motionEvent.getRawY();
                this.eRS = motionEvent.getRawX();
                jQ(false);
                return false;
            case 1:
                if (layoutParams.leftMargin == this.eSf && t(motionEvent) && System.currentTimeMillis() - this.eSu < 300) {
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
                int rawX = (int) (motionEvent.getRawX() - this.FG);
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
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.eRS));
                if (rawX2 >= this.eSe && rawX2 <= this.eSf) {
                    layoutParams.leftMargin = rawX2;
                    int ps = ps(rawX2);
                    if (ps <= this.eSh && ps >= this.eSg) {
                        pt(ps);
                        pr(rawX2);
                        pu(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                }
                this.eRS = motionEvent.getRawX();
                l(motionEvent.getRawX(), motionEvent.getRawY());
                if (rawX2 <= this.eSe && this.eSe < 0) {
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
        return Math.abs(motionEvent.getRawX() - this.FG) < this.bZQ && Math.abs(motionEvent.getRawY() - this.bsT) < this.bZQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ps(int i) {
        return (int) ((this.eSc * i) + this.eSh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pt(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i;
            childAt.setLayoutParams(layoutParams);
        }
        if (this.cTK != null) {
            ViewGroup.LayoutParams layoutParams2 = this.cTK.getLayoutParams();
            layoutParams2.width = i;
            layoutParams2.height = (this.dAQ * 4) + i;
            this.cTK.setLayoutParams(layoutParams2);
        }
    }

    public void aUo() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        setCanChildShowPreview(false);
        if (this.eSm) {
            jP(false);
        }
        if (this.eSo) {
            jQ(false);
        }
        bd(layoutParams.leftMargin, this.eSf);
    }

    private void bd(int i, final int i2) {
        if (i != i2) {
            final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    c.this.pt(c.this.ps(layoutParams.leftMargin));
                    c.this.setLayoutParams(layoutParams);
                    c.this.pu(layoutParams.leftMargin);
                }
            });
            ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (((FrameLayout.LayoutParams) c.this.getLayoutParams()).leftMargin <= 0) {
                        c.this.setCanChildShowPreview(true);
                    }
                    if (i2 == 0 && c.this.eSe == 0) {
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
        int i2 = this.eSf;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        bd(i, i2);
    }

    public void setOnEmotionClickListener(a aVar) {
        this.eSi = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu(int i) {
        if (this.eSj != null) {
            this.eSj.ag((this.eSf - i) * (1.0f / this.eSf));
        }
        pv(i);
    }

    private void pv(int i) {
        if (this.cTK != null) {
            float f = (1.0f - ((this.eSh - i) * (1.0f / this.eSh))) * this.eSh;
            if (f < 0.0f) {
                f = 0.0f;
            } else if (f > this.eSh) {
                f = this.eSh;
            }
            if (i <= this.eSh && !this.eSs) {
                this.cTK.setTranslationX(f);
                if (f == 0.0f) {
                    this.eSs = true;
                }
            } else if (i <= this.eSh && this.eSs) {
                this.cTK.setTranslationX(f);
                if (f == this.eSh) {
                    this.eSs = false;
                }
            } else if (i > this.eSh) {
                this.cTK.setTranslationX(this.eSh);
                if (f == this.eSh) {
                    this.eSs = false;
                }
            }
        }
    }

    public void setOnMoveListener(b bVar) {
        this.eSj = bVar;
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
            if (this.eSl) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_emotion_bar_slide", false);
                this.eSl = false;
                this.eSm = true;
                if (this.eSp == null) {
                    this.eSp = new LinearLayout(getContext());
                    this.eSp.setBackgroundResource(d.g.icon_pb_emotion_bar_slide_tip);
                    this.eSp.setOrientation(1);
                    TextView textView = new TextView(getContext());
                    textView.setText(getContext().getText(d.l.pb_emotion_bar_slide_tip));
                    textView.setTextColor(getResources().getColor(d.e.cp_cont_g));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    layoutParams.topMargin = k.g(getContext(), d.f.ds10);
                    this.eSp.addView(textView, layoutParams);
                }
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.rightMargin = this.eSg / 3;
                layoutParams2.bottomMargin = (int) (((FrameLayout.LayoutParams) getLayoutParams()).bottomMargin + (this.eSg * 1.5d));
                layoutParams2.gravity = 85;
                this.dBf.addView(this.eSp, this.eSk + 1, layoutParams2);
            }
        } else if (this.eSp != null && this.eSp.getVisibility() == 0 && this.eSm) {
            this.eSm = false;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.c.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    c.this.eSp.setAlpha(floatValue);
                    if (floatValue == 0.0f) {
                        c.this.eSp.setVisibility(8);
                        if (c.this.eSp.getParent() != null && c.this.eSp.getParent() == c.this.dBf) {
                            c.this.dBf.removeView(c.this.eSp);
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
            if (this.cTK != null && this.eSn) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_emotion_bar_search", false);
                this.eSn = false;
                this.eSo = true;
                if (this.eSq == null) {
                    this.eSq = new LinearLayout(getContext());
                    this.eSq.setBackgroundResource(d.g.icon_pb_emotion_bar_search_tip);
                    this.eSq.setOrientation(1);
                    TextView textView = new TextView(getContext());
                    textView.setSingleLine(true);
                    textView.setText(getContext().getText(d.l.pb_emotion_bar_search_tip));
                    textView.setTextColor(getResources().getColor(d.e.cp_cont_g));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    layoutParams.topMargin = k.g(getContext(), d.f.ds10);
                    this.eSq.addView(textView, layoutParams);
                }
                int[] iArr = new int[2];
                this.cTK.getLocationOnScreen(iArr);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.leftMargin = iArr[0] - k.g(getContext(), d.f.ds350);
                layoutParams2.bottomMargin = (int) (((FrameLayout.LayoutParams) getLayoutParams()).bottomMargin + (this.eSh * 1.2d));
                layoutParams2.gravity = 80;
                this.dBf.addView(this.eSq, this.eSk + 1, layoutParams2);
            }
        } else if (this.eSq != null) {
            this.eSq.setVisibility(8);
            this.eSo = false;
            if (this.eSq.getParent() != null && this.eSq.getParent() == this.dBf) {
                this.dBf.removeView(this.eSq);
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.eSm && this.eSp != null) {
            this.eSp.setVisibility(i);
        }
        if (this.eSo && this.eSq != null) {
            this.eSq.setVisibility(i);
        }
        if (this.cTK != null) {
            this.cTK.setVisibility(i);
        }
    }
}
