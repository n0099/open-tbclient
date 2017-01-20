package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity erC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NewSubPbActivity newSubPbActivity) {
        this.erC = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
    public void g(Object obj) {
        SubPbModel subPbModel;
        SubPbModel subPbModel2;
        SubPbModel subPbModel3;
        SubPbModel subPbModel4;
        SubPbModel subPbModel5;
        SubPbModel subPbModel6;
        SubPbModel subPbModel7;
        Object[] objArr = (Object[]) obj;
        String str = "";
        subPbModel = this.erC.erl;
        if (subPbModel.aPn() != null) {
            subPbModel5 = this.erC.erl;
            if (subPbModel5.aPn().Ji() != null) {
                subPbModel6 = this.erC.erl;
                if (subPbModel6.aPn().Ji().getAuthor() != null) {
                    subPbModel7 = this.erC.erl;
                    str = String.valueOf(subPbModel7.aPn().Ji().getAuthor().getUserId());
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
        NewSubPbActivity newSubPbActivity = this.erC;
        Activity pageActivity = this.erC.getPageContext().getPageActivity();
        subPbModel2 = this.erC.erl;
        String id = subPbModel2.aPn().aKC().getId();
        subPbModel3 = this.erC.erl;
        String name = subPbModel3.aPn().aKC().getName();
        subPbModel4 = this.erC.erl;
        newSubPbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, subPbModel4.aPn().Ji().getId(), str, str2, str3)));
    }
}
