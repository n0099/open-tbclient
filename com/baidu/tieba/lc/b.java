package com.baidu.tieba.lc;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.clientupdate.ClientUpdater;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.download.Download;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.io.IOException;
/* loaded from: classes.dex */
public class b extends BdAsyncTask<String, Integer, Download> {
    private ClientUpdateInfo kQd;

    public b(ClientUpdateInfo clientUpdateInfo) {
        this.kQd = clientUpdateInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: O */
    public Download doInBackground(String... strArr) throws IOException {
        if (this.kQd != null) {
            ClientUpdater.getInstance(TbadkCoreApplication.getInst()).startDownload(this.kQd, null);
        }
        return null;
    }
}
