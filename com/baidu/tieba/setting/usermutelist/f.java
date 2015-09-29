package com.baidu.tieba.setting.usermutelist;

import android.content.DialogInterface;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnCancelListener {
    final /* synthetic */ UserMuteListActivity cOH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(UserMuteListActivity userMuteListActivity) {
        this.cOH = userMuteListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        m mVar;
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        UserMuteAddAndDelModel userMuteAddAndDelModel2;
        m mVar2;
        mVar = this.cOH.cOB;
        if (mVar != null) {
            mVar2 = this.cOH.cOB;
            mVar2.cancelLoadData();
        }
        userMuteAddAndDelModel = this.cOH.chY;
        if (userMuteAddAndDelModel != null) {
            userMuteAddAndDelModel2 = this.cOH.chY;
            userMuteAddAndDelModel2.cancelLoadData();
        }
    }
}
