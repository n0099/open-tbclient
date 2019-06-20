package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class RecordTabLayout extends LinearLayout {
    private int fFX;
    private LinearLayout jvj;
    private View jvk;
    private boolean jvl;
    private a jvm;

    /* loaded from: classes5.dex */
    public interface a {
        void R(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.jvl = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jvl = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jvl = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.jvj = new LinearLayout(getContext());
        this.jvj.setOrientation(0);
        this.jvj.setGravity(17);
        addView(this.jvj, new ViewGroup.LayoutParams(-1, -2));
        this.jvk = new View(getContext());
        this.jvk.setBackgroundColor(getResources().getColor(R.color.cp_btn_a));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds44), com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds18);
        addView(this.jvk, layoutParams);
    }

    public void aM(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.fontsize28));
        textView.setTextColor(getResources().getColor(R.color.cp_btn_a));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.fFX != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.jvm != null) {
                        RecordTabLayout.this.jvm.R(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.jvj.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds44);
        }
        this.jvj.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.fFX != i) {
            this.fFX = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.jvj.getChildCount()) {
                View childAt = this.jvj.getChildAt(i2);
                if (childAt instanceof TextView) {
                    Object tag = childAt.getTag();
                    if ((tag instanceof Integer) && ((Integer) tag).intValue() == i) {
                        textView = (TextView) childAt;
                        textView.setTextColor(getResources().getColor(R.color.cp_btn_a));
                    } else {
                        ((TextView) childAt).setTextColor(getResources().getColor(R.color.white_alpha80));
                        textView = textView2;
                    }
                } else {
                    textView = textView2;
                }
                i2++;
                textView2 = textView;
            }
            if (this.jvl) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.jvk.getWidth()) / 2)) - RecordTabLayout.this.jvk.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.jvk, "translationX", RecordTabLayout.this.jvk.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.jvk.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.fFX;
    }

    public void setListener(a aVar) {
        this.jvm = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.jvl = z;
        if (!this.jvl) {
            this.jvk.setVisibility(4);
        }
    }
}
