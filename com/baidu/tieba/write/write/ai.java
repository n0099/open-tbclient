package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageProblemActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ WriteActivity dYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(WriteActivity writeActivity) {
        this.dYD = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dYD.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(this.dYD.getPageContext().getPageActivity())));
    }
}
