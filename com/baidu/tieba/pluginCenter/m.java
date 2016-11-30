package com.baidu.tieba.pluginCenter;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ PluginDownloadActivity.a fhf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PluginDownloadActivity.a aVar) {
        this.fhf = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        linearLayout = this.fhf.aPu;
        linearLayout.setVisibility(8);
        linearLayout2 = this.fhf.fgX;
        linearLayout2.setVisibility(0);
    }
}
