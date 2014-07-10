package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ bt a;
    private final /* synthetic */ com.baidu.tbadk.editortool.w b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(bt btVar, com.baidu.tbadk.editortool.w wVar) {
        this.a = btVar;
        this.b = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void a(int i, Object obj) {
        PbActivity pbActivity;
        if (i == 35 && !this.a.h.h() && !this.a.h.j()) {
            pbActivity = this.a.k;
            TiebaStatic.eventStat(pbActivity, "pb_reply", "pbclick", 1, new Object[0]);
        }
        this.b.a(i, obj);
    }
}
