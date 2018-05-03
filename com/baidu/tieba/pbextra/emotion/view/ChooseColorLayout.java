package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener axG;
    private int[] fBg;
    private int fBh;
    private int fBi;
    private int fBj;
    private int fBk;
    private a fBl;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void qQ(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.axG = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int intValue;
                if ((view2 instanceof ChooseColorView) && (intValue = ((Integer) view2.getTag()).intValue()) != ChooseColorLayout.this.fBk) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.fBk);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.fBk = intValue;
                    ChooseColorLayout.this.fBj = ((ChooseColorView) view2).getChooseColor();
                    ((ChooseColorView) view2).setIsChooseView(true);
                    if (ChooseColorLayout.this.fBl != null) {
                        ChooseColorLayout.this.fBl.qQ(ChooseColorLayout.this.fBj);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.af(getContext());
        this.fBg = getResources().getIntArray(d.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(d.e.ds24);
        this.fBh = (this.mWidth - (this.mPadding * 2)) / 8;
        this.fBi = (this.fBh - (getResources().getDimensionPixelSize(d.e.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fBh, this.fBh);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.fBg.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.fBg[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.fBi);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.fBj = this.fBg[i];
                this.fBk = i;
            }
            chooseColorView.setOnClickListener(this.axG);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(d.e.ds20));
    }

    public int getCurrentChooseColor() {
        return this.fBj;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.fBl = aVar;
    }
}
