package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tieba.pb.FileDownloader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.bIJ.bHT;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.o.fj()) {
            str = this.bIJ.mDownloadUrl;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.k.iI()) {
                Activity pageActivity = this.bIJ.getPageContext().getPageActivity();
                str2 = this.bIJ.mDownloadUrl;
                FileDownloader.download(pageActivity, str2, null, this.bIJ.getPageContext().getString(com.baidu.tieba.y.download_iqiyi_app));
                return;
            }
            return;
        }
        this.bIJ.showToast(com.baidu.tbadk.core.util.o.rI());
    }
}
