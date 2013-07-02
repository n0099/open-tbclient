package com.baidu.tieba.mention;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.aj;
import com.baidu.tieba.data.an;
import com.baidu.tieba.data.aw;
import com.baidu.tieba.model.bp;
import com.baidu.tieba.write.WriteActivity;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask {
    ArrayList a;
    final /* synthetic */ h b;
    private com.baidu.tieba.util.r c = null;
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
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        super.b();
        progressBar = this.b.l;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public String a(Object... objArr) {
        try {
            this.c = new com.baidu.tieba.util.r(this.d);
            this.c.a(this.a);
            return this.c.j();
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        ProgressBar progressBar;
        com.baidu.tieba.g gVar;
        com.baidu.tieba.g gVar2;
        com.baidu.tieba.g gVar3;
        com.baidu.tieba.g gVar4;
        try {
            progressBar = this.b.l;
            progressBar.setVisibility(8);
            if (this.c != null && this.c.c()) {
                if (this.f == 1) {
                    aj ajVar = new aj();
                    ajVar.b(str);
                    an anVar = (an) ajVar.d().get(0);
                    if (anVar != null) {
                        gVar4 = this.b.b;
                        WriteActivity.a(gVar4, ajVar.a().a(), ajVar.a().b(), ajVar.b().a(), anVar.d(), anVar.f(), this.e, ajVar.f(), ajVar.k());
                    } else {
                        return;
                    }
                }
                if (this.f == 2) {
                    gVar2 = this.b.b;
                    aw a = new bp(gVar2, str).a();
                    String a2 = a.g().a();
                    String b = a.g().b();
                    String a3 = a.l().a();
                    AntiData h = a.h();
                    String d = a.a().d();
                    int f = a.a().f();
                    gVar3 = this.b.b;
                    WriteActivity.a(gVar3, a2, b, a3, d, f, this.e, h, true);
                }
            } else if (this.c != null) {
                gVar = this.b.b;
                gVar.a(this.c.g());
            }
        } catch (Exception e) {
        }
        this.b.m = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.h();
        }
        progressBar = this.b.l;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
