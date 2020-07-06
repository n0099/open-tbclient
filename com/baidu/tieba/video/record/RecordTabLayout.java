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
/* loaded from: classes10.dex */
public class RecordTabLayout extends LinearLayout {
    private int hSW;
    private LinearLayout mcq;
    private View mcr;
    private boolean mcs;
    private a mct;

    /* loaded from: classes10.dex */
    public interface a {
        void ag(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.mcs = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mcs = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mcs = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.mcq = new LinearLayout(getContext());
        this.mcq.setOrientation(0);
        this.mcq.setGravity(17);
        addView(this.mcq, new ViewGroup.LayoutParams(-1, -2));
        this.mcr = new View(getContext());
        this.mcr.setBackgroundColor(getResources().getColor(R.color.cp_cont_a));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds18);
        addView(this.mcr, layoutParams);
    }

    public void bI(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.fontsize28));
        textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.hSW != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.mct != null) {
                        RecordTabLayout.this.mct.ag(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.mcq.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44);
        }
        this.mcq.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.hSW != i) {
            this.hSW = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.mcq.getChildCount()) {
                View childAt = this.mcq.getChildAt(i2);
                if (childAt instanceof TextView) {
                    Object tag = childAt.getTag();
                    if ((tag instanceof Integer) && ((Integer) tag).intValue() == i) {
                        textView = (TextView) childAt;
                        textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
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
            if (this.mcs) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.mcr.getWidth()) / 2)) - RecordTabLayout.this.mcr.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.mcr, "translationX", RecordTabLayout.this.mcr.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.mcr.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.hSW;
    }

    public void setListener(a aVar) {
        this.mct = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.mcs = z;
        if (!this.mcs) {
            this.mcr.setVisibility(4);
        }
    }
}
