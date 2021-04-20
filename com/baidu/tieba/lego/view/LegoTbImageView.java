package com.baidu.tieba.lego.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class LegoTbImageView extends TbImageView {
    public LegoTbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        G();
    }

    public final void G() {
        setDrawerType(6);
    }

    public LegoTbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LegoTbImageView(Context context) {
        this(context, null, 0);
    }
}
