package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ad f1885a;
    private com.baidu.tieba.util.ap b = null;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
    private int h;
    private boolean i;

    public ae(ad adVar, String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        this.f1885a = adVar;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = i;
        this.h = i2;
        this.i = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String str;
        String str2 = com.baidu.tieba.data.h.f1196a;
        if (this.g == 0) {
            str = str2 + "c/c/bawu/delthread";
        } else {
            str = str2 + "c/c/bawu/delpost";
        }
        this.b = new com.baidu.tieba.util.ap(str);
        this.b.a("fid", this.c);
        this.b.a("word", this.d);
        this.b.a("z", this.e);
        if (this.g == 0) {
            if (this.h == 0) {
                this.b.a("delete_my_thread", SocialConstants.TRUE);
            }
        } else if (this.g == 1) {
            this.b.a("pid", this.f);
            this.b.a("isfloor", SocialConstants.FALSE);
            this.b.a("src", SocialConstants.TRUE);
            if (this.h == 0 && this.i) {
                this.b.a("delete_my_post", SocialConstants.TRUE);
            }
        } else if (this.g == 2) {
            this.b.a("pid", this.f);
            this.b.a("isfloor", SocialConstants.TRUE);
            this.b.a("src", "3");
            if (this.h == 0 && this.i) {
                this.b.a("delete_my_post", SocialConstants.TRUE);
            }
        }
        if (this.h == 0 && !this.i) {
            this.b.a("is_vipdel", SocialConstants.TRUE);
        } else {
            this.b.a("is_vipdel", SocialConstants.FALSE);
        }
        this.b.e(true);
        this.b.j();
        if (this.b.c()) {
            return null;
        }
        return this.b.g();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        com.baidu.adp.a.g gVar;
        if (this.b != null) {
            this.b.h();
        }
        this.f1885a.f1884a = null;
        super.cancel(true);
        gVar = this.f1885a.mLoadDataCallBack;
        gVar.a(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        super.a((ae) str);
        this.f1885a.f1884a = null;
        if (this.b == null) {
            gVar2 = this.f1885a.mLoadDataCallBack;
            gVar2.a(null);
            return;
        }
        af afVar = new af(this.f1885a);
        afVar.c = this.g;
        afVar.d = this.f;
        afVar.b = str;
        if (str == null) {
            afVar.f1886a = true;
        } else {
            afVar.f1886a = false;
        }
        gVar = this.f1885a.mLoadDataCallBack;
        gVar.a(afVar);
    }
}
