package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.tieba.setting.usermutelist.h;
import tbclient.UserMuteQuery.MuteUser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h cOJ;
    private final /* synthetic */ MuteUser cOK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, MuteUser muteUser) {
        this.cOJ = hVar;
        this.cOK = muteUser;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h.b bVar;
        h.b bVar2;
        bVar = this.cOJ.cOF;
        if (bVar != null && this.cOK.user_id != null && this.cOK.user_name != null) {
            bVar2 = this.cOJ.cOF;
            bVar2.g(this.cOK.user_id.longValue(), this.cOK.user_name);
        }
    }
}
