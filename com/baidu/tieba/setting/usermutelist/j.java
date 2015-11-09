package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.tieba.setting.usermutelist.h;
import tbclient.UserMuteQuery.MuteUser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ h cQE;
    private final /* synthetic */ MuteUser cQF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, MuteUser muteUser) {
        this.cQE = hVar;
        this.cQF = muteUser;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h.a aVar;
        h.a aVar2;
        aVar = this.cQE.cQB;
        if (aVar != null && this.cQF.user_id != null && this.cQF.user_name != null) {
            aVar2 = this.cQE.cQB;
            aVar2.h(this.cQF.user_id.longValue(), this.cQF.user_name);
        }
    }
}
