package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity esV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NewSubPbActivity newSubPbActivity) {
        this.esV = newSubPbActivity;
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
        subPbModel = this.esV.esE;
        if (subPbModel.aON() != null) {
            subPbModel5 = this.esV.esE;
            if (subPbModel5.aON().Kn() != null) {
                subPbModel6 = this.esV.esE;
                if (subPbModel6.aON().Kn().getAuthor() != null) {
                    subPbModel7 = this.esV.esE;
                    str = String.valueOf(subPbModel7.aON().Kn().getAuthor().getUserId());
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
        NewSubPbActivity newSubPbActivity = this.esV;
        Activity pageActivity = this.esV.getPageContext().getPageActivity();
        subPbModel2 = this.esV.esE;
        String id = subPbModel2.aON().aKb().getId();
        subPbModel3 = this.esV.esE;
        String name = subPbModel3.aON().aKb().getName();
        subPbModel4 = this.esV.esE;
        newSubPbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, subPbModel4.aON().Kn().getId(), str, str2, str3)));
    }
}
