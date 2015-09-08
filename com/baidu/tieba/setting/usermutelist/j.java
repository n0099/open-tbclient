package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.tieba.setting.usermutelist.h;
import tbclient.UserMuteQuery.MuteUser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ h cHI;
    private final /* synthetic */ MuteUser cHJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, MuteUser muteUser) {
        this.cHI = hVar;
        this.cHJ = muteUser;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h.a aVar;
        h.a aVar2;
        aVar = this.cHI.cHF;
        if (aVar != null && this.cHJ.user_id != null && this.cHJ.user_name != null) {
            aVar2 = this.cHI.cHF;
            aVar2.g(this.cHJ.user_id.longValue(), this.cHJ.user_name);
        }
    }
}
