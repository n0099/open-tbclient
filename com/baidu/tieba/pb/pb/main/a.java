package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a {
    private TbPageContext eXu;

    public a(TbPageContext tbPageContext) {
        this.eXu = tbPageContext;
    }

    public boolean a(PbModel pbModel) {
        String str;
        int i = 2;
        if (this.eXu.getPageActivity() == null || pbModel == null || pbModel.lKe == null) {
            return false;
        }
        if ("3".equals(pbModel.lKe.lGK)) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this.eXu.getPageActivity()).createNormalCfg(2);
            createNormalCfg.setSubTabName(this.eXu.getString(R.string.tab_name_topic_rank));
            this.eXu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
            return true;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.bvr().getString("key_pb_back_sid1", "");
        String string2 = com.baidu.tbadk.core.sharedPref.b.bvr().getString("key_pb_back_sid2", "");
        if (!TextUtils.isEmpty(string) && com.baidu.tbadk.a.c.bmr().Aj(string) != null) {
            str = "1";
        } else {
            str = (TextUtils.isEmpty(string2) || com.baidu.tbadk.a.c.bmr().Aj(string2) == null) ? null : "2";
        }
        if (str == null && pbModel.lKe.lGJ != null) {
            str = pbModel.lKe.lGJ;
        }
        if (str != null) {
            if (str.equals("1")) {
                MainTabActivityConfig createNormalCfg2 = new MainTabActivityConfig(this.eXu.getPageActivity()).createNormalCfg(2);
                createNormalCfg2.setSubTab(1, null);
                this.eXu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg2));
                a(pbModel, 1);
                return true;
            } else if (str.equals("2")) {
                MainTabActivityConfig createNormalCfg3 = new MainTabActivityConfig(this.eXu.getPageActivity()).createNormalCfg(1);
                createNormalCfg3.setSubTab(0, pbModel.lKe.lGK);
                this.eXu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg3));
                if (!"游戏".equals(pbModel.lKe.lGK)) {
                    i = "数码".equals(pbModel.lKe.lGK) ? 3 : 0;
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
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c13719");
            aqVar.dX("fid", pbModel.lKe.getForumId());
            aqVar.dX("tid", pbModel.lKe.getThreadId());
            aqVar.an("obj_type", i);
            if (pbModel.dqI() == 5) {
                aqVar.an("obj_source", 1);
            } else if (pbModel.dqI() == 7) {
                aqVar.an("obj_source", 2);
            } else {
                aqVar.an("obj_source", 3);
            }
            aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(aqVar);
        }
    }
}
