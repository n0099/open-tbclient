package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.b.r rVar;
        com.baidu.tieba.b.r rVar2;
        com.baidu.tieba.b.r rVar3;
        rVar = this.a.o;
        if (rVar != null) {
            rVar2 = this.a.o;
            if (rVar2.a() != null) {
                if (TiebaApplication.b().l()) {
                    StatService.onEvent(this.a, "pb_header_forum_name", "pbclick", 1);
                }
                rVar3 = this.a.o;
                com.baidu.tieba.a.q a = rVar3.a().a();
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
