package com.baidu.tieba.themeCenter;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class j implements a.b {
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a dgw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(com.baidu.tbadk.core.dialog.a aVar) {
        this.dgw = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.dgw.dismiss();
    }
}
