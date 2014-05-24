package com.baidu.tieba.util;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
class o extends BdAsyncTask<String, String, WriteData> {
    private final n a;
    private final String b;

    public o(String str, n nVar) {
        setPriority(3);
        this.a = nVar;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public WriteData doInBackground(String... strArr) {
        String str;
        try {
            str = com.baidu.tbadk.core.a.b.a().e().a(this.b);
        } catch (Exception e) {
            str = null;
        }
        return WriteData.fromDraftString(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(WriteData writeData) {
        super.onPostExecute(writeData);
        if (this.a != null) {
            this.a.a(writeData);
        }
    }
}
