package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements a.b {
    final /* synthetic */ WriteUrlActivity gmD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(WriteUrlActivity writeUrlActivity) {
        this.gmD = writeUrlActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
    }
}
