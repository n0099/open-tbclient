package com.baidu.tieba.pb.pb.main.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener avj;
    private int[] eTi;
    private int eTj;
    private int eTk;
    private int eTl;
    private int eTm;
    private a eTn;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void pz(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.avj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof com.baidu.tieba.pb.pb.main.emotion.view.a) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.eTm) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.eTm);
                    if (childAt instanceof com.baidu.tieba.pb.pb.main.emotion.view.a) {
                        ((com.baidu.tieba.pb.pb.main.emotion.view.a) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.eTm = intValue;
                    ChooseColorLayout.this.eTl = ((com.baidu.tieba.pb.pb.main.emotion.view.a) view).getChooseColor();
                    ((com.baidu.tieba.pb.pb.main.emotion.view.a) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.eTn != null) {
                        ChooseColorLayout.this.eTn.pz(ChooseColorLayout.this.eTl);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = k.ad(getContext());
        this.eTi = getResources().getIntArray(d.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(d.f.ds24);
        this.eTj = (this.mWidth - (this.mPadding * 2)) / 8;
        this.eTk = (this.eTj - (getResources().getDimensionPixelSize(d.f.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.eTj, this.eTj);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.eTi.length; i++) {
            com.baidu.tieba.pb.pb.main.emotion.view.a aVar = new com.baidu.tieba.pb.pb.main.emotion.view.a(getContext());
            aVar.setChooseColor(this.eTi[i]);
            aVar.setTag(Integer.valueOf(i));
            aVar.setRadius(this.eTk);
            if (i == 0) {
                aVar.setIsChooseView(true);
                this.eTl = this.eTi[i];
                this.eTm = i;
            }
            aVar.setOnClickListener(this.avj);
            addView(aVar, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(d.f.ds20));
    }

    public int getCurrentChooseColor() {
        return this.eTl;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.eTn = aVar;
    }
}
