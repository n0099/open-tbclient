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
    private int[] kis;
    private int kit;
    private int kiu;
    private int kiv;
    private int kiw;
    private a kix;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes9.dex */
    public interface a {
        void AX(int i);
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
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.kiw) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.kiw);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.kiw = intValue;
                    ChooseColorLayout.this.kiv = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.kix != null) {
                        ChooseColorLayout.this.kix.AX(ChooseColorLayout.this.kiv);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.kis = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.kit = (this.mWidth - (this.mPadding * 2)) / 8;
        this.kiu = (this.kit - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.kit, this.kit);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.kis.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.kis[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.kiu);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.kiv = this.kis[i];
                this.kiw = i;
            }
            chooseColorView.setOnClickListener(this.ege);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.kiv;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.kix = aVar;
    }
}
