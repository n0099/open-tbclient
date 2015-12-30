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
public class ec implements View.OnClickListener {
    private final /* synthetic */ String bGn;
    private final /* synthetic */ String bGo;
    private final /* synthetic */ String bQW;
    private final /* synthetic */ long bes;
    final /* synthetic */ dk cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ec(dk dkVar, long j, String str, String str2, String str3) {
        this.cKg = dkVar;
        this.bes = j;
        this.bGn = str;
        this.bQW = str2;
        this.bGo = str3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        PbActivity pbActivity4;
        PbActivity pbActivity5;
        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c106628").aa("obj_id", String.valueOf(this.bes)));
        pbActivity = this.cKg.cGj;
        if (com.baidu.tbadk.core.util.bj.ah(pbActivity.getActivity())) {
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(this.bes))) {
                pbActivity5 = this.cKg.cGj;
                pbActivity5.showToast(n.j.can_not_send_gift_to_yourself);
            } else if (TbadkCoreApplication.m411getInst().appResponseToIntentClass(GiftTabActivityConfig.class)) {
                pbActivity3 = this.cKg.cGj;
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GiftTabActivityConfig(pbActivity3.getActivity(), this.bes, this.bGn, GiftTabActivityConfig.FROM_PB, com.baidu.adp.lib.h.b.c(this.bQW, 0L), com.baidu.adp.lib.h.b.c(this.bGo, 0L)));
                pbActivity4 = this.cKg.cGj;
                pbActivity4.sendMessage(customMessage);
            } else {
                pbActivity2 = this.cKg.cGj;
                pbActivity2.showToast(n.j.plugin_config_not_found);
            }
        }
    }
}
