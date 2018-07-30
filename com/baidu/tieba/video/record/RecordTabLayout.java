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
    private int dCt;
    private LinearLayout hjH;
    private View hjI;
    private boolean hjJ;
    private a hjK;

    /* loaded from: classes2.dex */
    public interface a {
        void F(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.hjJ = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hjJ = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hjJ = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.hjH = new LinearLayout(getContext());
        this.hjH.setOrientation(0);
        this.hjH.setGravity(17);
        addView(this.hjH, new ViewGroup.LayoutParams(-1, -2));
        this.hjI = new View(getContext());
        this.hjI.setBackgroundColor(getResources().getColor(d.C0140d.cp_cont_i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.f(getContext(), d.e.ds44), com.baidu.adp.lib.util.l.f(getContext(), d.e.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds18);
        addView(this.hjI, layoutParams);
    }

    public void ar(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.f(getContext(), d.e.fontsize28));
        textView.setTextColor(getResources().getColor(d.C0140d.cp_cont_i));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.dCt != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.hjK != null) {
                        RecordTabLayout.this.hjK.F(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.hjH.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds44);
        }
        this.hjH.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.dCt != i) {
            this.dCt = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.hjH.getChildCount()) {
                View childAt = this.hjH.getChildAt(i2);
                if (childAt instanceof TextView) {
                    Object tag = childAt.getTag();
                    if ((tag instanceof Integer) && ((Integer) tag).intValue() == i) {
                        textView = (TextView) childAt;
                        textView.setTextColor(getResources().getColor(d.C0140d.cp_cont_i));
                    } else {
                        ((TextView) childAt).setTextColor(getResources().getColor(d.C0140d.white_alpha80));
                        textView = textView2;
                    }
                } else {
                    textView = textView2;
                }
                i2++;
                textView2 = textView;
            }
            if (this.hjJ) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.hjI.getWidth()) / 2)) - RecordTabLayout.this.hjI.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.hjI, "translationX", RecordTabLayout.this.hjI.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.hjI.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.dCt;
    }

    public void setListener(a aVar) {
        this.hjK = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.hjJ = z;
        if (!this.hjJ) {
            this.hjI.setVisibility(4);
        }
    }
}
