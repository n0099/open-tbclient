package com.baidu.tieba.more;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class w implements com.baidu.adp.widget.BdSwitchView.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BrowseSettingActivity f1427a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(BrowseSettingActivity browseSettingActivity) {
        this.f1427a = browseSettingActivity;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (switchState == BdSwitchView.SwitchState.ON) {
            TiebaApplication.f().a((Boolean) true);
        } else {
            TiebaApplication.f().a((Boolean) false);
        }
    }
}
