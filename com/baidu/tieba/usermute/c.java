package com.baidu.tieba.usermute;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    private final /* synthetic */ String btT;
    final /* synthetic */ UserMuteAddAndDelModel cOT;
    private final /* synthetic */ String cOU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(UserMuteAddAndDelModel userMuteAddAndDelModel, String str, String str2) {
        this.cOT = userMuteAddAndDelModel;
        this.btT = str;
        this.cOU = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        String str;
        this.cOT.Yv();
        UserMuteAddAndDelModel userMuteAddAndDelModel = this.cOT;
        str = this.cOT.cOS;
        userMuteAddAndDelModel.s(str, this.btT, this.cOU);
        aVar.dismiss();
    }
}
