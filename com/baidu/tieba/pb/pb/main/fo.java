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
public class fo implements View.OnClickListener {
    final /* synthetic */ fn eBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fo(fn fnVar) {
        this.eBk = fnVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        com.baidu.tbadk.core.data.av avVar;
        com.baidu.tbadk.core.data.av avVar2;
        com.baidu.tbadk.core.data.av avVar3;
        TbPageContext tbPageContext2;
        com.baidu.tbadk.core.data.av avVar4;
        com.baidu.tbadk.core.data.av avVar5;
        TbPageContext tbPageContext3;
        com.baidu.tbadk.core.data.av avVar6;
        TbPageContext tbPageContext4;
        com.baidu.tbadk.core.data.av avVar7;
        com.baidu.tbadk.core.data.av avVar8;
        TbPageContext tbPageContext5;
        com.baidu.tbadk.core.data.av avVar9;
        TbPageContext tbPageContext6;
        tbPageContext = this.eBk.aat;
        if (com.baidu.tbadk.core.util.bl.aN(tbPageContext.getPageActivity()) && com.baidu.adp.lib.util.k.hA()) {
            avVar = this.eBk.eBj;
            if (avVar != null) {
                avVar2 = this.eBk.eBj;
                if (!StringUtils.isNull(avVar2.bookId)) {
                    if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        tbPageContext6 = this.eBk.aat;
                        com.baidu.adp.lib.util.k.showToast(tbPageContext6.getPageActivity(), w.l.book_plugin_not_install_tip);
                    } else if (view == this.eBk.eBg) {
                        avVar8 = this.eBk.eBj;
                        String str = avVar8.bookId;
                        com.baidu.tbadk.core.data.ar arVar = new com.baidu.tbadk.core.data.ar();
                        tbPageContext5 = this.eBk.aat;
                        arVar.pageContext = (TbPageContext) com.baidu.adp.base.k.Z(tbPageContext5.getPageActivity());
                        arVar.bookId = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_OPTION_TO_NOVEL_READER, arVar));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11387").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 6).Z("obj_locate", "0").Z("obj_param1", str));
                        com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c11442");
                        avVar9 = this.eBk.eBj;
                        TiebaStatic.log(auVar.Z("obj_id", avVar9.bookId).Z("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    } else if (view == this.eBk.eBi) {
                        tbPageContext3 = this.eBk.aat;
                        Activity pageActivity = tbPageContext3.getPageActivity();
                        avVar6 = this.eBk.eBj;
                        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(pageActivity, avVar6.bookId));
                        tbPageContext4 = this.eBk.aat;
                        tbPageContext4.sendMessage(customMessage);
                        com.baidu.tbadk.core.util.au auVar2 = new com.baidu.tbadk.core.util.au("c11442");
                        avVar7 = this.eBk.eBj;
                        TiebaStatic.log(auVar2.Z("obj_id", avVar7.bookId).Z("obj_locate", "1"));
                    } else if (view == this.eBk.eBb) {
                        avVar3 = this.eBk.eBj;
                        if (!StringUtils.isNull(avVar3.Wx)) {
                            com.baidu.tbadk.core.util.be vP = com.baidu.tbadk.core.util.be.vP();
                            tbPageContext2 = this.eBk.aat;
                            avVar4 = this.eBk.eBj;
                            vP.c((TbPageContext) com.baidu.adp.base.k.Z(tbPageContext2.getPageActivity()), new String[]{avVar4.Wx});
                            com.baidu.tbadk.core.util.au auVar3 = new com.baidu.tbadk.core.util.au("c11442");
                            avVar5 = this.eBk.eBj;
                            TiebaStatic.log(auVar3.Z("obj_id", avVar5.bookId).Z("obj_locate", "2"));
                        }
                    }
                }
            }
        }
    }
}
