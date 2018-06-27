package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener aGU;
    private int[] fRK;
    private int fRL;
    private int fRM;
    private int fRN;
    private int fRO;
    private a fRP;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void rk(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGU = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.fRO) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.fRO);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.fRO = intValue;
                    ChooseColorLayout.this.fRN = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.fRP != null) {
                        ChooseColorLayout.this.fRP.rk(ChooseColorLayout.this.fRN);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.ah(getContext());
        this.fRK = getResources().getIntArray(d.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(d.e.ds24);
        this.fRL = (this.mWidth - (this.mPadding * 2)) / 8;
        this.fRM = (this.fRL - (getResources().getDimensionPixelSize(d.e.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fRL, this.fRL);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.fRK.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.fRK[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.fRM);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.fRN = this.fRK[i];
                this.fRO = i;
            }
            chooseColorView.setOnClickListener(this.aGU);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(d.e.ds20));
    }

    public int getCurrentChooseColor() {
        return this.fRN;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.fRP = aVar;
    }
}
