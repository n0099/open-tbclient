package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements r {
    final /* synthetic */ NewSubPbActivity bPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(NewSubPbActivity newSubPbActivity) {
        this.bPw = newSubPbActivity;
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
        akVar = this.bPw.bPn;
        if (akVar.adB() != null) {
            akVar5 = this.bPw.bPn;
            if (akVar5.adB().aaH() != null) {
                akVar6 = this.bPw.bPn;
                if (akVar6.adB().aaH().getAuthor() != null) {
                    akVar7 = this.bPw.bPn;
                    str = String.valueOf(akVar7.adB().aaH().getAuthor().getUserId());
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
        NewSubPbActivity newSubPbActivity = this.bPw;
        Activity pageActivity = this.bPw.getPageContext().getPageActivity();
        akVar2 = this.bPw.bPn;
        String id = akVar2.adB().aaF().getId();
        akVar3 = this.bPw.bPn;
        String name = akVar3.adB().aaF().getName();
        akVar4 = this.bPw.bPn;
        newSubPbActivity.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(pageActivity, id, name, akVar4.adB().aaH().getId(), str, str2, str3)));
    }
}
