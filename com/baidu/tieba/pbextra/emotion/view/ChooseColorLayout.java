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
    private int[] mhj;
    private int mhk;
    private int mhl;
    private int mhm;
    private int mhn;
    private a mho;

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
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.mhn) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.mhn);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.mhn = intValue;
                    ChooseColorLayout.this.mhm = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.mho != null) {
                        ChooseColorLayout.this.mho.HX(ChooseColorLayout.this.mhm);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.mhj = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.mhk = (this.mWidth - (this.mPadding * 2)) / 8;
        this.mhl = (this.mhk - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mhk, this.mhk);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.mhj.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.mhj[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.mhl);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.mhm = this.mhj[i];
                this.mhn = i;
            }
            chooseColorView.setOnClickListener(this.foP);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.mhm;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.mho = aVar;
    }
}
