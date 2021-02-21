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
    private TbPageContext eUY;

    public a(TbPageContext tbPageContext) {
        this.eUY = tbPageContext;
    }

    public boolean a(PbModel pbModel) {
        String str;
        int i = 2;
        if (this.eUY.getPageActivity() == null || pbModel == null || pbModel.lOF == null) {
            return false;
        }
        if ("3".equals(pbModel.lOF.lLg)) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this.eUY.getPageActivity()).createNormalCfg(2);
            createNormalCfg.setSubTabName(this.eUY.getString(R.string.tab_name_topic_rank));
            this.eUY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
            return true;
        }
        String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString("key_pb_back_sid1", "");
        String string2 = com.baidu.tbadk.core.sharedPref.b.brQ().getString("key_pb_back_sid2", "");
        if (!TextUtils.isEmpty(string) && com.baidu.tbadk.a.c.biJ().zq(string) != null) {
            str = "1";
        } else {
            str = (TextUtils.isEmpty(string2) || com.baidu.tbadk.a.c.biJ().zq(string2) == null) ? null : "2";
        }
        if (str == null && pbModel.lOF.lLf != null) {
            str = pbModel.lOF.lLf;
        }
        if (str != null) {
            if (str.equals("1")) {
                MainTabActivityConfig createNormalCfg2 = new MainTabActivityConfig(this.eUY.getPageActivity()).createNormalCfg(2);
                createNormalCfg2.setSubTab(1, null);
                this.eUY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg2));
                a(pbModel, 1);
                return true;
            } else if (str.equals("2")) {
                MainTabActivityConfig createNormalCfg3 = new MainTabActivityConfig(this.eUY.getPageActivity()).createNormalCfg(1);
                createNormalCfg3.setSubTab(0, pbModel.lOF.lLg);
                this.eUY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg3));
                if (!"游戏".equals(pbModel.lOF.lLg)) {
                    i = "数码".equals(pbModel.lOF.lLg) ? 3 : 0;
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
            arVar.dR("fid", pbModel.lOF.getForumId());
            arVar.dR("tid", pbModel.lOF.getThreadId());
            arVar.ap("obj_type", i);
            if (pbModel.dpl() == 5) {
                arVar.ap("obj_source", 1);
            } else if (pbModel.dpl() == 7) {
                arVar.ap("obj_source", 2);
            } else {
                arVar.ap("obj_source", 3);
            }
            arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(arVar);
        }
    }
}
