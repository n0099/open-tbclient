package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener dmK;
    private int[] iZW;
    private int iZX;
    private int iZY;
    private int iZZ;
    private int jaa;
    private a jab;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes6.dex */
    public interface a {
        void zr(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dmK = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.jaa) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.jaa);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.jaa = intValue;
                    ChooseColorLayout.this.iZZ = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.jab != null) {
                        ChooseColorLayout.this.jab.zr(ChooseColorLayout.this.iZZ);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.iZW = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.iZX = (this.mWidth - (this.mPadding * 2)) / 8;
        this.iZY = (this.iZX - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.iZX, this.iZX);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.iZW.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.iZW[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.iZY);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.iZZ = this.iZW[i];
                this.jaa = i;
            }
            chooseColorView.setOnClickListener(this.dmK);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.iZZ;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.jab = aVar;
    }
}
