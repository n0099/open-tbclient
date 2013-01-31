package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.b.p pVar;
        com.baidu.tieba.b.p pVar2;
        com.baidu.tieba.b.p pVar3;
        pVar = this.a.o;
        if (pVar != null) {
            pVar2 = this.a.o;
            if (pVar2.a() != null) {
                if (TiebaApplication.b().k()) {
                    StatService.onEvent(this.a, "pb_header_forum_name", "pbclick", 1);
                }
                pVar3 = this.a.o;
                com.baidu.tieba.a.q a = pVar3.a().a();
                if (a != null && a.c() != null) {
                    String stringExtra = this.a.getIntent().getStringExtra("st_type");
                    if (stringExtra != null && stringExtra.equals("tb_frslist")) {
                        this.a.a();
                    } else {
                        FrsActivity.a(this.a, a.c(), (String) null);
                    }
                }
            }
        }
    }
}
