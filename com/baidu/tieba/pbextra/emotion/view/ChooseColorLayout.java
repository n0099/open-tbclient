package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener eFG;
    private int[] lck;
    private int lcl;
    private int lcm;
    private int lcn;
    private int lco;
    private a lcp;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes16.dex */
    public interface a {
        void EV(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eFG = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.lco) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.lco);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.lco = intValue;
                    ChooseColorLayout.this.lcn = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.lcp != null) {
                        ChooseColorLayout.this.lcp.EV(ChooseColorLayout.this.lcn);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.lck = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.lcl = (this.mWidth - (this.mPadding * 2)) / 8;
        this.lcm = (this.lcl - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.lcl, this.lcl);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.lck.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.lck[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.lcm);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.lcn = this.lck[i];
                this.lco = i;
            }
            chooseColorView.setOnClickListener(this.eFG);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.lcn;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.lcp = aVar;
    }
}
