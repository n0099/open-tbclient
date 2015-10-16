package com.baidu.tieba.setting.usermutelist;

import android.content.DialogInterface;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnCancelListener {
    final /* synthetic */ UserMuteListActivity cPg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(UserMuteListActivity userMuteListActivity) {
        this.cPg = userMuteListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        m mVar;
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        UserMuteAddAndDelModel userMuteAddAndDelModel2;
        m mVar2;
        mVar = this.cPg.cPa;
        if (mVar != null) {
            mVar2 = this.cPg.cPa;
            mVar2.cancelLoadData();
        }
        userMuteAddAndDelModel = this.cPg.cik;
        if (userMuteAddAndDelModel != null) {
            userMuteAddAndDelModel2 = this.cPg.cik;
            userMuteAddAndDelModel2.cancelLoadData();
        }
    }
}
