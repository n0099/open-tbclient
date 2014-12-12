package com.baidu.tieba.tbadkCore;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends BdAsyncTask<String, String, WriteData> {
    private final am bVr;
    private final String cacheKey;

    public an(String str, am amVar) {
        setPriority(3);
        this.bVr = amVar;
        this.cacheKey = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: B */
    public WriteData doInBackground(String... strArr) {
        String str;
        try {
            str = com.baidu.tbadk.core.a.a.nS().bV("tb.pb_editor").get(this.cacheKey);
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
        if (this.bVr != null) {
            this.bVr.a(writeData);
        }
    }
}
