package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.tieba.setting.usermutelist.h;
import tbclient.UserMuteQuery.MuteUser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ h dwn;
    private final /* synthetic */ MuteUser dwo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, MuteUser muteUser) {
        this.dwn = hVar;
        this.dwo = muteUser;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h.a aVar;
        h.a aVar2;
        aVar = this.dwn.dwk;
        if (aVar != null && this.dwo.user_id != null && this.dwo.user_name != null) {
            aVar2 = this.dwn.dwk;
            aVar2.k(this.dwo.user_id.longValue(), this.dwo.user_name);
        }
    }
}
