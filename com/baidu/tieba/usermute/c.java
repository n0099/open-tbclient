package com.baidu.tieba.usermute;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    private final /* synthetic */ String bCK;
    private final /* synthetic */ String bNq;
    final /* synthetic */ UserMuteAddAndDelModel dIS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(UserMuteAddAndDelModel userMuteAddAndDelModel, String str, String str2) {
        this.dIS = userMuteAddAndDelModel;
        this.bNq = str;
        this.bCK = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        UserMuteAddAndDelModel.From from;
        UserMuteAddAndDelModel.From from2;
        String str;
        from = this.dIS.dIL;
        if (from != UserMuteAddAndDelModel.From.PB) {
            from2 = this.dIS.dIL;
            if (from2 == UserMuteAddAndDelModel.From.PersonInfo) {
                TiebaStatic.log("c10041");
            }
        } else {
            TiebaStatic.log("c10033");
        }
        this.dIS.acC();
        UserMuteAddAndDelModel userMuteAddAndDelModel = this.dIS;
        str = this.dIS.dIR;
        userMuteAddAndDelModel.x(str, this.bNq, this.bCK);
        aVar.dismiss();
    }
}
