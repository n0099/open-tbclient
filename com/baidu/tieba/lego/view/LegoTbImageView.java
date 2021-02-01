package com.baidu.tieba.lego.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes9.dex */
public class LegoTbImageView extends TbImageView {
    public LegoTbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public LegoTbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LegoTbImageView(Context context) {
        this(context, null, 0);
    }

    private void init() {
        setDrawerType(6);
    }
}
