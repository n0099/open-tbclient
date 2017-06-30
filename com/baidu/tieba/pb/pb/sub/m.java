package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements NewSubPbActivity.a {
    final /* synthetic */ NewSubPbActivity eHC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NewSubPbActivity newSubPbActivity) {
        this.eHC = newSubPbActivity;
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
        subPbModel = this.eHC.eHl;
        if (subPbModel.aSm() != null) {
            subPbModel5 = this.eHC.eHl;
            if (subPbModel5.aSm().Mv() != null) {
                subPbModel6 = this.eHC.eHl;
                if (subPbModel6.aSm().Mv().getAuthor() != null) {
                    subPbModel7 = this.eHC.eHl;
                    str = String.valueOf(subPbModel7.aSm().Mv().getAuthor().getUserId());
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
        NewSubPbActivity newSubPbActivity = this.eHC;
        Activity pageActivity = this.eHC.getPageContext().getPageActivity();
        subPbModel2 = this.eHC.eHl;
        String id = subPbModel2.aSm().aNj().getId();
        subPbModel3 = this.eHC.eHl;
        String name = subPbModel3.aSm().aNj().getName();
        subPbModel4 = this.eHC.eHl;
        newSubPbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, subPbModel4.aSm().Mv().getId(), str, str2, str3)));
    }
}
