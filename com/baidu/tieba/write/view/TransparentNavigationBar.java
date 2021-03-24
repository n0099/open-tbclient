package com.baidu.tieba.write.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import d.b.b.a.f;
/* loaded from: classes5.dex */
public class TransparentNavigationBar extends NavigationBar {
    public TransparentNavigationBar(Context context) {
        super(context);
    }

    @Override // com.baidu.tbadk.core.view.NavigationBar
    public void onChangeSkinType(f<?> fVar, int i) {
        SkinManager.setBackgroundColor(this, R.color.common_color_10094);
        initPadding();
    }

    public TransparentNavigationBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TransparentNavigationBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
