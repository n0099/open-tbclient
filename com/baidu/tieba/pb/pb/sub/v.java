package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity cLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NewSubPbActivity newSubPbActivity) {
        this.cLc = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
    public void d(Object obj) {
        ao aoVar;
        ao aoVar2;
        ao aoVar3;
        ao aoVar4;
        ao aoVar5;
        ao aoVar6;
        ao aoVar7;
        Object[] objArr = (Object[]) obj;
        String str = "";
        aoVar = this.cLc.cKR;
        if (aoVar.anR() != null) {
            aoVar5 = this.cLc.cKR;
            if (aoVar5.anR().Iv() != null) {
                aoVar6 = this.cLc.cKR;
                if (aoVar6.anR().Iv().getAuthor() != null) {
                    aoVar7 = this.cLc.cKR;
                    str = String.valueOf(aoVar7.anR().Iv().getAuthor().getUserId());
                }
            }
        }
        String str2 = "";
        if (objArr.length > 1) {
            str2 = String.valueOf(objArr[1]);
        }
        String str3 = "";
        if (objArr.length > 2) {
            str3 = String.valueOf(objArr[2]);
        }
        NewSubPbActivity newSubPbActivity = this.cLc;
        Activity pageActivity = this.cLc.getPageContext().getPageActivity();
        aoVar2 = this.cLc.cKR;
        String id = aoVar2.anR().akZ().getId();
        aoVar3 = this.cLc.cKR;
        String name = aoVar3.anR().akZ().getName();
        aoVar4 = this.cLc.cKR;
        newSubPbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, aoVar4.anR().Iv().getId(), str, str2, str3)));
    }
}
