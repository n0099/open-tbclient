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
/* loaded from: classes8.dex */
public class RecordTabLayout extends LinearLayout {
    private LinearLayout kBh;
    private View kBi;
    private boolean kBj;
    private a kBk;
    private int mCurrentTab;

    /* loaded from: classes8.dex */
    public interface a {
        void onTabChoosed(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.kBj = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kBj = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kBj = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.kBh = new LinearLayout(getContext());
        this.kBh.setOrientation(0);
        this.kBh.setGravity(17);
        addView(this.kBh, new ViewGroup.LayoutParams(-1, -2));
        this.kBi = new View(getContext());
        this.kBi.setBackgroundColor(getResources().getColor(R.color.cp_cont_a));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds18);
        addView(this.kBi, layoutParams);
    }

    public void bg(final int i, String str) {
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
                    if (RecordTabLayout.this.kBk != null) {
                        RecordTabLayout.this.kBk.onTabChoosed(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.kBh.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44);
        }
        this.kBh.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.mCurrentTab != i) {
            this.mCurrentTab = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.kBh.getChildCount()) {
                View childAt = this.kBh.getChildAt(i2);
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
            if (this.kBj) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.kBi.getWidth()) / 2)) - RecordTabLayout.this.kBi.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.kBi, "translationX", RecordTabLayout.this.kBi.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.kBi.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.mCurrentTab;
    }

    public void setListener(a aVar) {
        this.kBk = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.kBj = z;
        if (!this.kBj) {
            this.kBi.setVisibility(4);
        }
    }
}
