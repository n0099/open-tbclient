package com.baidu.tieba.usermute;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a.b {
    private final /* synthetic */ String aUn;
    final /* synthetic */ UserMuteAddAndDelModel eED;
    private final /* synthetic */ String eEE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(UserMuteAddAndDelModel userMuteAddAndDelModel, String str, String str2) {
        this.eED = userMuteAddAndDelModel;
        this.aUn = str;
        this.eEE = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        UserMuteAddAndDelModel.From from;
        UserMuteAddAndDelModel.From from2;
        String str;
        from = this.eED.eEw;
        if (from != UserMuteAddAndDelModel.From.PB) {
            from2 = this.eED.eEw;
            if (from2 == UserMuteAddAndDelModel.From.PersonInfo) {
                TiebaStatic.log("c10041");
            }
        } else {
            TiebaStatic.log("c10033");
        }
        this.eED.akp();
        UserMuteAddAndDelModel userMuteAddAndDelModel = this.eED;
        str = this.eED.eEC;
        userMuteAddAndDelModel.C(str, this.aUn, this.eEE);
        aVar.dismiss();
    }
}
