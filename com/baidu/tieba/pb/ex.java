package com.baidu.tieba.pb;

import com.baidu.tbplugin.plugins.BdBrowserDelegate;
import com.baidu.tieba.recommend.WebviewHelper;
/* loaded from: classes.dex */
class ex implements BdBrowserDelegate.Callback {
    final /* synthetic */ WebBdActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ex(WebBdActivity webBdActivity) {
        this.a = webBdActivity;
    }

    @Override // com.baidu.tbplugin.plugins.BdBrowserDelegate.Callback
    public boolean shouldOverrideUrlLoading(String str) {
        return WebviewHelper.commonJumpHelper(this.a, str);
    }
}
