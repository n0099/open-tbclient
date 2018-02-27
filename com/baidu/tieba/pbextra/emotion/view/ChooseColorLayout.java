package com.baidu.tieba.pbextra.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener blQ;
    private int ggA;
    private int ggB;
    private a ggC;
    private int[] ggx;
    private int ggy;
    private int ggz;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void tu(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.blQ = new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof com.baidu.tieba.pbextra.emotion.view.a) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.ggB) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.ggB);
                    if (childAt instanceof com.baidu.tieba.pbextra.emotion.view.a) {
                        ((com.baidu.tieba.pbextra.emotion.view.a) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.ggB = intValue;
                    ChooseColorLayout.this.ggA = ((com.baidu.tieba.pbextra.emotion.view.a) view).getChooseColor();
                    ((com.baidu.tieba.pbextra.emotion.view.a) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.ggC != null) {
                        ChooseColorLayout.this.ggC.tu(ChooseColorLayout.this.ggA);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.ao(getContext());
        this.ggx = getResources().getIntArray(d.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(d.e.ds24);
        this.ggy = (this.mWidth - (this.mPadding * 2)) / 8;
        this.ggz = (this.ggy - (getResources().getDimensionPixelSize(d.e.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ggy, this.ggy);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.ggx.length; i++) {
            com.baidu.tieba.pbextra.emotion.view.a aVar = new com.baidu.tieba.pbextra.emotion.view.a(getContext());
            aVar.setChooseColor(this.ggx[i]);
            aVar.setTag(Integer.valueOf(i));
            aVar.setRadius(this.ggz);
            if (i == 0) {
                aVar.setIsChooseView(true);
                this.ggA = this.ggx[i];
                this.ggB = i;
            }
            aVar.setOnClickListener(this.blQ);
            addView(aVar, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(d.e.ds20));
    }

    public int getCurrentChooseColor() {
        return this.ggA;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.ggC = aVar;
    }
}
