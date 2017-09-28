package com.baidu.tieba.pb.pb.main.emotion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ChooseColorLayout extends LinearLayout {
    public View.OnClickListener auo;
    private int[] eOd;
    private int eOe;
    private int eOf;
    private int eOg;
    private int eOh;
    private a eOi;
    private int mPadding;
    private int mWidth;

    /* loaded from: classes.dex */
    public interface a {
        void px(int i);
    }

    public ChooseColorLayout(Context context) {
        this(context, null);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChooseColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.auo = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.view.ChooseColorLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue;
                if ((view instanceof com.baidu.tieba.pb.pb.main.emotion.view.a) && (intValue = ((Integer) view.getTag()).intValue()) != ChooseColorLayout.this.eOh) {
                    View childAt = ChooseColorLayout.this.getChildAt(ChooseColorLayout.this.eOh);
                    if (childAt instanceof com.baidu.tieba.pb.pb.main.emotion.view.a) {
                        ((com.baidu.tieba.pb.pb.main.emotion.view.a) childAt).setIsChooseView(false);
                    }
                    ChooseColorLayout.this.eOh = intValue;
                    ChooseColorLayout.this.eOg = ((com.baidu.tieba.pb.pb.main.emotion.view.a) view).getChooseColor();
                    ((com.baidu.tieba.pb.pb.main.emotion.view.a) view).setIsChooseView(true);
                    if (ChooseColorLayout.this.eOi != null) {
                        ChooseColorLayout.this.eOi.px(ChooseColorLayout.this.eOg);
                    }
                }
            }
        };
        init();
    }

    private void init() {
        this.mWidth = l.ad(getContext());
        this.eOd = getResources().getIntArray(d.b.choose_colors);
        this.mPadding = getResources().getDimensionPixelSize(d.f.ds24);
        this.eOe = (this.mWidth - (this.mPadding * 2)) / 8;
        this.eOf = (this.eOe - (getResources().getDimensionPixelSize(d.f.ds16) * 2)) / 2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.eOe, this.eOe);
        layoutParams.gravity = 17;
        for (int i = 0; i < this.eOd.length; i++) {
            com.baidu.tieba.pb.pb.main.emotion.view.a aVar = new com.baidu.tieba.pb.pb.main.emotion.view.a(getContext());
            aVar.setChooseColor(this.eOd[i]);
            aVar.setTag(Integer.valueOf(i));
            aVar.setRadius(this.eOf);
            if (i == 0) {
                aVar.setIsChooseView(true);
                this.eOg = this.eOd[i];
                this.eOh = i;
            }
            aVar.setOnClickListener(this.auo);
            addView(aVar, layoutParams);
        }
        setPadding(this.mPadding, 0, this.mPadding, getResources().getDimensionPixelSize(d.f.ds20));
    }

    public int getCurrentChooseColor() {
        return this.eOg;
    }

    public void setOnChooseColorChangeListener(a aVar) {
        this.eOi = aVar;
    }
}
