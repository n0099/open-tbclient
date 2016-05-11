package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.b {
    private final /* synthetic */ String cqS;
    final /* synthetic */ k dgn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar, String str) {
        this.dgn = kVar;
        this.cqS = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.data.e eVar;
        com.baidu.tieba.pb.data.e eVar2;
        com.baidu.tieba.pb.data.e eVar3;
        aVar.dismiss();
        eVar = this.dgn.dfK;
        if (eVar != null) {
            aw awVar = new aw("c10409");
            eVar2 = this.dgn.dfK;
            aw ac = awVar.ac("fid", eVar2.getForumId());
            eVar3 = this.dgn.dfK;
            TiebaStatic.log(ac.ac("tid", eVar3.getThreadId()).ac("uid", this.cqS).ac("is_like", "2"));
        }
    }
}
