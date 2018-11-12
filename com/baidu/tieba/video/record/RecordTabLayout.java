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
    private int dSj;
    private LinearLayout hAv;
    private View hAw;
    private boolean hAx;
    private a hAy;

    /* loaded from: classes5.dex */
    public interface a {
        void G(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.hAx = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hAx = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hAx = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.hAv = new LinearLayout(getContext());
        this.hAv.setOrientation(0);
        this.hAv.setGravity(17);
        addView(this.hAv, new ViewGroup.LayoutParams(-1, -2));
        this.hAw = new View(getContext());
        this.hAw.setBackgroundColor(getResources().getColor(e.d.cp_cont_i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.ds44), com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.ds18);
        addView(this.hAw, layoutParams);
    }

    public void ao(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.fontsize28));
        textView.setTextColor(getResources().getColor(e.d.cp_cont_i));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.dSj != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.hAy != null) {
                        RecordTabLayout.this.hAy.G(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.hAv.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.ds44);
        }
        this.hAv.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.dSj != i) {
            this.dSj = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.hAv.getChildCount()) {
                View childAt = this.hAv.getChildAt(i2);
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
            if (this.hAx) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.hAw.getWidth()) / 2)) - RecordTabLayout.this.hAw.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.hAw, "translationX", RecordTabLayout.this.hAw.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.hAw.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.dSj;
    }

    public void setListener(a aVar) {
        this.hAy = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.hAx = z;
        if (!this.hAx) {
            this.hAw.setVisibility(4);
        }
    }
}
