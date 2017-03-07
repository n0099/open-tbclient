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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eq implements View.OnClickListener {
    final /* synthetic */ ep eqr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eq(ep epVar) {
        this.eqr = epVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.at atVar;
        com.baidu.tbadk.core.data.at atVar2;
        com.baidu.tbadk.core.data.at atVar3;
        TbPageContext tbPageContext2;
        com.baidu.tbadk.core.data.at atVar4;
        com.baidu.tbadk.core.data.at atVar5;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.at atVar6;
        TbPageContext tbPageContext4;
        com.baidu.tbadk.core.data.at atVar7;
        com.baidu.tbadk.core.data.at atVar8;
        TbPageContext tbPageContext5;
        com.baidu.tbadk.core.data.at atVar9;
        TbPageContext tbPageContext6;
        tbPageContext = this.eqr.aaI;
        if (com.baidu.tbadk.core.util.bg.aI(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.hv()) {
            atVar = this.eqr.eqq;
            if (atVar != null) {
                atVar2 = this.eqr.eqq;
                if (!StringUtils.isNull(atVar2.bookId)) {
                    if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        tbPageContext6 = this.eqr.aaI;
                        com.baidu.adp.lib.util.k.showToast(tbPageContext6.getPageActivity(), w.l.book_plugin_not_install_tip);
                    } else if (view == this.eqr.eqn) {
                        atVar8 = this.eqr.eqq;
                        String str = atVar8.bookId;
                        com.baidu.tbadk.core.data.ap apVar = new com.baidu.tbadk.core.data.ap();
                        tbPageContext5 = this.eqr.aaI;
                        apVar.pageContext = (TbPageContext) com.baidu.adp.base.k.aa(tbPageContext5.getPageActivity());
                        apVar.bookId = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, apVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11387").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).Z("obj_locate", "0").Z("obj_param1", str));
                        com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11442");
                        atVar9 = this.eqr.eqq;
                        TiebaStatic.log(asVar.Z("obj_id", atVar9.bookId).Z("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    } else if (view == this.eqr.eqp) {
                        tbPageContext3 = this.eqr.aaI;
                        Activity pageActivity = tbPageContext3.getPageActivity();
                        atVar6 = this.eqr.eqq;
                        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(pageActivity, atVar6.bookId));
                        tbPageContext4 = this.eqr.aaI;
                        tbPageContext4.sendMessage(customMessage);
                        com.baidu.tbadk.core.util.as asVar2 = new com.baidu.tbadk.core.util.as("c11442");
                        atVar7 = this.eqr.eqq;
                        TiebaStatic.log(asVar2.Z("obj_id", atVar7.bookId).Z("obj_locate", "1"));
                    } else if (view == this.eqr.eqi) {
                        atVar3 = this.eqr.eqq;
                        if (!StringUtils.isNull(atVar3.WU)) {
                            com.baidu.tbadk.core.util.bb vQ = com.baidu.tbadk.core.util.bb.vQ();
                            tbPageContext2 = this.eqr.aaI;
                            atVar4 = this.eqr.eqq;
                            vQ.c((TbPageContext) com.baidu.adp.base.k.aa(tbPageContext2.getPageActivity()), new String[]{atVar4.WU});
                            com.baidu.tbadk.core.util.as asVar3 = new com.baidu.tbadk.core.util.as("c11442");
                            atVar5 = this.eqr.eqq;
                            TiebaStatic.log(asVar3.Z("obj_id", atVar5.bookId).Z("obj_locate", "2"));
                        }
                    }
                }
            }
        }
    }
}
