package com.baidu.tieba.pb.pb.main.emotion.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.pb.pb.main.emotion.data.EmotionImageData;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private float FG;
    private float bkY;
    private int dks;
    private float ewe;
    private double ewf;
    private int ewg;
    private int ewh;
    private float ewi;
    private int ewj;
    private int ewk;
    private InterfaceC0072a ewl;
    private b ewm;
    private com.baidu.tieba.pb.pb.main.emotion.data.b mData;
    private int mScreenWidth;

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0072a {
        void bW(List<String> list);

        void c(EmotionImageData emotionImageData);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aa(float f);
    }

    public a(Context context) {
        super(context);
        init();
    }

    private void init() {
        this.ewi = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.ewj = k.g(getContext(), w.f.ds60);
        this.ewk = k.g(getContext(), w.f.ds116);
        this.dks = k.g(getContext(), w.f.ds10);
        this.mScreenWidth = k.af(getContext());
        this.ewh = this.mScreenWidth - k.g(getContext(), w.f.ds130);
        setPadding(this.dks, this.dks * 2, this.dks, this.dks * 2);
    }

    public void a(ViewGroup viewGroup, int i, com.baidu.tieba.pb.pb.main.emotion.data.b bVar) {
        if (bVar != null && bVar.aNn() != null && !bVar.aNn().isEmpty()) {
            this.mData = bVar;
            List<EmotionImageData> aNn = bVar.aNn();
            this.ewf = (this.ewj - this.ewk) * (1.0d / this.ewh);
            setData(aNn);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = this.ewh;
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
            viewGroup.addView(this, i2, layoutParams);
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
            pbEmotionView.aNp();
            e(pbEmotionView, this.dks);
            pbEmotionView.e(emotionImageData);
        }
        ImageView imageView = new ImageView(getContext());
        aq.c(imageView, w.g.icon_pb_emotion_search);
        imageView.setOnClickListener(new c(this));
        e(imageView, this.dks * 2);
        this.ewg = this.mScreenWidth - Math.max(((list.size() + 1) * this.ewk) + ((list.size() + 4) * this.dks), this.mScreenWidth);
    }

    private void e(ImageView imageView, int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ewj, this.ewj);
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
                this.bkY = motionEvent.getRawY();
                this.ewe = motionEvent.getRawX();
                return false;
            case 1:
                return false;
            case 2:
                return !q(motionEvent);
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

    private void i(float f, float f2) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (getChildAt(i2) instanceof PbEmotionView) {
                    ((PbEmotionView) getChildAt(i2)).j(f, f2);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                iX(false);
                return true;
            case 2:
                setCanChildShowPreview(false);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
                int rawX = layoutParams.leftMargin + ((int) (motionEvent.getRawX() - this.ewe));
                if (rawX >= this.ewg && rawX <= this.ewh) {
                    layoutParams.leftMargin = rawX;
                    int oL = oL(rawX);
                    if (oL <= this.ewk && oL >= this.ewj) {
                        oM(oL);
                        oN(layoutParams.leftMargin);
                    }
                    setLayoutParams(layoutParams);
                }
                this.ewe = motionEvent.getRawX();
                i(motionEvent.getRawX(), motionEvent.getRawY());
                return true;
            default:
                return true;
        }
    }

    private boolean q(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.FG) < this.ewi && Math.abs(motionEvent.getRawY() - this.bkY) < this.ewi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int oL(int i) {
        return (int) ((this.ewf * i) + this.ewk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oM(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = i;
            childAt.setLayoutParams(layoutParams);
        }
    }

    public void iX(boolean z) {
        int i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        if (layoutParams.leftMargin < 0) {
            setCanChildShowPreview(true);
            return;
        }
        int i2 = layoutParams.leftMargin;
        if (z) {
            i = this.ewh;
        } else if (layoutParams.leftMargin > 0.4d * this.mScreenWidth) {
            i = this.ewh;
        } else {
            TiebaStatic.log("c12175");
            i = 0;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i);
        ofInt.addUpdateListener(new d(this, layoutParams));
        ofInt.addListener(new e(this));
        ofInt.setDuration(300L).start();
    }

    public void setOnEmotionClickListener(InterfaceC0072a interfaceC0072a) {
        this.ewl = interfaceC0072a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oN(int i) {
        if (this.ewm != null) {
            this.ewm.aa((this.ewh - i) * (1.0f / this.ewh));
        }
    }

    public void setOnMoveListener(b bVar) {
        this.ewm = bVar;
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
}
