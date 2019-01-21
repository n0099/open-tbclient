package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener aTJ;
    private int[] gsO;
    private int gsP;
    private int gsQ;
    private int gsR;
    private int gsS;
    private a gsT;
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
        this.aTJ = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.gsS) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.gsS);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.gsS = intValue;
                    ChooseColorLayout.this.gsR = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.gsT != null) {
                        ChooseColorLayout.this.gsT.tf(ChooseColorLayout.this.gsR);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.aO(getContext());
        this.gsO = getResources().getIntArray(e.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(e.C0210e.ds24);
        this.gsP = (this.mWidth - (this.mPadding * 2)) / 8;
        this.gsQ = (this.gsP - (getResources().getDimensionPixelSize(e.C0210e.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.gsP, this.gsP);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.gsO.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.gsO[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.gsQ);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.gsR = this.gsO[i];
                this.gsS = i;
            }
            chooseColorView.setOnClickListener(this.aTJ);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(e.C0210e.ds20));
    }

    public int getCurrentChooseColor() {
        return this.gsR;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.gsT = aVar;
    }
}
