package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener aKh;
    private int[] fZd;
    private int fZe;
    private int fZf;
    private int fZg;
    private int fZh;
    private a fZi;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void rE(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aKh = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.fZh) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.fZh);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.fZh = intValue;
                    ChooseColorLayout.this.fZg = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.fZi != null) {
                        ChooseColorLayout.this.fZi.rE(ChooseColorLayout.this.fZg);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.aO(getContext());
        this.fZd = getResources().getIntArray(e.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(e.C0141e.ds24);
        this.fZe = (this.mWidth - (this.mPadding * 2)) / 8;
        this.fZf = (this.fZe - (getResources().getDimensionPixelSize(e.C0141e.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fZe, this.fZe);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.fZd.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.fZd[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.fZf);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.fZg = this.fZd[i];
                this.fZh = i;
            }
            chooseColorView.setOnClickListener(this.aKh);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(e.C0141e.ds20));
    }

    public int getCurrentChooseColor() {
        return this.fZg;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.fZi = aVar;
    }
}
