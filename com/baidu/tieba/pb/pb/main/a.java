package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a {
    private TbPageContext dPv;

    public a(TbPageContext tbPageContext) {
        this.dPv = tbPageContext;
    }

    public boolean a(PbModel pbModel) {
        String str;
        int i = 2;
        if (this.dPv.getPageActivity() == null || pbModel == null || pbModel.kcE == null) {
            return false;
        }
        if ("3".equals(pbModel.kcE.jZG)) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this.dPv.getPageActivity()).createNormalCfg(2);
            createNormalCfg.setSubTabName(this.dPv.getString(R.string.tab_name_topic_rank));
            this.dPv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
            return true;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.aVP().getString("key_pb_back_sid1", "");
        String string2 = com.baidu.tbadk.core.sharedPref.b.aVP().getString("key_pb_back_sid2", "");
        if (!TextUtils.isEmpty(string) && com.baidu.tbadk.a.c.aNI().uM(string) != null) {
            str = "1";
        } else {
            str = (TextUtils.isEmpty(string2) || com.baidu.tbadk.a.c.aNI().uM(string2) == null) ? null : "2";
        }
        if (str == null && pbModel.kcE.jZF != null) {
            str = pbModel.kcE.jZF;
        }
        if (str != null) {
            if (str.equals("1")) {
                MainTabActivityConfig createNormalCfg2 = new MainTabActivityConfig(this.dPv.getPageActivity()).createNormalCfg(2);
                createNormalCfg2.setSubTab(1, null);
                this.dPv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg2));
                a(pbModel, 1);
                return true;
            } else if (str.equals("2")) {
                MainTabActivityConfig createNormalCfg3 = new MainTabActivityConfig(this.dPv.getPageActivity()).createNormalCfg(1);
                createNormalCfg3.setSubTab(0, pbModel.kcE.jZG);
                this.dPv.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg3));
                if (!"游戏".equals(pbModel.kcE.jZG)) {
                    i = "数码".equals(pbModel.kcE.jZG) ? 3 : 0;
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
            com.baidu.tbadk.core.util.ao aoVar = new com.baidu.tbadk.core.util.ao("c13719");
            aoVar.dk("fid", pbModel.kcE.getForumId());
            aoVar.dk("tid", pbModel.kcE.getThreadId());
            aoVar.ag("obj_type", i);
            if (pbModel.cKK() == 5) {
                aoVar.ag("obj_source", 1);
            } else if (pbModel.cKK() == 7) {
                aoVar.ag("obj_source", 2);
            } else {
                aoVar.ag("obj_source", 3);
            }
            aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(aoVar);
        }
    }
}
