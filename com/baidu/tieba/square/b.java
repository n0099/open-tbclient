package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Object, h, h> {
    final /* synthetic */ BarFolderFirstDirActivity a;
    private com.baidu.tbadk.core.util.al b;

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
    public void onProgressUpdate(h... hVarArr) {
        super.onProgressUpdate(hVarArr);
        this.a.a(hVarArr[0], false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(3:21|22|(8:24|4|5|(1:7)|8|(2:10|(1:(1:13))(1:17))(1:18)|15|16))|3|4|5|(0)|8|(0)(0)|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00be, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00bf, code lost:
        r1.a(r0.getMessage());
        com.baidu.adp.lib.util.BdLog.e(getClass().getName(), "doInBackground", r0.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0077 A[Catch: Exception -> 0x00be, TryCatch #0 {Exception -> 0x00be, blocks: (B:7:0x002f, B:9:0x0054, B:10:0x0061, B:12:0x0077, B:19:0x00a9, B:21:0x00b4), top: B:25:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b4 A[Catch: Exception -> 0x00be, TRY_LEAVE, TryCatch #0 {Exception -> 0x00be, blocks: (B:7:0x002f, B:9:0x0054, B:10:0x0061, B:12:0x0077, B:19:0x00a9, B:21:0x00b4), top: B:25:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0054 A[Catch: Exception -> 0x00be, TryCatch #0 {Exception -> 0x00be, blocks: (B:7:0x002f, B:9:0x0054, B:10:0x0061, B:12:0x0077, B:19:0x00a9, B:21:0x00b4), top: B:25:0x002f }] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h doInBackground(Object... objArr) {
        String str;
        String str2;
        boolean z = true;
        h hVar = new h();
        com.baidu.adp.lib.cache.s<String> r = com.baidu.tbadk.core.a.b.a().r();
        String a = r.a("first_dir_cache_key");
        if (a != null) {
            if (!a.equals("")) {
                hVar.b(a);
                publishProgress(hVar);
                this.b = new com.baidu.tbadk.core.util.al(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/forumdir");
                str = this.a.g;
                if (str != null) {
                    com.baidu.tbadk.core.util.al alVar = this.b;
                    String str3 = BarFolderFirstDirActivity.c;
                    str2 = this.a.g;
                    alVar.a(str3, str2);
                }
                String i = this.b.i();
                if (!this.b.a().b().b()) {
                    hVar.b(i);
                    if (new StringBuilder(String.valueOf(i)).toString().trim().equals(new StringBuilder(String.valueOf(a)).toString().trim())) {
                        if (z) {
                            return null;
                        }
                    } else {
                        r.a("first_dir_cache_key", i, 86400000L);
                    }
                } else {
                    hVar.a(this.b.f());
                }
                return hVar;
            }
        }
        z = false;
        this.b = new com.baidu.tbadk.core.util.al(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/forumdir");
        str = this.a.g;
        if (str != null) {
        }
        String i2 = this.b.i();
        if (!this.b.a().b().b()) {
        }
        return hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(h hVar) {
        if (hVar != null) {
            this.a.a(hVar, false);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        this.a.a((h) null, true);
    }
}
