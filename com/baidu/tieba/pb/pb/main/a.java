package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class a {
    private TbPageContext eCn;

    public a(TbPageContext tbPageContext) {
        this.eCn = tbPageContext;
    }

    public boolean a(PbModel pbModel) {
        String str;
        int i = 2;
        if (this.eCn.getPageActivity() == null || pbModel == null || pbModel.lkO == null) {
            return false;
        }
        if ("3".equals(pbModel.lkO.lhR)) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this.eCn.getPageActivity()).createNormalCfg(2);
            createNormalCfg.setSubTabName(this.eCn.getString(R.string.tab_name_topic_rank));
            this.eCn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
            return true;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.bnH().getString("key_pb_back_sid1", "");
        String string2 = com.baidu.tbadk.core.sharedPref.b.bnH().getString("key_pb_back_sid2", "");
        if (!TextUtils.isEmpty(string) && com.baidu.tbadk.a.c.bfd().zz(string) != null) {
            str = "1";
        } else {
            str = (TextUtils.isEmpty(string2) || com.baidu.tbadk.a.c.bfd().zz(string2) == null) ? null : "2";
        }
        if (str == null && pbModel.lkO.lhQ != null) {
            str = pbModel.lkO.lhQ;
        }
        if (str != null) {
            if (str.equals("1")) {
                MainTabActivityConfig createNormalCfg2 = new MainTabActivityConfig(this.eCn.getPageActivity()).createNormalCfg(2);
                createNormalCfg2.setSubTab(1, null);
                this.eCn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg2));
                a(pbModel, 1);
                return true;
            } else if (str.equals("2")) {
                MainTabActivityConfig createNormalCfg3 = new MainTabActivityConfig(this.eCn.getPageActivity()).createNormalCfg(1);
                createNormalCfg3.setSubTab(0, pbModel.lkO.lhR);
                this.eCn.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg3));
                if (!"游戏".equals(pbModel.lkO.lhR)) {
                    i = "数码".equals(pbModel.lkO.lhR) ? 3 : 0;
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
            aqVar.dR("fid", pbModel.lkO.getForumId());
            aqVar.dR("tid", pbModel.lkO.getThreadId());
            aqVar.aj("obj_type", i);
            if (pbModel.djF() == 5) {
                aqVar.aj("obj_source", 1);
            } else if (pbModel.djF() == 7) {
                aqVar.aj("obj_source", 2);
            } else {
                aqVar.aj("obj_source", 3);
            }
            aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(aqVar);
        }
    }
}
