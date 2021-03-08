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
    private TbPageContext eWx;

    public a(TbPageContext tbPageContext) {
        this.eWx = tbPageContext;
    }

    public boolean a(PbModel pbModel) {
        String str;
        int i = 2;
        if (this.eWx.getPageActivity() == null || pbModel == null || pbModel.lQH == null) {
            return false;
        }
        if ("3".equals(pbModel.lQH.lNi)) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this.eWx.getPageActivity()).createNormalCfg(2);
            createNormalCfg.setSubTabName(this.eWx.getString(R.string.tab_name_topic_rank));
            this.eWx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
            return true;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.brR().getString("key_pb_back_sid1", "");
        String string2 = com.baidu.tbadk.core.sharedPref.b.brR().getString("key_pb_back_sid2", "");
        if (!TextUtils.isEmpty(string) && com.baidu.tbadk.a.c.biL().zx(string) != null) {
            str = "1";
        } else {
            str = (TextUtils.isEmpty(string2) || com.baidu.tbadk.a.c.biL().zx(string2) == null) ? null : "2";
        }
        if (str == null && pbModel.lQH.lNh != null) {
            str = pbModel.lQH.lNh;
        }
        if (str != null) {
            if (str.equals("1")) {
                MainTabActivityConfig createNormalCfg2 = new MainTabActivityConfig(this.eWx.getPageActivity()).createNormalCfg(2);
                createNormalCfg2.setSubTab(1, null);
                this.eWx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg2));
                a(pbModel, 1);
                return true;
            } else if (str.equals("2")) {
                MainTabActivityConfig createNormalCfg3 = new MainTabActivityConfig(this.eWx.getPageActivity()).createNormalCfg(1);
                createNormalCfg3.setSubTab(0, pbModel.lQH.lNi);
                this.eWx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg3));
                if (!"游戏".equals(pbModel.lQH.lNi)) {
                    i = "数码".equals(pbModel.lQH.lNi) ? 3 : 0;
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
            arVar.dR("fid", pbModel.lQH.getForumId());
            arVar.dR("tid", pbModel.lQH.getThreadId());
            arVar.aq("obj_type", i);
            if (pbModel.dpu() == 5) {
                arVar.aq("obj_source", 1);
            } else if (pbModel.dpu() == 7) {
                arVar.aq("obj_source", 2);
            } else {
                arVar.aq("obj_source", 3);
            }
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(arVar);
        }
    }
}
