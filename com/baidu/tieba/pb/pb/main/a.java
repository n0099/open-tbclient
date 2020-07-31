package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class a {
    private TbPageContext dVN;

    public a(TbPageContext tbPageContext) {
        this.dVN = tbPageContext;
    }

    public boolean a(PbModel pbModel) {
        String str;
        int i = 2;
        if (this.dVN.getPageActivity() == null || pbModel == null || pbModel.klg == null) {
            return false;
        }
        if ("3".equals(pbModel.klg.kii)) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this.dVN.getPageActivity()).createNormalCfg(2);
            createNormalCfg.setSubTabName(this.dVN.getString(R.string.tab_name_topic_rank));
            this.dVN.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
            return true;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.aZP().getString("key_pb_back_sid1", "");
        String string2 = com.baidu.tbadk.core.sharedPref.b.aZP().getString("key_pb_back_sid2", "");
        if (!TextUtils.isEmpty(string) && com.baidu.tbadk.a.c.aRw().vO(string) != null) {
            str = "1";
        } else {
            str = (TextUtils.isEmpty(string2) || com.baidu.tbadk.a.c.aRw().vO(string2) == null) ? null : "2";
        }
        if (str == null && pbModel.klg.kih != null) {
            str = pbModel.klg.kih;
        }
        if (str != null) {
            if (str.equals("1")) {
                MainTabActivityConfig createNormalCfg2 = new MainTabActivityConfig(this.dVN.getPageActivity()).createNormalCfg(2);
                createNormalCfg2.setSubTab(1, null);
                this.dVN.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg2));
                a(pbModel, 1);
                return true;
            } else if (str.equals("2")) {
                MainTabActivityConfig createNormalCfg3 = new MainTabActivityConfig(this.dVN.getPageActivity()).createNormalCfg(1);
                createNormalCfg3.setSubTab(0, pbModel.klg.kii);
                this.dVN.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg3));
                if (!"游戏".equals(pbModel.klg.kii)) {
                    i = "数码".equals(pbModel.klg.kii) ? 3 : 0;
                }
                a(pbModel, i);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private void a(PbModel pbModel, int i) {
        if (pbModel != null) {
            com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c13719");
            apVar.dn("fid", pbModel.klg.getForumId());
            apVar.dn("tid", pbModel.klg.getThreadId());
            apVar.ah("obj_type", i);
            if (pbModel.cOv() == 5) {
                apVar.ah("obj_source", 1);
            } else if (pbModel.cOv() == 7) {
                apVar.ah("obj_source", 2);
            } else {
                apVar.ah("obj_source", 3);
            }
            apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(apVar);
        }
    }
}
