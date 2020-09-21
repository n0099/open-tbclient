package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener eHN;
    private int[] llb;
    private int llc;
    private int lld;
    private int lle;
    private int llf;
    private a llg;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes21.dex */
    public interface a {
        void Fw(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eHN = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.llf) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.llf);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.llf = intValue;
                    ChooseColorLayout.this.lle = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.llg != null) {
                        ChooseColorLayout.this.llg.Fw(ChooseColorLayout.this.lle);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.llb = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.llc = (this.mWidth - (this.mPadding * 2)) / 8;
        this.lld = (this.llc - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.llc, this.llc);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.llb.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.llb[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.lld);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.lle = this.llb[i];
                this.llf = i;
            }
            chooseColorView.setOnClickListener(this.eHN);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.lle;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.llg = aVar;
    }
}
