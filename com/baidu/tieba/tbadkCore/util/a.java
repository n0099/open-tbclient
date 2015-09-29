package com.baidu.tieba.tbadkCore.util;

import android.content.Context;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements a.b {
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.val$context = context;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        com.baidu.tbadk.browser.g.B(this.val$context, "http://tieba.baidu.com/mo/q/userappeal");
    }
}
