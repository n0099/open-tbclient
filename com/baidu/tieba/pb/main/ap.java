package com.baidu.tieba.pb.main;

import android.text.TextUtils;
import com.baidu.tieba.FileDownloader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.bvu.buH;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.s.bm()) {
            str = this.bvu.atx;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.j.fi()) {
                PbActivity pbActivity = this.bvu;
                str2 = this.bvu.atx;
                FileDownloader.download(pbActivity, str2, null, this.bvu.getString(com.baidu.tieba.y.download_iqiyi_app));
                return;
            }
            return;
        }
        this.bvu.showToast(com.baidu.tbadk.core.util.s.lu());
    }
}
