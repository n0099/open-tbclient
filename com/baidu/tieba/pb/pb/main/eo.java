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
public class eo implements View.OnClickListener {
    final /* synthetic */ en etX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eo(en enVar) {
        this.etX = enVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.ap apVar;
        com.baidu.tbadk.core.data.ap apVar2;
        com.baidu.tbadk.core.data.ap apVar3;
        TbPageContext tbPageContext2;
        com.baidu.tbadk.core.data.ap apVar4;
        com.baidu.tbadk.core.data.ap apVar5;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.ap apVar6;
        TbPageContext tbPageContext4;
        com.baidu.tbadk.core.data.ap apVar7;
        com.baidu.tbadk.core.data.ap apVar8;
        TbPageContext tbPageContext5;
        com.baidu.tbadk.core.data.ap apVar9;
        TbPageContext tbPageContext6;
        tbPageContext = this.etX.Gd;
        if (com.baidu.tbadk.core.util.bm.ak(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.gD()) {
            apVar = this.etX.etW;
            if (apVar != null) {
                apVar2 = this.etX.etW;
                if (!StringUtils.isNull(apVar2.bookId)) {
                    if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        tbPageContext6 = this.etX.Gd;
                        com.baidu.adp.lib.util.k.showToast(tbPageContext6.getPageActivity(), r.j.book_plugin_not_install_tip);
                    } else if (view == this.etX.etT) {
                        apVar8 = this.etX.etW;
                        String str = apVar8.bookId;
                        com.baidu.tbadk.core.data.al alVar = new com.baidu.tbadk.core.data.al();
                        tbPageContext5 = this.etX.Gd;
                        alVar.pageContext = (TbPageContext) com.baidu.adp.base.l.C(tbPageContext5.getPageActivity());
                        alVar.bookId = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, alVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c11387").s("obj_source", 6).ab("obj_locate", "0").ab("obj_param1", str));
                        com.baidu.tbadk.core.util.ax axVar = new com.baidu.tbadk.core.util.ax("c11442");
                        apVar9 = this.etX.etW;
                        TiebaStatic.log(axVar.ab("obj_id", apVar9.bookId).ab("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    } else if (view == this.etX.etV) {
                        tbPageContext3 = this.etX.Gd;
                        Activity pageActivity = tbPageContext3.getPageActivity();
                        apVar6 = this.etX.etW;
                        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(pageActivity, apVar6.bookId));
                        tbPageContext4 = this.etX.Gd;
                        tbPageContext4.sendMessage(customMessage);
                        com.baidu.tbadk.core.util.ax axVar2 = new com.baidu.tbadk.core.util.ax("c11442");
                        apVar7 = this.etX.etW;
                        TiebaStatic.log(axVar2.ab("obj_id", apVar7.bookId).ab("obj_locate", "1"));
                    } else if (view == this.etX.etO) {
                        apVar3 = this.etX.etW;
                        if (!StringUtils.isNull(apVar3.Sh)) {
                            com.baidu.tbadk.core.util.bh vL = com.baidu.tbadk.core.util.bh.vL();
                            tbPageContext2 = this.etX.Gd;
                            apVar4 = this.etX.etW;
                            vL.c((TbPageContext) com.baidu.adp.base.l.C(tbPageContext2.getPageActivity()), new String[]{apVar4.Sh});
                            com.baidu.tbadk.core.util.ax axVar3 = new com.baidu.tbadk.core.util.ax("c11442");
                            apVar5 = this.etX.etW;
                            TiebaStatic.log(axVar3.ab("obj_id", apVar5.bookId).ab("obj_locate", "2"));
                        }
                    }
                }
            }
        }
    }
}
