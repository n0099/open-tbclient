package com.baidu.tieba.pb.pb.a;

import com.baidu.tieba.play.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements t.b {
    final /* synthetic */ d dXu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(d dVar) {
        this.dXu = dVar;
    }

    @Override // com.baidu.tieba.play.t.b
    public boolean onError(com.baidu.tieba.play.t tVar, int i, int i2) {
        this.dXu.e(true, 4);
        return true;
    }
}
