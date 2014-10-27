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
    final /* synthetic */ BaobaoTailView bQj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BaobaoTailView baobaoTailView) {
        this.bQj = baobaoTailView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.data.b bVar;
        com.baidu.tieba.data.b bVar2;
        BaobaoSdkDelegate baobaoSdkDelegate;
        com.baidu.tieba.data.b bVar3;
        bVar = this.bQj.bQi;
        if (bVar != null) {
            bVar2 = this.bQj.bQi;
            if (bVar2.yq() != 1) {
                bVar3 = this.bQj.bQi;
                String yp = bVar3.yp();
                if (!com.baidu.adp.lib.util.l.aA(yp)) {
                    com.baidu.tbadk.browser.a.a(this.bQj.getContext(), yp, true);
                    return;
                }
                return;
            }
            try {
                Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_BAOBAO);
                if (pluginByName != null && (baobaoSdkDelegate = (BaobaoSdkDelegate) pluginByName.getClassInstance(BaobaoSdkDelegate.class)) != null) {
                    if (baobaoSdkDelegate.checkHasInstalled(this.bQj.getContext())) {
                        baobaoSdkDelegate.launchBaobao(this.bQj.getContext());
                    } else {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setData(Uri.parse(baobaoSdkDelegate.getJumpUrl()));
                        this.bQj.getContext().startActivity(intent);
                    }
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
