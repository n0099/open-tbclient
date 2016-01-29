package com.baidu.tieba.setting.usermutelist;

import android.content.DialogInterface;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnCancelListener {
    final /* synthetic */ UserMuteListActivity dMp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(UserMuteListActivity userMuteListActivity) {
        this.dMp = userMuteListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        m mVar;
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        UserMuteAddAndDelModel userMuteAddAndDelModel2;
        m mVar2;
        mVar = this.dMp.dMj;
        if (mVar != null) {
            mVar2 = this.dMp.dMj;
            mVar2.cancelLoadData();
        }
        userMuteAddAndDelModel = this.dMp.cMI;
        if (userMuteAddAndDelModel != null) {
            userMuteAddAndDelModel2 = this.dMp.cMI;
            userMuteAddAndDelModel2.cancelLoadData();
        }
    }
}
