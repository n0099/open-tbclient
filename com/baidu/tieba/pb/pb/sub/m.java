package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity eqU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NewSubPbActivity newSubPbActivity) {
        this.eqU = newSubPbActivity;
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
        subPbModel = this.eqU.eqD;
        if (subPbModel.aNe() != null) {
            subPbModel5 = this.eqU.eqD;
            if (subPbModel5.aNe().JB() != null) {
                subPbModel6 = this.eqU.eqD;
                if (subPbModel6.aNe().JB().getAuthor() != null) {
                    subPbModel7 = this.eqU.eqD;
                    str = String.valueOf(subPbModel7.aNe().JB().getAuthor().getUserId());
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
        NewSubPbActivity newSubPbActivity = this.eqU;
        Activity pageActivity = this.eqU.getPageContext().getPageActivity();
        subPbModel2 = this.eqU.eqD;
        String id = subPbModel2.aNe().aIx().getId();
        subPbModel3 = this.eqU.eqD;
        String name = subPbModel3.aNe().aIx().getName();
        subPbModel4 = this.eqU.eqD;
        newSubPbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, subPbModel4.aNe().JB().getId(), str, str2, str3)));
    }
}
