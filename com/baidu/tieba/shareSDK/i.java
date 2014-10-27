package com.baidu.tieba.shareSDK;

import android.view.View;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity bJq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(WriteShareActivity writeShareActivity) {
        this.bJq = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bJq.aca();
        com.baidu.tbadk.core.b.b.a(this.bJq, Constants.MEDIA_INFO, false);
        this.bJq.finish();
    }
}
