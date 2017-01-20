package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.FileDownloader;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gu implements a.b {
    private final /* synthetic */ TbPageContext aCz;
    final /* synthetic */ gt eqw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gu(gt gtVar, TbPageContext tbPageContext) {
        this.eqw = gtVar;
        this.aCz = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.eqw.eqs;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.l.cy()) {
            str = this.eqw.bBx;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.i.gl()) {
                Activity pageActivity = this.aCz.getPageActivity();
                str2 = this.eqw.bBx;
                FileDownloader.download(pageActivity, str2, null, this.aCz.getString(r.l.download_iqiyi_app));
                return;
            }
            return;
        }
        com.baidu.adp.lib.util.k.showToast(this.aCz.getPageActivity(), com.baidu.tbadk.core.util.l.tX());
    }
}
