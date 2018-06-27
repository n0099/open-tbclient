package com.baidu.tieba.write.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class TransparentNavigationBar extends NavigationBar {
    public TransparentNavigationBar(Context context) {
        super(context);
    }

    public TransparentNavigationBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TransparentNavigationBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar
    public void onChangeSkinType(e<?> eVar, int i) {
        am.j(this, d.C0142d.common_color_10094);
        initPadding();
    }
}
