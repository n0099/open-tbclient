package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.tieba.setting.usermutelist.h;
import tbclient.UserMuteQuery.MuteUser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h eeR;
    private final /* synthetic */ MuteUser eeS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, MuteUser muteUser) {
        this.eeR = hVar;
        this.eeS = muteUser;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h.b bVar;
        h.b bVar2;
        bVar = this.eeR.eeN;
        if (bVar != null && this.eeS.user_id != null && this.eeS.user_name != null) {
            bVar2 = this.eeR.eeN;
            bVar2.s(this.eeS.user_id.longValue(), this.eeS.user_name);
        }
    }
}
