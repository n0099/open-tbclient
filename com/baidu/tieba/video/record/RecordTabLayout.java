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
    private LinearLayout jck;
    private View jcl;
    private boolean jcm;
    private a jcn;

    /* loaded from: classes5.dex */
    public interface a {
        void M(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.jcm = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jcm = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jcm = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.jck = new LinearLayout(getContext());
        this.jck.setOrientation(0);
        this.jck.setGravity(17);
        addView(this.jck, new ViewGroup.LayoutParams(-1, -2));
        this.jcl = new View(getContext());
        this.jcl.setBackgroundColor(getResources().getColor(d.C0277d.cp_btn_a));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.h(getContext(), d.e.ds44), com.baidu.adp.lib.util.l.h(getContext(), d.e.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds18);
        addView(this.jcl, layoutParams);
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
                    if (RecordTabLayout.this.jcn != null) {
                        RecordTabLayout.this.jcn.M(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.jck.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds44);
        }
        this.jck.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.fpA != i) {
            this.fpA = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.jck.getChildCount()) {
                View childAt = this.jck.getChildAt(i2);
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
            if (this.jcm) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.jcl.getWidth()) / 2)) - RecordTabLayout.this.jcl.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.jcl, "translationX", RecordTabLayout.this.jcl.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.jcl.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.fpA;
    }

    public void setListener(a aVar) {
        this.jcn = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.jcm = z;
        if (!this.jcm) {
            this.jcl.setVisibility(4);
        }
    }
}
