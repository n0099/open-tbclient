package com.baidu.tieba.tbadkCore.bubble;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.d;
/* loaded from: classes.dex */
class o implements d {
    private final /* synthetic */ BaseActivity baY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(BaseActivity baseActivity) {
        this.baY = baseActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(a aVar) {
        aVar.dismiss();
        com.baidu.tbadk.core.i.A(this.baY.getPageContext().getPageActivity(), "remind_expired");
    }
}
