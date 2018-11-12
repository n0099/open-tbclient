package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener aPz;
    private int[] gib;
    private int gic;
    private int gie;
    private int gif;
    private int gig;
    private a gih;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void su(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aPz = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof ChooseColorView) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.gig) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.gig);
                    if (childAt instanceof ChooseColorView) {
                        ((ChooseColorView) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.gig = intValue;
                    ChooseColorLayout.this.gif = ((ChooseColorView) view).getChooseColor();
                    ((ChooseColorView) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.gih != null) {
                        ChooseColorLayout.this.gih.su(ChooseColorLayout.this.gif);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.aO(getContext());
        this.gib = getResources().getIntArray(e.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(e.C0200e.ds24);
        this.gic = (this.mWidth - (this.mPadding * 2)) / 8;
        this.gie = (this.gic - (getResources().getDimensionPixelSize(e.C0200e.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.gic, this.gic);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.gib.length; i++) {
            ChooseColorView chooseColorView = new ChooseColorView(getContext());
            chooseColorView.setChooseColor(this.gib[i]);
            chooseColorView.setTag(Integer.valueOf(i));
            chooseColorView.setRadius(this.gie);
            if (i == 0) {
                chooseColorView.setIsChooseView(true);
                this.gif = this.gib[i];
                this.gig = i;
            }
            chooseColorView.setOnClickListener(this.aPz);
            addView(chooseColorView, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(e.C0200e.ds20));
    }

    public int getCurrentChooseColor() {
        return this.gif;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.gih = aVar;
    }
}
