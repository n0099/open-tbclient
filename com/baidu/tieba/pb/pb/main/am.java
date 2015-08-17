package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.FileDownloader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements a.b {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PbActivity pbActivity) {
        this.cbo = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.cbo.caB;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.n.fl()) {
            str = this.cbo.aPL;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.i.iP()) {
                Activity pageActivity = this.cbo.getPageContext().getPageActivity();
                str2 = this.cbo.aPL;
                FileDownloader.download(pageActivity, str2, null, this.cbo.getPageContext().getString(i.C0057i.download_iqiyi_app));
                return;
            }
            return;
        }
        this.cbo.showToast(com.baidu.tbadk.core.util.n.ty());
    }
}
