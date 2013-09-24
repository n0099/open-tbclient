package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ao;
import com.baidu.tieba.data.as;
import com.baidu.tieba.data.bd;
import com.baidu.tieba.model.cc;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.av;
import com.baidu.tieba.write.WriteActivity;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<Object, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<BasicNameValuePair> f1375a;
    final /* synthetic */ i b;
    private com.baidu.tieba.util.z c = null;
    private String d;
    private String e;
    private int f;

    public r(i iVar, String str, ArrayList<BasicNameValuePair> arrayList, int i, String str2) {
        this.b = iVar;
        this.d = null;
        this.e = null;
        this.f1375a = null;
        this.d = str;
        this.f1375a = arrayList;
        this.f = i;
        this.e = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public String a(Object... objArr) {
        try {
            this.c = new com.baidu.tieba.util.z(this.d);
            this.c.a(this.f1375a);
            return this.c.j();
        } catch (Exception e) {
            av.b("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        try {
            if (this.c != null && this.c.c()) {
                if (this.f == 1) {
                    ao aoVar = new ao();
                    aoVar.b(str);
                    as asVar = aoVar.d().get(0);
                    if (asVar != null) {
                        activity4 = this.b.c;
                        WriteActivity.a(activity4, aoVar.b().a(), aoVar.b().b(), aoVar.c().a(), asVar.d(), asVar.e(), this.e, aoVar.f(), aoVar.i());
                    } else {
                        return;
                    }
                }
                if (this.f == 2) {
                    activity2 = this.b.c;
                    bd a2 = new cc(activity2, str).a();
                    String a3 = a2.g().a();
                    String b = a2.g().b();
                    String a4 = a2.l().a();
                    AntiData h = a2.h();
                    String d = a2.a().d();
                    int e = a2.a().e();
                    activity3 = this.b.c;
                    WriteActivity.a(activity3, a3, b, a4, d, e, this.e, h, true);
                }
            } else if (this.c != null) {
                activity = this.b.c;
                UtilHelper.a((Context) activity, this.c.g());
            }
        } catch (Exception e2) {
        }
        this.b.l = null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.c != null) {
            this.c.h();
        }
        super.cancel(true);
    }
}
