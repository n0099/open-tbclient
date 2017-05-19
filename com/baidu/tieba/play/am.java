package com.baidu.tieba.play;

import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.net.InetAddress;
/* loaded from: classes.dex */
class am extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ aj eSW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(aj ajVar) {
        this.eSW = ajVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        String str;
        String str2;
        str = this.eSW.eSO;
        if (!com.baidu.tbadk.core.util.au.isEmpty(str)) {
            str2 = this.eSW.eSO;
            Uri parse = Uri.parse(str2);
            if (parse != null) {
                try {
                    InetAddress byName = InetAddress.getByName(parse.getHost());
                    this.eSW.AA = byName.getHostAddress();
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
