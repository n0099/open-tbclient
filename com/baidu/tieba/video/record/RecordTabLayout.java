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
    private int dOA;
    private LinearLayout huJ;
    private View huK;
    private boolean huL;
    private a huM;

    /* loaded from: classes2.dex */
    public interface a {
        void P(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.huL = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.huL = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.huL = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.huJ = new LinearLayout(getContext());
        this.huJ.setOrientation(0);
        this.huJ.setGravity(17);
        addView(this.huJ, new ViewGroup.LayoutParams(-1, -2));
        this.huK = new View(getContext());
        this.huK.setBackgroundColor(getResources().getColor(d.C0107d.cp_cont_i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.s(getContext(), d.e.ds44), com.baidu.adp.lib.util.l.s(getContext(), d.e.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds18);
        addView(this.huK, layoutParams);
    }

    public void al(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.s(getContext(), d.e.fontsize28));
        textView.setTextColor(getResources().getColor(d.C0107d.cp_cont_i));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.dOA != i) {
                    RecordTabLayout.this.C(i, true);
                    if (RecordTabLayout.this.huM != null) {
                        RecordTabLayout.this.huM.P(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.huJ.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds44);
        }
        this.huJ.addView(textView, layoutParams);
    }

    public void C(int i, final boolean z) {
        TextView textView;
        if (this.dOA != i) {
            this.dOA = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.huJ.getChildCount()) {
                View childAt = this.huJ.getChildAt(i2);
                if (childAt instanceof TextView) {
                    Object tag = childAt.getTag();
                    if ((tag instanceof Integer) && ((Integer) tag).intValue() == i) {
                        textView = (TextView) childAt;
                        textView.setTextColor(getResources().getColor(d.C0107d.cp_cont_i));
                    } else {
                        ((TextView) childAt).setTextColor(getResources().getColor(d.C0107d.white_alpha80));
                        textView = textView2;
                    }
                } else {
                    textView = textView2;
                }
                i2++;
                textView2 = textView;
            }
            if (this.huL) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.huK.getWidth()) / 2)) - RecordTabLayout.this.huK.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.huK, "translationX", RecordTabLayout.this.huK.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.huK.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.dOA;
    }

    public void setListener(a aVar) {
        this.huM = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.huL = z;
        if (!this.huL) {
            this.huK.setVisibility(4);
        }
    }
}
