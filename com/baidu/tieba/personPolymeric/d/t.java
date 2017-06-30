package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ s eXM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.eXM = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.personPolymeric.c.f fVar;
        com.baidu.tieba.personPolymeric.c.f fVar2;
        Context context;
        if (view != null) {
            fVar = this.eXM.eXL;
            if (fVar != null) {
                TiebaStatic.log(new au("c11594"));
                fVar2 = this.eXM.eXL;
                String str = fVar2.forumName;
                if (aw.aG(str)) {
                    MessageManager messageManager = MessageManager.getInstance();
                    context = this.eXM.mContext;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        }
    }
}
