package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c;

import android.annotation.TargetApi;
import android.content.Context;
@TargetApi(14)
/* loaded from: classes4.dex */
public class b extends a {
    public b(Context context) {
        super(context);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.a, com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c.d
    public boolean computeScrollOffset() {
        return this.mScroller.computeScrollOffset();
    }
}
