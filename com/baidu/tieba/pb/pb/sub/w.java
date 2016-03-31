package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity doF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(NewSubPbActivity newSubPbActivity) {
        this.doF = newSubPbActivity;
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
        apVar = this.doF.dou;
        if (apVar.aAg() != null) {
            apVar5 = this.doF.dou;
            if (apVar5.aAg().LC() != null) {
                apVar6 = this.doF.dou;
                if (apVar6.aAg().LC().getAuthor() != null) {
                    apVar7 = this.doF.dou;
                    str = String.valueOf(apVar7.aAg().LC().getAuthor().getUserId());
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
        NewSubPbActivity newSubPbActivity = this.doF;
        Activity pageActivity = this.doF.getPageContext().getPageActivity();
        apVar2 = this.doF.dou;
        String id = apVar2.aAg().avP().getId();
        apVar3 = this.doF.dou;
        String name = apVar3.aAg().avP().getName();
        apVar4 = this.doF.dou;
        newSubPbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, apVar4.aAg().LC().getId(), str, str2, str3)));
    }
}
