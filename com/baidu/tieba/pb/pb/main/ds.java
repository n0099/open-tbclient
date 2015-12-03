package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ds implements View.OnClickListener {
    private final /* synthetic */ String bCJ;
    private final /* synthetic */ String bCK;
    private final /* synthetic */ String bNq;
    private final /* synthetic */ long bau;
    final /* synthetic */ da cGh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ds(da daVar, long j, String str, String str2, String str3) {
        this.cGh = daVar;
        this.bau = j;
        this.bCJ = str;
        this.bNq = str2;
        this.bCK = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        PbActivity pbActivity4;
        PbActivity pbActivity5;
        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c106628").ab("obj_id", String.valueOf(this.bau)));
        pbActivity = this.cGh.cCy;
        if (com.baidu.tbadk.core.util.bj.ah(pbActivity.getActivity())) {
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(this.bau))) {
                pbActivity5 = this.cGh.cCy;
                pbActivity5.showToast(n.i.can_not_send_gift_to_yourself);
            } else if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(GiftTabActivityConfig.class)) {
                pbActivity3 = this.cGh.cCy;
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(pbActivity3.getActivity(), this.bau, this.bCJ, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.h.b.c(this.bNq, 0L), com.baidu.adp.lib.h.b.c(this.bCK, 0L)));
                pbActivity4 = this.cGh.cCy;
                pbActivity4.sendMessage(customMessage);
            } else {
                pbActivity2 = this.cGh.cCy;
                pbActivity2.showToast(n.i.plugin_config_not_found);
            }
        }
    }
}
