package com.baidu.tieba.person.a;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b exS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.exS = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.person.data.b bVar;
        com.baidu.tieba.person.data.b bVar2;
        TbPageContext tbPageContext;
        com.baidu.tieba.person.data.b bVar3;
        TbPageContext tbPageContext2;
        bVar = this.exS.exR;
        if (bVar != null) {
            bVar2 = this.exS.exR;
            if (!StringUtils.isNull(bVar2.eyl)) {
                if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyBookrackActivityConfig.class)) {
                    tbPageContext2 = this.exS.bBE;
                    com.baidu.adp.lib.util.k.showToast(tbPageContext2.getPageActivity(), r.l.book_plugin_not_install_tip);
                    return;
                }
                tbPageContext = this.exS.bBE;
                Activity pageActivity = tbPageContext.getPageActivity();
                bVar3 = this.exS.exR;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyBookrackActivityConfig(pageActivity, 0, bVar3.eyl)));
                TiebaStatic.log(new ar("c11390").s("obj_type", 2));
            }
        }
    }
}
