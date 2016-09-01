package com.baidu.tieba.personPolymeric.d;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ q eJz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.eJz = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.personPolymeric.c.e eVar;
        com.baidu.tieba.personPolymeric.c.e eVar2;
        Context context;
        if (view != null) {
            eVar = this.eJz.eJy;
            if (eVar != null) {
                TiebaStatic.log(new ay("c11594"));
                eVar2 = this.eJz.eJy;
                String str = eVar2.forumName;
                if (ba.aN(str)) {
                    MessageManager messageManager = MessageManager.getInstance();
                    context = this.eJz.mContext;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(context).createNormalCfg(str, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        }
    }
}
