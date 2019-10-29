package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener czV;
    private int[] iiR;
    private int iiS;
    private int iiT;
    private int iiU;
    private int iiV;
    private a iiW;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void xg(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.czV = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.iiV) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.iiV);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.iiV = intValue;
                    ChooseColorLayout.this.iiU = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.iiW != null) {
                        ChooseColorLayout.this.iiW.xg(ChooseColorLayout.this.iiU);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.iiR = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.iiS = (this.mWidth - (this.mPadding * 2)) / 8;
        this.iiT = (this.iiS - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.iiS, this.iiS);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.iiR.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.iiR[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.iiT);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.iiU = this.iiR[i];
                this.iiV = i;
            }
            chooseColorView.setOnClickListener(this.czV);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.iiU;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.iiW = aVar;
    }
}
