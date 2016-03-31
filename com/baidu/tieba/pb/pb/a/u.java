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
    final /* synthetic */ r dej;
    private final /* synthetic */ an dek;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.data.s del;
    private final /* synthetic */ com.baidu.tbadk.widget.richText.n dem;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, an anVar, com.baidu.tieba.tbadkCore.data.s sVar, com.baidu.tbadk.widget.richText.n nVar) {
        this.dej = rVar;
        this.dek = anVar;
        this.del = sVar;
        this.dem = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.pb.data.e eVar;
        com.baidu.tieba.pb.data.e eVar2;
        com.baidu.tieba.pb.data.e eVar3;
        this.dek.deD.setVisibility(8);
        this.dek.deA.start();
        this.dej.b(this.del, this.dek);
        this.dej.avT();
        this.dej.c(this.dem);
        this.dej.a(this.dek, this.dem);
        eVar = this.dej.ddq;
        if (eVar != null) {
            aw awVar = new aw("c10795");
            eVar2 = this.dej.ddq;
            awVar.ac("fid", eVar2.getForumId());
            eVar3 = this.dej.ddq;
            awVar.ac("tid", eVar3.getThreadId());
            TiebaStatic.log(awVar);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }
}
