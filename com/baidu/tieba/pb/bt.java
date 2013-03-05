package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.b.q qVar;
        com.baidu.tieba.b.q qVar2;
        qVar = this.a.p;
        if (qVar.a() != null) {
            if (TiebaApplication.b().k()) {
                StatService.onEvent(this.a, "pb_set_host", "pbclick", 1);
            }
            qVar2 = this.a.p;
            if (!qVar2.d()) {
                this.a.x();
            } else {
                this.a.y();
            }
        }
    }
}
