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
    private int dRM;
    private LinearLayout hwe;
    private View hwf;
    private boolean hwg;
    private a hwh;

    /* loaded from: classes2.dex */
    public interface a {
        void V(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.hwg = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hwg = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hwg = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.hwe = new LinearLayout(getContext());
        this.hwe.setOrientation(0);
        this.hwe.setGravity(17);
        addView(this.hwe, new ViewGroup.LayoutParams(-1, -2));
        this.hwf = new View(getContext());
        this.hwf.setBackgroundColor(getResources().getColor(d.C0141d.cp_cont_i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.t(getContext(), d.e.ds44), com.baidu.adp.lib.util.l.t(getContext(), d.e.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds18);
        addView(this.hwf, layoutParams);
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
                if (RecordTabLayout.this.dRM != i) {
                    RecordTabLayout.this.H(i, true);
                    if (RecordTabLayout.this.hwh != null) {
                        RecordTabLayout.this.hwh.V(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.hwe.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds44);
        }
        this.hwe.addView(textView, layoutParams);
    }

    public void H(int i, final boolean z) {
        TextView textView;
        if (this.dRM != i) {
            this.dRM = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.hwe.getChildCount()) {
                View childAt = this.hwe.getChildAt(i2);
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
            if (this.hwg) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.hwf.getWidth()) / 2)) - RecordTabLayout.this.hwf.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.hwf, "translationX", RecordTabLayout.this.hwf.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.hwf.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.dRM;
    }

    public void setListener(a aVar) {
        this.hwh = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.hwg = z;
        if (!this.hwg) {
            this.hwf.setVisibility(4);
        }
    }
}
