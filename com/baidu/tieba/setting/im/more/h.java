package com.baidu.tieba.setting.im.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ SecretSettingActivity cKX;
    private final /* synthetic */ String cLa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SecretSettingActivity secretSettingActivity, String str) {
        this.cKX = secretSettingActivity;
        this.cLa = str;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        this.cKX.showProgressBar();
        switch (i) {
            case 0:
                this.cKX.ab(this.cLa, 1);
                break;
            case 1:
                this.cKX.ab(this.cLa, 2);
                break;
            case 2:
                this.cKX.ab(this.cLa, 3);
                break;
        }
        eVar = this.cKX.cKS;
        eVar.bO(i);
        if ("group".equals(this.cLa)) {
            this.cKX.cKR = i + 1;
        } else if ("post".equals(this.cLa)) {
            this.cKX.cKQ = i + 1;
        } else if ("like".equals(this.cLa)) {
            this.cKX.cKP = i + 1;
        }
    }
}
