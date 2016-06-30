package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.FileDownloader;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gj implements a.b {
    private final /* synthetic */ TbPageContext azW;
    final /* synthetic */ gi dWe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gj(gi giVar, TbPageContext tbPageContext) {
        this.dWe = giVar;
        this.azW = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.dWe.dWa;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.m.bG()) {
            str = this.dWe.bxa;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.i.fs()) {
                Activity pageActivity = this.azW.getPageActivity();
                str2 = this.dWe.bxa;
                FileDownloader.download(pageActivity, str2, null, this.azW.getString(u.j.download_iqiyi_app));
                return;
            }
            return;
        }
        com.baidu.adp.lib.util.k.showToast(this.azW.getPageActivity(), com.baidu.tbadk.core.util.m.sV());
    }
}
