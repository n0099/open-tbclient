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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b ezy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.ezy = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.person.data.b bVar;
        com.baidu.tieba.person.data.b bVar2;
        TbPageContext tbPageContext;
        com.baidu.tieba.person.data.b bVar3;
        TbPageContext tbPageContext2;
        bVar = this.ezy.ezx;
        if (bVar != null) {
            bVar2 = this.ezy.ezx;
            if (!StringUtils.isNull(bVar2.ezR)) {
                if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyBookrackActivityConfig.class)) {
                    tbPageContext2 = this.ezy.bID;
                    com.baidu.adp.lib.util.k.showToast(tbPageContext2.getPageActivity(), w.l.book_plugin_not_install_tip);
                    return;
                }
                tbPageContext = this.ezy.bID;
                Activity pageActivity = tbPageContext.getPageActivity();
                bVar3 = this.ezy.ezx;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyBookrackActivityConfig(pageActivity, 0, bVar3.ezR)));
                TiebaStatic.log(new as("c11390").s("obj_type", 2));
            }
        }
    }
}
