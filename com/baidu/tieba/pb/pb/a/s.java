package com.baidu.tieba.pb.pb.a;

import com.baidu.tieba.play.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements t.b {
    final /* synthetic */ e esY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(e eVar) {
        this.esY = eVar;
    }

    @Override // com.baidu.tieba.play.t.b
    public boolean onError(com.baidu.tieba.play.t tVar, int i, int i2) {
        this.esY.e(true, 4);
        return true;
    }
}
