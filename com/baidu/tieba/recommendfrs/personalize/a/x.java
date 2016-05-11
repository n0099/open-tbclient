package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.recommendfrs.personalize.a.v;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ v.a ebH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v.a aVar) {
        this.ebH = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TiebaStatic.log("c10983");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE));
    }
}
