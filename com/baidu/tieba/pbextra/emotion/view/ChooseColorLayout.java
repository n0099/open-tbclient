package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener eTU;
    private int[] lAt;
    private int lAu;
    private int lAv;
    private int lAw;
    private int lAx;
    private a lAy;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes22.dex */
    public interface a {
        void Gc(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eTU = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.lAx) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.lAx);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.lAx = intValue;
                    ChooseColorLayout.this.lAw = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.lAy != null) {
                        ChooseColorLayout.this.lAy.Gc(ChooseColorLayout.this.lAw);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.lAt = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.lAu = (this.mWidth - (this.mPadding * 2)) / 8;
        this.lAv = (this.lAu - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.lAu, this.lAu);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.lAt.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.lAt[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.lAv);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.lAw = this.lAt[i];
                this.lAx = i;
            }
            chooseColorView.setOnClickListener(this.eTU);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.lAw;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.lAy = aVar;
    }
}
