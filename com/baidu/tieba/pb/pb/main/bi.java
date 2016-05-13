package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.FileDownloader;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements a.b {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        if (!com.baidu.tbadk.core.util.m.bF()) {
            this.djE.showToast(com.baidu.tbadk.core.util.m.sY());
        } else {
            FileDownloader.download(this.djE.getPageContext().getPageActivity(), "http://bcscdn.baidu.com/videoandroid/baiduvideo_4099e.apk", null, this.djE.getPageContext().getString(t.j.download_baidu_video));
        }
    }
}
