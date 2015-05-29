package com.baidu.tieba.tbadkCore.c;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.k;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ BaseActivity bfU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BaseActivity baseActivity) {
        this.bfU = baseActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        k.A(this.bfU.getPageContext().getPageActivity(), "remind_expired");
    }
}
