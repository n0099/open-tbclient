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
public class ff implements View.OnClickListener {
    final /* synthetic */ fe erZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ff(fe feVar) {
        this.erZ = feVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.au auVar;
        com.baidu.tbadk.core.data.au auVar2;
        com.baidu.tbadk.core.data.au auVar3;
        TbPageContext tbPageContext2;
        com.baidu.tbadk.core.data.au auVar4;
        com.baidu.tbadk.core.data.au auVar5;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.au auVar6;
        TbPageContext tbPageContext4;
        com.baidu.tbadk.core.data.au auVar7;
        com.baidu.tbadk.core.data.au auVar8;
        TbPageContext tbPageContext5;
        com.baidu.tbadk.core.data.au auVar9;
        TbPageContext tbPageContext6;
        tbPageContext = this.erZ.aas;
        if (com.baidu.tbadk.core.util.bh.aN(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.hB()) {
            auVar = this.erZ.erY;
            if (auVar != null) {
                auVar2 = this.erZ.erY;
                if (!StringUtils.isNull(auVar2.bookId)) {
                    if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        tbPageContext6 = this.erZ.aas;
                        com.baidu.adp.lib.util.k.showToast(tbPageContext6.getPageActivity(), w.l.book_plugin_not_install_tip);
                    } else if (view == this.erZ.erV) {
                        auVar8 = this.erZ.erY;
                        String str = auVar8.bookId;
                        com.baidu.tbadk.core.data.aq aqVar = new com.baidu.tbadk.core.data.aq();
                        tbPageContext5 = this.erZ.aas;
                        aqVar.pageContext = (TbPageContext) com.baidu.adp.base.k.Z(tbPageContext5.getPageActivity());
                        aqVar.bookId = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aqVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11387").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).Z("obj_locate", "0").Z("obj_param1", str));
                        com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11442");
                        auVar9 = this.erZ.erY;
                        TiebaStatic.log(asVar.Z("obj_id", auVar9.bookId).Z("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    } else if (view == this.erZ.erX) {
                        tbPageContext3 = this.erZ.aas;
                        Activity pageActivity = tbPageContext3.getPageActivity();
                        auVar6 = this.erZ.erY;
                        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(pageActivity, auVar6.bookId));
                        tbPageContext4 = this.erZ.aas;
                        tbPageContext4.sendMessage(customMessage);
                        com.baidu.tbadk.core.util.as asVar2 = new com.baidu.tbadk.core.util.as("c11442");
                        auVar7 = this.erZ.erY;
                        TiebaStatic.log(asVar2.Z("obj_id", auVar7.bookId).Z("obj_locate", "1"));
                    } else if (view == this.erZ.erQ) {
                        auVar3 = this.erZ.erY;
                        if (!StringUtils.isNull(auVar3.Wx)) {
                            com.baidu.tbadk.core.util.bb vy = com.baidu.tbadk.core.util.bb.vy();
                            tbPageContext2 = this.erZ.aas;
                            auVar4 = this.erZ.erY;
                            vy.c((TbPageContext) com.baidu.adp.base.k.Z(tbPageContext2.getPageActivity()), new String[]{auVar4.Wx});
                            com.baidu.tbadk.core.util.as asVar3 = new com.baidu.tbadk.core.util.as("c11442");
                            auVar5 = this.erZ.erY;
                            TiebaStatic.log(asVar3.Z("obj_id", auVar5.bookId).Z("obj_locate", "2"));
                        }
                    }
                }
            }
        }
    }
}
