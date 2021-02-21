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
    private int jDP;
    private LinearLayout nRH;
    private View nRI;
    private boolean nRJ;
    private a nRK;

    /* loaded from: classes8.dex */
    public interface a {
        void ai(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.nRJ = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nRJ = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nRJ = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.nRH = new LinearLayout(getContext());
        this.nRH.setOrientation(0);
        this.nRH.setGravity(17);
        addView(this.nRH, new ViewGroup.LayoutParams(-1, -2));
        this.nRI = new View(getContext());
        this.nRI.setBackgroundColor(getResources().getColor(R.color.CAM_X0101));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds18);
        addView(this.nRI, layoutParams);
    }

    public void cf(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.fontsize28));
        textView.setTextColor(getResources().getColor(R.color.CAM_X0101));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.jDP != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.nRK != null) {
                        RecordTabLayout.this.nRK.ai(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.nRH.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44);
        }
        this.nRH.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.jDP != i) {
            this.jDP = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.nRH.getChildCount()) {
                View childAt = this.nRH.getChildAt(i2);
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
            if (this.nRJ) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.nRI.getWidth()) / 2)) - RecordTabLayout.this.nRI.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.nRI, "translationX", RecordTabLayout.this.nRI.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.nRI.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.jDP;
    }

    public void setListener(a aVar) {
        this.nRK = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.nRJ = z;
        if (!this.nRJ) {
            this.nRI.setVisibility(4);
        }
    }
}
