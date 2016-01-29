package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.tieba.setting.usermutelist.h;
import tbclient.UserMuteQuery.MuteUser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h dMr;
    private final /* synthetic */ MuteUser dMs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, MuteUser muteUser) {
        this.dMr = hVar;
        this.dMs = muteUser;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h.b bVar;
        h.b bVar2;
        bVar = this.dMr.dMn;
        if (bVar != null && this.dMs.user_id != null && this.dMs.user_name != null) {
            bVar2 = this.dMr.dMn;
            bVar2.j(this.dMs.user_id.longValue(), this.dMs.user_name);
        }
    }
}
