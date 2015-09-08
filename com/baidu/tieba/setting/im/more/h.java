package com.baidu.tieba.setting.im.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ SecretSettingActivity cDW;
    private final /* synthetic */ String cDZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SecretSettingActivity secretSettingActivity, String str) {
        this.cDW = secretSettingActivity;
        this.cDZ = str;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        this.cDW.showProgressBar();
        switch (i) {
            case 0:
                this.cDW.Z(this.cDZ, 1);
                break;
            case 1:
                this.cDW.Z(this.cDZ, 2);
                break;
            case 2:
                this.cDW.Z(this.cDZ, 3);
                break;
        }
        eVar = this.cDW.cDR;
        eVar.bO(i);
        if ("group".equals(this.cDZ)) {
            this.cDW.cDQ = i + 1;
        } else if ("post".equals(this.cDZ)) {
            this.cDW.cDP = i + 1;
        } else if ("like".equals(this.cDZ)) {
            this.cDW.cDO = i + 1;
        }
    }
}
