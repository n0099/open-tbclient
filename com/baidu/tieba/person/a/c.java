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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b enY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.enY = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.person.data.b bVar;
        com.baidu.tieba.person.data.b bVar2;
        TbPageContext tbPageContext;
        com.baidu.tieba.person.data.b bVar3;
        TbPageContext tbPageContext2;
        bVar = this.enY.enX;
        if (bVar != null) {
            bVar2 = this.enY.enX;
            if (!StringUtils.isNull(bVar2.eos)) {
                if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyBookrackActivityConfig.class)) {
                    tbPageContext2 = this.enY.btW;
                    com.baidu.adp.lib.util.k.showToast(tbPageContext2.getPageActivity(), r.j.book_plugin_not_install_tip);
                    return;
                }
                tbPageContext = this.enY.btW;
                Activity pageActivity = tbPageContext.getPageActivity();
                bVar3 = this.enY.enX;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyBookrackActivityConfig(pageActivity, 0, bVar3.eos)));
                TiebaStatic.log(new at("c11390").s("obj_type", 2));
            }
        }
    }
}
