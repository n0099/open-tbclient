package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity eye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NewSubPbActivity newSubPbActivity) {
        this.eye = newSubPbActivity;
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
        subPbModel = this.eye.exN;
        if (subPbModel.aOn() != null) {
            subPbModel5 = this.eye.exN;
            if (subPbModel5.aOn().LH() != null) {
                subPbModel6 = this.eye.exN;
                if (subPbModel6.aOn().LH().getAuthor() != null) {
                    subPbModel7 = this.eye.exN;
                    str = String.valueOf(subPbModel7.aOn().LH().getAuthor().getUserId());
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
        NewSubPbActivity newSubPbActivity = this.eye;
        Activity pageActivity = this.eye.getPageContext().getPageActivity();
        subPbModel2 = this.eye.exN;
        String id = subPbModel2.aOn().aJp().getId();
        subPbModel3 = this.eye.exN;
        String name = subPbModel3.aOn().aJp().getName();
        subPbModel4 = this.eye.exN;
        newSubPbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, subPbModel4.aOn().LH().getId(), str, str2, str3)));
    }
}
