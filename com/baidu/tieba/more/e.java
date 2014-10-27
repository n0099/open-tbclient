package com.baidu.tieba.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d bqc;
    private final /* synthetic */ r bqd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, r rVar) {
        this.bqc = dVar;
        this.bqd = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SettingTextTestNewView settingTextTestNewView;
        TbSettingTextTipView tbSettingTextTipView;
        SettingTextFunctionIntroView settingTextFunctionIntroView;
        settingTextTestNewView = this.bqc.bpY;
        if (view == settingTextTestNewView) {
            this.bqd.gF(1);
            return;
        }
        tbSettingTextTipView = this.bqc.bpZ;
        if (view == tbSettingTextTipView) {
            this.bqd.gF(2);
            return;
        }
        settingTextFunctionIntroView = this.bqc.bqa;
        if (view == settingTextFunctionIntroView) {
            this.bqd.gF(3);
        }
    }
}
