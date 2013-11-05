package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Object, g, g> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BarFolderFirstDirActivity f2358a;
    private com.baidu.tieba.util.ag b;

    private b(BarFolderFirstDirActivity barFolderFirstDirActivity) {
        this.f2358a = barFolderFirstDirActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(BarFolderFirstDirActivity barFolderFirstDirActivity, a aVar) {
        this(barFolderFirstDirActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void b(g... gVarArr) {
        super.b((Object[]) gVarArr);
        this.f2358a.a(gVarArr[0], false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(3:19|20|(7:22|4|5|6|(2:8|(1:(1:11))(1:15))(1:16)|13|14))|3|4|5|6|(0)(0)|13|14) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a7, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a8, code lost:
        r3.a(r0.getMessage());
        com.baidu.tieba.util.be.b(getClass().getName(), "doInBackground", r0.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0058 A[Catch: Exception -> 0x00a7, TryCatch #0 {Exception -> 0x00a7, blocks: (B:8:0x002e, B:10:0x0058, B:15:0x0093, B:17:0x009d), top: B:24:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x009d A[Catch: Exception -> 0x00a7, TRY_LEAVE, TryCatch #0 {Exception -> 0x00a7, blocks: (B:8:0x002e, B:10:0x0058, B:15:0x0093, B:17:0x009d), top: B:24:0x002e }] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public g a(Object... objArr) {
        boolean z = true;
        boolean z2 = false;
        g gVar = new g();
        com.baidu.adp.lib.cache.s<String> l = com.baidu.tieba.b.a.a().l();
        String a2 = l.a("first_dir_cache_key");
        if (a2 != null) {
            if (!a2.equals("")) {
                gVar.b(a2);
                c((Object[]) new g[]{gVar});
                z2 = z;
                this.b = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/f/forum/forumdir");
                String j = this.b.j();
                if (!this.b.c()) {
                    gVar.b(j);
                    if ((j + "").trim().equals((a2 + "").trim())) {
                        if (z2) {
                            return null;
                        }
                    } else {
                        l.a("first_dir_cache_key", j, Util.MILLSECONDS_OF_DAY);
                    }
                } else {
                    gVar.a(this.b.g());
                }
                return gVar;
            }
        }
        z = false;
        z2 = z;
        this.b = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/f/forum/forumdir");
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
            this.f2358a.a(gVar, false);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f2358a.a((g) null, true);
    }
}
