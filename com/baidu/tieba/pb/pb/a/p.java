package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements a.b {
    private final /* synthetic */ String cpV;
    final /* synthetic */ k ddT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(k kVar, String str) {
        this.ddT = kVar;
        this.cpV = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.data.e eVar;
        com.baidu.tieba.pb.data.e eVar2;
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.pb.data.e eVar3;
        com.baidu.tieba.pb.data.e eVar4;
        com.baidu.tieba.pb.data.e eVar5;
        com.baidu.tieba.pb.data.e eVar6;
        aVar.dismiss();
        eVar = this.ddT.ddq;
        if (eVar != null) {
            eVar2 = this.ddT.ddq;
            if (eVar2.avu() != null) {
                wVar = this.ddT.MY;
                eVar3 = this.ddT.ddq;
                String name = eVar3.avu().getName();
                eVar4 = this.ddT.ddq;
                wVar.bC(name, eVar4.avu().getId());
                aw awVar = new aw("c10409");
                eVar5 = this.ddT.ddq;
                aw ac = awVar.ac("fid", eVar5.getForumId());
                eVar6 = this.ddT.ddq;
                TiebaStatic.log(ac.ac("tid", eVar6.getThreadId()).ac("uid", this.cpV).ac("is_like", "1"));
            }
        }
    }
}
