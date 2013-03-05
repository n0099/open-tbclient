package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class br implements AdapterView.OnItemClickListener {
    final /* synthetic */ bq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bq bqVar) {
        this.a = bqVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        PbActivity pbActivity;
        b bVar;
        PbActivity pbActivity2;
        com.baidu.tieba.b.q qVar;
        PbActivity pbActivity3;
        com.baidu.tieba.b.q qVar2;
        PbActivity pbActivity4;
        com.baidu.tieba.b.q qVar3;
        PbActivity pbActivity5;
        com.baidu.tieba.b.q qVar4;
        PbActivity pbActivity6;
        PbActivity pbActivity7;
        PbActivity pbActivity8;
        com.baidu.tieba.b.q qVar5;
        PbActivity pbActivity9;
        PbActivity pbActivity10;
        PbActivity pbActivity11;
        PbActivity pbActivity12;
        AlertDialog alertDialog;
        PbActivity pbActivity13;
        boolean z;
        PbActivity pbActivity14;
        PbActivity pbActivity15;
        pbActivity = this.a.a;
        bVar = pbActivity.ae;
        long itemId = bVar.getItemId(i);
        if (itemId == 0) {
            if (TiebaApplication.b().k()) {
                pbActivity15 = this.a.a;
                StatService.onEvent(pbActivity15, "pb_skip_page", "pbclick", 1);
            }
            pbActivity13 = this.a.a;
            z = pbActivity13.ao;
            if (z) {
                pbActivity14 = this.a.a;
                pbActivity14.t();
            }
        } else if (itemId == 1) {
            pbActivity8 = this.a.a;
            qVar5 = pbActivity8.p;
            if (!qVar5.c()) {
                pbActivity9 = this.a.a;
                pbActivity9.A();
            } else {
                if (TiebaApplication.b().k()) {
                    pbActivity11 = this.a.a;
                    StatService.onEvent(pbActivity11, "pb_set_desc", "pbclick", 1);
                }
                pbActivity10 = this.a.a;
                pbActivity10.z();
            }
        } else if (itemId == 2) {
            pbActivity2 = this.a.a;
            qVar = pbActivity2.p;
            if (qVar != null) {
                pbActivity3 = this.a.a;
                qVar2 = pbActivity3.p;
                if (qVar2.a() != null) {
                    pbActivity4 = this.a.a;
                    qVar3 = pbActivity4.p;
                    if (qVar3.a().j() != 0) {
                        pbActivity5 = this.a.a;
                        qVar4 = pbActivity5.p;
                        if (qVar4.i()) {
                            pbActivity7 = this.a.a;
                            pbActivity7.C();
                        } else {
                            pbActivity6 = this.a.a;
                            pbActivity6.B();
                        }
                    }
                }
            }
        }
        pbActivity12 = this.a.a;
        alertDialog = pbActivity12.y;
        alertDialog.dismiss();
    }
}
