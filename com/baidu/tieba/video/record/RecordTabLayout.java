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
    private int dJY;
    private LinearLayout hFg;
    private View hFh;
    private boolean hFi;
    private a hFj;

    /* loaded from: classes2.dex */
    public interface a {
        void P(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.hFi = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hFi = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hFi = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.hFg = new LinearLayout(getContext());
        this.hFg.setOrientation(0);
        this.hFg.setGravity(17);
        addView(this.hFg, new ViewGroup.LayoutParams(-1, -2));
        this.hFh = new View(getContext());
        this.hFh.setBackgroundColor(getResources().getColor(d.C0108d.cp_cont_i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.s(getContext(), d.e.ds44), com.baidu.adp.lib.util.l.s(getContext(), d.e.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds18);
        addView(this.hFh, layoutParams);
    }

    public void ak(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.s(getContext(), d.e.fontsize28));
        textView.setTextColor(getResources().getColor(d.C0108d.cp_cont_i));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.dJY != i) {
                    RecordTabLayout.this.C(i, true);
                    if (RecordTabLayout.this.hFj != null) {
                        RecordTabLayout.this.hFj.P(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.hFg.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds44);
        }
        this.hFg.addView(textView, layoutParams);
    }

    public void C(int i, final boolean z) {
        TextView textView;
        if (this.dJY != i) {
            this.dJY = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.hFg.getChildCount()) {
                View childAt = this.hFg.getChildAt(i2);
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
            if (this.hFi) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.hFh.getWidth()) / 2)) - RecordTabLayout.this.hFh.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.hFh, "translationX", RecordTabLayout.this.hFh.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.hFh.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.dJY;
    }

    public void setListener(a aVar) {
        this.hFj = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.hFi = z;
        if (!this.hFi) {
            this.hFh.setVisibility(4);
        }
    }
}
