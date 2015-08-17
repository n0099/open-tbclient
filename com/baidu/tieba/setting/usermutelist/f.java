package com.baidu.tieba.setting.usermutelist;

import android.content.DialogInterface;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnCancelListener {
    final /* synthetic */ UserMuteListActivity czi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(UserMuteListActivity userMuteListActivity) {
        this.czi = userMuteListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        com.baidu.tieba.usermute.k kVar;
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        UserMuteAddAndDelModel userMuteAddAndDelModel2;
        com.baidu.tieba.usermute.k kVar2;
        kVar = this.czi.czc;
        if (kVar != null) {
            kVar2 = this.czi.czc;
            kVar2.cancelLoadData();
        }
        userMuteAddAndDelModel = this.czi.caO;
        if (userMuteAddAndDelModel != null) {
            userMuteAddAndDelModel2 = this.czi.caO;
            userMuteAddAndDelModel2.cancelLoadData();
        }
    }
}
