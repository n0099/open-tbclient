package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Object, f, f> {
    final /* synthetic */ BarFolderFirstDirActivity a;
    private com.baidu.tbadk.core.util.ae b;

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
    public void onProgressUpdate(f... fVarArr) {
        super.onProgressUpdate(fVarArr);
        this.a.a(fVarArr[0], false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(3:21|22|(8:24|4|5|(1:7)|8|(2:10|(1:(1:13))(1:17))(1:18)|15|16))|3|4|5|(0)|8|(0)(0)|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00c1, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c2, code lost:
        r1.a(r0.getMessage());
        com.baidu.adp.lib.util.BdLog.e(r0.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007a A[Catch: Exception -> 0x00c1, TryCatch #1 {Exception -> 0x00c1, blocks: (B:7:0x0032, B:9:0x0057, B:10:0x0064, B:12:0x007a, B:19:0x00ac, B:21:0x00b7), top: B:27:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b7 A[Catch: Exception -> 0x00c1, TRY_LEAVE, TryCatch #1 {Exception -> 0x00c1, blocks: (B:7:0x0032, B:9:0x0057, B:10:0x0064, B:12:0x007a, B:19:0x00ac, B:21:0x00b7), top: B:27:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0057 A[Catch: Exception -> 0x00c1, TryCatch #1 {Exception -> 0x00c1, blocks: (B:7:0x0032, B:9:0x0057, B:10:0x0064, B:12:0x007a, B:19:0x00ac, B:21:0x00b7), top: B:27:0x0032 }] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f doInBackground(Object... objArr) {
        String str;
        String str2;
        boolean z = true;
        f fVar = new f();
        com.baidu.adp.lib.cache.t<String> b = com.baidu.tbadk.core.a.a.a().b("tb.first_dir");
        String a = b.a("first_dir_cache_key");
        if (a != null) {
            if (!a.equals("")) {
                fVar.b(a);
                publishProgress(fVar);
                this.b = new com.baidu.tbadk.core.util.ae(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/forumdir");
                str = this.a.g;
                if (str != null) {
                    com.baidu.tbadk.core.util.ae aeVar = this.b;
                    String str3 = BarFolderFirstDirActivity.c;
                    str2 = this.a.g;
                    aeVar.a(str3, str2);
                }
                String h = this.b.h();
                if (!this.b.a().b().b()) {
                    fVar.b(h);
                    if (new StringBuilder(String.valueOf(h)).toString().trim().equals(new StringBuilder(String.valueOf(a)).toString().trim())) {
                        if (z) {
                            return null;
                        }
                    } else {
                        b.a("first_dir_cache_key", h, 86400000L);
                    }
                } else {
                    fVar.a(this.b.e());
                }
                return fVar;
            }
        }
        z = false;
        this.b = new com.baidu.tbadk.core.util.ae(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/forumdir");
        str = this.a.g;
        if (str != null) {
        }
        String h2 = this.b.h();
        if (!this.b.a().b().b()) {
        }
        return fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(f fVar) {
        if (fVar != null) {
            this.a.a(fVar, false);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.f();
            this.b = null;
        }
        this.a.a((f) null, true);
    }
}
