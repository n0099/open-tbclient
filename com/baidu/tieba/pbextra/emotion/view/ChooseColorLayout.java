package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener aGc;
    private int[] fNH;
    private int fNI;
    private int fNJ;
    private int fNK;
    private int fNL;
    private a fNM;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void rb(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGc = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.fNL) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.fNL);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.fNL = intValue;
                    ChooseColorLayout.this.fNK = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.fNM != null) {
                        ChooseColorLayout.this.fNM.rb(ChooseColorLayout.this.fNK);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.ah(getContext());
        this.fNH = getResources().getIntArray(d.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(d.e.ds24);
        this.fNI = (this.mWidth - (this.mPadding * 2)) / 8;
        this.fNJ = (this.fNI - (getResources().getDimensionPixelSize(d.e.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fNI, this.fNI);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.fNH.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.fNH[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.fNJ);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.fNK = this.fNH[i];
                this.fNL = i;
            }
            chooseColorView.setOnClickListener(this.aGc);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(d.e.ds20));
    }

    public int getCurrentChooseColor() {
        return this.fNK;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.fNM = aVar;
    }
}
