package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ q eIV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.eIV = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.personPolymeric.c.e eVar;
        com.baidu.tieba.personPolymeric.c.e eVar2;
        Context context;
        if (view != null) {
            eVar = this.eIV.eIU;
            if (eVar != null) {
                TiebaStatic.log(new as("c11594"));
                eVar2 = this.eIV.eIU;
                String str = eVar2.forumName;
                if (au.aG(str)) {
                    MessageManager messageManager = MessageManager.getInstance();
                    context = this.eIV.mContext;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        }
    }
}
