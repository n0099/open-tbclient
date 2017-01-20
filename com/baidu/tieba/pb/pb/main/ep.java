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
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ep implements View.OnClickListener {
    final /* synthetic */ eo ens;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ep(eo eoVar) {
        this.ens = eoVar;
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
        tbPageContext = this.ens.Fp;
        if (com.baidu.tbadk.core.util.bf.ak(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.gB()) {
            arVar = this.ens.enr;
            if (arVar != null) {
                arVar2 = this.ens.enr;
                if (!StringUtils.isNull(arVar2.bookId)) {
                    if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        tbPageContext6 = this.ens.Fp;
                        com.baidu.adp.lib.util.k.showToast(tbPageContext6.getPageActivity(), r.l.book_plugin_not_install_tip);
                    } else if (view == this.ens.eno) {
                        arVar8 = this.ens.enr;
                        String str = arVar8.bookId;
                        com.baidu.tbadk.core.data.an anVar = new com.baidu.tbadk.core.data.an();
                        tbPageContext5 = this.ens.Fp;
                        anVar.pageContext = (TbPageContext) com.baidu.adp.base.k.C(tbPageContext5.getPageActivity());
                        anVar.bookId = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, anVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11387").s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).ab("obj_locate", "0").ab("obj_param1", str));
                        com.baidu.tbadk.core.util.ar arVar10 = new com.baidu.tbadk.core.util.ar("c11442");
                        arVar9 = this.ens.enr;
                        TiebaStatic.log(arVar10.ab("obj_id", arVar9.bookId).ab("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    } else if (view == this.ens.enq) {
                        tbPageContext3 = this.ens.Fp;
                        Activity pageActivity = tbPageContext3.getPageActivity();
                        arVar6 = this.ens.enr;
                        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(pageActivity, arVar6.bookId));
                        tbPageContext4 = this.ens.Fp;
                        tbPageContext4.sendMessage(customMessage);
                        com.baidu.tbadk.core.util.ar arVar11 = new com.baidu.tbadk.core.util.ar("c11442");
                        arVar7 = this.ens.enr;
                        TiebaStatic.log(arVar11.ab("obj_id", arVar7.bookId).ab("obj_locate", "1"));
                    } else if (view == this.ens.enj) {
                        arVar3 = this.ens.enr;
                        if (!StringUtils.isNull(arVar3.RG)) {
                            com.baidu.tbadk.core.util.ba vt = com.baidu.tbadk.core.util.ba.vt();
                            tbPageContext2 = this.ens.Fp;
                            arVar4 = this.ens.enr;
                            vt.c((TbPageContext) com.baidu.adp.base.k.C(tbPageContext2.getPageActivity()), new String[]{arVar4.RG});
                            com.baidu.tbadk.core.util.ar arVar12 = new com.baidu.tbadk.core.util.ar("c11442");
                            arVar5 = this.ens.enr;
                            TiebaStatic.log(arVar12.ab("obj_id", arVar5.bookId).ab("obj_locate", "2"));
                        }
                    }
                }
            }
        }
    }
}
