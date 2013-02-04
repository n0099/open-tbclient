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
        com.baidu.tieba.b.n nVar;
        bt btVar;
        a aVar;
        a aVar2;
        AlertDialog alertDialog2;
        com.baidu.tieba.b.n nVar2;
        com.baidu.tieba.b.n nVar3;
        a aVar3;
        com.baidu.tieba.b.n nVar4;
        com.baidu.tieba.b.n nVar5;
        String str;
        com.baidu.tieba.b.n nVar6;
        com.baidu.tieba.b.n nVar7;
        com.baidu.tieba.b.n nVar8;
        com.baidu.tieba.a.ae l;
        com.baidu.tieba.b.n nVar9;
        com.baidu.tieba.b.n nVar10;
        com.baidu.tieba.b.n nVar11;
        com.baidu.tieba.b.n nVar12;
        bt btVar2;
        bt btVar3;
        boolean z = true;
        this.a.t = -1L;
        if (j == -3) {
            return;
        }
        if (j == -1) {
            btVar3 = this.a.l;
            if (btVar3.h()) {
                return;
            }
            this.a.q();
        } else if (j == -2) {
            btVar2 = this.a.l;
            if (btVar2.g()) {
                return;
            }
            this.a.p();
        } else {
            alertDialog = this.a.d;
            if (alertDialog != null) {
                this.a.t = j;
                nVar = this.a.n;
                if (nVar.a() != null) {
                    btVar = this.a.l;
                    com.baidu.tieba.a.am amVar = (com.baidu.tieba.a.am) btVar.getItem(i);
                    if (amVar != null) {
                        nVar4 = this.a.n;
                        if (nVar4.a().f() && amVar.b() != 1) {
                            nVar5 = this.a.n;
                            if (nVar5.j() != null) {
                                nVar12 = this.a.n;
                            }
                            z = false;
                            Intent intent = new Intent(this.a, SubPbActivity.class);
                            str = this.a.o;
                            intent.putExtra("themeId", str);
                            intent.putExtra("postId", amVar.a());
                            nVar6 = this.a.n;
                            intent.putExtra("fid", nVar6.a().a().b());
                            nVar7 = this.a.n;
                            intent.putExtra("kw", nVar7.a().a().c());
                            nVar8 = this.a.n;
                            intent.putExtra("threadId", nVar8.a().b().a());
                            l = this.a.l();
                            intent.putExtra("mark", l);
                            intent.putExtra("isMarked", z);
                            nVar9 = this.a.n;
                            intent.putExtra("anti", nVar9.a().e());
                            nVar10 = this.a.n;
                            intent.putExtra("manage_mode", nVar10.i());
                            nVar11 = this.a.n;
                            intent.putExtra("user_identity", nVar11.a().g());
                            this.a.startActivityForResult(intent, 1300004);
                            return;
                        }
                    }
                    if (amVar != null) {
                        nVar2 = this.a.n;
                        if (nVar2.j() != null) {
                            nVar3 = this.a.n;
                            if (nVar3.j().equals(amVar.a())) {
                                aVar3 = this.a.ac;
                                aVar3.a(1, this.a.getString(R.string.remove_mark));
                                aVar2 = this.a.ac;
                                aVar2.notifyDataSetInvalidated();
                                alertDialog2 = this.a.d;
                                alertDialog2.show();
                            }
                        }
                    }
                    aVar = this.a.ac;
                    aVar.a(1, this.a.getString(R.string.add_mark));
                    aVar2 = this.a.ac;
                    aVar2.notifyDataSetInvalidated();
                    alertDialog2 = this.a.d;
                    alertDialog2.show();
                }
            }
        }
    }
}
