package com.baidu.tieba.util;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
class n extends BdAsyncTask<String, String, WriteData> {
    private final m bPY;
    private final String cacheKey;

    public n(String str, m mVar) {
        setPriority(3);
        this.bPY = mVar;
        this.cacheKey = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: B */
    public WriteData doInBackground(String... strArr) {
        String str;
        try {
            str = com.baidu.tbadk.core.a.a.kS().bd("tb.pb_editor").get(this.cacheKey);
        } catch (Exception e) {
            str = null;
        }
        return WriteData.fromDraftString(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(WriteData writeData) {
        super.onPostExecute(writeData);
        if (this.bPY != null) {
            this.bPY.a(writeData);
        }
    }
}
