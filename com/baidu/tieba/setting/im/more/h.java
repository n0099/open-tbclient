package com.baidu.tieba.setting.im.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ SecretSettingActivity dlj;
    private final /* synthetic */ String dlm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SecretSettingActivity secretSettingActivity, String str) {
        this.dlj = secretSettingActivity;
        this.dlm = str;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        this.dlj.showProgressBar();
        switch (i) {
            case 0:
                this.dlj.ag(this.dlm, 1);
                break;
            case 1:
                this.dlj.ag(this.dlm, 2);
                break;
            case 2:
                this.dlj.ag(this.dlm, 3);
                break;
        }
        eVar = this.dlj.dle;
        eVar.bW(i);
        if ("group".equals(this.dlm)) {
            this.dlj.dld = i + 1;
        } else if ("post".equals(this.dlm)) {
            this.dlj.dlc = i + 1;
        } else if ("like".equals(this.dlm)) {
            this.dlj.dlb = i + 1;
        }
    }
}
