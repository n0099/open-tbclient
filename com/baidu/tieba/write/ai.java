package com.baidu.tieba.write;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ImageProblemActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements View.OnClickListener {
    final /* synthetic */ WriteActivity bTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(WriteActivity writeActivity) {
        this.bTX = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bTX.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(this.bTX)));
    }
}
