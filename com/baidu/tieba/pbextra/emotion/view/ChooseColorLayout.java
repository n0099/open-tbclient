package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener dmY;
    private int jdA;
    private int jdB;
    private int jdC;
    private int jdD;
    private a jdE;
    private int[] jdz;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes7.dex */
    public interface a {
        void zw(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dmY = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.jdD) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.jdD);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.jdD = intValue;
                    ChooseColorLayout.this.jdC = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.jdE != null) {
                        ChooseColorLayout.this.jdE.zw(ChooseColorLayout.this.jdC);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.jdz = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.jdA = (this.mWidth - (this.mPadding * 2)) / 8;
        this.jdB = (this.jdA - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.jdA, this.jdA);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.jdz.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.jdz[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.jdB);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.jdC = this.jdz[i];
                this.jdD = i;
            }
            chooseColorView.setOnClickListener(this.dmY);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.jdC;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.jdE = aVar;
    }
}
