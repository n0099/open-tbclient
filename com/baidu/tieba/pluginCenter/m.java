package com.baidu.tieba.pluginCenter;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
/* loaded from: classes2.dex */
class m implements View.OnClickListener {
    final /* synthetic */ PluginDownloadActivity.a fnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PluginDownloadActivity.a aVar) {
        this.fnc = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        linearLayout = this.fnc.aTi;
        linearLayout.setVisibility(8);
        linearLayout2 = this.fnc.fmU;
        linearLayout2.setVisibility(0);
    }
}
