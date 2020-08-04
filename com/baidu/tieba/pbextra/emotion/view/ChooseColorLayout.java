package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener eve;
    private int[] kMo;
    private int kMp;
    private int kMq;
    private int kMr;
    private int kMs;
    private a kMt;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes16.dex */
    public interface a {
        void CB(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eve = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.kMs) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.kMs);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.kMs = intValue;
                    ChooseColorLayout.this.kMr = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.kMt != null) {
                        ChooseColorLayout.this.kMt.CB(ChooseColorLayout.this.kMr);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.kMo = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.kMp = (this.mWidth - (this.mPadding * 2)) / 8;
        this.kMq = (this.kMp - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.kMp, this.kMp);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.kMo.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.kMo[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.kMq);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.kMr = this.kMo[i];
                this.kMs = i;
            }
            chooseColorView.setOnClickListener(this.eve);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.kMr;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.kMt = aVar;
    }
}
