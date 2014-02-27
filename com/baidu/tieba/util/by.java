package com.baidu.tieba.util;

import android.app.Activity;
/* loaded from: classes.dex */
final class by implements ca {
    final /* synthetic */ TbWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(TbWebViewActivity tbWebViewActivity) {
        this.a = tbWebViewActivity;
    }

    @Override // com.baidu.tieba.util.ca
    public final Object a(Activity activity) {
        return new TbJsBridge(activity);
    }
}
