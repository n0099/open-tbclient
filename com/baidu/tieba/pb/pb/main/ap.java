package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.FileDownloader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (!com.baidu.tbadk.core.util.o.fo()) {
            this.bKT.showToast(com.baidu.tbadk.core.util.o.sr());
        } else {
            FileDownloader.download(this.bKT.getPageContext().getPageActivity(), "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, this.bKT.getPageContext().getString(com.baidu.tieba.t.download_baidu_video));
        }
    }
}
