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
/* loaded from: classes5.dex */
public class RecordTabLayout extends LinearLayout {
    private int fMR;
    private LinearLayout jEM;
    private View jEN;
    private boolean jEO;
    private a jEP;

    /* loaded from: classes5.dex */
    public interface a {
        void S(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.jEO = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jEO = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jEO = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.jEM = new LinearLayout(getContext());
        this.jEM.setOrientation(0);
        this.jEM.setGravity(17);
        addView(this.jEM, new ViewGroup.LayoutParams(-1, -2));
        this.jEN = new View(getContext());
        this.jEN.setBackgroundColor(getResources().getColor(R.color.cp_cont_a));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds18);
        addView(this.jEN, layoutParams);
    }

    public void aN(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.fontsize28));
        textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.fMR != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.jEP != null) {
                        RecordTabLayout.this.jEP.S(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.jEM.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44);
        }
        this.jEM.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.fMR != i) {
            this.fMR = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.jEM.getChildCount()) {
                View childAt = this.jEM.getChildAt(i2);
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
            if (this.jEO) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.jEN.getWidth()) / 2)) - RecordTabLayout.this.jEN.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.jEN, "translationX", RecordTabLayout.this.jEN.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.jEN.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.fMR;
    }

    public void setListener(a aVar) {
        this.jEP = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.jEO = z;
        if (!this.jEO) {
            this.jEN.setVisibility(4);
        }
    }
}
