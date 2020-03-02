package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener dri;
    private int[] jeC;
    private int jeD;
    private int jeE;
    private int jeF;
    private int jeG;
    private a jeH;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes9.dex */
    public interface a {
        void zD(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dri = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.jeG) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.jeG);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.jeG = intValue;
                    ChooseColorLayout.this.jeF = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.jeH != null) {
                        ChooseColorLayout.this.jeH.zD(ChooseColorLayout.this.jeF);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.jeC = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.jeD = (this.mWidth - (this.mPadding * 2)) / 8;
        this.jeE = (this.jeD - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.jeD, this.jeD);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.jeC.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.jeC[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.jeE);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.jeF = this.jeC[i];
                this.jeG = i;
            }
            chooseColorView.setOnClickListener(this.dri);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.jeF;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.jeH = aVar;
    }
}
