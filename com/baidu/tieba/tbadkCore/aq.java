package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
class aq extends BdAsyncTask<String, String, WriteData> {
    private final String cacheKey;
    private final ap crr;

    public aq(String str, ap apVar) {
        setPriority(3);
        this.crr = apVar;
        this.cacheKey = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: A */
    public WriteData doInBackground(String... strArr) {
        String str;
        try {
            str = com.baidu.tbadk.core.b.a.rI().ck("tb.pb_editor").get(this.cacheKey);
        } catch (Exception e) {
            str = null;
        }
        return WriteData.fromDraftString(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(WriteData writeData) {
        super.onPostExecute(writeData);
        if (this.crr != null) {
            this.crr.a(writeData);
        }
    }
}
