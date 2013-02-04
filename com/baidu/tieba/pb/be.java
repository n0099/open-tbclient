package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.b.n nVar;
        com.baidu.tieba.b.n nVar2;
        com.baidu.tieba.b.n nVar3;
        nVar = this.a.n;
        if (nVar != null) {
            nVar2 = this.a.n;
            if (nVar2.a() != null) {
                nVar3 = this.a.n;
                com.baidu.tieba.a.p a = nVar3.a().a();
                if (a == null || a.c() == null) {
                    return;
                }
                String stringExtra = this.a.getIntent().getStringExtra("st_type");
                if (stringExtra == null || !stringExtra.equals("tb_frslist")) {
                    FrsActivity.a(this.a, a.c(), (String) null);
                } else {
                    this.a.g();
                }
            }
        }
    }
}
