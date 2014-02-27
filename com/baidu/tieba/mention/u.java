package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.am;
import com.baidu.tieba.data.aq;
import com.baidu.tieba.data.av;
import com.baidu.tieba.model.bv;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.write.WriteActivity;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u extends BdAsyncTask<Object, Integer, String> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ l b;
    private ba c;
    private String d;
    private String e;
    private int f;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(Object... objArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        String str2 = str;
        try {
            if (this.c != null && this.c.c()) {
                if (this.f == 1) {
                    am amVar = new am();
                    amVar.b(str2);
                    aq aqVar = amVar.e().get(0);
                    if (aqVar == null) {
                        return;
                    }
                    activity4 = this.b.c;
                    WriteActivity.a(activity4, amVar.c().getId(), amVar.c().getName(), amVar.d().a(), aqVar.d(), aqVar.e(), this.e, amVar.g(), amVar.k());
                }
                if (this.f == 2) {
                    activity2 = this.b.c;
                    av a = new bv(activity2, str2).a();
                    String id = a.g().getId();
                    String name = a.g().getName();
                    String a2 = a.l().a();
                    AntiData h = a.h();
                    String d = a.a().d();
                    int e = a.a().e();
                    activity3 = this.b.c;
                    WriteActivity.a(activity3, id, name, a2, d, e, this.e, h, true);
                }
            } else if (this.c != null) {
                activity = this.b.c;
                BdUtilHelper.a((Context) activity, this.c.i());
            }
        } catch (Exception e2) {
        }
        this.b.l = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        super.b();
    }

    private String d() {
        try {
            this.c = new ba(this.d);
            this.c.a(this.a);
            return this.c.l();
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        if (this.c != null) {
            this.c.j();
        }
        super.cancel(true);
    }
}
