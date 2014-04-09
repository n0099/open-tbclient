package com.baidu.tieba.model;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends BdAsyncTask<String, Integer, bb> {
    com.baidu.tbadk.core.util.ak a;
    final /* synthetic */ a b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ bb a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(bb bbVar) {
        bb bbVar2 = bbVar;
        super.a((b) bbVar2);
        this.b.b = null;
        this.b.a.a(bbVar2);
    }

    private b(a aVar) {
        this.b = aVar;
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(a aVar, byte b) {
        this(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        super.c();
    }

    private bb a() {
        bb bbVar;
        Exception e;
        Context unused;
        try {
            this.a = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/s/sync");
            this.a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            com.baidu.tieba.p.c();
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.i.b(com.baidu.tieba.p.d())));
            stringBuffer.append(",");
            com.baidu.tieba.p.c();
            stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.i.c(com.baidu.tieba.p.d())));
            this.a.a("_phone_screen", stringBuffer.toString());
            if (TbadkApplication.j().ai() > 0) {
                this.a.a("_msg_status", "0");
            } else {
                this.a.a("_msg_status", "1");
            }
            String i = this.a.i();
            if (!this.a.a().b().b()) {
                return null;
            }
            bbVar = new bb();
            try {
                bbVar.a(i);
                if (TbadkApplication.B() == null && bbVar.d().a() != null && bbVar.d().a().length() > 0) {
                    unused = this.b.c;
                    TbadkApplication.b(bbVar.d().a());
                    TbadkApplication.c(bbVar.d().a());
                    return bbVar;
                }
                return bbVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
                return bbVar;
            }
        } catch (Exception e3) {
            bbVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        this.b.b = null;
        if (this.a != null) {
            this.a.g();
        }
        super.cancel(true);
    }
}
