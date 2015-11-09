package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity cnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(NewSubPbActivity newSubPbActivity) {
        this.cnS = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
    public void d(Object obj) {
        am amVar;
        am amVar2;
        am amVar3;
        am amVar4;
        am amVar5;
        am amVar6;
        am amVar7;
        Object[] objArr = (Object[]) obj;
        String str = "";
        amVar = this.cnS.cnH;
        if (amVar.aic() != null) {
            amVar5 = this.cnS.cnH;
            if (amVar5.aic().afB() != null) {
                amVar6 = this.cnS.cnH;
                if (amVar6.aic().afB().getAuthor() != null) {
                    amVar7 = this.cnS.cnH;
                    str = String.valueOf(amVar7.aic().afB().getAuthor().getUserId());
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
        NewSubPbActivity newSubPbActivity = this.cnS;
        Activity pageActivity = this.cnS.getPageContext().getPageActivity();
        amVar2 = this.cnS.cnH;
        String id = amVar2.aic().afz().getId();
        amVar3 = this.cnS.cnH;
        String name = amVar3.aic().afz().getName();
        amVar4 = this.cnS.cnH;
        newSubPbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, amVar4.aic().afB().getId(), str, str2, str3)));
    }
}
