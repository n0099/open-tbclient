package com.baidu.tieba.model;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<String, Integer, ce> {

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.util.z f1412a;
    final /* synthetic */ a b;

    private b(a aVar) {
        this.b = aVar;
        this.f1412a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(a aVar, b bVar) {
        this(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ce a(String... strArr) {
        ce ceVar;
        Exception e;
        Context context;
        try {
            this.f1412a = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/s/sync");
            this.f1412a.a("_os_version", Build.VERSION.RELEASE);
            StringBuffer stringBuffer = new StringBuffer(15);
            stringBuffer.append(String.valueOf(UtilHelper.a(TiebaApplication.g())));
            stringBuffer.append(",");
            stringBuffer.append(String.valueOf(UtilHelper.b(TiebaApplication.g())));
            this.f1412a.a("_phone_screen", stringBuffer.toString());
            if (TiebaApplication.g().Q() > 0) {
                this.f1412a.a("_msg_status", "0");
            } else {
                this.f1412a.a("_msg_status", "1");
            }
            String j = this.f1412a.j();
            if (!this.f1412a.c()) {
                return null;
            }
            ceVar = new ce();
            try {
                ceVar.a(j);
                if (TiebaApplication.O() == null && ceVar.d().a() != null && ceVar.d().a().length() > 0) {
                    context = this.b.c;
                    TiebaApplication.a(context, ceVar.d().a());
                    TiebaApplication.n(ceVar.d().a());
                    return ceVar;
                }
                return ceVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.av.b(getClass().getName(), "doInBackground", e.getMessage());
                return ceVar;
            }
        } catch (Exception e3) {
            ceVar = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.b = null;
        if (this.f1412a != null) {
            this.f1412a.h();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ce ceVar) {
        super.a((b) ceVar);
        this.b.b = null;
        this.b.f1387a.a(ceVar);
    }
}
