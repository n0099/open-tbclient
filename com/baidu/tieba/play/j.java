package com.baidu.tieba.play;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class j implements a.b {
    final /* synthetic */ c flr;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar, String str) {
        this.flr = cVar;
        this.val$url = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
        this.flr.startPlay(this.val$url);
        aVar.dismiss();
    }
}
