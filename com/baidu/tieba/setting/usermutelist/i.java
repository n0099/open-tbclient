package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.tieba.setting.usermutelist.h;
import tbclient.UserMuteQuery.MuteUser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h cQE;
    private final /* synthetic */ MuteUser cQF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, MuteUser muteUser) {
        this.cQE = hVar;
        this.cQF = muteUser;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h.b bVar;
        h.b bVar2;
        bVar = this.cQE.cQA;
        if (bVar != null && this.cQF.user_id != null && this.cQF.user_name != null) {
            bVar2 = this.cQE.cQA;
            bVar2.g(this.cQF.user_id.longValue(), this.cQF.user_name);
        }
    }
}
