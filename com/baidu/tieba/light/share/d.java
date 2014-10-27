package com.baidu.tieba.light.share;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ LightappGameShare blK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(LightappGameShare lightappGameShare) {
        this.blK = lightappGameShare;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.coreExtra.share.d dVar;
        com.baidu.tbadk.coreExtra.share.d dVar2;
        dVar = this.blK.aIb;
        if (dVar != null) {
            dVar2 = this.blK.aIb;
            dVar2.dismiss();
            this.blK.aIb = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonGroupActivityConfig(this.blK, 23003, 2)));
        this.blK.finish();
    }
}
