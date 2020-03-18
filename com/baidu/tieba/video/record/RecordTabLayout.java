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
    private LinearLayout kEc;
    private View kEd;
    private boolean kEe;
    private a kEf;
    private int mCurrentTab;

    /* loaded from: classes10.dex */
    public interface a {
        void onTabChoosed(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.kEe = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kEe = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kEe = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.kEc = new LinearLayout(getContext());
        this.kEc.setOrientation(0);
        this.kEc.setGravity(17);
        addView(this.kEc, new ViewGroup.LayoutParams(-1, -2));
        this.kEd = new View(getContext());
        this.kEd.setBackgroundColor(getResources().getColor(R.color.cp_cont_a));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds18);
        addView(this.kEd, layoutParams);
    }

    public void bf(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.fontsize28));
        textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.mCurrentTab != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.kEf != null) {
                        RecordTabLayout.this.kEf.onTabChoosed(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.kEc.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44);
        }
        this.kEc.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.mCurrentTab != i) {
            this.mCurrentTab = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.kEc.getChildCount()) {
                View childAt = this.kEc.getChildAt(i2);
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
            if (this.kEe) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.kEd.getWidth()) / 2)) - RecordTabLayout.this.kEd.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.kEd, "translationX", RecordTabLayout.this.kEd.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.kEd.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.mCurrentTab;
    }

    public void setListener(a aVar) {
        this.kEf = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.kEe = z;
        if (!this.kEe) {
            this.kEd.setVisibility(4);
        }
    }
}
