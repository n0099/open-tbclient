package com.baidu.tieba.pb.pb.main.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener avg;
    private int[] eUc;
    private int eUd;
    private int eUe;
    private int eUf;
    private int eUg;
    private a eUh;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void pB(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.avg = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof com.baidu.tieba.pb.pb.main.emotion.view.a) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.eUg) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.eUg);
                    if (childAt instanceof com.baidu.tieba.pb.pb.main.emotion.view.a) {
                        ((com.baidu.tieba.pb.pb.main.emotion.view.a) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.eUg = intValue;
                    ChooseColorLayout.this.eUf = ((com.baidu.tieba.pb.pb.main.emotion.view.a) view).getChooseColor();
                    ((com.baidu.tieba.pb.pb.main.emotion.view.a) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.eUh != null) {
                        ChooseColorLayout.this.eUh.pB(ChooseColorLayout.this.eUf);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = k.ae(getContext());
        this.eUc = getResources().getIntArray(d.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(d.f.ds24);
        this.eUd = (this.mWidth - (this.mPadding * 2)) / 8;
        this.eUe = (this.eUd - (getResources().getDimensionPixelSize(d.f.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.eUd, this.eUd);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.eUc.length; i++) {
            com.baidu.tieba.pb.pb.main.emotion.view.a aVar = new com.baidu.tieba.pb.pb.main.emotion.view.a(getContext());
            aVar.setChooseColor(this.eUc[i]);
            aVar.setTag(Integer.valueOf(i));
            aVar.setRadius(this.eUe);
            if (i == 0) {
                aVar.setIsChooseView(true);
                this.eUf = this.eUc[i];
                this.eUg = i;
            }
            aVar.setOnClickListener(this.avg);
            addView(aVar, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(d.f.ds20));
    }

    public int getCurrentChooseColor() {
        return this.eUf;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.eUh = aVar;
    }
}
