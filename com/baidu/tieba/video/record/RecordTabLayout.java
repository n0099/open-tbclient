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
/* loaded from: classes17.dex */
public class RecordTabLayout extends LinearLayout {
    private int hYX;
    private LinearLayout mjI;
    private View mjJ;
    private boolean mjK;
    private a mjL;

    /* loaded from: classes17.dex */
    public interface a {
        void af(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.mjK = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mjK = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mjK = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.mjI = new LinearLayout(getContext());
        this.mjI.setOrientation(0);
        this.mjI.setGravity(17);
        addView(this.mjI, new ViewGroup.LayoutParams(-1, -2));
        this.mjJ = new View(getContext());
        this.mjJ.setBackgroundColor(getResources().getColor(R.color.cp_cont_a));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds18);
        addView(this.mjJ, layoutParams);
    }

    public void bJ(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.fontsize28));
        textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.hYX != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.mjL != null) {
                        RecordTabLayout.this.mjL.af(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.mjI.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44);
        }
        this.mjI.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.hYX != i) {
            this.hYX = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.mjI.getChildCount()) {
                View childAt = this.mjI.getChildAt(i2);
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
            if (this.mjK) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.mjJ.getWidth()) / 2)) - RecordTabLayout.this.mjJ.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.mjJ, "translationX", RecordTabLayout.this.mjJ.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.mjJ.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.hYX;
    }

    public void setListener(a aVar) {
        this.mjL = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.mjK = z;
        if (!this.mjK) {
            this.mjJ.setVisibility(4);
        }
    }
}
