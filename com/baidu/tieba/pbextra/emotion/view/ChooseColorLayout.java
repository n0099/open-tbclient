package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener bmd;
    private int[] ggI;
    private int ggJ;
    private int ggK;
    private int ggL;
    private int ggM;
    private a ggN;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void tt(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bmd = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof com.baidu.tieba.pbextra.emotion.view.a) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.ggM) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.ggM);
                    if (childAt instanceof com.baidu.tieba.pbextra.emotion.view.a) {
                        ((com.baidu.tieba.pbextra.emotion.view.a) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.ggM = intValue;
                    ChooseColorLayout.this.ggL = ((com.baidu.tieba.pbextra.emotion.view.a) view).getChooseColor();
                    ((com.baidu.tieba.pbextra.emotion.view.a) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.ggN != null) {
                        ChooseColorLayout.this.ggN.tt(ChooseColorLayout.this.ggL);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.ao(getContext());
        this.ggI = getResources().getIntArray(d.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(d.e.ds24);
        this.ggJ = (this.mWidth - (this.mPadding * 2)) / 8;
        this.ggK = (this.ggJ - (getResources().getDimensionPixelSize(d.e.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ggJ, this.ggJ);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.ggI.length; i++) {
            com.baidu.tieba.pbextra.emotion.view.a aVar = new com.baidu.tieba.pbextra.emotion.view.a(getContext());
            aVar.setChooseColor(this.ggI[i]);
            aVar.setTag(Integer.valueOf(i));
            aVar.setRadius(this.ggK);
            if (i == 0) {
                aVar.setIsChooseView(true);
                this.ggL = this.ggI[i];
                this.ggM = i;
            }
            aVar.setOnClickListener(this.bmd);
            addView(aVar, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(d.e.ds20));
    }

    public int getCurrentChooseColor() {
        return this.ggL;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.ggN = aVar;
    }
}
