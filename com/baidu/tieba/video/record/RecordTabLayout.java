package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class RecordTabLayout extends LinearLayout {
    private LinearLayout gXY;
    private View gXZ;
    private boolean gYa;
    private a gYb;
    private int goF;

    /* loaded from: classes2.dex */
    public interface a {
        void E(int i, boolean z);
    }

    public RecordTabLayout(Context context) {
        super(context);
        this.gYa = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gYa = true;
        initView();
    }

    public RecordTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gYa = true;
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.gXY = new LinearLayout(getContext());
        this.gXY.setOrientation(0);
        this.gXY.setGravity(17);
        addView(this.gXY, new ViewGroup.LayoutParams(-1, -2));
        this.gXZ = new View(getContext());
        this.gXZ.setBackgroundColor(getResources().getColor(d.C0096d.cp_cont_i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.f(getContext(), d.e.ds44), com.baidu.adp.lib.util.l.f(getContext(), d.e.ds4));
        layoutParams.topMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds18);
        addView(this.gXZ, layoutParams);
    }

    public void al(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, com.baidu.adp.lib.util.l.f(getContext(), d.e.fontsize28));
        textView.setTextColor(getResources().getColor(d.C0096d.cp_cont_i));
        textView.setText(str);
        textView.setTag(Integer.valueOf(i));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.RecordTabLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RecordTabLayout.this.goF != i) {
                    RecordTabLayout.this.q(i, true);
                    if (RecordTabLayout.this.gYb != null) {
                        RecordTabLayout.this.gYb.E(i, true);
                    }
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.gXY.getChildCount() != 0) {
            layoutParams.leftMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds44);
        }
        this.gXY.addView(textView, layoutParams);
    }

    public void q(int i, final boolean z) {
        TextView textView;
        if (this.goF != i) {
            this.goF = i;
            final TextView textView2 = null;
            int i2 = 0;
            while (i2 < this.gXY.getChildCount()) {
                View childAt = this.gXY.getChildAt(i2);
                if (childAt instanceof TextView) {
                    Object tag = childAt.getTag();
                    if ((tag instanceof Integer) && ((Integer) tag).intValue() == i) {
                        textView = (TextView) childAt;
                        textView.setTextColor(getResources().getColor(d.C0096d.cp_cont_i));
                    } else {
                        ((TextView) childAt).setTextColor(getResources().getColor(d.C0096d.white_alpha80));
                        textView = textView2;
                    }
                } else {
                    textView = textView2;
                }
                i2++;
                textView2 = textView;
            }
            if (this.gYa) {
                textView2.post(new Runnable() { // from class: com.baidu.tieba.video.record.RecordTabLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        float x = (textView2.getX() + ((textView2.getWidth() - RecordTabLayout.this.gXZ.getWidth()) / 2)) - RecordTabLayout.this.gXZ.getLeft();
                        if (z) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(RecordTabLayout.this.gXZ, "translationX", RecordTabLayout.this.gXZ.getTranslationX(), x);
                            ofFloat.setDuration(500L);
                            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
                            ofFloat.start();
                            return;
                        }
                        RecordTabLayout.this.gXZ.setTranslationX(x);
                    }
                });
            }
        }
    }

    public int getCurrentTab() {
        return this.goF;
    }

    public void setListener(a aVar) {
        this.gYb = aVar;
    }

    public void setShowIndicator(boolean z) {
        this.gYa = z;
        if (!this.gYa) {
            this.gXZ.setVisibility(4);
        }
    }
}
