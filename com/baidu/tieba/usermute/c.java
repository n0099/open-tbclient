package com.baidu.tieba.usermute;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    private final /* synthetic */ String boe;
    private final /* synthetic */ String bxC;
    final /* synthetic */ UserMuteAddAndDelModel diB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(UserMuteAddAndDelModel userMuteAddAndDelModel, String str, String str2) {
        this.diB = userMuteAddAndDelModel;
        this.bxC = str;
        this.boe = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        UserMuteAddAndDelModel.From from;
        UserMuteAddAndDelModel.From from2;
        String str;
        from = this.diB.diu;
        if (from != UserMuteAddAndDelModel.From.PB) {
            from2 = this.diB.diu;
            if (from2 == UserMuteAddAndDelModel.From.PersonInfo) {
                TiebaStatic.log("c10041");
            }
        } else {
            TiebaStatic.log("c10033");
        }
        this.diB.Zf();
        UserMuteAddAndDelModel userMuteAddAndDelModel = this.diB;
        str = this.diB.diA;
        userMuteAddAndDelModel.t(str, this.bxC, this.boe);
        aVar.dismiss();
    }
}
