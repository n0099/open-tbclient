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
    private int dwv;
    private LinearLayout hem;
    private View hen;
    private boolean heo;
    private a hep;

    /* loaded from: classes2.dex */
    public interface a {
        void G(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.heo = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.heo = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.heo = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.hem = new LinearLayout(getContext());
        this.hem.setOrientation(0);
        this.hem.setGravity(17);
        addView(this.hem, new ViewGroup.LayoutParams(-1, -2));
        this.hen = new View(getContext());
        this.hen.setBackgroundColor(getResources().getColor(d.C0141d.cp_cont_i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.e(getContext(), d.e.ds44), com.baidu.adp.lib.util.l.e(getContext(), d.e.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds18);
        addView(this.hen, layoutParams);
    }

    public void ar(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.e(getContext(), d.e.fontsize28));
        textView.setTextColor(getResources().getColor(d.C0141d.cp_cont_i));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.dwv != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.hep != null) {
                        RecordTabLayout.this.hep.G(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.hem.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds44);
        }
        this.hem.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.dwv != i) {
            this.dwv = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.hem.getChildCount()) {
                View childAt = this.hem.getChildAt(i2);
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
            if (this.heo) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.hen.getWidth()) / 2)) - RecordTabLayout.this.hen.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.hen, "translationX", RecordTabLayout.this.hen.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.hen.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.dwv;
    }

    public void setListener(a aVar) {
        this.hep = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.heo = z;
        if (!this.heo) {
            this.hen.setVisibility(4);
        }
    }
}
