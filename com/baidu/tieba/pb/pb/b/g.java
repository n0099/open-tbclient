package com.baidu.tieba.pb.pb.b;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.cw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.b {
    final /* synthetic */ a dhT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.dhT = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        PbActivity pbActivity;
        aVar.dismiss();
        pbActivity = this.dhT.dhQ;
        cw awx = pbActivity.awx();
        if (awx != null && awx.getPbData() != null) {
            TiebaStatic.log(new aw("c10504").ac("fid", awx.getPbData().getForumId()).ac("tid", awx.getPbData().getThreadId()).ac("obj_locate", "2"));
        }
    }
}
