package com.baidu.tieba.pb;

import android.os.Handler;
/* loaded from: classes.dex */
final class dm implements Runnable {
    final /* synthetic */ dl a;
    private final /* synthetic */ com.baidu.tieba.data.av b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(dl dlVar, com.baidu.tieba.data.av avVar, boolean z, String str, String str2) {
        this.a = dlVar;
        this.b = avVar;
        this.c = z;
        this.d = str;
        this.e = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        cu cuVar;
        dy dyVar;
        cu cuVar2;
        cu cuVar3;
        ed edVar;
        cu cuVar4;
        dy dyVar2;
        cuVar = this.a.a;
        dyVar = cuVar.aj;
        if (dyVar != null) {
            cuVar4 = this.a.a;
            dyVar2 = cuVar4.aj;
            com.baidu.tieba.data.av avVar = this.b;
            dyVar2.a();
        }
        if (this.c) {
            cuVar3 = this.a.a;
            edVar = cuVar3.s;
            String str = this.d;
            String str2 = this.e;
            edVar.b(str);
            new Handler().postDelayed(new el(edVar, str2), 200L);
        }
        cuVar2 = this.a.a;
        cuVar2.aa();
    }
}
