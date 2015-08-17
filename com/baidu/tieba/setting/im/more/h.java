package com.baidu.tieba.setting.im.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ SecretSettingActivity cvA;
    private final /* synthetic */ String cvD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SecretSettingActivity secretSettingActivity, String str) {
        this.cvA = secretSettingActivity;
        this.cvD = str;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        this.cvA.showProgressBar();
        switch (i) {
            case 0:
                this.cvA.X(this.cvD, 1);
                break;
            case 1:
                this.cvA.X(this.cvD, 2);
                break;
            case 2:
                this.cvA.X(this.cvD, 3);
                break;
        }
        eVar = this.cvA.cvv;
        eVar.bL(i);
        if ("group".equals(this.cvD)) {
            this.cvA.cvu = i + 1;
        } else if ("post".equals(this.cvD)) {
            this.cvA.cvt = i + 1;
        } else if ("like".equals(this.cvD)) {
            this.cvA.cvs = i + 1;
        }
    }
}
