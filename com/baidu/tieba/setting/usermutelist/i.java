package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.tieba.setting.usermutelist.h;
import tbclient.UserMuteQuery.MuteUser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h czk;
    private final /* synthetic */ MuteUser czl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, MuteUser muteUser) {
        this.czk = hVar;
        this.czl = muteUser;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h.b bVar;
        h.b bVar2;
        bVar = this.czk.czg;
        if (bVar != null && this.czl.user_id != null && this.czl.user_name != null) {
            bVar2 = this.czk.czg;
            bVar2.f(this.czl.user_id.longValue(), this.czl.user_name);
        }
    }
}
