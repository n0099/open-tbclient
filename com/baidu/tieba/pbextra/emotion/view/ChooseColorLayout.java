package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener eve;
    private int[] kMm;
    private int kMn;
    private int kMo;
    private int kMp;
    private int kMq;
    private a kMr;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes16.dex */
    public interface a {
        void CB(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eve = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.kMq) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.kMq);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.kMq = intValue;
                    ChooseColorLayout.this.kMp = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.kMr != null) {
                        ChooseColorLayout.this.kMr.CB(ChooseColorLayout.this.kMp);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.kMm = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.kMn = (this.mWidth - (this.mPadding * 2)) / 8;
        this.kMo = (this.kMn - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.kMn, this.kMn);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.kMm.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.kMm[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.kMo);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.kMp = this.kMm[i];
                this.kMq = i;
            }
            chooseColorView.setOnClickListener(this.eve);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.kMp;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.kMr = aVar;
    }
}
