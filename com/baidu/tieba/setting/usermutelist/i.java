package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.tieba.setting.usermutelist.h;
import tbclient.UserMuteQuery.MuteUser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h dpa;
    private final /* synthetic */ MuteUser dpb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, MuteUser muteUser) {
        this.dpa = hVar;
        this.dpb = muteUser;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h.b bVar;
        h.b bVar2;
        bVar = this.dpa.doW;
        if (bVar != null && this.dpb.user_id != null && this.dpb.user_name != null) {
            bVar2 = this.dpa.doW;
            bVar2.j(this.dpb.user_id.longValue(), this.dpb.user_name);
        }
    }
}
