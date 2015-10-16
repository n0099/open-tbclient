package com.baidu.tieba.usermute;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    private final /* synthetic */ String bop;
    private final /* synthetic */ String bxN;
    final /* synthetic */ UserMuteAddAndDelModel djb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(UserMuteAddAndDelModel userMuteAddAndDelModel, String str, String str2) {
        this.djb = userMuteAddAndDelModel;
        this.bxN = str;
        this.bop = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        UserMuteAddAndDelModel.From from;
        UserMuteAddAndDelModel.From from2;
        String str;
        from = this.djb.diU;
        if (from != UserMuteAddAndDelModel.From.PB) {
            from2 = this.djb.diU;
            if (from2 == UserMuteAddAndDelModel.From.PersonInfo) {
                TiebaStatic.log("c10041");
            }
        } else {
            TiebaStatic.log("c10033");
        }
        this.djb.Zf();
        UserMuteAddAndDelModel userMuteAddAndDelModel = this.djb;
        str = this.djb.dja;
        userMuteAddAndDelModel.s(str, this.bxN, this.bop);
        aVar.dismiss();
    }
}
