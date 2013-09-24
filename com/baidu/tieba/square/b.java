package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Object, g, g> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BarFolderFirstDirActivity f1836a;
    private com.baidu.tieba.util.z b;

    private b(BarFolderFirstDirActivity barFolderFirstDirActivity) {
        this.f1836a = barFolderFirstDirActivity;
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
    public void b(g... gVarArr) {
        super.b((Object[]) gVarArr);
        this.f1836a.a(gVarArr[0], false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(3:18|19|(6:21|4|5|(2:7|(1:(1:10))(1:14))(1:15)|12|13))|3|4|5|(0)(0)|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009d, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x009e, code lost:
        r1.a(r0.getMessage());
        com.baidu.tieba.util.av.b(getClass().getName(), "doInBackground", r0.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0093 A[Catch: Exception -> 0x009d, TRY_LEAVE, TryCatch #0 {Exception -> 0x009d, blocks: (B:7:0x002d, B:9:0x0057, B:16:0x0089, B:18:0x0093), top: B:23:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0057 A[Catch: Exception -> 0x009d, TryCatch #0 {Exception -> 0x009d, blocks: (B:7:0x002d, B:9:0x0057, B:16:0x0089, B:18:0x0093), top: B:23:0x002d }] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public g a(Object... objArr) {
        boolean z = true;
        g gVar = new g();
        com.baidu.adp.lib.cache.q<String> k = com.baidu.tieba.b.a.a().k();
        String a2 = k.a("first_dir_cache_key");
        if (a2 != null) {
            try {
            } catch (Exception e) {
                z = false;
            }
            if (!a2.equals("")) {
                gVar.b(a2);
                c((Object[]) new g[]{gVar});
                this.b = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/f/forum/forumdir");
                String j = this.b.j();
                if (!this.b.c()) {
                    gVar.b(j);
                    if (new StringBuilder(String.valueOf(j)).toString().trim().equals(new StringBuilder(String.valueOf(a2)).toString().trim())) {
                        if (z) {
                            return null;
                        }
                    } else {
                        k.a("first_dir_cache_key", j, Util.MILLSECONDS_OF_DAY);
                    }
                } else {
                    gVar.a(this.b.g());
                }
                return gVar;
            }
        }
        z = false;
        this.b = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/f/forum/forumdir");
        String j2 = this.b.j();
        if (!this.b.c()) {
        }
        return gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(g gVar) {
        if (gVar != null) {
            this.f1836a.a(gVar, false);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f1836a.a((g) null, true);
    }
}
