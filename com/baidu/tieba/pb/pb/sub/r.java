package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity cmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(NewSubPbActivity newSubPbActivity) {
        this.cmr = newSubPbActivity;
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
        akVar = this.cmr.cmi;
        if (akVar.ahA() != null) {
            akVar5 = this.cmr.cmi;
            if (akVar5.ahA().afi() != null) {
                akVar6 = this.cmr.cmi;
                if (akVar6.ahA().afi().getAuthor() != null) {
                    akVar7 = this.cmr.cmi;
                    str = String.valueOf(akVar7.ahA().afi().getAuthor().getUserId());
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
        NewSubPbActivity newSubPbActivity = this.cmr;
        Activity pageActivity = this.cmr.getPageContext().getPageActivity();
        akVar2 = this.cmr.cmi;
        String id = akVar2.ahA().afg().getId();
        akVar3 = this.cmr.cmi;
        String name = akVar3.ahA().afg().getName();
        akVar4 = this.cmr.cmi;
        newSubPbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, akVar4.ahA().afi().getId(), str, str2, str3)));
    }
}
