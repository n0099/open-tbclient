package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ChooseColorLayout extends LinearLayout {
    private int mPadding;
    private int mWidth;
    private int[] mre;
    private int mrf;
    private int mrg;
    private int mrh;
    private int mri;
    private a mrj;
    public View.OnClickListener onClickListener;

    /* loaded from: classes2.dex */
    public interface a {
        void GC(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.mri) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.mri);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.mri = intValue;
                    ChooseColorLayout.this.mrh = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.mrj != null) {
                        ChooseColorLayout.this.mrj.GC(ChooseColorLayout.this.mrh);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.getEquipmentWidth(getContext());
        this.mre = getResources().getIntArray(R.array.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.mrf = (this.mWidth - (this.mPadding * 2)) / 8;
        this.mrg = (this.mrf - (getResources().getDimensionPixelSize(R.dimen.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mrf, this.mrf);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.mre.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.mre[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.mrg);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.mrh = this.mre[i];
                this.mri = i;
            }
            chooseColorView.setOnClickListener(this.onClickListener);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(R.dimen.ds20));
    }

    public int getCurrentChooseColor() {
        return this.mrh;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.mrj = aVar;
    }
}
