package com.baidu.tieba.pb.pb.main.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener auc;
    private int[] eNP;
    private int eNQ;
    private int eNR;
    private int eNS;
    private int eNT;
    private a eNU;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void pw(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.auc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof com.baidu.tieba.pb.pb.main.emotion.view.a) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.eNT) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.eNT);
                    if (childAt instanceof com.baidu.tieba.pb.pb.main.emotion.view.a) {
                        ((com.baidu.tieba.pb.pb.main.emotion.view.a) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.eNT = intValue;
                    ChooseColorLayout.this.eNS = ((com.baidu.tieba.pb.pb.main.emotion.view.a) view).getChooseColor();
                    ((com.baidu.tieba.pb.pb.main.emotion.view.a) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.eNU != null) {
                        ChooseColorLayout.this.eNU.pw(ChooseColorLayout.this.eNS);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.ad(getContext());
        this.eNP = getResources().getIntArray(d.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(d.f.ds24);
        this.eNQ = (this.mWidth - (this.mPadding * 2)) / 8;
        this.eNR = (this.eNQ - (getResources().getDimensionPixelSize(d.f.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.eNQ, this.eNQ);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.eNP.length; i++) {
            com.baidu.tieba.pb.pb.main.emotion.view.a aVar = new com.baidu.tieba.pb.pb.main.emotion.view.a(getContext());
            aVar.setChooseColor(this.eNP[i]);
            aVar.setTag(Integer.valueOf(i));
            aVar.setRadius(this.eNR);
            if (i == 0) {
                aVar.setIsChooseView(true);
                this.eNS = this.eNP[i];
                this.eNT = i;
            }
            aVar.setOnClickListener(this.auc);
            addView(aVar, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(d.f.ds20));
    }

    public int getCurrentChooseColor() {
        return this.eNS;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.eNU = aVar;
    }
}
