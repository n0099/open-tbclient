package com.baidu.tieba.themeCenter;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.b {
    final /* synthetic */ d deg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.deg = dVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar2 = this.deg.Lt;
        aVar2.dismiss();
    }
}
