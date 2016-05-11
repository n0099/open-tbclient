package com.baidu.tieba.pb.pb.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ r dgC;
    private final /* synthetic */ an dgD;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s dgE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(r rVar, an anVar, com.baidu.tieba.tbadkCore.data.s sVar) {
        this.dgC = rVar;
        this.dgD = anVar;
        this.dgE = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dgD.dgT.isPlaying()) {
            this.dgD.dgT.pause();
            this.dgD.dgY.setVisibility(0);
        } else {
            this.dgC.a(this.dgD, this.dgE);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }
}
