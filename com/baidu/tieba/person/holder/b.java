package com.baidu.tieba.person.holder;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCoverActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ BookShelfItemView eCF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BookShelfItemView bookShelfItemView) {
        this.eCF = bookShelfItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.personInfo.b bVar;
        com.baidu.tieba.personInfo.b bVar2;
        TbPageContext tbPageContext;
        com.baidu.tieba.personInfo.b bVar3;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        com.baidu.tieba.personInfo.b bVar4;
        TbPageContext tbPageContext4;
        if (view != null) {
            bVar = this.eCF.eCB;
            if (bVar != null) {
                TiebaStatic.log(new ay("c11390").s("obj_type", 1));
                bVar2 = this.eCF.eCB;
                if (bVar2.Qa == 3) {
                    if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                        tbPageContext4 = this.eCF.GM;
                        k.showToast(tbPageContext4.getPageActivity(), t.j.manga_plugin_not_install_tip);
                        return;
                    }
                    tbPageContext3 = this.eCF.GM;
                    Activity pageActivity = tbPageContext3.getPageActivity();
                    bVar4 = this.eCF.eCB;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaCoverActivityConfig(pageActivity, bVar4.eGK)));
                } else if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    tbPageContext2 = this.eCF.GM;
                    k.showToast(tbPageContext2.getPageActivity(), t.j.book_plugin_not_install_tip);
                } else {
                    tbPageContext = this.eCF.GM;
                    Activity pageActivity2 = tbPageContext.getPageActivity();
                    bVar3 = this.eCF.eCB;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(pageActivity2, bVar3.bookId)));
                }
            }
        }
    }
}
