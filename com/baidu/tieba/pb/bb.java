package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.tieba.R;
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
        com.baidu.tieba.a.ac o;
        a aVar;
        boolean z;
        String str;
        String str2;
        com.baidu.tieba.b.q qVar;
        com.baidu.tieba.b.q qVar2;
        long j;
        switch (i) {
            case 0:
                str = this.a.q;
                if (str != null) {
                    str2 = this.a.q;
                    if (str2.length() > 0) {
                        qVar = this.a.p;
                        if (qVar.a() != null) {
                            qVar2 = this.a.p;
                            ArrayList d = qVar2.a().d();
                            j = this.a.w;
                            com.baidu.tieba.a.al alVar = (com.baidu.tieba.a.al) d.get((int) j);
                            this.a.x = alVar;
                            this.a.a(alVar);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 1:
                o = this.a.o();
                this.a.ai = o;
                aVar = this.a.af;
                String str3 = (String) aVar.getItem(1);
                if (str3 == null || !str3.equals(this.a.getString(R.string.remove_mark))) {
                    this.a.aj = true;
                } else {
                    this.a.aj = false;
                }
                PbActivity pbActivity = this.a;
                z = this.a.aj;
                pbActivity.a(o, z);
                return;
            case 2:
                this.a.s();
                return;
            default:
                return;
        }
    }
}
