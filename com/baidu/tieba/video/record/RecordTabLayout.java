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
    private int dYL;
    private LinearLayout hHH;
    private View hHI;
    private boolean hHJ;
    private a hHK;

    /* loaded from: classes5.dex */
    public interface a {
        void G(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.hHJ = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hHJ = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hHJ = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.hHH = new LinearLayout(getContext());
        this.hHH.setOrientation(0);
        this.hHH.setGravity(17);
        addView(this.hHH, new ViewGroup.LayoutParams(-1, -2));
        this.hHI = new View(getContext());
        this.hHI.setBackgroundColor(getResources().getColor(e.d.cp_cont_i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds44), com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds18);
        addView(this.hHI, layoutParams);
    }

    public void ao(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.fontsize28));
        textView.setTextColor(getResources().getColor(e.d.cp_cont_i));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.dYL != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.hHK != null) {
                        RecordTabLayout.this.hHK.G(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.hHH.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds44);
        }
        this.hHH.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.dYL != i) {
            this.dYL = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.hHH.getChildCount()) {
                View childAt = this.hHH.getChildAt(i2);
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
            if (this.hHJ) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.hHI.getWidth()) / 2)) - RecordTabLayout.this.hHI.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.hHI, "translationX", RecordTabLayout.this.hHI.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.hHI.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.dYL;
    }

    public void setListener(a aVar) {
        this.hHK = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.hHJ = z;
        if (!this.hHJ) {
            this.hHI.setVisibility(4);
        }
    }
}
