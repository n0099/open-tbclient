package com.baidu.tieba.play;

import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.net.InetAddress;
/* loaded from: classes.dex */
class ak extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ ah eJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ah ahVar) {
        this.eJG = ahVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        String str;
        String str2;
        str = this.eJG.eJx;
        if (!com.baidu.tbadk.core.util.av.isEmpty(str)) {
            str2 = this.eJG.eJx;
            Uri parse = Uri.parse(str2);
            if (parse != null) {
                try {
                    InetAddress byName = InetAddress.getByName(parse.getHost());
                    this.eJG.tQ = byName.getHostAddress();
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return null;
    }
}
