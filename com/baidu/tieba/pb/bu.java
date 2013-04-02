package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.b.r rVar;
        com.baidu.tieba.b.r rVar2;
        rVar = this.a.o;
        if (rVar.a() != null) {
            if (TiebaApplication.b().l()) {
                StatService.onEvent(this.a, "pb_set_host", "pbclick", 1);
            }
            rVar2 = this.a.o;
            if (!rVar2.d()) {
                this.a.y();
            } else {
                this.a.z();
            }
        }
    }
}
