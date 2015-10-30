package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements PbActivity.a {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.ciK = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
    public void d(Object obj) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        Object[] objArr = (Object[]) obj;
        blVar = this.ciK.cih;
        String valueOf = String.valueOf(blVar.getPbData().getUserData().getUserId());
        String str = "";
        if (objArr.length > 1) {
            str = String.valueOf(objArr[1]);
        }
        String str2 = "";
        if (objArr.length > 2) {
            str2 = String.valueOf(objArr[2]);
        }
        PbActivity pbActivity = this.ciK;
        Activity pageActivity = this.ciK.getPageContext().getPageActivity();
        blVar2 = this.ciK.cih;
        String id = blVar2.getPbData().aeJ().getId();
        blVar3 = this.ciK.cih;
        String name = blVar3.getPbData().aeJ().getName();
        blVar4 = this.ciK.cih;
        pbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, blVar4.getPbData().aeK().getId(), valueOf, str, str2)));
    }
}
