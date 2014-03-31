package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bz implements com.baidu.tbadk.editortool.x {
    final /* synthetic */ bk a;
    private final /* synthetic */ com.baidu.tbadk.editortool.x b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bk bkVar, com.baidu.tbadk.editortool.x xVar) {
        this.a = bkVar;
        this.b = xVar;
    }

    @Override // com.baidu.tbadk.editortool.x
    public final void a(int i, Object obj) {
        PbActivity pbActivity;
        if (i == 35 && !this.a.j.h() && !this.a.j.i()) {
            pbActivity = this.a.m;
            TiebaStatic.a(pbActivity, "pb_reply", "pbclick", 1, new Object[0]);
        }
        this.b.a(i, obj);
    }
}
