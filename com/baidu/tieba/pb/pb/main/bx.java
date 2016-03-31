package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.FileDownloader;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx implements a.b {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.dht.dgo;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.m.fr()) {
            str = this.dht.bfq;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.i.jg()) {
                Activity pageActivity = this.dht.getPageContext().getPageActivity();
                str2 = this.dht.bfq;
                FileDownloader.download(pageActivity, str2, null, this.dht.getPageContext().getString(t.j.download_iqiyi_app));
                return;
            }
            return;
        }
        this.dht.showToast(com.baidu.tbadk.core.util.m.vq());
    }
}
