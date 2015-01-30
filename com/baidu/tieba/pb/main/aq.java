package com.baidu.tieba.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tieba.FileDownloader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.bAT.bAg;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.s.bL()) {
            str = this.bAT.mDownloadUrl;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.i.fg()) {
                Activity pageActivity = this.bAT.getPageContext().getPageActivity();
                str2 = this.bAT.mDownloadUrl;
                FileDownloader.download(pageActivity, str2, null, this.bAT.getPageContext().getString(com.baidu.tieba.z.download_iqiyi_app));
                return;
            }
            return;
        }
        this.bAT.showToast(com.baidu.tbadk.core.util.s.os());
    }
}
