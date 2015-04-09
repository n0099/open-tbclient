package com.baidu.tieba.setting.im.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ SecretSettingActivity bZE;
    private final /* synthetic */ String bZH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SecretSettingActivity secretSettingActivity, String str) {
        this.bZE = secretSettingActivity;
        this.bZH = str;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        this.bZE.showProgressBar();
        switch (i) {
            case 0:
                this.bZE.S(this.bZH, 1);
                break;
            case 1:
                this.bZE.S(this.bZH, 2);
                break;
            case 2:
                this.bZE.S(this.bZH, 3);
                break;
        }
        eVar.dismiss();
    }
}
