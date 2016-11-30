package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d.a;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.InterfaceC0058a {
    final /* synthetic */ b eDZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.eDZ = bVar;
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0058a
    public void P(int i, int i2) {
        b.a aVar;
        b.a aVar2;
        int i3;
        a aVar3;
        BaseActivity baseActivity;
        a aVar4;
        aVar = this.eDZ.eDW;
        if (aVar != null) {
            aVar2 = this.eDZ.eDW;
            if (aVar2.aTa()) {
                int abs = Math.abs(i2);
                i3 = b.eDV;
                if (abs > i3) {
                    aVar3 = this.eDZ.eDT;
                    if (aVar3 != null) {
                        aVar4 = this.eDZ.eDT;
                        aVar4.setBackgroundResource(r.d.transparent);
                    }
                    baseActivity = this.eDZ.aTb;
                    baseActivity.finish();
                }
            }
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0058a
    public void Q(int i, int i2) {
        this.eDZ.aSV();
    }
}
