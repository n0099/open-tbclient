package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Object, h, h> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BarFolderFirstDirActivity f2394a;
    private com.baidu.tieba.util.ap b;

    private b(BarFolderFirstDirActivity barFolderFirstDirActivity) {
        this.f2394a = barFolderFirstDirActivity;
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
    public void b(h... hVarArr) {
        super.b((Object[]) hVarArr);
        this.f2394a.a(hVarArr[0], false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(3:22|23|(9:25|4|5|6|(1:8)|9|(2:11|(1:(1:14))(1:18))(1:19)|16|17))|3|4|5|6|(0)|9|(0)(0)|16|17) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00bc, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00bd, code lost:
        r3.a(r0.getMessage());
        com.baidu.tieba.util.bg.b(getClass().getName(), "doInBackground", r0.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052 A[Catch: Exception -> 0x00bc, TryCatch #0 {Exception -> 0x00bc, blocks: (B:8:0x002e, B:10:0x0052, B:11:0x005f, B:13:0x006d, B:18:0x00a8, B:20:0x00b2), top: B:27:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006d A[Catch: Exception -> 0x00bc, TryCatch #0 {Exception -> 0x00bc, blocks: (B:8:0x002e, B:10:0x0052, B:11:0x005f, B:13:0x006d, B:18:0x00a8, B:20:0x00b2), top: B:27:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b2 A[Catch: Exception -> 0x00bc, TRY_LEAVE, TryCatch #0 {Exception -> 0x00bc, blocks: (B:8:0x002e, B:10:0x0052, B:11:0x005f, B:13:0x006d, B:18:0x00a8, B:20:0x00b2), top: B:27:0x002e }] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h a(Object... objArr) {
        String str;
        String str2;
        boolean z = true;
        boolean z2 = false;
        h hVar = new h();
        com.baidu.adp.lib.cache.s<String> m = com.baidu.tieba.b.a.a().m();
        String a2 = m.a("first_dir_cache_key");
        if (a2 != null) {
            if (!a2.equals("")) {
                hVar.b(a2);
                c((Object[]) new h[]{hVar});
                z2 = z;
                this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1196a + "c/f/forum/forumdir");
                str = this.f2394a.g;
                if (str != null) {
                    com.baidu.tieba.util.ap apVar = this.b;
                    String str3 = BarFolderFirstDirActivity.c;
                    str2 = this.f2394a.g;
                    apVar.a(str3, str2);
                }
                String j = this.b.j();
                if (!this.b.c()) {
                    hVar.b(j);
                    if ((j + "").trim().equals((a2 + "").trim())) {
                        if (z2) {
                            return null;
                        }
                    } else {
                        m.a("first_dir_cache_key", j, Util.MILLSECONDS_OF_DAY);
                    }
                } else {
                    hVar.a(this.b.g());
                }
                return hVar;
            }
        }
        z = false;
        z2 = z;
        this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1196a + "c/f/forum/forumdir");
        str = this.f2394a.g;
        if (str != null) {
        }
        String j2 = this.b.j();
        if (!this.b.c()) {
        }
        return hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(h hVar) {
        if (hVar != null) {
            this.f2394a.a(hVar, false);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
            this.b = null;
        }
        this.f2394a.a((h) null, true);
    }
}
