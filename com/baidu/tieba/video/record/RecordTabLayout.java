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
    private int dRY;
    private LinearLayout hwr;
    private View hws;
    private boolean hwt;
    private a hwu;

    /* loaded from: classes2.dex */
    public interface a {
        void V(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.hwt = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hwt = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hwt = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.hwr = new LinearLayout(getContext());
        this.hwr.setOrientation(0);
        this.hwr.setGravity(17);
        addView(this.hwr, new ViewGroup.LayoutParams(-1, -2));
        this.hws = new View(getContext());
        this.hws.setBackgroundColor(getResources().getColor(d.C0140d.cp_cont_i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.t(getContext(), d.e.ds44), com.baidu.adp.lib.util.l.t(getContext(), d.e.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds18);
        addView(this.hws, layoutParams);
    }

    public void al(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.t(getContext(), d.e.fontsize28));
        textView.setTextColor(getResources().getColor(d.C0140d.cp_cont_i));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.dRY != i) {
                    RecordTabLayout.this.H(i, true);
                    if (RecordTabLayout.this.hwu != null) {
                        RecordTabLayout.this.hwu.V(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.hwr.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds44);
        }
        this.hwr.addView(textView, layoutParams);
    }

    public void H(int i, final boolean z) {
        TextView textView;
        if (this.dRY != i) {
            this.dRY = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.hwr.getChildCount()) {
                View childAt = this.hwr.getChildAt(i2);
                if (childAt instanceof TextView) {
                    Object tag = childAt.getTag();
                    if ((tag instanceof Integer) && ((Integer) tag).intValue() == i) {
                        textView = (TextView) childAt;
                        textView.setTextColor(getResources().getColor(d.C0140d.cp_cont_i));
                    } else {
                        ((TextView) childAt).setTextColor(getResources().getColor(d.C0140d.white_alpha80));
                        textView = textView2;
                    }
                } else {
                    textView = textView2;
                }
                i2++;
                textView2 = textView;
            }
            if (this.hwt) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.hws.getWidth()) / 2)) - RecordTabLayout.this.hws.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.hws, "translationX", RecordTabLayout.this.hws.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.hws.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.dRY;
    }

    public void setListener(a aVar) {
        this.hwu = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.hwt = z;
        if (!this.hwt) {
            this.hws.setVisibility(4);
        }
    }
}
