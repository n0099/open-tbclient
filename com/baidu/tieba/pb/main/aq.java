package com.baidu.tieba.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tieba.FileDownloader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.bAS.bAf;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.s.bL()) {
            str = this.bAS.mDownloadUrl;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.i.fg()) {
                Activity pageActivity = this.bAS.getPageContext().getPageActivity();
                str2 = this.bAS.mDownloadUrl;
                FileDownloader.download(pageActivity, str2, null, this.bAS.getPageContext().getString(com.baidu.tieba.z.download_iqiyi_app));
                return;
            }
            return;
        }
        this.bAS.showToast(com.baidu.tbadk.core.util.s.ol());
    }
}
