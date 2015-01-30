package com.baidu.tieba.tbadkCore.bubble;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.d;
/* loaded from: classes.dex */
class w implements d {
    private final /* synthetic */ x bXV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(x xVar) {
        this.bXV = xVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(a aVar) {
        aVar.dismiss();
        if (this.bXV != null) {
            this.bXV.afq();
        }
    }
}
