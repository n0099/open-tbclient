package com.baidu.tieba.setting.im.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ SecretSettingActivity cdX;
    private final /* synthetic */ String cea;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.i ceb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SecretSettingActivity secretSettingActivity, String str, com.baidu.tbadk.core.dialog.i iVar) {
        this.cdX = secretSettingActivity;
        this.cea = str;
        this.ceb = iVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.cdX.showProgressBar();
        switch (i) {
            case 0:
                this.cdX.T(this.cea, 1);
                break;
            case 1:
                this.cdX.T(this.cea, 2);
                break;
            case 2:
                this.cdX.T(this.cea, 3);
                break;
        }
        this.ceb.bD(i);
        if ("group".equals(this.cea)) {
            this.cdX.cdS = i + 1;
        } else if ("post".equals(this.cea)) {
            this.cdX.cdR = i + 1;
        } else if ("like".equals(this.cea)) {
            this.cdX.cdQ = i + 1;
        }
    }
}
