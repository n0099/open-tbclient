package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.tieba.setting.usermutelist.h;
import tbclient.UserMuteQuery.MuteUser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h cHI;
    private final /* synthetic */ MuteUser cHJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, MuteUser muteUser) {
        this.cHI = hVar;
        this.cHJ = muteUser;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h.b bVar;
        h.b bVar2;
        bVar = this.cHI.cHE;
        if (bVar != null && this.cHJ.user_id != null && this.cHJ.user_name != null) {
            bVar2 = this.cHI.cHE;
            bVar2.f(this.cHJ.user_id.longValue(), this.cHJ.user_name);
        }
    }
}
