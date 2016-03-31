package com.baidu.tieba.signall;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class n implements Runnable {
    private final /* synthetic */ String blB;
    final /* synthetic */ SignAllForumActivity egh;
    private final /* synthetic */ String egi;
    private final /* synthetic */ boolean egj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SignAllForumActivity signAllForumActivity, String str, String str2, boolean z) {
        this.egh = signAllForumActivity;
        this.egi = str;
        this.blB = str2;
        this.egj = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.egh.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(this.egh.getPageContext().getPageActivity(), this.egi, this.blB, Boolean.valueOf(this.egj))));
    }
}
