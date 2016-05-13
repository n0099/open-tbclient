package com.baidu.tieba.pb.pb.a;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ r dgC;
    private final /* synthetic */ an dgD;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s dgE;
    private final /* synthetic */ com.baidu.tbadk.widget.richText.o dgF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, an anVar, com.baidu.tieba.tbadkCore.data.s sVar, com.baidu.tbadk.widget.richText.o oVar) {
        this.dgC = rVar;
        this.dgD = anVar;
        this.dgE = sVar;
        this.dgF = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.pb.data.e eVar;
        com.baidu.tieba.pb.data.e eVar2;
        com.baidu.tieba.pb.data.e eVar3;
        this.dgD.dgW.setVisibility(8);
        this.dgD.dgT.start();
        this.dgC.b(this.dgE, this.dgD);
        this.dgC.awf();
        this.dgC.c(this.dgF);
        this.dgC.a(this.dgD, this.dgF);
        eVar = this.dgC.dfK;
        if (eVar != null) {
            aw awVar = new aw("c10795");
            eVar2 = this.dgC.dfK;
            awVar.ac("fid", eVar2.getForumId());
            eVar3 = this.dgC.dfK;
            awVar.ac("tid", eVar3.getThreadId());
            TiebaStatic.log(awVar);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }
}
