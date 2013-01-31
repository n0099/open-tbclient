package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements AdapterView.OnItemClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(PbActivity pbActivity) {
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
        com.baidu.tieba.b.p pVar;
        bv bvVar;
        a aVar;
        a aVar2;
        AlertDialog alertDialog2;
        com.baidu.tieba.b.p pVar2;
        com.baidu.tieba.b.p pVar3;
        a aVar3;
        com.baidu.tieba.b.p pVar4;
        com.baidu.tieba.b.p pVar5;
        String str;
        com.baidu.tieba.b.p pVar6;
        com.baidu.tieba.b.p pVar7;
        com.baidu.tieba.b.p pVar8;
        com.baidu.tieba.a.af o;
        com.baidu.tieba.b.p pVar9;
        com.baidu.tieba.b.p pVar10;
        com.baidu.tieba.b.p pVar11;
        com.baidu.tieba.b.p pVar12;
        bv bvVar2;
        bv bvVar3;
        boolean z = true;
        this.a.v = -1L;
        if (j != -3) {
            if (j == -1) {
                bvVar3 = this.a.m;
                if (bvVar3.h()) {
                    return;
                }
                this.a.v();
            } else if (j != -2) {
                alertDialog = this.a.e;
                if (alertDialog != null) {
                    this.a.v = j;
                    pVar = this.a.o;
                    if (pVar.a() != null) {
                        bvVar = this.a.m;
                        com.baidu.tieba.a.an anVar = (com.baidu.tieba.a.an) bvVar.getItem(i);
                        if (anVar != null) {
                            pVar4 = this.a.o;
                            if (pVar4.a().f() && anVar.b() != 1) {
                                pVar5 = this.a.o;
                                if (pVar5.j() != null) {
                                    pVar12 = this.a.o;
                                }
                                z = false;
                                Intent intent = new Intent(this.a, SubPbActivity.class);
                                str = this.a.p;
                                intent.putExtra("themeId", str);
                                intent.putExtra("postId", anVar.a());
                                pVar6 = this.a.o;
                                intent.putExtra("fid", pVar6.a().a().b());
                                pVar7 = this.a.o;
                                intent.putExtra("kw", pVar7.a().a().c());
                                pVar8 = this.a.o;
                                intent.putExtra("threadId", pVar8.a().b().a());
                                o = this.a.o();
                                intent.putExtra("mark", o);
                                intent.putExtra("isMarked", z);
                                pVar9 = this.a.o;
                                intent.putExtra("anti", pVar9.a().e());
                                pVar10 = this.a.o;
                                intent.putExtra("manage_mode", pVar10.i());
                                pVar11 = this.a.o;
                                intent.putExtra("user_identity", pVar11.a().g());
                                this.a.startActivityForResult(intent, 1300004);
                                return;
                            }
                        }
                        if (anVar != null) {
                            pVar2 = this.a.o;
                            if (pVar2.j() != null) {
                                pVar3 = this.a.o;
                                if (pVar3.j().equals(anVar.a())) {
                                    aVar3 = this.a.ae;
                                    aVar3.a(1, this.a.getString(R.string.remove_mark));
                                    aVar2 = this.a.ae;
                                    aVar2.notifyDataSetInvalidated();
                                    alertDialog2 = this.a.e;
                                    alertDialog2.show();
                                }
                            }
                        }
                        aVar = this.a.ae;
                        aVar.a(1, this.a.getString(R.string.add_mark));
                        aVar2 = this.a.ae;
                        aVar2.notifyDataSetInvalidated();
                        alertDialog2 = this.a.e;
                        alertDialog2.show();
                    }
                }
            } else {
                bvVar2 = this.a.m;
                if (bvVar2.g()) {
                    return;
                }
                this.a.u();
            }
        }
    }
}
