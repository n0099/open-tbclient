package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.FileDownloader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements a.b {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.cjN.ciZ;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.n.fi()) {
            str = this.cjN.aPn;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.i.iO()) {
                Activity pageActivity = this.cjN.getPageContext().getPageActivity();
                str2 = this.cjN.aPn;
                FileDownloader.download(pageActivity, str2, null, this.cjN.getPageContext().getString(i.h.download_iqiyi_app));
                return;
            }
            return;
        }
        this.cjN.showToast(com.baidu.tbadk.core.util.n.tB());
    }
}
