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
    private TbPageContext eGu;

    public a(TbPageContext tbPageContext) {
        this.eGu = tbPageContext;
    }

    public boolean a(PbModel pbModel) {
        String str;
        int i = 2;
        if (this.eGu.getPageActivity() == null || pbModel == null || pbModel.lre == null) {
            return false;
        }
        if ("3".equals(pbModel.lre.lof)) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this.eGu.getPageActivity()).createNormalCfg(2);
            createNormalCfg.setSubTabName(this.eGu.getString(R.string.tab_name_topic_rank));
            this.eGu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
            return true;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.bpu().getString("key_pb_back_sid1", "");
        String string2 = com.baidu.tbadk.core.sharedPref.b.bpu().getString("key_pb_back_sid2", "");
        if (!TextUtils.isEmpty(string) && com.baidu.tbadk.a.c.bgW().zH(string) != null) {
            str = "1";
        } else {
            str = (TextUtils.isEmpty(string2) || com.baidu.tbadk.a.c.bgW().zH(string2) == null) ? null : "2";
        }
        if (str == null && pbModel.lre.loe != null) {
            str = pbModel.lre.loe;
        }
        if (str != null) {
            if (str.equals("1")) {
                MainTabActivityConfig createNormalCfg2 = new MainTabActivityConfig(this.eGu.getPageActivity()).createNormalCfg(2);
                createNormalCfg2.setSubTab(1, null);
                this.eGu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg2));
                a(pbModel, 1);
                return true;
            } else if (str.equals("2")) {
                MainTabActivityConfig createNormalCfg3 = new MainTabActivityConfig(this.eGu.getPageActivity()).createNormalCfg(1);
                createNormalCfg3.setSubTab(0, pbModel.lre.lof);
                this.eGu.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg3));
                if (!"游戏".equals(pbModel.lre.lof)) {
                    i = "数码".equals(pbModel.lre.lof) ? 3 : 0;
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
            arVar.dR("fid", pbModel.lre.getForumId());
            arVar.dR("tid", pbModel.lre.getThreadId());
            arVar.ak("obj_type", i);
            if (pbModel.dlE() == 5) {
                arVar.ak("obj_source", 1);
            } else if (pbModel.dlE() == 7) {
                arVar.ak("obj_source", 2);
            } else {
                arVar.ak("obj_source", 3);
            }
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(arVar);
        }
    }
}
