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
        com.baidu.tieba.b.p pVar;
        com.baidu.tieba.b.p pVar2;
        long j;
        long j2;
        com.baidu.tieba.b.p pVar3;
        com.baidu.tieba.b.p pVar4;
        long j3;
        com.baidu.tieba.a.af o;
        a aVar;
        boolean z;
        String str;
        String str2;
        com.baidu.tieba.b.p pVar5;
        com.baidu.tieba.b.p pVar6;
        long j4;
        switch (i) {
            case 0:
                str = this.a.p;
                if (str != null) {
                    str2 = this.a.p;
                    if (str2.length() > 0) {
                        pVar5 = this.a.o;
                        if (pVar5.a() != null) {
                            pVar6 = this.a.o;
                            ArrayList c = pVar6.a().c();
                            j4 = this.a.v;
                            com.baidu.tieba.a.an anVar = (com.baidu.tieba.a.an) c.get((int) j4);
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
                o = this.a.o();
                this.a.ah = o;
                aVar = this.a.ae;
                String str3 = (String) aVar.getItem(1);
                if (str3 == null || !str3.equals(this.a.getString(R.string.remove_mark))) {
                    this.a.ai = true;
                } else {
                    this.a.ai = false;
                }
                PbActivity pbActivity = this.a;
                z = this.a.ai;
                pbActivity.a(o, z);
                return;
            case 2:
                pVar = this.a.o;
                if (pVar != null) {
                    pVar2 = this.a.o;
                    if (pVar2.a() != null) {
                        j = this.a.v;
                        if (j >= 0) {
                            j2 = this.a.v;
                            pVar3 = this.a.o;
                            if (j2 < pVar3.a().c().size()) {
                                pVar4 = this.a.o;
                                ArrayList c2 = pVar4.a().c();
                                j3 = this.a.v;
                                com.baidu.tieba.a.an anVar2 = (com.baidu.tieba.a.an) c2.get((int) j3);
                                if (anVar2.d() != null) {
                                    if (anVar2.d().a() != null && anVar2.d().a().equalsIgnoreCase("0")) {
                                        this.a.b(this.a.getString(R.string.invalid_user));
                                        return;
                                    } else {
                                        PersonInfoActivity.a(this.a, anVar2.d().a(), anVar2.d().b());
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
