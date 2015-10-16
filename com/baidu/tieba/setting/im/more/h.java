package com.baidu.tieba.setting.im.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ SecretSettingActivity cLw;
    private final /* synthetic */ String cLz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SecretSettingActivity secretSettingActivity, String str) {
        this.cLw = secretSettingActivity;
        this.cLz = str;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        this.cLw.showProgressBar();
        switch (i) {
            case 0:
                this.cLw.ab(this.cLz, 1);
                break;
            case 1:
                this.cLw.ab(this.cLz, 2);
                break;
            case 2:
                this.cLw.ab(this.cLz, 3);
                break;
        }
        eVar = this.cLw.cLr;
        eVar.bO(i);
        if ("group".equals(this.cLz)) {
            this.cLw.cLq = i + 1;
        } else if ("post".equals(this.cLz)) {
            this.cLw.cLp = i + 1;
        } else if ("like".equals(this.cLz)) {
            this.cLw.cLo = i + 1;
        }
    }
}
