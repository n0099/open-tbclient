package com.baidu.tieba.shareSDK;

import android.view.View;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ WriteShareActivity bJF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(WriteShareActivity writeShareActivity) {
        this.bJF = writeShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bJF.acd();
        com.baidu.tbadk.core.b.b.a(this.bJF, Constants.MEDIA_INFO, false);
        this.bJF.finish();
    }
}
