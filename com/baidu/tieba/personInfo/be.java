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
public class be implements View.OnClickListener {
    final /* synthetic */ bc dji;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bc bcVar) {
        this.dji = bcVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10606"));
        MessageManager messageManager = MessageManager.getInstance();
        baseFragmentActivity = this.dji.cZG;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(baseFragmentActivity.getPageContext().getPageActivity(), 0L)));
    }
}
