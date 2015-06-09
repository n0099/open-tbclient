package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements r {
    final /* synthetic */ NewSubPbActivity bPx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(NewSubPbActivity newSubPbActivity) {
        this.bPx = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.sub.r
    public void c(Object obj) {
        ak akVar;
        ak akVar2;
        ak akVar3;
        ak akVar4;
        ak akVar5;
        ak akVar6;
        ak akVar7;
        Object[] objArr = (Object[]) obj;
        String str = "";
        akVar = this.bPx.bPo;
        if (akVar.adC() != null) {
            akVar5 = this.bPx.bPo;
            if (akVar5.adC().aaI() != null) {
                akVar6 = this.bPx.bPo;
                if (akVar6.adC().aaI().getAuthor() != null) {
                    akVar7 = this.bPx.bPo;
                    str = String.valueOf(akVar7.adC().aaI().getAuthor().getUserId());
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
        NewSubPbActivity newSubPbActivity = this.bPx;
        Activity pageActivity = this.bPx.getPageContext().getPageActivity();
        akVar2 = this.bPx.bPo;
        String id = akVar2.adC().aaG().getId();
        akVar3 = this.bPx.bPo;
        String name = akVar3.adC().aaG().getName();
        akVar4 = this.bPx.bPo;
        newSubPbActivity.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(pageActivity, id, name, akVar4.adC().aaI().getId(), str, str2, str3)));
    }
}
