package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.tieba.setting.usermutelist.h;
import tbclient.UserMuteQuery.MuteUser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h cPi;
    private final /* synthetic */ MuteUser cPj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, MuteUser muteUser) {
        this.cPi = hVar;
        this.cPj = muteUser;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h.b bVar;
        h.b bVar2;
        bVar = this.cPi.cPe;
        if (bVar != null && this.cPj.user_id != null && this.cPj.user_name != null) {
            bVar2 = this.cPi.cPe;
            bVar2.g(this.cPj.user_id.longValue(), this.cPj.user_name);
        }
    }
}
