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
    private LinearLayout kBm;
    private View kBn;
    private boolean kBo;
    private a kBp;
    private int mCurrentTab;

    /* loaded from: classes8.dex */
    public interface a {
        void onTabChoosed(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.kBo = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kBo = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kBo = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.kBm = new LinearLayout(getContext());
        this.kBm.setOrientation(0);
        this.kBm.setGravity(17);
        addView(this.kBm, new ViewGroup.LayoutParams(-1, -2));
        this.kBn = new View(getContext());
        this.kBn.setBackgroundColor(getResources().getColor(R.color.cp_cont_a));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds18);
        addView(this.kBn, layoutParams);
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
                    if (RecordTabLayout.this.kBp != null) {
                        RecordTabLayout.this.kBp.onTabChoosed(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.kBm.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44);
        }
        this.kBm.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.mCurrentTab != i) {
            this.mCurrentTab = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.kBm.getChildCount()) {
                View childAt = this.kBm.getChildAt(i2);
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
            if (this.kBo) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.kBn.getWidth()) / 2)) - RecordTabLayout.this.kBn.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.kBn, "translationX", RecordTabLayout.this.kBn.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.kBn.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.mCurrentTab;
    }

    public void setListener(a aVar) {
        this.kBp = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.kBo = z;
        if (!this.kBo) {
            this.kBn.setVisibility(4);
        }
    }
}
