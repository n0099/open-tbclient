package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class bs implements AdapterView.OnItemClickListener {
    final /* synthetic */ br a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(br brVar) {
        this.a = brVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        PbActivity pbActivity;
        b bVar;
        PbActivity pbActivity2;
        com.baidu.tieba.b.r rVar;
        PbActivity pbActivity3;
        PbActivity pbActivity4;
        com.baidu.tieba.b.r rVar2;
        PbActivity pbActivity5;
        com.baidu.tieba.b.r rVar3;
        PbActivity pbActivity6;
        com.baidu.tieba.b.r rVar4;
        PbActivity pbActivity7;
        com.baidu.tieba.b.r rVar5;
        PbActivity pbActivity8;
        PbActivity pbActivity9;
        PbActivity pbActivity10;
        com.baidu.tieba.b.r rVar6;
        PbActivity pbActivity11;
        PbActivity pbActivity12;
        PbActivity pbActivity13;
        PbActivity pbActivity14;
        AlertDialog alertDialog;
        PbActivity pbActivity15;
        boolean z;
        PbActivity pbActivity16;
        PbActivity pbActivity17;
        pbActivity = this.a.a;
        bVar = pbActivity.ag;
        long itemId = bVar.getItemId(i);
        if (itemId == 1) {
            if (TiebaApplication.b().l()) {
                pbActivity17 = this.a.a;
                StatService.onEvent(pbActivity17, "pb_skip_page", "pbclick", 1);
            }
            pbActivity15 = this.a.a;
            z = pbActivity15.ap;
            if (z) {
                pbActivity16 = this.a.a;
                pbActivity16.u();
            }
        } else if (itemId == 2) {
            pbActivity10 = this.a.a;
            rVar6 = pbActivity10.o;
            if (!rVar6.c()) {
                pbActivity11 = this.a.a;
                pbActivity11.B();
            } else {
                if (TiebaApplication.b().l()) {
                    pbActivity13 = this.a.a;
                    StatService.onEvent(pbActivity13, "pb_set_desc", "pbclick", 1);
                }
                pbActivity12 = this.a.a;
                pbActivity12.A();
            }
        } else if (itemId == 3) {
            pbActivity4 = this.a.a;
            rVar2 = pbActivity4.o;
            if (rVar2 != null) {
                pbActivity5 = this.a.a;
                rVar3 = pbActivity5.o;
                if (rVar3.a() != null) {
                    pbActivity6 = this.a.a;
                    rVar4 = pbActivity6.o;
                    if (rVar4.a().l() != 0) {
                        pbActivity7 = this.a.a;
                        rVar5 = pbActivity7.o;
                        if (rVar5.i()) {
                            pbActivity9 = this.a.a;
                            pbActivity9.D();
                        } else {
                            pbActivity8 = this.a.a;
                            pbActivity8.C();
                        }
                    }
                }
            }
        } else if (itemId == 0) {
            pbActivity2 = this.a.a;
            rVar = pbActivity2.o;
            if (rVar != null) {
                pbActivity3 = this.a.a;
                pbActivity3.t();
            }
        }
        pbActivity14 = this.a.a;
        alertDialog = pbActivity14.x;
        alertDialog.dismiss();
    }
}
