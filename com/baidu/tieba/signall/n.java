package com.baidu.tieba.signall;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class n implements Runnable {
    private final /* synthetic */ String bgQ;
    final /* synthetic */ SignAllForumActivity dNI;
    private final /* synthetic */ String dNJ;
    private final /* synthetic */ boolean dNK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SignAllForumActivity signAllForumActivity, String str, String str2, boolean z) {
        this.dNI = signAllForumActivity;
        this.dNJ = str;
        this.bgQ = str2;
        this.dNK = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dNI.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(this.dNI.getPageContext().getPageActivity(), this.dNJ, this.bgQ, Boolean.valueOf(this.dNK))));
    }
}
