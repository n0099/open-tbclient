package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class RecordTabLayout extends LinearLayout {
    private int dRR;
    private LinearLayout hwC;
    private View hwD;
    private boolean hwE;
    private a hwF;

    /* loaded from: classes2.dex */
    public interface a {
        void V(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.hwE = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hwE = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hwE = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.hwC = new LinearLayout(getContext());
        this.hwC.setOrientation(0);
        this.hwC.setGravity(17);
        addView(this.hwC, new ViewGroup.LayoutParams(-1, -2));
        this.hwD = new View(getContext());
        this.hwD.setBackgroundColor(getResources().getColor(d.C0141d.cp_cont_i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.t(getContext(), d.e.ds44), com.baidu.adp.lib.util.l.t(getContext(), d.e.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds18);
        addView(this.hwD, layoutParams);
    }

    public void al(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.t(getContext(), d.e.fontsize28));
        textView.setTextColor(getResources().getColor(d.C0141d.cp_cont_i));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.dRR != i) {
                    RecordTabLayout.this.H(i, true);
                    if (RecordTabLayout.this.hwF != null) {
                        RecordTabLayout.this.hwF.V(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.hwC.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds44);
        }
        this.hwC.addView(textView, layoutParams);
    }

    public void H(int i, final boolean z) {
        TextView textView;
        if (this.dRR != i) {
            this.dRR = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.hwC.getChildCount()) {
                View childAt = this.hwC.getChildAt(i2);
                if (childAt instanceof TextView) {
                    Object tag = childAt.getTag();
                    if ((tag instanceof Integer) && ((Integer) tag).intValue() == i) {
                        textView = (TextView) childAt;
                        textView.setTextColor(getResources().getColor(d.C0141d.cp_cont_i));
                    } else {
                        ((TextView) childAt).setTextColor(getResources().getColor(d.C0141d.white_alpha80));
                        textView = textView2;
                    }
                } else {
                    textView = textView2;
                }
                i2++;
                textView2 = textView;
            }
            if (this.hwE) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.hwD.getWidth()) / 2)) - RecordTabLayout.this.hwD.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.hwD, "translationX", RecordTabLayout.this.hwD.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.hwD.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.dRR;
    }

    public void setListener(a aVar) {
        this.hwF = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.hwE = z;
        if (!this.hwE) {
            this.hwD.setVisibility(4);
        }
    }
}
