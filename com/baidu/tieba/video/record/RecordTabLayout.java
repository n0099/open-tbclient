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
    private int fKV;
    private LinearLayout jBs;
    private View jBt;
    private boolean jBu;
    private a jBv;

    /* loaded from: classes5.dex */
    public interface a {
        void T(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.jBu = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jBu = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jBu = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.jBs = new LinearLayout(getContext());
        this.jBs.setOrientation(0);
        this.jBs.setGravity(17);
        addView(this.jBs, new ViewGroup.LayoutParams(-1, -2));
        this.jBt = new View(getContext());
        this.jBt.setBackgroundColor(getResources().getColor(R.color.cp_btn_a));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds44), com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds18);
        addView(this.jBt, layoutParams);
    }

    public void aM(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.fontsize28));
        textView.setTextColor(getResources().getColor(R.color.cp_btn_a));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.fKV != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.jBv != null) {
                        RecordTabLayout.this.jBv.T(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.jBs.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds44);
        }
        this.jBs.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.fKV != i) {
            this.fKV = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.jBs.getChildCount()) {
                View childAt = this.jBs.getChildAt(i2);
                if (childAt instanceof TextView) {
                    Object tag = childAt.getTag();
                    if ((tag instanceof Integer) && ((Integer) tag).intValue() == i) {
                        textView = (TextView) childAt;
                        textView.setTextColor(getResources().getColor(R.color.cp_btn_a));
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
            if (this.jBu) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.jBt.getWidth()) / 2)) - RecordTabLayout.this.jBt.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.jBt, "translationX", RecordTabLayout.this.jBt.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.jBt.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.fKV;
    }

    public void setListener(a aVar) {
        this.jBv = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.jBu = z;
        if (!this.jBu) {
            this.jBt.setVisibility(4);
        }
    }
}
