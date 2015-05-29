package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tieba.pb.FileDownloader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.bKT.bKi;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.o.fo()) {
            str = this.bKT.mDownloadUrl;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.k.iY()) {
                Activity pageActivity = this.bKT.getPageContext().getPageActivity();
                str2 = this.bKT.mDownloadUrl;
                FileDownloader.download(pageActivity, str2, null, this.bKT.getPageContext().getString(com.baidu.tieba.t.download_iqiyi_app));
                return;
            }
            return;
        }
        this.bKT.showToast(com.baidu.tbadk.core.util.o.sr());
    }
}
