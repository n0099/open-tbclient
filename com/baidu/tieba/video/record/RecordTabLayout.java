package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.e;
/* loaded from: classes5.dex */
public class RecordTabLayout extends LinearLayout {
    private int dRe;
    private LinearLayout hyL;
    private View hyM;
    private boolean hyN;
    private a hyO;

    /* loaded from: classes5.dex */
    public interface a {
        void G(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.hyN = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hyN = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hyN = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.hyL = new LinearLayout(getContext());
        this.hyL.setOrientation(0);
        this.hyL.setGravity(17);
        addView(this.hyL, new ViewGroup.LayoutParams(-1, -2));
        this.hyM = new View(getContext());
        this.hyM.setBackgroundColor(getResources().getColor(e.d.cp_cont_i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.ds44), com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.ds18);
        addView(this.hyM, layoutParams);
    }

    public void as(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.fontsize28));
        textView.setTextColor(getResources().getColor(e.d.cp_cont_i));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.dRe != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.hyO != null) {
                        RecordTabLayout.this.hyO.G(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.hyL.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.ds44);
        }
        this.hyL.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.dRe != i) {
            this.dRe = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.hyL.getChildCount()) {
                View childAt = this.hyL.getChildAt(i2);
                if (childAt instanceof TextView) {
                    Object tag = childAt.getTag();
                    if ((tag instanceof Integer) && ((Integer) tag).intValue() == i) {
                        textView = (TextView) childAt;
                        textView.setTextColor(getResources().getColor(e.d.cp_cont_i));
                    } else {
                        ((TextView) childAt).setTextColor(getResources().getColor(e.d.white_alpha80));
                        textView = textView2;
                    }
                } else {
                    textView = textView2;
                }
                i2++;
                textView2 = textView;
            }
            if (this.hyN) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.hyM.getWidth()) / 2)) - RecordTabLayout.this.hyM.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.hyM, "translationX", RecordTabLayout.this.hyM.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.hyM.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.dRe;
    }

    public void setListener(a aVar) {
        this.hyO = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.hyN = z;
        if (!this.hyN) {
            this.hyM.setVisibility(4);
        }
    }
}
