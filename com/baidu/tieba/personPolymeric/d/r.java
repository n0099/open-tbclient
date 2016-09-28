package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ q eLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.eLC = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.personPolymeric.c.e eVar;
        com.baidu.tieba.personPolymeric.c.e eVar2;
        Context context;
        if (view != null) {
            eVar = this.eLC.eLB;
            if (eVar != null) {
                TiebaStatic.log(new ax("c11594"));
                eVar2 = this.eLC.eLB;
                String str = eVar2.forumName;
                if (az.aN(str)) {
                    MessageManager messageManager = MessageManager.getInstance();
                    context = this.eLC.mContext;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        }
    }
}
