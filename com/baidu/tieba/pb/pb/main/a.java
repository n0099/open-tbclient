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
    private TbPageContext efn;

    public a(TbPageContext tbPageContext) {
        this.efn = tbPageContext;
    }

    public boolean a(PbModel pbModel) {
        String str;
        int i = 2;
        if (this.efn.getPageActivity() == null || pbModel == null || pbModel.kAA == null) {
            return false;
        }
        if ("3".equals(pbModel.kAA.kxC)) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this.efn.getPageActivity()).createNormalCfg(2);
            createNormalCfg.setSubTabName(this.efn.getString(R.string.tab_name_topic_rank));
            this.efn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
            return true;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.bik().getString("key_pb_back_sid1", "");
        String string2 = com.baidu.tbadk.core.sharedPref.b.bik().getString("key_pb_back_sid2", "");
        if (!TextUtils.isEmpty(string) && com.baidu.tbadk.a.c.aZN().xZ(string) != null) {
            str = "1";
        } else {
            str = (TextUtils.isEmpty(string2) || com.baidu.tbadk.a.c.aZN().xZ(string2) == null) ? null : "2";
        }
        if (str == null && pbModel.kAA.kxB != null) {
            str = pbModel.kAA.kxB;
        }
        if (str != null) {
            if (str.equals("1")) {
                MainTabActivityConfig createNormalCfg2 = new MainTabActivityConfig(this.efn.getPageActivity()).createNormalCfg(2);
                createNormalCfg2.setSubTab(1, null);
                this.efn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg2));
                a(pbModel, 1);
                return true;
            } else if (str.equals("2")) {
                MainTabActivityConfig createNormalCfg3 = new MainTabActivityConfig(this.efn.getPageActivity()).createNormalCfg(1);
                createNormalCfg3.setSubTab(0, pbModel.kAA.kxC);
                this.efn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg3));
                if (!"游戏".equals(pbModel.kAA.kxC)) {
                    i = "数码".equals(pbModel.kAA.kxC) ? 3 : 0;
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
            aqVar.dD("fid", pbModel.kAA.getForumId());
            aqVar.dD("tid", pbModel.kAA.getThreadId());
            aqVar.ai("obj_type", i);
            if (pbModel.cZl() == 5) {
                aqVar.ai("obj_source", 1);
            } else if (pbModel.cZl() == 7) {
                aqVar.ai("obj_source", 2);
            } else {
                aqVar.ai("obj_source", 3);
            }
            aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(aqVar);
        }
    }
}
