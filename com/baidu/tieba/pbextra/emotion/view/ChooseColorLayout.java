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
    private int[] fBj;
    private int fBk;
    private int fBl;
    private int fBm;
    private int fBn;
    private a fBo;
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
                if ((view2 instanceof ChooseColorView) && (intValue = ((Integer) view2.getTag()).intValue()) != ChooseColorLayout.this.fBn) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.fBn);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.fBn = intValue;
                    ChooseColorLayout.this.fBm = ((ChooseColorView) view2).getChooseColor();
                    ((ChooseColorView) view2).setIsChooseView(true);
                    if (ChooseColorLayout.this.fBo != null) {
                        ChooseColorLayout.this.fBo.qQ(ChooseColorLayout.this.fBm);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.af(getContext());
        this.fBj = getResources().getIntArray(d.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(d.e.ds24);
        this.fBk = (this.mWidth - (this.mPadding * 2)) / 8;
        this.fBl = (this.fBk - (getResources().getDimensionPixelSize(d.e.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fBk, this.fBk);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.fBj.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.fBj[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.fBl);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.fBm = this.fBj[i];
                this.fBn = i;
            }
            chooseColorView.setOnClickListener(this.axG);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(d.e.ds20));
    }

    public int getCurrentChooseColor() {
        return this.fBm;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.fBo = aVar;
    }
}
