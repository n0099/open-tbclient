package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ChooseColorLayout extends LinearLayout {
    private int mPadding;
    private int mWidth;
    private int[] mmt;
    private int mmu;
    private int mmv;
    private int mmw;
    private int mmx;
    private a mmy;
    public View.OnClickListener onClickListener;

    /* loaded from: classes2.dex */
    public interface a {
        void HQ(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.mmx) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.mmx);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.mmx = intValue;
                    ChooseColorLayout.this.mmw = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.mmy != null) {
                        ChooseColorLayout.this.mmy.HQ(ChooseColorLayout.this.mmw);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.mmt = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.mmu = (this.mWidth - (this.mPadding * 2)) / 8;
        this.mmv = (this.mmu - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mmu, this.mmu);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.mmt.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.mmt[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.mmv);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.mmw = this.mmt[i];
                this.mmx = i;
            }
            chooseColorView.setOnClickListener(this.onClickListener);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.mmw;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.mmy = aVar;
    }
}
