package com.baidu.tieba.pluginCenter;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ PluginDetailActivity eXp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PluginDetailActivity pluginDetailActivity) {
        this.eXp = pluginDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.eXp.closeActivity();
    }
}
