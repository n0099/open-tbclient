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
    private TbPageContext eSJ;

    public a(TbPageContext tbPageContext) {
        this.eSJ = tbPageContext;
    }

    public boolean a(PbModel pbModel) {
        String str;
        int i = 2;
        if (this.eSJ.getPageActivity() == null || pbModel == null || pbModel.lFA == null) {
            return false;
        }
        if ("3".equals(pbModel.lFA.lCf)) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this.eSJ.getPageActivity()).createNormalCfg(2);
            createNormalCfg.setSubTabName(this.eSJ.getString(R.string.tab_name_topic_rank));
            this.eSJ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
            return true;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.brx().getString("key_pb_back_sid1", "");
        String string2 = com.baidu.tbadk.core.sharedPref.b.brx().getString("key_pb_back_sid2", "");
        if (!TextUtils.isEmpty(string) && com.baidu.tbadk.a.c.bix().yY(string) != null) {
            str = "1";
        } else {
            str = (TextUtils.isEmpty(string2) || com.baidu.tbadk.a.c.bix().yY(string2) == null) ? null : "2";
        }
        if (str == null && pbModel.lFA.lCe != null) {
            str = pbModel.lFA.lCe;
        }
        if (str != null) {
            if (str.equals("1")) {
                MainTabActivityConfig createNormalCfg2 = new MainTabActivityConfig(this.eSJ.getPageActivity()).createNormalCfg(2);
                createNormalCfg2.setSubTab(1, null);
                this.eSJ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg2));
                a(pbModel, 1);
                return true;
            } else if (str.equals("2")) {
                MainTabActivityConfig createNormalCfg3 = new MainTabActivityConfig(this.eSJ.getPageActivity()).createNormalCfg(1);
                createNormalCfg3.setSubTab(0, pbModel.lFA.lCf);
                this.eSJ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg3));
                if (!"游戏".equals(pbModel.lFA.lCf)) {
                    i = "数码".equals(pbModel.lFA.lCf) ? 3 : 0;
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
            aqVar.dW("fid", pbModel.lFA.getForumId());
            aqVar.dW("tid", pbModel.lFA.getThreadId());
            aqVar.an("obj_type", i);
            if (pbModel.dmP() == 5) {
                aqVar.an("obj_source", 1);
            } else if (pbModel.dmP() == 7) {
                aqVar.an("obj_source", 2);
            } else {
                aqVar.an("obj_source", 3);
            }
            aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(aqVar);
        }
    }
}
