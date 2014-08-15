package com.baidu.tieba.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d a;
    private final /* synthetic */ r b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, r rVar) {
        this.a = dVar;
        this.b = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SettingTextTestNewView settingTextTestNewView;
        TbSettingTextTipView tbSettingTextTipView;
        SettingTextFunctionIntroView settingTextFunctionIntroView;
        settingTextTestNewView = this.a.g;
        if (view == settingTextTestNewView) {
            this.b.a(1);
            return;
        }
        tbSettingTextTipView = this.a.h;
        if (view == tbSettingTextTipView) {
            this.b.a(2);
            return;
        }
        settingTextFunctionIntroView = this.a.i;
        if (view == settingTextFunctionIntroView) {
            this.b.a(3);
        }
    }
}
