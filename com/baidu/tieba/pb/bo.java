package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements View.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.b.p pVar;
        com.baidu.tieba.b.p pVar2;
        pVar = this.a.o;
        if (pVar.a() != null) {
            if (TiebaApplication.b().k()) {
                StatService.onEvent(this.a, "pb_set_host", "pbclick", 1);
            }
            pVar2 = this.a.o;
            if (!pVar2.d()) {
                this.a.w();
            } else {
                this.a.x();
            }
        }
    }
}
