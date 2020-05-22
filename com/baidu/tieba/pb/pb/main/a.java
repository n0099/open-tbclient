package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes9.dex */
public class a {
    private TbPageContext dIF;

    public a(TbPageContext tbPageContext) {
        this.dIF = tbPageContext;
    }

    public boolean a(PbModel pbModel) {
        String str;
        int i = 2;
        if (this.dIF.getPageActivity() == null || this.dIF.getPageActivity().getIntent() == null || !this.dIF.getPageActivity().getIntent().hasExtra(IntentConfig.KEY_URI) || pbModel == null || pbModel.jHO == null) {
            return false;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString("key_pb_back_sid1", "");
        String string2 = com.baidu.tbadk.core.sharedPref.b.aTX().getString("key_pb_back_sid2", "");
        if (!TextUtils.isEmpty(string) && com.baidu.tbadk.a.c.aMf().uE(string) != null) {
            str = "1";
        } else {
            str = (TextUtils.isEmpty(string2) || com.baidu.tbadk.a.c.aMf().uE(string2) == null) ? null : "2";
        }
        if (str == null && pbModel.jHO.jEP != null) {
            str = pbModel.jHO.jEP;
        }
        if (str != null) {
            if (str.equals("1")) {
                MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this.dIF.getPageActivity()).createNormalCfg(2);
                createNormalCfg.setSubTab(1, null);
                this.dIF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
                a(pbModel.jHO, 1);
                return true;
            } else if (str.equals("2")) {
                MainTabActivityConfig createNormalCfg2 = new MainTabActivityConfig(this.dIF.getPageActivity()).createNormalCfg(1);
                createNormalCfg2.setSubTab(0, pbModel.jHO.jEQ);
                this.dIF.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg2));
                if (!"游戏".equals(pbModel.jHO.jEQ)) {
                    i = "数码".equals(pbModel.jHO.jEQ) ? 3 : 0;
                }
                a(pbModel.jHO, i);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private void a(com.baidu.tieba.pb.data.e eVar, int i) {
        if (eVar != null) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13719");
            anVar.dh("fid", eVar.getForumId());
            anVar.dh("tid", eVar.getThreadId());
            anVar.ag("obj_type", i);
            anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(anVar);
        }
    }
}
