package com.baidu.tieba.more;

import android.view.View;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d bqq;
    private final /* synthetic */ r bqr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, r rVar) {
        this.bqq = dVar;
        this.bqr = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SettingTextTestNewView settingTextTestNewView;
        TbSettingTextTipView tbSettingTextTipView;
        SettingTextFunctionIntroView settingTextFunctionIntroView;
        settingTextTestNewView = this.bqq.bqm;
        if (view == settingTextTestNewView) {
            this.bqr.gF(1);
            return;
        }
        tbSettingTextTipView = this.bqq.bqn;
        if (view == tbSettingTextTipView) {
            this.bqr.gF(2);
            return;
        }
        settingTextFunctionIntroView = this.bqq.bqo;
        if (view == settingTextFunctionIntroView) {
            this.bqr.gF(3);
        }
    }
}
