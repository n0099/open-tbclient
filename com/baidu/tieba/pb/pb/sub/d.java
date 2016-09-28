package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity exF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NewSubPbActivity newSubPbActivity) {
        this.exF = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
    public void g(Object obj) {
        ax axVar;
        ax axVar2;
        ax axVar3;
        ax axVar4;
        ax axVar5;
        ax axVar6;
        ax axVar7;
        Object[] objArr = (Object[]) obj;
        String str = "";
        axVar = this.exF.exr;
        if (axVar.aRs() != null) {
            axVar5 = this.exF.exr;
            if (axVar5.aRs().Jv() != null) {
                axVar6 = this.exF.exr;
                if (axVar6.aRs().Jv().getAuthor() != null) {
                    axVar7 = this.exF.exr;
                    str = String.valueOf(axVar7.aRs().Jv().getAuthor().getUserId());
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
        NewSubPbActivity newSubPbActivity = this.exF;
        Activity pageActivity = this.exF.getPageContext().getPageActivity();
        axVar2 = this.exF.exr;
        String id = axVar2.aRs().aMT().getId();
        axVar3 = this.exF.exr;
        String name = axVar3.aRs().aMT().getName();
        axVar4 = this.exF.exr;
        newSubPbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, axVar4.aRs().Jv().getId(), str, str2, str3)));
    }
}
