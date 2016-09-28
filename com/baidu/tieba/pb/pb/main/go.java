package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.FileDownloader;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class go implements a.b {
    private final /* synthetic */ TbPageContext aDv;
    final /* synthetic */ gn ewU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public go(gn gnVar, TbPageContext tbPageContext) {
        this.ewU = gnVar;
        this.aDv = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.ewU.ewQ;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.m.cA()) {
            str = this.ewU.bKR;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.i.gn()) {
                Activity pageActivity = this.aDv.getPageActivity();
                str2 = this.ewU.bKR;
                FileDownloader.download(pageActivity, str2, null, this.aDv.getString(r.j.download_iqiyi_app));
                return;
            }
            return;
        }
        com.baidu.adp.lib.util.k.showToast(this.aDv.getPageActivity(), com.baidu.tbadk.core.util.m.up());
    }
}
