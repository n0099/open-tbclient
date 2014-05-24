package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements com.baidu.tbadk.editortool.x {
    final /* synthetic */ bq a;
    private final /* synthetic */ com.baidu.tbadk.editortool.x b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(bq bqVar, com.baidu.tbadk.editortool.x xVar) {
        this.a = bqVar;
        this.b = xVar;
    }

    @Override // com.baidu.tbadk.editortool.x
    public void a(int i, Object obj) {
        PbActivity pbActivity;
        if (i == 35 && !this.a.j.h() && !this.a.j.j()) {
            pbActivity = this.a.m;
            TiebaStatic.eventStat(pbActivity, "pb_reply", "pbclick", 1, new Object[0]);
        }
        this.b.a(i, obj);
    }
}
