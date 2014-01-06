package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import com.slidingmenu.lib.R;
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

    @Override // com.baidu.tieba.view.NavigationBar
    public void c(int i) {
        if (i == 1) {
            setBackgroundColor(getResources().getColor(R.color.navi_transparent_bg_1));
        } else {
            setBackgroundColor(getResources().getColor(R.color.navi_transparent_bg));
        }
        a();
    }
}
