package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener ckH;
    private int[] iaK;
    private int iaL;
    private int iaM;
    private int iaN;
    private int iaO;
    private a iaP;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void xR(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ckH = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.iaO) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.iaO);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.iaO = intValue;
                    ChooseColorLayout.this.iaN = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.iaP != null) {
                        ChooseColorLayout.this.iaP.xR(ChooseColorLayout.this.iaN);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.af(getContext());
        this.iaK = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.iaL = (this.mWidth - (this.mPadding * 2)) / 8;
        this.iaM = (this.iaL - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.iaL, this.iaL);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.iaK.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.iaK[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.iaM);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.iaN = this.iaK[i];
                this.iaO = i;
            }
            chooseColorView.setOnClickListener(this.ckH);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.iaN;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.iaP = aVar;
    }
}
