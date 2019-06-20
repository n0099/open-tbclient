package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener ckI;
    private int[] iaO;
    private int iaP;
    private int iaQ;
    private int iaR;
    private int iaS;
    private a iaT;
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
        this.ckI = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.iaS) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.iaS);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.iaS = intValue;
                    ChooseColorLayout.this.iaR = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.iaT != null) {
                        ChooseColorLayout.this.iaT.xR(ChooseColorLayout.this.iaR);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.af(getContext());
        this.iaO = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.iaP = (this.mWidth - (this.mPadding * 2)) / 8;
        this.iaQ = (this.iaP - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.iaP, this.iaP);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.iaO.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.iaO[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.iaQ);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.iaR = this.iaO[i];
                this.iaS = i;
            }
            chooseColorView.setOnClickListener(this.ckI);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.iaR;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.iaT = aVar;
    }
}
