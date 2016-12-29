package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ei implements View.OnClickListener {
    final /* synthetic */ eh eex;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ei(eh ehVar) {
        this.eex = ehVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.aq aqVar;
        com.baidu.tbadk.core.data.aq aqVar2;
        com.baidu.tbadk.core.data.aq aqVar3;
        TbPageContext tbPageContext2;
        com.baidu.tbadk.core.data.aq aqVar4;
        com.baidu.tbadk.core.data.aq aqVar5;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.aq aqVar6;
        TbPageContext tbPageContext4;
        com.baidu.tbadk.core.data.aq aqVar7;
        com.baidu.tbadk.core.data.aq aqVar8;
        TbPageContext tbPageContext5;
        com.baidu.tbadk.core.data.aq aqVar9;
        TbPageContext tbPageContext6;
        tbPageContext = this.eex.Gf;
        if (com.baidu.tbadk.core.util.bh.ai(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.gD()) {
            aqVar = this.eex.eew;
            if (aqVar != null) {
                aqVar2 = this.eex.eew;
                if (!StringUtils.isNull(aqVar2.bookId)) {
                    if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        tbPageContext6 = this.eex.Gf;
                        com.baidu.adp.lib.util.k.showToast(tbPageContext6.getPageActivity(), r.j.book_plugin_not_install_tip);
                    } else if (view == this.eex.eet) {
                        aqVar8 = this.eex.eew;
                        String str = aqVar8.bookId;
                        com.baidu.tbadk.core.data.am amVar = new com.baidu.tbadk.core.data.am();
                        tbPageContext5 = this.eex.Gf;
                        amVar.pageContext = (TbPageContext) com.baidu.adp.base.l.C(tbPageContext5.getPageActivity());
                        amVar.bookId = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, amVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.at("c11387").s("obj_source", 6).ab("obj_locate", "0").ab("obj_param1", str));
                        com.baidu.tbadk.core.util.at atVar = new com.baidu.tbadk.core.util.at("c11442");
                        aqVar9 = this.eex.eew;
                        TiebaStatic.log(atVar.ab("obj_id", aqVar9.bookId).ab("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    } else if (view == this.eex.eev) {
                        tbPageContext3 = this.eex.Gf;
                        Activity pageActivity = tbPageContext3.getPageActivity();
                        aqVar6 = this.eex.eew;
                        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(pageActivity, aqVar6.bookId));
                        tbPageContext4 = this.eex.Gf;
                        tbPageContext4.sendMessage(customMessage);
                        com.baidu.tbadk.core.util.at atVar2 = new com.baidu.tbadk.core.util.at("c11442");
                        aqVar7 = this.eex.eew;
                        TiebaStatic.log(atVar2.ab("obj_id", aqVar7.bookId).ab("obj_locate", "1"));
                    } else if (view == this.eex.eeo) {
                        aqVar3 = this.eex.eew;
                        if (!StringUtils.isNull(aqVar3.Sx)) {
                            com.baidu.tbadk.core.util.bc vz = com.baidu.tbadk.core.util.bc.vz();
                            tbPageContext2 = this.eex.Gf;
                            aqVar4 = this.eex.eew;
                            vz.c((TbPageContext) com.baidu.adp.base.l.C(tbPageContext2.getPageActivity()), new String[]{aqVar4.Sx});
                            com.baidu.tbadk.core.util.at atVar3 = new com.baidu.tbadk.core.util.at("c11442");
                            aqVar5 = this.eex.eew;
                            TiebaStatic.log(atVar3.ab("obj_id", aqVar5.bookId).ab("obj_locate", "2"));
                        }
                    }
                }
            }
        }
    }
}
