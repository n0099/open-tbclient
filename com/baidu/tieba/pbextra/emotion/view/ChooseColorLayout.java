package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener dRK;
    private int jQA;
    private int jQB;
    private int jQC;
    private int jQD;
    private a jQE;
    private int[] jQz;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes9.dex */
    public interface a {
        void Am(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dRK = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.jQD) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.jQD);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.jQD = intValue;
                    ChooseColorLayout.this.jQC = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.jQE != null) {
                        ChooseColorLayout.this.jQE.Am(ChooseColorLayout.this.jQC);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.jQz = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.jQA = (this.mWidth - (this.mPadding * 2)) / 8;
        this.jQB = (this.jQA - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.jQA, this.jQA);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.jQz.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.jQz[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.jQB);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.jQC = this.jQz[i];
                this.jQD = i;
            }
            chooseColorView.setOnClickListener(this.dRK);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.jQC;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.jQE = aVar;
    }
}
