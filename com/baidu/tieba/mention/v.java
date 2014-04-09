package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.Context;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.b.av;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.data.ai;
import com.baidu.tieba.data.am;
import com.baidu.tieba.model.an;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v extends BdAsyncTask<Object, Integer, String> {
    ArrayList<BasicNameValuePair> a;
    final /* synthetic */ m b;
    private ak c;
    private String d;
    private String e;
    private final int f;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ String a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        Activity activity5;
        Activity activity6;
        Activity activity7;
        Activity activity8;
        Activity activity9;
        Activity activity10;
        String str2 = str;
        try {
            if (this.c != null && this.c.a().b().b()) {
                if (this.f == 1) {
                    com.baidu.tieba.data.ae aeVar = new com.baidu.tieba.data.ae();
                    aeVar.b(str2);
                    ai aiVar = aeVar.e().get(0);
                    if (aiVar == null) {
                        return;
                    }
                    if (aiVar.d() != null) {
                        if (aeVar.g() == null || aeVar.g().getIfpost() != 0) {
                            activity9 = this.b.c;
                            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new av(activity9, 2, aeVar.c().getId(), aeVar.c().getName(), aeVar.d().l(), aiVar.d(), aiVar.e(), aeVar.g(), 13001, false, aeVar.k(), this.e, false, false, null, null, null)));
                        } else {
                            activity10 = this.b.c;
                            com.baidu.adp.lib.util.i.a((Context) activity10, aeVar.g().getForbid_info());
                            return;
                        }
                    } else if (aeVar.g() == null || aeVar.g().getIfpost() != 0) {
                        activity7 = this.b.c;
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new av(activity7, 1, aeVar.c().getId(), aeVar.c().getName(), aeVar.d().l(), null, aiVar.e(), aeVar.g(), 13002, false, aeVar.k(), this.e, false, false, null, null, null)));
                    } else {
                        activity8 = this.b.c;
                        com.baidu.adp.lib.util.i.a((Context) activity8, aeVar.g().getForbid_info());
                        return;
                    }
                }
                if (this.f == 2) {
                    activity2 = this.b.c;
                    am a = new an(activity2, str2).a();
                    String id = a.g().getId();
                    String name = a.g().getName();
                    String l = a.l().l();
                    AntiData h = a.h();
                    String d = a.a().d();
                    int e = a.a().e();
                    if (d != null) {
                        if (h == null || h.getIfpost() != 0) {
                            activity5 = this.b.c;
                            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new av(activity5, 2, id, name, l, d, e, h, 13001, false, true, this.e, false, false, null, null, null)));
                        } else {
                            activity6 = this.b.c;
                            com.baidu.adp.lib.util.i.a((Context) activity6, h.getForbid_info());
                            return;
                        }
                    } else if (h == null || h.getIfpost() != 0) {
                        activity3 = this.b.c;
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new av(activity3, 1, id, name, l, null, e, h, 13002, false, true, this.e, false, false, null, null, null)));
                    } else {
                        activity4 = this.b.c;
                        com.baidu.adp.lib.util.i.a((Context) activity4, h.getForbid_info());
                        return;
                    }
                }
            } else if (this.c != null) {
                activity = this.b.c;
                com.baidu.adp.lib.util.i.a((Context) activity, this.c.f());
            }
        } catch (Exception e2) {
        }
        this.b.l = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        super.c();
    }

    private String a() {
        try {
            this.c = new ak(this.d);
            this.c.a(this.a);
            return this.c.i();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("PostAsyncTask", "doInBackground", "error = " + e.getMessage());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        if (this.c != null) {
            this.c.g();
        }
        super.cancel(true);
    }
}
