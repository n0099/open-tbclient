package com.baidu.tieba.setting.im.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ SecretSettingActivity bZp;
    private final /* synthetic */ String bZs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SecretSettingActivity secretSettingActivity, String str) {
        this.bZp = secretSettingActivity;
        this.bZs = str;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        this.bZp.showProgressBar();
        switch (i) {
            case 0:
                this.bZp.S(this.bZs, 1);
                break;
            case 1:
                this.bZp.S(this.bZs, 2);
                break;
            case 2:
                this.bZp.S(this.bZs, 3);
                break;
        }
        eVar.dismiss();
    }
}
