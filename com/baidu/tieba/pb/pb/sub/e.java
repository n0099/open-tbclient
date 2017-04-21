package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.e.a;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.InterfaceC0055a {
    final /* synthetic */ b euT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.euT = bVar;
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0055a
    public void V(int i, int i2) {
        b.a aVar;
        b.a aVar2;
        int i3;
        a aVar3;
        BaseActivity baseActivity;
        a aVar4;
        aVar = this.euT.euQ;
        if (aVar != null) {
            aVar2 = this.euT.euQ;
            if (aVar2.aPn()) {
                int abs = Math.abs(i2);
                i3 = b.TOUCH_SLOP;
                if (abs > i3) {
                    aVar3 = this.euT.euO;
                    if (aVar3 != null) {
                        aVar4 = this.euT.euO;
                        aVar4.setBackgroundResource(w.e.transparent);
                    }
                    baseActivity = this.euT.bdG;
                    baseActivity.finish();
                }
            }
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0055a
    public void W(int i, int i2) {
        this.euT.aPi();
    }
}
