package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity ejr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewSubPbActivity newSubPbActivity) {
        this.ejr = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
    public void g(Object obj) {
        aw awVar;
        aw awVar2;
        aw awVar3;
        aw awVar4;
        aw awVar5;
        aw awVar6;
        aw awVar7;
        Object[] objArr = (Object[]) obj;
        String str = "";
        awVar = this.ejr.eje;
        if (awVar.aLS() != null) {
            awVar5 = this.ejr.eje;
            if (awVar5.aLS().Iw() != null) {
                awVar6 = this.ejr.eje;
                if (awVar6.aLS().Iw().getAuthor() != null) {
                    awVar7 = this.ejr.eje;
                    str = String.valueOf(awVar7.aLS().Iw().getAuthor().getUserId());
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
        NewSubPbActivity newSubPbActivity = this.ejr;
        Activity pageActivity = this.ejr.getPageContext().getPageActivity();
        awVar2 = this.ejr.eje;
        String id = awVar2.aLS().aHv().getId();
        awVar3 = this.ejr.eje;
        String name = awVar3.aLS().aHv().getName();
        awVar4 = this.ejr.eje;
        newSubPbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, awVar4.aLS().Iw().getId(), str, str2, str3)));
    }
}
