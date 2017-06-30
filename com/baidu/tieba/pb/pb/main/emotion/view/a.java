package com.baidu.tieba.pb.pb.main.emotion.view;

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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.pb.pb.main.emotion.data.EmotionImageData;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private float FG;
    private float boN;
    private ImageView cLg;
    private ViewGroup dsD;
    private int dso;
    private b eFA;
    private int eFB;
    private boolean eFC;
    private boolean eFD;
    private boolean eFE;
    private boolean eFF;
    private LinearLayout eFG;
    private LinearLayout eFH;
    private boolean eFI;
    private float eFr;
    private double eFs;
    private double eFt;
    private int eFu;
    private int eFv;
    private float eFw;
    private int eFx;
    private int eFy;
    private InterfaceC0075a eFz;
    private com.baidu.tieba.pb.pb.main.emotion.data.b mData;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mScreenWidth;
    private VelocityTracker mVelocityTracker;

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0075a {
        void c(EmotionImageData emotionImageData);

        void cl(List<String> list);
    }

    /* loaded from: classes.dex */
    public interface b {
        void ag(float f);
    }

    public a(Context context) {
        super(context);
        this.eFC = false;
        this.eFD = false;
        this.eFE = false;
        this.eFF = false;
        this.eFI = false;
        init();
    }

    private void init() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        this.eFC = bVar.getBoolean("pb_emotion_bar_slide", true);
        this.eFE = bVar.getBoolean("pb_emotion_bar_search", true);
        this.mScreenWidth = k.af(getContext());
        this.eFw = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = k.g(getContext(), w.f.ds150);
        this.eFx = k.g(getContext(), w.f.ds60);
        this.eFy = k.g(getContext(), w.f.ds116);
        this.dso = k.g(getContext(), w.f.ds10);
        this.eFv = this.mScreenWidth - k.g(getContext(), w.f.ds130);
        setPadding(this.dso, this.dso * 2, this.dso, this.dso * 2);
        as.k(this, w.e.cp_bg_line_d);
    }

    private void pc(int i) {
        int i2 = (int) (this.eFt * (i - this.eFu));
        if (i2 <= 255 && i2 >= 0) {
            getBackground().setAlpha(i2);
        }
    }

    public void a(ViewGroup viewGroup, int i, com.baidu.tieba.pb.pb.main.emotion.data.b bVar) {
        if (bVar != null && bVar.aRm() != null && !bVar.aRm().isEmpty()) {
            this.dsD = viewGroup;
            this.mData = bVar;
            List<EmotionImageData> aRm = bVar.aRm();
            this.eFs = (this.eFx - this.eFy) * (1.0d / this.eFv);
            setData(aRm);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.eFv;
            layoutParams.bottomMargin = i;
            layoutParams.gravity = 80;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                i2++;
                View childAt = viewGroup.getChildAt(i3);
                if (childAt != null && (childAt instanceof com.baidu.adp.widget.f)) {
                    break;
                }
            }
            this.eFB = i2;
            viewGroup.addView(this, this.eFB, layoutParams);
            ju(true);
        }
    }

    public void setBottomMargin(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (layoutParams != null && layoutParams.bottomMargin != i) {
            layoutParams.bottomMargin = i;
            setLayoutParams(layoutParams);
        }
    }

    private void setData(List<EmotionImageData> list) {
        for (EmotionImageData emotionImageData : list) {
            PbEmotionView pbEmotionView = new PbEmotionView(getContext());
            pbEmotionView.setOnClickListener(new com.baidu.tieba.pb.pb.main.emotion.view.b(this, emotionImageData));
            pbEmotionView.aRp();
            e(pbEmotionView, this.dso);
            pbEmotionView.e(emotionImageData);
        }
        this.cLg = new ImageView(getContext());
        as.c(this.cLg, w.g.icon_pb_emotion_search);
        this.cLg.setOnClickListener(new c(this));
        e(this.cLg, this.dso * 2);
        this.eFu = this.mScreenWidth - Math.max(((list.size() + 1) * this.eFy) + ((list.size() + 4) * this.dso), this.mScreenWidth);
        this.eFt = 255.0d * (1.0d / (this.eFu - this.eFv));
    }

    private void e(ImageView imageView, int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.eFx, this.eFx);
        layoutParams.leftMargin = i;
        layoutParams.gravity = 16;
        addView(imageView, layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (((FrameLayout.LayoutParams) getLayoutParams()).leftMargin > 0) {
                    setCanChildShowPreview(false);
                }
                this.FG = motionEvent.getRawX();
                this.boN = motionEvent.getRawY();
                this.eFr = motionEvent.getRawX();
                jv(false);
                return false;
            case 1:
                return false;
            case 2:
                return !s(motionEvent);
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
                if (getChildAt(i2) instanceof PbEmotionView) {
                    ((PbEmotionView) getChildAt(i2)).setCanShowPreview(z);
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
                if (getChildAt(i2) instanceof PbEmotionView) {
                    ((PbEmotionView) getChildAt(i2)).l(f, f2);
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
                        jt(false);
                        break;
                    } else {
                        jt(true);
                        break;
                    }
                } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
                    jt(false);
                    break;
                } else {
                    jt(true);
                    break;
                }
                break;
            case 2:
                ju(false);
                setCanChildShowPreview(false);
                int rawX2 = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.eFr));
                if (rawX2 >= this.eFu && rawX2 <= this.eFv) {
                    layoutParams.leftMargin = rawX2;
                    int pd = pd(rawX2);
                    if (pd <= this.eFy && pd >= this.eFx) {
                        pe(pd);
                        pc(rawX2);
                        pf(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                }
                this.eFr = motionEvent.getRawX();
                k(motionEvent.getRawX(), motionEvent.getRawY());
                if (rawX2 <= this.eFu && this.eFu < 0) {
                    jv(true);
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

    private boolean s(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.FG) < this.eFw && Math.abs(motionEvent.getRawY() - this.boN) < this.eFw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int pd(int i) {
        return (int) ((this.eFs * i) + this.eFy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pe(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i;
            childAt.setLayoutParams(layoutParams);
        }
    }

    public void aRo() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        setCanChildShowPreview(false);
        if (this.eFD) {
            ju(false);
        }
        if (this.eFF) {
            jv(false);
        }
        bd(layoutParams.leftMargin, this.eFv);
    }

    private void bd(int i, int i2) {
        if (i != i2) {
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new d(this, (FrameLayout.LayoutParams) getLayoutParams()));
            ofInt.addListener(new e(this, i2));
            ofInt.setDuration(300L).start();
        }
    }

    public void jt(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin < 0) {
            setCanChildShowPreview(true);
            return;
        }
        int i = layoutParams.leftMargin;
        int i2 = this.eFv;
        if (z) {
            i2 = 0;
            TiebaStatic.log("c12175");
        }
        bd(i, i2);
    }

    public void setOnEmotionClickListener(InterfaceC0075a interfaceC0075a) {
        this.eFz = interfaceC0075a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pf(int i) {
        if (this.eFA != null) {
            this.eFA.ag((this.eFv - i) * (1.0f / this.eFv));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.eFA = bVar;
    }

    public void onResume() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof PbEmotionView)) {
                    ((PbEmotionView) childAt).refresh();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void ju(boolean z) {
        if (z) {
            if (this.eFC) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_emotion_bar_slide", false);
                this.eFC = false;
                this.eFD = true;
                if (this.eFG == null) {
                    this.eFG = new LinearLayout(getContext());
                    this.eFG.setBackgroundResource(w.g.icon_pb_emotion_bar_slide_tip);
                    this.eFG.setOrientation(1);
                    TextView textView = new TextView(getContext());
                    textView.setText(getContext().getText(w.l.pb_emotion_bar_slide_tip));
                    textView.setTextColor(getResources().getColor(w.e.cp_cont_g));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    layoutParams.topMargin = k.g(getContext(), w.f.ds10);
                    this.eFG.addView(textView, layoutParams);
                }
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.rightMargin = this.eFx / 3;
                layoutParams2.bottomMargin = (int) (((FrameLayout.LayoutParams) getLayoutParams()).bottomMargin + (this.eFx * 1.5d));
                layoutParams2.gravity = 85;
                this.dsD.addView(this.eFG, this.eFB + 1, layoutParams2);
            }
        } else if (this.eFG != null && this.eFG.getVisibility() == 0 && this.eFD) {
            this.eFD = false;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.addUpdateListener(new f(this));
            ofFloat.setDuration(300L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jv(boolean z) {
        if (z) {
            if (this.cLg != null && this.eFE) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("pb_emotion_bar_search", false);
                this.eFE = false;
                this.eFF = true;
                if (this.eFH == null) {
                    this.eFH = new LinearLayout(getContext());
                    this.eFH.setBackgroundResource(w.g.icon_pb_emotion_bar_search_tip);
                    this.eFH.setOrientation(1);
                    TextView textView = new TextView(getContext());
                    textView.setSingleLine(true);
                    textView.setText(getContext().getText(w.l.pb_emotion_bar_search_tip));
                    textView.setTextColor(getResources().getColor(w.e.cp_cont_g));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    layoutParams.topMargin = k.g(getContext(), w.f.ds10);
                    this.eFH.addView(textView, layoutParams);
                }
                int[] iArr = new int[2];
                this.cLg.getLocationOnScreen(iArr);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.leftMargin = iArr[0] - k.g(getContext(), w.f.ds350);
                layoutParams2.bottomMargin = (int) (((FrameLayout.LayoutParams) getLayoutParams()).bottomMargin + (this.eFy * 1.2d));
                layoutParams2.gravity = 80;
                this.dsD.addView(this.eFH, this.eFB + 1, layoutParams2);
            }
        } else if (this.eFH != null) {
            this.eFH.setVisibility(8);
            this.eFF = false;
            if (this.eFH.getParent() != null && this.eFH.getParent() == this.dsD) {
                this.dsD.removeView(this.eFH);
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.eFD && this.eFG != null) {
            this.eFG.setVisibility(i);
        }
        if (this.eFF && this.eFH != null) {
            this.eFH.setVisibility(i);
        }
    }
}
