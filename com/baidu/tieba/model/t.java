package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ s a;
    private com.baidu.tieba.util.ba b = null;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
    private int h;
    private boolean i;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        String str = com.baidu.tieba.data.i.a;
        this.b = new com.baidu.tieba.util.ba(this.g == 0 ? String.valueOf(str) + "c/c/bawu/delthread" : String.valueOf(str) + "c/c/bawu/delpost");
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
        if (this.h != 0 || this.i) {
            this.b.a("is_vipdel", SocialConstants.FALSE);
        } else {
            this.b.a("is_vipdel", SocialConstants.TRUE);
        }
        this.b.e(true);
        this.b.l();
        if (this.b.c()) {
            return null;
        }
        return this.b.i();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        String str2 = str;
        super.a((t) str2);
        this.a.a = null;
        if (this.b == null) {
            gVar2 = this.a.mLoadDataCallBack;
            gVar2.a(null);
            return;
        }
        u uVar = new u(this.a);
        uVar.c = this.g;
        uVar.d = this.f;
        uVar.b = str2;
        if (str2 == null) {
            uVar.a = true;
        } else {
            uVar.a = false;
        }
        gVar = this.a.mLoadDataCallBack;
        gVar.a(uVar);
    }

    public t(s sVar, String str, String str2, String str3, String str4, int i, int i2, boolean z) {
        this.a = sVar;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = i;
        this.h = i2;
        this.i = z;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        com.baidu.adp.a.g gVar;
        if (this.b != null) {
            this.b.j();
        }
        this.a.a = null;
        super.cancel(true);
        gVar = this.a.mLoadDataCallBack;
        gVar.a(null);
    }
}
