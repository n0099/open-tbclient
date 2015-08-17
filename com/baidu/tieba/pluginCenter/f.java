package com.baidu.tieba.pluginCenter;

import android.view.View;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ PluginDetailActivity coj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PluginDetailActivity pluginDetailActivity) {
        this.coj = pluginDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.coj.closeActivity();
    }
}
