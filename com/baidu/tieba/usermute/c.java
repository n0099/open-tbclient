package com.baidu.tieba.usermute;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    private final /* synthetic */ String bGo;
    private final /* synthetic */ String bQW;
    final /* synthetic */ UserMuteAddAndDelModel dQt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(UserMuteAddAndDelModel userMuteAddAndDelModel, String str, String str2) {
        this.dQt = userMuteAddAndDelModel;
        this.bQW = str;
        this.bGo = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        UserMuteAddAndDelModel.From from;
        UserMuteAddAndDelModel.From from2;
        String str;
        from = this.dQt.dQm;
        if (from != UserMuteAddAndDelModel.From.PB) {
            from2 = this.dQt.dQm;
            if (from2 == UserMuteAddAndDelModel.From.PersonInfo) {
                TiebaStatic.log("c10041");
            }
        } else {
            TiebaStatic.log("c10033");
        }
        this.dQt.adL();
        UserMuteAddAndDelModel userMuteAddAndDelModel = this.dQt;
        str = this.dQt.dQs;
        userMuteAddAndDelModel.y(str, this.bQW, this.bGo);
        aVar.dismiss();
    }
}
