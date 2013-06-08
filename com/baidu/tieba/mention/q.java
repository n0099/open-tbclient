package com.baidu.tieba.mention;

import android.widget.ProgressBar;
import com.baidu.tieba.a.am;
import com.baidu.tieba.a.ar;
import com.baidu.tieba.a.ay;
import com.baidu.tieba.c.bp;
import com.baidu.tieba.d.ae;
import com.baidu.tieba.write.WriteActivity;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.lib.a.a {
    ArrayList a;
    final /* synthetic */ h b;
    private com.baidu.tieba.d.t c = null;
    private String d;
    private String e;
    private int f;

    public q(h hVar, String str, ArrayList arrayList, int i, String str2) {
        this.b = hVar;
        this.d = null;
        this.e = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
        this.f = i;
        this.e = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        ProgressBar progressBar;
        super.b();
        progressBar = this.b.l;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public String a(Object... objArr) {
        try {
            this.c = new com.baidu.tieba.d.t(this.d);
            this.c.a(this.a);
            return this.c.i();
        } catch (Exception e) {
            ae.b("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(String str) {
        ProgressBar progressBar;
        com.baidu.tieba.e eVar;
        com.baidu.tieba.e eVar2;
        com.baidu.tieba.e eVar3;
        com.baidu.tieba.e eVar4;
        try {
            progressBar = this.b.l;
            progressBar.setVisibility(8);
            if (this.c != null && this.c.b()) {
                if (this.f == 1) {
                    am amVar = new am();
                    amVar.b(str);
                    ar arVar = (ar) amVar.d().get(0);
                    if (arVar != null) {
                        eVar4 = this.b.b;
                        WriteActivity.a(eVar4, amVar.a().a(), amVar.a().b(), amVar.b().a(), arVar.d(), arVar.f(), this.e, amVar.f(), amVar.k());
                    } else {
                        return;
                    }
                }
                if (this.f == 2) {
                    eVar2 = this.b.b;
                    ay a = new bp(eVar2, str).a();
                    String a2 = a.g().a();
                    String b = a.g().b();
                    String a3 = a.l().a();
                    com.baidu.tieba.a.b h = a.h();
                    String d = a.a().d();
                    int f = a.a().f();
                    eVar3 = this.b.b;
                    WriteActivity.a(eVar3, a2, b, a3, d, f, this.e, h, true);
                }
            } else if (this.c != null) {
                eVar = this.b.b;
                eVar.a(this.c.f());
            }
        } catch (Exception e) {
        }
        this.b.m = null;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.g();
        }
        progressBar = this.b.l;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
