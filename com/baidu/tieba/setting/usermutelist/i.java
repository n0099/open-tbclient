package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.tieba.setting.usermutelist.h;
import tbclient.UserMuteQuery.MuteUser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h dwn;
    private final /* synthetic */ MuteUser dwo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, MuteUser muteUser) {
        this.dwn = hVar;
        this.dwo = muteUser;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h.b bVar;
        h.b bVar2;
        bVar = this.dwn.dwj;
        if (bVar != null && this.dwo.user_id != null && this.dwo.user_name != null) {
            bVar2 = this.dwn.dwj;
            bVar2.j(this.dwo.user_id.longValue(), this.dwo.user_name);
        }
    }
}
