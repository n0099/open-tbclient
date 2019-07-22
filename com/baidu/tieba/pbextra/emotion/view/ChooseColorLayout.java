package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener clU;
    private int[] ihg;
    private int ihh;
    private int ihi;
    private int ihj;
    private int ihk;
    private a ihl;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void yv(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.clU = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.ihk) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.ihk);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.ihk = intValue;
                    ChooseColorLayout.this.ihj = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.ihl != null) {
                        ChooseColorLayout.this.ihl.yv(ChooseColorLayout.this.ihj);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.af(getContext());
        this.ihg = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.ihh = (this.mWidth - (this.mPadding * 2)) / 8;
        this.ihi = (this.ihh - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ihh, this.ihh);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.ihg.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.ihg[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.ihi);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.ihj = this.ihg[i];
                this.ihk = i;
            }
            chooseColorView.setOnClickListener(this.clU);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.ihj;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.ihl = aVar;
    }
}
