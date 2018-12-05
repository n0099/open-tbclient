package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener aSY;
    private int[] goS;
    private int goT;
    private int goU;
    private int goV;
    private int goW;
    private a goX;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void sO(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aSY = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.goW) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.goW);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.goW = intValue;
                    ChooseColorLayout.this.goV = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.goX != null) {
                        ChooseColorLayout.this.goX.sO(ChooseColorLayout.this.goV);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.aO(getContext());
        this.goS = getResources().getIntArray(e.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(e.C0210e.ds24);
        this.goT = (this.mWidth - (this.mPadding * 2)) / 8;
        this.goU = (this.goT - (getResources().getDimensionPixelSize(e.C0210e.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.goT, this.goT);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.goS.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.goS[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.goU);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.goV = this.goS[i];
                this.goW = i;
            }
            chooseColorView.setOnClickListener(this.aSY);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(e.C0210e.ds20));
    }

    public int getCurrentChooseColor() {
        return this.goV;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.goX = aVar;
    }
}
