package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ChooseColorLayout extends LinearLayout {
    private int mPadding;
    private int mWidth;
    private int[] mhM;
    private int mhN;
    private int mhO;
    private int mhP;
    private int mhQ;
    private a mhR;
    public View.OnClickListener onClickListener;

    /* loaded from: classes2.dex */
    public interface a {
        void Gk(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.mhQ) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.mhQ);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.mhQ = intValue;
                    ChooseColorLayout.this.mhP = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.mhR != null) {
                        ChooseColorLayout.this.mhR.Gk(ChooseColorLayout.this.mhP);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.mhM = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.mhN = (this.mWidth - (this.mPadding * 2)) / 8;
        this.mhO = (this.mhN - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mhN, this.mhN);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.mhM.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.mhM[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.mhO);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.mhP = this.mhM[i];
                this.mhQ = i;
            }
            chooseColorView.setOnClickListener(this.onClickListener);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.mhP;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.mhR = aVar;
    }
}
