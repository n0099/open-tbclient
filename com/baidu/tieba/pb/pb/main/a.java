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
    private TbPageContext etO;

    public a(TbPageContext tbPageContext) {
        this.etO = tbPageContext;
    }

    public boolean a(PbModel pbModel) {
        String str;
        int i = 2;
        if (this.etO.getPageActivity() == null || pbModel == null || pbModel.kYp == null) {
            return false;
        }
        if ("3".equals(pbModel.kYp.kVs)) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this.etO.getPageActivity()).createNormalCfg(2);
            createNormalCfg.setSubTabName(this.etO.getString(R.string.tab_name_topic_rank));
            this.etO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
            return true;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.blO().getString("key_pb_back_sid1", "");
        String string2 = com.baidu.tbadk.core.sharedPref.b.blO().getString("key_pb_back_sid2", "");
        if (!TextUtils.isEmpty(string) && com.baidu.tbadk.a.c.bdk().zg(string) != null) {
            str = "1";
        } else {
            str = (TextUtils.isEmpty(string2) || com.baidu.tbadk.a.c.bdk().zg(string2) == null) ? null : "2";
        }
        if (str == null && pbModel.kYp.kVr != null) {
            str = pbModel.kYp.kVr;
        }
        if (str != null) {
            if (str.equals("1")) {
                MainTabActivityConfig createNormalCfg2 = new MainTabActivityConfig(this.etO.getPageActivity()).createNormalCfg(2);
                createNormalCfg2.setSubTab(1, null);
                this.etO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg2));
                a(pbModel, 1);
                return true;
            } else if (str.equals("2")) {
                MainTabActivityConfig createNormalCfg3 = new MainTabActivityConfig(this.etO.getPageActivity()).createNormalCfg(1);
                createNormalCfg3.setSubTab(0, pbModel.kYp.kVs);
                this.etO.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg3));
                if (!"游戏".equals(pbModel.kYp.kVs)) {
                    i = "数码".equals(pbModel.kYp.kVs) ? 3 : 0;
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
            aqVar.dK("fid", pbModel.kYp.getForumId());
            aqVar.dK("tid", pbModel.kYp.getThreadId());
            aqVar.aj("obj_type", i);
            if (pbModel.dgy() == 5) {
                aqVar.aj("obj_source", 1);
            } else if (pbModel.dgy() == 7) {
                aqVar.aj("obj_source", 2);
            } else {
                aqVar.aj("obj_source", 3);
            }
            aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(aqVar);
        }
    }
}
