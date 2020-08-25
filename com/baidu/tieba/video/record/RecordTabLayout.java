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
    private int inf;
    private LinearLayout mBr;
    private View mBs;
    private boolean mBt;
    private a mBu;

    /* loaded from: classes17.dex */
    public interface a {
        void ah(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.mBt = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBt = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBt = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.mBr = new LinearLayout(getContext());
        this.mBr.setOrientation(0);
        this.mBr.setGravity(17);
        addView(this.mBr, new ViewGroup.LayoutParams(-1, -2));
        this.mBs = new View(getContext());
        this.mBs.setBackgroundColor(getResources().getColor(R.color.cp_cont_a));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds18);
        addView(this.mBs, layoutParams);
    }

    public void bH(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.fontsize28));
        textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.inf != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.mBu != null) {
                        RecordTabLayout.this.mBu.ah(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.mBr.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44);
        }
        this.mBr.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.inf != i) {
            this.inf = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.mBr.getChildCount()) {
                View childAt = this.mBr.getChildAt(i2);
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
            if (this.mBt) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.mBs.getWidth()) / 2)) - RecordTabLayout.this.mBs.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.mBs, "translationX", RecordTabLayout.this.mBs.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.mBs.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.inf;
    }

    public void setListener(a aVar) {
        this.mBu = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.mBt = z;
        if (!this.mBt) {
            this.mBs.setVisibility(4);
        }
    }
}
