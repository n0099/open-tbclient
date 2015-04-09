package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.FileDownloader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (!com.baidu.tbadk.core.util.o.fj()) {
            this.bIJ.showToast(com.baidu.tbadk.core.util.o.rI());
        } else {
            FileDownloader.download(this.bIJ.getPageContext().getPageActivity(), "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, this.bIJ.getPageContext().getString(com.baidu.tieba.y.download_baidu_video));
        }
    }
}
