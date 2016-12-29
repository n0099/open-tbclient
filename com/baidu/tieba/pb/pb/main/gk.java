package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.FileDownloader;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gk implements a.b {
    private final /* synthetic */ TbPageContext aDH;
    final /* synthetic */ gj ehn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gk(gj gjVar, TbPageContext tbPageContext) {
        this.ehn = gjVar;
        this.aDH = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.ehn.ehj;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.m.cA()) {
            str = this.ehn.btP;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.i.gn()) {
                Activity pageActivity = this.aDH.getPageActivity();
                str2 = this.ehn.btP;
                FileDownloader.download(pageActivity, str2, null, this.aDH.getString(r.j.download_iqiyi_app));
                return;
            }
            return;
        }
        com.baidu.adp.lib.util.k.showToast(this.aDH.getPageActivity(), com.baidu.tbadk.core.util.m.ud());
    }
}
