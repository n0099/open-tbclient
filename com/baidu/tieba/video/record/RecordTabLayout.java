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
    private int fpO;
    private LinearLayout jcw;
    private View jcx;
    private boolean jcy;
    private a jcz;

    /* loaded from: classes5.dex */
    public interface a {
        void M(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.jcy = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jcy = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jcy = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.jcw = new LinearLayout(getContext());
        this.jcw.setOrientation(0);
        this.jcw.setGravity(17);
        addView(this.jcw, new ViewGroup.LayoutParams(-1, -2));
        this.jcx = new View(getContext());
        this.jcx.setBackgroundColor(getResources().getColor(d.C0277d.cp_btn_a));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.h(getContext(), d.e.ds44), com.baidu.adp.lib.util.l.h(getContext(), d.e.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds18);
        addView(this.jcx, layoutParams);
    }

    public void aH(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.h(getContext(), d.e.fontsize28));
        textView.setTextColor(getResources().getColor(d.C0277d.cp_btn_a));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.fpO != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.jcz != null) {
                        RecordTabLayout.this.jcz.M(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.jcw.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds44);
        }
        this.jcw.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.fpO != i) {
            this.fpO = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.jcw.getChildCount()) {
                View childAt = this.jcw.getChildAt(i2);
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
            if (this.jcy) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.jcx.getWidth()) / 2)) - RecordTabLayout.this.jcx.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.jcx, "translationX", RecordTabLayout.this.jcx.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.jcx.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.fpO;
    }

    public void setListener(a aVar) {
        this.jcz = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.jcy = z;
        if (!this.jcy) {
            this.jcx.setVisibility(4);
        }
    }
}
