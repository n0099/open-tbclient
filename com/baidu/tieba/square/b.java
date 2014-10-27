package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Object, f, f> {
    final /* synthetic */ BarFolderFirstDirActivity bLV;
    private com.baidu.tbadk.core.util.ac yV;

    private b(BarFolderFirstDirActivity barFolderFirstDirActivity) {
        this.bLV = barFolderFirstDirActivity;
        this.yV = null;
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
        this.bLV.a(fVarArr[0], false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(3:21|22|(8:24|4|5|(1:7)|8|(2:10|(1:(1:13))(1:17))(1:18)|15|16))|3|4|5|(0)|8|(0)(0)|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00bc, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00bd, code lost:
        r1.setErrorMsg(r0.getMessage());
        com.baidu.adp.lib.util.BdLog.e(r0.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0076 A[Catch: Exception -> 0x00bc, TryCatch #0 {Exception -> 0x00bc, blocks: (B:7:0x002f, B:9:0x0053, B:10:0x0060, B:12:0x0076, B:19:0x00a8, B:21:0x00b2), top: B:25:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b2 A[Catch: Exception -> 0x00bc, TRY_LEAVE, TryCatch #0 {Exception -> 0x00bc, blocks: (B:7:0x002f, B:9:0x0053, B:10:0x0060, B:12:0x0076, B:19:0x00a8, B:21:0x00b2), top: B:25:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0053 A[Catch: Exception -> 0x00bc, TryCatch #0 {Exception -> 0x00bc, blocks: (B:7:0x002f, B:9:0x0053, B:10:0x0060, B:12:0x0076, B:19:0x00a8, B:21:0x00b2), top: B:25:0x002f }] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: x */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f doInBackground(Object... objArr) {
        String str;
        String str2;
        boolean z = true;
        f fVar = new f();
        com.baidu.adp.lib.cache.t<String> bd = com.baidu.tbadk.core.a.a.kS().bd("tb.first_dir");
        String str3 = bd.get("first_dir_cache_key");
        if (str3 != null) {
            if (!str3.equals("")) {
                fVar.parserJson(str3);
                publishProgress(fVar);
                this.yV = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/forumdir");
                str = this.bLV.stType;
                if (str != null) {
                    com.baidu.tbadk.core.util.ac acVar = this.yV;
                    String str4 = BarFolderFirstDirActivity.bLU;
                    str2 = this.bLV.stType;
                    acVar.k(str4, str2);
                }
                String lA = this.yV.lA();
                if (!this.yV.mc().nb().jq()) {
                    fVar.parserJson(lA);
                    if (new StringBuilder(String.valueOf(lA)).toString().trim().equals(new StringBuilder(String.valueOf(str3)).toString().trim())) {
                        if (z) {
                            return null;
                        }
                    } else {
                        bd.a("first_dir_cache_key", lA, 86400000L);
                    }
                } else {
                    fVar.setErrorMsg(this.yV.getErrorString());
                }
                return fVar;
            }
        }
        z = false;
        this.yV = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/forumdir");
        str = this.bLV.stType;
        if (str != null) {
        }
        String lA2 = this.yV.lA();
        if (!this.yV.mc().nb().jq()) {
        }
        return fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(f fVar) {
        if (fVar != null) {
            this.bLV.a(fVar, false);
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.yV != null) {
            this.yV.dM();
            this.yV = null;
        }
        this.bLV.a(null, true);
    }
}
