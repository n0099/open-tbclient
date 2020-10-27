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
    private int iVR;
    private LinearLayout nnE;
    private View nnF;
    private boolean nnG;
    private a nnH;

    /* loaded from: classes23.dex */
    public interface a {
        void ak(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.nnG = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nnG = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nnG = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.nnE = new LinearLayout(getContext());
        this.nnE.setOrientation(0);
        this.nnE.setGravity(17);
        addView(this.nnE, new ViewGroup.LayoutParams(-1, -2));
        this.nnF = new View(getContext());
        this.nnF.setBackgroundColor(getResources().getColor(R.color.cp_cont_a));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds18);
        addView(this.nnF, layoutParams);
    }

    public void bV(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.fontsize28));
        textView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.iVR != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.nnH != null) {
                        RecordTabLayout.this.nnH.ak(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.nnE.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44);
        }
        this.nnE.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.iVR != i) {
            this.iVR = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.nnE.getChildCount()) {
                View childAt = this.nnE.getChildAt(i2);
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
            if (this.nnG) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.nnF.getWidth()) / 2)) - RecordTabLayout.this.nnF.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.nnF, "translationX", RecordTabLayout.this.nnF.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.nnF.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.iVR;
    }

    public void setListener(a aVar) {
        this.nnH = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.nnG = z;
        if (!this.nnG) {
            this.nnF.setVisibility(4);
        }
    }
}
