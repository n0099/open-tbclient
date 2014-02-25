package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Object, h, h> {
    final /* synthetic */ BarFolderFirstDirActivity a;
    private com.baidu.tieba.util.ba b;

    private b(BarFolderFirstDirActivity barFolderFirstDirActivity) {
        this.a = barFolderFirstDirActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(BarFolderFirstDirActivity barFolderFirstDirActivity, b bVar) {
        this(barFolderFirstDirActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(h... hVarArr) {
        super.b((Object[]) hVarArr);
        this.a.a(hVarArr[0], false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(3:21|22|(8:24|4|5|(1:7)|8|(2:10|(1:(1:13))(1:17))(1:18)|15|16))|3|4|5|(0)|8|(0)(0)|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b2, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b3, code lost:
        r1.a(r0.getMessage());
        com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", r0.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x006c A[Catch: Exception -> 0x00b2, TryCatch #1 {Exception -> 0x00b2, blocks: (B:7:0x002d, B:9:0x0051, B:10:0x005e, B:12:0x006c, B:19:0x009e, B:21:0x00a8), top: B:27:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a8 A[Catch: Exception -> 0x00b2, TRY_LEAVE, TryCatch #1 {Exception -> 0x00b2, blocks: (B:7:0x002d, B:9:0x0051, B:10:0x005e, B:12:0x006c, B:19:0x009e, B:21:0x00a8), top: B:27:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0051 A[Catch: Exception -> 0x00b2, TryCatch #1 {Exception -> 0x00b2, blocks: (B:7:0x002d, B:9:0x0051, B:10:0x005e, B:12:0x006c, B:19:0x009e, B:21:0x00a8), top: B:27:0x002d }] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h a(Object... objArr) {
        String str;
        String str2;
        boolean z = true;
        h hVar = new h();
        com.baidu.adp.lib.cache.s<String> p = com.baidu.tieba.c.a.a().p();
        String a = p.a("first_dir_cache_key");
        if (a != null) {
            if (!a.equals("")) {
                hVar.b(a);
                c((Object[]) new h[]{hVar});
                this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/f/forum/forumdir");
                str = this.a.g;
                if (str != null) {
                    com.baidu.tieba.util.ba baVar = this.b;
                    String str3 = BarFolderFirstDirActivity.c;
                    str2 = this.a.g;
                    baVar.a(str3, str2);
                }
                String m = this.b.m();
                if (!this.b.d()) {
                    hVar.b(m);
                    if (new StringBuilder(String.valueOf(m)).toString().trim().equals(new StringBuilder(String.valueOf(a)).toString().trim())) {
                        if (z) {
                            return null;
                        }
                    } else {
                        p.a("first_dir_cache_key", m, 86400000L);
                    }
                } else {
                    hVar.a(this.b.j());
                }
                return hVar;
            }
        }
        z = false;
        this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/f/forum/forumdir");
        str = this.a.g;
        if (str != null) {
        }
        String m2 = this.b.m();
        if (!this.b.d()) {
        }
        return hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(h hVar) {
        if (hVar != null) {
            this.a.a(hVar, false);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.k();
            this.b = null;
        }
        this.a.a((h) null, true);
    }
}
