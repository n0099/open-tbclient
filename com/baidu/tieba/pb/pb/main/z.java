package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements PbActivity.a {
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.ciz = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
    public void d(Object obj) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        Object[] objArr = (Object[]) obj;
        blVar = this.ciz.chV;
        String valueOf = String.valueOf(blVar.getPbData().getUserData().getUserId());
        String str = "";
        if (objArr.length > 1) {
            str = String.valueOf(objArr[1]);
        }
        String str2 = "";
        if (objArr.length > 2) {
            str2 = String.valueOf(objArr[2]);
        }
        PbActivity pbActivity = this.ciz;
        Activity pageActivity = this.ciz.getPageContext().getPageActivity();
        blVar2 = this.ciz.chV;
        String id = blVar2.getPbData().aeN().getId();
        blVar3 = this.ciz.chV;
        String name = blVar3.getPbData().aeN().getName();
        blVar4 = this.ciz.chV;
        pbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, blVar4.getPbData().aeO().getId(), valueOf, str, str2)));
    }
}
