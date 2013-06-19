package com.baidu.tieba.more;

import android.view.View;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class v implements com.baidu.adp.widget.BdSwitchView.c {
    final /* synthetic */ BrowseSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(BrowseSettingActivity browseSettingActivity) {
        this.a = browseSettingActivity;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, com.baidu.adp.widget.BdSwitchView.d dVar) {
        if (dVar == com.baidu.adp.widget.BdSwitchView.d.ON) {
            TiebaApplication.e().a((Boolean) true);
        } else {
            TiebaApplication.e().a((Boolean) false);
        }
    }
}
