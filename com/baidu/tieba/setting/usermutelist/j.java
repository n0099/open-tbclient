package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.tieba.setting.usermutelist.h;
import tbclient.UserMuteQuery.MuteUser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ h dpa;
    private final /* synthetic */ MuteUser dpb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, MuteUser muteUser) {
        this.dpa = hVar;
        this.dpb = muteUser;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h.a aVar;
        h.a aVar2;
        aVar = this.dpa.doX;
        if (aVar != null && this.dpb.user_id != null && this.dpb.user_name != null) {
            aVar2 = this.dpa.doX;
            aVar2.k(this.dpb.user_id.longValue(), this.dpb.user_name);
        }
    }
}
