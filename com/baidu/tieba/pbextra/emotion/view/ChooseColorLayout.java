package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener aOJ;
    private int[] ggE;
    private int ggF;
    private int ggG;
    private int ggH;
    private int ggI;
    private a ggJ;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void sb(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOJ = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.ggI) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.ggI);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.ggI = intValue;
                    ChooseColorLayout.this.ggH = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.ggJ != null) {
                        ChooseColorLayout.this.ggJ.sb(ChooseColorLayout.this.ggH);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.aO(getContext());
        this.ggE = getResources().getIntArray(e.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(e.C0175e.ds24);
        this.ggF = (this.mWidth - (this.mPadding * 2)) / 8;
        this.ggG = (this.ggF - (getResources().getDimensionPixelSize(e.C0175e.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ggF, this.ggF);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.ggE.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.ggE[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.ggG);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.ggH = this.ggE[i];
                this.ggI = i;
            }
            chooseColorView.setOnClickListener(this.aOJ);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(e.C0175e.ds20));
    }

    public int getCurrentChooseColor() {
        return this.ggH;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.ggJ = aVar;
    }
}
