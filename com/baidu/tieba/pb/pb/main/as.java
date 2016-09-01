package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.e.c;
/* loaded from: classes.dex */
class as implements c.a {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // com.baidu.tieba.e.c.a
    public void cM(boolean z) {
        if (z) {
            com.baidu.tieba.pb.a.c.aMq();
        } else {
            com.baidu.tieba.pb.a.c.aMp();
        }
    }
}
