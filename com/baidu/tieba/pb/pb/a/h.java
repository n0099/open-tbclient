package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    private final /* synthetic */ String cpV;
    final /* synthetic */ d ddH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar, String str) {
        this.ddH = dVar;
        this.cpV = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.data.e eVar;
        com.baidu.tieba.pb.data.e eVar2;
        com.baidu.tieba.pb.data.e eVar3;
        aVar.dismiss();
        this.ddH.lQ(1);
        eVar = this.ddH.ddF;
        if (eVar != null) {
            aw awVar = new aw("c10398");
            eVar2 = this.ddH.ddF;
            aw ac = awVar.ac("fid", eVar2.getForumId());
            eVar3 = this.ddH.ddF;
            TiebaStatic.log(ac.ac("tid", eVar3.getThreadId()).ac("uid", this.cpV).ac("is_like", "1"));
        }
    }
}
