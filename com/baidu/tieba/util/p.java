package com.baidu.tieba.util;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p extends BdAsyncTask<Object, Integer, String> {
    final /* synthetic */ o a;
    private ba b = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/p/updata");
    private int c;
    private int d;
    private String e;
    private String f;
    private int g;
    private int h;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(Object... objArr) {
        if (this.a.b() == null || !this.a.b().a() || this.g == 0) {
            return null;
        }
        this.b.a("number", new StringBuilder(String.valueOf(this.h)).toString());
        if (this.g == 1) {
            this.b.a("ab_num_error", new StringBuilder(String.valueOf(this.c)).toString());
            this.b.a("error", this.e);
            this.b.a("ab_num_slow", new StringBuilder(String.valueOf(this.d)).toString());
            this.b.a("time", this.f);
        } else if (this.g == 3) {
            this.b.a("ab_num_slow", new StringBuilder(String.valueOf(this.d)).toString());
            this.b.a("time", this.f);
        } else if (this.g == 2) {
            this.b.a("ab_num_error", new StringBuilder(String.valueOf(this.c)).toString());
            this.b.a("error", this.e);
        }
        return this.b.l();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        String str2 = str;
        super.a((p) str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) != 0) {
                return;
            }
            String optString = jSONObject.optString("photo_strategy");
            com.baidu.tieba.data.c cVar = new com.baidu.tieba.data.c();
            cVar.a(optString);
            if (cVar.a() == this.a.b().a() && cVar.e() == this.a.b().e() && cVar.c() == this.a.b().c() && cVar.d() == this.a.b().d()) {
                return;
            }
            this.a.a(cVar);
        } catch (Exception e) {
            com.baidu.tieba.data.c cVar2 = new com.baidu.tieba.data.c();
            cVar2.a(false);
            this.a.a(cVar2);
            com.baidu.adp.lib.util.e.b("CDNLogger", "onPostExecute", e.getMessage());
        }
    }

    public p(o oVar, int i, int i2, int i3, String str, int i4, String str2) {
        this.a = oVar;
        this.c = i3;
        this.d = i4;
        this.e = str;
        this.f = str2;
        this.g = i;
        this.h = i2;
    }
}
