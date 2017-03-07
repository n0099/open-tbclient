package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity euQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NewSubPbActivity newSubPbActivity) {
        this.euQ = newSubPbActivity;
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
        subPbModel = this.euQ.euz;
        if (subPbModel.aOE() != null) {
            subPbModel5 = this.euQ.euz;
            if (subPbModel5.aOE().JN() != null) {
                subPbModel6 = this.euQ.euz;
                if (subPbModel6.aOE().JN().getAuthor() != null) {
                    subPbModel7 = this.euQ.euz;
                    str = String.valueOf(subPbModel7.aOE().JN().getAuthor().getUserId());
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
        NewSubPbActivity newSubPbActivity = this.euQ;
        Activity pageActivity = this.euQ.getPageContext().getPageActivity();
        subPbModel2 = this.euQ.euz;
        String id = subPbModel2.aOE().aJU().getId();
        subPbModel3 = this.euQ.euz;
        String name = subPbModel3.aOE().aJU().getName();
        subPbModel4 = this.euQ.euz;
        newSubPbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, subPbModel4.aOE().JN().getId(), str, str2, str3)));
    }
}
