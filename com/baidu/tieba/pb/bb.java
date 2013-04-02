package com.baidu.tieba.pb;

import android.content.DialogInterface;
import java.util.ArrayList;
/* loaded from: classes.dex */
class bb implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        com.baidu.tieba.b.r rVar;
        com.baidu.tieba.b.r rVar2;
        long j;
        switch (i) {
            case 0:
                str = this.a.p;
                if (str != null) {
                    str2 = this.a.p;
                    if (str2.length() > 0) {
                        rVar = this.a.o;
                        if (rVar.a() != null) {
                            rVar2 = this.a.o;
                            ArrayList d = rVar2.a().d();
                            j = this.a.v;
                            com.baidu.tieba.a.an anVar = (com.baidu.tieba.a.an) d.get((int) j);
                            this.a.w = anVar;
                            this.a.a(anVar);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.a.t();
                return;
            default:
                return;
        }
    }
}
