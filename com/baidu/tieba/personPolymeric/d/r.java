package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ q eSa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.eSa = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.personPolymeric.c.e eVar;
        com.baidu.tieba.personPolymeric.c.e eVar2;
        Context context;
        if (view != null) {
            eVar = this.eSa.eRZ;
            if (eVar != null) {
                TiebaStatic.log(new av("c11594"));
                eVar2 = this.eSa.eRZ;
                String str = eVar2.forumName;
                if (ax.aN(str)) {
                    MessageManager messageManager = MessageManager.getInstance();
                    context = this.eSa.mContext;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        }
    }
}
