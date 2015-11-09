package com.baidu.tieba.setting.usermutelist;

import android.content.DialogInterface;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnCancelListener {
    final /* synthetic */ UserMuteListActivity cQC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(UserMuteListActivity userMuteListActivity) {
        this.cQC = userMuteListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        m mVar;
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        UserMuteAddAndDelModel userMuteAddAndDelModel2;
        m mVar2;
        mVar = this.cQC.cQw;
        if (mVar != null) {
            mVar2 = this.cQC.cQw;
            mVar2.cancelLoadData();
        }
        userMuteAddAndDelModel = this.cQC.cjm;
        if (userMuteAddAndDelModel != null) {
            userMuteAddAndDelModel2 = this.cQC.cjm;
            userMuteAddAndDelModel2.cancelLoadData();
        }
    }
}
