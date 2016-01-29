package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.tieba.setting.usermutelist.h;
import tbclient.UserMuteQuery.MuteUser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ h dMr;
    private final /* synthetic */ MuteUser dMs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, MuteUser muteUser) {
        this.dMr = hVar;
        this.dMs = muteUser;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h.a aVar;
        h.a aVar2;
        aVar = this.dMr.dMo;
        if (aVar != null && this.dMs.user_id != null && this.dMs.user_name != null) {
            aVar2 = this.dMr.dMo;
            aVar2.k(this.dMs.user_id.longValue(), this.dMs.user_name);
        }
    }
}
