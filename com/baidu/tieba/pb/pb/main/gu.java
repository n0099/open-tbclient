package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.FileDownloader;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gu implements a.b {
    private final /* synthetic */ TbPageContext aHR;
    final /* synthetic */ gt etD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gu(gt gtVar, TbPageContext tbPageContext) {
        this.etD = gtVar;
        this.aHR = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.etD.etz;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.l.dH()) {
            str = this.etD.bID;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.i.hf()) {
                Activity pageActivity = this.aHR.getPageActivity();
                str2 = this.etD.bID;
                FileDownloader.download(pageActivity, str2, null, this.aHR.getString(w.l.download_iqiyi_app));
                return;
            }
            return;
        }
        com.baidu.adp.lib.util.k.showToast(this.aHR.getPageActivity(), com.baidu.tbadk.core.util.l.uv());
    }
}
