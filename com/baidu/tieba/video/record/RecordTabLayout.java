package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class RecordTabLayout extends LinearLayout {
    private int dCq;
    private LinearLayout hjI;
    private View hjJ;
    private boolean hjK;
    private a hjL;

    /* loaded from: classes2.dex */
    public interface a {
        void F(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.hjK = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hjK = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hjK = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.hjI = new LinearLayout(getContext());
        this.hjI.setOrientation(0);
        this.hjI.setGravity(17);
        addView(this.hjI, new ViewGroup.LayoutParams(-1, -2));
        this.hjJ = new View(getContext());
        this.hjJ.setBackgroundColor(getResources().getColor(f.d.cp_cont_i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.f(getContext(), f.e.ds44), com.baidu.adp.lib.util.l.f(getContext(), f.e.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(getContext(), f.e.ds18);
        addView(this.hjJ, layoutParams);
    }

    public void ar(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.f(getContext(), f.e.fontsize28));
        textView.setTextColor(getResources().getColor(f.d.cp_cont_i));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.dCq != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.hjL != null) {
                        RecordTabLayout.this.hjL.F(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.hjI.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(getContext(), f.e.ds44);
        }
        this.hjI.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.dCq != i) {
            this.dCq = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.hjI.getChildCount()) {
                View childAt = this.hjI.getChildAt(i2);
                if (childAt instanceof TextView) {
                    Object tag = childAt.getTag();
                    if ((tag instanceof Integer) && ((Integer) tag).intValue() == i) {
                        textView = (TextView) childAt;
                        textView.setTextColor(getResources().getColor(f.d.cp_cont_i));
                    } else {
                        ((TextView) childAt).setTextColor(getResources().getColor(f.d.white_alpha80));
                        textView = textView2;
                    }
                } else {
                    textView = textView2;
                }
                i2++;
                textView2 = textView;
            }
            if (this.hjK) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.hjJ.getWidth()) / 2)) - RecordTabLayout.this.hjJ.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.hjJ, "translationX", RecordTabLayout.this.hjJ.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.hjJ.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.dCq;
    }

    public void setListener(a aVar) {
        this.hjL = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.hjK = z;
        if (!this.hjK) {
            this.hjJ.setVisibility(4);
        }
    }
}
