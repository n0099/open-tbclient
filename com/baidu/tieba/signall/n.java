package com.baidu.tieba.signall;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class n implements Runnable {
    private final /* synthetic */ String bew;
    final /* synthetic */ SignAllForumActivity dxE;
    private final /* synthetic */ String dxF;
    private final /* synthetic */ boolean dxG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SignAllForumActivity signAllForumActivity, String str, String str2, boolean z) {
        this.dxE = signAllForumActivity;
        this.dxF = str;
        this.bew = str2;
        this.dxG = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dxE.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SignAllForumAdvertActivityConfig(this.dxE.getPageContext().getPageActivity(), this.dxF, this.bew, Boolean.valueOf(this.dxG))));
    }
}
