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
/* loaded from: classes7.dex */
public class RecordTabLayout extends LinearLayout {
    private int jxW;
    private LinearLayout nHA;
    private View nHB;
    private boolean nHC;
    private a nHD;

    /* loaded from: classes7.dex */
    public interface a {
        void ai(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.nHC = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nHC = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nHC = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.nHA = new LinearLayout(getContext());
        this.nHA.setOrientation(0);
        this.nHA.setGravity(17);
        addView(this.nHA, new ViewGroup.LayoutParams(-1, -2));
        this.nHB = new View(getContext());
        this.nHB.setBackgroundColor(getResources().getColor(R.color.CAM_X0101));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds18);
        addView(this.nHB, layoutParams);
    }

    public void bY(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.fontsize28));
        textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.jxW != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.nHD != null) {
                        RecordTabLayout.this.nHD.ai(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.nHA.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44);
        }
        this.nHA.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.jxW != i) {
            this.jxW = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.nHA.getChildCount()) {
                View childAt = this.nHA.getChildAt(i2);
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
            if (this.nHC) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.nHB.getWidth()) / 2)) - RecordTabLayout.this.nHB.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.nHB, "translationX", RecordTabLayout.this.nHB.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.nHB.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.jxW;
    }

    public void setListener(a aVar) {
        this.nHD = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.nHC = z;
        if (!this.nHC) {
            this.nHB.setVisibility(4);
        }
    }
}
