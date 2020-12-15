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
    private TbPageContext eNx;

    public a(TbPageContext tbPageContext) {
        this.eNx = tbPageContext;
    }

    public boolean a(PbModel pbModel) {
        String str;
        int i = 2;
        if (this.eNx.getPageActivity() == null || pbModel == null || pbModel.lEP == null) {
            return false;
        }
        if ("3".equals(pbModel.lEP.lBF)) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this.eNx.getPageActivity()).createNormalCfg(2);
            createNormalCfg.setSubTabName(this.eNx.getString(R.string.tab_name_topic_rank));
            this.eNx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
            return true;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString("key_pb_back_sid1", "");
        String string2 = com.baidu.tbadk.core.sharedPref.b.bsO().getString("key_pb_back_sid2", "");
        if (!TextUtils.isEmpty(string) && com.baidu.tbadk.a.c.bkb().Ao(string) != null) {
            str = "1";
        } else {
            str = (TextUtils.isEmpty(string2) || com.baidu.tbadk.a.c.bkb().Ao(string2) == null) ? null : "2";
        }
        if (str == null && pbModel.lEP.lBE != null) {
            str = pbModel.lEP.lBE;
        }
        if (str != null) {
            if (str.equals("1")) {
                MainTabActivityConfig createNormalCfg2 = new MainTabActivityConfig(this.eNx.getPageActivity()).createNormalCfg(2);
                createNormalCfg2.setSubTab(1, null);
                this.eNx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg2));
                a(pbModel, 1);
                return true;
            } else if (str.equals("2")) {
                MainTabActivityConfig createNormalCfg3 = new MainTabActivityConfig(this.eNx.getPageActivity()).createNormalCfg(1);
                createNormalCfg3.setSubTab(0, pbModel.lEP.lBF);
                this.eNx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg3));
                if (!"游戏".equals(pbModel.lEP.lBF)) {
                    i = "数码".equals(pbModel.lEP.lBF) ? 3 : 0;
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
            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13719");
            arVar.dY("fid", pbModel.lEP.getForumId());
            arVar.dY("tid", pbModel.lEP.getThreadId());
            arVar.al("obj_type", i);
            if (pbModel.dqV() == 5) {
                arVar.al("obj_source", 1);
            } else if (pbModel.dqV() == 7) {
                arVar.al("obj_source", 2);
            } else {
                arVar.al("obj_source", 3);
            }
            arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(arVar);
        }
    }
}
