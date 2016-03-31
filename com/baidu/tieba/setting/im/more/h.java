package com.baidu.tieba.setting.im.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ SecretSettingActivity eaO;
    private final /* synthetic */ String eaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SecretSettingActivity secretSettingActivity, String str) {
        this.eaO = secretSettingActivity;
        this.eaR = str;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.f fVar;
        this.eaO.showProgressBar();
        switch (i) {
            case 0:
                this.eaO.ar(this.eaR, 1);
                break;
            case 1:
                this.eaO.ar(this.eaR, 2);
                break;
            case 2:
                this.eaO.ar(this.eaR, 3);
                break;
        }
        fVar = this.eaO.eaK;
        fVar.ck(i);
        if ("group".equals(this.eaR)) {
            this.eaO.eaJ = i + 1;
        } else if ("post".equals(this.eaR)) {
            this.eaO.eaI = i + 1;
        } else if ("like".equals(this.eaR)) {
            this.eaO.eaH = i + 1;
        }
    }
}
