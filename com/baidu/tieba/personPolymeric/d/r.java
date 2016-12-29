package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ q evz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.evz = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.personPolymeric.c.e eVar;
        com.baidu.tieba.personPolymeric.c.e eVar2;
        Context context;
        if (view != null) {
            eVar = this.evz.evy;
            if (eVar != null) {
                TiebaStatic.log(new at("c11594"));
                eVar2 = this.evz.evy;
                String str = eVar2.forumName;
                if (av.aN(str)) {
                    MessageManager messageManager = MessageManager.getInstance();
                    context = this.evz.mContext;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        }
    }
}
