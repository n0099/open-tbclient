package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener drh;
    private int[] jeA;
    private int jeB;
    private int jeC;
    private int jeD;
    private int jeE;
    private a jeF;
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
        this.drh = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.jeE) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.jeE);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.jeE = intValue;
                    ChooseColorLayout.this.jeD = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.jeF != null) {
                        ChooseColorLayout.this.jeF.zD(ChooseColorLayout.this.jeD);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.jeA = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.jeB = (this.mWidth - (this.mPadding * 2)) / 8;
        this.jeC = (this.jeB - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.jeB, this.jeB);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.jeA.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.jeA[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.jeC);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.jeD = this.jeA[i];
                this.jeE = i;
            }
            chooseColorView.setOnClickListener(this.drh);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.jeD;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.jeF = aVar;
    }
}
