package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener eoP;
    private int[] kDk;
    private int kDl;
    private int kDm;
    private int kDn;
    private int kDo;
    private a kDp;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes9.dex */
    public interface a {
        void Cb(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eoP = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.kDo) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.kDo);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.kDo = intValue;
                    ChooseColorLayout.this.kDn = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.kDp != null) {
                        ChooseColorLayout.this.kDp.Cb(ChooseColorLayout.this.kDn);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.kDk = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.kDl = (this.mWidth - (this.mPadding * 2)) / 8;
        this.kDm = (this.kDl - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.kDl, this.kDl);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.kDk.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.kDk[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.kDm);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.kDn = this.kDk[i];
                this.kDo = i;
            }
            chooseColorView.setOnClickListener(this.eoP);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.kDn;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.kDp = aVar;
    }
}
