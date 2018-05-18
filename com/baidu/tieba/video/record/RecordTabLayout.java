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
    private int dnd;
    private LinearLayout gSL;
    private View gSM;
    private boolean gSN;
    private a gSO;

    /* loaded from: classes2.dex */
    public interface a {
        void G(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.gSN = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gSN = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gSN = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.gSL = new LinearLayout(getContext());
        this.gSL.setOrientation(0);
        this.gSL.setGravity(17);
        addView(this.gSL, new ViewGroup.LayoutParams(-1, -2));
        this.gSM = new View(getContext());
        this.gSM.setBackgroundColor(getResources().getColor(d.C0126d.cp_cont_i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.e(getContext(), d.e.ds44), com.baidu.adp.lib.util.l.e(getContext(), d.e.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds18);
        addView(this.gSM, layoutParams);
    }

    public void ar(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.e(getContext(), d.e.fontsize28));
        textView.setTextColor(getResources().getColor(d.C0126d.cp_cont_i));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (RecordTabLayout.this.dnd != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.gSO != null) {
                        RecordTabLayout.this.gSO.G(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.gSL.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds44);
        }
        this.gSL.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.dnd != i) {
            this.dnd = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.gSL.getChildCount()) {
                View childAt = this.gSL.getChildAt(i2);
                if (childAt instanceof TextView) {
                    Object tag = childAt.getTag();
                    if ((tag instanceof Integer) && ((Integer) tag).intValue() == i) {
                        textView = (TextView) childAt;
                        textView.setTextColor(getResources().getColor(d.C0126d.cp_cont_i));
                    } else {
                        ((TextView) childAt).setTextColor(getResources().getColor(d.C0126d.white_alpha80));
                        textView = textView2;
                    }
                } else {
                    textView = textView2;
                }
                i2++;
                textView2 = textView;
            }
            if (this.gSN) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.gSM.getWidth()) / 2)) - RecordTabLayout.this.gSM.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.gSM, "translationX", RecordTabLayout.this.gSM.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.gSM.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.dnd;
    }

    public void setListener(a aVar) {
        this.gSO = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.gSN = z;
        if (!this.gSN) {
            this.gSM.setVisibility(4);
        }
    }
}
