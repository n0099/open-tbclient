package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener aTa;
    private int[] grJ;
    private int grK;
    private int grL;
    private int grM;
    private int grN;
    private a grO;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void tb(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aTa = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.grN) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.grN);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.grN = intValue;
                    ChooseColorLayout.this.grM = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.grO != null) {
                        ChooseColorLayout.this.grO.tb(ChooseColorLayout.this.grM);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.aO(getContext());
        this.grJ = getResources().getIntArray(e.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(e.C0210e.ds24);
        this.grK = (this.mWidth - (this.mPadding * 2)) / 8;
        this.grL = (this.grK - (getResources().getDimensionPixelSize(e.C0210e.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.grK, this.grK);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.grJ.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.grJ[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.grL);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.grM = this.grJ[i];
                this.grN = i;
            }
            chooseColorView.setOnClickListener(this.aTa);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(e.C0210e.ds20));
    }

    public int getCurrentChooseColor() {
        return this.grM;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.grO = aVar;
    }
}
