package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.FileDownloader;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements a.b {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.cNq.cMu;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.m.fq()) {
            str = this.cNq.baG;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.i.ja()) {
                Activity pageActivity = this.cNq.getPageContext().getPageActivity();
                str2 = this.cNq.baG;
                FileDownloader.download(pageActivity, str2, null, this.cNq.getPageContext().getString(t.j.download_iqiyi_app));
                return;
            }
            return;
        }
        this.cNq.showToast(com.baidu.tbadk.core.util.m.uU());
    }
}
