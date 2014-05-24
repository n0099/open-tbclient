package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.core.view.NavigationBar;
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
    public void c(int i) {
        if (i == 1) {
            setBackgroundColor(getResources().getColor(com.baidu.tieba.s.navi_transparent_bg_1));
        } else {
            setBackgroundColor(getResources().getColor(com.baidu.tieba.s.navi_transparent_bg));
        }
        a();
    }
}
