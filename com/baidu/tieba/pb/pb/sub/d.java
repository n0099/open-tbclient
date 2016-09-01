package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity evy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NewSubPbActivity newSubPbActivity) {
        this.evy = newSubPbActivity;
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
        axVar = this.evy.evl;
        if (axVar.aQK() != null) {
            axVar5 = this.evy.evl;
            if (axVar5.aQK().Kw() != null) {
                axVar6 = this.evy.evl;
                if (axVar6.aQK().Kw().getAuthor() != null) {
                    axVar7 = this.evy.evl;
                    str = String.valueOf(axVar7.aQK().Kw().getAuthor().getUserId());
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
        NewSubPbActivity newSubPbActivity = this.evy;
        Activity pageActivity = this.evy.getPageContext().getPageActivity();
        axVar2 = this.evy.evl;
        String id = axVar2.aQK().aMn().getId();
        axVar3 = this.evy.evl;
        String name = axVar3.aQK().aMn().getName();
        axVar4 = this.evy.evl;
        newSubPbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, axVar4.aQK().Kw().getId(), str, str2, str3)));
    }
}
