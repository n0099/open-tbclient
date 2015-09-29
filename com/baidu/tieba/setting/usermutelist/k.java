package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.tieba.setting.usermutelist.h;
import tbclient.UserMuteQuery.MuteUser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ h cOJ;
    private final /* synthetic */ MuteUser cOK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar, MuteUser muteUser) {
        this.cOJ = hVar;
        this.cOK = muteUser;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h.a aVar;
        h.a aVar2;
        aVar = this.cOJ.cOG;
        if (aVar != null && this.cOK.user_id != null && this.cOK.user_name != null) {
            aVar2 = this.cOJ.cOG;
            aVar2.h(this.cOK.user_id.longValue(), this.cOK.user_name);
        }
    }
}
