package com.baidu.tieba.mainentrance;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.CreateBarGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(SquareSearchActivity squareSearchActivity) {
        this.bVC = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bd.ah(this.bVC.getPageContext().getPageActivity())) {
            this.bVC.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarGuideActivityConfig(this.bVC.getPageContext().getPageActivity(), this.bVC.bUV)));
        }
    }
}
