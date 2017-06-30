package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements PbActivity.a {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
    public void g(Object obj) {
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        if (!com.baidu.adp.lib.util.i.hj()) {
            this.ewh.showToast(w.l.network_not_available);
            return;
        }
        Object[] objArr = (Object[]) obj;
        pbModel = this.ewh.eue;
        String valueOf = String.valueOf(pbModel.getPbData().getUserData().getUserId());
        String str = "";
        if (objArr.length > 1) {
            str = String.valueOf(objArr[1]);
        }
        String str2 = "";
        if (objArr.length > 2) {
            str2 = String.valueOf(objArr[2]);
        }
        PbActivity pbActivity = this.ewh;
        Activity pageActivity = this.ewh.getPageContext().getPageActivity();
        pbModel2 = this.ewh.eue;
        String id = pbModel2.getPbData().aMt().getId();
        pbModel3 = this.ewh.eue;
        String name = pbModel3.getPbData().aMt().getName();
        pbModel4 = this.ewh.eue;
        pbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, pbModel4.getPbData().aMv().getId(), valueOf, str, str2)));
    }
}
