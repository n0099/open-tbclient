package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.b.q qVar;
        com.baidu.tieba.b.q qVar2;
        com.baidu.tieba.b.q qVar3;
        qVar = this.a.p;
        if (qVar != null) {
            qVar2 = this.a.p;
            if (qVar2.a() != null) {
                if (TiebaApplication.b().k()) {
                    StatService.onEvent(this.a, "pb_header_forum_name", "pbclick", 1);
                }
                qVar3 = this.a.p;
                com.baidu.tieba.a.q a = qVar3.a().a();
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
