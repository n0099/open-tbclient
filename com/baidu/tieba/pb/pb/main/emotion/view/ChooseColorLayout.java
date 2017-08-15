package com.baidu.tieba.pb.pb.main.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener avW;
    private int[] eUF;
    private int eUG;
    private int eUH;
    private int eUI;
    private int eUJ;
    private a eUK;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void pv(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.avW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof com.baidu.tieba.pb.pb.main.emotion.view.a) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.eUJ) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.eUJ);
                    if (childAt instanceof com.baidu.tieba.pb.pb.main.emotion.view.a) {
                        ((com.baidu.tieba.pb.pb.main.emotion.view.a) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.eUJ = intValue;
                    ChooseColorLayout.this.eUI = ((com.baidu.tieba.pb.pb.main.emotion.view.a) view).getChooseColor();
                    ((com.baidu.tieba.pb.pb.main.emotion.view.a) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.eUK != null) {
                        ChooseColorLayout.this.eUK.pv(ChooseColorLayout.this.eUI);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = k.ag(getContext());
        this.eUF = getResources().getIntArray(d.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(d.f.ds24);
        this.eUG = (this.mWidth - (this.mPadding * 2)) / 8;
        this.eUH = (this.eUG - (getResources().getDimensionPixelSize(d.f.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.eUG, this.eUG);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.eUF.length; i++) {
            com.baidu.tieba.pb.pb.main.emotion.view.a aVar = new com.baidu.tieba.pb.pb.main.emotion.view.a(getContext());
            aVar.setChooseColor(this.eUF[i]);
            aVar.setTag(Integer.valueOf(i));
            aVar.setRadius(this.eUH);
            if (i == 0) {
                aVar.setIsChooseView(true);
                this.eUI = this.eUF[i];
                this.eUJ = i;
            }
            aVar.setOnClickListener(this.avW);
            addView(aVar, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(d.f.ds20));
    }

    public int getCurrentChooseColor() {
        return this.eUI;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.eUK = aVar;
    }
}
