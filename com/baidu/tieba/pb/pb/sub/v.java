package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity cHd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(NewSubPbActivity newSubPbActivity) {
        this.cHd = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
    public void d(Object obj) {
        an anVar;
        an anVar2;
        an anVar3;
        an anVar4;
        an anVar5;
        an anVar6;
        an anVar7;
        Object[] objArr = (Object[]) obj;
        String str = "";
        anVar = this.cHd.cGS;
        if (anVar.amF() != null) {
            anVar5 = this.cHd.cGS;
            if (anVar5.amF().ajT() != null) {
                anVar6 = this.cHd.cGS;
                if (anVar6.amF().ajT().getAuthor() != null) {
                    anVar7 = this.cHd.cGS;
                    str = String.valueOf(anVar7.amF().ajT().getAuthor().getUserId());
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
        NewSubPbActivity newSubPbActivity = this.cHd;
        Activity pageActivity = this.cHd.getPageContext().getPageActivity();
        anVar2 = this.cHd.cGS;
        String id = anVar2.amF().ajR().getId();
        anVar3 = this.cHd.cGS;
        String name = anVar3.amF().ajR().getName();
        anVar4 = this.cHd.cGS;
        newSubPbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, anVar4.amF().ajT().getId(), str, str2, str3)));
    }
}
