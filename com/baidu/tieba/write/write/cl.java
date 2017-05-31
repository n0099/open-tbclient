package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements a.b {
    final /* synthetic */ WriteUrlActivity gbF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(WriteUrlActivity writeUrlActivity) {
        this.gbF = writeUrlActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.gbF.finish();
    }
}
