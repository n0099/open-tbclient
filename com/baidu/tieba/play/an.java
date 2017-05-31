package com.baidu.tieba.play;

import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.net.InetAddress;
/* loaded from: classes.dex */
class an extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ ak fbJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ak akVar) {
        this.fbJ = akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        String str;
        String str2;
        str = this.fbJ.fbB;
        if (!com.baidu.tbadk.core.util.au.isEmpty(str)) {
            str2 = this.fbJ.fbB;
            Uri parse = Uri.parse(str2);
            if (parse != null) {
                try {
                    InetAddress byName = InetAddress.getByName(parse.getHost());
                    this.fbJ.AA = byName.getHostAddress();
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
