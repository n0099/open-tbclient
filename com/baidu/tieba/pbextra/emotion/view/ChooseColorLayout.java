package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener blT;
    private int[] ggN;
    private int ggO;
    private int ggP;
    private int ggQ;
    private int ggR;
    private a ggS;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void tu(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.blT = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof com.baidu.tieba.pbextra.emotion.view.a) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.ggR) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.ggR);
                    if (childAt instanceof com.baidu.tieba.pbextra.emotion.view.a) {
                        ((com.baidu.tieba.pbextra.emotion.view.a) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.ggR = intValue;
                    ChooseColorLayout.this.ggQ = ((com.baidu.tieba.pbextra.emotion.view.a) view).getChooseColor();
                    ((com.baidu.tieba.pbextra.emotion.view.a) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.ggS != null) {
                        ChooseColorLayout.this.ggS.tu(ChooseColorLayout.this.ggQ);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.ao(getContext());
        this.ggN = getResources().getIntArray(d.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(d.e.ds24);
        this.ggO = (this.mWidth - (this.mPadding * 2)) / 8;
        this.ggP = (this.ggO - (getResources().getDimensionPixelSize(d.e.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ggO, this.ggO);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.ggN.length; i++) {
            com.baidu.tieba.pbextra.emotion.view.a aVar = new com.baidu.tieba.pbextra.emotion.view.a(getContext());
            aVar.setChooseColor(this.ggN[i]);
            aVar.setTag(Integer.valueOf(i));
            aVar.setRadius(this.ggP);
            if (i == 0) {
                aVar.setIsChooseView(true);
                this.ggQ = this.ggN[i];
                this.ggR = i;
            }
            aVar.setOnClickListener(this.blT);
            addView(aVar, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(d.e.ds20));
    }

    public int getCurrentChooseColor() {
        return this.ggQ;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.ggS = aVar;
    }
}
