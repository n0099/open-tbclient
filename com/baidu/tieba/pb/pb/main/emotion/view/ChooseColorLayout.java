package com.baidu.tieba.pb.pb.main.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener auz;
    private int[] eWI;
    private int eWJ;
    private int eWK;
    private int eWL;
    private int eWM;
    private a eWN;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void pQ(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.auz = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof com.baidu.tieba.pb.pb.main.emotion.view.a) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.eWM) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.eWM);
                    if (childAt instanceof com.baidu.tieba.pb.pb.main.emotion.view.a) {
                        ((com.baidu.tieba.pb.pb.main.emotion.view.a) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.eWM = intValue;
                    ChooseColorLayout.this.eWL = ((com.baidu.tieba.pb.pb.main.emotion.view.a) view).getChooseColor();
                    ((com.baidu.tieba.pb.pb.main.emotion.view.a) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.eWN != null) {
                        ChooseColorLayout.this.eWN.pQ(ChooseColorLayout.this.eWL);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.ac(getContext());
        this.eWI = getResources().getIntArray(d.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(d.e.ds24);
        this.eWJ = (this.mWidth - (this.mPadding * 2)) / 8;
        this.eWK = (this.eWJ - (getResources().getDimensionPixelSize(d.e.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.eWJ, this.eWJ);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.eWI.length; i++) {
            com.baidu.tieba.pb.pb.main.emotion.view.a aVar = new com.baidu.tieba.pb.pb.main.emotion.view.a(getContext());
            aVar.setChooseColor(this.eWI[i]);
            aVar.setTag(Integer.valueOf(i));
            aVar.setRadius(this.eWK);
            if (i == 0) {
                aVar.setIsChooseView(true);
                this.eWL = this.eWI[i];
                this.eWM = i;
            }
            aVar.setOnClickListener(this.auz);
            addView(aVar, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(d.e.ds20));
    }

    public int getCurrentChooseColor() {
        return this.eWL;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.eWN = aVar;
    }
}
