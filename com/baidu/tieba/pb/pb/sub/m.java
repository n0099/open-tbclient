package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity evm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NewSubPbActivity newSubPbActivity) {
        this.evm = newSubPbActivity;
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
        subPbModel = this.evm.euV;
        if (subPbModel.aPO() != null) {
            subPbModel5 = this.evm.euV;
            if (subPbModel5.aPO().Kn() != null) {
                subPbModel6 = this.evm.euV;
                if (subPbModel6.aPO().Kn().getAuthor() != null) {
                    subPbModel7 = this.evm.euV;
                    str = String.valueOf(subPbModel7.aPO().Kn().getAuthor().getUserId());
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
        NewSubPbActivity newSubPbActivity = this.evm;
        Activity pageActivity = this.evm.getPageContext().getPageActivity();
        subPbModel2 = this.evm.euV;
        String id = subPbModel2.aPO().aLc().getId();
        subPbModel3 = this.evm.euV;
        String name = subPbModel3.aPO().aLc().getName();
        subPbModel4 = this.evm.euV;
        newSubPbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, subPbModel4.aPO().Kn().getId(), str, str2, str3)));
    }
}
