package com.baidu.tieba.pb;

import android.content.DialogInterface;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonInfoActivity;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ax implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.b.n nVar;
        com.baidu.tieba.b.n nVar2;
        long j;
        long j2;
        com.baidu.tieba.b.n nVar3;
        com.baidu.tieba.b.n nVar4;
        long j3;
        com.baidu.tieba.a.ae l;
        a aVar;
        boolean z;
        String str;
        String str2;
        com.baidu.tieba.b.n nVar5;
        com.baidu.tieba.b.n nVar6;
        long j4;
        switch (i) {
            case 0:
                str = this.a.o;
                if (str != null) {
                    str2 = this.a.o;
                    if (str2.length() > 0) {
                        nVar5 = this.a.n;
                        if (nVar5.a() != null) {
                            nVar6 = this.a.n;
                            ArrayList c = nVar6.a().c();
                            j4 = this.a.t;
                            com.baidu.tieba.a.am amVar = (com.baidu.tieba.a.am) c.get((int) j4);
                            this.a.u = amVar;
                            this.a.a(amVar);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 1:
                l = this.a.l();
                this.a.af = l;
                aVar = this.a.ac;
                String str3 = (String) aVar.getItem(1);
                if (str3 == null || !str3.equals(this.a.getString(R.string.remove_mark))) {
                    this.a.ag = true;
                } else {
                    this.a.ag = false;
                }
                PbActivity pbActivity = this.a;
                z = this.a.ag;
                pbActivity.a(l, z);
                return;
            case 2:
                nVar = this.a.n;
                if (nVar != null) {
                    nVar2 = this.a.n;
                    if (nVar2.a() != null) {
                        j = this.a.t;
                        if (j >= 0) {
                            j2 = this.a.t;
                            nVar3 = this.a.n;
                            if (j2 < nVar3.a().c().size()) {
                                nVar4 = this.a.n;
                                ArrayList c2 = nVar4.a().c();
                                j3 = this.a.t;
                                com.baidu.tieba.a.am amVar2 = (com.baidu.tieba.a.am) c2.get((int) j3);
                                if (amVar2.d() != null) {
                                    if (amVar2.d().a() == null || !amVar2.d().a().equalsIgnoreCase("0")) {
                                        PersonInfoActivity.a(this.a, amVar2.d().a(), amVar2.d().b());
                                        return;
                                    } else {
                                        this.a.b(this.a.getString(R.string.invalid_user));
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
