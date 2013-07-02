package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends BdAsyncTask {
    com.baidu.tieba.a.e a = null;
    int b;
    final /* synthetic */ ax c;

    public az(ax axVar, int i) {
        this.c = axVar;
        this.b = 3;
        this.b = i;
        setSelfExecute(true);
        axVar.setErrorString(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.data.aj ajVar;
        com.baidu.tieba.data.aj ajVar2;
        com.baidu.tieba.data.aj ajVar3;
        ay ayVar;
        ay ayVar2;
        com.baidu.tieba.data.aj ajVar4;
        boolean z = false;
        super.b();
        this.c.y = System.nanoTime();
        ajVar = this.c.t;
        ArrayList d = ajVar.d();
        if (this.b == 1) {
            boolean z2 = false;
            while (d.size() + 30 > com.baidu.tieba.data.g.b()) {
                d.remove(0);
                z2 = true;
            }
            if (z2) {
                ajVar3 = this.c.t;
                ajVar3.e().f(1);
                ayVar = this.c.x;
                if (ayVar != null) {
                    ayVar2 = this.c.x;
                    ajVar4 = this.c.t;
                    ayVar2.a(ajVar4);
                }
            }
        } else if (this.b == 2) {
            while (d.size() + 30 > com.baidu.tieba.data.g.b()) {
                d.remove(d.size() - 1);
                z = true;
            }
            if (z) {
                ajVar2 = this.c.t;
                ajVar2.e().e(1);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.aj a(Object... objArr) {
        com.baidu.tieba.data.aj ajVar;
        String str;
        String str2;
        String str3;
        int i;
        int i2;
        boolean z;
        boolean z2;
        int i3;
        int i4;
        boolean z3;
        long j;
        boolean z4;
        com.baidu.tieba.data.ak akVar;
        com.baidu.tieba.data.aj ajVar2;
        com.baidu.tieba.data.ak akVar2;
        com.baidu.tieba.data.ak akVar3;
        long j2;
        com.baidu.tieba.data.ak akVar4;
        com.baidu.tieba.data.ak akVar5;
        Context context;
        int i5;
        int i6;
        long j3;
        Context context2;
        try {
            ajVar = this.c.t;
            ArrayList d = ajVar.d();
            switch (this.b) {
                case 1:
                    this.c.d = ((com.baidu.tieba.data.an) d.get(d.size() - 1)).d();
                    break;
                case 2:
                    this.c.d = ((com.baidu.tieba.data.an) d.get(0)).d();
                    break;
            }
            this.a = new com.baidu.tieba.a.e();
            com.baidu.tieba.a.e eVar = this.a;
            str = this.c.c;
            str2 = this.c.b;
            str3 = this.c.d;
            i = this.c.l;
            i2 = this.c.k;
            z = this.c.f;
            z2 = this.c.e;
            int i7 = this.b;
            i3 = this.c.j;
            i4 = this.c.m;
            z3 = this.c.s;
            j = this.c.r;
            z4 = this.c.q;
            akVar = ax.v;
            String a = eVar.a(str, str2, str3, i, i2, z, z2, i7, i3, i4, z3, j, z4, akVar);
            if (this.a.b()) {
                com.baidu.tieba.data.aj ajVar3 = new com.baidu.tieba.data.aj();
                context = this.c.w;
                ajVar3.a(a, context);
                com.baidu.tieba.data.ba b = ajVar3.b();
                i5 = this.c.g;
                b.b(i5);
                i6 = this.c.h;
                b.a(i6);
                j3 = this.c.i;
                b.a(j3);
                for (int i8 = 0; i8 < ajVar3.d().size(); i8++) {
                    com.baidu.tieba.data.an anVar = (com.baidu.tieba.data.an) ajVar3.d().get(i8);
                    for (int i9 = 0; i9 < anVar.a().size(); i9++) {
                        context2 = this.c.w;
                        ((com.baidu.tieba.data.an) anVar.a().get(i9)).a(context2);
                    }
                }
                ajVar2 = ajVar3;
            } else {
                this.c.setErrorString(this.a.e());
                this.c.setErrorCode(this.a.f());
                ajVar2 = null;
            }
            if (this.a.c()) {
                akVar3 = ax.v;
                akVar3.a();
                long nanoTime = System.nanoTime();
                j2 = this.c.y;
                akVar4 = ax.v;
                akVar4.a((int) ((nanoTime - j2) / 1000000));
                akVar5 = ax.v;
                akVar5.b(this.a.d());
                return ajVar2;
            }
            akVar2 = ax.v;
            akVar2.c(1);
            return ajVar2;
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("PbAsyncTask", "doInBackground", "error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.aj ajVar) {
        int i;
        com.baidu.tieba.data.aj ajVar2;
        int size;
        com.baidu.tieba.data.aj ajVar3;
        com.baidu.tieba.data.aj ajVar4;
        boolean z;
        ay ayVar;
        ay ayVar2;
        com.baidu.tieba.data.aj ajVar5;
        String str;
        ay ayVar3;
        ay ayVar4;
        String str2;
        this.c.u = null;
        if (ajVar != null) {
            this.c.s = false;
            this.c.e(ajVar.e().d());
            this.c.m = ajVar.e().a();
            ax axVar = this.c;
            i = this.c.m;
            axVar.m = i < 1 ? 1 : this.c.m;
            ajVar2 = this.c.t;
            ArrayList d = ajVar2.d();
            switch (this.b) {
                case 1:
                    ajVar4 = this.c.t;
                    ajVar4.a(ajVar.e(), 1);
                    d.addAll(ajVar.d());
                    size = 0;
                    break;
                case 2:
                    size = ajVar.d().size() + 1;
                    ajVar3 = this.c.t;
                    ajVar3.a(ajVar.e(), 2);
                    d.addAll(0, ajVar.d());
                    break;
                case 3:
                    z = this.c.f;
                    if (!z) {
                        ajVar.e().c(ajVar.e().a());
                    }
                case 4:
                case 5:
                case 6:
                    this.c.t = ajVar;
                    this.c.d(ajVar.e().d());
                    size = 0;
                    break;
                default:
                    size = 0;
                    break;
            }
            ayVar = this.c.x;
            if (ayVar != null) {
                ayVar2 = this.c.x;
                int errorCode = this.c.getErrorCode();
                int i2 = this.b;
                ajVar5 = this.c.t;
                str = this.c.mErrorString;
                ayVar2.a(true, errorCode, i2, size, ajVar5, str);
                return;
            }
            return;
        }
        ayVar3 = this.c.x;
        if (ayVar3 != null) {
            ayVar4 = this.c.x;
            int errorCode2 = this.c.getErrorCode();
            int i3 = this.b;
            str2 = this.c.mErrorString;
            ayVar4.a(false, errorCode2, i3, 0, null, str2);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ay ayVar;
        ay ayVar2;
        super.cancel(true);
        this.c.setErrorString(null);
        if (this.a != null) {
            this.a.a();
        }
        ayVar = this.c.x;
        if (ayVar != null) {
            ayVar2 = this.c.x;
            ayVar2.a(false, this.c.getErrorCode(), this.b, 0, null, null);
        }
        this.c.u = null;
    }
}
