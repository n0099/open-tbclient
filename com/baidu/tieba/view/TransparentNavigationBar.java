package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
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
    public void onChangeSkinType(com.baidu.adp.base.j<?> jVar, int i) {
        ax.j(this, t.navi_transparent_bg);
        initPadding();
    }
}
