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
/* loaded from: classes5.dex */
public class RecordTabLayout extends LinearLayout {
    private int fpA;
    private LinearLayout jcl;
    private View jcm;
    private boolean jcn;
    private a jco;

    /* loaded from: classes5.dex */
    public interface a {
        void M(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.jcn = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jcn = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jcn = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.jcl = new LinearLayout(getContext());
        this.jcl.setOrientation(0);
        this.jcl.setGravity(17);
        addView(this.jcl, new ViewGroup.LayoutParams(-1, -2));
        this.jcm = new View(getContext());
        this.jcm.setBackgroundColor(getResources().getColor(d.C0277d.cp_btn_a));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.h(getContext(), d.e.ds44), com.baidu.adp.lib.util.l.h(getContext(), d.e.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds18);
        addView(this.jcm, layoutParams);
    }

    public void aJ(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.h(getContext(), d.e.fontsize28));
        textView.setTextColor(getResources().getColor(d.C0277d.cp_btn_a));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.fpA != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.jco != null) {
                        RecordTabLayout.this.jco.M(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.jcl.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds44);
        }
        this.jcl.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.fpA != i) {
            this.fpA = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.jcl.getChildCount()) {
                View childAt = this.jcl.getChildAt(i2);
                if (childAt instanceof TextView) {
                    Object tag = childAt.getTag();
                    if ((tag instanceof Integer) && ((Integer) tag).intValue() == i) {
                        textView = (TextView) childAt;
                        textView.setTextColor(getResources().getColor(d.C0277d.cp_btn_a));
                    } else {
                        ((TextView) childAt).setTextColor(getResources().getColor(d.C0277d.white_alpha80));
                        textView = textView2;
                    }
                } else {
                    textView = textView2;
                }
                i2++;
                textView2 = textView;
            }
            if (this.jcn) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.jcm.getWidth()) / 2)) - RecordTabLayout.this.jcm.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.jcm, "translationX", RecordTabLayout.this.jcm.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.jcm.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.fpA;
    }

    public void setListener(a aVar) {
        this.jco = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.jcn = z;
        if (!this.jcn) {
            this.jcm.setVisibility(4);
        }
    }
}
