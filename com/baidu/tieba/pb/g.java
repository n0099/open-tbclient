package com.baidu.tieba.pb;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    private final /* synthetic */ String epu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(String str) {
        this.epu = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_NICK_NAME_ACT, this.epu));
    }
}
