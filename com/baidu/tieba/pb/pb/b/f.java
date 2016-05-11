package com.baidu.tieba.pb.pb.b;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.cw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.b {
    final /* synthetic */ a dhT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.dhT = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        PbActivity pbActivity;
        aVar.dismiss();
        pbActivity = this.dhT.dhQ;
        cw awu = pbActivity.awu();
        if (awu != null && awu.getPbData() != null) {
            TiebaStatic.log(new aw("c10505").ac("fid", awu.getPbData().getForumId()).ac("tid", awu.getPbData().getThreadId()).ac("obj_locate", "1"));
        }
    }
}
