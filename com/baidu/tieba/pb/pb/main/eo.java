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
public class eo implements View.OnClickListener {
    final /* synthetic */ en eoA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eo(en enVar) {
        this.eoA = enVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.as asVar;
        com.baidu.tbadk.core.data.as asVar2;
        com.baidu.tbadk.core.data.as asVar3;
        TbPageContext tbPageContext2;
        com.baidu.tbadk.core.data.as asVar4;
        com.baidu.tbadk.core.data.as asVar5;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.as asVar6;
        TbPageContext tbPageContext4;
        com.baidu.tbadk.core.data.as asVar7;
        com.baidu.tbadk.core.data.as asVar8;
        TbPageContext tbPageContext5;
        com.baidu.tbadk.core.data.as asVar9;
        TbPageContext tbPageContext6;
        tbPageContext = this.eoA.aaX;
        if (com.baidu.tbadk.core.util.bg.aK(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.hA()) {
            asVar = this.eoA.eoz;
            if (asVar != null) {
                asVar2 = this.eoA.eoz;
                if (!StringUtils.isNull(asVar2.bookId)) {
                    if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        tbPageContext6 = this.eoA.aaX;
                        com.baidu.adp.lib.util.k.showToast(tbPageContext6.getPageActivity(), w.l.book_plugin_not_install_tip);
                    } else if (view == this.eoA.eow) {
                        asVar8 = this.eoA.eoz;
                        String str = asVar8.bookId;
                        com.baidu.tbadk.core.data.ao aoVar = new com.baidu.tbadk.core.data.ao();
                        tbPageContext5 = this.eoA.aaX;
                        aoVar.pageContext = (TbPageContext) com.baidu.adp.base.k.Z(tbPageContext5.getPageActivity());
                        aoVar.bookId = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, aoVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11387").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).aa("obj_locate", "0").aa("obj_param1", str));
                        com.baidu.tbadk.core.util.as asVar10 = new com.baidu.tbadk.core.util.as("c11442");
                        asVar9 = this.eoA.eoz;
                        TiebaStatic.log(asVar10.aa("obj_id", asVar9.bookId).aa("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    } else if (view == this.eoA.eoy) {
                        tbPageContext3 = this.eoA.aaX;
                        Activity pageActivity = tbPageContext3.getPageActivity();
                        asVar6 = this.eoA.eoz;
                        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(pageActivity, asVar6.bookId));
                        tbPageContext4 = this.eoA.aaX;
                        tbPageContext4.sendMessage(customMessage);
                        com.baidu.tbadk.core.util.as asVar11 = new com.baidu.tbadk.core.util.as("c11442");
                        asVar7 = this.eoA.eoz;
                        TiebaStatic.log(asVar11.aa("obj_id", asVar7.bookId).aa("obj_locate", "1"));
                    } else if (view == this.eoA.eor) {
                        asVar3 = this.eoA.eoz;
                        if (!StringUtils.isNull(asVar3.Xj)) {
                            com.baidu.tbadk.core.util.bb wn = com.baidu.tbadk.core.util.bb.wn();
                            tbPageContext2 = this.eoA.aaX;
                            asVar4 = this.eoA.eoz;
                            wn.c((TbPageContext) com.baidu.adp.base.k.Z(tbPageContext2.getPageActivity()), new String[]{asVar4.Xj});
                            com.baidu.tbadk.core.util.as asVar12 = new com.baidu.tbadk.core.util.as("c11442");
                            asVar5 = this.eoA.eoz;
                            TiebaStatic.log(asVar12.aa("obj_id", asVar5.bookId).aa("obj_locate", "2"));
                        }
                    }
                }
            }
        }
    }
}
