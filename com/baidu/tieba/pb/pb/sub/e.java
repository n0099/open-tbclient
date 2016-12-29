package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.d.a;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.InterfaceC0057a {
    final /* synthetic */ b ehZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.ehZ = bVar;
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0057a
    public void P(int i, int i2) {
        b.a aVar;
        b.a aVar2;
        int i3;
        a aVar3;
        BaseActivity baseActivity;
        a aVar4;
        aVar = this.ehZ.ehW;
        if (aVar != null) {
            aVar2 = this.ehZ.ehW;
            if (aVar2.aMR()) {
                int abs = Math.abs(i2);
                i3 = b.ehV;
                if (abs > i3) {
                    aVar3 = this.ehZ.ehT;
                    if (aVar3 != null) {
                        aVar4 = this.ehZ.ehT;
                        aVar4.setBackgroundResource(r.d.transparent);
                    }
                    baseActivity = this.ehZ.aSs;
                    baseActivity.finish();
                }
            }
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0057a
    public void Q(int i, int i2) {
        this.ehZ.aMM();
    }
}
