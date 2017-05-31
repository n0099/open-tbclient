package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView fzC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsPraiseView frsPraiseView) {
        this.fzC = frsPraiseView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PraiseData praiseData;
        Context context;
        praiseData = this.fzC.fzA;
        MetaData metaData = praiseData.getUser().get(1);
        if (metaData != null) {
            context = this.fzC.mContext;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(context).createNormalConfig(com.baidu.adp.lib.g.b.c(metaData.getUserId(), 0L), false, metaData.isBigV())));
        }
    }
}
