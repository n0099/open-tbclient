package com.baidu.tieba.usermute;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    private final /* synthetic */ String buA;
    final /* synthetic */ UserMuteAddAndDelModel cXA;
    private final /* synthetic */ String cXB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(UserMuteAddAndDelModel userMuteAddAndDelModel, String str, String str2) {
        this.cXA = userMuteAddAndDelModel;
        this.buA = str;
        this.cXB = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        UserMuteAddAndDelModel.From from;
        UserMuteAddAndDelModel.From from2;
        String str;
        from = this.cXA.cXt;
        if (from != UserMuteAddAndDelModel.From.PB) {
            from2 = this.cXA.cXt;
            if (from2 == UserMuteAddAndDelModel.From.PersonInfo) {
                TiebaStatic.log(m.cXT);
            }
        } else {
            TiebaStatic.log(m.cXS);
        }
        this.cXA.Yx();
        UserMuteAddAndDelModel userMuteAddAndDelModel = this.cXA;
        str = this.cXA.cXz;
        userMuteAddAndDelModel.t(str, this.buA, this.cXB);
        aVar.dismiss();
    }
}
