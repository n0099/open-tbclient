package com.baidu.tieba.setting.usermutelist;

import android.content.DialogInterface;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnCancelListener {
    final /* synthetic */ UserMuteListActivity dwl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(UserMuteListActivity userMuteListActivity) {
        this.dwl = userMuteListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        m mVar;
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        UserMuteAddAndDelModel userMuteAddAndDelModel2;
        m mVar2;
        mVar = this.dwl.dwf;
        if (mVar != null) {
            mVar2 = this.dwl.dwf;
            mVar2.cancelLoadData();
        }
        userMuteAddAndDelModel = this.dwl.cFo;
        if (userMuteAddAndDelModel != null) {
            userMuteAddAndDelModel2 = this.dwl.cFo;
            userMuteAddAndDelModel2.cancelLoadData();
        }
    }
}
