package com.baidu.tieba.shareSDK;

import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
/* loaded from: classes.dex */
class h implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ WriteShareActivity bJF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(WriteShareActivity writeShareActivity) {
        this.bJF = writeShareActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void onClick(com.baidu.tbadk.core.dialog.e eVar) {
        eVar.dismiss();
        com.baidu.tbadk.core.b.b.a(this.bJF, Constants.MEDIA_INFO, false);
        this.bJF.finish();
    }
}
