package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity cTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NewSubPbActivity newSubPbActivity) {
        this.cTK = newSubPbActivity;
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
        aoVar = this.cTK.cTz;
        if (aoVar.asw() != null) {
            aoVar5 = this.cTK.cTz;
            if (aoVar5.asw().Ki() != null) {
                aoVar6 = this.cTK.cTz;
                if (aoVar6.asw().Ki().getAuthor() != null) {
                    aoVar7 = this.cTK.cTz;
                    str = String.valueOf(aoVar7.asw().Ki().getAuthor().getUserId());
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
        NewSubPbActivity newSubPbActivity = this.cTK;
        Activity pageActivity = this.cTK.getPageContext().getPageActivity();
        aoVar2 = this.cTK.cTz;
        String id = aoVar2.asw().aoX().getId();
        aoVar3 = this.cTK.cTz;
        String name = aoVar3.asw().aoX().getName();
        aoVar4 = this.cTK.cTz;
        newSubPbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, aoVar4.asw().Ki().getId(), str, str2, str3)));
    }
}
