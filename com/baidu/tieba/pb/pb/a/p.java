package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements a.b {
    private final /* synthetic */ String cqS;
    final /* synthetic */ k dgn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(k kVar, String str) {
        this.dgn = kVar;
        this.cqS = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.data.e eVar;
        com.baidu.tieba.pb.data.e eVar2;
        com.baidu.tieba.tbadkCore.x xVar;
        com.baidu.tieba.pb.data.e eVar3;
        com.baidu.tieba.pb.data.e eVar4;
        com.baidu.tieba.pb.data.e eVar5;
        com.baidu.tieba.pb.data.e eVar6;
        aVar.dismiss();
        eVar = this.dgn.dfK;
        if (eVar != null) {
            eVar2 = this.dgn.dfK;
            if (eVar2.avA() != null) {
                xVar = this.dgn.Dp;
                eVar3 = this.dgn.dfK;
                String name = eVar3.avA().getName();
                eVar4 = this.dgn.dfK;
                xVar.bH(name, eVar4.avA().getId());
                aw awVar = new aw("c10409");
                eVar5 = this.dgn.dfK;
                aw ac = awVar.ac("fid", eVar5.getForumId());
                eVar6 = this.dgn.dfK;
                TiebaStatic.log(ac.ac("tid", eVar6.getThreadId()).ac("uid", this.cqS).ac("is_like", "1"));
            }
        }
    }
}
