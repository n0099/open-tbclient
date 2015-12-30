package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.FileDownloader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements a.b {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.cFS.cFb;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.n.fi()) {
            str = this.cFS.aYr;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.i.iR()) {
                Activity pageActivity = this.cFS.getPageContext().getPageActivity();
                str2 = this.cFS.aYr;
                FileDownloader.download(pageActivity, str2, null, this.cFS.getPageContext().getString(n.j.download_iqiyi_app));
                return;
            }
            return;
        }
        this.cFS.showToast(com.baidu.tbadk.core.util.n.tQ());
    }
}
