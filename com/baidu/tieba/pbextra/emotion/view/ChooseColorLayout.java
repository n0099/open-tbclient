package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener ccD;
    private int[] hIL;
    private int hIM;
    private int hIN;
    private int hIO;
    private int hIP;
    private a hIQ;
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
        this.ccD = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.hIP) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.hIP);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.hIP = intValue;
                    ChooseColorLayout.this.hIO = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.hIQ != null) {
                        ChooseColorLayout.this.hIQ.wL(ChooseColorLayout.this.hIO);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.aO(getContext());
        this.hIL = getResources().getIntArray(d.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(d.e.ds24);
        this.hIM = (this.mWidth - (this.mPadding * 2)) / 8;
        this.hIN = (this.hIM - (getResources().getDimensionPixelSize(d.e.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.hIM, this.hIM);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.hIL.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.hIL[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.hIN);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.hIO = this.hIL[i];
                this.hIP = i;
            }
            chooseColorView.setOnClickListener(this.ccD);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(d.e.ds20));
    }

    public int getCurrentChooseColor() {
        return this.hIO;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.hIQ = aVar;
    }
}
