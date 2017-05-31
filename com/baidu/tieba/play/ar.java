package com.baidu.tieba.play;

import com.baidu.tieba.play.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements as.a {
    final /* synthetic */ ap fbT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ap apVar) {
        this.fbT = apVar;
    }

    @Override // com.baidu.tieba.play.as.a
    public void onChange(boolean z) {
        this.fbT.fbQ = z;
    }
}
