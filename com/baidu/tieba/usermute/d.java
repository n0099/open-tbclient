package com.baidu.tieba.usermute;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a.b {
    private final /* synthetic */ String aQH;
    final /* synthetic */ UserMuteAddAndDelModel eVj;
    private final /* synthetic */ String eVk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(UserMuteAddAndDelModel userMuteAddAndDelModel, String str, String str2) {
        this.eVj = userMuteAddAndDelModel;
        this.aQH = str;
        this.eVk = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        UserMuteAddAndDelModel.From from;
        UserMuteAddAndDelModel.From from2;
        String str;
        from = this.eVj.eVc;
        if (from != UserMuteAddAndDelModel.From.PB) {
            from2 = this.eVj.eVc;
            if (from2 == UserMuteAddAndDelModel.From.PersonInfo) {
                TiebaStatic.log("c10041");
            }
        } else {
            TiebaStatic.log("c10033");
        }
        this.eVj.akx();
        UserMuteAddAndDelModel userMuteAddAndDelModel = this.eVj;
        str = this.eVj.eVi;
        userMuteAddAndDelModel.D(str, this.aQH, this.eVk);
        aVar.dismiss();
    }
}
