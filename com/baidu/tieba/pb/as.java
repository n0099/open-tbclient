package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.b.r rVar;
        com.baidu.tieba.a.ae o;
        com.baidu.tieba.b.r rVar2;
        com.baidu.tieba.a.ae aeVar;
        com.baidu.tieba.b.r rVar3;
        rVar = this.a.o;
        if (rVar != null) {
            PbActivity pbActivity = this.a;
            o = this.a.o();
            pbActivity.ak = o;
            rVar2 = this.a.o;
            if (!rVar2.n()) {
                if (TiebaApplication.b().l()) {
                    StatService.onEvent(this.a, "pb_collect", "pbclick", 1);
                }
            } else if (TiebaApplication.b().l()) {
                StatService.onEvent(this.a, "pb_cancel_collect", "pbclick", 1);
            }
            PbActivity pbActivity2 = this.a;
            aeVar = this.a.ak;
            rVar3 = this.a.o;
            pbActivity2.a(aeVar, rVar3.n() ? false : true);
        }
    }
}
