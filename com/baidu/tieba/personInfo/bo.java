package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements View.OnClickListener {
    final /* synthetic */ bm epX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bm bmVar) {
        this.epX = bmVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10606"));
        MessageManager messageManager = MessageManager.getInstance();
        baseFragmentActivity = this.epX.bfw;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(baseFragmentActivity.getPageContext().getPageActivity(), 0L)));
    }
}
