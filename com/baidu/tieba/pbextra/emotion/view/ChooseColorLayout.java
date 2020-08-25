package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener eFC;
    private int[] lcd;
    private int lce;
    private int lcf;
    private int lcg;
    private int lch;
    private a lci;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes16.dex */
    public interface a {
        void EV(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eFC = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.lch) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.lch);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.lch = intValue;
                    ChooseColorLayout.this.lcg = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.lci != null) {
                        ChooseColorLayout.this.lci.EV(ChooseColorLayout.this.lcg);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.lcd = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.lce = (this.mWidth - (this.mPadding * 2)) / 8;
        this.lcf = (this.lce - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.lce, this.lce);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.lcd.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.lcd[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.lcf);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.lcg = this.lcd[i];
                this.lch = i;
            }
            chooseColorView.setOnClickListener(this.eFC);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.lcg;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.lci = aVar;
    }
}
