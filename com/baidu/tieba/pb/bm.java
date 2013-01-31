package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class bm implements AdapterView.OnItemClickListener {
    final /* synthetic */ bl a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bl blVar) {
        this.a = blVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        PbActivity pbActivity;
        b bVar;
        PbActivity pbActivity2;
        com.baidu.tieba.b.p pVar;
        PbActivity pbActivity3;
        com.baidu.tieba.b.p pVar2;
        PbActivity pbActivity4;
        com.baidu.tieba.b.p pVar3;
        PbActivity pbActivity5;
        com.baidu.tieba.b.p pVar4;
        PbActivity pbActivity6;
        PbActivity pbActivity7;
        PbActivity pbActivity8;
        com.baidu.tieba.b.p pVar5;
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
        bVar = pbActivity.ad;
        long itemId = bVar.getItemId(i);
        if (itemId == 0) {
            if (TiebaApplication.b().k()) {
                pbActivity15 = this.a.a;
                StatService.onEvent(pbActivity15, "pb_skip_page", "pbclick", 1);
            }
            pbActivity13 = this.a.a;
            z = pbActivity13.an;
            if (z) {
                pbActivity14 = this.a.a;
                pbActivity14.s();
            }
        } else if (itemId == 1) {
            pbActivity8 = this.a.a;
            pVar5 = pbActivity8.o;
            if (!pVar5.c()) {
                pbActivity9 = this.a.a;
                pbActivity9.z();
            } else {
                if (TiebaApplication.b().k()) {
                    pbActivity11 = this.a.a;
                    StatService.onEvent(pbActivity11, "pb_set_desc", "pbclick", 1);
                }
                pbActivity10 = this.a.a;
                pbActivity10.y();
            }
        } else if (itemId == 2) {
            pbActivity2 = this.a.a;
            pVar = pbActivity2.o;
            if (pVar != null) {
                pbActivity3 = this.a.a;
                pVar2 = pbActivity3.o;
                if (pVar2.a() != null) {
                    pbActivity4 = this.a.a;
                    pVar3 = pbActivity4.o;
                    if (pVar3.a().g() != 0) {
                        pbActivity5 = this.a.a;
                        pVar4 = pbActivity5.o;
                        if (pVar4.i()) {
                            pbActivity7 = this.a.a;
                            pbActivity7.B();
                        } else {
                            pbActivity6 = this.a.a;
                            pbActivity6.A();
                        }
                    }
                }
            }
        }
        pbActivity12 = this.a.a;
        alertDialog = pbActivity12.x;
        alertDialog.dismiss();
    }
}
