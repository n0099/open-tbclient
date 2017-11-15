package com.baidu.tieba.pb.pb.main.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener auH;
    private int[] eXd;
    private int eXe;
    private int eXf;
    private int eXg;
    private int eXh;
    private a eXi;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void pR(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.auH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof com.baidu.tieba.pb.pb.main.emotion.view.a) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.eXh) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.eXh);
                    if (childAt instanceof com.baidu.tieba.pb.pb.main.emotion.view.a) {
                        ((com.baidu.tieba.pb.pb.main.emotion.view.a) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.eXh = intValue;
                    ChooseColorLayout.this.eXg = ((com.baidu.tieba.pb.pb.main.emotion.view.a) view).getChooseColor();
                    ((com.baidu.tieba.pb.pb.main.emotion.view.a) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.eXi != null) {
                        ChooseColorLayout.this.eXi.pR(ChooseColorLayout.this.eXg);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.ac(getContext());
        this.eXd = getResources().getIntArray(d.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(d.e.ds24);
        this.eXe = (this.mWidth - (this.mPadding * 2)) / 8;
        this.eXf = (this.eXe - (getResources().getDimensionPixelSize(d.e.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.eXe, this.eXe);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.eXd.length; i++) {
            com.baidu.tieba.pb.pb.main.emotion.view.a aVar = new com.baidu.tieba.pb.pb.main.emotion.view.a(getContext());
            aVar.setChooseColor(this.eXd[i]);
            aVar.setTag(Integer.valueOf(i));
            aVar.setRadius(this.eXf);
            if (i == 0) {
                aVar.setIsChooseView(true);
                this.eXg = this.eXd[i];
                this.eXh = i;
            }
            aVar.setOnClickListener(this.auH);
            addView(aVar, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(d.e.ds20));
    }

    public int getCurrentChooseColor() {
        return this.eXg;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.eXi = aVar;
    }
}
