package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity dWP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewSubPbActivity newSubPbActivity) {
        this.dWP = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
    public void d(Object obj) {
        aw awVar;
        aw awVar2;
        aw awVar3;
        aw awVar4;
        aw awVar5;
        aw awVar6;
        aw awVar7;
        Object[] objArr = (Object[]) obj;
        String str = "";
        awVar = this.dWP.dWC;
        if (awVar.aIH() != null) {
            awVar5 = this.dWP.dWC;
            if (awVar5.aIH().Ix() != null) {
                awVar6 = this.dWP.dWC;
                if (awVar6.aIH().Ix().getAuthor() != null) {
                    awVar7 = this.dWP.dWC;
                    str = String.valueOf(awVar7.aIH().Ix().getAuthor().getUserId());
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
        NewSubPbActivity newSubPbActivity = this.dWP;
        Activity pageActivity = this.dWP.getPageContext().getPageActivity();
        awVar2 = this.dWP.dWC;
        String id = awVar2.aIH().aEl().getId();
        awVar3 = this.dWP.dWC;
        String name = awVar3.aIH().aEl().getName();
        awVar4 = this.dWP.dWC;
        newSubPbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, awVar4.aIH().Ix().getId(), str, str2, str3)));
    }
}
