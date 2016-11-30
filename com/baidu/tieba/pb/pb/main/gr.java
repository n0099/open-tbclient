package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.FileDownloader;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gr implements a.b {
    private final /* synthetic */ TbPageContext aEn;
    final /* synthetic */ gq eDh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gr(gq gqVar, TbPageContext tbPageContext) {
        this.eDh = gqVar;
        this.aEn = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.eDh.eDd;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.m.cA()) {
            str = this.eDh.bNK;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.i.gn()) {
                Activity pageActivity = this.aEn.getPageActivity();
                str2 = this.eDh.bNK;
                FileDownloader.download(pageActivity, str2, null, this.aEn.getString(r.j.download_iqiyi_app));
                return;
            }
            return;
        }
        com.baidu.adp.lib.util.k.showToast(this.aEn.getPageActivity(), com.baidu.tbadk.core.util.m.ut());
    }
}
