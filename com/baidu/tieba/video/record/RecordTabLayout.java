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
    private int dOV;
    private LinearLayout hvd;
    private View hve;
    private boolean hvf;
    private a hvg;

    /* loaded from: classes2.dex */
    public interface a {
        void P(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.hvf = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hvf = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hvf = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.hvd = new LinearLayout(getContext());
        this.hvd.setOrientation(0);
        this.hvd.setGravity(17);
        addView(this.hvd, new ViewGroup.LayoutParams(-1, -2));
        this.hve = new View(getContext());
        this.hve.setBackgroundColor(getResources().getColor(d.C0108d.cp_cont_i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.s(getContext(), d.e.ds44), com.baidu.adp.lib.util.l.s(getContext(), d.e.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds18);
        addView(this.hve, layoutParams);
    }

    public void an(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.s(getContext(), d.e.fontsize28));
        textView.setTextColor(getResources().getColor(d.C0108d.cp_cont_i));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.dOV != i) {
                    RecordTabLayout.this.C(i, true);
                    if (RecordTabLayout.this.hvg != null) {
                        RecordTabLayout.this.hvg.P(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.hvd.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds44);
        }
        this.hvd.addView(textView, layoutParams);
    }

    public void C(int i, final boolean z) {
        TextView textView;
        if (this.dOV != i) {
            this.dOV = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.hvd.getChildCount()) {
                View childAt = this.hvd.getChildAt(i2);
                if (childAt instanceof TextView) {
                    Object tag = childAt.getTag();
                    if ((tag instanceof Integer) && ((Integer) tag).intValue() == i) {
                        textView = (TextView) childAt;
                        textView.setTextColor(getResources().getColor(d.C0108d.cp_cont_i));
                    } else {
                        ((TextView) childAt).setTextColor(getResources().getColor(d.C0108d.white_alpha80));
                        textView = textView2;
                    }
                } else {
                    textView = textView2;
                }
                i2++;
                textView2 = textView;
            }
            if (this.hvf) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.hve.getWidth()) / 2)) - RecordTabLayout.this.hve.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.hve, "translationX", RecordTabLayout.this.hve.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.hve.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.dOV;
    }

    public void setListener(a aVar) {
        this.hvg = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.hvf = z;
        if (!this.hvf) {
            this.hve.setVisibility(4);
        }
    }
}
