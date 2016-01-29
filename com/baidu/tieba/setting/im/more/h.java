package com.baidu.tieba.setting.im.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ SecretSettingActivity dIu;
    private final /* synthetic */ String dIx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SecretSettingActivity secretSettingActivity, String str) {
        this.dIu = secretSettingActivity;
        this.dIx = str;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.f fVar;
        this.dIu.showProgressBar();
        switch (i) {
            case 0:
                this.dIu.aj(this.dIx, 1);
                break;
            case 1:
                this.dIu.aj(this.dIx, 2);
                break;
            case 2:
                this.dIu.aj(this.dIx, 3);
                break;
        }
        fVar = this.dIu.dIq;
        fVar.ci(i);
        if ("group".equals(this.dIx)) {
            this.dIu.dIp = i + 1;
        } else if ("post".equals(this.dIx)) {
            this.dIu.dIo = i + 1;
        } else if ("like".equals(this.dIx)) {
            this.dIu.dIn = i + 1;
        }
    }
}
