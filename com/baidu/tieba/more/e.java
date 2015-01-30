package com.baidu.tieba.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d bvb;
    private final /* synthetic */ q bvc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, q qVar) {
        this.bvb = dVar;
        this.bvc = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SettingTextTestNewView settingTextTestNewView;
        TbSettingTextTipView tbSettingTextTipView;
        SettingTextFunctionIntroView settingTextFunctionIntroView;
        settingTextTestNewView = this.bvb.buX;
        if (view == settingTextTestNewView) {
            this.bvc.gS(1);
            return;
        }
        tbSettingTextTipView = this.bvb.buY;
        if (view == tbSettingTextTipView) {
            this.bvc.gS(2);
            return;
        }
        settingTextFunctionIntroView = this.bvb.buZ;
        if (view == settingTextFunctionIntroView) {
            this.bvc.gS(3);
        }
    }
}
