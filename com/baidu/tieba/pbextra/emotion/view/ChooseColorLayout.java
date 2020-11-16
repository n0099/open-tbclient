package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener fhp;
    private int[] lTc;
    private int lTd;
    private int lTe;
    private int lTf;
    private int lTg;
    private a lTh;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes21.dex */
    public interface a {
        void Hg(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fhp = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.lTg) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.lTg);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.lTg = intValue;
                    ChooseColorLayout.this.lTf = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.lTh != null) {
                        ChooseColorLayout.this.lTh.Hg(ChooseColorLayout.this.lTf);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.lTc = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.lTd = (this.mWidth - (this.mPadding * 2)) / 8;
        this.lTe = (this.lTd - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.lTd, this.lTd);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.lTc.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.lTc[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.lTe);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.lTf = this.lTc[i];
                this.lTg = i;
            }
            chooseColorView.setOnClickListener(this.fhp);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.lTf;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.lTh = aVar;
    }
}
