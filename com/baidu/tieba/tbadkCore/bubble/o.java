package com.baidu.tieba.tbadkCore.bubble;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.d;
/* loaded from: classes.dex */
class o implements d {
    private final /* synthetic */ BaseActivity baZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(BaseActivity baseActivity) {
        this.baZ = baseActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(a aVar) {
        aVar.dismiss();
        com.baidu.tbadk.core.i.A(this.baZ.getPageContext().getPageActivity(), "remind_expired");
    }
}
