package com.baidu.tieba.tbadkCore.util;

import android.content.Context;
import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class h implements a.b {
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context) {
        this.val$context = context;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        com.baidu.tbadk.browser.g.B(this.val$context, "http://tieba.baidu.com/mo/q/userappeal");
    }
}
