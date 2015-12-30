package com.baidu.tieba.setting.im.more;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AdapterView.OnItemClickListener {
    final /* synthetic */ SecretSettingActivity dsq;
    private final /* synthetic */ String dst;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SecretSettingActivity secretSettingActivity, String str) {
        this.dsq = secretSettingActivity;
        this.dst = str;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.core.dialog.e eVar;
        this.dsq.showProgressBar();
        switch (i) {
            case 0:
                this.dsq.ah(this.dst, 1);
                break;
            case 1:
                this.dsq.ah(this.dst, 2);
                break;
            case 2:
                this.dsq.ah(this.dst, 3);
                break;
        }
        eVar = this.dsq.dsm;
        eVar.bP(i);
        if ("group".equals(this.dst)) {
            this.dsq.dsl = i + 1;
        } else if ("post".equals(this.dst)) {
            this.dsq.dsk = i + 1;
        } else if ("like".equals(this.dst)) {
            this.dsq.dsj = i + 1;
        }
    }
}
