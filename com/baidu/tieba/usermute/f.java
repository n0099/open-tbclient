package com.baidu.tieba.usermute;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.b {
    private final /* synthetic */ String aQH;
    final /* synthetic */ UserMuteAddAndDelModel eVk;
    private final /* synthetic */ String eVl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(UserMuteAddAndDelModel userMuteAddAndDelModel, String str, String str2) {
        this.eVk = userMuteAddAndDelModel;
        this.aQH = str;
        this.eVl = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        UserMuteAddAndDelModel.From from;
        UserMuteAddAndDelModel.From from2;
        String str;
        from = this.eVk.eVd;
        if (from != UserMuteAddAndDelModel.From.PB) {
            from2 = this.eVk.eVd;
            if (from2 == UserMuteAddAndDelModel.From.PersonInfo) {
                TiebaStatic.log("c10041");
            }
        } else {
            TiebaStatic.log("c10033");
        }
        this.eVk.akv();
        UserMuteAddAndDelModel userMuteAddAndDelModel = this.eVk;
        str = this.eVk.eVj;
        userMuteAddAndDelModel.D(str, this.aQH, this.eVl);
        aVar.dismiss();
    }
}
