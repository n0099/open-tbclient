package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.tieba.setting.usermutelist.h;
import tbclient.UserMuteQuery.MuteUser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ h eeR;
    private final /* synthetic */ MuteUser eeS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar, MuteUser muteUser) {
        this.eeR = hVar;
        this.eeS = muteUser;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h.a aVar;
        h.a aVar2;
        aVar = this.eeR.eeO;
        if (aVar != null && this.eeS.user_id != null && this.eeS.user_name != null) {
            aVar2 = this.eeR.eeO;
            aVar2.t(this.eeS.user_id.longValue(), this.eeS.user_name);
        }
    }
}
