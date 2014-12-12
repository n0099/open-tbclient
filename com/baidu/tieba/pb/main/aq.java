package com.baidu.tieba.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tieba.FileDownloader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.bzj.byx;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.s.bN()) {
            str = this.bzj.mDownloadUrl;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.i.fh()) {
                Activity pageActivity = this.bzj.getPageContext().getPageActivity();
                str2 = this.bzj.mDownloadUrl;
                FileDownloader.download(pageActivity, str2, null, this.bzj.getPageContext().getString(com.baidu.tieba.z.download_iqiyi_app));
                return;
            }
            return;
        }
        this.bzj.showToast(com.baidu.tbadk.core.util.s.op());
    }
}
