package com.baidu.tieba.pb.main;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements bg {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.bg
    public void c(Object obj) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bq bqVar4;
        bqVar = this.bzj.byJ;
        String valueOf = String.valueOf(bqVar.getPbData().getUserData().getUserId());
        String valueOf2 = String.valueOf(((Object[]) obj)[1]);
        PbActivity pbActivity = this.bzj;
        Activity pageActivity = this.bzj.getPageContext().getPageActivity();
        bqVar2 = this.bzj.byJ;
        String id = bqVar2.getPbData().aej().getId();
        bqVar3 = this.bzj.byJ;
        String name = bqVar3.getPbData().aej().getName();
        bqVar4 = this.bzj.byJ;
        pbActivity.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(pageActivity, id, name, bqVar4.getPbData().agE().getId(), valueOf, valueOf2)));
    }
}
