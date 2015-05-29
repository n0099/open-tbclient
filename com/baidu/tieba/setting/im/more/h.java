package com.baidu.tieba.setting.im.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ SecretSettingActivity cdW;
    private final /* synthetic */ String cdZ;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.i cea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SecretSettingActivity secretSettingActivity, String str, com.baidu.tbadk.core.dialog.i iVar) {
        this.cdW = secretSettingActivity;
        this.cdZ = str;
        this.cea = iVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.cdW.showProgressBar();
        switch (i) {
            case 0:
                this.cdW.T(this.cdZ, 1);
                break;
            case 1:
                this.cdW.T(this.cdZ, 2);
                break;
            case 2:
                this.cdW.T(this.cdZ, 3);
                break;
        }
        this.cea.bD(i);
        if ("group".equals(this.cdZ)) {
            this.cdW.cdR = i + 1;
        } else if ("post".equals(this.cdZ)) {
            this.cdW.cdQ = i + 1;
        } else if ("like".equals(this.cdZ)) {
            this.cdW.cdP = i + 1;
        }
    }
}
