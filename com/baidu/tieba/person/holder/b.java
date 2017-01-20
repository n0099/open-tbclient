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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ BookShelfItemView eyH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BookShelfItemView bookShelfItemView) {
        this.eyH = bookShelfItemView;
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
            bVar = this.eyH.eyD;
            if (bVar != null) {
                TiebaStatic.log(new ar("c11390").s("obj_type", 1));
                bVar2 = this.eyH.eyD;
                if (bVar2.Pw == 3) {
                    if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(MangaCoverActivityConfig.class)) {
                        tbPageContext4 = this.eyH.FY;
                        k.showToast(tbPageContext4.getPageActivity(), r.l.manga_plugin_not_install_tip);
                        return;
                    }
                    tbPageContext3 = this.eyH.FY;
                    Activity pageActivity = tbPageContext3.getPageActivity();
                    bVar4 = this.eyH.eyD;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MangaCoverActivityConfig(pageActivity, bVar4.eCE)));
                } else if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                    tbPageContext2 = this.eyH.FY;
                    k.showToast(tbPageContext2.getPageActivity(), r.l.book_plugin_not_install_tip);
                } else {
                    tbPageContext = this.eyH.FY;
                    Activity pageActivity2 = tbPageContext.getPageActivity();
                    bVar3 = this.eyH.eyD;
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BookCoverActivityConfig(pageActivity2, bVar3.bookId)));
                }
            }
        }
    }
}
