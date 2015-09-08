package com.baidu.tieba.setting.usermutelist;

import android.content.DialogInterface;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnCancelListener {
    final /* synthetic */ UserMuteListActivity cHG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(UserMuteListActivity userMuteListActivity) {
        this.cHG = userMuteListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        com.baidu.tieba.usermute.k kVar;
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        UserMuteAddAndDelModel userMuteAddAndDelModel2;
        com.baidu.tieba.usermute.k kVar2;
        kVar = this.cHG.cHA;
        if (kVar != null) {
            kVar2 = this.cHG.cHA;
            kVar2.cancelLoadData();
        }
        userMuteAddAndDelModel = this.cHG.cbJ;
        if (userMuteAddAndDelModel != null) {
            userMuteAddAndDelModel2 = this.cHG.cbJ;
            userMuteAddAndDelModel2.cancelLoadData();
        }
    }
}
