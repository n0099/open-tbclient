package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements PbActivity.a {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.a
    public void g(Object obj) {
        PbModel pbModel;
        PbModel pbModel2;
        PbModel pbModel3;
        PbModel pbModel4;
        if (!com.baidu.adp.lib.util.i.hk()) {
            this.ehy.showToast(w.l.network_not_available);
            return;
        }
        Object[] objArr = (Object[]) obj;
        pbModel = this.ehy.efE;
        String valueOf = String.valueOf(pbModel.getPbData().getUserData().getUserId());
        String str = "";
        if (objArr.length > 1) {
            str = String.valueOf(objArr[1]);
        }
        String str2 = "";
        if (objArr.length > 2) {
            str2 = String.valueOf(objArr[2]);
        }
        PbActivity pbActivity = this.ehy;
        Activity pageActivity = this.ehy.getPageContext().getPageActivity();
        pbModel2 = this.ehy.efE;
        String id = pbModel2.getPbData().aHE().getId();
        pbModel3 = this.ehy.efE;
        String name = pbModel3.getPbData().aHE().getName();
        pbModel4 = this.ehy.efE;
        pbActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(pageActivity, id, name, pbModel4.getPbData().aHG().getId(), valueOf, str, str2)));
    }
}
