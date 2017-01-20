package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.f.a;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.InterfaceC0057a {
    final /* synthetic */ b erj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.erj = bVar;
    }

    @Override // com.baidu.tieba.f.a.InterfaceC0057a
    public void Q(int i, int i2) {
        b.a aVar;
        b.a aVar2;
        int i3;
        a aVar3;
        BaseActivity baseActivity;
        a aVar4;
        aVar = this.erj.erg;
        if (aVar != null) {
            aVar2 = this.erj.erg;
            if (aVar2.aOM()) {
                int abs = Math.abs(i2);
                i3 = b.erf;
                if (abs > i3) {
                    aVar3 = this.erj.erd;
                    if (aVar3 != null) {
                        aVar4 = this.erj.erd;
                        aVar4.setBackgroundResource(r.e.transparent);
                    }
                    baseActivity = this.erj.aWr;
                    baseActivity.finish();
                }
            }
        }
    }

    @Override // com.baidu.tieba.f.a.InterfaceC0057a
    public void R(int i, int i2) {
        this.erj.aOH();
    }
}
