package com.baidu.tieba.setting.im.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ SecretSettingActivity cMS;
    private final /* synthetic */ String cMV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SecretSettingActivity secretSettingActivity, String str) {
        this.cMS = secretSettingActivity;
        this.cMV = str;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        this.cMS.showProgressBar();
        switch (i) {
            case 0:
                this.cMS.ab(this.cMV, 1);
                break;
            case 1:
                this.cMS.ab(this.cMV, 2);
                break;
            case 2:
                this.cMS.ab(this.cMV, 3);
                break;
        }
        eVar = this.cMS.cMN;
        eVar.bO(i);
        if ("group".equals(this.cMV)) {
            this.cMS.cMM = i + 1;
        } else if ("post".equals(this.cMV)) {
            this.cMS.cML = i + 1;
        } else if ("like".equals(this.cMV)) {
            this.cMS.cMK = i + 1;
        }
    }
}
