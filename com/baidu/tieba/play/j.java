package com.baidu.tieba.play;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements a.b {
    final /* synthetic */ c eUa;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar, String str) {
        this.eUa = cVar;
        this.val$url = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        c.eTK = true;
        this.eUa.startPlay(this.val$url);
        aVar.dismiss();
    }
}
