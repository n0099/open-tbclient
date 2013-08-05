package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.ay;
import com.baidu.tieba.util.aj;
import com.baidu.tieba.util.am;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1306a;
    private com.baidu.tieba.util.u b = null;
    private String c;
    private ArrayList d;
    private e e;

    public p(h hVar, String str, ArrayList arrayList, e eVar) {
        this.f1306a = hVar;
        this.c = null;
        this.d = null;
        this.e = null;
        this.c = str;
        this.d = arrayList;
        this.e = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        a(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public ay a(Object... objArr) {
        ay ayVar;
        Exception e;
        com.baidu.tieba.g gVar;
        int i;
        n nVar;
        try {
            this.b = new com.baidu.tieba.util.u(this.c);
            this.b.a(this.d);
            com.baidu.tieba.util.u uVar = this.b;
            gVar = this.f1306a.b;
            uVar.a(gVar);
            String k = this.b.k();
            if (!this.b.d() || k == null) {
                return null;
            }
            ayVar = new ay();
            try {
                ayVar.a(k);
                if (ayVar.a()) {
                    i = this.f1306a.o;
                    if (i != 4) {
                        nVar = this.f1306a.j;
                        nVar.a(k);
                        return ayVar;
                    }
                    return ayVar;
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                aj.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return ayVar;
            }
        } catch (Exception e3) {
            ayVar = null;
            e = e3;
        }
    }

    private void a(boolean z) {
        int i;
        ProgressBar progressBar;
        int i2;
        ProgressBar progressBar2;
        if (z) {
            i2 = this.f1306a.o;
            switch (i2) {
                case 1:
                case 2:
                case 3:
                    progressBar2 = this.f1306a.l;
                    progressBar2.setVisibility(0);
                    return;
                case 4:
                    this.e.c(true);
                    this.e.notifyDataSetChanged();
                    return;
                default:
                    return;
            }
        }
        i = this.f1306a.o;
        switch (i) {
            case 1:
            case 2:
            case 3:
                progressBar = this.f1306a.l;
                progressBar.setVisibility(8);
                return;
            case 4:
                this.e.c(false);
                this.e.notifyDataSetChanged();
                return;
            default:
                return;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ay ayVar) {
        com.baidu.tieba.g gVar;
        a(false);
        if (this.b != null) {
            if (!this.b.e() || ayVar == null) {
                gVar = this.f1306a.b;
                Activity parent = gVar.getParent();
                if (parent != null && (parent instanceof MentionActivity)) {
                    am.a((Context) ((MentionActivity) parent), this.b.h());
                }
            } else {
                this.f1306a.a(ayVar);
            }
        }
        this.f1306a.k = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.i();
        }
        a(false);
        this.f1306a.k = null;
        super.cancel(true);
    }
}
