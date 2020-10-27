package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener fcr;
    private int[] lMQ;
    private int lMR;
    private int lMS;
    private int lMT;
    private int lMU;
    private a lMV;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes22.dex */
    public interface a {
        void Gv(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fcr = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.lMU) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.lMU);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.lMU = intValue;
                    ChooseColorLayout.this.lMT = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.lMV != null) {
                        ChooseColorLayout.this.lMV.Gv(ChooseColorLayout.this.lMT);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.lMQ = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.lMR = (this.mWidth - (this.mPadding * 2)) / 8;
        this.lMS = (this.lMR - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.lMR, this.lMR);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.lMQ.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.lMQ[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.lMS);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.lMT = this.lMQ[i];
                this.lMU = i;
            }
            chooseColorView.setOnClickListener(this.fcr);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.lMT;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.lMV = aVar;
    }
}
