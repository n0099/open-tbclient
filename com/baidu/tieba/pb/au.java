package com.baidu.tieba.pb;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.R;
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
        com.baidu.tieba.b.q qVar;
        ca caVar;
        a aVar;
        a aVar2;
        AlertDialog alertDialog2;
        com.baidu.tieba.b.q qVar2;
        com.baidu.tieba.b.q qVar3;
        a aVar3;
        com.baidu.tieba.b.q qVar4;
        com.baidu.tieba.b.q qVar5;
        String str;
        com.baidu.tieba.b.q qVar6;
        com.baidu.tieba.b.q qVar7;
        com.baidu.tieba.b.q qVar8;
        com.baidu.tieba.a.ac o;
        com.baidu.tieba.b.q qVar9;
        com.baidu.tieba.b.q qVar10;
        com.baidu.tieba.b.q qVar11;
        com.baidu.tieba.b.q qVar12;
        ca caVar2;
        ca caVar3;
        boolean z = true;
        this.a.w = -1L;
        if (j != -3) {
            if (j == -1) {
                caVar3 = this.a.n;
                if (caVar3.h()) {
                    return;
                }
                this.a.w();
            } else if (j != -2) {
                alertDialog = this.a.e;
                if (alertDialog != null) {
                    this.a.w = j;
                    qVar = this.a.p;
                    if (qVar.a() != null) {
                        caVar = this.a.n;
                        com.baidu.tieba.a.al alVar = (com.baidu.tieba.a.al) caVar.getItem(i);
                        if (alVar != null) {
                            qVar4 = this.a.p;
                            if (qVar4.a().i() && alVar.c() != 1) {
                                qVar5 = this.a.p;
                                if (qVar5.j() != null) {
                                    qVar12 = this.a.p;
                                }
                                z = false;
                                Intent intent = new Intent(this.a, SubPbActivity.class);
                                str = this.a.q;
                                intent.putExtra("themeId", str);
                                intent.putExtra("postId", alVar.a());
                                qVar6 = this.a.p;
                                intent.putExtra("fid", qVar6.a().a().b());
                                qVar7 = this.a.p;
                                intent.putExtra("kw", qVar7.a().a().c());
                                qVar8 = this.a.p;
                                intent.putExtra("threadId", qVar8.a().b().a());
                                o = this.a.o();
                                intent.putExtra("mark", o);
                                intent.putExtra("isMarked", z);
                                qVar9 = this.a.p;
                                intent.putExtra("anti", qVar9.a().f());
                                qVar10 = this.a.p;
                                intent.putExtra("manage_mode", qVar10.i());
                                qVar11 = this.a.p;
                                intent.putExtra("user_identity", qVar11.a().j());
                                this.a.startActivityForResult(intent, 1300004);
                                return;
                            }
                        }
                        if (alVar != null) {
                            qVar2 = this.a.p;
                            if (qVar2.j() != null) {
                                qVar3 = this.a.p;
                                if (qVar3.j().equals(alVar.a())) {
                                    aVar3 = this.a.af;
                                    aVar3.a(1, this.a.getString(R.string.remove_mark));
                                    aVar2 = this.a.af;
                                    aVar2.notifyDataSetInvalidated();
                                    alertDialog2 = this.a.e;
                                    alertDialog2.show();
                                }
                            }
                        }
                        aVar = this.a.af;
                        aVar.a(1, this.a.getString(R.string.add_mark));
                        aVar2 = this.a.af;
                        aVar2.notifyDataSetInvalidated();
                        alertDialog2 = this.a.e;
                        alertDialog2.show();
                    }
                }
            } else {
                caVar2 = this.a.n;
                if (caVar2.g()) {
                    return;
                }
                this.a.v();
            }
        }
    }
}
