package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.FileDownloader;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gc implements a.b {
    private final /* synthetic */ TbPageContext azg;
    final /* synthetic */ gb dpH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gc(gb gbVar, TbPageContext tbPageContext) {
        this.dpH = gbVar;
        this.azg = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.dpH.dpD;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.m.bF()) {
            str = this.dpH.bbf;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.i.fr()) {
                Activity pageActivity = this.azg.getPageActivity();
                str2 = this.dpH.bbf;
                FileDownloader.download(pageActivity, str2, null, this.azg.getString(t.j.download_iqiyi_app));
                return;
            }
            return;
        }
        com.baidu.adp.lib.util.k.showToast(this.azg.getPageActivity(), com.baidu.tbadk.core.util.m.sX());
    }
}
