package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements a.b {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        df dfVar;
        df dfVar2;
        df dfVar3;
        df dfVar4;
        aVar.dismiss();
        dfVar = this.dht.dfV;
        if (dfVar != null) {
            dfVar2 = this.dht.dfV;
            if (dfVar2.getPbData() != null) {
                com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10398");
                dfVar3 = this.dht.dfV;
                com.baidu.tbadk.core.util.aw ac = awVar.ac("fid", dfVar3.getPbData().getForumId());
                dfVar4 = this.dht.dfV;
                TiebaStatic.log(ac.ac("tid", dfVar4.getPbData().getThreadId()).ac("is_like", "2"));
            }
        }
    }
}
