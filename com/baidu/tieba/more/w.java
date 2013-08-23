package com.baidu.tieba.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class w implements com.baidu.adp.widget.BdSwitchView.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BrowseSettingActivity f1464a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(BrowseSettingActivity browseSettingActivity) {
        this.f1464a = browseSettingActivity;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            TiebaApplication.g().b((Boolean) true);
        } else {
            TiebaApplication.g().b((Boolean) false);
        }
    }
}
