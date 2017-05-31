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
public class t implements View.OnClickListener {
    final /* synthetic */ s eND;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.eND = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.personPolymeric.c.f fVar;
        com.baidu.tieba.personPolymeric.c.f fVar2;
        Context context;
        if (view != null) {
            fVar = this.eND.eNC;
            if (fVar != null) {
                TiebaStatic.log(new as("c11594"));
                fVar2 = this.eND.eNC;
                String str = fVar2.forumName;
                if (au.aB(str)) {
                    MessageManager messageManager = MessageManager.getInstance();
                    context = this.eND.mContext;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        }
    }
}
