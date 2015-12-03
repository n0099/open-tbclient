package com.baidu.tieba.setting.usermutelist;

import android.content.DialogInterface;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnCancelListener {
    final /* synthetic */ UserMuteListActivity doY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(UserMuteListActivity userMuteListActivity) {
        this.doY = userMuteListActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        m mVar;
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        UserMuteAddAndDelModel userMuteAddAndDelModel2;
        m mVar2;
        mVar = this.doY.doS;
        if (mVar != null) {
            mVar2 = this.doY.doS;
            mVar2.cancelLoadData();
        }
        userMuteAddAndDelModel = this.doY.cBJ;
        if (userMuteAddAndDelModel != null) {
            userMuteAddAndDelModel2 = this.doY.cBJ;
            userMuteAddAndDelModel2.cancelLoadData();
        }
    }
}
