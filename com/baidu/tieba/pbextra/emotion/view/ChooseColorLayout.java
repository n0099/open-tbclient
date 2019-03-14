package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener ccA;
    private int[] hIY;
    private int hIZ;
    private int hJa;
    private int hJb;
    private int hJc;
    private a hJd;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void wP(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ccA = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.hJc) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.hJc);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.hJc = intValue;
                    ChooseColorLayout.this.hJb = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.hJd != null) {
                        ChooseColorLayout.this.hJd.wP(ChooseColorLayout.this.hJb);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.aO(getContext());
        this.hIY = getResources().getIntArray(d.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(d.e.ds24);
        this.hIZ = (this.mWidth - (this.mPadding * 2)) / 8;
        this.hJa = (this.hIZ - (getResources().getDimensionPixelSize(d.e.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.hIZ, this.hIZ);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.hIY.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.hIY[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.hJa);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.hJb = this.hIY[i];
                this.hJc = i;
            }
            chooseColorView.setOnClickListener(this.ccA);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(d.e.ds20));
    }

    public int getCurrentChooseColor() {
        return this.hJb;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.hJd = aVar;
    }
}
