package com.baidu.tieba.play;

import android.net.Uri;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.az;
import java.net.InetAddress;
/* loaded from: classes.dex */
class v extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ s eZb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.eZb = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        String str;
        String str2;
        str = this.eZb.eYT;
        if (!az.isEmpty(str)) {
            str2 = this.eZb.eYT;
            Uri parse = Uri.parse(str2);
            if (parse != null) {
                try {
                    InetAddress byName = InetAddress.getByName(parse.getHost());
                    this.eZb.tP = byName.getHostAddress();
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
