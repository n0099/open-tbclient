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
    private int[] mms;
    private int mmt;
    private int mmu;
    private int mmv;
    private int mmw;
    private a mmx;
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
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.mmw) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.mmw);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.mmw = intValue;
                    ChooseColorLayout.this.mmv = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.mmx != null) {
                        ChooseColorLayout.this.mmx.HQ(ChooseColorLayout.this.mmv);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.mms = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.mmt = (this.mWidth - (this.mPadding * 2)) / 8;
        this.mmu = (this.mmt - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mmt, this.mmt);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.mms.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.mms[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.mmu);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.mmv = this.mms[i];
                this.mmw = i;
            }
            chooseColorView.setOnClickListener(this.onClickListener);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.mmv;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.mmx = aVar;
    }
}
