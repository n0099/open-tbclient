package com.baidu.tieba.tbadkCore.bubble;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.d;
/* loaded from: classes.dex */
class u implements d {
    private final /* synthetic */ x bWd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(x xVar) {
        this.bWd = xVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(a aVar) {
        aVar.dismiss();
        if (this.bWd != null) {
            this.bWd.aeM();
        }
    }
}
