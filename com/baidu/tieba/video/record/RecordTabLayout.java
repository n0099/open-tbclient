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
/* loaded from: classes23.dex */
public class RecordTabLayout extends LinearLayout {
    private int jbO;
    private LinearLayout ntB;
    private View ntC;
    private boolean ntD;
    private a ntE;

    /* loaded from: classes23.dex */
    public interface a {
        void ak(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.ntD = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ntD = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ntD = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.ntB = new LinearLayout(getContext());
        this.ntB.setOrientation(0);
        this.ntB.setGravity(17);
        addView(this.ntB, new ViewGroup.LayoutParams(-1, -2));
        this.ntC = new View(getContext());
        this.ntC.setBackgroundColor(getResources().getColor(R.color.cp_cont_a));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds18);
        addView(this.ntC, layoutParams);
    }

    public void bZ(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.fontsize28));
        textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.jbO != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.ntE != null) {
                        RecordTabLayout.this.ntE.ak(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.ntB.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44);
        }
        this.ntB.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.jbO != i) {
            this.jbO = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.ntB.getChildCount()) {
                View childAt = this.ntB.getChildAt(i2);
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
            if (this.ntD) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.ntC.getWidth()) / 2)) - RecordTabLayout.this.ntC.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.ntC, "translationX", RecordTabLayout.this.ntC.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.ntC.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.jbO;
    }

    public void setListener(a aVar) {
        this.ntE = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.ntD = z;
        if (!this.ntD) {
            this.ntC.setVisibility(4);
        }
    }
}
