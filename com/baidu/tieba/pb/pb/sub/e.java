package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.e.a;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.InterfaceC0056a {
    final /* synthetic */ b eux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.eux = bVar;
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0056a
    public void V(int i, int i2) {
        b.a aVar;
        b.a aVar2;
        int i3;
        a aVar3;
        BaseActivity baseActivity;
        a aVar4;
        aVar = this.eux.euu;
        if (aVar != null) {
            aVar2 = this.eux.euu;
            if (aVar2.aOd()) {
                int abs = Math.abs(i2);
                i3 = b.eut;
                if (abs > i3) {
                    aVar3 = this.eux.eur;
                    if (aVar3 != null) {
                        aVar4 = this.eux.eur;
                        aVar4.setBackgroundResource(w.e.transparent);
                    }
                    baseActivity = this.eux.bcF;
                    baseActivity.finish();
                }
            }
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0056a
    public void W(int i, int i2) {
        this.eux.aNY();
    }
}
