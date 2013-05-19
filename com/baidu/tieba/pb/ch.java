package com.baidu.tieba.pb;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements com.baidu.tieba.view.ad {
    final /* synthetic */ bl a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(bl blVar) {
        this.a = blVar;
    }

    @Override // com.baidu.tieba.view.ad
    public void a(int i) {
        cr crVar;
        cr crVar2;
        switch (i) {
            case 0:
                if (this.a.t()) {
                    crVar = this.a.A;
                    crVar.c();
                } else {
                    new Handler().postDelayed(new cj(this), 0L);
                }
                this.a.ao = true;
                return;
            case 1:
                if (this.a.t()) {
                    crVar2 = this.a.A;
                    crVar2.h();
                } else {
                    new Handler().postDelayed(new ci(this), 0L);
                }
                this.a.ao = false;
                return;
            default:
                return;
        }
    }
}
