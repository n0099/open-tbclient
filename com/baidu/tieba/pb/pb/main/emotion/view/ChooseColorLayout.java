package com.baidu.tieba.pb.pb.main.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener avV;
    private int[] eSM;
    private int eSN;
    private int eSO;
    private int eSP;
    private int eSQ;
    private a eSR;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void pl(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.avV = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof com.baidu.tieba.pb.pb.main.emotion.view.a) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.eSQ) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.eSQ);
                    if (childAt instanceof com.baidu.tieba.pb.pb.main.emotion.view.a) {
                        ((com.baidu.tieba.pb.pb.main.emotion.view.a) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.eSQ = intValue;
                    ChooseColorLayout.this.eSP = ((com.baidu.tieba.pb.pb.main.emotion.view.a) view).getChooseColor();
                    ((com.baidu.tieba.pb.pb.main.emotion.view.a) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.eSR != null) {
                        ChooseColorLayout.this.eSR.pl(ChooseColorLayout.this.eSP);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = k.ag(getContext());
        this.eSM = getResources().getIntArray(d.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(d.f.ds24);
        this.eSN = (this.mWidth - (this.mPadding * 2)) / 8;
        this.eSO = (this.eSN - (getResources().getDimensionPixelSize(d.f.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.eSN, this.eSN);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.eSM.length; i++) {
            com.baidu.tieba.pb.pb.main.emotion.view.a aVar = new com.baidu.tieba.pb.pb.main.emotion.view.a(getContext());
            aVar.setChooseColor(this.eSM[i]);
            aVar.setTag(Integer.valueOf(i));
            aVar.setRadius(this.eSO);
            if (i == 0) {
                aVar.setIsChooseView(true);
                this.eSP = this.eSM[i];
                this.eSQ = i;
            }
            aVar.setOnClickListener(this.avV);
            addView(aVar, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(d.f.ds20));
    }

    public int getCurrentChooseColor() {
        return this.eSP;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.eSR = aVar;
    }
}
