package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.FileDownloader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements a.b {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PbActivity pbActivity) {
        this.ciK = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.ciK.chW;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.n.fi()) {
            str = this.ciK.aPf;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.i.iN()) {
                Activity pageActivity = this.ciK.getPageContext().getPageActivity();
                str2 = this.ciK.aPf;
                FileDownloader.download(pageActivity, str2, null, this.ciK.getPageContext().getString(i.h.download_iqiyi_app));
                return;
            }
            return;
        }
        this.ciK.showToast(com.baidu.tbadk.core.util.n.ty());
    }
}
