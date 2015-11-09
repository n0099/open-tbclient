package com.baidu.tieba.usermute;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    private final /* synthetic */ String boT;
    private final /* synthetic */ String byk;
    final /* synthetic */ UserMuteAddAndDelModel dkH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(UserMuteAddAndDelModel userMuteAddAndDelModel, String str, String str2) {
        this.dkH = userMuteAddAndDelModel;
        this.byk = str;
        this.boT = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        UserMuteAddAndDelModel.From from;
        UserMuteAddAndDelModel.From from2;
        String str;
        from = this.dkH.dkA;
        if (from != UserMuteAddAndDelModel.From.PB) {
            from2 = this.dkH.dkA;
            if (from2 == UserMuteAddAndDelModel.From.PersonInfo) {
                TiebaStatic.log("c10041");
            }
        } else {
            TiebaStatic.log("c10033");
        }
        this.dkH.Zw();
        UserMuteAddAndDelModel userMuteAddAndDelModel = this.dkH;
        str = this.dkH.dkG;
        userMuteAddAndDelModel.s(str, this.byk, this.boT);
        aVar.dismiss();
    }
}
