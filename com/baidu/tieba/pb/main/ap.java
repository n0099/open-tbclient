package com.baidu.tieba.pb.main;

import android.text.TextUtils;
import com.baidu.tieba.FileDownloader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.dialog.a aVar2;
        String str;
        String str2;
        aVar2 = this.bvg.bus;
        aVar2.dismiss();
        if (com.baidu.tbadk.core.util.s.bm()) {
            str = this.bvg.ato;
            if (!TextUtils.isEmpty(str) && com.baidu.adp.lib.util.j.fi()) {
                PbActivity pbActivity = this.bvg;
                str2 = this.bvg.ato;
                FileDownloader.download(pbActivity, str2, null, this.bvg.getString(com.baidu.tieba.y.download_iqiyi_app));
                return;
            }
            return;
        }
        this.bvg.showToast(com.baidu.tbadk.core.util.s.lu());
    }
}
