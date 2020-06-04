package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener ege;
    private int kjA;
    private int kjB;
    private int kjC;
    private a kjD;
    private int[] kjy;
    private int kjz;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes9.dex */
    public interface a {
        void AZ(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ege = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.kjC) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.kjC);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.kjC = intValue;
                    ChooseColorLayout.this.kjB = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.kjD != null) {
                        ChooseColorLayout.this.kjD.AZ(ChooseColorLayout.this.kjB);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.kjy = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.kjz = (this.mWidth - (this.mPadding * 2)) / 8;
        this.kjA = (this.kjz - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.kjz, this.kjz);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.kjy.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.kjy[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.kjA);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.kjB = this.kjy[i];
                this.kjC = i;
            }
            chooseColorView.setOnClickListener(this.ege);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.kjB;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.kjD = aVar;
    }
}
