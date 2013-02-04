package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class bg implements AdapterView.OnItemClickListener {
    final /* synthetic */ bf a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bf bfVar) {
        this.a = bfVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        PbActivity pbActivity;
        com.baidu.tieba.b.n nVar;
        PbActivity pbActivity2;
        com.baidu.tieba.b.n nVar2;
        PbActivity pbActivity3;
        com.baidu.tieba.b.n nVar3;
        PbActivity pbActivity4;
        com.baidu.tieba.b.n nVar4;
        PbActivity pbActivity5;
        PbActivity pbActivity6;
        PbActivity pbActivity7;
        com.baidu.tieba.b.n nVar5;
        PbActivity pbActivity8;
        PbActivity pbActivity9;
        PbActivity pbActivity10;
        AlertDialog alertDialog;
        PbActivity pbActivity11;
        com.baidu.tieba.b.n nVar6;
        PbActivity pbActivity12;
        PbActivity pbActivity13;
        if (i == 0) {
            pbActivity11 = this.a.a;
            nVar6 = pbActivity11.n;
            if (nVar6.d()) {
                pbActivity13 = this.a.a;
                pbActivity13.s();
            } else {
                pbActivity12 = this.a.a;
                pbActivity12.r();
            }
        } else if (i == 1) {
            pbActivity7 = this.a.a;
            nVar5 = pbActivity7.n;
            if (nVar5.c()) {
                pbActivity9 = this.a.a;
                pbActivity9.t();
            } else {
                pbActivity8 = this.a.a;
                pbActivity8.u();
            }
        } else if (i == 2) {
            pbActivity = this.a.a;
            nVar = pbActivity.n;
            if (nVar != null) {
                pbActivity2 = this.a.a;
                nVar2 = pbActivity2.n;
                if (nVar2.a() != null) {
                    pbActivity3 = this.a.a;
                    nVar3 = pbActivity3.n;
                    if (nVar3.a().g() != 0) {
                        pbActivity4 = this.a.a;
                        nVar4 = pbActivity4.n;
                        if (nVar4.i()) {
                            pbActivity6 = this.a.a;
                            pbActivity6.w();
                        } else {
                            pbActivity5 = this.a.a;
                            pbActivity5.v();
                        }
                    }
                }
            }
        }
        pbActivity10 = this.a.a;
        alertDialog = pbActivity10.v;
        alertDialog.dismiss();
    }
}
