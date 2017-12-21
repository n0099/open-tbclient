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
    private LinearLayout gYd;
    private View gYe;
    private boolean gYf;
    private a gYg;
    private int goK;

    /* loaded from: classes2.dex */
    public interface a {
        void E(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.gYf = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gYf = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gYf = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.gYd = new LinearLayout(getContext());
        this.gYd.setOrientation(0);
        this.gYd.setGravity(17);
        addView(this.gYd, new ViewGroup.LayoutParams(-1, -2));
        this.gYe = new View(getContext());
        this.gYe.setBackgroundColor(getResources().getColor(d.C0095d.cp_cont_i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.f(getContext(), d.e.ds44), com.baidu.adp.lib.util.l.f(getContext(), d.e.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds18);
        addView(this.gYe, layoutParams);
    }

    public void al(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.f(getContext(), d.e.fontsize28));
        textView.setTextColor(getResources().getColor(d.C0095d.cp_cont_i));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.goK != i) {
                    RecordTabLayout.this.q(i, true);
                    if (RecordTabLayout.this.gYg != null) {
                        RecordTabLayout.this.gYg.E(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.gYd.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds44);
        }
        this.gYd.addView(textView, layoutParams);
    }

    public void q(int i, final boolean z) {
        TextView textView;
        if (this.goK != i) {
            this.goK = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.gYd.getChildCount()) {
                View childAt = this.gYd.getChildAt(i2);
                if (childAt instanceof TextView) {
                    Object tag = childAt.getTag();
                    if ((tag instanceof Integer) && ((Integer) tag).intValue() == i) {
                        textView = (TextView) childAt;
                        textView.setTextColor(getResources().getColor(d.C0095d.cp_cont_i));
                    } else {
                        ((TextView) childAt).setTextColor(getResources().getColor(d.C0095d.white_alpha80));
                        textView = textView2;
                    }
                } else {
                    textView = textView2;
                }
                i2++;
                textView2 = textView;
            }
            if (this.gYf) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.gYe.getWidth()) / 2)) - RecordTabLayout.this.gYe.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.gYe, "translationX", RecordTabLayout.this.gYe.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.gYe.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.goK;
    }

    public void setListener(a aVar) {
        this.gYg = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.gYf = z;
        if (!this.gYf) {
            this.gYe.setVisibility(4);
        }
    }
}
