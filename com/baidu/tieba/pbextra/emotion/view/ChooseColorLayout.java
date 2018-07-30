package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener aGU;
    private int[] fRV;
    private int fRW;
    private int fRX;
    private int fRY;
    private int fRZ;
    private a fSa;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void rh(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGU = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.fRZ) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.fRZ);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.fRZ = intValue;
                    ChooseColorLayout.this.fRY = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.fSa != null) {
                        ChooseColorLayout.this.fSa.rh(ChooseColorLayout.this.fRY);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.ah(getContext());
        this.fRV = getResources().getIntArray(d.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(d.e.ds24);
        this.fRW = (this.mWidth - (this.mPadding * 2)) / 8;
        this.fRX = (this.fRW - (getResources().getDimensionPixelSize(d.e.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fRW, this.fRW);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.fRV.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.fRV[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.fRX);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.fRY = this.fRV[i];
                this.fRZ = i;
            }
            chooseColorView.setOnClickListener(this.aGU);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(d.e.ds20));
    }

    public int getCurrentChooseColor() {
        return this.fRY;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.fSa = aVar;
    }
}
