package com.baidu.tieba.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d btE;
    private final /* synthetic */ q btF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, q qVar) {
        this.btE = dVar;
        this.btF = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SettingTextTestNewView settingTextTestNewView;
        TbSettingTextTipView tbSettingTextTipView;
        SettingTextFunctionIntroView settingTextFunctionIntroView;
        settingTextTestNewView = this.btE.btA;
        if (view == settingTextTestNewView) {
            this.btF.gJ(1);
            return;
        }
        tbSettingTextTipView = this.btE.btB;
        if (view == tbSettingTextTipView) {
            this.btF.gJ(2);
            return;
        }
        settingTextFunctionIntroView = this.btE.btC;
        if (view == settingTextFunctionIntroView) {
            this.btF.gJ(3);
        }
    }
}
