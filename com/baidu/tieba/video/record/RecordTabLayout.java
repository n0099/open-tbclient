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
    private int jqf;
    private LinearLayout nIM;
    private View nIN;
    private boolean nIO;
    private a nIP;

    /* loaded from: classes23.dex */
    public interface a {
        void ak(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.nIO = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nIO = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nIO = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.nIM = new LinearLayout(getContext());
        this.nIM.setOrientation(0);
        this.nIM.setGravity(17);
        addView(this.nIM, new ViewGroup.LayoutParams(-1, -2));
        this.nIN = new View(getContext());
        this.nIN.setBackgroundColor(getResources().getColor(R.color.CAM_X0101));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds18);
        addView(this.nIN, layoutParams);
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
                if (RecordTabLayout.this.jqf != i) {
                    RecordTabLayout.this.setCurrentTab(i, true);
                    if (RecordTabLayout.this.nIP != null) {
                        RecordTabLayout.this.nIP.ak(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.nIM.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds44);
        }
        this.nIM.addView(textView, layoutParams);
    }

    public void setCurrentTab(int i, final boolean z) {
        TextView textView;
        if (this.jqf != i) {
            this.jqf = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.nIM.getChildCount()) {
                View childAt = this.nIM.getChildAt(i2);
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
            if (this.nIO) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.nIN.getWidth()) / 2)) - RecordTabLayout.this.nIN.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.nIN, "translationX", RecordTabLayout.this.nIN.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.nIN.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.jqf;
    }

    public void setListener(a aVar) {
        this.nIP = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.nIO = z;
        if (!this.nIO) {
            this.nIN.setVisibility(4);
        }
    }
}
