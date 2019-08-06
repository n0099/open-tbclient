package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener cmb;
    private int[] iii;
    private int iij;
    private int iik;
    private int iil;
    private int iim;
    private a iin;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void yx(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cmb = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.iim) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.iim);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.iim = intValue;
                    ChooseColorLayout.this.iil = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.iin != null) {
                        ChooseColorLayout.this.iin.yx(ChooseColorLayout.this.iil);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.af(getContext());
        this.iii = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.iij = (this.mWidth - (this.mPadding * 2)) / 8;
        this.iik = (this.iij - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.iij, this.iij);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.iii.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.iii[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.iik);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.iil = this.iii[i];
                this.iim = i;
            }
            chooseColorView.setOnClickListener(this.cmb);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.iil;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.iin = aVar;
    }
}
