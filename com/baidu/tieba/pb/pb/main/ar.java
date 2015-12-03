package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.FileDownloader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements a.b {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.cCm.cBw;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.n.fi()) {
            str = this.cCm.aUq;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.i.iQ()) {
                Activity pageActivity = this.cCm.getPageContext().getPageActivity();
                str2 = this.cCm.aUq;
                FileDownloader.download(pageActivity, str2, null, this.cCm.getPageContext().getString(n.i.download_iqiyi_app));
                return;
            }
            return;
        }
        this.cCm.showToast(com.baidu.tbadk.core.util.n.ug());
    }
}
