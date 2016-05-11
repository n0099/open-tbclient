package com.baidu.tieba.signall;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class n implements Runnable {
    private final /* synthetic */ String bhE;
    final /* synthetic */ SignAllForumActivity ejs;
    private final /* synthetic */ String ejt;
    private final /* synthetic */ boolean eju;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SignAllForumActivity signAllForumActivity, String str, String str2, boolean z) {
        this.ejs = signAllForumActivity;
        this.ejt = str;
        this.bhE = str2;
        this.eju = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ejs.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(this.ejs.getPageContext().getPageActivity(), this.ejt, this.bhE, Boolean.valueOf(this.eju))));
    }
}
