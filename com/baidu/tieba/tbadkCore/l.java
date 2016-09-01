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
public class l implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView fpW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsPraiseView frsPraiseView) {
        this.fpW = frsPraiseView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PraiseData praiseData;
        Context context;
        praiseData = this.fpW.fpU;
        MetaData metaData = praiseData.getUser().get(0);
        if (metaData != null) {
            context = this.fpW.mContext;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(context).createNormalConfig(com.baidu.adp.lib.h.b.c(metaData.getUserId(), 0L), false)));
        }
    }
}
