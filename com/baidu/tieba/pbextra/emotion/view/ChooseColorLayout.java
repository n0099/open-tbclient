package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener axH;
    private int[] fCm;
    private int fCn;
    private int fCo;
    private int fCp;
    private int fCq;
    private a fCr;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void qP(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.axH = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int intValue;
                if ((view2 instanceof ChooseColorView) && (intValue = ((Integer) view2.getTag()).intValue()) != ChooseColorLayout.this.fCq) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.fCq);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.fCq = intValue;
                    ChooseColorLayout.this.fCp = ((ChooseColorView) view2).getChooseColor();
                    ((ChooseColorView) view2).setIsChooseView(true);
                    if (ChooseColorLayout.this.fCr != null) {
                        ChooseColorLayout.this.fCr.qP(ChooseColorLayout.this.fCp);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.af(getContext());
        this.fCm = getResources().getIntArray(d.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(d.e.ds24);
        this.fCn = (this.mWidth - (this.mPadding * 2)) / 8;
        this.fCo = (this.fCn - (getResources().getDimensionPixelSize(d.e.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fCn, this.fCn);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.fCm.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.fCm[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.fCo);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.fCp = this.fCm[i];
                this.fCq = i;
            }
            chooseColorView.setOnClickListener(this.axH);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(d.e.ds20));
    }

    public int getCurrentChooseColor() {
        return this.fCp;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.fCr = aVar;
    }
}
