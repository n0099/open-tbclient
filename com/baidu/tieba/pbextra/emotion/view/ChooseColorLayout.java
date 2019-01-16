package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener aTI;
    private int[] gsN;
    private int gsO;
    private int gsP;
    private int gsQ;
    private int gsR;
    private a gsS;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void tf(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aTI = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.gsR) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.gsR);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.gsR = intValue;
                    ChooseColorLayout.this.gsQ = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.gsS != null) {
                        ChooseColorLayout.this.gsS.tf(ChooseColorLayout.this.gsQ);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.aO(getContext());
        this.gsN = getResources().getIntArray(e.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(e.C0210e.ds24);
        this.gsO = (this.mWidth - (this.mPadding * 2)) / 8;
        this.gsP = (this.gsO - (getResources().getDimensionPixelSize(e.C0210e.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.gsO, this.gsO);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.gsN.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.gsN[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.gsP);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.gsQ = this.gsN[i];
                this.gsR = i;
            }
            chooseColorView.setOnClickListener(this.aTI);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(e.C0210e.ds20));
    }

    public int getCurrentChooseColor() {
        return this.gsQ;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.gsS = aVar;
    }
}
