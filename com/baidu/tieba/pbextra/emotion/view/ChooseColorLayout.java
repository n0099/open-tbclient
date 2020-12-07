package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener foP;
    private int mPadding;
    private int mWidth;
    private int[] mhh;
    private int mhi;
    private int mhj;
    private int mhk;
    private int mhl;
    private a mhm;

    /* loaded from: classes22.dex */
    public interface a {
        void HX(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.foP = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.mhl) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.mhl);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.mhl = intValue;
                    ChooseColorLayout.this.mhk = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.mhm != null) {
                        ChooseColorLayout.this.mhm.HX(ChooseColorLayout.this.mhk);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.mhh = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.mhi = (this.mWidth - (this.mPadding * 2)) / 8;
        this.mhj = (this.mhi - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mhi, this.mhi);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.mhh.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.mhh[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.mhj);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.mhk = this.mhh[i];
                this.mhl = i;
            }
            chooseColorView.setOnClickListener(this.foP);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.mhk;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.mhm = aVar;
    }
}
