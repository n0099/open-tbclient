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
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eo implements View.OnClickListener {
    final /* synthetic */ en erO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eo(en enVar) {
        this.erO = enVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.an anVar;
        com.baidu.tbadk.core.data.an anVar2;
        com.baidu.tbadk.core.data.an anVar3;
        TbPageContext tbPageContext2;
        com.baidu.tbadk.core.data.an anVar4;
        com.baidu.tbadk.core.data.an anVar5;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.an anVar6;
        TbPageContext tbPageContext4;
        com.baidu.tbadk.core.data.an anVar7;
        com.baidu.tbadk.core.data.an anVar8;
        TbPageContext tbPageContext5;
        com.baidu.tbadk.core.data.an anVar9;
        TbPageContext tbPageContext6;
        tbPageContext = this.erO.Gd;
        if (com.baidu.tbadk.core.util.bn.al(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.gD()) {
            anVar = this.erO.erN;
            if (anVar != null) {
                anVar2 = this.erO.erN;
                if (!StringUtils.isNull(anVar2.bookId)) {
                    if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        tbPageContext6 = this.erO.Gd;
                        com.baidu.adp.lib.util.k.showToast(tbPageContext6.getPageActivity(), t.j.book_plugin_not_install_tip);
                    } else if (view == this.erO.erK) {
                        anVar8 = this.erO.erN;
                        String str = anVar8.bookId;
                        com.baidu.tbadk.core.data.aj ajVar = new com.baidu.tbadk.core.data.aj();
                        tbPageContext5 = this.erO.Gd;
                        ajVar.pageContext = (TbPageContext) com.baidu.adp.base.l.C(tbPageContext5.getPageActivity());
                        ajVar.bookId = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, ajVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c11387").s("obj_source", 6).ab("obj_locate", "0").ab("obj_param1", str));
                        com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c11442");
                        anVar9 = this.erO.erN;
                        TiebaStatic.log(ayVar.ab("obj_id", anVar9.bookId).ab("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    } else if (view == this.erO.erM) {
                        tbPageContext3 = this.erO.Gd;
                        Activity pageActivity = tbPageContext3.getPageActivity();
                        anVar6 = this.erO.erN;
                        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(pageActivity, anVar6.bookId));
                        tbPageContext4 = this.erO.Gd;
                        tbPageContext4.sendMessage(customMessage);
                        com.baidu.tbadk.core.util.ay ayVar2 = new com.baidu.tbadk.core.util.ay("c11442");
                        anVar7 = this.erO.erN;
                        TiebaStatic.log(ayVar2.ab("obj_id", anVar7.bookId).ab("obj_locate", "1"));
                    } else if (view == this.erO.erF) {
                        anVar3 = this.erO.erN;
                        if (!StringUtils.isNull(anVar3.Sb)) {
                            com.baidu.tbadk.core.util.bi vx = com.baidu.tbadk.core.util.bi.vx();
                            tbPageContext2 = this.erO.Gd;
                            anVar4 = this.erO.erN;
                            vx.c((TbPageContext) com.baidu.adp.base.l.C(tbPageContext2.getPageActivity()), new String[]{anVar4.Sb});
                            com.baidu.tbadk.core.util.ay ayVar3 = new com.baidu.tbadk.core.util.ay("c11442");
                            anVar5 = this.erO.erN;
                            TiebaStatic.log(ayVar3.ab("obj_id", anVar5.bookId).ab("obj_locate", "2"));
                        }
                    }
                }
            }
        }
    }
}
