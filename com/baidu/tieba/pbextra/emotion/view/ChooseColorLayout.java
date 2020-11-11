package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener fii;
    private int[] lSM;
    private int lSN;
    private int lSO;
    private int lSP;
    private int lSQ;
    private a lSR;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes22.dex */
    public interface a {
        void GI(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fii = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.lSQ) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.lSQ);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.lSQ = intValue;
                    ChooseColorLayout.this.lSP = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.lSR != null) {
                        ChooseColorLayout.this.lSR.GI(ChooseColorLayout.this.lSP);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.lSM = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.lSN = (this.mWidth - (this.mPadding * 2)) / 8;
        this.lSO = (this.lSN - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.lSN, this.lSN);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.lSM.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.lSM[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.lSO);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.lSP = this.lSM[i];
                this.lSQ = i;
            }
            chooseColorView.setOnClickListener(this.fii);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.lSP;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.lSR = aVar;
    }
}
