package com.baidu.tieba.setting.usermutelist;

import android.content.DialogInterface;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnCancelListener {
    final /* synthetic */ UserMuteListActivity eeP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(UserMuteListActivity userMuteListActivity) {
        this.eeP = userMuteListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        m mVar;
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        UserMuteAddAndDelModel userMuteAddAndDelModel2;
        m mVar2;
        mVar = this.eeP.eeJ;
        if (mVar != null) {
            mVar2 = this.eeP.eeJ;
            mVar2.cancelLoadData();
        }
        userMuteAddAndDelModel = this.eeP.dgD;
        if (userMuteAddAndDelModel != null) {
            userMuteAddAndDelModel2 = this.eeP.dgD;
            userMuteAddAndDelModel2.cancelLoadData();
        }
    }
}
