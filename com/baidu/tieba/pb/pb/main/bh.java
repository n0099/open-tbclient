package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements PbActivity.a {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
    public void d(Object obj) {
        df dfVar;
        df dfVar2;
        df dfVar3;
        df dfVar4;
        Object[] objArr = (Object[]) obj;
        dfVar = this.dht.dfV;
        String valueOf = String.valueOf(dfVar.getPbData().getUserData().getUserId());
        String str = "";
        if (objArr.length > 1) {
            str = String.valueOf(objArr[1]);
        }
        String str2 = "";
        if (objArr.length > 2) {
            str2 = String.valueOf(objArr[2]);
        }
        PbActivity pbActivity = this.dht;
        Activity pageActivity = this.dht.getPageContext().getPageActivity();
        dfVar2 = this.dht.dfV;
        String id = dfVar2.getPbData().avu().getId();
        dfVar3 = this.dht.dfV;
        String name = dfVar3.getPbData().avu().getName();
        dfVar4 = this.dht.dfV;
        pbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, dfVar4.getPbData().avv().getId(), valueOf, str, str2)));
    }
}
