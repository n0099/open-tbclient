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
    private int dzH;
    private LinearLayout hit;
    private View hiu;
    private boolean hiv;
    private a hiw;

    /* loaded from: classes2.dex */
    public interface a {
        void G(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.hiv = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hiv = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hiv = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.hit = new LinearLayout(getContext());
        this.hit.setOrientation(0);
        this.hit.setGravity(17);
        addView(this.hit, new ViewGroup.LayoutParams(-1, -2));
        this.hiu = new View(getContext());
        this.hiu.setBackgroundColor(getResources().getColor(d.C0142d.cp_cont_i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.e(getContext(), d.e.ds44), com.baidu.adp.lib.util.l.e(getContext(), d.e.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds18);
        addView(this.hiu, layoutParams);
    }

    public void ao(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.e(getContext(), d.e.fontsize28));
        textView.setTextColor(getResources().getColor(d.C0142d.cp_cont_i));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.dzH != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.hiw != null) {
                        RecordTabLayout.this.hiw.G(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.hit.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds44);
        }
        this.hit.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.dzH != i) {
            this.dzH = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.hit.getChildCount()) {
                View childAt = this.hit.getChildAt(i2);
                if (childAt instanceof TextView) {
                    Object tag = childAt.getTag();
                    if ((tag instanceof Integer) && ((Integer) tag).intValue() == i) {
                        textView = (TextView) childAt;
                        textView.setTextColor(getResources().getColor(d.C0142d.cp_cont_i));
                    } else {
                        ((TextView) childAt).setTextColor(getResources().getColor(d.C0142d.white_alpha80));
                        textView = textView2;
                    }
                } else {
                    textView = textView2;
                }
                i2++;
                textView2 = textView;
            }
            if (this.hiv) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.hiu.getWidth()) / 2)) - RecordTabLayout.this.hiu.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.hiu, "translationX", RecordTabLayout.this.hiu.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.hiu.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.dzH;
    }

    public void setListener(a aVar) {
        this.hiw = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.hiv = z;
        if (!this.hiv) {
            this.hiu.setVisibility(4);
        }
    }
}
