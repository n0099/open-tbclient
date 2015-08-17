package com.baidu.tieba.setting.usermutelist;

import android.view.View;
import com.baidu.tieba.setting.usermutelist.h;
import tbclient.UserMuteQuery.MuteUser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ h czk;
    private final /* synthetic */ MuteUser czl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar, MuteUser muteUser) {
        this.czk = hVar;
        this.czl = muteUser;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h.a aVar;
        h.a aVar2;
        aVar = this.czk.czh;
        if (aVar != null && this.czl.user_id != null && this.czl.user_name != null) {
            aVar2 = this.czk.czh;
            aVar2.g(this.czl.user_id.longValue(), this.czl.user_name);
        }
    }
}
