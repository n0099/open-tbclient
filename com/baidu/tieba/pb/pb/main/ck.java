package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import tbclient.PbPage.PbPageResIdl;
/* loaded from: classes.dex */
class ck extends BdAsyncTask<Void, Void, Void> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.tbadk.util.y.a(PbPageRequestMessage.WIRE, PbPageResIdl.class);
        return null;
    }
}
