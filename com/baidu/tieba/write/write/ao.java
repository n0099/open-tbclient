package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageProblemActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ WriteActivity cyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.cyc = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cyc.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(this.cyc.getPageContext().getPageActivity())));
    }
}
