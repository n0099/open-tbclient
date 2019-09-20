package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener cmX;
    private int[] ikh;
    private int iki;
    private int ikj;
    private int ikk;
    private int ikl;
    private a ikm;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes4.dex */
    public interface a {
        void yA(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cmX = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.ikl) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.ikl);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.ikl = intValue;
                    ChooseColorLayout.this.ikk = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.ikm != null) {
                        ChooseColorLayout.this.ikm.yA(ChooseColorLayout.this.ikk);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.af(getContext());
        this.ikh = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.iki = (this.mWidth - (this.mPadding * 2)) / 8;
        this.ikj = (this.iki - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.iki, this.iki);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.ikh.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.ikh[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.ikj);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.ikk = this.ikh[i];
                this.ikl = i;
            }
            chooseColorView.setOnClickListener(this.cmX);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.ikk;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.ikm = aVar;
    }
}
