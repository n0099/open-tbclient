package com.baidu.tieba.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements View.OnClickListener {
    final /* synthetic */ d a;
    private final /* synthetic */ p b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, p pVar) {
        this.a = dVar;
        this.b = pVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SettingTextTestNewView settingTextTestNewView;
        TbSettingTextTipView tbSettingTextTipView;
        SettingTextFunctionIntroView settingTextFunctionIntroView;
        settingTextTestNewView = this.a.h;
        if (view == settingTextTestNewView) {
            this.b.a(1);
            return;
        }
        tbSettingTextTipView = this.a.i;
        if (view == tbSettingTextTipView) {
            this.b.a(2);
            return;
        }
        settingTextFunctionIntroView = this.a.j;
        if (view == settingTextFunctionIntroView) {
            this.b.a(3);
        }
    }
}
