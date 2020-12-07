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
    private int jqd;
    private LinearLayout nIK;
    private View nIL;
    private boolean nIM;
    private a nIN;

    /* loaded from: classes23.dex */
    public interface a {
        void ak(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.nIM = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nIM = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nIM = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.nIK = new LinearLayout(getContext());
        this.nIK.setOrientation(0);
        this.nIK.setGravity(17);
        addView(this.nIK, new ViewGroup.LayoutParams(-1, -2));
        this.nIL = new View(getContext());
        this.nIL.setBackgroundColor(getResources().getColor(R.color.CAM_X0101));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds18);
        addView(this.nIL, layoutParams);
    }

    public void bX(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.fontsize28));
        textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.jqd != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.nIN != null) {
                        RecordTabLayout.this.nIN.ak(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.nIK.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44);
        }
        this.nIK.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.jqd != i) {
            this.jqd = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.nIK.getChildCount()) {
                View childAt = this.nIK.getChildAt(i2);
                if (childAt instanceof TextView) {
                    Object tag = childAt.getTag();
                    if ((tag instanceof Integer) && ((Integer) tag).intValue() == i) {
                        textView = (TextView) childAt;
                        textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
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
            if (this.nIM) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.nIL.getWidth()) / 2)) - RecordTabLayout.this.nIL.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.nIL, "translationX", RecordTabLayout.this.nIL.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.nIL.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.jqd;
    }

    public void setListener(a aVar) {
        this.nIN = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.nIM = z;
        if (!this.nIM) {
            this.nIL.setVisibility(4);
        }
    }
}
