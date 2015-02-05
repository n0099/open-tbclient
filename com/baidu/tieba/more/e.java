package com.baidu.tieba.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d bva;
    private final /* synthetic */ q bvb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, q qVar) {
        this.bva = dVar;
        this.bvb = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SettingTextTestNewView settingTextTestNewView;
        TbSettingTextTipView tbSettingTextTipView;
        SettingTextFunctionIntroView settingTextFunctionIntroView;
        settingTextTestNewView = this.bva.buW;
        if (view == settingTextTestNewView) {
            this.bvb.gS(1);
            return;
        }
        tbSettingTextTipView = this.bva.buX;
        if (view == tbSettingTextTipView) {
            this.bvb.gS(2);
            return;
        }
        settingTextFunctionIntroView = this.bva.buY;
        if (view == settingTextFunctionIntroView) {
            this.bvb.gS(3);
        }
    }
}
