package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
/* loaded from: classes3.dex */
public class AdThreadUserInfoLayout extends ThreadUserInfoLayout {
    public AdThreadUserInfoLayout(Context context) {
        super(context);
    }

    public AdThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tbadk.core.view.ThreadUserInfoLayout
    protected String fZ(String str) {
        return ao.A(str, 16);
    }
}
