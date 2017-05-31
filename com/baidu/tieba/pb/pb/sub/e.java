package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.e.a;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.InterfaceC0059a {
    final /* synthetic */ b exL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.exL = bVar;
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0059a
    public void Y(int i, int i2) {
        b.a aVar;
        b.a aVar2;
        int i3;
        a aVar3;
        BaseActivity baseActivity;
        a aVar4;
        aVar = this.exL.exI;
        if (aVar != null) {
            aVar2 = this.exL.exI;
            if (aVar2.aNL()) {
                int abs = Math.abs(i2);
                i3 = b.TOUCH_SLOP;
                if (abs > i3) {
                    aVar3 = this.exL.exG;
                    if (aVar3 != null) {
                        aVar4 = this.exL.exG;
                        aVar4.setBackgroundResource(w.e.transparent);
                    }
                    baseActivity = this.exL.bfa;
                    baseActivity.finish();
                }
            }
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0059a
    public void Z(int i, int i2) {
        this.exL.aNG();
    }
}
