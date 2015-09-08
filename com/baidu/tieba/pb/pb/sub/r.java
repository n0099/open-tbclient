package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity cgV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(NewSubPbActivity newSubPbActivity) {
        this.cgV = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
    public void d(Object obj) {
        ak akVar;
        ak akVar2;
        ak akVar3;
        ak akVar4;
        ak akVar5;
        ak akVar6;
        ak akVar7;
        Object[] objArr = (Object[]) obj;
        String str = "";
        akVar = this.cgV.cgM;
        if (akVar.afD() != null) {
            akVar5 = this.cgV.cgM;
            if (akVar5.afD().adk() != null) {
                akVar6 = this.cgV.cgM;
                if (akVar6.afD().adk().getAuthor() != null) {
                    akVar7 = this.cgV.cgM;
                    str = String.valueOf(akVar7.afD().adk().getAuthor().getUserId());
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
        NewSubPbActivity newSubPbActivity = this.cgV;
        Activity pageActivity = this.cgV.getPageContext().getPageActivity();
        akVar2 = this.cgV.cgM;
        String id = akVar2.afD().adi().getId();
        akVar3 = this.cgV.cgM;
        String name = akVar3.afD().adi().getName();
        akVar4 = this.cgV.cgM;
        newSubPbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, akVar4.afD().adk().getId(), str, str2, str3)));
    }
}
