package com.baidu.tieba.pb.pb.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ r dej;
    private final /* synthetic */ an dek;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s del;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(r rVar, an anVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        this.dej = rVar;
        this.dek = anVar;
        this.del = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dek.deA.isPlaying()) {
            this.dek.deA.pause();
            this.dek.deF.setVisibility(0);
        } else {
            this.dej.a(this.dek, this.del);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }
}
