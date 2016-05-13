package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(NewSubPbActivity newSubPbActivity) {
        this.dqn = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
    public void d(Object obj) {
        ap apVar;
        ap apVar2;
        ap apVar3;
        ap apVar4;
        ap apVar5;
        ap apVar6;
        ap apVar7;
        Object[] objArr = (Object[]) obj;
        String str = "";
        apVar = this.dqn.dqc;
        if (apVar.aAq() != null) {
            apVar5 = this.dqn.dqc;
            if (apVar5.aAq().Kn() != null) {
                apVar6 = this.dqn.dqc;
                if (apVar6.aAq().Kn().getAuthor() != null) {
                    apVar7 = this.dqn.dqc;
                    str = String.valueOf(apVar7.aAq().Kn().getAuthor().getUserId());
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
        NewSubPbActivity newSubPbActivity = this.dqn;
        Activity pageActivity = this.dqn.getPageContext().getPageActivity();
        apVar2 = this.dqn.dqc;
        String id = apVar2.aAq().avY().getId();
        apVar3 = this.dqn.dqc;
        String name = apVar3.aAq().avY().getName();
        apVar4 = this.dqn.dqc;
        newSubPbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, apVar4.aAq().Kn().getId(), str, str2, str3)));
    }
}
