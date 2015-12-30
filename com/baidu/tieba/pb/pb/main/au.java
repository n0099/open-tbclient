package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.FileDownloader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements a.b {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (!com.baidu.tbadk.core.util.n.fi()) {
            this.cFS.showToast(com.baidu.tbadk.core.util.n.tQ());
        } else {
            FileDownloader.download(this.cFS.getPageContext().getPageActivity(), "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, this.cFS.getPageContext().getString(n.j.download_baidu_video));
        }
    }
}
