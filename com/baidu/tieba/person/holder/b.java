package com.baidu.tieba.person.holder;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.MangaCoverActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ BookShelfItemView euf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BookShelfItemView bookShelfItemView) {
        this.euf = bookShelfItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.personInfo.c cVar;
        com.baidu.tieba.personInfo.c cVar2;
        TbPageContext tbPageContext;
        com.baidu.tieba.personInfo.c cVar3;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        com.baidu.tieba.personInfo.c cVar4;
        TbPageContext tbPageContext4;
        if (view != null) {
            cVar = this.euf.eub;
            if (cVar != null) {
                TiebaStatic.log(new ay("c11390").s("obj_type", 1));
                cVar2 = this.euf.eub;
                if (cVar2.NC == 3) {
                    if (!TbadkCoreApplication.m10getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                        tbPageContext4 = this.euf.EA;
                        com.baidu.adp.lib.util.k.showToast(tbPageContext4.getPageActivity(), u.j.manga_plugin_not_install_tip);
                        return;
                    }
                    tbPageContext3 = this.euf.EA;
                    Activity pageActivity = tbPageContext3.getPageActivity();
                    cVar4 = this.euf.eub;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaCoverActivityConfig(pageActivity, cVar4.eAg)));
                } else if (!TbadkCoreApplication.m10getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    tbPageContext2 = this.euf.EA;
                    com.baidu.adp.lib.util.k.showToast(tbPageContext2.getPageActivity(), u.j.book_plugin_not_install_tip);
                } else {
                    tbPageContext = this.euf.EA;
                    Activity pageActivity2 = tbPageContext.getPageActivity();
                    cVar3 = this.euf.eub;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(pageActivity2, cVar3.bookId)));
                }
            }
        }
    }
}
