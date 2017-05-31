package com.baidu.tieba.pb.video;

import com.baidu.tieba.pb.view.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements d.a {
    final /* synthetic */ l eAW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.eAW = lVar;
    }

    @Override // com.baidu.tieba.pb.view.d.a
    public void onAnimationEnd() {
        this.eAW.jk(false);
    }
}
