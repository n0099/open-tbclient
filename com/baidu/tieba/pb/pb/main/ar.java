package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.FileDownloader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements a.b {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (!com.baidu.tbadk.core.util.n.fi()) {
            this.cjN.showToast(com.baidu.tbadk.core.util.n.tB());
        } else {
            FileDownloader.download(this.cjN.getPageContext().getPageActivity(), "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, this.cjN.getPageContext().getString(i.h.download_baidu_video));
        }
    }
}
