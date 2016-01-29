package com.baidu.tieba.usermute;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    private final /* synthetic */ String bUY;
    final /* synthetic */ UserMuteAddAndDelModel eld;
    private final /* synthetic */ String ele;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(UserMuteAddAndDelModel userMuteAddAndDelModel, String str, String str2) {
        this.eld = userMuteAddAndDelModel;
        this.bUY = str;
        this.ele = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        UserMuteAddAndDelModel.From from;
        UserMuteAddAndDelModel.From from2;
        String str;
        from = this.eld.ekW;
        if (from != UserMuteAddAndDelModel.From.PB) {
            from2 = this.eld.ekW;
            if (from2 == UserMuteAddAndDelModel.From.PersonInfo) {
                TiebaStatic.log("c10041");
            }
        } else {
            TiebaStatic.log("c10033");
        }
        this.eld.agV();
        UserMuteAddAndDelModel userMuteAddAndDelModel = this.eld;
        str = this.eld.elc;
        userMuteAddAndDelModel.A(str, this.bUY, this.ele);
        aVar.dismiss();
    }
}
