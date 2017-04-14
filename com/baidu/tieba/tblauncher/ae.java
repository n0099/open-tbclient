package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ z fAp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(z zVar) {
        this.fAp = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().runTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, (Class) null);
    }
}
