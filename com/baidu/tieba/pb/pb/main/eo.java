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
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eo implements View.OnClickListener {
    final /* synthetic */ en efJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eo(en enVar) {
        this.efJ = enVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.am amVar;
        com.baidu.tbadk.core.data.am amVar2;
        com.baidu.tbadk.core.data.am amVar3;
        TbPageContext tbPageContext2;
        com.baidu.tbadk.core.data.am amVar4;
        com.baidu.tbadk.core.data.am amVar5;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.am amVar6;
        TbPageContext tbPageContext4;
        com.baidu.tbadk.core.data.am amVar7;
        com.baidu.tbadk.core.data.am amVar8;
        TbPageContext tbPageContext5;
        com.baidu.tbadk.core.data.am amVar9;
        TbPageContext tbPageContext6;
        tbPageContext = this.efJ.DQ;
        if (com.baidu.tbadk.core.util.bn.ab(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.fH()) {
            amVar = this.efJ.efI;
            if (amVar != null) {
                amVar2 = this.efJ.efI;
                if (!StringUtils.isNull(amVar2.bookId)) {
                    if (!TbadkCoreApplication.m10getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        tbPageContext6 = this.efJ.DQ;
                        com.baidu.adp.lib.util.k.showToast(tbPageContext6.getPageActivity(), u.j.book_plugin_not_install_tip);
                    } else if (view == this.efJ.efF) {
                        amVar8 = this.efJ.efI;
                        String str = amVar8.bookId;
                        com.baidu.tbadk.core.data.ai aiVar = new com.baidu.tbadk.core.data.ai();
                        tbPageContext5 = this.efJ.DQ;
                        aiVar.pageContext = (TbPageContext) com.baidu.adp.base.l.s(tbPageContext5.getPageActivity());
                        aiVar.bookId = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aiVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c11387").s("obj_source", 6).ab("obj_locate", "0").ab("obj_param1", str));
                        com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c11442");
                        amVar9 = this.efJ.efI;
                        TiebaStatic.log(ayVar.ab("obj_id", amVar9.bookId).ab("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    } else if (view == this.efJ.efH) {
                        tbPageContext3 = this.efJ.DQ;
                        Activity pageActivity = tbPageContext3.getPageActivity();
                        amVar6 = this.efJ.efI;
                        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(pageActivity, amVar6.bookId));
                        tbPageContext4 = this.efJ.DQ;
                        tbPageContext4.sendMessage(customMessage);
                        com.baidu.tbadk.core.util.ay ayVar2 = new com.baidu.tbadk.core.util.ay("c11442");
                        amVar7 = this.efJ.efI;
                        TiebaStatic.log(ayVar2.ab("obj_id", amVar7.bookId).ab("obj_locate", "1"));
                    } else if (view == this.efJ.efA) {
                        amVar3 = this.efJ.efI;
                        if (!StringUtils.isNull(amVar3.Pp)) {
                            com.baidu.tbadk.core.util.bi us = com.baidu.tbadk.core.util.bi.us();
                            tbPageContext2 = this.efJ.DQ;
                            amVar4 = this.efJ.efI;
                            us.c((TbPageContext) com.baidu.adp.base.l.s(tbPageContext2.getPageActivity()), new String[]{amVar4.Pp});
                            com.baidu.tbadk.core.util.ay ayVar3 = new com.baidu.tbadk.core.util.ay("c11442");
                            amVar5 = this.efJ.efI;
                            TiebaStatic.log(ayVar3.ab("obj_id", amVar5.bookId).ab("obj_locate", "2"));
                        }
                    }
                }
            }
        }
    }
}
