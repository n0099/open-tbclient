package com.baidu.tieba.view;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.BaobaoSdkDelegate;
/* loaded from: classes.dex */
class a implements View.OnClickListener {
    final /* synthetic */ BaobaoTailView bQy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaobaoTailView baobaoTailView) {
        this.bQy = baobaoTailView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.data.b bVar;
        com.baidu.tieba.data.b bVar2;
        BaobaoSdkDelegate baobaoSdkDelegate;
        com.baidu.tieba.data.b bVar3;
        bVar = this.bQy.bQx;
        if (bVar != null) {
            bVar2 = this.bQy.bQx;
            if (bVar2.ys() != 1) {
                bVar3 = this.bQy.bQx;
                String yr = bVar3.yr();
                if (!com.baidu.adp.lib.util.l.aA(yr)) {
                    com.baidu.tbadk.browser.a.a(this.bQy.getContext(), yr, true);
                    return;
                }
                return;
            }
            try {
                Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_BAOBAO);
                if (pluginByName != null && (baobaoSdkDelegate = (BaobaoSdkDelegate) pluginByName.getClassInstance(BaobaoSdkDelegate.class)) != null) {
                    if (baobaoSdkDelegate.checkHasInstalled(this.bQy.getContext())) {
                        baobaoSdkDelegate.launchBaobao(this.bQy.getContext());
                    } else {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setData(Uri.parse(baobaoSdkDelegate.getJumpUrl()));
                        this.bQy.getContext().startActivity(intent);
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
