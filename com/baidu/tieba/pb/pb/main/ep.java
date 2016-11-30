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
public class ep implements View.OnClickListener {
    final /* synthetic */ eo eAo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ep(eo eoVar) {
        this.eAo = eoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.ar arVar;
        com.baidu.tbadk.core.data.ar arVar2;
        com.baidu.tbadk.core.data.ar arVar3;
        TbPageContext tbPageContext2;
        com.baidu.tbadk.core.data.ar arVar4;
        com.baidu.tbadk.core.data.ar arVar5;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.ar arVar6;
        TbPageContext tbPageContext4;
        com.baidu.tbadk.core.data.ar arVar7;
        com.baidu.tbadk.core.data.ar arVar8;
        TbPageContext tbPageContext5;
        com.baidu.tbadk.core.data.ar arVar9;
        TbPageContext tbPageContext6;
        tbPageContext = this.eAo.Gf;
        if (com.baidu.tbadk.core.util.bk.ak(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.gD()) {
            arVar = this.eAo.eAn;
            if (arVar != null) {
                arVar2 = this.eAo.eAn;
                if (!StringUtils.isNull(arVar2.bookId)) {
                    if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        tbPageContext6 = this.eAo.Gf;
                        com.baidu.adp.lib.util.k.showToast(tbPageContext6.getPageActivity(), r.j.book_plugin_not_install_tip);
                    } else if (view == this.eAo.eAk) {
                        arVar8 = this.eAo.eAn;
                        String str = arVar8.bookId;
                        com.baidu.tbadk.core.data.an anVar = new com.baidu.tbadk.core.data.an();
                        tbPageContext5 = this.eAo.Gf;
                        anVar.pageContext = (TbPageContext) com.baidu.adp.base.l.C(tbPageContext5.getPageActivity());
                        anVar.bookId = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, anVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.av("c11387").s("obj_source", 6).ab("obj_locate", "0").ab("obj_param1", str));
                        com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c11442");
                        arVar9 = this.eAo.eAn;
                        TiebaStatic.log(avVar.ab("obj_id", arVar9.bookId).ab("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    } else if (view == this.eAo.eAm) {
                        tbPageContext3 = this.eAo.Gf;
                        Activity pageActivity = tbPageContext3.getPageActivity();
                        arVar6 = this.eAo.eAn;
                        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(pageActivity, arVar6.bookId));
                        tbPageContext4 = this.eAo.Gf;
                        tbPageContext4.sendMessage(customMessage);
                        com.baidu.tbadk.core.util.av avVar2 = new com.baidu.tbadk.core.util.av("c11442");
                        arVar7 = this.eAo.eAn;
                        TiebaStatic.log(avVar2.ab("obj_id", arVar7.bookId).ab("obj_locate", "1"));
                    } else if (view == this.eAo.eAf) {
                        arVar3 = this.eAo.eAn;
                        if (!StringUtils.isNull(arVar3.SC)) {
                            com.baidu.tbadk.core.util.bf vP = com.baidu.tbadk.core.util.bf.vP();
                            tbPageContext2 = this.eAo.Gf;
                            arVar4 = this.eAo.eAn;
                            vP.c((TbPageContext) com.baidu.adp.base.l.C(tbPageContext2.getPageActivity()), new String[]{arVar4.SC});
                            com.baidu.tbadk.core.util.av avVar3 = new com.baidu.tbadk.core.util.av("c11442");
                            arVar5 = this.eAo.eAn;
                            TiebaStatic.log(avVar3.ab("obj_id", arVar5.bookId).ab("obj_locate", "2"));
                        }
                    }
                }
            }
        }
    }
}
