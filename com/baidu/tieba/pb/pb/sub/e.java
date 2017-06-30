package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.e.a;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.InterfaceC0062a {
    final /* synthetic */ b eHj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.eHj = bVar;
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0062a
    public void ah(int i, int i2) {
        b.a aVar;
        b.a aVar2;
        int i3;
        a aVar3;
        BaseActivity baseActivity;
        a aVar4;
        aVar = this.eHj.eHg;
        if (aVar != null) {
            aVar2 = this.eHj.eHg;
            if (aVar2.aRL()) {
                int abs = Math.abs(i2);
                i3 = b.TOUCH_SLOP;
                if (abs > i3) {
                    aVar3 = this.eHj.eHe;
                    if (aVar3 != null) {
                        aVar4 = this.eHj.eHe;
                        aVar4.setBackgroundResource(w.e.transparent);
                    }
                    baseActivity = this.eHj.bhX;
                    baseActivity.finish();
                }
            }
        }
    }

    @Override // com.baidu.tieba.e.a.InterfaceC0062a
    public void ai(int i, int i2) {
        this.eHj.aRG();
    }
}
