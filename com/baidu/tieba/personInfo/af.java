package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ ae cuI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.cuI = aeVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PersonInfoActivity personInfoActivity;
        MessageManager messageManager = MessageManager.getInstance();
        personInfoActivity = this.cuI.cqE;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(personInfoActivity.getPageContext().getPageActivity(), 0L)));
    }
}
