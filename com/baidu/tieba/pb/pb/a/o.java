package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.b {
    private final /* synthetic */ String cpV;
    final /* synthetic */ k ddT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar, String str) {
        this.ddT = kVar;
        this.cpV = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.data.e eVar;
        com.baidu.tieba.pb.data.e eVar2;
        com.baidu.tieba.pb.data.e eVar3;
        aVar.dismiss();
        eVar = this.ddT.ddq;
        if (eVar != null) {
            aw awVar = new aw("c10409");
            eVar2 = this.ddT.ddq;
            aw ac = awVar.ac("fid", eVar2.getForumId());
            eVar3 = this.ddT.ddq;
            TiebaStatic.log(ac.ac("tid", eVar3.getThreadId()).ac("uid", this.cpV).ac("is_like", "2"));
        }
    }
}
