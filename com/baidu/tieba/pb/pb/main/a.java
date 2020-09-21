package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class a {
    private TbPageContext ehG;

    public a(TbPageContext tbPageContext) {
        this.ehG = tbPageContext;
    }

    public boolean a(PbModel pbModel) {
        String str;
        int i = 2;
        if (this.ehG.getPageActivity() == null || pbModel == null || pbModel.kJe == null) {
            return false;
        }
        if ("3".equals(pbModel.kJe.kGh)) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this.ehG.getPageActivity()).createNormalCfg(2);
            createNormalCfg.setSubTabName(this.ehG.getString(R.string.tab_name_topic_rank));
            this.ehG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
            return true;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.bjf().getString("key_pb_back_sid1", "");
        String string2 = com.baidu.tbadk.core.sharedPref.b.bjf().getString("key_pb_back_sid2", "");
        if (!TextUtils.isEmpty(string) && com.baidu.tbadk.a.c.baC().yu(string) != null) {
            str = "1";
        } else {
            str = (TextUtils.isEmpty(string2) || com.baidu.tbadk.a.c.baC().yu(string2) == null) ? null : "2";
        }
        if (str == null && pbModel.kJe.kGg != null) {
            str = pbModel.kJe.kGg;
        }
        if (str != null) {
            if (str.equals("1")) {
                MainTabActivityConfig createNormalCfg2 = new MainTabActivityConfig(this.ehG.getPageActivity()).createNormalCfg(2);
                createNormalCfg2.setSubTab(1, null);
                this.ehG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg2));
                a(pbModel, 1);
                return true;
            } else if (str.equals("2")) {
                MainTabActivityConfig createNormalCfg3 = new MainTabActivityConfig(this.ehG.getPageActivity()).createNormalCfg(1);
                createNormalCfg3.setSubTab(0, pbModel.kJe.kGh);
                this.ehG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg3));
                if (!"游戏".equals(pbModel.kJe.kGh)) {
                    i = "数码".equals(pbModel.kJe.kGh) ? 3 : 0;
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
            aqVar.dF("fid", pbModel.kJe.getForumId());
            aqVar.dF("tid", pbModel.kJe.getThreadId());
            aqVar.ai("obj_type", i);
            if (pbModel.dcP() == 5) {
                aqVar.ai("obj_source", 1);
            } else if (pbModel.dcP() == 7) {
                aqVar.ai("obj_source", 2);
            } else {
                aqVar.ai("obj_source", 3);
            }
            aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(aqVar);
        }
    }
}
