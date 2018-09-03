package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener aGT;
    private int[] fRN;
    private int fRO;
    private int fRP;
    private int fRQ;
    private int fRR;
    private a fRS;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void rh(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGT = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.fRR) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.fRR);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.fRR = intValue;
                    ChooseColorLayout.this.fRQ = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.fRS != null) {
                        ChooseColorLayout.this.fRS.rh(ChooseColorLayout.this.fRQ);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.ah(getContext());
        this.fRN = getResources().getIntArray(f.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(f.e.ds24);
        this.fRO = (this.mWidth - (this.mPadding * 2)) / 8;
        this.fRP = (this.fRO - (getResources().getDimensionPixelSize(f.e.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fRO, this.fRO);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.fRN.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.fRN[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.fRP);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.fRQ = this.fRN[i];
                this.fRR = i;
            }
            chooseColorView.setOnClickListener(this.aGT);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(f.e.ds20));
    }

    public int getCurrentChooseColor() {
        return this.fRQ;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.fRS = aVar;
    }
}
