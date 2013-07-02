package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.ap;
import com.baidu.tieba.util.ab;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask {
    final /* synthetic */ h a;
    private com.baidu.tieba.util.r b = null;
    private String c;
    private ArrayList d;
    private e e;

    public p(h hVar, String str, ArrayList arrayList, e eVar) {
        this.a = hVar;
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
    public ap a(Object... objArr) {
        ap apVar;
        Exception e;
        com.baidu.tieba.g gVar;
        int i;
        n nVar;
        try {
            this.b = new com.baidu.tieba.util.r(this.c);
            this.b.a(this.d);
            com.baidu.tieba.util.r rVar = this.b;
            gVar = this.a.b;
            rVar.a(gVar);
            String j = this.b.j();
            if (!this.b.c() || j == null) {
                return null;
            }
            apVar = new ap();
            try {
                apVar.a(j);
                if (apVar.a()) {
                    i = this.a.o;
                    if (i != 4) {
                        nVar = this.a.j;
                        nVar.a(j);
                        return apVar;
                    }
                    return apVar;
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.z.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return apVar;
            }
        } catch (Exception e3) {
            apVar = null;
            e = e3;
        }
    }

    private void a(boolean z) {
        int i;
        ProgressBar progressBar;
        int i2;
        ProgressBar progressBar2;
        if (z) {
            i2 = this.a.o;
            switch (i2) {
                case 1:
                case 2:
                case 3:
                    progressBar2 = this.a.l;
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
        i = this.a.o;
        switch (i) {
            case 1:
            case 2:
            case 3:
                progressBar = this.a.l;
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
    public void a(ap apVar) {
        com.baidu.tieba.g gVar;
        a(false);
        if (this.b != null) {
            if (!this.b.d() || apVar == null) {
                gVar = this.a.b;
                Activity parent = gVar.getParent();
                if (parent != null && (parent instanceof MentionActivity)) {
                    ab.a((Context) ((MentionActivity) parent), this.b.g());
                }
            } else {
                this.a.a(apVar);
            }
        }
        this.a.k = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        a(false);
        this.a.k = null;
        super.cancel(true);
    }
}
