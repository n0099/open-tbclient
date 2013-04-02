package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements AdapterView.OnItemClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0098, code lost:
        if (r2.j().equals(r0.a()) != false) goto L33;
     */
    @Override // android.widget.AdapterView.OnItemClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        AlertDialog alertDialog;
        com.baidu.tieba.b.r rVar;
        cd cdVar;
        a aVar;
        AlertDialog alertDialog2;
        com.baidu.tieba.b.r rVar2;
        com.baidu.tieba.b.r rVar3;
        com.baidu.tieba.b.r rVar4;
        com.baidu.tieba.b.r rVar5;
        com.baidu.tieba.b.r rVar6;
        com.baidu.tieba.b.r rVar7;
        com.baidu.tieba.b.r rVar8;
        com.baidu.tieba.b.r rVar9;
        com.baidu.tieba.b.r rVar10;
        cd cdVar2;
        cd cdVar3;
        boolean z = true;
        this.a.v = -1L;
        if (j != -3) {
            if (j == -1) {
                cdVar3 = this.a.m;
                if (cdVar3.h()) {
                    return;
                }
                this.a.x();
            } else if (j != -2) {
                alertDialog = this.a.e;
                if (alertDialog != null) {
                    this.a.v = j;
                    rVar = this.a.o;
                    if (rVar.a() != null) {
                        cdVar = this.a.m;
                        com.baidu.tieba.a.an anVar = (com.baidu.tieba.a.an) cdVar.getItem(i);
                        if (anVar != null) {
                            rVar2 = this.a.o;
                            if (rVar2.a().k() && anVar.c() != 1) {
                                rVar3 = this.a.o;
                                if (rVar3.j() != null) {
                                    rVar10 = this.a.o;
                                }
                                z = false;
                                Intent intent = new Intent(this.a, SubPbActivity.class);
                                intent.putExtra("postId", anVar.a());
                                rVar4 = this.a.o;
                                intent.putExtra("fid", rVar4.a().a().b());
                                rVar5 = this.a.o;
                                intent.putExtra("kw", rVar5.a().a().c());
                                rVar6 = this.a.o;
                                intent.putExtra("threadId", rVar6.a().b().a());
                                intent.putExtra("isMarked", z);
                                rVar7 = this.a.o;
                                intent.putExtra("anti", rVar7.a().f());
                                rVar8 = this.a.o;
                                intent.putExtra("manage_mode", rVar8.i());
                                rVar9 = this.a.o;
                                intent.putExtra("user_identity", rVar9.a().l());
                                this.a.startActivityForResult(intent, 1300004);
                                return;
                            }
                        }
                        aVar = this.a.ah;
                        aVar.notifyDataSetInvalidated();
                        alertDialog2 = this.a.e;
                        alertDialog2.show();
                    }
                }
            } else {
                cdVar2 = this.a.m;
                if (cdVar2.g()) {
                    return;
                }
                this.a.w();
            }
        }
    }
}
