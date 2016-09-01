package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.FileDownloader;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class go implements a.b {
    private final /* synthetic */ TbPageContext aDS;
    final /* synthetic */ gn euO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public go(gn gnVar, TbPageContext tbPageContext) {
        this.euO = gnVar;
        this.aDS = tbPageContext;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.euO.euK;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.m.cA()) {
            str = this.euO.bKQ;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.i.gn()) {
                Activity pageActivity = this.aDS.getPageActivity();
                str2 = this.euO.bKQ;
                FileDownloader.download(pageActivity, str2, null, this.aDS.getString(t.j.download_iqiyi_app));
                return;
            }
            return;
        }
        com.baidu.adp.lib.util.k.showToast(this.aDS.getPageActivity(), com.baidu.tbadk.core.util.m.tZ());
    }
}
