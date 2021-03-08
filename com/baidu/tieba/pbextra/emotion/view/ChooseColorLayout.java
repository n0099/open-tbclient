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
    private int[] mth;
    private int mti;
    private int mtj;
    private int mtk;
    private int mtl;
    private a mtm;
    public View.OnClickListener onClickListener;

    /* loaded from: classes2.dex */
    public interface a {
        void GF(int i);
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
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.mtl) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.mtl);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.mtl = intValue;
                    ChooseColorLayout.this.mtk = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.mtm != null) {
                        ChooseColorLayout.this.mtm.GF(ChooseColorLayout.this.mtk);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.mth = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.mti = (this.mWidth - (this.mPadding * 2)) / 8;
        this.mtj = (this.mti - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mti, this.mti);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.mth.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.mth[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.mtj);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.mtk = this.mth[i];
                this.mtl = i;
            }
            chooseColorView.setOnClickListener(this.onClickListener);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.mtk;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.mtm = aVar;
    }
}
