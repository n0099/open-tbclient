package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.FileDownloader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (!com.baidu.tbadk.core.util.o.fj()) {
            this.bIv.showToast(com.baidu.tbadk.core.util.o.rI());
        } else {
            FileDownloader.download(this.bIv.getPageContext().getPageActivity(), "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, this.bIv.getPageContext().getString(com.baidu.tieba.y.download_baidu_video));
        }
    }
}
