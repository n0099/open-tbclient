package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener ccC;
    private int[] hIK;
    private int hIL;
    private int hIM;
    private int hIN;
    private int hIO;
    private a hIP;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void wL(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ccC = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.hIO) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.hIO);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.hIO = intValue;
                    ChooseColorLayout.this.hIN = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.hIP != null) {
                        ChooseColorLayout.this.hIP.wL(ChooseColorLayout.this.hIN);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.aO(getContext());
        this.hIK = getResources().getIntArray(d.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(d.e.ds24);
        this.hIL = (this.mWidth - (this.mPadding * 2)) / 8;
        this.hIM = (this.hIL - (getResources().getDimensionPixelSize(d.e.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.hIL, this.hIL);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.hIK.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.hIK[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.hIM);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.hIN = this.hIK[i];
                this.hIO = i;
            }
            chooseColorView.setOnClickListener(this.ccC);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(d.e.ds20));
    }

    public int getCurrentChooseColor() {
        return this.hIN;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.hIP = aVar;
    }
}
