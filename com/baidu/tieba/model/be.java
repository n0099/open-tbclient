package com.baidu.tieba.model;

import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.a.h f1346a = null;
    int b;
    final /* synthetic */ bc c;

    public be(bc bcVar, int i) {
        this.c = bcVar;
        this.b = 3;
        this.b = i;
        setSelfExecute(true);
        bcVar.setErrorString(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        com.baidu.tieba.data.as asVar;
        com.baidu.tieba.data.as asVar2;
        com.baidu.tieba.data.as asVar3;
        bd bdVar;
        bd bdVar2;
        com.baidu.tieba.data.as asVar4;
        boolean z = false;
        super.b();
        this.c.y = System.nanoTime();
        asVar = this.c.t;
        ArrayList c = asVar.c();
        if (this.b == 1) {
            boolean z2 = false;
            while (c.size() + 30 > com.baidu.tieba.data.g.b()) {
                c.remove(0);
                z2 = true;
            }
            if (z2) {
                asVar3 = this.c.t;
                asVar3.d().f(1);
                bdVar = this.c.x;
                if (bdVar != null) {
                    bdVar2 = this.c.x;
                    asVar4 = this.c.t;
                    bdVar2.a(asVar4);
                }
            }
        } else if (this.b == 2) {
            while (c.size() + 30 > com.baidu.tieba.data.g.b()) {
                c.remove(c.size() - 1);
                z = true;
            }
            if (z) {
                asVar2 = this.c.t;
                asVar2.d().e(1);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public com.baidu.tieba.data.as a(Object... objArr) {
        com.baidu.tieba.data.as asVar;
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
        com.baidu.tieba.data.at atVar;
        com.baidu.tieba.data.as asVar2;
        com.baidu.tieba.data.at atVar2;
        com.baidu.tieba.data.at atVar3;
        long j2;
        com.baidu.tieba.data.at atVar4;
        com.baidu.tieba.data.at atVar5;
        Context context;
        int i5;
        int i6;
        long j3;
        Context context2;
        try {
            asVar = this.c.t;
            ArrayList c = asVar.c();
            switch (this.b) {
                case 1:
                    this.c.d = ((com.baidu.tieba.data.aw) c.get(c.size() - 1)).d();
                    break;
                case 2:
                    this.c.d = ((com.baidu.tieba.data.aw) c.get(0)).d();
                    break;
            }
            this.f1346a = new com.baidu.tieba.a.h();
            com.baidu.tieba.a.h hVar = this.f1346a;
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
            atVar = bc.v;
            String a2 = hVar.a(str, str2, str3, i, i2, z, z2, i7, i3, i4, z3, j, z4, atVar);
            if (this.f1346a.b()) {
                com.baidu.tieba.data.as asVar3 = new com.baidu.tieba.data.as();
                context = this.c.w;
                asVar3.a(a2, context);
                com.baidu.tieba.data.bm b = asVar3.b();
                i5 = this.c.g;
                b.b(i5);
                i6 = this.c.h;
                b.a(i6);
                j3 = this.c.i;
                b.a(j3);
                for (int i8 = 0; i8 < asVar3.c().size(); i8++) {
                    com.baidu.tieba.data.aw awVar = (com.baidu.tieba.data.aw) asVar3.c().get(i8);
                    for (int i9 = 0; i9 < awVar.a().size(); i9++) {
                        context2 = this.c.w;
                        ((com.baidu.tieba.data.aw) awVar.a().get(i9)).a(context2);
                    }
                }
                asVar2 = asVar3;
            } else {
                this.c.setErrorString(this.f1346a.e());
                this.c.setErrorCode(this.f1346a.f());
                asVar2 = null;
            }
            if (this.f1346a.c()) {
                atVar3 = bc.v;
                atVar3.a();
                long nanoTime = System.nanoTime();
                j2 = this.c.y;
                atVar4 = bc.v;
                atVar4.a((int) ((nanoTime - j2) / 1000000));
                atVar5 = bc.v;
                atVar5.b(this.f1346a.d());
                return asVar2;
            }
            atVar2 = bc.v;
            atVar2.c(1);
            return asVar2;
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b("PbAsyncTask", "doInBackground", "error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.data.as asVar) {
        int i;
        com.baidu.tieba.data.as asVar2;
        int size;
        com.baidu.tieba.data.as asVar3;
        com.baidu.tieba.data.as asVar4;
        boolean z;
        bd bdVar;
        bd bdVar2;
        com.baidu.tieba.data.as asVar5;
        String str;
        bd bdVar3;
        bd bdVar4;
        String str2;
        this.c.u = null;
        if (asVar != null) {
            this.c.s = false;
            this.c.e(asVar.d().d());
            this.c.m = asVar.d().a();
            bc bcVar = this.c;
            i = this.c.m;
            bcVar.m = i < 1 ? 1 : this.c.m;
            asVar2 = this.c.t;
            ArrayList c = asVar2.c();
            switch (this.b) {
                case 1:
                    asVar4 = this.c.t;
                    asVar4.a(asVar.d(), 1);
                    c.addAll(asVar.c());
                    size = 0;
                    break;
                case 2:
                    size = asVar.c().size() + 1;
                    asVar3 = this.c.t;
                    asVar3.a(asVar.d(), 2);
                    c.addAll(0, asVar.c());
                    break;
                case 3:
                    z = this.c.f;
                    if (!z) {
                        asVar.d().c(asVar.d().a());
                    }
                    b(asVar);
                    size = 0;
                    break;
                case 4:
                    b(asVar);
                    size = 0;
                    break;
                case 5:
                    b(asVar);
                    size = 0;
                    break;
                case 6:
                    b(asVar);
                    size = 0;
                    break;
                default:
                    size = 0;
                    break;
            }
            bdVar = this.c.x;
            if (bdVar != null) {
                bdVar2 = this.c.x;
                int errorCode = this.c.getErrorCode();
                int i2 = this.b;
                asVar5 = this.c.t;
                str = this.c.mErrorString;
                bdVar2.a(true, errorCode, i2, size, asVar5, str);
                return;
            }
            return;
        }
        bdVar3 = this.c.x;
        if (bdVar3 != null) {
            bdVar4 = this.c.x;
            int errorCode2 = this.c.getErrorCode();
            int i3 = this.b;
            str2 = this.c.mErrorString;
            bdVar4.a(false, errorCode2, i3, 0, null, str2);
        }
    }

    private void b(com.baidu.tieba.data.as asVar) {
        this.c.t = asVar;
        this.c.d(asVar.d().d());
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        bd bdVar;
        bd bdVar2;
        super.cancel(true);
        this.c.setErrorString(null);
        if (this.f1346a != null) {
            this.f1346a.a();
        }
        bdVar = this.c.x;
        if (bdVar != null) {
            bdVar2 = this.c.x;
            bdVar2.a(false, this.c.getErrorCode(), this.b, 0, null, null);
        }
        this.c.u = null;
    }
}
