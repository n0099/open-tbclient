package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.b {
    private final /* synthetic */ String cqS;
    final /* synthetic */ d dgb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar, String str) {
        this.dgb = dVar;
        this.cqS = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.data.e eVar;
        com.baidu.tieba.pb.data.e eVar2;
        com.baidu.tieba.pb.data.e eVar3;
        aVar.dismiss();
        eVar = this.dgb.dfY;
        if (eVar != null) {
            aw awVar = new aw("c10398");
            eVar2 = this.dgb.dfY;
            aw ac = awVar.ac("fid", eVar2.getForumId());
            eVar3 = this.dgb.dfY;
            TiebaStatic.log(ac.ac("tid", eVar3.getThreadId()).ac("uid", this.cqS).ac("is_like", "2"));
        }
    }
}
