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
/* loaded from: classes22.dex */
public class RecordTabLayout extends LinearLayout {
    private int iuC;
    private boolean mLA;
    private a mLB;
    private LinearLayout mLy;
    private View mLz;

    /* loaded from: classes22.dex */
    public interface a {
        void ai(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.mLA = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLA = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLA = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.mLy = new LinearLayout(getContext());
        this.mLy.setOrientation(0);
        this.mLy.setGravity(17);
        addView(this.mLy, new ViewGroup.LayoutParams(-1, -2));
        this.mLz = new View(getContext());
        this.mLz.setBackgroundColor(getResources().getColor(R.color.cp_cont_a));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds18);
        addView(this.mLz, layoutParams);
    }

    public void bK(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.fontsize28));
        textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.iuC != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.mLB != null) {
                        RecordTabLayout.this.mLB.ai(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.mLy.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44);
        }
        this.mLy.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.iuC != i) {
            this.iuC = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.mLy.getChildCount()) {
                View childAt = this.mLy.getChildAt(i2);
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
            if (this.mLA) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.mLz.getWidth()) / 2)) - RecordTabLayout.this.mLz.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.mLz, "translationX", RecordTabLayout.this.mLz.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.mLz.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.iuC;
    }

    public void setListener(a aVar) {
        this.mLB = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.mLA = z;
        if (!this.mLA) {
            this.mLz.setVisibility(4);
        }
    }
}
