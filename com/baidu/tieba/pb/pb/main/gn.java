package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.FileDownloader;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gn implements a.b {
    private final /* synthetic */ TbPageContext aAL;
    final /* synthetic */ gm eiH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gn(gm gmVar, TbPageContext tbPageContext) {
        this.eiH = gmVar;
        this.aAL = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.eiH.eiD;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.m.bF()) {
            str = this.eiH.bzo;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.i.fr()) {
                Activity pageActivity = this.aAL.getPageActivity();
                str2 = this.eiH.bzo;
                FileDownloader.download(pageActivity, str2, null, this.aAL.getString(u.j.download_iqiyi_app));
                return;
            }
            return;
        }
        com.baidu.adp.lib.util.k.showToast(this.aAL.getPageActivity(), com.baidu.tbadk.core.util.m.sU());
    }
}
