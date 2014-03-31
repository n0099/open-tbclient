package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends BdAsyncTask<Object, h, h> {
    final /* synthetic */ BarFolderFirstDirActivity a;
    private com.baidu.tbadk.core.util.ak b;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ h a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(h hVar) {
        h hVar2 = hVar;
        if (hVar2 != null) {
            this.a.a(hVar2, false);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void b(h... hVarArr) {
        h[] hVarArr2 = hVarArr;
        super.b((Object[]) hVarArr2);
        this.a.a(hVarArr2[0], false);
    }

    private b(BarFolderFirstDirActivity barFolderFirstDirActivity) {
        this.a = barFolderFirstDirActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(BarFolderFirstDirActivity barFolderFirstDirActivity, byte b) {
        this(barFolderFirstDirActivity);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(3:21|22|(8:24|4|5|(1:7)|8|(2:10|(1:(1:13))(1:17))(1:18)|15|16))|3|4|5|(0)|8|(0)(0)|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ba, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00bb, code lost:
        r1.a(r0.getMessage());
        com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", r0.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0074 A[Catch: Exception -> 0x00ba, TryCatch #0 {Exception -> 0x00ba, blocks: (B:7:0x002d, B:9:0x0051, B:10:0x005e, B:12:0x0074, B:19:0x00a6, B:21:0x00b0), top: B:25:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b0 A[Catch: Exception -> 0x00ba, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ba, blocks: (B:7:0x002d, B:9:0x0051, B:10:0x005e, B:12:0x0074, B:19:0x00a6, B:21:0x00b0), top: B:25:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0051 A[Catch: Exception -> 0x00ba, TryCatch #0 {Exception -> 0x00ba, blocks: (B:7:0x002d, B:9:0x0051, B:10:0x005e, B:12:0x0074, B:19:0x00a6, B:21:0x00b0), top: B:25:0x002d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private h a() {
        String str;
        String str2;
        boolean z = true;
        h hVar = new h();
        com.baidu.adp.lib.cache.s<String> p = com.baidu.tbadk.core.c.b.a().p();
        String a = p.a("first_dir_cache_key");
        if (a != null) {
            if (!a.equals("")) {
                hVar.b(a);
                c((Object[]) new h[]{hVar});
                this.b = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/f/forum/forumdir");
                str = this.a.g;
                if (str != null) {
                    com.baidu.tbadk.core.util.ak akVar = this.b;
                    String str3 = BarFolderFirstDirActivity.c;
                    str2 = this.a.g;
                    akVar.a(str3, str2);
                }
                String i = this.b.i();
                if (!this.b.a().b().b()) {
                    hVar.b(i);
                    if (new StringBuilder(String.valueOf(i)).toString().trim().equals(new StringBuilder(String.valueOf(a)).toString().trim())) {
                        if (z) {
                            return null;
                        }
                    } else {
                        p.a("first_dir_cache_key", i, 86400000L);
                    }
                } else {
                    hVar.a(this.b.f());
                }
                return hVar;
            }
        }
        z = false;
        this.b = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/f/forum/forumdir");
        str = this.a.g;
        if (str != null) {
        }
        String i2 = this.b.i();
        if (!this.b.a().b().b()) {
        }
        return hVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.a((h) null, true);
    }
}
